<%@ include file="/html/portlet/nss/necessary_info_display/init.jsp" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.necessary_info.model.ThongTinCanThiet"%>
<%@page import="java.util.List"%>
<style type="text/css">
#<portlet:namespace/>boxinfo{
	position: relative; 
	/*float: left;*/ 
	width: 190px; 
	height: 150px;
}

.<portlet:namespace />info {
	padding-top: 5px;
	padding-right: 0px;
	padding-bottom: 5px;
	padding-left: 0px;
	/*float: left;*/
	width: 190px;
}
</style>

<%
	List<ThongTinCanThiet> thongTinCanThietList = (List<ThongTinCanThiet>)renderRequest.getAttribute("thongTinCanThietList") == null ? new ArrayList<ThongTinCanThiet>() 
				: (List<ThongTinCanThiet>)renderRequest.getAttribute("thongTinCanThietList");
%>

<div  id="<portlet:namespace/>necessary_info_display" style="display: none">
<div class="toptitleleft">
    <h3><liferay-ui:message key="nss-thong-tin-can-biet" /></h3>
    <div class="btmtitleleft">
    	<div class="ctrtitleleft">
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
       	<table cellspacing="0" width="100%">
       	<%
       	for( int i=0; i < thongTinCanThietList.size(); i++) {
    		ThongTinCanThiet thongTinCanThiet = thongTinCanThietList.get(i);
        %>
		
     		<tr>
				<td>
					<div class="<portlet:namespace />info">
						<a href="<%= thongTinCanThiet.getUrlWebsite() %>"  target="<%= thongTinCanThiet.getTarget() %>">
							<img src='<%= themeDisplay.getPathImage() %>/necessary_info?img_id=<%= thongTinCanThiet.getImageId_liferay() %>' />
						</a>
					</div>
				</td>
			</tr>
        <%
        	}
       	%>
       	</table>
       	
	    <%
       	} else if ("up".equals(displayStyleInfo) || "right".equals(displayStyleInfo)) {
		%>
		<div id="<portlet:namespace/>boxinfo">
			<table cellspacing="0" width="100%">
			    <tr>
				<%
				for( int i=0; i < thongTinCanThietList.size(); i++) {
		    		ThongTinCanThiet thongTinCanThiet = thongTinCanThietList.get(i);
		    	%>
					<td>
						<div class="<portlet:namespace />info">
							<a href="<%= thongTinCanThiet.getUrlWebsite() %>"  target="<%= thongTinCanThiet.getTarget() %>">
								<img width="200px" src='<%= themeDisplay.getPathImage() %>/necessary_info?img_id=<%= thongTinCanThiet.getImageId_liferay() %>' />
							</a>
						</div>
					</td>
					<td ></td>
				<%
				}
				%>
				</tr>
			</table>
		</div>
		
		<% }  %>
		
   			</form>
    	</div>
    </div>
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
			jQuery(document).ready(function(){
				jQuery("#<portlet:namespace/>necessary_info_display").show();
			});
</script>

