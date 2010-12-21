<%@ include file="/html/portlet/nss/contact/init.jsp" %>
<div class="boxsupport">
<p class="titlecont"><liferay-ui:message key="nss-ho-tro-truc-tuyen" /></p>
<div class="bottomsupport">
 	<div class="contentsupport">
          	<div class="supp">
			<ul>
		     	<logic:iterate id="hoTroTrucTuyen" name="attHoTroTrucTuyen"
					type="com.nss.portlet.contact.model.HoTroTrucTuyen" scope="request" indexId="i">
		
				     	<li><a href="<%=hoTroTrucTuyen.getLink() %>"><img src="/html/images/<%=hoTroTrucTuyen.getImageUrl() %>" align="absbottom" /></a> 
				  		<a href="<%=hoTroTrucTuyen.getLink() %>"><%=hoTroTrucTuyen.getTen() %></a></li>
		    	
		    	</logic:iterate>
    		</ul>
    		</div>
    	</div>
	</div>
</div>