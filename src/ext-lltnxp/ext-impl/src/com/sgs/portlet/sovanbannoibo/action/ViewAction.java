package com.sgs.portlet.sovanbannoibo.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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
import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.impl.SoLoaiVanBanNoiBoImpl;
import com.sgs.portlet.sovanbannoibo.model.impl.SoPhongVanBanNoiBoImpl;
import com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.sovanbannoibo.service.SoPhongVanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalServiceUtil;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoUtil;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoUtil;

public class ViewAction extends PortletAction {
	
	private static Log _log = LogFactory.getLog(ViewAction.class);
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/sovanbannoibo/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		if(cmd.equals(Constants.ADD)){
			addSoVanBanNoiBo(req, res, redirect);
		}else if(cmd.equals(Constants.EDIT)){
			editSoVanBanNoiBo(req);
		}else if(cmd.equals(Constants.UPDATE)){
			updateSoVanBanNoiBo(req, res, redirect);
		}else if(cmd.equals(Constants.DELETE)){
			deleteSoVanBanNoiBo(req);
		}else if(cmd.equals("CONFIGLOAIVANBANNOIBO")){
			configLoaiVanBanNoiBo(req);
		}else if(cmd.equals("CONFIGUPDATELOAIVANBANNOIBO")){
			configUpdateLoaiVanBanNoiBo(req);
		}else if(cmd.equals("CONFIGPHONGBAN")){
			configPhongBan(req);
		}else if(cmd.equals("CONFIGUPDATEPHONGBAN")){
			configUpdatePhongBan(req);
		}	
	}

	public void addSoVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) throws SystemException {
		try{
			String maSoVanBanNoiBo = ParamUtil.getString(req, "maSoVanBanNoiBo");
			String tenSoVanBanNoiBo = ParamUtil.getString(req, "tenSoVanBanNoiBo");
			List<SoVanBanNoiBo> soVanBanNoiBos = SoVanBanNoiBoLocalServiceUtil.getSoVanBanNoiBos(-1, -1);
			boolean check = false;
			for(SoVanBanNoiBo svbnb : soVanBanNoiBos){
				if(maSoVanBanNoiBo.equals(svbnb.getMaSoVanBanNoiBo())){
					check = true;
				}
			}
			if(!check){
				long soVanBanNoiBoId = CounterLocalServiceUtil.increment();
				SoVanBanNoiBo soVanBanNoiBo = SoVanBanNoiBoLocalServiceUtil.createSoVanBanNoiBo(soVanBanNoiBoId);
				Date date = new Date();
				Timestamp dateNow = new Timestamp(date.getTime());
				soVanBanNoiBo.setNgayTao(dateNow);
				soVanBanNoiBo.setMaSoVanBanNoiBo(maSoVanBanNoiBo);
				soVanBanNoiBo.setTenSoVanBanNoiBo(tenSoVanBanNoiBo);
				SoVanBanNoiBoLocalServiceUtil.addSoVanBanNoiBo(soVanBanNoiBo);
				sendRedirect(req, res, redirect);
			}else{
				req.setAttribute("maSoVanBanNoiBo", maSoVanBanNoiBo);
				req.setAttribute("tenSoVanBanNoiBo",tenSoVanBanNoiBo);
				req.setAttribute("errorAddSoVanBanNoiBo","errorAddSoVanBanNoiBo");
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD addSoVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void editSoVanBanNoiBo(ActionRequest req) {
		try{
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			SoVanBanNoiBo soVanBanNoiBo = SoVanBanNoiBoLocalServiceUtil.getSoVanBanNoiBo(soVanBanNoiBoId);
			req.setAttribute("soVanBanNoiBo", soVanBanNoiBo);
		}catch(Exception e){
			_log.error("ERROR IN METHOD editSoVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void updateSoVanBanNoiBo(ActionRequest req, ActionResponse res, String redirect) {
		try{
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			String maSoVanBanNoiBo = ParamUtil.getString(req, "maSoVanBanNoiBo");
			String tenSoVanBanNoiBo = ParamUtil.getString(req, "tenSoVanBanNoiBo");
			SoVanBanNoiBo soVanBanNoiBo = SoVanBanNoiBoLocalServiceUtil.getSoVanBanNoiBo(soVanBanNoiBoId);
			
			List<SoVanBanNoiBo> soVanBanNoiBos = SoVanBanNoiBoLocalServiceUtil.getSoVanBanNoiBos(-1, -1);
			boolean check = false;
			for(SoVanBanNoiBo svbnb : soVanBanNoiBos){
				if(maSoVanBanNoiBo.equals(svbnb.getMaSoVanBanNoiBo())){
					check = true;
				}
			}
			if(maSoVanBanNoiBo.equals(soVanBanNoiBo.getMaSoVanBanNoiBo())){
				check = false;
			}
			if(!check){
				soVanBanNoiBo.setMaSoVanBanNoiBo(maSoVanBanNoiBo);
				soVanBanNoiBo.setTenSoVanBanNoiBo(tenSoVanBanNoiBo);
				SoVanBanNoiBoLocalServiceUtil.updateSoVanBanNoiBo(soVanBanNoiBo);
				sendRedirect(req, res, redirect);
			}else{
				req.setAttribute("soVanBanNoiBo", soVanBanNoiBo);
				req.setAttribute("errorEditSoVanBanNoiBo","errorEditSoVanBanNoiBo");
			}
		}catch(Exception e){
			_log.error("ERROR IN METHOD updateSoVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void deleteSoVanBanNoiBo(ActionRequest req) {
		try{
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			SoVanBanNoiBoLocalServiceUtil.deleteSoVanBanNoiBo(soVanBanNoiBoId);
		}catch(Exception e){
		}
	}
	
	public void configLoaiVanBanNoiBo(ActionRequest req) {
		try{
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			req.setAttribute("soVanBanNoiBoId", soVanBanNoiBoId);
		}catch(Exception e){
			_log.error("ERROR IN METHOD configSoVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void configUpdateLoaiVanBanNoiBo(ActionRequest req) {
		try {
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			SoLoaiVanBanNoiBoUtil.removeBySoVanBanNoiBo(soVanBanNoiBoId);
			String addLoaiVanBanNoiBo = ParamUtil.getString(req, "addLoaiVanBanNoiBo");
			StringTokenizer st = new StringTokenizer(addLoaiVanBanNoiBo,",");
			SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = new SoLoaiVanBanNoiBoImpl();
			while(st.hasMoreTokens()){
				long loaiVanBanNoiBoId = Long.parseLong(st.nextToken());
				soLoaiVanBanNoiBo.setSoVanBanNoiBoId(soVanBanNoiBoId);
				soLoaiVanBanNoiBo.setLoaiVanBanNoiBoId(loaiVanBanNoiBoId);
				SoLoaiVanBanNoiBoLocalServiceUtil.addSoLoaiVanBanNoiBo(soLoaiVanBanNoiBo);
			}
			configLoaiVanBanNoiBo(req);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD configUpdateLoaiVanBanNoiBo OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void configPhongBan(ActionRequest req) {
		try{
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			req.setAttribute("soVanBanNoiBoId", soVanBanNoiBoId);
		}catch(Exception e){
			_log.error("ERROR IN METHOD configPhongBan OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void configUpdatePhongBan(ActionRequest req) {
		try {
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			SoPhongVanBanNoiBoUtil.removeBySoVanBanNoiBo(soVanBanNoiBoId);
			String addPhongBan = ParamUtil.getString(req, "addPhongBan");
			StringTokenizer st = new StringTokenizer(addPhongBan,",");
			SoPhongVanBanNoiBo soPhongVanBanNoiBo = new SoPhongVanBanNoiBoImpl();
			while(st.hasMoreTokens()){
				String phongVanBanNoiBoId = st.nextToken();
				soPhongVanBanNoiBo.setSoVanBanNoiBoId(soVanBanNoiBoId);
				soPhongVanBanNoiBo.setPhongVanBanNoiBoId(phongVanBanNoiBoId);
				SoPhongVanBanNoiBoLocalServiceUtil.addSoPhongVanBanNoiBo(soPhongVanBanNoiBo);
			}
			configPhongBan(req);
		} catch (Exception e) {
			_log.error("ERROR IN METHOD configUpdatePhongBan OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		try {
			long soVanBanNoiBoId = ParamUtil.getLong(req, "soVanBanNoiBoId");
			req.setAttribute("soVanBanNoiBoId", soVanBanNoiBoId);
		} catch (Exception e) {
		}
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.sovanbannoibo.view");
		}
	}
}
