<%@ include file="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapphong/init.jsp" %>
<!-- %@ include file="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapphong/page_iterator/init_search.jsp" %-->

<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.onedoorpcccreport.dto.TinhHinhThuLyHoSoCapPhongDTO"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.sgs.portlet.onedoorpcccreport_tinhhinhthulyhosocapphong.search.HoSoCapPhongSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%><liferay-util:include page="/html/portlet/ext/onedoorpcccreport_tinhhinhthulyhosocapphong/js/onedoorpcccreport_tinhhinhthulyhosocapphong-js.jsp"></liferay-util:include>

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/view" />
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
	portletURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/view" );
	HoSoCapPhongSearch searchContainer = new HoSoCapPhongSearch(renderRequest, portletURL);
	
	List<String> typeList = new ArrayList<String>();
	List<String> valueTypeList = new ArrayList<String>();
	int start1 = searchContainer.getStart();
	int end1 = searchContainer.getEnd();
	OrderByComparator obc = null;
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String today = df.format(date);
	int tonTruoc = 0;
	int daNhan = 0;
	int chuaNhan = 0;
	int tuGiaiQuyet = 0;
	int nguoiKhacThuLyThay = 0;
	int trongHanISO = 0;
	int quaHanISO = 0;
	int tongHoSoCanXuLy = 0;
	int tongHoSoGiaiQuyet = 0;
	int tongHoSoTonDong = 0;
	List<TinhHinhThuLyHoSoCapPhongDTO> tinhHinhThuLyHoSoCapPhongList = new ArrayList<TinhHinhThuLyHoSoCapPhongDTO>();
	List<Long> userList = new ArrayList<Long>();
	String chuyenVien = "";
	
	long userId = PortalUtil.getUserId(renderRequest);
	String pmlDepartmentId = PmlUserLocalServiceUtil.getPmlUser(userId).getDepartmentsId(); 
	List<PmlUser> users = PmlUserLocalServiceUtil.searchByDep(pmlDepartmentId, start1 , end1, searchContainer.getOrderByComparator());
	int total1 = PmlUserLocalServiceUtil.searchCountByDep(pmlDepartmentId);
		
	searchContainer.setResults(users);
	searchContainer.setTotal(total1);
		
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
		
%>	

