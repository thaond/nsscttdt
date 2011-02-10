package com.sgs.portlet.career.action;

import java.rmi.RemoteException;
import java.util.ArrayList;
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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.career.CareerCodeSameCodeException;
import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.model.impl.CareerImpl;
import com.sgs.portlet.career.service.CareerLocalServiceUtil;
import com.sgs.portlet.career.service.persistence.CareerUtil;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class ViewAction extends PortletAction {

	private static Log _log = LogFactory.getLog(ViewAction.class);
	private int total = 0;

	// Yenlt update 05/04/2010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
							PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
		//yenlt 05/04/2010
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect");
		try {
			if (Validator.isNotNull(cmd)) {
				if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
					updateCareer(req, res);
				}
				else if (cmd.equals(Constants.EDIT)) {
					editCareer(req, res);
				}
				else if (cmd.equals(Constants.DELETE)) {
					boolean delete = deleteCareer(req);
					redirect += "&delete=".concat(String.valueOf(delete));
				}
	//			else if (cmd.equals(Constants.UPDATE)) {
	//				updateCareer(req, res);
	//			}
				else if (cmd.equals(Constants.LOCK)) {
					updateActiveCareer(req, res);
				}
			}
		} catch (Exception e) {
			if (e instanceof CareerCodeSameCodeException) {
				req.setAttribute("careerFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.career.add");
			}
			else {
				throw e;
			}
		}

	}
	//	yenlt 05/04/2010
	private void updateActiveCareer(ActionRequest req, ActionResponse res) {
		String careerId = ParamUtil.getString(req, "careerId");
		
		try {
			Career career = CareerLocalServiceUtil.getCareer(careerId);
			
			if ("1".equals(career.getActive())) {
				career.setActive("0");
			}
			else {
				career.setActive("1");
			}

			career = CareerLocalServiceUtil.updateCareer(career);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private boolean deleteCareer(ActionRequest req) {
		String careerId = ParamUtil.getString(req, "careerId");
		Career career = null;
		try {
			career = CareerLocalServiceUtil.getCareer(careerId);
			CareerLocalServiceUtil.deleteCareer(career);
			return true;
		} catch (PortalException e) {
			_log.error(e);
			return false;
		} catch (SystemException e) {
			_log.error(e);
			return false;
		}	
	}

	private Career updateCareer(ActionRequest req, ActionResponse res) throws SystemException, PortalException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		
		String careerId = ParamUtil.getString(uploadRequest, "careerId");
		String careerCode = ParamUtil.getString(uploadRequest, "careerCode");
		String careerName = ParamUtil.getString(uploadRequest, "careerName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		Career career = null;
		
		if (cmd.equals(Constants.ADD)) {
			if (active) {
				career = CareerLocalServiceUtil.addCareer(careerCode, careerName, description, "1");
			}
			else {
				career = CareerLocalServiceUtil.addCareer(careerCode, careerName, description, "0");
			}
		}
		else if (cmd.equals(Constants.UPDATE)) {
			if (active) {
				career = CareerLocalServiceUtil.updateCareer(careerId, careerCode, careerName, description, "1");
			}
			else {
				career = CareerLocalServiceUtil.updateCareer(careerId, careerCode, careerName, description, "0");
			}
		}
		
		return career;
	}

	private void editCareer(ActionRequest req, ActionResponse res) {
		String careerId = ParamUtil.getString(req, "careerId");
		req.setAttribute("careerId", careerId);
		/*
		Career career = null;
		try {
			career = CareerLocalServiceUtil.getCareer(careerId);
			req.setAttribute("career", career);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}*/
	}

	/*
	private void createCareer(ActionRequest req, ActionResponse res) {
		Career career = new CareerImpl();
		String careerId = "";
		
		try {
			careerId = IdTemplateServiceUtil.generatedId(Career.class);
		} catch (NoSuchIdGeneratedException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (RemoteException e) {
			_log.error(e);
		}
		
		String careerCode = ParamUtil.getString(req, "careerCode");
		String careerName = ParamUtil.getString(req, "careerName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");
		
		career.setCareerId(careerId);
		career.setCareerCode(careerCode);
		career.setCareerName(careerName);
		career.setDescription(description);
		if (active) {
			career.setActive("1");
		}
		else {
			career.setActive("0");
		}

		try {
			CareerLocalServiceUtil.addCareer(career);
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	*/
	//end
	
	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		}
		else {
			return mapping.findForward("portlet.sgs.career.view");
		}
	}

	/**
	 * Lay danh sach career tu vi tri bat dau(start1) den vi tri ket thuc(end1)
	 * Danh sach duoc loc theo truong(type) va tu khoa(keyword)
	 * Neu keyword = null thi tim het va lay danh sach tu start den end
	 * Neu keyword != null:
	 *  + type = all: tim tat ca cac truong co tu khoa la keyword va lay danh sach
	 *  tu start toi end
	 *  + type = careerCode: tim danh sach sao cho truong careerCode giong keyword
	 *  va lay danh sach tu start toi end
	 *  + type = careerName: tim danh sach sao cho truong careerName giong keyword
	 *  va lay danh sach tu start toi end  
	 *  + type = description: tim danh sach sao cho truong description giong keyword
	 *  va lay danh sach tu start toi end  
	 * @param type
	 * @param keyword
	 * @param start1
	 * @param end1
	 * @return danh sach career
	 */
	public List<Career> getListCareer(
		String type, String keyword, String start1, String end1) {

		List<Career> list = new ArrayList<Career>();
		int start = Integer.parseInt(start1);
		int end = Integer.parseInt(end1);
		try {

			if (keyword == null || keyword.trim().equals("")) {
				list = CareerUtil.findAll(start, end);
				total = CareerUtil.countAll();
				
			}
			else {
				keyword = "%" + keyword + "%";
				if (type.equals("all")) {
					list =
						CareerUtil.findByC_N_D(
							keyword, keyword, keyword, start, end);
					total = CareerUtil.countByC_N_D(keyword, keyword, keyword);
					
				}
				else if (type.equals("careerCode")) {
					list = CareerUtil.findByCareerCode(keyword, start, end);
					total = CareerUtil.countByCareerCode(keyword);
				}
				
				else if (type.equals("careerName")) {
					list = CareerUtil.findByCareerName(keyword, start, end);
					total = CareerUtil.countByCareerName(keyword);
				}
				else if (type.equals("description")) {
					list = CareerUtil.findByDescription(keyword, start, end);
					total = CareerUtil.countByDescription(keyword);
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Xoa doi tuong career co id duoc xac dinh trong he thong
	 * @param careerId
	 */
	public void deleteCareer(String careerId) {

		try {
			Career career = CareerLocalServiceUtil.getCareer(careerId);
			CareerLocalServiceUtil.deleteCareer(career);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lay so dong du lieu khi tim kiem theo truong(type) va tu khoa (keyword)
	 * @param type
	 * @param keyword
	 * @return tong so dong
	 */
	public int totalRecord(String type, String keyword) {
		try {
			if (keyword == null || keyword.trim().equals("")) {
				total = CareerUtil.countAll();
			}
			else {
				keyword = "%" + keyword + "%";
				if (type.equals("all")) {
					total = CareerUtil.countByC_N_D(keyword, keyword, keyword);
				}
				else if (type.equals("careerCode")) {
					total = CareerUtil.countByCareerCode(keyword);
				}
				else if (type.equals("careerName")) {
					total = CareerUtil.countByCareerName(keyword);
				}
				else if (type.equals("description")) {
					total = CareerUtil.countByDescription(keyword);
				}
			}

		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * Cap nhat du lieu moi
	 * Dung co condition de xac dinh them moi hay cap nhat
	 * + Condition = "update": cap nhat
	 * + Khac: them moi
	 * @param condition
	 * @param careerId
	 * @param careerCode
	 * @param careerName
	 * @param description
	 * @param active
	 */
	public void update(
		String condition, String careerId, String careerCode,
		String careerName, String description, String active) {
	
		try {
			if ("update".equals(condition)) {
				Career career = new CareerImpl();
				career.setCareerId(careerId);
				career.setCareerCode(careerCode);
				career.setCareerName(careerName);
				career.setDescription(description);
				career.setActive(active);
				career = CareerLocalServiceUtil.updateCareer(career);
			}
			else {
				try {
					careerId = IdTemplateServiceUtil.generatedId(Career.class);
				}
				catch (NoSuchIdGeneratedException e) {
					e.printStackTrace();
				}
				catch (RemoteException e) {
					e.printStackTrace();
				}
				create(careerId, careerCode, careerName, description, active);
			}

		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Them moi mot career vao he thong
	 * @param id
	 * @param careerCode
	 * @param careerName
	 * @param description
	 * @param active
	 */
	public void create(
		String id, String careerCode, String careerName, String description,
		String active) {

		Career career = new CareerImpl();
		career.setCareerId(id);
		career.setCareerCode(careerCode);
		career.setCareerName(careerName);
		career.setDescription(description);
		career.setActive(active);

		try {
			CareerLocalServiceUtil.addCareer(career);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}
}
