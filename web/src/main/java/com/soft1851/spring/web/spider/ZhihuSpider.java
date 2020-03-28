package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Zhihu;
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
 * @date 2020/3/28
 * @deprecated 知乎圆桌数据爬取
 */
public class ZhihuSpider {
    private static  final  Integer SUCCESS=200;
    public static List<Zhihu> getZhihu() {
        List<Zhihu> zhihus = new ArrayList<>();
        //目标地址
        String url = "https://www.zhihu.com/api/v4/roundtables?limit=10&offset=20";
        //创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建get请求
        HttpGet get = new HttpGet(url);
        //创建context请求
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
                System.out.println(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONArray("data");
            list.forEach(o -> {
                JSONObject json=JSONObject.parseObject(o.toString());
                Zhihu zhihu = Zhihu.builder()
                        .visitsCount(json.getInteger("visits_count"))
                        .titleName(json.getString("name"))
                        .logo(json.getString("logo")).build();
                zhihus.add(zhihu);
                System.out.println(zhihu);
            });
        }else {
            System.out.println("请求失败");

        }try{
            response.close();
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zhihus;
    }

    public static void main(String[] args) {
        getZhihu();
    }
}
