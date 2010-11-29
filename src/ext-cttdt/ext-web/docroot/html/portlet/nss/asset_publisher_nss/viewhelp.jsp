<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/nss/asset_publisher_nss/init.jsp" %>

<%@page import="com.liferay.portlet.tags.service.persistence.TagsVocabularyUtil"%>
<%@page import="com.liferay.portlet.tags.service.persistence.TagsEntryUtil"%>
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<script type="text/javascript" src="/html/js/scroll/jquery.scrollTo.js"></script>
<script type="text/javascript" src="/html/js/scroll/jquery.scrollTo-min.js"></script>
<script type="text/javascript" src="/html/js/scroll/jquery.serialScroll.js"></script>
<script type="text/javascript" src="/html/js/scroll/jquery.serialScroll-min.js"></script>


<style type="text/css">
.portlet-asset-publisher .asset-content img {
	width: 130px;
	border:2px solid #EEEEEE;
	float:left;
	height:auto;
	margin-bottom:5px;
	margin-right:10px;
	padding:1px;
}
</style>

<div id="<portlet:namespace/>divTab" >

<!-- MoNT start 27/11/2010 -->
<script>
	jQuery.easing.easeOutQuart = function (x, t, b, c, d) {
			return -c * ((t=t/d-1)*t*t*t - 1) + b;
	};

	jQuery(function( $ ){
		<portlet:namespace/>scrollviewhelp();
	});

	function <portlet:namespace/>scrollviewhelp() {
		jQuery('#<portlet:namespace/>slideshowhelp').serialScroll({
			items:'li',
			prev:'#<portlet:namespace/>screenhelp a.prevbt',
			next:'#<portlet:namespace/>screenhelp a.nextbt',
			start:0, //as we are centering it, start at the 2nd
			//step:1,
			//force:true,
			stop:true,
			//lock:false,
			//cycle:false, //don't pull back once you reach the end
			easing:'easeOutQuart', //use this easing equation for a funny effect
		});
	}
