
<br/>
<!--  MoNT start 16/11/2010  -->	
<div id="<portlet:namespace/>partner_management" style="display: none"> 
<div id="<portlet:namespace/>boxpartner">
	<%
	if ("horizontal".equals(displayStylePartner) || "vertical".equals(displayStylePartner)) {
	%>
		<%
	    for (int i = 0; i < partnerList.size(); i ++) {
	   		Partner partner = partnerList.get(i);
    	%>
				<div class="<portlet:namespace/>partner">
					<a href="<%= partner.getUrlPartner() %>" target="<%= partner.getTarget() %>">
						<img src="<%= themeDisplay.getPathImage() %>/partner_management?img_id=<%= partner.getImageId_liferay() %>" /></a>
				</div>
		<%
		}
		%>
	
	<script type="text/javascript">
		window.addEvent('load', function() {
			var hVP = null;
			if ('<%= displayStylePartner %>' == "horizontal") {
				hVP = 'horizontal';
			} else {
				hVP = 'vertical';
			}
			//slider variables for making things easier below
			var itemsHolder = $('<portlet:namespace/>boxpartner');
			var myItems = $$(itemsHolder.getElements('.<portlet:namespace/>partner'));
			
			/* MoNT start 16/11/2010 */	
			jQuery("#<portlet:namespace/>partner_management").show();
			for(var i=0;i<myItems.length;i++){
				jQuery(myItems[i]).show();
			}
			/* MoNT end 16/11/2010 */
			
			//create instance of the slider, and start it up		
			
				var mySliderP = new SL_Slider({
					slideTimer: 4000,				// thoi gian chay, so cang nho chay cang nhanh
					orientation: hVP,     	// vertical, horizontal, or none: None will create a fading in/out transition.
					fade: true,                    	// if true will fade the outgoing slide - only used if orientation is != None
					isPaused: false,
					container: itemsHolder,
					items: myItems
				});
				mySliderP.start();		
			});
	</script>
	<% }  %>
	
</div>
</div>
 <!-- MoNT end 16/11/2010 --> 