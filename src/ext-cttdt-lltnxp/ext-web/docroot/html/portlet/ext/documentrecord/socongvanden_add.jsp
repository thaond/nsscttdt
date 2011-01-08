<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.agency.model.Agency"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo"%>
<liferay-util:include page='/html/portlet/ext/documentrecord/js/documentrecordValidate.jsp'></liferay-util:include>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<script type="text/javascript">
	function checkExitDocumentRecordType(url){
		submitForm(document.<portlet:namespace />fm,url);
	}

</script>

<%	
	String typeAgen = renderRequest.getParameter("typeAgen");
	String tabCVDens = renderRequest.getParameter("tabCVDens");
	String tabs = renderRequest.getParameter("tabs");
	String redirect = renderRequest.getParameter("redirect");
	String agencyId = (String)renderRequest.getParameter("agencyId")== null ? "" : (String)renderRequest.getParameter("agencyId");
	String departmentId = (String)renderRequest.getParameter("departmentId")== null ? "" : (String)renderRequest.getParameter("departmentId");
	String yearInUse = (String)renderRequest.getParameter("yearInUse")== null ? "" : (String)renderRequest.getParameter("yearInUse");
	String currentRecord = (String)renderRequest.getParameter("currentRecord")== null ? "" : (String)renderRequest.getParameter("currentRecord");

	PortletURL  portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action","/sgs/documentrecord/addscvden" );
	portletURL.setParameter("tabCVDens",tabCVDens );
	portletURL.setParameter("tabs",tabs);
	
%>

<%
	
	List<Department> departmentList = (List<Department>)renderRequest.getAttribute("departmentList")== null ? new ArrayList<Department>() : (List<Department>)renderRequest.getAttribute("departmentList");
	List<Agency> agencyList = (List<Agency>)renderRequest.getAttribute("agencyList")== null ? new ArrayList<Agency>() : (List<Agency>)renderRequest.getAttribute("agencyList");
	List<PmlEdmDocumentRecordType> listDocumentRecordType = (List<PmlEdmDocumentRecordType>) renderRequest.getAttribute("listDocumentRecordType")== null ?  new ArrayList<PmlEdmDocumentRecordType>(): (List<PmlEdmDocumentRecordType>) renderRequest.getAttribute("listDocumentRecordType");
	List<PmlEdmDocumentRecordTo> listDocumentRecordTo = (List<PmlEdmDocumentRecordTo>) renderRequest.getAttribute("listDocumentRecordTo")== null ?  new ArrayList<PmlEdmDocumentRecordTo>(): (List<PmlEdmDocumentRecordTo>) renderRequest.getAttribute("listDocumentRecordTo");
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace/>fm" onsubmit="return checkCurrentRecord()">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= "ADD_SO_CVDEN" %>" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
	<input name="<portlet:namespace />typeAgen" type="hidden" id="typeAgen" value="<%= typeAgen %>" />
<div class="title_categ"><liferay-ui:message key="them-so-van-ban-den"/></div>
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
    	<input style="width: 50%" type="text" class="input-pml" name="<portlet:namespace />currentRecord" id="currentRecord" value="<%= currentRecord %>" />
    </td>
   </tr>
   
<% if ("agency".equals(typeAgen)) { %>
	<tr>
	    <td>
	    	<label>
	    		<liferay-ui:message key="book_document_send_agency" />
	    			<font color="#ff0000" size="1">(*)</font>&nbsp;:
	    	</label>
	    </td>
	    <td>
	        <select style="width: 51%"  name="<portlet:namespace/>agencyId" id="agencyId" > 
	        	<option selected="selected">[<liferay-ui:message key="select" />]</option>
	        	<logic:iterate id="agency" name="agencyList" indexId="i" type="com.sgs.portlet.agency.model.Agency" scope="request" >
	        	<%
	    			PortletURL agencyURLOption = renderResponse.createRenderURL();
		        	agencyURLOption.setParameter("struts_action", "/sgs/documentrecord/addscvden");
		        	agencyURLOption.setParameter(Constants.CMD,"CHOICE");
		        	agencyURLOption.setParameter("redirect",redirect);
		        	agencyURLOption.setParameter("tabCVDens",tabCVDens );
		        	agencyURLOption.setParameter("tabs",tabs);
		        	agencyURLOption.setParameter("typeAgen",typeAgen);
	    		%>
	        		<option onclick="checkExitDocumentRecordType('<%= agencyURLOption.toString() %>')" value="<%=agency.getAgencyId() %>" <%= agencyId.equals(agency.getAgencyId()) ? "selected" : "" %>><%=agency.getAgencyName() %></option>
	        	</logic:iterate>
			</select>   
		</td>
	</tr>


<% } else if ("department".equals(typeAgen)) { %>
	<tr>
	    <td>
	    	<label>
	    			<liferay-ui:message key="book_document_send_department" />
	    				<font color="#ff0000" size="1">(*)</font>&nbsp;:
	    	</label>
	    </td>
	    <td>
	        <select style="width: 51%" name="<portlet:namespace/>departmentId" id="departmentId"> 
	        	<option selected="selected">[<liferay-ui:message key="select" />]</option>
	        	<logic:iterate id="department" name="departmentList" indexId="i" type="com.sgs.portlet.department.model.Department" scope="request">
	        	<%
	    			PortletURL departmentURLOption = renderResponse.createRenderURL();
		        	departmentURLOption.setParameter("struts_action", "/sgs/documentrecord/addscvden");
		        	departmentURLOption.setParameter(Constants.CMD,"CHOICE");
		        	departmentURLOption.setParameter("redirect",redirect);
		        	departmentURLOption.setParameter("tabCVDens",tabCVDens );
		        	departmentURLOption.setParameter("tabs",tabs);
		        	departmentURLOption.setParameter("typeAgen",typeAgen);
	    		%>
	        		<option onclick="checkExitDocumentRecordType('<%= departmentURLOption.toString() %>')" value="<%=department.getDepartmentsId() %>" <%= departmentId.equals(department.getDepartmentsId()) ? "selected" : "" %>><%=department.getDepartmentsName() %></option>
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
							
							for (int i = 0; i < listDocumentRecordTo.size(); i++) {
								if ((int) documentrecordtype.getDocumentRecordTypeId() == listDocumentRecordTo.get(i).getDocumentRecordTypeId()) {
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
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
	    </td>
	</tr>
    </table>
	<c:if test="<%= (listDocumentRecordTo.size() == listDocumentRecordType.size()) %>">
		<script type="text/javascript">
			document.<portlet:namespace />fm.checkallbox.checked = true;
		</script>
	</c:if>
</div>
</form>
