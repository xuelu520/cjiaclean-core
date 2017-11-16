
package com.huazhu.hvip.util;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public class HttpClientTest {

	public static void main(String args[]) {

		try {

			HttpClient httpclient = new DefaultHttpClient();
                        //Secure Protocol implementation.
			SSLContext ctx = SSLContext.getInstance("SSL");
                        //Implementation of a trust manager for X509 certificates
			X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {

				}

				public void checkServerTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);

			ClientConnectionManager ccm = httpclient.getConnectionManager();
                        //register https protocol in httpclient's scheme registry
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));

			HttpGet httpget = new HttpGet("");
			HttpParams params = httpclient.getParams();

			params.setParameter("param1", "paramValue1");

			httpget.setParams(params);
			System.out.println("REQUEST:" + httpget.getURI());
			ResponseHandler responseHandler = new BasicResponseHandler();
			String responseBody;

			//responseBody = httpclient.execute(httpget, responseHandler);

			//System.out.println(responseBody);

			// Create a response handler

			/*
			 var httpClient = new HttpClient();
	            var data = new Dictionary<string, string>
	            {
	                 { "grant_type", "client_credentials" }, 
	                { "scope", "/OAuth/Token" }, 
	                { "client_id", "5EB2D1649AEA47CFADC8053C4AF9B236" }, 
	                { "client_secret", "D6B42A16E62441D59836E6BE7BCC42A0" }
	            };

	            var httpContent = new FormUrlEncodedContent(data);
	            var response = httpClient.PostAsync("http://10.1.249.63:7878/OAuth/Token", httpContent).Result.Content;
*/
	            
		
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}


