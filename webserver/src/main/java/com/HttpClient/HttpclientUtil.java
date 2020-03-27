package com.HttpClient;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class HttpclientUtil {
    /**
     * 根据URL试用get方法取得返回的数据
     * @param url
     *        URL地址，参数直接挂在URL后面即可
     * @return
     */
    public static String getGetDateByUrl(String url){

        String data = null;
        //构造HttpClient的实例
        HttpClient httpClient = new HttpClient();
        //创建GET方法的实例
        GetMethod getMethod = new GetMethod(url);
        //设置头信息：如果不设置User-Agent可能会报405，导致取不到数据
        getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:39.0) Gecko/20100101 Firefox/39.0");
        //使用系统提供的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try{
            //开始执行getMethod
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed:" + getMethod.getStatusLine());
            }
            //读取内容
            byte[] responseBody = getMethod.getResponseBody();
            //处理内容
            data = new String(responseBody);
        }catch (HttpException e){
            //发生异常，可能是协议不对或者返回的内容有问题
            System.out.println("Please check your provided http address!");
            data = "";
            e.printStackTrace();
        }catch(IOException e){
            //发生网络异常
            data = "";
            e.printStackTrace();
        }finally{
            //释放连接
            getMethod.releaseConnection();
        }
        return data;
    }

    /**
     * 根据post方法取得返回数据
     * @param url
     *          URL地址
     * @param array
     *          需要以post形式提交的参数
     * @return
     */
    public static String getPostDateByUrl(String url, Map<String ,String> array){
        String data = null;
        //构造HttpClient的实例
        HttpClient httpClient = new HttpClient();
        //创建post方法的实例
        PostMethod postMethod = new PostMethod(url);
        //设置头信息
        postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:39.0) Gecko/20100101 Firefox/39.0");
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //遍历设置要提交的参数
        if(array!=null){
            Iterator it = array.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String,String> entry =(Map.Entry) it.next();
                String key = entry.getKey();
                String value = entry.getValue().trim();
                postMethod.setParameter(key,value);
            }
        }

        //使用系统提供的默认的恢复策略
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try{
            //执行postMethod
            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed:" + postMethod.getStatusLine());
            }
            //读取内容
            byte[] responseBody = postMethod.getResponseBody();
            //处理内容
            data = new String(responseBody);
        }catch (HttpException e){
            //发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("Please check your provided http address!");
            data = "";
            e.printStackTrace();
        }catch(IOException e){
            //发生网络异常
            data = "";
            e.printStackTrace();
        }finally{
            //释放连接
            postMethod.releaseConnection();
        }
        System.out.println(data);
        return data;
    }
}
