<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.agency.model.Agency"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"%>
<%@page import="javax.portlet.PortletURL"%>
<liferay-util:include page='/html/portlet/ext/documentrecord/js/documentrecordValidate.jsp'></liferay-util:include>

<script type="text/javascript">
	function checkExitBookRecordType(url){
		submitForm(document.<portlet:namespace />fm,url);
	}

</script>

<%
	String typeAgenCVDi = renderRequest.getParameter("typeAgenCVDi");
	String tabCVDi = renderRequest.getParameter("tabCVDi");
	String tabsSoCV = renderRequest.getParameter("tabs");
	String redirect = renderRequest.getParameter("redirect");
	String agencyId = (String)renderRequest.getParameter("agencyId")== null ? "" : (String)renderRequest.getParameter("agencyId");
	String departmentId = (String)renderRequest.getParameter("departmentId")== null ? "" : (String)renderRequest.getParameter("departmentId");
	String yearInUse = (String)renderRequest.getParameter("yearInUse")== null ? "" : (String)renderRequest.getParameter("yearInUse");
	String currentRecord = (String)renderRequest.getParameter("currentRecord")== null ? "" : (String)renderRequest.getParameter("currentRecord");
	
	List<Department> departmentList = (List<Department>)renderRequest.getAttribute("departmentList")== null ? new ArrayList<Department>() : (List<Department>)renderRequest.getAttribute("departmentList");
	List<Agency> agencyList = (List<Agency>)renderRequest.getAttribute("agencyList")== null ? new ArrayList<Agency>() : (List<Agency>)renderRequest.getAttribute("agencyList");
	List<PmlEdmDocumentRecordType> listDocumentRecordType = (List<PmlEdmDocumentRecordType>) renderRequest.getAttribute("listDocumentRecordType")== null ?  new ArrayList<PmlEdmDocumentRecordType>(): (List<PmlEdmDocumentRecordType>) renderRequest.getAttribute("listDocumentRecordType"); 
	List<PmlEdmBookDocumentSend> listBookDocumentSend = (List<PmlEdmBookDocumentSend>) renderRequest.getAttribute("listBookDocumentSend")== null ?  new ArrayList<PmlEdmBookDocumentSend>(): (List<PmlEdmBookDocumentSend>) renderRequest.getAttribute("listBookDocumentSend"); 
%>

<portlet:actionURL var="add" >
	<portlet:param name="struts_action" value="/sgs/documentrecord/addscvdi"/>
	<portlet:param name="tabCVDi" value="<%= tabCVDi %>"/>
	<portlet:param name="tabs" value="<%= tabsSoCV %>"/>
</portlet:actionURL>
<form action="<%= add %>" method="post" name="<portlet:namespace />fm" onsubmit="return checkCurrentRecord()" >
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= "ADD_SO_CVDI" %>" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
	<input name="<portlet:namespace />typeAgenCVDi" type="hidden" id="typeAgen" value="<%= typeAgenCVDi %>" />
<div class="title_categ"><liferay-ui:message key="them-so-van-ban-di"/></div>
<div class="boxcontent">
	<input type="hidden" name="<portlet:namespace/>listBookDocument"/>	
<table cellspacing="0" width="100%">
  <tr>
    <td width="15%">
    	<label>
    		<liferay-ui:message key="book_document_send_date_create" />&nbsp;:
    	</label>
    </td>
     <td>
    	<input type="text" readonly style="width: 50%" name="<portlet:namespace />dateCreate" id="dateCreate" value='<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>'/>
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
    	<input type="text" style="width: 50%" name="<portlet:namespace />currentRecord" id="currentRecord" value="<%= currentRecord %>" />
    </td>
   </tr>
   
