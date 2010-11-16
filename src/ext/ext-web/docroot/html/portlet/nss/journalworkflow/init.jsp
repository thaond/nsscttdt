<%@ include file="/html/common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.nss.portlet.journalworkflow.util.RoleFilter"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.nss.portlet.journalworkflow.util.XmlRead"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portlet.journal.service.permission.JournalArticlePermission"%>
<%@page import="com.liferay.portlet.RenderRequestImpl"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.journal.service.permission.JournalPermission"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portlet.journal.search.ArticleSearchTerms"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.journal.util.JournalUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest"%>
<%@page import="com.liferay.portlet.journal.search.ArticleSearch"%>


<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.nss.portlet.journalworkflow.model.InstanceBean"%>
<%@page import="com.nss.portlet.journalworkflow.service.InstanceBeanLocalServiceUtil"%>
<%@page import="com.nss.portlet.journalworkflow.service.persistence.InstanceBeanUtil"%>
<%@page import="com.nss.portlet.journalworkflow.util.ArticleUtil"%>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.DateFormats"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.PortalException"%>
<%@page import="com.nss.portlet.journal.action.EditArticleAction"%>
<%@page import="com.nss.portlet.journal.search.ArticleSearchExt"%>

<%@page import="com.nss.portlet.journalworkflow.model.JournalProcessDefinition"%>
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>

<theme:defineObjects />
<portlet:defineObjects />

<%
	PortletPreferences preferences = renderRequest.getPreferences();
	
	JournalProcessDefinition processDefinition = null;
	long businessProcessId = GetterUtil.getLong(preferences.getValue("bpid",""));
	if (businessProcessId > 0) {
		processDefinition = getJournalProcessDefinition(businessProcessId);
	}
	List<String> taskNodeName = new ArrayList<String>();
	if (processDefinition != null) {
		taskNodeName = XmlRead.getNodeName("task-node", processDefinition.getContent());
	}
	String[] currentRoles = new String[taskNodeName.size()];
	
	for (int i = 0; i < taskNodeName.size(); i++) {
		currentRoles[i] = preferences.getValue(taskNodeName.get(i),"");
	}
	
	user = PortalUtil.getUser(request);
	DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);
	DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
	String type = StringPool.BLANK;
	long groupId = themeDisplay.getScopeGroupId();
	type = ParamUtil.getString(request, "type", type);
	
	List<String> userTaskNodeList = getNodeName(user, taskNodeName, currentRoles);
	int delta = GetterUtil.getInteger(preferences.getValue("delta",""));
%>

<%!
	public JournalProcessDefinition getJournalProcessDefinition(long bpid) {
		JournalProcessDefinition processDefinition = null;
		try {
			//processDefinition = ProcessDefinitionUtil.findByPrimaryKey(bpid);
			processDefinition = JournalProcessDefinitionLocalServiceUtil.getJournalProcessDefinition(bpid);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return processDefinition;
	}
	
	public List<String> getNodeName(User user, List<String> taskNodeName, String[] roles) {
		List<String> result = new ArrayList<String>();
		List<Role> roles2 = new ArrayList<Role>();
		
		if (user != null)
		roles2 = user.getRoles();
		
		for (int i = 0; i < roles.length; i++) {
			if (hasRole(roles[i], roles2)) result.add(taskNodeName.get(i));
		}
		return result;
	}
	
	public boolean hasRole(String roleName, List<Role> roles) {
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).getName().equals(roleName)) return true;
		}
		return false;
	}
	
	public String prepareForTabs(List<String> list) {
		String result = "";
		for (String s : list) {
			s = s.replaceAll(" ", "_");
			//s = s.toUpperCase();
			result = result + s + ",";
		}
		if (result.length() > 2)
		result = result.substring(0, result.length() - 1);
		return result;
	}
%>

<script type='text/javascript' src='/dwr/interface/JWFA.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
