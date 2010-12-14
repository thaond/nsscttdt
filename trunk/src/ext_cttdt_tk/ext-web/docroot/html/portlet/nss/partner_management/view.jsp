<%@ include file="/html/portlet/nss/partner_management/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.partner.model.Partner"%>

<style type="text/css">
#<portlet:namespace/>boxpartner{
	position: relative; 
	float: left; 
	width: 660px; 
	height: 95px;
}

.<portlet:namespace/>partner {
	padding-top: 5px;
	padding-right: 0px;
	padding-bottom: 5px;
	padding-left: 0px;
	float: left;
	width: 660px;
}
</style>

<%
	List<Partner> partnerList = (List<Partner>)renderRequest.getAttribute("partnerList") == null ? 
								new ArrayList<Partner>() : (List<Partner>)renderRequest.getAttribute("partnerList");
%>


<div class="boxnews parimg">
    <form name="<portlet:namespace />fm" action="" method="post">
		<c:choose>
			<c:when test='<%= "select".equals(displayStylePartner) %>'>
				<%@ include file="/html/portlet/nss/partner_management/view_select.jsp" %>
			</c:when>
			<c:when test='<%= "image".equals(displayStylePartner) %>'>
				<%@ include file="/html/portlet/nss/partner_management/view_image.jsp" %>
			</c:when>
			<c:when test='<%= "vertical".equals(displayStylePartner)|| "horizontal".equals(displayStylePartner) %>'>
				<%@ include file="/html/portlet/nss/partner_management/view_up_left.jsp" %>
			</c:when>
		</c:choose>
    </form>
</div>

