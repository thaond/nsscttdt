
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.util.NumberFormatUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>



<%

String formName = namespace + request.getAttribute("liferay-ui:page-iterator:formName");
String curParam = (String)request.getAttribute("liferay-ui:page-iterator:curParam");
//String curParam = String.valueOf(searchContainer.getCurParam());
int curValue = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:curValue"));
//int curValue = searchContainer.getCurValue();

int delta = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:delta"));
//int delta = searchContainer.getDelta();

String jsCall = (String)request.getAttribute("liferay-ui:page-iterator:jsCall");

int maxPages = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:maxPages"));
//int maxPages = 25;
String target = (String)request.getAttribute("liferay-ui:page-iterator:target");

total = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:total"));
type = (String)request.getAttribute("liferay-ui:page-iterator:type");
url = (String)request.getAttribute("liferay-ui:page-iterator:url");

String urlAnchor = (String)request.getAttribute("liferay-ui:page-iterator:urlAnchor");
int pages = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:pages"));

start = (curValue - 1) * delta;
end = curValue * delta;


if (end > total) {
	end = total;
}

int resultRowsSize = delta;

if (total < delta) {
	resultRowsSize = total;
}
else {
	resultRowsSize = total - ((curValue - 1) * delta);

	if (resultRowsSize > delta) {
		resultRowsSize = delta;
	}
}

NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
%>


<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.NumberFormat"%>


<%@page import="com.liferay.taglib.ui.SearchPaginatorTag"%>


<c:if test='<%= type.equals("regular") || (type.equals("article") && (total > resultRowsSize)) %>'>
	<div class="taglib-page-iterator">
</c:if>

<c:if test='<%= type.equals("regular") %>'>
	<div class="search-results">
		<c:choose>
			<c:when test="<%= total > resultRowsSize %>">
				<%= LanguageUtil.format(pageContext, "showing-x-x-of-x-results", new Object[] {numberFormat.format(start + 1), numberFormat.format(end), numberFormat.format(total)}) %>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="<%= total != 1 %>">
						<%= LanguageUtil.format(pageContext, "showing-x-results", numberFormat.format(total)) %>
					</c:when>
					<c:otherwise>
						<%= LanguageUtil.format(pageContext, "showing-x-result", numberFormat.format(total)) %>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>

