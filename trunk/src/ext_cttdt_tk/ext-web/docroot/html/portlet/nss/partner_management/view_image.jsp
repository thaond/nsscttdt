	<%
    for (int i = 0; i < partnerList.size(); i ++) {
   		Partner partner = partnerList.get(i);
    %>
			<a href="<%= partner.getUrlPartner() %>" target="<%= partner.getTarget() %>">
				<img style="margin-bottom: 3px;" src="<%= themeDisplay.getPathImage() %>/partner_management?img_id=<%= partner.getImageId_liferay() %>" /></a>
	<%
	}
	%>
