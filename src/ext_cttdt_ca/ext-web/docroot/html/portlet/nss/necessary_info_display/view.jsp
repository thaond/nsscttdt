<%@ include file="/html/portlet/nss/necessary_info_display/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.necessary_info.model.ThongTinCanThiet"%>
<%@page import="java.util.List"%>
<%
	List<ThongTinCanThiet> thongTinCanThietList = (List<ThongTinCanThiet>)renderRequest.getAttribute("thongTinCanThietList") == null ? new ArrayList<ThongTinCanThiet>() 
				: (List<ThongTinCanThiet>)renderRequest.getAttribute("thongTinCanThietList");
%>
<div class="toptitleleft_no">
<form  name="<portlet:namespace/>fm" action="" method="get">
        <%
       	if ("select".equals(displayStyleInfo)) {
       	%>
      	<select class="listlink" name="jumpMenu" >
        <%
	       	for( int i=0; i < thongTinCanThietList.size(); i++) {
        		ThongTinCanThiet thongTinCanThiet = thongTinCanThietList.get(i);
        %>
        		
       		<option onclick="window.open('<%= thongTinCanThiet.getUrlWebsite() %>','<%= thongTinCanThiet.getTarget() %>');" >
       			<%= thongTinCanThiet.getTenThongTinCanThiet() %>
       		</option>
        <%	
       		}
       	%>
       	</select>
       	<%
       	}
       	else if ("image".equals(displayStyleInfo)) {
       	%>
       	<%
       	for( int i=0; i < thongTinCanThietList.size(); i++) {
    		ThongTinCanThiet thongTinCanThiet = thongTinCanThietList.get(i);
    		String cssClasWT = "info" + i;
        %>
					<div class="<%= cssClasWT %>">
						<a href="<%= thongTinCanThiet.getUrlWebsite() %>"  target="<%= thongTinCanThiet.getTarget() %>">
							<img src='<%= themeDisplay.getPathImage() %>/necessary_info?img_id=<%= thongTinCanThiet.getImageId_liferay() %>' />
						</a>
					</div>
        <%
        	}
       	%>
	    <%
       	} else if ("up".equals(displayStyleInfo) || "right".equals(displayStyleInfo)) {
		%>
		<!-- MoNT start 16/11/2010 -->
		<div  id="<portlet:namespace/>necessary_info_display" style="display: none">
		<div id="<portlet:namespace/>boxinfo">
				<%
				for( int i=0; i < thongTinCanThietList.size(); i++) {
		    		ThongTinCanThiet thongTinCanThiet = thongTinCanThietList.get(i);
		    	%>
						<div class="<portlet:namespace />info" style="display: none">
							<a href="<%= thongTinCanThiet.getUrlWebsite() %>"  target="<%= thongTinCanThiet.getTarget() %>">
								<img width="200px" src='<%= themeDisplay.getPathImage() %>/necessary_info?img_id=<%= thongTinCanThiet.getImageId_liferay() %>' />
							</a>
						</div>
				<%
				}
				%>
		</div>
		</div>
		<script type="text/javascript">
			window.addEvent('load', function() {
				var hVI = null;
				if ('<%= displayStyleInfo %>' == "right") {
					hVI = 'horizontal';
				} else {
					hVI = 'vertical';
				}
				//slider variables for making things easier below
				var itemsHolder = $('<portlet:namespace/>boxinfo');
				var myItems = $$(itemsHolder.getElements('.<portlet:namespace />info'));
				jQuery("#<portlet:namespace/>necessary_info_display").show();
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
		<% }  %>
		
<!-- MoNT end 16/11/2010 -->		
</form>
</div>