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

<%@ include file="/html/portlet/nss/navigation/init.jsp" %>

<style type="text/css">
.nav-menu li a {
	font-weight: bold;
	color: #fcff00 !important;
	background-image: url(/html/images/iconh2.png) !important;
	background-repeat: no-repeat;
	background-position: left 4px;
}
.nav-menu li a.selected {
	font-size: 12px;
	font-weight: bold;
	/*text-transform: uppercase*/;
	color: #fffc00 !important;
	/*background-image: url(/html/images/iconli_hv.png) !important;
	background-repeat: no-repeat !important;
	background-position: left 6px !important;*/
	padding-left: 15px;
	padding-bottom: 0px;
	margin-top: 0px;
}
.nav-menu li ul li {
	background-image: url(/html/images/bglinemn.jpg) !important;
	background-repeat: repeat-x;
	background-position: bottom;
}
.nav-menu li ul li a {
	font-weight: normal !important;
	color: #fff !important;
	background-image: url(/html/images/iconli.png) !important;
	background-repeat: no-repeat !important;
	background-position: left 6px !important;
}
</style> 

<div id="leftmenu">
    <div id="topmnl">
    <div id="bttmnl">

<liferay-ui:navigation
	bulletStyle="<%= bulletStyle %>"
	displayStyle="<%= displayStyle %>"
	headerType="<%= headerType %>"
	rootLayoutType="<%= rootLayoutType %>"
	rootLayoutLevel="<%= rootLayoutLevel %>"
	includedLayouts="<%= includedLayouts %>"
	nestedChildren="<%= nestedChildren %>"
/>
	
	</div>
    </div>
</div>