<% if ("agency".equals(typeAgenCVDi)) { %>
	<tr>
	    <td>
	    	<label>
	    		<liferay-ui:message key="book_document_send_agency" />
	    		<font color="#ff0000" size="1">(*)</font>&nbsp;:
	    	</label>
	    </td>
	    <td>
	        <select style="width: 51%"  name="<portlet:namespace/>agencyId" id="agencyId"> 
	        	<option selected="selected">[<liferay-ui:message key="select" />]</option>
	        	<logic:iterate id="agency" name="agencyList" indexId="i" type="com.sgs.portlet.agency.model.Agency" scope="request" >
	        		<%
		    			PortletURL agencyURLOption = renderResponse.createRenderURL();
			        	agencyURLOption.setParameter("struts_action", "/sgs/documentrecord/addscvdi");
			        	agencyURLOption.setParameter(Constants.CMD,"CHOICE");
			        	agencyURLOption.setParameter("redirect",redirect);
			        	agencyURLOption.setParameter("tabCVDi",tabCVDi );
			        	agencyURLOption.setParameter("tabs",tabsSoCV);
			        	agencyURLOption.setParameter("typeAgenCVDi",typeAgenCVDi);
	    			%>
	        		<option onclick="checkExitBookRecordType('<%= agencyURLOption.toString() %>')" value="<%=agency.getAgencyId() %>" <%= agencyId.equals(agency.getAgencyId()) ? "selected" : "" %>><%=agency.getAgencyName() %></option>
	        	</logic:iterate>
			</select>   
		</td>


<% } else if ("department".equals(typeAgenCVDi)) { %>
	<tr>
	    <td>
	    	<label>
	    			<liferay-ui:message key="book_document_send_department" />
	    			<font color="#ff0000" size="1">(*)</font>&nbsp;:
	    	</label>
	    </td>
	    <td>
	        <select style="width: 51%"  name="<portlet:namespace/>departmentId" id="departmentId"> 
	        	<option selected="selected">[<liferay-ui:message key="select" />]</option>
	        	<logic:iterate id="department" name="departmentList" indexId="i" type="com.sgs.portlet.department.model.Department" scope="request">
	        		<%
		    			PortletURL departmentURLOption = renderResponse.createRenderURL();
			        	departmentURLOption.setParameter("struts_action", "/sgs/documentrecord/addscvdi");
			        	departmentURLOption.setParameter(Constants.CMD,"CHOICE");
			        	departmentURLOption.setParameter("redirect",redirect);
			        	departmentURLOption.setParameter("tabCVDi",tabCVDi );
			        	departmentURLOption.setParameter("tabs",tabsSoCV);
			        	departmentURLOption.setParameter("typeAgenCVDi",typeAgenCVDi);
	    			%>
	        		<option onclick="checkExitBookRecordType('<%= departmentURLOption.toString() %>')" value="<%=department.getDepartmentsId() %>" <%= departmentId.equals(department.getDepartmentsId()) ? "selected" : "" %>><%=department.getDepartmentsName() %></option>
	        	</logic:iterate>
			</select>	       	      
		</td>
 	</tr>
<% } %>

	<tr>
	    <td valign="top">
	    	<label>
	    		<liferay-ui:message key="document_record_type" />
	    		<font color="#ff0000" size="1">(*)</font>&nbsp;:
	    	</label>
	    </td>
	    
	    <td>
	    	<div id="idParent_1" class="table-list-border">
	    	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="results-header-Scrollbar" >
						<td width="45px" align="center">
						<input class="styled" type="checkbox" onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<portlet:namespace/>documentRecordTypes', this);"
							name="checkallbox" id="checkallbox"/>
						</td>
						<td><liferay-ui:message key="all" /></td>
					</tr>
					</table>	
					<div class="Scrollbarauto">
					<table cellspacing="0" width="100%" class="taglib_Scrollbar table-pml">
					<logic:iterate  id="documentrecordtype" name="listDocumentRecordType" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request" indexId="k">
						
						<%
							String check = "";
							
							for (int i = 0; i < listBookDocumentSend.size(); i++) {
								if ((int) documentrecordtype.getDocumentRecordTypeId() == listBookDocumentSend.get(i).getDocumentRecordTypeId()) {
									check = "checked=checked";
									break;
								}
							}
						%>
						
							<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'} " >
								<td align="center" id="<%= k %>" width="45px">
									<input class="styled" type="checkbox" onclick="Liferay.Util.checkAllBox(<portlet:namespace />fm,'<portlet:namespace/>documentRecordTypes', checkallbox);"
										<%= check %> name="<portlet:namespace/>documentRecordTypes" id="<%= k %>" value="<%= documentrecordtype.getDocumentRecordTypeId()%>" />
								</td>
								<td><%=  documentrecordtype.getDocumentRecordTypeName() %></td>
							</tr>
						</logic:iterate>
					</table>
				</div>
	    </td>
	</tr>
	
	<tr>
	    <td>
	    	<label>
	    		<liferay-ui:message key="book_document_send_yearln_user" />&nbsp;:
	    	</label>
	    </td>
	    <td>
	    	<input style="width: 50%" readonly="readonly" type="text" name="<portlet:namespace />yearInUse" id="yearInUse" value='<%= new SimpleDateFormat("yyyy").format(new Date()) %>'/>
	    </td>
    </tr>
    
	<tr>
		<td></td>
	    <td > 
    		<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="save" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
	    </td>
	</tr>
</table>

	<c:if test="<%= (listBookDocumentSend.size() == listDocumentRecordType.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
	</c:if>
</div>
</form>