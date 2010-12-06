
package com.nss.portlet.digitalsignature.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.nss.portlet.digitalsignature.model.Signature;
import com.nss.portlet.digitalsignature.service.base.SignatureLocalServiceBaseImpl;

public class SignatureLocalServiceImpl extends SignatureLocalServiceBaseImpl {

	public Signature addSignature(
		long groupId, long companyId, long userId, long articlePrimKey,
		String articleId, String signData)
		throws SystemException {

		Signature signature;
		try {
			signature =
				signaturePersistence.findByAPK_U(articlePrimKey, userId);
		}
		catch (Exception e) {
			signature =
				signaturePersistence.create(CounterLocalServiceUtil.increment(Signature.class.getName()));
		}
		signature.setGroupId(groupId);
		signature.setCompanyId(companyId);
		signature.setUserId(userId);
		signature.setArticlePrimKey(articlePrimKey);
		signature.setArticleId(articleId);
		signature.setCreateDate(new Date());
		signature.setSignData(signData);

		return signaturePersistence.update(signature, false);
	}

	public List<Signature> findByArticleId(String articleId)
		throws SystemException {

		return signaturePersistence.findByArticleId(articleId);
	}

	public List<Signature> findByArticlePrimKey(long articlePrimKey)
		throws SystemException {

		return signaturePersistence.findByArticlePrimKey(articlePrimKey);
	}

	public Signature getSignature(long articlePrimKey, long userId)
		throws SystemException {

		return signaturePersistence.fetchByAPK_U(articlePrimKey, userId);
	}
}
