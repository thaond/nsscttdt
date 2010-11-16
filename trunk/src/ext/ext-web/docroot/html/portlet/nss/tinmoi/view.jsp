<%@ include file="/html/portlet/nss/tinmoi/init.jsp" %>
<%@page import="com.liferay.portlet.tags.service.persistence.TagsVocabularyUtil"%>
<%@page import="com.liferay.portlet.tags.service.persistence.TagsEntryUtil"%>
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.RenderRequest"%>
	    
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
	
	<%@ include file="/html/portlet/nss/tinmoi/add_asset.jspf" %>
	
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
		<!--<div class="separator"> </div> -->
	<%
	}
	
	// Display content
	PortletURL portletURL = renderResponse.createRenderURL();
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);
	%>
	
<!-- phmphuc create 19/07/2010 -->
<div id="<portlet:namespace/>tinmoi_display" style="display: none">
<input type="hidden" id="displayType-id" name="displayType-name" value="<%= displayType %>"/>

<div id="boxnews">
	<c:choose>
		<c:when test='<%= selectionStyle.equals("dynamic") && Validator.isNotNull(category) %>'>
			<%@ include file="/html/portlet/nss/tinmoi/view_dynamic_by_category.jspf" %>
		</c:when>
		<c:when test='<%= selectionStyle.equals("dynamic") && Validator.isNull(category) %>'>
			<%@ include file="/html/portlet/nss/tinmoi/view_dynamic_list.jspf" %>
		</c:when>
		<c:when test='<%= selectionStyle.equals("manual") %>'>
			<%@ include file="/html/portlet/nss/tinmoi/view_manual.jspf" %>
		</c:when>
	</c:choose>
</div>
</div>

<script type="text/javascript">

	var displayTypeId = document.getElementById('displayType-id').value;
	if (displayTypeId == "horizontal") {		
	} else {
		displayTypeId == "vertical";
	}
	window.addEvent('domready', function() {
		
		//slider variables for making things easier below
		var itemsHolder = $('boxnews');
		var myItems = $$(itemsHolder.getElements('.news'));

		//create instance of the slider, and start it up	
		var	mySlider = new SL_Slider({
				slideTimer: 4000,				// thoi gian chay, so cang nho chay cang nhanh
				orientation: displayTypeId,     	// vertical, horizontal, or none: None will create a fading in/out transition.
				fade: true,                    	// if true will fade the outgoing slide - only used if orientation is != None
				isPaused: false,
				container: itemsHolder,
				items: myItems
			});
		mySlider.start();
	});
	jQuery(document).ready(function(){
		jQuery("#<portlet:namespace/>tinmoi_display").show();
	});
</script>
<!-- phmphuc end 20/07/2010 -->
	
	<%!
	private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.nss.tinmoi.view.jsp");
	%>
	
