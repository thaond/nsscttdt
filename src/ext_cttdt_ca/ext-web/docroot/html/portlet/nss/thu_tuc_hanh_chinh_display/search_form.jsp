<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh_display/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh_display.search.ThucTucHanhChinhDisplaySearch"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh_display.search.ThucTucHanhChinhDisplayDisplayTerms"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>

<%
	List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhList = (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList") == null ? new ArrayList<LinhVucThuTucHanhChinh>() : (List<LinhVucThuTucHanhChinh>)renderRequest.getAttribute("linhVucThuTucHanhChinhList"); 
	ThucTucHanhChinhDisplaySearch searchContainer = (ThucTucHanhChinhDisplaySearch)request.getAttribute("liferay-ui:search:searchContainer");
	ThucTucHanhChinhDisplayDisplayTerms displayTerms = (ThucTucHanhChinhDisplayDisplayTerms)searchContainer.getDisplayTerms();
%>

<table class="vanbanphapquy-table" width="100%" cellspacing="0">
		<tr>
			<td width="20%"><liferay-ui:message key="ten-thu-tuc-hanh-chinh" />:&nbsp;</td>
			<td>
				<input style="width: 50.7%" name="<portlet:namespace/><%= ThucTucHanhChinhDisplayDisplayTerms.TEN_THU_TUC_HANH_CHINH %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenThuTucHanhChinh()) %>" />
			</td>
		</tr>
		<tr style="display: none;">
			<td><liferay-ui:message key="linh-vuc" />:&nbsp;</td>
			<td>
				<select name="<portlet:namespace /><%= ThucTucHanhChinhDisplayDisplayTerms.LINH_VUC_THU_TUC %>" id="select2" style="width: 52%;">
		    		<option <%=(displayTerms.getLinhVucThuTuc() == 0  ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
					<%
						if (!linhVucThuTucHanhChinhList.isEmpty()) { 
							for (int i = 0; i < linhVucThuTucHanhChinhList.size(); i ++) {
								LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) linhVucThuTucHanhChinhList.get(i);
								String select = (displayTerms.getLinhVucThuTuc() == linhVucThuTucHanhChinh.getMaLinhVucThuTucHanhChinh() ? "selected" : "" );
					%>
								<option <%= select %>  value="<%= linhVucThuTucHanhChinh.getMaLinhVucThuTucHanhChinh() %>" > <%= linhVucThuTucHanhChinh.getTenLinhVucThuTucHanhChinh() %> </option>
					<%
							}
						}
					%>
		    	</select>
			</td>		
		</tr>
		<tr>
		 	<td><liferay-ui:message key="cap-co-quan-thuc-hien" />:&nbsp;</td>
		    <td >
				<select name="<portlet:namespace /><%= ThucTucHanhChinhDisplayDisplayTerms.CAP_DON_VI_THU_TUC%>" id="<portlet:namespace/>radioCapDV" style="width: 52%;" onchange="selectCapDonVi(this.value)">
		    		<option <%= (displayTerms.getCapDonViThuTuc() == 1 ? "selected" : "" ) %> value="1"><liferay-ui:message key="cap-thanh-pho" /></option>
		    		<option <%= (displayTerms.getCapDonViThuTuc() == 2 ? "selected" : "" ) %> value="2"><liferay-ui:message key="cap-quan-huyen" /></option>
		    		<option <%= (displayTerms.getCapDonViThuTuc() == 3 ? "selected" : "" ) %> value="3"><liferay-ui:message key="cap-phuong-xa" /></option>
		    	</select>
		    </td>
		</tr>
		<tr>
		 	<td><liferay-ui:message key="co-quan-thuc-hien" />:&nbsp;</td>
		    <td >
		    	<div id="donViOnChange">
		    		<select name="<portlet:namespace /><%= ThucTucHanhChinhDisplayDisplayTerms.DON_VI_THU_TUC%>" id='maDonViThuTuc' style="width: 52%;" onchange="setDisplayTermsMaDV(this.value)">
						<option <%=(displayTerms.getDonViThuTuc() == 0 ? "selected" : "" )%> value="0"><liferay-ui:message key="tat-ca" /></option>
						<%
							if (1 == displayTerms.getCapDonViThuTuc()) {
								List<DonViThuTuc> capThanhPhoList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(1, 1);
								for (int i = 0; i < capThanhPhoList.size(); i ++) {
									DonViThuTuc donViThuTuc = (DonViThuTuc) capThanhPhoList.get(i);
									String select = (displayTerms.getDonViThuTuc() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "" );
						%>
							<option  <%= select %> value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							else if (2 == displayTerms.getCapDonViThuTuc()) {
								List<DonViThuTuc> capQuanHuyenList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(2, 1);
								for (int i = 0; i < capQuanHuyenList.size(); i ++) {
									DonViThuTuc donViThuTuc = (DonViThuTuc) capQuanHuyenList.get(i);
									String select = (displayTerms.getDonViThuTuc() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "" );
						%>
							<option  <%= select %> value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							else {
								List<DonViThuTuc> capPhuongXaList = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(3, 1);
								for (int i = 0; i < capPhuongXaList.size(); i ++) {
									DonViThuTuc donViThuTuc = (DonViThuTuc) capPhuongXaList.get(i);
									String select = (displayTerms.getDonViThuTuc() == donViThuTuc.getMaDonViThuTuc() ? "selected" : "" );
						%>
							<option  <%= select %> value="<%= donViThuTuc.getMaDonViThuTuc() %>" > <%= donViThuTuc.getTenDonViThuTuc() %> </option>
						<%
								}
							}
							
						%>
			    	</select>
		    	</div>
		    </td>
		</tr>
		<input type="hidden" name="<portlet:namespace/>donViThuTuc" id="<portlet:namespace/>displayTermsMaDV" value="" />
	</table>	
<br/><input style="margin-left: 20.5%" type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>

