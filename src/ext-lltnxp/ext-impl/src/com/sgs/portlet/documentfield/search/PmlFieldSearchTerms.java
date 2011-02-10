/**
 * 
 */
package com.sgs.portlet.documentfield.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlFieldSearchTerms  extends PmlFieldDisplayTerms{

	public PmlFieldSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		//YENLT UPDATE 12/03/2010
//		maPhanLoai = ParamUtil.getString(renderRequest, MA_PHAN_LOAI);
//		tenPhanLoai = ParamUtil.getString(renderRequest, TEN_PHAN_LOAI);
		maPhanLoai = DAOParamUtil.getLike(renderRequest, MA_PHAN_LOAI);
		tenPhanLoai = DAOParamUtil.getLike(renderRequest, TEN_PHAN_LOAI);
	}

}
