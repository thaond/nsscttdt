<%@ include file="/html/portlet/nss/adv_display/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.adv.model.QuangCao"%>

<%
	List<QuangCao> quangCaoList = (List<QuangCao>)renderRequest.getAttribute("quangCaoList") == null ? new ArrayList<QuangCao>() 
				: (List<QuangCao>)renderRequest.getAttribute("quangCaoList");
%>

<div class="advr">
<form  name="<portlet:namespace/>fm" action="" method="get">
        <%
       	if ("select".equals(displayStyleAdv)) {
       	%>
      	<select class="listlink" name="jumpMenu" >
        <%
	       	for( int i=0; i < quangCaoList.size(); i++) {
        		QuangCao quangCao = quangCaoList.get(i);
        %>
        		
       		<option onclick="window.open('<%= quangCao.getUrlWebsite() %>','<%= quangCao.getTarget() %>');" >
       			<%= quangCao.getTenQuangCao() %>
       		</option>
        <%	
       		}
       	%>
       	</select>
       	<%
       	}
       	else if ("image".equals(displayStyleAdv)) {
       	%>

       	<%
       	for( int i=0; i < quangCaoList.size(); i++) {
    		QuangCao quangCao = quangCaoList.get(i);
        %>
					<div class="listadv">
						<a href="<%= quangCao.getUrlWebsite() %>"  target="<%= quangCao.getTarget() %>">
							<img src='<%= themeDisplay.getPathImage() %>/adv?img_id=<%= quangCao.getImageId_liferay() %>' />
						</a>
					</div>
        <%
        	}
       	%>

	    <%
       	} else if ("up".equals(displayStyleAdv) || "right".equals(displayStyleAdv)) {
		%>
<!-- MoNT start 16/11/2010 -->
		<div id="<portlet:namespace/>adv_display" style="display: none">
				<%
				for( int i=0; i < quangCaoList.size(); i++) {
		    		QuangCao quangCao = quangCaoList.get(i);
		    	%>
						<div class="listadv">
							<a href="<%= quangCao.getUrlWebsite() %>"  target="<%= quangCao.getTarget() %>">
								<img src='<%= themeDisplay.getPathImage() %>/adv?img_id=<%= quangCao.getImageId_liferay() %>' />
							</a>
						</div>
				<%
				}
				%>
		</div>
		<script type="text/javascript">
			window.addEvent('load', function() {
				var hVI = null;
				if ('<%= displayStyleAdv %>' == "right") {
					hVI = 'horizontal';
				} 
				else {
					hVI = 'vertical';
				}
				//slider variables for making things easier below
				var itemsHolder = $('<portlet:namespace/>boxadv');
				var myItems = $$(itemsHolder.getElements('.<portlet:namespace />adv'));
				jQuery("#<portlet:namespace/>adv_display").show();
				for(var i=0;i<myItems.length;i++){
					jQuery(myItems[i]).show();
				}
				//create instance of the slider, and start it up		
					var mySliderI = new SL_Slider({
						slideTimer: 4000,				// thoi gian chay, so cang nho chay cang nhanh
						orientation: hVI,     	// vertical, horizontal, or none: None will create a fading in/out transition.
						fade: true,                    	// if true will fade the outgoing slide - only used if orientation is != None
						isPaused: false,
						container: itemsHolder,
						items: myItems
					});
					mySliderI.start();
								 
			});
		</script>
		<% } %>
		
</form>
</div>
<!-- MoNT end 16/11/2010 -->