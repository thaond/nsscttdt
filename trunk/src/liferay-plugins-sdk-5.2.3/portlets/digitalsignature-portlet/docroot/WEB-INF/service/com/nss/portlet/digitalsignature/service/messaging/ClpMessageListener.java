/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nss.portlet.digitalsignature.service.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import com.nss.portlet.digitalsignature.service.ArticleDigestLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.ArticleDigestServiceUtil;
import com.nss.portlet.digitalsignature.service.CertificateLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.CertificateServiceUtil;
import com.nss.portlet.digitalsignature.service.ClpSerializer;
import com.nss.portlet.digitalsignature.service.DigitalSignatureLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.DigitalSignatureServiceUtil;
import com.nss.portlet.digitalsignature.service.SignatureLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.SignatureServiceUtil;

/**
 * <a href="ClpMessageListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpMessageListener implements MessageListener {
	public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(SERVLET_CONTEXT_NAME)) {
			ArticleDigestLocalServiceUtil.clearService();

			ArticleDigestServiceUtil.clearService();
			DigitalSignatureLocalServiceUtil.clearService();

			DigitalSignatureServiceUtil.clearService();
			SignatureLocalServiceUtil.clearService();

			SignatureServiceUtil.clearService();
			CertificateLocalServiceUtil.clearService();

			CertificateServiceUtil.clearService();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);
}