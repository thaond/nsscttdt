package com.sgs.portlet.sovanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PhongBanSearchTerms extends PhongBanDisplayTerms{

	public PhongBanSearchTerms(RenderRequest request) {
		super(request);
		departmentsCode = DAOParamUtil.getLike(request, DEPARTMENTSCODE);
		departmentsName = DAOParamUtil.getLike(request, DEPARTMENTNAMES);
		abbreviateName = DAOParamUtil.getLike(request, ABBREVIATENAME);
	}
}
