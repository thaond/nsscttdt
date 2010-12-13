/**
 * 
 */
package com.nss.portlet.department.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author minhnv
 *
 */
public class PmlDepartmentSearchTerms extends PmlDepartmentDisplayTerms{

	
	public PmlDepartmentSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		maPhong = DAOParamUtil.getLike(renderRequest, MA_PHONG);
		tenPhong = DAOParamUtil.getLike(renderRequest, TEN_PHONG);
		tenVietTat = DAOParamUtil.getLike(renderRequest, TEN_VIET_TAT);
	}

}
