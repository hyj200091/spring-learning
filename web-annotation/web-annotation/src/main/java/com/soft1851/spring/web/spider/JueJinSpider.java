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
 * @Author: zw_w
 * @Date: 2020/3/27 15:00
 * @Description:
 */
public class JueJinSpider {
    private static  final  Integer SUCCESS=200;
    public static List<Topic> getTopics(){
        List<Topic> topics=new ArrayList<>();
        //目标地址
        String url="https://short-msg-ms.juejin.im/v1/topicList?uid=5c066a5a518825697324148f&device_id=1585287134702&token=eyJhY2Nlc3NfdG9rZW4iOiI0NTE3QXk1eE92RFlxN0t6IiwicmVmcmVzaF90b2tlbiI6IjJiQjBZb0xJZXNMRGtsRkQiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建get请求
        HttpGet get=new HttpGet(url);
        //创建context请求
        HttpClientContext context=HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response=null;
        try{
            response=httpclient.execute(get,context);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.getStatusLine().getStatusCode()==SUCCESS){
            HttpEntity entity=response.getEntity();
            String res=null;
            try {
                res= EntityUtils.toString(entity,"UTF-8");

                System.out.println(res);


            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject=JSONObject.parseObject(res);
            JSONArray list=jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o -> {
                JSONObject json=JSONObject.parseObject(o.toString());
                Topic topic=
                        Topic.builder().id(json.getString("objectId"))
                                .topicName(json.getString("title"))
                                .topicIcon(json.getString("description"))
                                .description(json.getString("icon"))
                                .msgCount(json.getInteger("msgsCount"))
                                .followersCount(json.getInteger("followersCount"))
                                .followed(json.getBoolean("followed")).build();
                topics.add(topic);
                System.out.println(topic);
            });
        }else {
            System.out.println("请求失败");

        }try{
            response.close();
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  topics;
    }

    public static void main(String[] args) {
        getTopics();
    }
}
