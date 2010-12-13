package com.nss.portlet.thoitiet_tygia.util;


import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class WeatherUtil {
	
	static ArrayList<Weather> result = new ArrayList<Weather>();
	
	/**
	 * @author 
	 * @param url
	 * @return 
	 */
	public static ArrayList<Weather> getWeather(String url) { 
		DefaultHttpClient client = new DefaultHttpClient(); 
		HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);            
		HttpResponse response; 
		HttpEntity entity;
		try { 
			HttpGet get = new HttpGet(url); 	                    
			response = client.execute(get); 
			entity = response.getEntity(); 
			InputStream is = entity.getContent(); 
			read(is); 
			is.close(); 
			if (entity != null) entity.consumeContent(); 
		} catch (Exception e) { 
			return null;
		}  
		return result;
	}
	
	private static void read(InputStream in) { 
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp; 
		try { 
			sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader(); 
			WeatherResult rh = new WeatherResult(); 
			xr.setContentHandler(rh); 
			xr.parse(new InputSource(in)); 
			result=rh.getListWeathers();
		} catch (ParserConfigurationException e) { 
			System.out.println("ERROR: in read of class "+WeatherUtil.class + " "+e.getMessage());
		} catch (SAXException e) { 
			System.out.println("ERROR: in read of class "+WeatherUtil.class + " "+e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: in read of class "+WeatherUtil.class + " "+e.getMessage());
		}
	}
}
