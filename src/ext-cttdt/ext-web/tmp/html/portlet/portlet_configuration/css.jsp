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

<%@ include file="/html/portlet/css_init.jsp" %>

.portlet-configuration {
}

.portlet-configuration .edit-permissions form:after {
	clear: both;
	content: ".";
	display: block;
	height: 0;
	visibility: hidden;
}

.ie .portlet-configuration .edit-permissions form {
	height: 1%;
}

.portlet-configuration .edit-permissions .assign-permissions {
	float: left;
}

.portlet-configuration .edit-permissions .assign-permissions .button-holder {
	position: relative;
}

.portlet-configuration .edit-permissions .assign-permissions .button-holder .finished {
	position: absolute;
	right: 0;
}

.portlet-configuration .facebook-api td {
	padding-bottom: 2px;
}

.portlet-configuration .facebook-api .api-input {
	padding-right: 12px;
}

.ie .portlet-configuration .facebook-api .api-input {
	padding-right: 17px;
}

.portlet-configuration .facebook-api .lfr-input-text {
	width: 100%;
}

.portlet-configuration .canvas-url .url-text {
	padding-right: 0;
	text-align: right;
}

.portlet-configuration .canvas-url .url-input {
	padding-left: 0
}