<%@ include file="/html/portlet/nss/asset_publisher_nss/init.jsp" %>

<%@page import="com.liferay.portlet.tags.service.persistence.TagsVocabularyUtil"%>
<%@page import="com.liferay.portlet.tags.service.persistence.TagsEntryUtil"%>
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<div id="<portlet:namespace/>bodyTab" >
<div id="<portlet:namespace/>divTab" >
<div class="toplist"  >
<div class="titlecateg">
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
			    	%>
			    	
			    	<%
			    } catch (Exception e) {}
			    
		    	//PortletURL viewCategoryURL = new PortletURLImpl(request,portletAssetPublisher, selectPlId, PortletRequest.RENDER_PHASE );
		    	PortletURL viewCategoryURL = renderResponse.createRenderURL();
		    	viewCategoryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
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
							  	 viewCategoryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
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
						   viewCategoryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
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
	
</div>

<!--  minh 20100719 -->
<script type="text/javascript">		
	function <portlet:namespace/>ajaxpaginate(href) {
		//showLoading('<liferay-ui:message key="xin-cho"/>');
		//<portlet:namespace/>showLoading('');
		//jQuery('div#<portlet:namespace/>last_msg_loader').html('<img src="/html/images/bigLoader.gif">');
		//jQuery('div#<portlet:namespace/>divTab" >').empty();
		//jQuery('#p_p_id<portlet:namespace/>').val('div').html('<div class="loading-animation"></div>');
		//jQuery('#<portlet:namespace/>divTab').load(href + ' #<portlet:namespace/>divTab', function(){
		//location.href = href;
		//alert('<portlet:namespace/>divTab');
		//jQuery('#<portlet:namespace/>bodyTab').load(href + ' #<portlet:namespace/>divTab', function(){
			
			//<portlet:namespace/>hideLoading();
			//jQuery('div#<portlet:namespace/>last_msg_loader').empty();
		//});
		
		jQuery('div#<portlet:namespace/>last_msg_loader').html('<img src="/html/images/bigLoader.gif">');
		var html = jQuery.ajax({
			 url: href,
			 async: false
			}).responseText; 

			if (html.indexOf("<portlet:namespace/>divTab") > 0) {													
				var data=html.substring(html.indexOf("<portlet:namespace/>divTab") - 9, html.indexOf("<portlet:namespace/>end")-10);					
				if (data != "") {							
					jQuery("#<portlet:namespace/>divTab").remove();
					jQuery("#<portlet:namespace/>bodyTab").html(data);
					jQuery('div#<portlet:namespace/>last_msg_loader').empty();
				}
			}
	}
	
	function <portlet:namespace/>showLoading(message, time) {
		var loadingMessage;
		if (!isNaN(message) || (message.toLowerCase() == 'slow') || (message.toLowerCase() == 'fast')) {
			time = message;
			message = 'Loading';
		}
		if (message) {
			loadingMessage = message;
		} else {
			loadingMessage = 'Loading';
		}
		var wnd = jQuery(window), doc = jQuery(document), pTop = doc.scrollTop(), pLeft = doc
				.scrollLeft();
		pTop += (wnd.height() - 140) / 2;
		pLeft += (wnd.width() - 400) / 2;
		var disabledZone = document.getElementById('disabledZone_');
		var message = jQuery('<div/>');
		message.attr('id', 'message_');
		message.css({
			marginTop: '35px',
			textAlign: 'center'
		});
		message.text(loadingMessage + '...');

		if (!disabledZone) {
			var messageZone = jQuery('<div></div>');
			messageZone.attr('id', 'messageZone_');
			messageZone
					.css( {
						position : "absolute",
						left : pLeft,
						top : pTop,
						width : 400,
						height : 140,
						width : 200,
						height : 70,
						background : 'url(/html/images/loading-bar.gif) no-repeat center center #000000',
						color : 'white',
						fontFamily : 'Arial,Helvetica,sans-serif',
						fontSize : '20px',
						margin : '10px',
						borderTop : 'solid 1px #EEEEEE',
						borderBottom : 'solid 1px #EEEEEE',
						padding : 4,
						zIndex: 2002,
						textAlign : 'center'
					});
			messageZone.html(message);
			messageZone.appendTo('body');

			disabledZone = jQuery('<div></div>');
			disabledZone.attr('id', 'disabledZone_');
			disabledZone.css( {
				position : "absolute",
				left : 0,
				top : 0,
				width : jQuery(document).width(),
				height : jQuery(document).height(),
				background: '#000000',
				filter: 'alpha(opacity=70)',
				opacity: 0.7,
				zIndex: 2001
			});
			disabledZone.appendTo('body');
		} else {
			jQuery('#messageZone_').css( {
				top : pTop,
				left: pLeft
			});
			jQuery('#messageZone_').html(message);
			if (time) {
				jQuery('#disabledZone_').show();
				jQuery('#messageZone_').show(time);
			} else {
				jQuery('#disabledZone_').show();
				jQuery('#messageZone_').show();
			}
		}
	}

	function <portlet:namespace/>hideLoading(time) {
		if (time) {
			jQuery('#disabledZone_').hide();
			jQuery('#messageZone_').hide(time);
		} else {
			jQuery('#disabledZone_').hide();
			jQuery('#messageZone_').hide();
		}
	}

	jQuery(function() {
		jQuery(window).scroll(
				function() {
					var wnd = jQuery(window), doc = jQuery(document), pTop = doc
							.scrollTop(), pLeft = doc.scrollLeft();
					pTop += (wnd.height() - 140) / 2;
					pLeft += (wnd.width() - 400) / 2;
					jQuery('#messageZone_').css( {
						top : pTop,
						left: pLeft
					});
					jQuery('#disabledZone_').css( {
						height : jQuery(document).height()
					});
				});
	});
</script>
<!--  minh 20100719 -->
