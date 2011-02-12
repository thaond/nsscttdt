<%@ include file="/html/portlet/ext/onedoorpcccreport/init.jsp" %>
<table class="report">
<tr height="10"></tr>
<tr><td height="200"><div align="center">
<portlet:renderURL var="test1">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothang"/>
</portlet:renderURL>
<a href="<%= test1 %>" onmouseover="document.but.src='/html/images/month1.jpg'"
onmouseout="document.but.src='/html/images/om1.png'"><img name="but" src="/html/images/om1.png"> </a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test2">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluyke"/>
</portlet:renderURL>
<a href="<%= test2 %>" onmouseover="document.but2.src='/html/images/m2.jpg'"
onmouseout="document.but2.src='/html/images/m4.png'"><img name="but2" src="/html/images/m4.png"></a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test3">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphong"/>
</portlet:renderURL>
<a href="<%= test3 %>" onmouseover="document.but3.src='/html/images/m6.png'"
onmouseout="document.but3.src='/html/images/m3.jpg'"><img name="but3" src="/html/images/m3.jpg"></a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test4">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapso"/>
</portlet:renderURL>
<a href="<%= test4 %>" onmouseover="document.but4.src='/html/images/m8.png'"
onmouseout="document.but4.src='/html/images/m4.jpg'"><img name="but4" src="/html/images/m4.jpg"></a>
</div></td>
</tr>
<tr><td><div align="center">
<portlet:renderURL var="test1">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothang"/>
</portlet:renderURL>
<a href="<%= test1 %>" onmouseover="document.but.src='/html/images/month1.jpg'"
onmouseout="document.but.src='/html/images/om1.png'"><liferay-ui:message key="onedoorpcccreport-baocaohosothang" /></a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test2">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/baocaohosothangluyke"/>
</portlet:renderURL>
<a href="<%= test2 %>" onmouseover="document.but2.src='/html/images/m2.jpg'"
onmouseout="document.but2.src='/html/images/m4.png'"><liferay-ui:message key="onedoorpcccreport-baocaohosothangluyke" /></a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test3">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapphong"/>
</portlet:renderURL>
<a href="<%= test3 %>" onmouseover="document.but3.src='/html/images/m6.png'"
onmouseout="document.but3.src='/html/images/m3.jpg'"><liferay-ui:message key="onedoorpcccreport-tinhhinhthulyhosocapphong" /></a>
</div></td>
<td><div align="center">
<portlet:renderURL var="test4">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport/tinhhinhthulyhosocapso"/>
</portlet:renderURL>
<a href="<%= test4 %>" onmouseover="document.but4.src='/html/images/m8.png'"
onmouseout="document.but4.src='/html/images/m4.jpg'"><liferay-ui:message key="onedoorpcccreport-tinhhinhthulyhosocapso" /></a>
</div></td>
</tr>

</table>