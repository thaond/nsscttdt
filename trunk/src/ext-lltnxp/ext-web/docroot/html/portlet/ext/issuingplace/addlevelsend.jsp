<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@ include file="/html/portlet/ext/issuingplace/init.jsp" %>

<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.issuingplace.search.LevelSendSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sgs.portlet.issuingplace.util.LevelSendChecker"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<script type="text/javascript">
	
	function <portlet:namespace/>updateLevelSend() {
		document.<portlet:namespace/>fm.<portlet:namespace/>addDetailIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		document.<portlet:namespace/>fm.<portlet:namespace/>removeDetailIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace/>fm, "<portlet:namespace/>allRowIds");
		submitForm(document.<portlet:namespace />fm);
	}
	
</script>

<%
	List<PmlEdmLevelSend> listlevelsend = (List<PmlEdmLevelSend>)renderRequest.getAttribute("listlevelsend");

	String issuingPlaceId = (String) renderRequest.getAttribute("issuingPlaceId");
	String redirect = (String) ParamUtil.getString(renderRequest, "redirect");
	String redirect_view = (String) ParamUtil.getString(renderRequest, "redirect_view");
%>

<%
	PortletURL portletURLLevelSend = renderResponse.createActionURL();
	portletURLLevelSend.setWindowState(WindowState.NORMAL);
	portletURLLevelSend.setParameter("struts_action","/sgs/issuingplace/addlevelsend");
	portletURLLevelSend.setParameter("issuingPlaceId", issuingPlaceId);
//	minh update 20101113
//	portletURLLevelSend.setParameter("redirect", redirect);
//	end minh update 20101113
%>
<%
		LevelSendSearch levelSendSearch = new LevelSendSearch(renderRequest,portletURLLevelSend);
		portletURLLevelSend.setParameter(levelSendSearch.getCurParam(), String.valueOf(levelSendSearch.getCurValue()));
		
// minh update 20101113
		List<PmlEdmLevelSend> resLevelSend = new ArrayList<PmlEdmLevelSend>();	
		try {
			resLevelSend = PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSends(levelSendSearch.getStart(), levelSendSearch.getEnd());
		} catch (Exception e) {}
// end minh update 20101113		

		RowChecker rowChecker = new LevelSendChecker(renderResponse,issuingPlaceId);
		levelSendSearch.setRowChecker(rowChecker);
// minh update 20101113		
//		levelSendSearch.setResults(listlevelsend);
		levelSendSearch.setResults(resLevelSend);
// end minh update 20101113		
		levelSendSearch.setTotal(listlevelsend.size());
		portletURLLevelSend.setParameter("redirect_view", redirect_view);
	%>

<form  name="<portlet:namespace />fm" action="<%=portletURLLevelSend.toString() %>" method="post"  >
<div class="boxcontent">
	<input name="<%= Constants.CMD %>"  type="hidden" value="<%= Constants.ADD %>"/>
	<input name="<portlet:namespace/>addDetailIds"  type="hidden" value=""/>
	<input name="<portlet:namespace/>removeDetailIds"  type="hidden" value=""/>
	
	<%
		List resultRows = levelSendSearch.getResultRows();
		ResultRow row = null;
		PmlEdmLevelSend levelSend = null;
	
// minh update 20101113		
		//for( int i=0; i< listlevelsend.size(); i++) {
		//	levelSend = listlevelsend.get(i);
// end minh update 20101113		
		for( int i=0; i< resLevelSend.size(); i++) {
			levelSend = resLevelSend.get(i);
			levelSend = levelSend.toEscapedModel();
			row = new ResultRow(levelSend, levelSend.getLevelSendId(), i);
			
			//STT
			row.addText(String.valueOf(i+1));
			//Ten cap cong van
			row.addText(levelSend.getLevelSendName());
			
			resultRows.add(row);
			
		}
	%>
	
	<liferay-ui:search-iterator searchContainer="<%=levelSendSearch %>" />
	<table id="table-button">
		<tbody>
			<tr>
				<td>
	    		<input class="button" type="submit" name="button" onclick="<portlet:namespace/>updateLevelSend()" value="<liferay-ui:message key='update' />" /> 
	    		<input class="button" type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect_view %>');"><input class="button" type="button" value='<liferay-ui:message key="back"/>' /></span>
			 </td>
			</tr>
		</tbody>
	</table>
	</div>
</form>
