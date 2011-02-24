package org.anses.director.webservices.cliente;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jboss.internal.soa.esb.util.StreamUtils;

public class ClienteHola {
	
//	static String url = "http://localhost:8080/DecirHola/DecirHola";
	static String url = "http://localhost:7777/";
	static String soapFile = "soap-request-hola.xml";

	public static void main(String[] args) throws Exception {

		PostMethod method = new PostMethod(url);
		String request = StreamUtils.getResourceAsString(soapFile, "UTF-8");
		method.setRequestHeader("Content-Type", "text/xml;charset=UTF-8");
		method.setRequestHeader("SOAPAction", "\"\"");
		method.setRequestEntity( new StringRequestEntity(request) );
		
		System.out.println("****  REQUEST  URL: " + url);		
		System.out.println("****  REQUEST BODY: " + request);
		
		
		HttpClient client = new HttpClient();
		InputStream response = null;
		try
		{
			System.out.println(System.currentTimeMillis());
			int code = client.executeMethod(method);
//			System.out.println("**** RESPONSE CODE: " + code);
			
			response = method.getResponseBodyAsStream();
			byte[] bytes = StreamUtils.readStream(response);
			System.out.println("**** RESPONSE BODY: " + new String(bytes, method.getResponseCharSet()));
			System.out.println(System.currentTimeMillis());
		}
		finally
		{
			method.releaseConnection();
			if (response != null)
			{
				response.close();
			}
		}
	}
}
