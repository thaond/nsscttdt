<%@page import="com.sgs.portlet.documentdelegate.util.PmlDocumentDelegateUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>
<%@page import="com.sgs.portlet.departmentleader.search.PmlUserLeaderSearch"%>
<%@page import="com.sgs.portlet.departmentleader.action.PmlUserDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlDepartmentsLeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.service.PositionLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sgs.portlet.departmentleader.search.PmlDepartmentLeaderChecker"%>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	//List<PmlUserDTO>  pmlUserDTOList = (List<PmlUserDTO>) renderRequest.getAttribute("userList"); // phmphuc close 27/05/2010
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	String departmentId = (String) renderRequest.getAttribute("departmentId");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/departmentleader/setleader");
	portletURL.setParameter("departmentId", departmentId);
	portletURL.setParameter("redirect", redirect);
%>

<script type="text/javascript">
	function <portlet:namespace/>updateLeader(url) {
	
		var leaderDepartmentCheckbox = document.getElementsByName("<portlet:namespace/>rowIds");
		var listDepartmentLeaderExcept = "";
		var listUnDepartmentLeaderExcept = "";
		for (var i = 0; i < leaderDepartmentCheckbox.length; i++) {
			
			if (leaderDepartmentCheckbox[i].checked) {
				listDepartmentLeaderExcept += leaderDepartmentCheckbox[i].value + ",";
			} else {
				listUnDepartmentLeaderExcept += leaderDepartmentCheckbox[i].value + ",";
			}
			
		}
		
		document.<portlet:namespace/>fm.<portlet:namespace/>addDepartmentLeader.value = listDepartmentLeaderExcept;
		document.<portlet:namespace/>fm.<portlet:namespace/>removeDepartmentLeader.value = listUnDepartmentLeaderExcept;
		
		// nguoi chu tri hop
		var leaderMettingCheckboxs = document.getElementsByName("<portlet:namespace/>isLeaderMetting");
	
		var listleaderMettingExcept = "";
		var listUnleaderMettingExcept = "";
		for (var j = 0; j < leaderMettingCheckboxs.length; j++) {
			
			if (leaderMettingCheckboxs[j].checked) {
				listleaderMettingExcept += leaderMettingCheckboxs[j].value + ",";
			} else {
				listUnleaderMettingExcept += leaderMettingCheckboxs[j].value + ",";
			}
			
		}	
		document.<portlet:namespace/>fm.<portlet:namespace/>addLeaderMetting.value = listleaderMettingExcept;
		document.<portlet:namespace/>fm.<portlet:namespace/>removeLeaderMetting.value = listUnleaderMettingExcept;
		
		// van thu phong
		
		var vanThuPhongCheckboxs = document.getElementsByName("<portlet:namespace/>isVanThuDepartment");
	
		var listVanThuPhongExcept = "";
		var listUnVanThuPhongExcept = "";
		for (var z = 0; z < vanThuPhongCheckboxs.length; z++) {
			
			if (vanThuPhongCheckboxs[z].checked) {
				listVanThuPhongExcept += vanThuPhongCheckboxs[z].value + ",";
			} else {
				listUnVanThuPhongExcept += vanThuPhongCheckboxs[z].value + ",";
			}
			
		}	
		document.<portlet:namespace/>fm.<portlet:namespace/>addVanThuPhong.value = listVanThuPhongExcept;
		document.<portlet:namespace/>fm.<portlet:namespace/>removeVanThuPhong.value = listUnVanThuPhongExcept;
		
		submitForm(document.<portlet:namespace/>fm);
	}
