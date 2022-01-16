package utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpClientUtil {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));

        HttpClientUtil httpClientUtil = new HttpClientUtil();

        String url = "http://www.baidu.com";
        httpClientUtil.doGetTestOne(url);
    }

    /**
     * 无参Get
     */
    @Test
    public void doGetTestOne(String url) {
        //获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建Get请求
        HttpGet httpGet = new HttpGet(url);
        //响应模型
        CloseableHttpResponse response = null;
        try {
            //由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            //从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应类型：" + responseEntity.getContentType());
                System.out.println("响应内容长度:" + responseEntity.getContentLength());
                System.out.println("响应内容:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}