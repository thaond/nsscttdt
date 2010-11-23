
<select class="listlink" name="jumpMenu" >
    <option value="#">--------- <liferay-ui:message key="nss-chon-doi-tac" /> ---------</option>
   	<%
    for (int i = 0; i < partnerList.size(); i ++) {
   		Partner partner = partnerList.get(i);
    %>
       		
		<option onclick="window.open('<%= partner.getUrlPartner() %>','<%= partner.getTarget() %>');" >
    		<%= partner.getTenPartner() %>
   		</option>
   		
    <%	
    }
    %>
</select>