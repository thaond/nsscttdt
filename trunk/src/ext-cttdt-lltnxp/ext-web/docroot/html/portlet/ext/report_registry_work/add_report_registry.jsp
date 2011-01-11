<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>\
<%@page import="java.util.List"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	String tabs1 = ParamUtil.getString(request, "tabs1" ,"Report-Registry");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	
	List<Department> departments = DepartmentLocalServiceUtil.getDepartments(-1,-1);
%>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="add_report_registry">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="reportregistry" />
	<portlet:param name="tabs1" value="Report-Registry" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_report_registry%>" enctype="multipart/form-data" method="post">
<table>
	<tr>
		<td><liferay-ui:message key="report-registry-code" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>reportRegistryCode"></td>
		<td><liferay-ui:message key="department-name" /></td>
		<td>
		<select name="<portlet:namespace/>department">
			<option value=""><liferay-ui:message key="select-department" /></option>
			<% if(departments.size() >0 ){ %>
				<% for(int i = 0; i < departments.size(); i++){ %>
					<option value="<%=departments.get(i).getDepartmentId()%>"><%=departments.get(i).getDepartmentName()%></option>		
				<%} %> 
			<%} %> 
		</select>
		</td>
	</tr>
</table>	

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="result-work"/></label>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="result-title-file" /></td>
		    	<td width="50%"><liferay-ui:message key="result-name-file" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="add-result-work-file" />' onclick="uploadResultFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
</fieldset>

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="program-work"/></label>
		<table id="addfileupload1" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="program-title-file" /></td>
		    	<td width="50%"><liferay-ui:message key="program-name-file" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="add-program-work-file" />' onclick="uploadProgramFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow1" id="nameFieldRow1" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles1" id="nameFiles1" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles1" id="titleFiles1" value="" />
</fieldset>

<br>

<input type="submit" value='<liferay-ui:message key="add-report-registry"/>' onclick="return checkValidate()">
</form>

<script type="text/javascript">
	var incstt = 0;
	var incstt1 = 0;
	
	function checkValidate(){
		fileUpload();
		fileUpload1();
	}

	function uploadResultFile(){
		var table=document.getElementById('addfileupload').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile' type='text' maxlength='255' id='titlefile" +incstt+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile" +incstt+"' id='namefile" +incstt+"' onchange='getFileNameForTitle(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow(this)' ></input></div>";
		incstt += 1;
	}
	
	function uploadProgramFile(){
		var table=document.getElementById('addfileupload1').insertRow(1);
		
		var title = table.insertCell(0);
		var nameDocument = table.insertCell(1);
		var deleteRow = table.insertCell(2);

		table.style.backgroundColor = "white";
		table.setAttribute("class", "portlet-section-header results-row");
		table.setAttribute("className", "portlet-section-header results-row");
		title.innerHTML="<input style='width: 90%'  name='<portlet:namespace/>titlefile1' type='text' maxlength='255' id='titlefile1" +incstt1+"'>";
		nameDocument.innerHTML="<input type='file' name='<portlet:namespace/>namefile1" +incstt1+"' id='namefile1" +incstt1+"' onchange='getFileNameForTitle1(this)'>";
		deleteRow.innerHTML="<div align='center'><input style='width: 80%' type='button' value='<liferay-ui:message key='delete'/>' onclick='deleteRow1(this)' ></input></div>";
		incstt1 += 1;
	}
	
	function getFileNameForTitle(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile", "");
			var titleObj = document.getElementById("titlefile" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}
	
	function getFileNameForTitle1(obj) {
		if (obj.type != "file") return;
		var id = obj.id;
		var filePath = obj.value;
		if (id != null && id != "") {
			var numOfId = id.replace("namefile1", "");
			var titleObj = document.getElementById("titlefile1" + numOfId);
			if (titleObj != null && titleObj.type == "text" && filePath.length > 0) {
				var arrTmp = filePath.split("\\");
				if (arrTmp.length > 0) {
					var fileName = arrTmp[arrTmp.length - 1];
					if (fileName.length > 0) {
						var lastIdxDot = fileName.lastIndexOf(".");
						if (lastIdxDot > 0) {
							titleObj.value = fileName.substring(0, lastIdxDot);
						}
					} 
				} 
			} 
		} 
	}

	function deleteRow(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload').deleteRow(i);
	}
	
	function deleteRow1(row){
		 var i=row.parentNode.parentNode.parentNode.rowIndex;
		 document.getElementById('addfileupload1').deleteRow(i);
	}
	
	function fileUpload() {
		var listNameRow = "";
		var valueNameFile ="";
		var tileFile ="";
		for(i = 0; i < incstt; i++) {
			if(document.getElementById('namefile'+ i)) {			
				listNameRow += "namefile" + i + "_";
				valueNameFile += document.getElementById('namefile'+ i).value +"/";
			}

			if (document.getElementById('titlefile'+ i)) {
				tileFile += document.getElementById('titlefile'+ i).value + "#";	
			}
		}
		alert(listNameRow);
		document.getElementById('nameFieldRow').value = listNameRow;
		document.getElementById('nameFiles').value = valueNameFile;
		document.getElementById('titleFiles').value = tileFile;		
	}
	
	function fileUpload1() {
		var listNameRow = "";
		var valueNameFile ="";
		var tileFile ="";
		for(i = 0; i < incstt; i++) {
			if(document.getElementById('namefile1'+ i)) {			
				listNameRow += "namefile1" + i + "_";
				valueNameFile += document.getElementById('namefile1'+ i).value +"/";
			}

			if (document.getElementById('titlefile1'+ i)) {
				tileFile += document.getElementById('titlefile1'+ i).value + "#";	
			}
		}
		alert(listNameRow);
		document.getElementById('nameFieldRow1').value = listNameRow;
		document.getElementById('nameFiles1').value = valueNameFile;
		document.getElementById('titleFiles1').value = tileFile;		
	}
	
	function checkFileUpload() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile'+ i).value;
				var fileTitle = document.getElementById('titlefile'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	function checkFileUpload1() {
		var result = true;
		for(i = incstt - 1; i >= 0; i--) {
			if(document.getElementById('namefile1'+ i)) {			
				var valueNameFile1 = document.getElementById('namefile1'+ i).value;
				var fileTitle = document.getElementById('titlefile1'+ i);
				var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1).toLowerCase();

				if (valueNameFile1 == "") {
					alert("<liferay-ui:message key='chon-tap-tin-dinh-kem'/>");
					document.getElementById('namefile1'+ i).focus();
					fileTitle.focus();
					result = false;
					break;
				}

				var typeStandard = "xls,html,htm,doc,docx,xlsx,pdf";	
				
				if(typeStandard.search(type.toLowerCase()) == -1) {
					alert("<liferay-ui:message key='sai-dinh-dang'/>");
					fileTitle.focus();
					result = false;	
					break;
				}

				if (fileTitle.value.trim() == "") {
					alert("<liferay-ui:message key='nhap-tieu-de'/>");
					fileTitle.focus();
					result = false;
					break;
				}
			}
		}
		return result;
	}
</script>

