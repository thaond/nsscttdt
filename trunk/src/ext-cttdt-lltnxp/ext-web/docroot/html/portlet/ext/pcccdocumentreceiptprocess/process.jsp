<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pcccdocumentreceiptprocess-js.jsp"/>
<!-- form chuyen cong van den ban giam doc -->
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<portlet:actionURL var="form" ></portlet:actionURL>
<%
	User loginUser = PortalUtil.getUser(renderRequest); 
	String senderId = String.valueOf(loginUser.getUserId());
%>

<form name="<portlet:namespace/>form"  method="post" action="<%=form%>" onsubmit="return checknguoinhan();">
<div class="title_categ"><liferay-ui:message key="pccc-XL-xulyhoso"/></div>
<div class="boxcontent">
<fieldset class="filnoborder_div">
<table cellspacing="0" width="100%" >
	<tr>
      <td>
      	<div align="left" style="font-style: italic; font-size: small; font-weight: bold;">
      		<liferay-ui:message key="pccc-DRP-phancongconvanden"/>
      	</div>
      </td>
    	<td>
    	<div align="left" style="font-style: italic; font-size: small; font-weight: bold;">
      		<liferay-ui:message key="pccc-DRP-thongtinchitietcvd"/>
      	</div>
      	</td>
  	</tr>
</table>
</fieldset>
<br>
<fieldset class="filnoborder_div">
<table cellspacing="0" width="100%" >
    <tr>
    <td colspan="2">
    	<div align="center" style="font-style: italic; font-size: small; font-weight: bold;">
      		<liferay-ui:message key="pccc-DRP-chuyencongvandenbgd"/>
      	</div>
    </td>
    <td><liferay-ui:message key="pccc-DRP-ngaybatdau"/> :   </td>
    <td>
    <%=new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>
     <input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processor" value="<%= senderId %>">
    </td>   
  </tr>
   
  <tr>
    <td><div align="right">
      <liferay-ui:message key="pccc-DRP-noidungxuly"/>
      :</div></td>
    <td rowspan="3">
      <textarea name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>processInformation" id="thongTinXuLy" rows="5" style="width: 97%;"></textarea></td>    
  </tr>
   <tr>
    <td><div align="right">
      <liferay-ui:message key="pccc-DRP-chuyenden"/>
      <font color="red">(*)</font>:</div></td>
  </tr>
  <tr class="bgdocsend-table-footer">
    <td></td>
    <td align="center" rowspan="5">
      <liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
      <input type="reset" class="button-width" value='<liferay-ui:message key="reset"/>'>
      <a onClick="window.history.back()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'></a></td>   
  </tr>
</table>
</fieldset>
</div>
</form>