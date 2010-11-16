<%@ include file="/html/portlet/nss/contact/init.jsp" %>

<div class="boxsupport">
<div class="bottomsupport">
 	<div class="contentsupport">
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