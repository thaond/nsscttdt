
package com.nss.portlet.digitalsignature.model.impl;

import com.liferay.portal.kernel.util.Base64;
import com.nss.portlet.digitalsignature.model.Signature;

public class SignatureImpl extends SignatureModelImpl implements Signature {

	public SignatureImpl() {

	}

	public byte[] getSignatureData() {

		return Base64.decode(getSignData().trim());
	}
}