<%	

	int size = users.size();
	for(int index = 0; index < size; index ++) { 		
		userList.add(users.get(index).getUserId());
		try {
			chuyenVien = PmlUserLocalServiceUtil.getFullName(users.get(index).getUserId());
		} catch (Exception e) {
			chuyenVien = "";
		}
		
		tonTruoc = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTruoc(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		daNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoDaNhan(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		chuaNhan = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoChuaNhan(userList, typeList, valueTypeList, -1, -1 , obc).size();
		tuGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTuGiaiQuyet(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		nguoiKhacThuLyThay = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoNguoiKhacThuLyThay(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		trongHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonTrongHanISO(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		quaHanISO = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoTonQuaHanISO(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoCanXuLy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHoSoCanXuLy(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHoSoGiaiQuyet(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoTonDong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHoSoTonISO(userList, today, typeList, valueTypeList, -1, -1 , obc).size();
		
		TinhHinhThuLyHoSoCapPhongDTO tinhHinhThuLyHoSoCapPhongDTO = new TinhHinhThuLyHoSoCapPhongDTO();
		tinhHinhThuLyHoSoCapPhongDTO.setId(users.get(index).getUserId());
		tinhHinhThuLyHoSoCapPhongDTO.setChuyenVien(chuyenVien);
		tinhHinhThuLyHoSoCapPhongDTO.setTonTruoc(tonTruoc);
		tinhHinhThuLyHoSoCapPhongDTO.setDaNhan(daNhan);
		tinhHinhThuLyHoSoCapPhongDTO.setChuaNhan(chuaNhan);
		tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoCanXuLy(tongHoSoCanXuLy);
		tinhHinhThuLyHoSoCapPhongDTO.setTuGiaiQuyet(tuGiaiQuyet);
		tinhHinhThuLyHoSoCapPhongDTO.setNguoiKhacThuLyThay(nguoiKhacThuLyThay);
		tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoGiaiQuyet(tongHoSoGiaiQuyet);
		tinhHinhThuLyHoSoCapPhongDTO.setTrongHanISO(trongHanISO);
		tinhHinhThuLyHoSoCapPhongDTO.setQuaHanISO(quaHanISO);
		tinhHinhThuLyHoSoCapPhongDTO.setTongHoSoTonDong(tongHoSoTonDong);
		
		if ((tongHoSoCanXuLy > 0) ||(tongHoSoGiaiQuyet > 0) || (tongHoSoTonDong > 0)) {
			tinhHinhThuLyHoSoCapPhongDTO.setHasFile(true);
		}
		userList = new ArrayList();
		tinhHinhThuLyHoSoCapPhongList.add(tinhHinhThuLyHoSoCapPhongDTO);
	}
%>


<form action="<%= portletURL.toString() %>" method="post"  name="<portlet:namespace />frmReport" >
<div class="title_categ"><liferay-ui:message key="bao-cao-ho-so-cap-phong"/></div>
<div class="boxcontent">
<div class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="onedoorpcccreport-tieudetinhhinhthulyhosocapphong" /></h2>
	<h5>(<liferay-ui:message key="Ngay"/>&nbsp;<%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>)</h5> 
</div>
	 
	<%
		List resultRows1 = searchContainer.getResultRows();
		ResultRow row1 = null;
		PmlUser pmlUser = null;
		TinhHinhThuLyHoSoCapPhongDTO tinhHinhThuLyHoSoCapPhongDTO = null;
		
		for ( int i=0; i< users.size(); i++) {
			
			pmlUser = users.get(i);
			pmlUser = pmlUser.toEscapedModel();
			try {
				chuyenVien = PmlUserLocalServiceUtil.getFullName(pmlUser.getUserId());
			} catch (Exception e) {
				chuyenVien = "";
			}
			
			tinhHinhThuLyHoSoCapPhongDTO = tinhHinhThuLyHoSoCapPhongList.get(i);
			
			row1 = new ResultRow(tinhHinhThuLyHoSoCapPhongDTO, tinhHinhThuLyHoSoCapPhongDTO.getId(), i);
			
			// chuyen vien URL
			PortletURL chuyenVienURL = renderResponse.createRenderURL();
			chuyenVienURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			chuyenVienURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			chuyenVienURL.setParameter("action","chuyenvien" );
			chuyenVienURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			// ton truoc URL
			PortletURL tonTruocURL = renderResponse.createRenderURL();
			tonTruocURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			tonTruocURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			tonTruocURL.setParameter("action","tontruoc" );
			tonTruocURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// da nhan URL
			PortletURL daNhanURL = renderResponse.createRenderURL();
			daNhanURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			daNhanURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			daNhanURL.setParameter("action","danhan" );
			daNhanURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// chua nhan URL
			PortletURL chuaNhanURL = renderResponse.createRenderURL();
			chuaNhanURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			chuaNhanURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			chuaNhanURL.setParameter("action","chuanhan" );
			chuaNhanURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tong ho so can xu ly URL
			PortletURL tongCanXuLyURL = renderResponse.createRenderURL();
			tongCanXuLyURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			tongCanXuLyURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			tongCanXuLyURL.setParameter("action","tonghosocanxuly" );
			tongCanXuLyURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tu giai quyet URL
			PortletURL tuGiaiQuyetURL = renderResponse.createRenderURL();
			tuGiaiQuyetURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			tuGiaiQuyetURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			tuGiaiQuyetURL.setParameter("action","tugiaiquyet" );
			tuGiaiQuyetURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// nguoi khac thu ly thay URL
			PortletURL nguoiKhacXuLyURL = renderResponse.createRenderURL();
			nguoiKhacXuLyURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			nguoiKhacXuLyURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			nguoiKhacXuLyURL.setParameter("action","nguoikhacthulythay" );
			nguoiKhacXuLyURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tong ho so giai quyet URL
			PortletURL hsGiaiQuyetURL = renderResponse.createRenderURL();
			hsGiaiQuyetURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			hsGiaiQuyetURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			hsGiaiQuyetURL.setParameter("action","tonghosogiaiquyet" );
			hsGiaiQuyetURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			// trong han iso URL
			PortletURL trongHanISOURL = renderResponse.createRenderURL();
			trongHanISOURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			trongHanISOURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			trongHanISOURL.setParameter("action","tronghaniso" );
			trongHanISOURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// qua han iso URL
			PortletURL quaHanISOURL = renderResponse.createRenderURL();
			quaHanISOURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			quaHanISOURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			quaHanISOURL.setParameter("action","quahaniso" );
			quaHanISOURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			// tong ho so ton dong URL
			PortletURL tongTonDongURL = renderResponse.createRenderURL();
			tongTonDongURL.setParameter("struts_action","/sgs/onedoorpcccreport_tinhhinhthulyhosocapphong/filedetails" );
			tongTonDongURL.setParameter("id",String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getId()));
			tongTonDongURL.setParameter("action","tonghosotondong" );
			tongTonDongURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			//chuyen vien
			if (tinhHinhThuLyHoSoCapPhongDTO.isHasFile() == true) {
				row1.addText(chuyenVien, chuyenVienURL.toString());
			} else {
				row1.addText(chuyenVien);
			}
			
			//ton truoc
			if (tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc()), tonTruocURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTonTruoc()));
			}
			
			//da nhan
			if (tinhHinhThuLyHoSoCapPhongDTO.getDaNhan() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getDaNhan()), daNhanURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getDaNhan()));
			}
			
			//chua nhan
			if (tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan()), chuaNhanURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getChuaNhan()));
			}
			
			//tong ho so can xu ly
			if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy()),tongCanXuLyURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoCanXuLy()));
			}
			
			// tu giai quyet 
			if (tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet()),tuGiaiQuyetURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTuGiaiQuyet()));
			}
			
			// nguoi khac thu ly thay
			if (tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay()),nguoiKhacXuLyURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getNguoiKhacThuLyThay()));
			}
			
			// tong ho so giai quyet 
			if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet()),hsGiaiQuyetURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoGiaiQuyet()));
			}
			
			// trong han iso
			if (tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO()),trongHanISOURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTrongHanISO()));
			}
			
			// qua han iso
			if (tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO()),quaHanISOURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getQuaHanISO()));
			}
			
			// tong ho so ton dong
			if (tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong() > 0) {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong()),tongTonDongURL.toString());
			} else {
				row1.addText(String.valueOf(tinhHinhThuLyHoSoCapPhongDTO.getTongHoSoTonDong()));
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
<div class="results-grid">
	<table class="taglib-search-iterator" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header">
					<td rowspan="3" width="25%"><b><liferay-ui:message key="onedoorpcccreport-chuyenvien" /></b></td>
					<td colspan="4" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosocanxuly" /></b></td>
					<td colspan="3" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
					<td colspan="3" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosotondong" /></b></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tontruoc" /></b></td>
					<td colspan="2"><b><liferay-ui:message key="onedoorpcccreport-moichuyenden" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tugiaiquyet" /></b></td>
					<td rowspan="2" width="6%" align="center"><b><liferay-ui:message key="onedoorpcccreport-nguoikhacthulythay" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tronghaniso" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-quahaniso" /></b></td>
					<td rowspan="2" width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-danhan" /></b></td>
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-chuanhan" /></b></td>
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
	
					<td class="col_cp-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
	
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
<div id="table-button" align="right">
		<input class="button" type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' onclick="<portlet:namespace />setActionFrom('<portlet:namespace />report=true');<portlet:namespace />frmReport.submit();"  />
</div>
</div>
</form>

		
