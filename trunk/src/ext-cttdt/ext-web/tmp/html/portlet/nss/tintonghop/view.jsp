<%@ include file="/html/portlet/nss/tintonghop/init.jsp" %>

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
	
	<%@ include file="/html/portlet/nss/tintonghop/add_asset.jspf" %>
	
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
	

<input type="hidden" id="displayType-id" name="displayType-name" value="<%= displayType %>"/>

<%@ include file="/html/portlet/nss/tintonghop/view_dynamic_list.jspf" %>
	
	
<%!
	private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.nss.tintonghop.view.jsp");
%>
	