</script>
<!-- MoNT end 27/11/2010 -->

	<div class="toplist" >
	    <div class="titlecateg">
	    <div id="<portlet:namespace/>slideshowhelp" class="bgtabtle">
	    <ul>    
	    <%
	    	long categoryParentId = 0;
	    	List<TagsVocabulary> vocabularies = TagsVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, TagsEntryConstants.FOLKSONOMY_CATEGORY);
		    for (TagsVocabulary vocabulary : vocabularies) {
		    	if (vocabulary.getName().equals(category)) {
		    		categoryParentId = vocabulary.getVocabularyId();	    		
		    	}
		    }
		    List<TagsEntry> tagsEntrys = new ArrayList<TagsEntry>();
		    try {
		    	tagsEntrys= JournalProcessDefinitionLocalServiceUtil.getListTagsEntry(categoryParentId);
		    } catch (Exception e) {}
		    
	    	//PortletURL viewCategoryURL = new PortletURLImpl(request,portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
	    	PortletURL viewCategoryURL = renderResponse.createRenderURL();
	    	viewCategoryURL.setWindowState(LiferayWindowState.NORMAL);
	  		viewCategoryURL.setParameter("struts_action", "/nss/asset_publisher_nss/viewhelp");
	  		viewCategoryURL.setParameter("tagsEntryId", "0");
	  		
	  		
	  		if (tagsEntryId == 0) {
		%>
	    	<li class="leftact"><a  class="rightact" href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL.toString() %>');"><%=category %></a></li>
	    <%} else {%>	
	    	<li ><a  href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL.toString() %>');"><%=category %></a></li>
	   <%}
	  		if (tagsEntrys.size() >1 ) {
	  		String name  = "";
		   for (TagsEntry tagsEntry : tagsEntrys) {
			   if (null != tagsEntry) {
				   if (tagsCategoriesHelp.length > 0) {
					   for (int i=0; i < tagsCategoriesHelp.length; i++ ) {
						   if (tagsEntry.getName().equals(tagsCategoriesHelp[i])) {
							   viewCategoryURL = renderResponse.createRenderURL();
							   viewCategoryURL.setWindowState(LiferayWindowState.NORMAL);
						  	   viewCategoryURL.setParameter("struts_action", "/nss/asset_publisher_nss/viewhelp");
						  	   viewCategoryURL.setParameter("tagsEntry", String.valueOf(tagsEntry.getEntryId()));
						  	   
						  	   name = tagsEntry.getName();
						  	   if (tagsEntryId == tagsEntry.getEntryId()) {
		%>
									<li class="leftact"><a class="rightact" href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL %>')"><%=tagsEntry.getName() %></a></li>
		<% 						} else { %>
									<li><a  href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL %>')"><%=tagsEntry.getName() %></a></li>
		<%	
								}
						   }
					   }
				   } 
				   
				   else {
					   viewCategoryURL = renderResponse.createRenderURL();
					   viewCategoryURL.setWindowState(LiferayWindowState.NORMAL);
				  	   viewCategoryURL.setParameter("struts_action", "/nss/asset_publisher_nss/viewhelp");
				  	   viewCategoryURL.setParameter("tagsEntry", String.valueOf(tagsEntry.getEntryId()));
				  	   if (tagsEntryId == tagsEntry.getEntryId()) {
		%>				   
					   <li class="leftact" ><a class="rightact" href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL %>')"><%=tagsEntry.getName() %></a></li>
		<%				} else { %>
						<li ><a  href="javascript:<portlet:namespace/>ajaxpaginate('<%= viewCategoryURL %>');" ><%=tagsEntry.getName() %></a></li>
		<%				}	
				   }
			   }
		   }
	  	}
	   %>    	
	    </ul>
	    </div>
	    <!-- MoNT start 27/11/2010 -->
	    <div id="<portlet:namespace/>screenhelp" class="btnextpre">
			<div id="<portlet:namespace/>buttonhelp">
				<a class="prevbt" onclick="<portlet:namespace/>scrollviewhelp()" href="#"></a>
				<a class="nextbt" onclick="<portlet:namespace/>scrollviewhelp()" href="#"></a>
			</div>	
		</div>
	    </div>			
		<!-- MoNT end 27/11/2010 -->
	    <div class="btmlist">
	    <div class="ctrlist">
	    <div class="shownew">
	   
		<%
		if (mergeUrlTags) {
			String[] compilerEntries = (String[])request.getAttribute(WebKeys.TAGS_COMPILER_ENTRIES);
		
			Set<String> layoutTagsEntries = TagsUtil.getLayoutTagsEntries(request);
		
			if (!layoutTagsEntries.isEmpty()) {
				compilerEntries = ArrayUtil.append(compilerEntries, layoutTagsEntries.toArray(new String[layoutTagsEntries.size()]));
			}
		
			String titleEntry = null;
		
			if ((compilerEntries != null) && (compilerEntries.length > 0)) {
				String[] newEntries = ArrayUtil.append(entries, compilerEntries);
		
				entries = newEntries;
		
				titleEntry = compilerEntries[compilerEntries.length - 1];
			}
		
			String portletTitle = HtmlUtil.unescape(portletDisplay.getTitle());
		
			portletTitle = TagsUtil.substitutePropertyVariables(scopeGroupId, titleEntry, portletTitle);
		
			renderResponse.setTitle(portletTitle);
		}
		
		entries = ArrayUtil.distinct(entries, new StringComparator());
		
		for (String entryName : entries) {
			try {
				TagsEntry entry = TagsEntryLocalServiceUtil.getEntry(scopeGroupId, entryName);
		
				TagsProperty journalTemplateIdProperty = TagsPropertyLocalServiceUtil.getProperty(entry.getEntryId(), "journal-template-id");
		
				String journalTemplateId = journalTemplateIdProperty.getValue();
		
				request.setAttribute(WebKeys.JOURNAL_TEMPLATE_ID, journalTemplateId);
		
				break;
			}
			catch (NoSuchEntryException nsee) {
			}
			catch (NoSuchPropertyException nspe) {
			}
		}
		
		if (enableTagBasedNavigation && selectionStyle.equals("manual") && (entries.length > 0)) {
			selectionStyle = "dynamic";
		}
		
		String portletId = portletDisplay.getId();
		%>
		
		<%@ include file="/html/portlet/nss/asset_publisher_nss/add_asset.jspf" %>
		 <div id="<portlet:namespace/>last_msg_loader" align="center"></div>
		<%
		if (showQueryLogic) {
			StringBuilder tagsText = new StringBuilder();
		
			if (entries.length > 0) {
				tagsText.append("( ");
			}
		
			for (int i = 0; i < entries.length; i++) {
				if ((i + 1) == entries.length) {
					tagsText.append(entries[i]);
					tagsText.append(" )");
				}
				else {
					tagsText.append(entries[i]);
		
					if (andOperator) {
						tagsText.append(" AND ");
					}
					else {
						tagsText.append(" OR ");
					}
				}
			}
		
			if ((entries.length > 0) && (notEntries.length > 0)) {
				tagsText.append(" AND NOT ( ");
			}
		
			for (int i = 0; i < notEntries.length; i++) {
				if ((i + 1) == notEntries.length) {
					tagsText.append(notEntries[i]);
					tagsText.append(" )");
				}
				else {
					tagsText.append(notEntries[i]);
					tagsText.append(" OR ");
				}
			}
		%>
		
			<liferay-ui:message key="tags" />:
		
			<%= tagsText %>
		
			<div class="separator"><!-- --></div>
		
		<%
		}
		
		// Display content
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);
		%>
		
		<c:choose>
			<c:when test='<%= selectionStyle.equals("dynamic") && Validator.isNotNull(category) %>'>
				<%@ include file="/html/portlet/nss/asset_publisher_nss/view_dynamic_by_category.jspf" %>
			</c:when>
			<c:when test='<%= selectionStyle.equals("dynamic") && Validator.isNull(category) %>'>
				<%@ include file="/html/portlet/nss/asset_publisher_nss/view_dynamic_list.jspf" %>
			</c:when>
			<c:when test='<%= selectionStyle.equals("manual") %>'>
				<%@ include file="/html/portlet/nss/asset_publisher_nss/view_manual.jspf" %>
			</c:when>
		</c:choose>
		
		<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
		</c:if>
		
		<%!
		private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.nss.asset_publisher_nss.view.jsp");
		%>
		</div>
		</div>
		</div>
	</div>
</div>
<div id="<portlet:namespace/>end"></div>


