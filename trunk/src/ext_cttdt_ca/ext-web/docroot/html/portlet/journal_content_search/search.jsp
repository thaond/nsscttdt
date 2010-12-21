<%@page import="com.nss.portlet.digitalsignature.util.ArticleSignUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
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

<%@ include file="/html/portlet/journal_content_search/init.jsp" %>


<%@page import="javax.portlet.WindowState"%>
<!-- Tu update 20101126 -->
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<script type="text/javascript">
	
	window.onload = function () {
	
		if (document.getElementById('<portlet:namespace />cal_from_date') != null) {
			callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate');
		}
		
		if (document.getElementById('<portlet:namespace />cal_to_date') != null) {
			callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate');
		}
		
	}
	
</script>
<!-- End Tu update -->
<c:choose>
	<c:when test="<%= windowState.equals(WindowState.NORMAL) %>">

		<%
		String defaultKeywords = LanguageUtil.get(pageContext, "search") + "...";
		String unicodeDefaultKeywords = UnicodeFormatter.toString(defaultKeywords);
		
		String keywords = ParamUtil.getString(request, "keywords", defaultKeywords);
		//Tu update 20101122
		String name = ParamUtil.getString(request,"search_name","");
		String description = ParamUtil.getString(request,"search_description","");
		String fromDate = ParamUtil.getString(request,"cal_from_date");
		String toDate = ParamUtil.getString(request,"cal_to_date");
		//End Tu update
		%>

		<form action="<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/journal_content_search/search" /></portlet:renderURL>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
		
		<!-- Tu update 20101126 -->

		<div class="titlecategories"><h6><liferay-ui:message key="nss-tim-kiem"/></h6></div>
		<div id="<portlet:namespace />journal_content_search_advanced" >
			<br />
			<table cellspacing="0" width="100%">
			<tr>
				<td align="right"><liferay-ui:message key="j_c_s_a_name" />:&nbsp;</td>
				<td align="left">
					<input name="<portlet:namespace />search_name" size="20" style="width: 125px" type="text" value="<%= name %>" />
				</td>
				<td>&nbsp;</td>		
				<td align="right"><liferay-ui:message key="j_c_s_a__description" />:&nbsp;</td>
				<td align="left">
					<input name="<portlet:namespace />search_description" size="20" style="width: 125px" type="text" value="<%= description %>" />
				</td>		
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right"><liferay-ui:message key="j_c_s_a__from_date" />:&nbsp;</td>
				<td align="left" width="133px">
					<input name="<portlet:namespace />cal_from_date" id="<portlet:namespace />cal_from_date" size="12" type="text" value="<%= fromDate %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
					<br>
					(dd/mm/yyyy)
				</td>
				<td><img src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" /></td>
				<td align="right"><liferay-ui:message key="j_c_s_a__to_date" />:&nbsp;</td>
				<td align="left" width="133px">
					<input name="<portlet:namespace />cal_to_date" id="<portlet:namespace />cal_to_date" size="12" type="text" value="<%= toDate %>" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
					<br>
					(dd/mm/yyyy)
				</td>
				<td><img src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" /></td>
			</tr>
			</table>	
			<div style="padding-left: 4px;"><input type="submit" value='<liferay-ui:message key="search"/>' /></div>
			<br>
		</div>
		<div style="padding-left: 4px;"><a id="<portlet:namespace />hide_search_advanced" href="#"><liferay-ui:message key="hide-search-advanced"/><%= " <<" %> </a></div>
		<div style="padding-left: 4px;"><a id="<portlet:namespace />Show_search_advanced" style="display: none;" href="#"><liferay-ui:message key="show-search-advanced"/><%= ">>" %> </a></div>
		<div class="separator"></div>
		<!-- End Tu update -->
		<%
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setWindowState(WindowState.NORMAL);

		portletURL.setParameter("struts_action", "/journal_content_search/search");
		portletURL.setParameter("keywords", keywords);

		List<String> headerNames = new ArrayList<String>();

		headerNames.add("#");
		headerNames.add("name");
		headerNames.add("content");
		//headerNames.add("score");

		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-pages-were-found-that-matched-the-keywords-x", "<b>" + HtmlUtil.escape(keywords) + "</b>"));

		try {

			// We must use QueryUtil.ALL_POS or else pagination will break. We
			// need to filter the results with ContentHits first and then make a
			// subset of the filtered results.
			//Tu update 20101126
			Hits results = null;
			if(!name.equalsIgnoreCase("") || !description.equalsIgnoreCase("")){
				results = CompanyLocalServiceUtil.search(company.getCompanyId(), 0, PortletKeys.JOURNAL, 0, type, name+" "+ description, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}else{
				results = CompanyLocalServiceUtil.search(company.getCompanyId(), 0, PortletKeys.JOURNAL, 0, type, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			
			ContentHits contentHits = new ContentHits();

			contentHits.setShowListed(showListed);

			contentHits.recordHits(results, layout.getGroupId(), layout.isPrivateLayout(), searchContainer.getStart(), searchContainer.getEnd());

			int total = results.getLength();
			int total1 = 0;
			//searchContainer.setTotal(total);

			List resultRows = searchContainer.getResultRows();
			JournalArticle article_vttv = null;
			Date date,date1,date2;
			date = date1 = date2 = null;
			StringTokenizer tokenizer = new StringTokenizer(fromDate,"/");
			if(tokenizer.hasMoreTokens()){
				int day = Integer.parseInt(tokenizer.nextToken());
				int month = Integer.parseInt(tokenizer.nextToken());
				int year = Integer.parseInt(tokenizer.nextToken());
				date1 = new Date(year-1900,month-1,day);
			}
			StringTokenizer tokenizer1 = new StringTokenizer(toDate,"/");
			if(tokenizer1.hasMoreTokens()){
				int day = Integer.parseInt(tokenizer1.nextToken());
				int month = Integer.parseInt(tokenizer1.nextToken());
				int year = Integer.parseInt(tokenizer1.nextToken());
				date2 = new Date(year-1900,month-1,day);
			}
			int position = 1;
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				
				ResultRow row = new ResultRow(doc, i, i);
				
				String acticleStringId = doc.get(Field.ENTRY_CLASS_PK);
				long articleGroupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));
				article_vttv =  JournalArticleLocalServiceUtil.getArticle(articleGroupId,acticleStringId);
				try{
					date = article_vttv.getApprovedDate();
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}
				if(date != null && date1 != null && date2 != null){
					if(date.compareTo(date1) >= 0 && date.compareTo(date2) <= 0){
						total1++;
					// Position
						row.addText(searchContainer.getStart() + total1 + StringPool.PERIOD);
					}else{
						continue;
					}
					
				}else{
					// Position
					row.addText(searchContainer.getStart() + i + 1 + StringPool.PERIOD);
				}
				// Title
				
				String title = doc.get(Field.TITLE);

				title = StringUtil.highlight(title, keywords);

				row.addText(title);

				// Content

				row.addJSP("/html/portlet/journal_content_search/article_content.jsp");

				// Score

			//	row.addScore(results.score(i));

				// Add result row

				resultRows.add(row);
			}
			if(total1 > 0)
				total = total1;
			searchContainer.setTotal(total);
			
			//End Tu update
		%>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					 
					<!-- 
					<input name="<portlet:namespace />keywords" size="30" type="text" value="<!%= HtmlUtil.escape(keywords) %>" onBlur="if (this.value == '') { this.value = '<!%= unicodeDefaultKeywords %>'; }" onFocus="if (this.value == '<!%= unicodeDefaultKeywords %>') { this.value = ''; }" />

					<input align="absmiddle" border="0" src="<!%= themeDisplay.getPathThemeImages() %>/common/search.png" title="<liferay-ui:message key="search" />" type="image" />
					-->
					
					<span><liferay-ui:message key="ket-qua-tim-kiem"/>: <%= HtmlUtil.escape(keywords) %> </span>
				</td>
				<td align="right">
					<liferay-ui:search-speed searchContainer="<%= searchContainer %>" hits="<%= results %>" />
				</td>
			</tr>
			</table>
			
			<br />

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

		<%
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}
		%>

		</form>

		<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
			<script type="text/javascript">
				if (document.<portlet:namespace />fm.<portlet:namespace />keywords) {
					Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />keywords);
				}
			</script>
		</c:if>
	</c:when>
	<c:otherwise>
		<liferay-ui:journal-content-search />
	</c:otherwise>
</c:choose>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.journal_content_search.search.jsp");
%>
<!-- Tu update 20101126 -->
<script language="javascript">
	jQuery(document).ready(function(){
		jQuery('#<portlet:namespace />Show_search_advanced').click(function(){
			jQuery('#<portlet:namespace />journal_content_search_advanced').show('slow');
			jQuery('#<portlet:namespace />Show_search_advanced').hide();
			jQuery('#<portlet:namespace />hide_search_advanced').show();
		});
		jQuery('#<portlet:namespace />hide_search_advanced').click(function(){
			jQuery('#<portlet:namespace />journal_content_search_advanced').hide('slow');
			jQuery('#<portlet:namespace />hide_search_advanced').hide();
			jQuery('#<portlet:namespace />Show_search_advanced').show();
		});
	});
</script>
<!--  End Tu update -->