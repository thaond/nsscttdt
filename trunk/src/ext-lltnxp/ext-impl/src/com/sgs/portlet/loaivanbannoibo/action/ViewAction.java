package com.sgs.portlet.loaivanbannoibo.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/loaivanbannoibo/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if(cmd.equals(Constants.ADD)){
			addLoaiVanBanNoiBo(req, res, redirect);
		}else if(cmd.equals(Constants.EDIT)){
			editLoaiVanBanNoiBo(req);
		}else if(cmd.equals(Constants.UPDATE)){
			updateLoaiVanBanNoiBo(req, res, redirect);
		}else if(cmd.equals(Constants.DELETE)){
			deleteLoaiVanBanNoiBo(req);
		}	
	}

	public void addLoaiVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) throws SystemException {
		try{
			String kyHieuLoaiVanBanNoiBo = ParamUtil.getString(req, "kyHieuLoaiVanBanNoiBo");
			String tenLoaiVanBanNoiBo = ParamUtil.getString(req, "tenLoaiVanBanNoiBo");
			List<LoaiVanBanNoiBo> loaiVanBanNoiBos = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBos(-1, -1);
			boolean check = false;
			for(LoaiVanBanNoiBo lvbnb : loaiVanBanNoiBos){
				if(lvbnb.getKyHieuLoaiVanBanNoiBo().equals(kyHieuLoaiVanBanNoiBo)){
					check = true;
				}
			}
			if(!check){
				long loaiVanBanNoiBoId = CounterLocalServiceUtil.increment();
				LoaiVanBanNoiBo loaiVanBanNoiBo = LoaiVanBanNoiBoLocalServiceUtil.createLoaiVanBanNoiBo(loaiVanBanNoiBoId);
				loaiVanBanNoiBo.setKyHieuLoaiVanBanNoiBo(kyHieuLoaiVanBanNoiBo);
				loaiVanBanNoiBo.setTenLoaiVanBanNoiBo(tenLoaiVanBanNoiBo);
				LoaiVanBanNoiBoLocalServiceUtil.addLoaiVanBanNoiBo(loaiVanBanNoiBo);
				sendRedirect(req, res, redirect);
			}else{
				req.setAttribute("kyHieuLoaiVanBanNoiBo", kyHieuLoaiVanBanNoiBo);
				req.setAttribute("tenLoaiVanBanNoiBo",tenLoaiVanBanNoiBo);
				req.setAttribute("errorAddLoaiVanBanNoiBo","errorAddLoaiVanBanNoiBo");
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD addLoaiVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void editLoaiVanBanNoiBo(ActionRequest req) {
		try{
			long loaiVanBanNoiBoId = ParamUtil.getLong(req, "loaiVanBanNoiBoId");
			LoaiVanBanNoiBo loaiVanBanNoiBo = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBo(loaiVanBanNoiBoId);
			req.setAttribute("loaiVanBanNoiBo", loaiVanBanNoiBo);
		}catch(Exception e){
			_log.error("ERROR IN METHOD editLoaiVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void updateLoaiVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) {
		try{
			long loaiVanBanNoiBoId = ParamUtil.getLong(req, "loaiVanBanNoiBoId");
			String kyHieuLoaiVanBanNoiBo = ParamUtil.getString(req, "kyHieuLoaiVanBanNoiBo");
			String tenLoaiVanBanNoiBo = ParamUtil.getString(req, "tenLoaiVanBanNoiBo");
			
			LoaiVanBanNoiBo loaiVanBanNoiBo = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBo(loaiVanBanNoiBoId);
			List<LoaiVanBanNoiBo> loaiVanBanNoiBos = LoaiVanBanNoiBoLocalServiceUtil.getLoaiVanBanNoiBos(-1, -1);
			boolean check = false;
			for(LoaiVanBanNoiBo lvbnb : loaiVanBanNoiBos){
				if(lvbnb.getKyHieuLoaiVanBanNoiBo().equals(kyHieuLoaiVanBanNoiBo)){
					check = true;
				}
			}
			if(kyHieuLoaiVanBanNoiBo.equals(loaiVanBanNoiBo.getKyHieuLoaiVanBanNoiBo())){
				check = false;
			}
			if(!check){
				loaiVanBanNoiBo.setKyHieuLoaiVanBanNoiBo(kyHieuLoaiVanBanNoiBo);
				loaiVanBanNoiBo.setTenLoaiVanBanNoiBo(tenLoaiVanBanNoiBo);
				LoaiVanBanNoiBoLocalServiceUtil.updateLoaiVanBanNoiBo(loaiVanBanNoiBo);
				sendRedirect(req, res, redirect);
			}else{
				req.setAttribute("loaiVanBanNoiBo", loaiVanBanNoiBo);
				req.setAttribute("errorEditLoaiVanBanNoiBo","errorEditLoaiVanBanNoiBo");
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD updateLoaiVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void deleteLoaiVanBanNoiBo(ActionRequest req) {
		try{
			long loaiVanBanNoiBoId = ParamUtil.getLong(req, "loaiVanBanNoiBoId");
			LoaiVanBanNoiBoLocalServiceUtil.deleteLoaiVanBanNoiBo(loaiVanBanNoiBoId);
		}catch(Exception e){
			_log.error("ERROR IN METHOD deleteLoaiVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}


	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.loaivanbannoibo.view");
		}
	}
}
