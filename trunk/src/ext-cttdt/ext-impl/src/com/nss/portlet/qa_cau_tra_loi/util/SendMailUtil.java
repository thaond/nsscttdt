package com.nss.portlet.qa_cau_tra_loi.util;

import java.io.File;

import javax.mail.internet.InternetAddress;

import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

public class SendMailUtil {
	public static void sendMail(InternetAddress toEmail, String subject, String content, 
			boolean htmlFormat, File attachedFiles) throws MailEngineException {

		File[] fileAttach = null;
		if (attachedFiles.exists()) {
			fileAttach = new File[] { attachedFiles }; 
		}
		
		MailEngine.send(new InternetAddress(), new InternetAddress[] { toEmail }, null,
				null, null, subject, content, htmlFormat, new InternetAddress[] {}, "", "", fileAttach);
	}
}
