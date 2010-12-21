<%@ include file="/html/portlet/nss/onedoorreport_tinhhinhthulyhosocapso/init.jsp" %>


<%@page import="com.nss.portlet.onedoorreport_tinhhinhthulyhosocapso.search.HoSoCapSoSearch"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.department.model.PmlUser"%>
<%@page import="com.nss.portlet.onedoor.dto.TinhHinhThuLyHoSoCapSoDTO"%>
<%@page import="com.nss.portlet.department.model.Department"%>
<%@page import="com.nss.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.nss.portlet.department.service.PmlUserLocalServiceUtil"%>
<%@page import="com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%><portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/nss/onedoorreport_tinhhinhthulyhosocapso/view" />
</portlet:actionURL>

<script type="text/javascript">
	function <portlet:namespace />setActionFrom(param) {
		var action = "<%=report%>"; 
		if (param != "xembaocao") {
			action = action + "&" + param;
		}
		
		document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
	}
</script>

<%
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/view" );
	HoSoCapSoSearch searchContainer = new HoSoCapSoSearch(renderRequest,portletURL);

	List<String> typeList = new ArrayList<String>();
	List<String> valueTypeList = new ArrayList<String>();
	int start1 = searchContainer.getStart();
	int end1 = searchContainer.getEnd();
	OrderByComparator obc = null;
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String toDay = df.format(date);
	int tonTruoc = 0;
	int daNhan = 0;
	int chuaNhan = 0;
	int hoSoGiaiQuyet = 0;
	int trongHanISO = 0;
	int quaHanISO = 0;
	int tongHoSoCanXuLy = 0;
	int tongHoSoTonDong = 0;
	List<PmlUser> pmlUserList = null;
	Department department = null;
	String departmentId = null;
	List<Long> longList = new ArrayList<Long>();
	int departmentSize = 0;
	List<TinhHinhThuLyHoSoCapSoDTO> tinhHinhThuLyHoSoCapSoList = new ArrayList<TinhHinhThuLyHoSoCapSoDTO>();
	List<Department> departmentList = DepartmentLocalServiceUtil.search(start1, end1, searchContainer.getOrderByComparator());
	int total1 = DepartmentLocalServiceUtil.getDepartmentsCount();
	
	searchContainer.setResults(departmentList);
	searchContainer.setTotal(total1);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
%>

