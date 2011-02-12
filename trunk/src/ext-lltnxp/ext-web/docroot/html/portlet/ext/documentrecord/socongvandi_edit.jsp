<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<liferay-util:include page='/html/portlet/ext/documentrecord/js/documentrecordValidate.jsp'></liferay-util:include>

<%
	String typeAgenCVDi = (String)renderRequest.getAttribute("typeAgenCVDi");
	String tabCVDi = (String)renderRequest.getAttribute("tabCVDi");
	String redirect = (String)renderRequest.getAttribute("redirect");
	String tabsEdit = (String)renderRequest.getAttribute("tabs");
	
	PmlEdmBookDocumentSend bookRecordSend = (PmlEdmBookDocumentSend)renderRequest.getAttribute("bookRecordSend");
	String documentRecordTypeName = (String)renderRequest.getAttribute("documentRecordTypeName");
	String agencyName = (String)renderRequest.getAttribute("agencyName");
	String departmentName = (String)renderRequest.getAttribute("departmentName");
	long bookRecordSendId = 0;
	if ( null!= bookRecordSend) {
		bookRecordSendId = bookRecordSend.getBookDocumentSendId();
	}
%>


<%
	PortletURL cvdiEditURL = renderResponse.createActionURL();
	cvdiEditURL.setWindowState(WindowState.NORMAL);
	cvdiEditURL.setParameter("struts_action","/sgs/documentrecord/addscvdi");
	cvdiEditURL.setParameter("tabs",tabsEdit);
%>
<form action="<%= cvdiEditURL.toString() %>" method="post" name="<portlet:namespace />fm" onsubmit="return checkCurrentNumberRecord()">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
	<input name="<portlet:namespace />tabCVDi" type="hidden" value="<%= tabCVDi %>" />
	<input name="<portlet:namespace />bookRecordSendId" type="hidden" value="<%= String.valueOf(bookRecordSendId) %>" />
<%
if (("agency".equals(typeAgenCVDi)) && (null!= bookRecordSend)) {
%>
<div class="title_categ"><liferay-ui:message key="cap-nhat-so-van-ban-di"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
  <tr>
    <td width="15%">
    	<label>
    		<liferay-ui:message key="document_record_to_date_create" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input style="width: 50%" readonly type="text" name="<portlet:namespace />dateCreate" id="dateCreate" value='<%=new SimpleDateFormat("dd/MM/yyyy").format(bookRecordSend.getDateCreated()) %>'/>
    </td>
  </tr>
     
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="so-hien-tai" />
    		<font color="#ff0000" size="1">(*)</font>&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 50%" name="<portlet:namespace />currentRecord" id="currentRecord" value="<%= String.valueOf(bookRecordSend.getCurrentRecord()) %>"/>
    </td>
  </tr>
  
  <tr>
    <td>
		<label>
			<liferay-ui:message key="document_record_to_agency" />&nbsp;:
		</label>
	</td>
    <td>
    	<input type="text" readonly="readonly" style="width: 50%" name="<portlet:namespace/>agencyId" value="<%= agencyName %>" >
	</td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="document_record_type" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 50%" readonly name="<portlet:namespace />documentRecordTypeName" id="documentRecordTypeName" value="<%= documentRecordTypeName %>"/>
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="year" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" readonly="readonly" style="width: 50%" name="<portlet:namespace />yearlnUser" id="yearlnUser" value='<%= bookRecordSend.getYearInUse() %>'/>
    </td>
  </tr>
  <tr>
  	<td></td>
  	<td>
  		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	    		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
	    		<input  type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
	    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input  type="button"	value='<liferay-ui:message key="back"/>' /></span>
  	</td>
  </tr>
 </table>
  </div>
<%

} else if (("department".equals(typeAgenCVDi)) && (null!= bookRecordSend)) {
%>
<div class="title_categ"><liferay-ui:message key="cap-nhat-so-van-ban-di"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
  <tr>
    <td width="15%">
    	<label>
    		<liferay-ui:message key="document_record_to_date_create" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input style="width: 50%" readonly type="text" name="<portlet:namespace />dateCreate" id="dateCreate" value='<%=new SimpleDateFormat("dd/MM/yyyy").format(bookRecordSend.getDateCreated()) %>'/>
    </td>
  </tr>
     
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="so-hien-tai" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 50%" name="<portlet:namespace />currentRecord" id="currentRecord" value="<%= String.valueOf(bookRecordSend.getCurrentRecord()) %>"/>
    </td>
  </tr> 
  
  <tr>
    <td>
		<label>
			<liferay-ui:message key="document_record_to_department" />&nbsp;:
		</label>
	</td>
    <td>
    	<input type="text" readonly="readonly" style="width: 50%" name="<portlet:namespace/>agencyId" value="<%= departmentName %>" >
	</td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="document_record_type" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 50%" readonly name="<portlet:namespace />documentRecordTypeName" id="documentRecordTypeName" value="<%= documentRecordTypeName %>"/>
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="year" />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" readonly="readonly" style="width: 50%" name="<portlet:namespace />yearlnUser" id="yearlnUser" value='<%= bookRecordSend.getYearInUse() %>'/>
    </td>
  </tr>
  <tr>
  	<td></td>
  	<td>
  		<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	    		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
	    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
	    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
  	</td>
  	</tr>
 </table>

  </div>
  <% } %>
</form>