</script>

	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
	<div class="title_categ"><liferay-ui:message key="department_name"/> : <%= departmentName %></div>
	<div class="boxcontent">	
	<!-- <input type="hidden" name="<portlet:namespace />departmentId" id="departmentId" value="<%= departmentId %>"> -->
	<input name="<portlet:namespace/>addDepartmentLeader"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeDepartmentLeader"  type="hidden" value=""/>
	
	<input name="<portlet:namespace/>addLeaderMetting"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeLeaderMetting"  type="hidden" value=""/>
	
	<input name="<portlet:namespace/>addVanThuPhong"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeVanThuPhong"  type="hidden" value=""/>
	
	<%
		PmlUserLeaderSearch pmlUserLeaderSearch = new PmlUserLeaderSearch(renderRequest, portletURL);
		
		// phmphuc update 27/05/2010
		List<PmlUser> results = PmlUserLocalServiceUtil.findUserListByDepartment(departmentId, pmlUserLeaderSearch.getStart(), pmlUserLeaderSearch.getEnd());
		Collections.sort(results, new Comparator<PmlUser>(){
			public int compare(PmlUser o1, PmlUser o2) {
				return PmlDocumentDelegateUtil.getFullName(o1.getUserId()).compareTo(PmlDocumentDelegateUtil.getFullName(o2.getUserId()));
			}
		});
		int total = PmlUserLocalServiceUtil.countUserListByDepartment(departmentId);
	
		// List<PmlUserDTO> results = pmlUserDTOList; // phmphuc close 27/05/2010
		
		pmlUserLeaderSearch.setTotal(total);
		pmlUserLeaderSearch.setResults(results);
		portletURL.setParameter(pmlUserLeaderSearch.getCurParam(), String.valueOf(pmlUserLeaderSearch.getCurValue()));
		
		// chuyen ve rowChecker cua Liferay
		List<String> header = pmlUserLeaderSearch.getHeaderNames();
		RowChecker rowChecker = new PmlDepartmentLeaderChecker(renderResponse);
		pmlUserLeaderSearch.setRowChecker(rowChecker);
		
		
		// tieu de nguoi chu tri hop
		String formName = renderResponse.getNamespace() + "fm";
		String rowName = renderResponse.getNamespace() + "isLeaderMetting";
		String rowAllName = renderResponse.getNamespace() +"allIsLeaderMetting";
		
		StringBuilder rowAllNameChecked = new StringBuilder();
		rowAllNameChecked.append("<input name=\"");
		rowAllNameChecked.append(rowAllName);
		rowAllNameChecked.append("\" type=\"checkbox\" ");
		rowAllNameChecked.append("onClick=\"Liferay.Util.checkAll(");
		rowAllNameChecked.append(formName);
		rowAllNameChecked.append(", '");
		rowAllNameChecked.append(rowName);
		rowAllNameChecked.append("', this");
		rowAllNameChecked.append(");\"> " + LanguageUtil.get(pageContext,"nguoi-chu-tri-hop", ""));
		header.add(rowAllNameChecked.toString());
		
		// tieu de nguoi chu tri hop
		
		String rowNameVT = renderResponse.getNamespace() + "isVanThuDepartment";
		String rowAllNameVT = renderResponse.getNamespace() +"allIsVanThuDepartment";
		
		StringBuilder rowAllNameVTChecked = new StringBuilder();
		rowAllNameVTChecked.append("<input name=\"");
		rowAllNameVTChecked.append(rowAllNameVT);
		rowAllNameVTChecked.append("\" type=\"checkbox\" ");
		rowAllNameVTChecked.append("onClick=\"Liferay.Util.checkAll(");
		rowAllNameVTChecked.append(formName);
		rowAllNameVTChecked.append(", '");
		rowAllNameVTChecked.append(rowNameVT);
		rowAllNameVTChecked.append("', this");
		rowAllNameVTChecked.append(");\"> " + LanguageUtil.get(pageContext,"van-thu-phong", ""));
		header.add(rowAllNameVTChecked.toString());
		
		pmlUserLeaderSearch.setHeaderNames(header);
	%>
	
	<%
		List resultRow = pmlUserLeaderSearch.getResultRows();
		ResultRow row = null;
		PmlUser pmlUser = null;
		long pmlUserId = 0;
		//String isLeader = "";
		boolean isMain = false;
		
		User userHienThi = null;
		String userName = "";
		
		Position position = null;
		
		int countCheck = 0;
		String isNguoiChuTriHop = "";
		StringBuilder rowNameChecked=null;
		
		int countCheckVT = 0;
		String isVanThuPhong = "";
		
		List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
		
		for (int i = 0; i < results.size(); i ++) {
			pmlUser = results.get(i);
			pmlUserId = pmlUser.getUserId();
			
			row = new ResultRow(pmlUser, pmlUserId, i);
			
			try {
				pmlDepartmentsLeaderList = PmlDepartmentsLeaderUtil.findByDepartmentsId_UserId(departmentId, pmlUserId);
			} catch (Exception e) {
				pmlDepartmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
			}
			
			/* phmphuc close 23/09/2010
			if (pmlDepartmentsLeaderList.size()!= 0 ) {
				isLeader = "1";
				countCheck += 1;
			}

			// checked
			StringBuilder rowNameChecked = new StringBuilder();
			rowNameChecked.append("<input ");
			rowNameChecked.append(("1".equals(isLeader) ? "checked " : " "));
			rowNameChecked.append("name=\"");
			rowNameChecked.append(rowName);
			rowNameChecked.append("\" type=\"checkbox\" value=\"");
			rowNameChecked.append(String.valueOf(pmlUserId));
			rowNameChecked.append("\" ");
			rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
			rowNameChecked.append(formName);
			rowNameChecked.append(", '");
			rowNameChecked.append(rowName);
			rowNameChecked.append("', ");
			rowNameChecked.append(rowAllName);
			rowNameChecked.append(");\"");
			rowNameChecked.append(">");
			
			isLeader = "";
			row.addText(rowNameChecked.toString()); 
			// end phmphuc close
			*/
			
			// STT
			row.addText((i + 1) + ".");
			
			// ten lanh dao
			try {
			userHienThi = UserLocalServiceUtil.getUser(pmlUserId);
			userName = userHienThi.getLastName() + " " + userHienThi.getMiddleName() + " " + userHienThi.getFirstName();
			}
			catch (Exception ex) {}
			
			row.addText(userName);
			
			// chuc vu
			try {
				position = PositionLocalServiceUtil.getPosition(pmlUser.getPositionId());
				row.addText(position.getPositionName());
			} catch (Exception e) {
				row.addText("");
			}
			
			// uu tien	
			for (int j = 0; j < pmlDepartmentsLeaderList.size(); j++) {
				if (pmlUserId == pmlDepartmentsLeaderList.get(j).getUserId() && pmlDepartmentsLeaderList.get(j).getMain()) {
					isMain = true;
					break;
				}
				else {
					isMain = false;
				}
				
			}
			String uuTien = "<input type='radio' onclick='clickCheckBox(event,this)'" + (isMain == true  ? "checked" : " ") +  " value=" + String.valueOf(pmlUserId) +  " name='isLeaderMain'/>";
			isMain = false;
			row.addText(uuTien);
			
			// nguoi chu tri hop
			if (pmlUser.getIsLeaderMetting()) {
				isNguoiChuTriHop = "1";
				countCheck += 1;
			}

			// checked
			 rowNameChecked = new StringBuilder();
			rowNameChecked.append("<input ");
			rowNameChecked.append(("1".equals(isNguoiChuTriHop) ? "checked " : " "));
			rowNameChecked.append("name=\"");
			rowNameChecked.append(rowName);
			rowNameChecked.append("\" type=\"checkbox\" value=\"");
			rowNameChecked.append(String.valueOf(pmlUserId));
			rowNameChecked.append("\" ");
			rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
			rowNameChecked.append(formName);
			rowNameChecked.append(", '");
			rowNameChecked.append(rowName);
			rowNameChecked.append("', ");
			rowNameChecked.append(rowAllName);
			rowNameChecked.append(");\"");
			rowNameChecked.append(">");
			
			isNguoiChuTriHop = "";
			row.addText(rowNameChecked.toString()); 
			
			// van thu cua phong
			
			if (pmlUser.getIsVanThuPhong()) {
				isVanThuPhong = "1";
				countCheckVT += 1;
			}

			// checked
			rowNameChecked = new StringBuilder();
			rowNameChecked.append("<input ");
			rowNameChecked.append(("1".equals(isVanThuPhong) ? "checked " : " "));
			rowNameChecked.append("name=\"");
			rowNameChecked.append(rowNameVT);
			rowNameChecked.append("\" type=\"checkbox\" value=\"");
			rowNameChecked.append(String.valueOf(pmlUserId));
			rowNameChecked.append("\" ");
			rowNameChecked.append("onClick=\"Liferay.Util.checkAllBox(");
			rowNameChecked.append(formName);
			rowNameChecked.append(", '");
			rowNameChecked.append(rowNameVT);
			rowNameChecked.append("', ");
			rowNameChecked.append(rowAllNameVT);
			rowNameChecked.append(");\"");
			rowNameChecked.append(">");
			
			isVanThuPhong = "";
			row.addText(rowNameChecked.toString());
		
			resultRow.add(row);
		}
		
	%>

		<liferay-ui:search-iterator searchContainer="<%= pmlUserLeaderSearch %>" />
		<div align="right" id="table-button">
			<input class="button-width" type="button" value='<liferay-ui:message key="save"/>' onclick="<portlet:namespace/>updateLeader('<%= portletURL.toString() %>');"/>
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'/></span></div>
		</div>
	</form>

  <c:if test="<%= (countCheck == results.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.<portlet:namespace />allIsLeaderMetting.checked = true;
		</script>
 </c:if>

 <c:if test="<%= (countCheckVT == results.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.<portlet:namespace />allIsVanThuDepartment.checked = true;
		</script>
 </c:if>