<%
	
	departmentSize = departmentList.size();
	for(int index = 0; index < departmentSize; index ++) {
		
		// Lay tung Phong ban ra xu ly
		department = departmentList.get(index);
		departmentId = department.getDepartmentsId();
		
		// Lay danh sach user thuoc pmlDepartmentId
		try {
			pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(departmentId);
		} catch (Exception e) {
			pmlUserList = new ArrayList<PmlUser>();
		}
		
		for (int i = 0; i < pmlUserList.size(); i++) {
			longList.add(pmlUserList.get(i).getUserId());
		}
		
		
		String phongBan = department.getDepartmentsName();
		tonTruoc = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTruoc(longList, toDay, typeList, valueTypeList, -1, -1, obc).size();
		daNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoDaNhan( longList,  toDay,  typeList, valueTypeList, -1, -1 , obc).size();
		chuaNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoChuaNhan(longList, typeList, valueTypeList, -1, -1 , obc).size();
		hoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoGiaiQuyet(longList, toDay, typeList, valueTypeList, -1, -1, obc).size();
		trongHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTrongHanISO(longList, toDay, typeList, valueTypeList, -1, -1 , obc).size();
		quaHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonQuaHanISO(longList, toDay, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoCanXuLy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHoSoCanXuLy(longList, toDay, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoTonDong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHoSoTonISO(longList, toDay, typeList, valueTypeList, -1, -1 , obc).size();
		
		TinhHinhThuLyHoSoCapSoDTO tinhHinhThuLyHoSoCapSoDTO = new TinhHinhThuLyHoSoCapSoDTO();
		tinhHinhThuLyHoSoCapSoDTO.setId(departmentId);
		tinhHinhThuLyHoSoCapSoDTO.setPhongBan(phongBan);
		tinhHinhThuLyHoSoCapSoDTO.setTonTruoc(tonTruoc);
		tinhHinhThuLyHoSoCapSoDTO.setDaNhan(daNhan);
		tinhHinhThuLyHoSoCapSoDTO.setChuaNhan(chuaNhan);
		tinhHinhThuLyHoSoCapSoDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
		tinhHinhThuLyHoSoCapSoDTO.setHoSoGiaiQuyet(hoSoGiaiQuyet);
		tinhHinhThuLyHoSoCapSoDTO.setTrongHanISO(trongHanISO);
		tinhHinhThuLyHoSoCapSoDTO.setQuaHanISO(quaHanISO);
		tinhHinhThuLyHoSoCapSoDTO.setTongHoSoTonDong(tongHoSoTonDong);
		
		if ((tongHoSoCanXuLy > 0) || (hoSoGiaiQuyet > 0) || (tongHoSoTonDong > 0)) {
			tinhHinhThuLyHoSoCapSoDTO.setHasFile(true);
		}
		
		longList = new ArrayList<Long>();
		tinhHinhThuLyHoSoCapSoList.add(tinhHinhThuLyHoSoCapSoDTO);
	}
%>

<form action="<%= portletURL.toString() %>" method="post"  name="<portlet:namespace />frmReport" >
<div class="title_categ"><liferay-ui:message key="bao-cao-ho-so-cap-so"/></div>
<div class="boxcontent">
	<div class="contain-title-report">
		<h2 class="report-title-HS"><liferay-ui:message key="onedoorpcccreport-tieudetinhhinhthulyhosocapso" /></h2>
		<h5> (ngay <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>)</h5> 
	</div>
	
	<%
		List resultRows1 = searchContainer.getResultRows();
		ResultRow row1 = null;		
		TinhHinhThuLyHoSoCapSoDTO tinhHinhThuLyHoSoCapSoDTO = null;
		
		for ( int i=0; i< departmentList.size(); i++) {
			tinhHinhThuLyHoSoCapSoDTO = tinhHinhThuLyHoSoCapSoList.get(i);
			
			row1 = new ResultRow(tinhHinhThuLyHoSoCapSoDTO, tinhHinhThuLyHoSoCapSoDTO.getId(), i);
			
			// phong ban URL
			PortletURL phongBanURL = renderResponse.createRenderURL();
			phongBanURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			phongBanURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			phongBanURL.setParameter("action","phongban" );
			phongBanURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// ton truoc URL
			PortletURL tonTruocURL = renderResponse.createRenderURL();
			tonTruocURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			tonTruocURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			tonTruocURL.setParameter("action","tontruoc" );
			tonTruocURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// da nhan URL
			PortletURL daNhanURL = renderResponse.createRenderURL();
			daNhanURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			daNhanURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			daNhanURL.setParameter("action","danhan" );
			daNhanURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// chua nhan URL
			PortletURL chuaNhanURL = renderResponse.createRenderURL();
			chuaNhanURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			chuaNhanURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			chuaNhanURL.setParameter("action","chuanhan" );
			chuaNhanURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tong so can xu ly URL
			PortletURL tongCanXuLyURL = renderResponse.createRenderURL();
			tongCanXuLyURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			tongCanXuLyURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			tongCanXuLyURL.setParameter("action","tonghosocanxuly" );
			tongCanXuLyURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// ho so giai quyet URL
			PortletURL hsGiaiQuyetURL = renderResponse.createRenderURL();
			hsGiaiQuyetURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			hsGiaiQuyetURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			hsGiaiQuyetURL.setParameter("action","hosogiaiquyet" );
			hsGiaiQuyetURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// trong han iso URL
			PortletURL trongHanISOURL = renderResponse.createRenderURL();
			trongHanISOURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			trongHanISOURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			trongHanISOURL.setParameter("action","tronghaniso" );
			trongHanISOURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// qua han iso URL
			PortletURL quaHanISOURL = renderResponse.createRenderURL();
			quaHanISOURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			quaHanISOURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			quaHanISOURL.setParameter("action","quahaniso" );
			quaHanISOURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tong ho so ton dong URL
			PortletURL tongTonDongURL = renderResponse.createRenderURL();
			tongTonDongURL.setParameter("struts_action","/nss/onedoorreport_tinhhinhthulyhosocapso/filedetails" );
			tongTonDongURL.setParameter("id",tinhHinhThuLyHoSoCapSoDTO.getId() );
			tongTonDongURL.setParameter("action","tonghosotondong" );
			tongTonDongURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// phong ban
			if (tinhHinhThuLyHoSoCapSoDTO.isHasFile() == true) {
				row1.addText(tinhHinhThuLyHoSoCapSoDTO.getPhongBan(),phongBanURL.toString());
			} else {
				row1.addText(tinhHinhThuLyHoSoCapSoDTO.getPhongBan());
			}
			
			// ton truoc
			if (tinhHinhThuLyHoSoCapSoDTO.getTonTruoc() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTonTruoc()),tonTruocURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTonTruoc()));
			}
			
			// da nhan
			if (tinhHinhThuLyHoSoCapSoDTO.getDaNhan() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getDaNhan()),daNhanURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getDaNhan()));
			}
			
			// chua nhan
			if (tinhHinhThuLyHoSoCapSoDTO.getChuaNhan() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getChuaNhan()),chuaNhanURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getChuaNhan()));
			}
			
			// tong can xu ly
			if (tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy()),tongCanXuLyURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTongHoSoCanXuLy()));
			}
			
			// ho so giai quyet
			if (tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet()),hsGiaiQuyetURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getHoSoGiaiQuyet()));
			}
			
			// trong han iso
			if (tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO()),trongHanISOURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTrongHanISO()));
			}
			
			// qua han iso
			if (tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO()),quaHanISOURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getQuaHanISO()));
			}
			
			// tong ton dong
			if (tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong()),tongTonDongURL.toString());	
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapSoDTO.getTongHoSoTonDong()));
			}
			
			resultRows1.add(row1);
		}
	%>
	
	<%
	
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	
	if (end > total) {
		end = total;
	}
	
	if (rowChecker != null) {
		if (headerNames != null) {
			headerNames.add(0, rowChecker.getAllRowsCheckBox());
		}
	}
	
	if (resultRows.isEmpty() && (headerNames == null)) {
		headerNames = new ArrayList<String>();
	
		headerNames.add(StringPool.BLANK);
	}
	%>
	
	<c:if test="<%= (resultRows.size() > 0) || ((resultRows.size() == 0) && (emptyResultsMessage != null)) %>">
		<c:if test="<%= paginate %>">
		
			<div  class="taglib-search-iterator-page-iterator-top">	
				<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
			
		</c:if>
		<div class="results-grid" >
			<table class="taglib-search-iterator" cellspacing="0" width="100%">
			
				<tr class="portlet-section-header results-header">
					<td rowspan="3" width="30%"><b><liferay-ui:message key="onedoorpcccreport-phongban" /></b></td>
					<td colspan="4" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosocanxuly" /></b></td>
					<td rowspan="3" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
					<td colspan="3" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosotondong" /></b></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tontruoc" /></b></td>
					<td colspan="2" align="center"><b><liferay-ui:message key="onedoorpcccreport-moichuyenden" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tronghaniso" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-quahaniso" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-danhan" /></b></td>
					<td width="5%" align="center" ><b><liferay-ui:message key="onedoorpcccreport-chuanhan" /></b></td>
				</tr>
				<tr bgcolor="#8ad1fe">
					<td >(1)</td>
					<td align="center">(2)</td>
					<td align="center">(3)</td>
					<td align="center">(4)</td>
					<td align="center">(5)</td>
					<td align="center">(6)</td>
					<td align="center">(7)</td>
					<td align="center">(8)</td>
					<td align="center">(9)</td>
				</tr>
				
		<%
			boolean allRowsIsChecked = true;
	
			for (int i = 0; i < resultRows.size(); i++) {
				ResultRow row = (ResultRow)resultRows.get(i);
	
				String className = "portlet-section-alternate results-row alt";
				String classHoverName = "portlet-section-alternate-hover results-row alt hover";
	
				if (MathUtil.isEven(i)) {
					className = "portlet-section-body results-row";
					classHoverName = "portlet-section-body-hover results-row hover";
				}
	
				if (Validator.isNotNull(row.getClassName())) {
					className += " " + row.getClassName();
				}
	
				if (Validator.isNotNull(row.getClassHoverName())) {
					classHoverName += " " + row.getClassHoverName();
				}
	
				if (row.isRestricted()) {
					className += " restricted";
					classHoverName += " restricted";
				}
	
				row.setClassName(className);
				row.setClassHoverName(classHoverName);
	
				request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW, row);
	
				List entries = row.getEntries();
	
				if (rowChecker != null) {
					boolean rowIsChecked = rowChecker.isChecked(row.getObject());
	
					if (!rowIsChecked) {
						allRowsIsChecked = false;
					}
	
					row.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(rowIsChecked, row.getPrimaryKey()));
				}
			%>
	
				<tr class="<%= className %>"
					<c:if test="<%= searchContainer.isHover() %>">
						onmouseover="this.className = '<%= classHoverName %>';" onmouseout="this.className = '<%= className %>';"
					</c:if>
				>
	
				<%
				for (int j = 0; j < entries.size(); j++) {
					SearchEntry entry = (SearchEntry)entries.get(j);
	
					entry.setIndex(j);
	
					request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW_ENTRY, entry);
				%>
	
					<td align="<%= entry.getAlign() %>" class="rptso-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
	
						<%
						entry.print(pageContext);
						%>
	
					</td>
	
				<%
				}
				%>
	
				</tr>
	
			<%
			}
			%>
				
			</table>
				
		</div>
		
		<c:if test="<%= (resultRows.size() > 10) && paginate %>">
			<div class="taglib-search-iterator-page-iterator-bottom">
				<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
		</c:if>
		
	</c:if>	
				
	<table width="100%" cellspacing="0">
		<tr>
			<td style="padding-left:3px;padding-bottom: 15px">
				<br /><b>H&#432;&#7899;ng d&#7851;n</b><br />
				(1) = T&ecirc;n ph&ograve;ng ban.<br />
				(2) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; &#273;ang &#7903; t&#7841;i chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng x&#7917; l&yacute; v&agrave; ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; t&iacute;nh &#273;&#7871;n ng&agrave;y th&#7889;ng k&ecirc;.<br />
				(3) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do Ph&ograve;ng kh&aacute;c chuy&#7875;n &#273;&#7871;n cho chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng v&agrave; chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng &#273;&atilde; nh&#7853;n.<br />
				(4) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do Ph&ograve;ng kh&aacute;c chuy&#7875;n &#273;&#7871;n cho chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng v&agrave; chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng ch&#432;a nh&#7853;n.<br />
				(5) = (2) + (3) + (4)<br />
				(6) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; do chuy&ecirc;n vi&ecirc;n trong Ph&ograve;ng chuy&#7875;n qua Ph&ograve;ng kh&aacute;c trong ng&agrave;y th&#7889;ng k&ecirc;.<br />
				(7) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; c&ograve;n trong Ph&ograve;ng, ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; v&agrave; trong th&#7901;i h&#7841;n theo ISO.<br />
				(8) = S&#7889; l&#432;&#7907;ng h&#7891; s&#417; c&ograve;n trong Ph&ograve;ng, ch&#432;a k&#7871;t th&uacute;c qu&aacute; tr&igrave;nh x&#7917; l&yacute; v&agrave; v&#432;&#7907;t qu&aacute; th&#7901;i h&#7841;n theo ISO.<br />
				(9) = (7) + (8) ho&#7863;c (5) - (6)<br /><br />
				<font style="font-style:italic">T&iacute;nh &#273;&#7871;n tr&#7841;ng th&aacute;i x&#7917; l&yacute; m&#7899;i nh&#7845;t c&#7911;a t&#7915;ng b&#7897; h&#7891; s&#417; t&#7841;i Ph&ograve;ng ban.</font>
			</td>
		</tr>
	</table>
	<div align="right">
				<input class="button" type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' onclick="<portlet:namespace />setActionFrom('<portlet:namespace />report=true');<portlet:namespace />frmReport.submit();"  />
	</div>
	
</div>
</form>