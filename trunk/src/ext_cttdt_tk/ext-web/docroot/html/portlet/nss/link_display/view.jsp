<%@ include file="/html/portlet/nss/link_display/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.link.model.LienKetWebsite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.link.model.LoaiWebsite"%>
<%@page import="com.nss.portlet.link.service.LienKetWebsiteLocalServiceUtil"%>

<%
	List<LoaiWebsite> loaiWebsiteList = (List<LoaiWebsite>)renderRequest.getAttribute("loaiWebsiteList") == null ? 
								new ArrayList<LoaiWebsite>() : (List<LoaiWebsite>)renderRequest.getAttribute("loaiWebsiteList");
	List<LienKetWebsite> lienKetWebsiteList = (List<LienKetWebsite>)renderRequest.getAttribute("lienKetWebsiteList") == null ? 
								new ArrayList<LienKetWebsite>() : (List<LienKetWebsite>)renderRequest.getAttribute("lienKetWebsiteList");
%>
<div class="topbox">
        <h4><liferay-ui:message key="nss-lien-ket" /></h4>
        	<div class="bottombox">
            	<div class="centerbox">
            	<form name="<portlet:namespace />fm" action="" method="get">
			        <%
			       	if ("select".equals(displayStyleLink)) {
			        List<LienKetWebsite> lienKetWebsiteLoaiWebsiteList = new ArrayList<LienKetWebsite>();
			       	%>
			      	<select class="listmenulink" name="jumpMenu" >
				        <option value="#">---------- <liferay-ui:message key="nss-lien-ket-website" /> ----------</option>
			       	<%
				        for ( int j=0; j < loaiWebsiteList.size(); j++) {
				        	long maLoaiWebsite = loaiWebsiteList.get(j).getMaLoaiWebsite();
				        	lienKetWebsiteLoaiWebsiteList = LienKetWebsiteLocalServiceUtil.getListLienKetWebsiteByLoaiWebsiteId(maLoaiWebsite);
				        	
				        %>
					        	<optgroup label="<%= loaiWebsiteList.get(j).getTenLoaiWebsite() %>">
						        <%
							       	for( int i=0; i < lienKetWebsiteLoaiWebsiteList.size(); i++) {
						        		LienKetWebsite lienKetWebsite = lienKetWebsiteLoaiWebsiteList.get(i);
						        %>
						        		
					        		<option onclick="window.open('<%= lienKetWebsite.getUrlWebsite() %>','<%= lienKetWebsite.getTarget() %>');" >
					        			<%= lienKetWebsite.getTenWebsite() %>
					        		</option>
						        <%	
						       		}
					        %>
					       	 	</optgroup>
					       	<%
				        	}
			       	%>
			       	</select>
			       	<%
			       	}
			       	else if ("image".equals(displayStyleLink)) {
			       	%>
			       	<table align="center">
			       	<%
			       		for(int i = 0; i < lienKetWebsiteList.size(); i++) {
				        	LienKetWebsite lienKetWebsite = lienKetWebsiteList.get(i);
			        %>
					
			     		<tr>
							<td>
								<div class="link">
									<a href="<%= lienKetWebsite.getUrlWebsite() %>"  target="<%= lienKetWebsite.getTarget() %>">
										<img src='<%= themeDisplay.getPathImage() %>/link?img_id=<%= lienKetWebsite.getImageId_liferay() %>' />
									</a>
								</div>
							</td>
						</tr>
			         	<tr height="10"></tr>
			        <%
			        	}
			       	%>
			       	</table>
				    <%
			       	} else if ("up".equals(displayStyleLink) || "right".equals(displayStyleLink)) {
					%>
					<div id="<portlet:namespace/>boxlink">
						<table>
						    <tr>
							<%
							for(int i = 0; i < lienKetWebsiteList.size(); i++) {
					        	LienKetWebsite lienKetWebsite = lienKetWebsiteList.get(i);
					    	%>
								<td>
									<div class="<portlet:namespace />link">
										<a href="<%= lienKetWebsite.getUrlWebsite() %>"  target="<%= lienKetWebsite.getTarget() %>">
											<img src='<%= themeDisplay.getPathImage() %>/link?img_id=<%= lienKetWebsite.getImageId_liferay() %>' />
										</a>
									</div>
								</td>
								<td width="10px"></td>
							<%
							}
							%>
							</tr>
						</table>
					</div>
					
					<script type="text/javascript">
						window.addEvent('domready', function() {
							var hVL = null;
							if ('<%= displayStyleLink %>' == "right") {
								hVL = 'horizontal';
							} else {
								hVL = 'vertical';
							}
							//slider variables for making things easier below
							var itemsHolder = $('<portlet:namespace/>boxlink');
							var myItems = $$(itemsHolder.getElements('.<portlet:namespace/>link'));
					
							//create instance of the slider, and start it up		
								var mySliderL = new SL_Slider({
									slideTimer: 4000,				// thoi gian chay, so cang nho chay cang nhanh
									orientation: hVL,     	// vertical, horizontal, or none: None will create a fading in/out transition.
									fade: true,                    	// if true will fade the outgoing slide - only used if orientation is != None
									isPaused: false,
									container: itemsHolder,
									items: myItems
								});
								mySliderL.start();
							
						});
					</script>
					<% }  %>
		
   			</form>
            	</div>
            </div>
</div>
