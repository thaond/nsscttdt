/**
 * 
 */
package com.sgs.portlet.documentdelegate.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author WIN7
 *u
 */
public class PmlDocumentDelegateDisplayTerms extends DisplayTerms{
	public static final String USER_DELEGATE = "userDelegate";
	public static final String LIST_USER_IS_DELEGATE = "listUserIsDelegate";
	public static final String FROM_DATE_DELEGATE = "fromDateDelegate";
	public static final String TO_DATE_DELEGATE = "toDateDelegate";
	public static final String CHECK_ALL_USER = "checkAllUser";
	
	protected long userDelegate;
	protected String listUserIsDelegate;
	protected String fromDateDelegate;
	protected String toDateDelegate;
	protected boolean checkAllUser;
	
	public PmlDocumentDelegateDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		
		userDelegate = ParamUtil.getLong(renderRequest, USER_DELEGATE);
		listUserIsDelegate = ParamUtil.getString(renderRequest, LIST_USER_IS_DELEGATE);
		fromDateDelegate = ParamUtil.getString(renderRequest, FROM_DATE_DELEGATE);
		toDateDelegate = ParamUtil.getString(renderRequest, TO_DATE_DELEGATE);
		checkAllUser = ParamUtil.getBoolean(renderRequest, CHECK_ALL_USER);
	}

	public long getUserDelegate() {
		return userDelegate;
	}

	public void setUserDelegate(long userDelegate) {
		this.userDelegate = userDelegate;
	}

	public String getListUserIsDelegate() {
		return listUserIsDelegate;
	}

	public void setListUserIsDelegate(String listUserIsDelegate) {
		this.listUserIsDelegate = listUserIsDelegate;
	}

	public String getFromDateDelegate() {
		return fromDateDelegate;
	}

	public void setFromDateDelegate(String fromDateDelegate) {
		this.fromDateDelegate = fromDateDelegate;
	}

	public String getToDateDelegate() {
		return toDateDelegate;
	}

	public void setToDateDelegate(String toDateDelegate) {
		this.toDateDelegate = toDateDelegate;
	}

	public boolean isCheckAllUser() {
		return checkAllUser;
	}

	public void setCheckAllUser(boolean checkAllUser) {
		this.checkAllUser = checkAllUser;
	}

}
