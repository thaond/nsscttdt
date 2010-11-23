package com.nss.portlet.thoitiet_tygia.util;


import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherResult extends DefaultHandler{
	final String ITEM = "Item";
	final String ADIMG = "AdImg";
	final String ADIMG1 = "AdImg1";
	final String ADIMG2 = "AdImg2";
	final String ADIMG3 = "AdImg3";
	final String ADIMG4 = "AdImg4";
	final String ADIMG5 = "AdImg5";
	final String WEATHER = "Weather";
	boolean isItem,isAdImg,isAdImg1,isAdImg2,isAdImg3,isAdImg4,isAdImg5,isWeather;
	ArrayList<Weather> listWeather = new ArrayList<Weather>();
	Weather current;
	public ArrayList<Weather> getListWeathers(){
		return this.listWeather;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals(ITEM)){
			isItem=true;
			current = new Weather();
		}
		else if (qName.equals(ADIMG)){
			isAdImg = true;
		}	
		else if (qName.equals(ADIMG1)){
			isAdImg1 = true;
		}
		else if (qName.equals(ADIMG2)){
			isAdImg2 = true;
		}
		else if (qName.equals(ADIMG3)){
			isAdImg3 = true;
		}
		else if (qName.equals(ADIMG4)){
			isAdImg4 = true;
		}
		else if (qName.equals(ADIMG5)){
			isAdImg5 = true;
		}
		else if (qName.equals(WEATHER)){
			isWeather = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals(ITEM)){
			listWeather.add(current);
			isItem = false;
		}
		else if (qName.equals(ADIMG)){
			isAdImg = false;
		}
		else if (qName.equals(ADIMG1)){
			isAdImg1 = false;
		}
		else if (qName.equals(ADIMG2)){
			isAdImg2 = false;
		}
		else if (qName.equals(ADIMG3)){
			isAdImg3 = false;
		}
		else if (qName.equals(ADIMG4)){
			isAdImg4 = false;
		}
		else if (qName.equals(ADIMG5)){
			isAdImg5 = false;
		}
		else if (qName.equals(WEATHER)){
			isWeather = false;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (isAdImg) {
			current.setAdImg(new String(ch, start, length));
		} else if (isAdImg1) {
			current.setAdImg1(new String(ch, start, length));
		}else if (isAdImg2) {
			current.setAdImg2(new String(ch, start, length));
		}else if (isAdImg3) {
			current.setAdImg3(new String(ch, start, length));
		}else if (isAdImg4) {
			current.setAdImg4(new String(ch, start, length));
		}else if (isAdImg5) {
			current.setAdImg5(new String(ch, start, length));
		}else if (isWeather) {
			current.setWeather(new String(ch, start, length));
		} 
	}
}
