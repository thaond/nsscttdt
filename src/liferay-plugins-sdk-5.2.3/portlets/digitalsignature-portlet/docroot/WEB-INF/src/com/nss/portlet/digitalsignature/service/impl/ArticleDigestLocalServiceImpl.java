
package com.nss.portlet.digitalsignature.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.nss.portal.util.NSSHtmlUtil;
import com.nss.portlet.digitalsignature.service.base.ArticleDigestLocalServiceBaseImpl;

public class ArticleDigestLocalServiceImpl
	extends ArticleDigestLocalServiceBaseImpl {

	public byte[] digest(JournalArticle article)
		throws PortalException, SystemException {

		return digest(article, "SHA-1", "BC");
	}

	public byte[] digest(
		JournalArticle article, String algorithm, String provider)
		throws PortalException, SystemException {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm, provider);
			md.update(String.valueOf(article.getGroupId()).getBytes("UTF-8"));
			md.update(String.valueOf(article.getCompanyId()).getBytes("UTF-8"));
			md.update(String.valueOf(article.getUserId()).getBytes("UTF-8"));
			md.update(String.valueOf(article.getVersion()).getBytes("UTF-8"));
			md.update(df.format(article.getCreateDate()).getBytes("UTF-8"));
			md.update(article.getTitle().getBytes("UTF-8"));
			md.update(article.getUrlTitle().getBytes("UTF-8"));
			md.update(article.getDescription().getBytes("UTF-8"));

			String content = article.getContent();

			if (article.getApproved()) {
				md.update(String.valueOf(article.getApprovedByUserId()).getBytes(
					"UTF-8"));
				md.update(df.format(article.getApprovedDate()).getBytes("UTF-8"));
			}

			if (article.getSmallImageId() > 0) {
				Image image =
					ImageLocalServiceUtil.getImage(article.getSmallImageId());
				if (image != null) {
					md.update(image.getTextObj());
				}
			}

			Document document = SAXReaderUtil.read(content);

			String htmlContent =
				document.getRootElement().element("static-content").getText();

			md.update(htmlContent.getBytes("UTF-8"));

			List<String> imageURLs =
				NSSHtmlUtil.getAllImageLinks(htmlContent, null);

			URL url;
			InputStream in;
			String host =
				"http://" + PortalUtil.getCDNHost() + ":" +
					PortalUtil.getPortalPort();

			for (String urlStr : imageURLs) {
				if (!urlStr.contains("://")) {
					urlStr = host + urlStr;
				}
				url = new URL(urlStr);
				in = url.openStream();
				Image image = ImageLocalServiceUtil.getImage(in);
				md.update(image.getTextObj());
			}

			// List<Signature> signatures =
			// SignatureLocalServiceUtil.findByArticlePrimKey(article.getId());
			// for (Signature signature : signatures) {
			// md.update(signature.getSignatureData());
			// }

			return md.digest();
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public byte[] digest(long articleId)
		throws PortalException, SystemException {

		return digest(articleId, "SHA-1", "BC");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.nss.portlet.digitalsignature.service.ArticleDigestLocalService#digest
	 *      (long, java.lang.String, java.lang.String)
	 */
	@Override
	public byte[] digest(long articleId, String algorithm, String provider)
		throws PortalException, SystemException {

		JournalArticle article =
			JournalArticleLocalServiceUtil.getArticle(articleId);
		return digest(article, algorithm, provider);
	}
}
