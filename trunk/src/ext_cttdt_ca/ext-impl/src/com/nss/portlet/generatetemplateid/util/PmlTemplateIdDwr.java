package com.nss.portlet.generatetemplateid.util;

public class PmlTemplateIdDwr {
	public boolean checkOnlyContainText(String textTemplate) {
		boolean result = false;
		char temp = '[';
		for (int i = 0; i < textTemplate.length(); i++) {
			if ( textTemplate.charAt(i) == temp) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
		return result;
	}
}
