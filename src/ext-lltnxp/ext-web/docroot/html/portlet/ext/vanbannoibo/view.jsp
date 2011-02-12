<%@ include file="/html/portlet/ext/vanbannoibo/init.jsp" %>

<c:choose>
	<c:when test='<%= actionVanBanNoiBo.equals("tiepNhan") %>'>
			<%@ include file="/html/portlet/ext/vanbannoibo/tiepnhanvanbannoibo/tiepnhanvanbannoibo.jsp" %>						
	</c:when>
	<c:when test='<%= actionVanBanNoiBo.equals("xuLy") %>'>
			<%@ include file="/html/portlet/ext/vanbannoibo/xulyvanbannoibo/xulyvanbannoibo.jsp" %>						
	</c:when>
	<c:when test='<%= actionVanBanNoiBo.equals("traCuu") %>'>
			<%@ include file="/html/portlet/ext/vanbannoibo/tracuuvanbannoibo/tracuuvanbannoibo.jsp" %>						
	</c:when>
	<c:when test='<%= actionVanBanNoiBo.equals("baoCao") %>'>
			<%@ include file="/html/portlet/ext/vanbannoibo/baocaovanbannoibo/baocaovanbannoibo.jsp" %>						
	</c:when>
</c:choose>