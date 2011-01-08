<%@ include file="/html/common/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>



<script type="text/javascript">


function <portlet:namespace/>checkReceiverId(form) {
	
	if(form.<portlet:namespace/><%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX %>receiverId.value == "0") {
		alert("<liferay-ui:message key='chonnguoitiepnhanxuly'/>");
		form.<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX%>receiverId.focus();
		return false;
	}
	
	return true;
}

function startTime()
{
	var today=new Date();
	var h=today.getHours();
	var m=today.getMinutes();
	var s=today.getSeconds();
	// add a zero in front of numbers<10
	m=checkTime(m);
	s=checkTime(s);
	document.getElementById('applicantTime').value=h+":"+m+":"+s;
	t=setTimeout('startTime()',500);

}

function checkTime(i)
	{
	if (i<10)
	  {
	  i="0" + i;
	  }
	return i;
}
</script>

