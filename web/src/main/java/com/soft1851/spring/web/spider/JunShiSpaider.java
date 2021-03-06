package com.soft1851.spring.web.spider;

import com.soft1851.spring.web.entity.Subject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyj
 * @date 2020/3/28
 * @deprecated 云班课首页数据爬取
 * 解析HTML的方法
 */
public class JunShiSpaider {
    private static final Integer SUCCESS = 200;
    public static List<Subject> getJunShi(){
        List<Subject> subjects = new ArrayList<>();
        //目标地址
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String url = "https://www.zhihu.com/special/all";
        //创建response对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //创建get请求
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", userAgent);
            //创建context请求
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpGet, context);
            int statusCode = response.getStatusLine().getStatusCode();
            //看是否能够请求到页面200 OK
            System.out.println(response.getStatusLine().getStatusCode());
            if(statusCode==SUCCESS){
                HttpEntity entity=response.getEntity();
                if(entity!=null){
                    String res= EntityUtils.toString(entity);
                    System.out.println(res);
                    Document document= Jsoup.parse(res);
                    Elements elements=document.getElementsByClass("news-stream-newsStream-news-item-has-image clearfix news_item");
                    //查看总长度
                    System.out.println("*********"+elements.size());
                    for(Element element:elements){
                        //取得第二个div
                        Element two = element.child(1);
                        Element info = two.child(0).child(0).child(1);
                        //图片
                        Element img = element.child(0).child(0);
                        String imgPicture = img.attr("src");
                        //主题
                        String  title = two.select("SpecialListCard-title").text();
                        //取出时间
                        String time = info.child(0).text();
                        //取出次数
                        String count = info.child(1).text();
                        //取出内容
                        String content = two.child(1).text();
                        Subject subject = Subject.builder()
                                .img(imgPicture)
                                .title(title)
                                .time(time)
                                .count(count)
                                .content(content).build();
                        subjects.add(subject);
                        System.out.println(subject);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subjects;
    }
    public static void main(String[] args) {
        getJunShi();
    }
}
