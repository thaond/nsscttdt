
<br/>
<table align="center">
	<%
    for (int i = 0; i < partnerList.size(); i ++) {
   		Partner partner = partnerList.get(i);
    %>
     		
    <tr>
		<td>
			<a href="<%= partner.getUrlPartner() %>" target="<%= partner.getTarget() %>">
				<img width="150px" height="120px" src="<%= themeDisplay.getPathImage() %>/partner_management?img_id=<%= partner.getImageId_liferay() %>" /></a>
		</td>
	</tr>
	
	<tr height="10px"></tr>
        
	<%
	}
	%>
</table>