package com.winit.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.fastjson.JSON;


public class HttpClientUtil {


	/**
	 * 底层接口方法(只需要前面组织参数)(传个map过来进行了)charset 编码 默认为Utf-8
	 * @throws Exception 
	 */
	public static String  post(String url,Map<String,String> map,String charset){  
		//如果它为空,则默认为它是UTF-8
		if(StringUtils.isEmpty(charset)){
			charset="UTF-8";
		}
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost httppost = new HttpPost(url);  
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>(); 
        if(map!=null){
        for(Map.Entry e:map.entrySet()){
        	//如果键为空或者值为空则不让它传
        	if((e.getKey()!=null) || (e.getValue()!=null)){
        		if(StringUtils.isNotEmpty(e.getValue().toString())){
        	     paramlist.add(new BasicNameValuePair(e.getKey().toString(),e.getValue().toString()));
        		}
        	}
        }
        }
        UrlEncodedFormEntity uefEntity;  
		try {
			uefEntity = new UrlEncodedFormEntity(paramlist, charset);
			httppost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			if(response!=null){
			HttpEntity entity = response.getEntity();
			try {
				if (entity != null) {
					return EntityUtils.toString(entity, charset);

				}
			} finally {
				response.close();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				//throw e1;
			}

		}
        return null;
    }  
	
	
	
	/**
	 * 底层接口方法(只需要前面组织参数)(传个map过来进行了)charset 编码 默认为Utf-8
	 * @throws Exception 
	 */
	public static String  postJson(String url,Map<String,String> map,String charset){  
		//如果它为空,则默认为它是UTF-8
		if(StringUtils.isEmpty(charset)){
			charset="UTF-8";
		}
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json");
        
        String paramlist = JSON.toJSONString(map);
        StringEntity  uefEntity;  
		try {
			uefEntity = new StringEntity (paramlist, charset);
			httppost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			if(response!=null){
				HttpEntity entity = response.getEntity();
				try {
					if (entity != null) {
						return EntityUtils.toString(entity, charset);
					}
				} finally {
					response.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				//throw e1;
			}

		}
        return null;
    }  
	
}
