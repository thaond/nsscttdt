package com.sgs.portlet.field.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.field.form.FieldForm;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.model.impl.PmlFieldImpl;
import com.sgs.portlet.field.service.PmlFieldLocalServiceUtil;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			String cmd = ParamUtil.getString(req, "cmd");
			String errorMessage = "";
			String key = "";
			int filter = 0; // default
			boolean flagSearch = false;
			if(Validator.isNull(cmd) == false) {
				
				if(cmd.equals("search")) { // search
					// get key search
					key = ParamUtil.getString(req, "key");
					HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
					String method = request.getMethod().toLowerCase();

					if (key != null && "get".equals(method)) {
						try {
							byte[] k = key.getBytes("ISO-8859-1");

							key = new String(k, "UTF-8");

						}
						catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
						}
					}
					req.setAttribute("keySearch", key);
					// get filter(0: all, 1: code, 2: name, 3: description)
					filter = Integer.parseInt(ParamUtil.getString(req, "filter"));
					req.setAttribute("filter", filter);
					// set flag
					flagSearch = true;
				}
				else if(cmd.equals("add_process")) addProcess(form, req, res, errorMessage); // add process
				else if(cmd.equals("edit")) edit(form, req, res); // edit
				else if(cmd.equals("edit_process")) editProcess(form, req, res, errorMessage); // edit process
				else if(cmd.equals("delete")) delete(form, req, res); // delete
			}
			
			// get current page
			int page = 1;
			if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
			
			// get total item of page
			int limit = 10; // default
			if(req.getParameter("limit") != null) limit = Integer.parseInt(req.getParameter("limit"));
			
			// get total rows, total pages
			int totalRows = flagSearch == false ? PmlFieldLocalServiceUtil.getPmlFieldsCount() : getListField(key, filter).size();
			int totalPages = totalRows / limit;
			totalPages = totalRows % limit == 0 ? totalPages : totalPages + 1;
			
			// set attributes
			req.setAttribute("currentPage", page);
			req.setAttribute("currentLimit", limit);
			req.setAttribute("totalPages", totalPages);
			req.setAttribute("totalOfItems", totalRows);
			
			// get list field
			int start = (page - 1) * limit;
			int end = page * limit;
			ArrayList<PmlField> listField = new ArrayList<PmlField>();
			if (flagSearch == false){
				listField = (ArrayList<PmlField>) PmlFieldLocalServiceUtil.getPmlFields(start, end);
			}else {
				listField = getListField(key, filter, start, end);
			}
			
			// get flag sort
			int flag, sort = 0;
			if(req.getParameter("sort") != null) sort = Integer.parseInt(req.getParameter("sort"));
			if(req.getParameter("flag") == null) flag = 0;
			else if(Integer.parseInt(req.getParameter("flag")) == 1) flag = 0;
			else flag = 1;
			
			// set flag sort
			req.setAttribute("flag", flag);
			// set list field
			req.setAttribute("listField", sort(listField, sort, flag));
			// set error message
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("listDepartments", DepartmentUtil.findAll());
			
			return mapping.findForward("portlet.sgs.field.view");
		}
	}

	private ArrayList<PmlField> getListField(String key, int filter) throws Exception {
		
		ArrayList<PmlField> listField = new ArrayList<PmlField>();
		
		switch(filter) {
		
		case 1:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldCode(key);
			break;
		case 2:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldName(key);
			break;
		case 3:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByDescription(key);
			break;
		default:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldCode_FieldName(key, key);
			break;
		}
		return listField;
	}
	
	/*
	 * @param key, filter, start, end
	 *
	 * 0 - find all
	 * 1 - find by field code
	 * 2 - find by field name
	 * 3 - find by description
	 *
	 * @return ArrayList
	*/
	private ArrayList<PmlField> getListField(String key, int filter, int start, int end) throws Exception {
			
		ArrayList<PmlField> listField = new ArrayList<PmlField>();
		
		switch(filter) {
		
		case 1:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldCode(key, start, end);
			break;
		case 2:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldName(key, start, end);
			break;
		case 3:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByDescription(key, start, end);
			break;
		default:
			listField = (ArrayList<PmlField>) PmlFieldUtil.findByFieldCode_FieldName(key, key, start, end);
			break;
		}
		return listField;
	}
	
	/*
	 * 
	 */
	private void addProcess(ActionForm form, RenderRequest req, RenderResponse res, String errorMessage) throws Exception {

		try {
//			// get form available
			FieldForm fieldForm = (FieldForm) form;
			String fieldID = IdTemplateServiceUtil.generatedId(PmlField.class);
			
			PmlField field = PmlFieldLocalServiceUtil.createPmlField(fieldID);
			Boolean active = ParamUtil.getBoolean(req, "_active");
			field.setFieldCode(fieldForm.get_fieldCode());
			field.setFieldName(fieldForm.get_fieldName());
			field.setDescription(fieldForm.get_description());
			field.setDepartmentsId(fieldForm.get_departmentsId());
			if(active) {
				field.setActive("1");
			} else {
				field.setActive("0");
			}
			
			PmlFieldLocalServiceUtil.updatePmlField(field);
			
			errorMessage = "Successfully!";
		} catch(Exception e) {
			errorMessage = "Error ...";
		}
	}

	/*
	 * 
	 */
	private void edit(ActionForm form, RenderRequest req, RenderResponse res) throws Exception {
		
		// get Field ID
		String fieldID = ParamUtil.getString(req, "fieldID");
		FieldForm fieldForm = (FieldForm) form;
		
		PmlField field = PmlFieldUtil.findByPrimaryKey(fieldID);
		fieldForm.set_active(field.getActive());
		fieldForm.set_description(field.getDescription());
		fieldForm.set_fieldCode(field.getFieldCode());
		fieldForm.set_fieldId(fieldID);
		fieldForm.set_fieldName(field.getFieldName());
		fieldForm.set_departmentsId(field.getDepartmentsId());
		
		req.setAttribute("field", fieldForm);
	}
	
	/*
	 * 
	 */
	private void editProcess(ActionForm form, RenderRequest req, RenderResponse res, String errorMessage) throws Exception {
		
		try {
			// get form available
			FieldForm fieldForm = (FieldForm) form;
			
			PmlField field = new PmlFieldImpl();
			
			field.setFieldId(fieldForm.get_fieldId());
			Boolean active = ParamUtil.getBoolean(req, "_active");
			
			field.setFieldCode(fieldForm.get_fieldCode());
			field.setFieldName(fieldForm.get_fieldName());
			field.setDescription(fieldForm.get_description());
			field.setDepartmentsId(fieldForm.get_departmentsId());
			if(active) {
				field.setActive("1");
			} else {
				field.setActive("0");
			}
			
			PmlFieldLocalServiceUtil.updatePmlField(field);
			
			errorMessage = "Successfully!";
		} catch(Exception e) {
			errorMessage = "Error.";
		}
	}
	
	/*
	 * 
	 */
	private void delete(ActionForm form, RenderRequest req, RenderResponse res) throws Exception {
		
		try {
		
			String fieldID = ParamUtil.getString(req, "fieldID");	
			PmlFieldLocalServiceUtil.deletePmlField(fieldID);
		} catch(Exception e) {
			
		}
	}
	
	/*
	 * sort array list field
	 *  
	 * @param list, sort, flag
	 *
	 * 0 - not sort
	 * 1 - sort field code
	 * 2 - sort field name
	 * 3 - sort active
	 *
	 * @return ArrayList
	*/
	private ArrayList<PmlField> sort(ArrayList<PmlField> list, int sort, int flag) throws Exception {
		
		int len = list.size();
		int i, j;
		
		for(i = 0; i < len - 1; i ++) {
			for(j = i + 1; j < len; j ++) {
				
				String str1, str2;
				switch(sort) {
					
					case 2:
						str1 = (list.get(i)).getFieldName();
						str2 = (list.get(j)).getFieldName();
						break;
					case 3:
						str1 = (list.get(i)).getActive();
						str2 = (list.get(j)).getActive();
						break;
					default:
						str1 = (list.get(i)).getFieldCode();
						str2 = (list.get(j)).getFieldCode();
						break;
				}
				
				if(flag == 1) { // sort down
					if(str1.compareTo(str2) < 0) {
						PmlField temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				} else { // sort up
					if(str1.compareTo(str2) > 0) {
						PmlField temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
		return list;
	}

}
