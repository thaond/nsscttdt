/**
 * 
 */
package com.sgs.portlet.documentdelegate.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author WIN7
 *
 */
public class PmlDocumentDelegateSearchTerms extends PmlDocumentDelegateDisplayTerms{

	/**
	 * @param renderRequest
	 */
	public PmlDocumentDelegateSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		userDelegate = DAOParamUtil.getLong(renderRequest, USER_DELEGATE);
		listUserIsDelegate = DAOParamUtil.getString(renderRequest, LIST_USER_IS_DELEGATE);
		fromDateDelegate = DAOParamUtil.getString(renderRequest, FROM_DATE_DELEGATE);
		toDateDelegate = DAOParamUtil.getString(renderRequest, TO_DATE_DELEGATE);
		checkAllUser = ParamUtil.getBoolean(renderRequest, CHECK_ALL_USER);
	}
}
