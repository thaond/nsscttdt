/**
 * 
 */
package com.nss.portlet.documentfield.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlFieldSearchTerms  extends PmlFieldDisplayTerms{

	public PmlFieldSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
//		maPhanLoai = DAOParamUtil.getLike(renderRequest, MA_PHAN_LOAI);
		maPhanLoai = "%" + ParamUtil.getString(renderRequest, MA_PHAN_LOAI) + "%";
		tenPhanLoai = DAOParamUtil.getLike(renderRequest, TEN_PHAN_LOAI);
	}

}
