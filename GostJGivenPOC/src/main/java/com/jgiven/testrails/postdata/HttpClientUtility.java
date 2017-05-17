package com.jgiven.testrails.postdata;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpClientUtility {
	
	private static String hostaddress = "localhost";

	public static String executeGet(String Url)throws Exception{
		URL url= new URL(Url);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		Url=uri.toASCIIString();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpclient = HttpClients.custom()
				.setConnectionManager(cm)
				.setRedirectStrategy(new LaxRedirectStrategy())
				.build();
		HttpContext context = new BasicHttpContext();
		HttpGet httpget = new HttpGet(Url);
		httpget.addHeader("Content-Type","application/json");
		httpget.addHeader("Authorization","Basic "+getAuthDetails());		
		HttpResponse response = httpclient.execute(httpget, context);
		HttpEntity entity = response.getEntity();
		String responsetext = IOUtils.toString(entity.getContent(), "UTF-8");
		httpclient.close();
		return responsetext;

	}
	public static String ExecutePost(String Url,String rawData)throws Exception{
		URL url= new URL(Url);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		Url=uri.toASCIIString();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(100);		
		CloseableHttpClient httpclient = HttpClients.custom()
				.setConnectionManager(cm)
				.setRedirectStrategy(new LaxRedirectStrategy())
				.build();
		HttpContext context = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(Url);
		httpPost.setEntity(new StringEntity(rawData));			
		httpPost.addHeader("Content-Type","application/json");		
		httpPost.addHeader("Authorization","Basic "+getAuthDetails());
		//httpPost.addHeader( BasicScheme.authenticate(getCredentials(),"US-ASCII",false) );
		HttpResponse response = httpclient.execute(httpPost, context);
		HttpEntity entity = response.getEntity();
		String responseText =IOUtils.toString(entity.getContent(), "UTF-8");
		httpclient.close();
		return responseText;
	}
	
	public static  String getAuthDetails()throws Exception{
		return new String(Base64.encodeBase64(("karthikvundavalli@gmail.com:Value*12").getBytes("UTF-8")));
	}
	

	


}
