package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyj
 * @deprecated  使用HttpClient和Jsoup实现的爬虫，爬取掘金的Topic页面
 * @data 2020/3/28
 */
public class JueJinSpider {
    private static  final  Integer SUCCESS=200;
    public static List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5c066a5a518825697324148f&device_id=1585287134702&token=eyJhY2Nlc3NfdG9rZW4iOiI0NTE3QXk1eE92RFlxN0t6IiwicmVmcmVzaF90b2tlbiI6IjJiQjBZb0xJZXNMRGtsRkQiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(response.getStatusLine());
        //如果请求成功 侧获取网页源码
        if(response.getStatusLine().getStatusCode()==SUCCESS){
           //获取响应实体 并转成UTF-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //得到一组json数据
//            System.out.println(res);

            //解析json数据  res 是整个大的json对象 就是全部的json数据
            //字符串rs 转换成json对象
            JSONObject jsonObject = JSONObject.parseObject(res);
            //jsonObject.getJSONObject("d") 拿到d还是一个json对象 所以可以继续get 因为list拿到的是一个数据所以用JSONArray
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            //用foreach 便利数组list
            list.forEach(o -> {
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed")).build();
                topics.add(topic);
            });
        }else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topics;
    }
    public static void main(String[] args) {
        System.out.println(getTopics());

    }
}


