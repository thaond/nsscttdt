<%@ include file="/html/portlet/ext/processtype/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/processtype/js/pccc-docreceipt.jsp" ></liferay-util:include>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	ProcessType processtype = (ProcessType) renderRequest.getAttribute("processType");	
%>

<form action="<portlet:actionURL ><portlet:param name="struts_action" value="/ext/processtype/view"/></portlet:actionURL>" 
 name="<portlet:namespace />fm" method="post" onsubmit="return test();">
<div class="title_categ"><liferay-ui:message key="javax.portlet.title.PROCESSTYPE"/></div>
<div class="boxcontent">

<input type="hidden" name="<portlet:namespace />cmd" id="<portlet:namespace />cmd" value="view"> 
<input type="hidden" name="processTypeId" id="processTypeId" value=""> 

<table id="addprocesstype" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
	<tr class="portlet-section-header results-header" >
		<td width="30px" align="center">#</td>
		<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
		<td width="70%"><liferay-ui:message key="ten"/></td>
		<td width="10%" align="center"><liferay-ui:message key="recordtype.code"/></td>
		<td align="center"></td>
	</tr>
	<logic:iterate id="listprocesstype" name="listprocesstype" indexId="i" type="com.ext.portlet.processtype.model.ProcessType" scope="request" >
	<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
		<td>
			<span>
				<input type="radio"  name="chk" id="<portlet:namespace />chk<%=listprocesstype.getProcessTypeId() %>" value="" style="text-align: center;" />
			</span>
		</td>
		<td align="center"><div id="stt"><%=i+1 %>.</div></td>
		<td id='fileTypeId' >
			<div id="processTypeName<%= listprocesstype.getProcessTypeId() %>">
				<%=listprocesstype.getName()%>
			</div>
			<div id="editProcessTypeName<%= listprocesstype.getProcessTypeId() %>" style="display: none;" >
				<input name="processTypeName_<%=listprocesstype.getProcessTypeId() %>" style="width: 95%" id="hiddenProcessTypeName<%= listprocesstype.getProcessTypeId() %>" 
					type="text" value="<%= listprocesstype.getName()%>" /> 
			</div>
		</td>
		
		<td align="center">
			<div id="processTypeFlag<%= listprocesstype.getProcessTypeId() %>">
				<%=listprocesstype.getFlagProcessType() %>
			</div>
			<div id="editProcessTypeFlag<%= listprocesstype.getProcessTypeId() %>" style="display: none;" >
				<select style="width: 60%" id="hiddenProcessTypeFlag<%= listprocesstype.getProcessTypeId() %>" name="hiddenProcessTypeFlag_<%= listprocesstype.getProcessTypeId() %>" >
					<option value="1" <%= listprocesstype.getFlagProcessType() == 1 ? "selected" : "" %>> 1</option>			
					<option value="2" <%= listprocesstype.getFlagProcessType() == 2 ? "selected" : "" %>> 2</option>			
					<option value="3" <%= listprocesstype.getFlagProcessType() == 3 ? "selected" : "" %>> 3</option>			
				</select>
			</div>
		</td>
		
		<td align="center">
			<div id="current<%= listprocesstype.getProcessTypeId() %>">
				<img class="image-edit" src="/html/images/edit.png" onclick="<portlet:namespace />editProcessType(<%= listprocesstype.getProcessTypeId() %>);">
				<img class="image-edit" src="/html/images/delete.png" onclick="<portlet:namespace />deleteProcessType(this.parentNode.parentNode.parentNode.rowIndex, <%=listprocesstype.getProcessTypeId() %>);"/>
			</div>
		
			<div id="edit<%= listprocesstype.getProcessTypeId() %>" style="display: none;">
				<img class="image-edit" src="/html/images/image-save.png" onclick="<portlet:namespace />updateProcessType(<%= listprocesstype.getProcessTypeId() %>);">
				<img class="image-edit" src="/html/images/image-cancel.png" onclick="<portlet:namespace />cancel(<%=listprocesstype.getProcessTypeId() %>);"/>
			</div>
		</td>
		
	</tr>
	</logic:iterate>
	</table>
<div id ="table-button" align="right">
		<portlet:renderURL var="redirect">
			<portlet:param name="struts_action"
					value="/ext/processtype/view" />
		</portlet:renderURL>
			<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect %>">
		    <input type="button" id="addprocesstypebtn" onclick="addnewprocesstype()" value='<liferay-ui:message key="recordtype.add" />'>
</div>
</div>
</form>
<%
Boolean flag = (Boolean) renderRequest.getAttribute("flag");
Boolean flagUpdate = (Boolean) renderRequest.getAttribute("flagUpdate") == null ? false : true;

if (flag != null && flag) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='them-cach-thuc-xu-ly-thanh-cong'/>");
	</script>

<%
}
if (flagUpdate) {
%>
	<script type="text/javascript" >	
		alert("<liferay-ui:message key='cap-nhat-thanh-cong'/>");
	</script>
<%
} 
%>
