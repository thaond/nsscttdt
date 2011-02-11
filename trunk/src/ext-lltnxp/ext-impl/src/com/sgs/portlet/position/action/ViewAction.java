package com.sgs.portlet.position.action;

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
import com.sgs.portlet.position.PositionCanNotDeleteException;
import com.sgs.portlet.position.PositionCodeSameCodeException;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalServiceUtil;

public class ViewAction extends PortletAction {

	/**
	 * phmphuc update 28/01/2010
	 */
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	private static Log _log = LogFactory.getLog(ViewAction.class);

	@Override
	public void processAction(ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res) throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);
		
		try {
			if(Constants.ADD.equals(cmd)) {
				createPosition(req, res);
			}
			else if (Constants.DELETE.equals(cmd)) {
				deletePosition(req, res);
			}
			else if (Constants.UPDATE.equals(cmd)) {
				updatePosition(req, res);
			}
			else if (Constants.LOCK.equals(cmd)) {
				updateActivePosition(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(req, "redirect");
				sendRedirect(req, res, redirect);
			}
		} catch (Exception e) {
			if (e instanceof PositionCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof PositionCodeSameCodeException) {
				req.setAttribute("positionFlag", "fail");
				SessionErrors.add(req, e.getClass().getName());
				setForward(req, "portlet.sgs.position.add");
			}
			else {
				throw e;
			}
		}
	}

	private Position createPosition(ActionRequest req, ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
	
		String positionCode = ParamUtil.getString(uploadRequest, "positionCode");
		String positionName = ParamUtil.getString(uploadRequest, "positionName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		Position position = null;
		
		if (active) {
			position = PositionLocalServiceUtil.addPosition(positionCode, positionName, description, "1");
		}
		else {
			position = PositionLocalServiceUtil.addPosition(positionCode, positionName, description, "0");
		}
	
		return position;
	}
	
	/*
	private void editPosition(ActionRequest req, ActionResponse res) {

		String positionId = ParamUtil.getString(req, "positionId");
		
		Position position = null;
		try {
			position = PositionLocalServiceUtil.getPosition(positionId);
		} catch (PortalException e) {
		
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("position", position);
	}*/
	
	private void deletePosition(ActionRequest req, ActionResponse res) throws Exception {
		
		String positionId = ParamUtil.getString(req, "positionId");
		PositionLocalServiceUtil.removeAgency(positionId);
		/* yenlt close 24082010
		List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
		
		try {
			pmlUserList = PmlUserUtil.findByPositionId(positionId);
			
			if (pmlUserList.size() > 0) {
				req.setAttribute("deleteAction", false);
			}
			else {
				Position position = PositionLocalServiceUtil.getPosition(positionId);
				PositionLocalServiceUtil.deletePosition(position);
				
				req.setAttribute("deleteAction", true);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		*/
	}
	
	private Position updatePosition(ActionRequest req, ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String positionId = ParamUtil.getString(uploadRequest, "positionId");
		String positionCode = ParamUtil.getString(uploadRequest, "positionCode");
		String positionName = ParamUtil.getString(uploadRequest, "positionName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		Position position = null;
			
		if (active) {
			position = PositionLocalServiceUtil.updatePosition(positionId, positionCode, positionName, description, "1");
		}
		else {
			position = PositionLocalServiceUtil.updatePosition(positionId, positionCode, positionName, description, "0");
		}
		return position;
	}
	
	private void updateActivePosition(ActionRequest req, ActionResponse res) {
		
		String positionId = ParamUtil.getString(req, "positionId");
		
		try {
			Position position = PositionLocalServiceUtil.getPosition(positionId);
			
			if ("1".equals(position.getActive())) {
				position.setActive("0");
			}
			else {
				position.setActive("1");
			}
			
			position = PositionLocalServiceUtil.updatePosition(position);			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ActionForward render( ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res) throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
			// processAction if
			// available
		}
		else {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			if (!Validator.isNull(cmd)) {
				if (cmd.equals(Constants.EDIT)) {
					editPosition(req, res);
				}
			}
			return mapping.findForward("portlet.sgs.position.view");
		}
	}

	/*
	private List<Position> getListPosition(
		RenderRequest req, RenderResponse res, int numberPage, int numberRecord) {

		int total = 0;
		int totalPage = 0;
		int start = numberPage * numberRecord;
		int end = start + numberRecord;
		List list = null;
		String type = ParamUtil.getString(req, "type");
		String keyword = ParamUtil.getString(req, "keyword");
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		
		String method = request.getMethod().toLowerCase();
		System.out.println("method: " + method);

		if (keyword != null && "get".equals(method)) {
			try {
				byte[] k = keyword.getBytes("ISO-8859-1");

				keyword = new String(k, "UTF-8");

			}
			catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		req.setAttribute("type", type);
		req.setAttribute("keyword", keyword);
		req.setAttribute("numberRecord", numberRecord);

		if (keyword != null && !keyword.trim().equals("")) {
			keyword = "%" + keyword + "%";
		}
		_log.info("keyword: " + keyword);
		_log.info("type: " + type);
		_log.info("numberRecord: " + numberRecord);
		try {
			if (keyword == null || keyword.trim().equals("")) {
				list = PositionUtil.findAll(start, end);
				total = PositionUtil.countAll();
			}
			else {
				if (type.equals("all")) {
					list =
						PositionUtil.findByAllfilter(
							keyword, keyword, keyword, start, end);
					total =
						PositionUtil.countByAllfilter(keyword, keyword, keyword);
				}
				else if (type.equals("positionCode")) {
					list = PositionUtil.findByPositionCode(keyword, start, end);
					total = PositionUtil.countByPositionCode(keyword);
				}
				else if (type.equals("positionName")) {
					list = PositionUtil.findByPositionName(keyword, start, end);
					total = PositionUtil.countByPositionName(keyword);
				}
				else if (type.equals("description")) {
					list = PositionUtil.findByDescription(keyword, start, end);
					total = PositionUtil.countByDescription(keyword);
				}
			}

			_log.info("total record: " + total);
			req.setAttribute("total", total);

			if (total == 0) {
				totalPage = 1;
			}
			else {
				totalPage =
					(total % numberRecord == 0)
						? (total / numberRecord) : (total / numberRecord + 1);
				keyword = ParamUtil.getString(req, "keyword");
			}

			_log.info("total page: " + totalPage);
			req.setAttribute("totalPage", totalPage);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return list;

	}

	private void updatePosition(RenderRequest req, RenderResponse res) {

		String positionId = ParamUtil.getString(req, "positionId");
		String positionCode = ParamUtil.getString(req, "positionCode");
		String positionName = ParamUtil.getString(req, "positionName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");

		try {
			Position position =
				PositionLocalServiceUtil.getPosition(positionId);

			position.setPositionCode(positionCode);
			position.setPositionName(positionName);
			position.setDescription(description);
			if (active) {
				position.setActive("1");
			}
			else {
				position.setActive("0");
			}

			position = PositionLocalServiceUtil.updatePosition(position);

		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private void deletePosition(RenderRequest req, RenderResponse res) {

		String positionId = ParamUtil.getString(req, "positionId");
		List<PmlUser> pmlUserList = null;
		
		try {
			pmlUserList = PmlUserUtil.findByPositionId(positionId);
		} catch (Exception e) {
		}
		if (pmlUserList != null && !pmlUserList.isEmpty()) {
			req.setAttribute("flag", false);
		}
		
		else {
			try {
				
				Position position = PositionLocalServiceUtil.getPosition(positionId);
				PositionLocalServiceUtil.deletePosition(position);
				req.setAttribute("flag", true);
			}
			
			catch (Exception e) {
				req.setAttribute("flag", false);
			}
		}
		
	}*/

	private void editPosition(RenderRequest req, RenderResponse res) {

		String positionId = ParamUtil.getString(req, "positionId");
		req.setAttribute("positionId", positionId);
		
//		try {
//			Position position =
//				PositionLocalServiceUtil.getPosition(positionId);
//			req.setAttribute("position", position);
//		}
//		catch (PortalException e) {
//			e.printStackTrace();
//		}
//		catch (SystemException e) {
//			e.printStackTrace();
//		}
	}

	/*
	private void createPosition(RenderRequest req, RenderResponse res) {

		//String positionId = ParamUtil.getString(req, "positionId");
		String positionId = "";
		try {
			positionId = IdTemplateServiceUtil.generatedId(Position.class);
		} catch (NoSuchIdGeneratedException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		String positionCode = ParamUtil.getString(req, "positionCode");
		String positionName = ParamUtil.getString(req, "positionName");
		String description = ParamUtil.getString(req, "description");
		Boolean active = ParamUtil.getBoolean(req, "active");


		Position position = new PositionImpl();
		position.setPositionId(positionId);
		position.setPositionCode(positionCode);
		position.setPositionName(positionName);
		position.setDescription(description);
		if (active) {
			position.setActive("1");
		}
		else {
			position.setActive("0");
		}

		try {
			position = PositionLocalServiceUtil.updatePosition(position);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

	}

	private void updateActivePosition(RenderRequest req, RenderResponse res) {

		String positionId = ParamUtil.getString(req, "positionId");

		try {
			Position position =
				PositionLocalServiceUtil.getPosition(positionId);
			_log.info("position: " + position.getActive());
			if ("1".equals(position.getActive())) {
				position.setActive("0");
			}
			else {
				position.setActive("1");
			}

			position = PositionLocalServiceUtil.updatePosition(position);

		}

		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}*/

}