<c:if test='<%= type.equals("article") && (total > resultRowsSize) %>'>
	<div class="search-results">
		<liferay-ui:message key="pages" />:

		<%
		int pagesIteratorMax = maxPages;
		int pagesIteratorBegin = 1;
		int pagesIteratorEnd = pages;

		if (pages > pagesIteratorMax) {
			pagesIteratorBegin = curValue - pagesIteratorMax;
			pagesIteratorEnd = curValue + pagesIteratorMax;

			if (pagesIteratorBegin < 1) {
				pagesIteratorBegin = 1;
			}

			if (pagesIteratorEnd > pages) {
				pagesIteratorEnd = pages;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = pagesIteratorBegin; i <= pagesIteratorEnd; i++) {
			if (i == curValue) {
				sb.append("<b class='journal-article-page-number'>");
			}
			else {
				sb.append("<a class='journal-article-page-number' onchange='viewListDocument(");
				sb.append(_getHREF(formName, curParam, i, jsCall, url, urlAnchor));
				sb.append(")'");
				sb.append("'>");
			}

			sb.append(i);

			if (i == curValue) {
				sb.append("</b>");
			}
			else {
				sb.append("</a>");
			}

			sb.append("&nbsp;&nbsp;");
		}
		%>

		<%= sb.toString() %>
	</div>
</c:if>

<c:if test="<%= total > delta %>">
	<div class="search-pages">
		<c:if test='<%= type.equals("regular") %>'>
			<div class="page-selector">
				<liferay-ui:message key="page" />

				<c:choose>
					<c:when test="<%= themeDisplay.isFacebook() %>">
						<%= curValue %>
					</c:when>
					<c:otherwise>
						
						<select   >

							
							<%
							int pagesIteratorMax = maxPages;
							int pagesIteratorBegin = 1;
							int pagesIteratorEnd = pages;

							if (pages > pagesIteratorMax) {
								pagesIteratorBegin = curValue - pagesIteratorMax;
								pagesIteratorEnd = curValue + pagesIteratorMax;

								if (pagesIteratorBegin < 1) {
									pagesIteratorBegin = 1;
								}

								if (pagesIteratorEnd > pages) {
									pagesIteratorEnd = pages;
								}
							}
							
							for (int i = pagesIteratorBegin; i <= pagesIteratorEnd; i++) {
							%>

								<option onclick='viewListDocument("<%= url + curParam %>" + "=" + "<%= String.valueOf(i) %>" + "<%= urlAnchor %>")'  <%= (i == curValue) ? "selected=\"selected\"" : "" %> value="<%= i %>"><%= i %></option>

							<%
							}
							%>

						</select>
					</c:otherwise>
				</c:choose>

				<liferay-ui:message key="of" />

				<%= numberFormat.format(pages) %>

				<%--<input class="page-iterator-submit" type="submit" value="<liferay-ui:message key="submit" />" />--%>
			</div>
		</c:if>

		<div class="page-links">
			<c:if test='<%= type.equals("regular") %>'>
				<c:choose>
					<c:when test="<%= curValue != 1 %>">
						<a class="first" onclick="viewListDocument('<%= _getHREF(formName, curParam, 1, jsCall, url, urlAnchor) %>')" target="<%= target %>">
					</c:when>
					<c:otherwise>
						<span class="first">
					</c:otherwise>
				</c:choose>

				<liferay-ui:message key="first" />

				<c:choose>
					<c:when test="<%= curValue != 1 %>">
						</a>
					</c:when>
					<c:otherwise>
						</span>
					</c:otherwise>
				</c:choose>
			</c:if>

			<c:choose>
				<c:when test="<%= curValue != 1 %>">
					<a class="previous" onclick="viewListDocument('<%= _getHREF(formName, curParam, curValue - 1, jsCall, url, urlAnchor) %>')" target="<%= target %>">
				</c:when>
				<c:when test='<%= type.equals("regular") %>'>
					<span class="previous">
				</c:when>
			</c:choose>

			<c:if test='<%= (type.equals("regular") || curValue != 1) %>'>
				<liferay-ui:message key="previous" />
			</c:if>

			<c:choose>
				<c:when test="<%= curValue != 1 %>">
					</a>
				</c:when>
				<c:when test='<%= type.equals("regular") %>'>
					</span>
				</c:when>
			</c:choose>

			<c:choose>
				<c:when test="<%= curValue != pages %>">
					<a class="next" onclick="viewListDocument('<%= _getHREF(formName, curParam, curValue + 1, jsCall, url, urlAnchor) %>')" target="<%= target %>">
				</c:when>
				<c:when test='<%= type.equals("regular") %>'>
					<span class="next">
				</c:when>
			</c:choose>

			<c:if test='<%= (type.equals("regular") || curValue != pages) %>'>
				<liferay-ui:message key="next" />
			</c:if>

			<c:choose>
				<c:when test="<%= curValue != pages %>">
					</a>
				</c:when>
				<c:when test='<%= type.equals("regular") %>'>
					</span>
				</c:when>
			</c:choose>

			<c:if test='<%= type.equals("regular") %>'>
				<c:choose>
					<c:when test="<%= curValue != pages %>">
						<a class="last" onclick="viewListDocument('<%= _getHREF(formName, curParam, pages, jsCall, url, urlAnchor) %>')" target="<%= target %>">
					</c:when>
					<c:otherwise>
						<span class="last">
					</c:otherwise>
				</c:choose>

				<liferay-ui:message key="last" />

				<c:choose>
					<c:when test="<%= curValue != pages %>">
						</a>
					</c:when>
					<c:otherwise>
						</span>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</div>
</c:if>

<c:if test='<%= type.equals("regular") || (type.equals("article") && (total > resultRowsSize)) %>'>
	</div>
</c:if>
