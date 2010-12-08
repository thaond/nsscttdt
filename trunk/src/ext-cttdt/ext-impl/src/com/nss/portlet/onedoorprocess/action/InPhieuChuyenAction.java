package com.nss.portlet.onedoorprocess.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;
import com.nss.portlet.onedoor.ajax.OnedoorDwr;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoorprocess.util.PhieuChuyenUtil;

/**
 * 
 * @author yenlt
 *
 */
public class InPhieuChuyenAction extends PortletAction {
	private static Log _log = LogFactory.getLog(InPhieuChuyenAction.class);
	@Override
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
		inPhieuChuyen(req, res);
	}

	@Override
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {

		return mapping.findForward("portlet.nss.onedoorprocess.onedoorphieuchuyen");
	}
	
	private void inPhieuChuyen(PortletRequest req, PortletResponse res) {
		String fileId = ParamUtil.getString(req, com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String applicantTime = ParamUtil.getString(req, "applicantTimeAfter");
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);		
		String realPath = request.getSession().getServletContext().getRealPath("reports");
		
		String day = "";
		String month = "";
		String year = "";
		String receiptNumber = "";
		String hour = "";
		String minutes = "";
		String address = "";
		String represent = "";
		int processTime = 0;
		String departmentReceive = "";
		String ngayNhan = "";
		PmlOneDoorReceiveFile file = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		} catch (Exception e) {
			_log.error("CAN NOT GET PMLONEDOORRECEIVEFILE");
		}
		
		if ( null != file) {
			
			processTime =  OnedoorDwr.timeProcessRemainOfFile(file.getExpectedReturningDate());
			
			if ( null != file.getApplicationDate() ) {
				ngayNhan = sdf.format(file.getApplicationDate());
				String[] dateSplit = ngayNhan.split("/");
				day = dateSplit[0];
				month = dateSplit[1];
				year = dateSplit[2];
			}
			//dai dien ben nop hs
			represent =  file.getApplicantName();
			receiptNumber = file.getNumberReceipt();
			address = file.getPermanentAddress();
			
			//hour
			if (!"".equals(applicantTime)){
				String[] time = applicantTime.split(":");
				hour = time[0];
				minutes = time[1];
			}
			
			//departmentReceive
			Department department = null;
			try {
				department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				departmentReceive = department.getDepartmentsName();
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		
		PhieuChuyenUtil rtfUtil = new PhieuChuyenUtil(realPath, day, month, year, StringUtils.convertToRTF(receiptNumber),hour, minutes,
				StringUtils.convertToRTF(address), StringUtils.convertToRTF(represent), processTime, StringUtils.convertToRTF(departmentReceive));
		
		InputStream in = null;
		try {
			in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/phieuChuyenHoSoCacPhong.rtf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ServletResponseUtil.sendFile(response, "phieuChuyenHoSoCacPhong.rtf", in, "application/rtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
