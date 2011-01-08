package com.sgs.portlet.onedoorpcccreport_baocaohosothang.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangDTO;
import com.sgs.portlet.onedoorpcccreport.util.BaoCaoHoSoThangUtil;
import com.sgs.portlet.onedoorpcccreport_baocaohosothang.search.BaoCaoHoSoThangDisplayTerms;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		boolean report = ParamUtil.getBoolean(req, "report", false);
		List<String> typeList = new ArrayList<String>();
		List<String> valueTypeList = new ArrayList<String>();
		int start = -1;
		int end = -1;
		OrderByComparator obc = null;
		
		if ( report == true) {
			Date fromDate = new Date();
			Date toDate = new Date();
			
			String fromDateString = ParamUtil.getString(req, BaoCaoHoSoThangDisplayTerms.TUNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			String toDateString = ParamUtil.getString(req, BaoCaoHoSoThangDisplayTerms.DENNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			
			if(fromDateString != "" && toDateString != "") {
				fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDateString);
				toDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDateString);
			}
			
			xuatFileBaoCaoHoSoThang(req, res, fromDate, toDate, typeList,  valueTypeList, start, end, obc);
		}
	}

	
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
//				//Yenlt update 05/04/2010
//				String fromDate = ParamUtil.getString(req, BaoCaoHoSoThangDisplayTerms.TUNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//				String toDate = ParamUtil.getString(req, BaoCaoHoSoThangDisplayTerms.DENNGAY, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//				
////				String fromDate = ParamUtil.getString(req, "fromDate", "");
////				String toDate = ParamUtil.getString(req, "toDate", "");
//				//end
//				if(Validator.isNull(fromDate) == true && Validator.isNull(toDate) == true) {
//					toDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//					String[] arrToDate = toDate.split("/");
//					fromDate = "01/" + arrToDate[1] + "/" + arrToDate[2];
//				}
//				//yenlt update 08/04/2010
//				List<BaoCaoHoSoThangDTO> listBaoCaoHoSoThangDTO = getBaoCaoHoSoThang(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate), new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
//				List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
//				for (int i=0; i< listBaoCaoHoSoThangDTO.size()-1 ; i++) {
//					baoCaoHoSoThangList.add(listBaoCaoHoSoThangDTO.get(i));
//				}
//				req.setAttribute("fromDate", fromDate);
//				req.setAttribute("toDate", toDate);
//				req.setAttribute("baoCaoHoSoThangList", baoCaoHoSoThangList);
//				req.setAttribute("baoCaoHoSoThangTotal", listBaoCaoHoSoThangDTO.get(listBaoCaoHoSoThangDTO.size()-1));
//				
				return mapping.findForward("portlet.sgs.onedoorpcccreport_baocaohosothang.view");
			}
	}

	public List<BaoCaoHoSoThangDTO> getBaoCaoHoSoThangReport(String fromDate, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
		
		try {
			
			int tongTonDauKy = 0;
			int tongHoSoNhanTrongThang = 0;
			int tongTongCong = 0;
			int tongSoDungHan = 0;
			int tongSoTreHan = 0;
			int tongTrongHan = 0;
			int tongDaTreHan = 0;
			int tongChinhSuaBoSung = 0;
			String tongTyLeHoSoDungHan = "";
			
			// Lay cac FileType co trong he thong
			List<PmlFileType> pmlFileTypeList = PmlFileTypeUtil.findAll();
			int pmlFileTypeSize = pmlFileTypeList.size();
			for(int index = 0; index < pmlFileTypeList.size(); index ++) {
				
				// Lay ra tung FileType de xu ly
				PmlFileType pmlFileType = pmlFileTypeList.get(index);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
				List<PmlFileType> listFileTypeIndex = new ArrayList<PmlFileType>();
				listFileTypeIndex.add(pmlFileType);
				
				int stt = index + 1;
				String tenSanPham = StringUtils.convertToRTF(pmlFileType.getFileTypeName());
				
				int tonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(listFileTypeIndex, fromDate, typeList, valueTypeList, start, end, obc).size();
				int hoSoNhanTrongThang = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int tongCong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int soDungHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int soTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int trongHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int daTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				int chinhSuaBoSung = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
				
				// Cach tinh: [(hoan thanh dung han + ton trong han + ton chinh sua, bo sung) / tong ho so can xu ly trong thang]*100%
				String tyLeHoSoDungHan = StringUtils.convertToRTF("-");

				if (tongCong > 0) {
					int tongBaLoaiHoSo = soDungHan+trongHan+chinhSuaBoSung;
					
					if ((tongBaLoaiHoSo == 0) || (tongBaLoaiHoSo == tongCong)) {
						int tyLeChan = (tongBaLoaiHoSo / tongCong) * 100;
						tyLeHoSoDungHan = tyLeChan +"%";
					} else {
						tyLeHoSoDungHan = Round(((float)tongBaLoaiHoSo / tongCong)* 100,2)+ "%";
					}
				} else {
					tyLeHoSoDungHan = "/";
				}
				
				BaoCaoHoSoThangDTO baoCaoHoSoThangDTO = new BaoCaoHoSoThangDTO();
				baoCaoHoSoThangDTO.setFileTypeId(pmlFileTypeId);
				baoCaoHoSoThangDTO.setStt(stt);
				baoCaoHoSoThangDTO.setTenSanPham(tenSanPham);
				baoCaoHoSoThangDTO.setTonDauKy(tonDauKy);
				baoCaoHoSoThangDTO.setHoSoNhanTrongThang(hoSoNhanTrongThang);
				baoCaoHoSoThangDTO.setTongCong(tongCong);
				baoCaoHoSoThangDTO.setSoDungHan(soDungHan);
				baoCaoHoSoThangDTO.setSoTreHan(soTreHan);
				baoCaoHoSoThangDTO.setTrongHan(trongHan);
				baoCaoHoSoThangDTO.setDaTreHan(daTreHan);
				baoCaoHoSoThangDTO.setChinhSuaBoSung(chinhSuaBoSung);
				baoCaoHoSoThangDTO.setTyLeHoSoDungHan(tyLeHoSoDungHan);
				
				baoCaoHoSoThangList.add(baoCaoHoSoThangDTO);
				
			}
			tongTonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(pmlFileTypeList, fromDate, typeList, valueTypeList, start, end, obc).size();
			tongHoSoNhanTrongThang = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongTongCong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongSoDungHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongSoTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongTrongHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongDaTreHan= PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			tongChinhSuaBoSung = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(pmlFileTypeList, fromDate, toDate, typeList, valueTypeList, start, end, obc).size();
			
			BaoCaoHoSoThangDTO tongCongDTO = new BaoCaoHoSoThangDTO();
			tongCongDTO.setFileTypeId("all");
			tongCongDTO.setStt(pmlFileTypeSize + 1);
			tongCongDTO.setTenSanPham(StringUtils.convertToRTF(""));
			tongCongDTO.setTonDauKy(tongTonDauKy);
			tongCongDTO.setHoSoNhanTrongThang(tongHoSoNhanTrongThang);
			tongCongDTO.setTongCong(tongTongCong);
			tongCongDTO.setSoDungHan(tongSoDungHan);
			tongCongDTO.setSoTreHan(tongSoTreHan);
			tongCongDTO.setTrongHan(tongTrongHan);
			tongCongDTO.setDaTreHan(tongDaTreHan);
			tongCongDTO.setChinhSuaBoSung(tongChinhSuaBoSung);
			tongCongDTO.setTyLeHoSoDungHan("-");
			if (tongTongCong > 0) {
				int total = tongSoDungHan + tongTrongHan + tongChinhSuaBoSung;
				
				if ((total == 0) || (total == tongTongCong)) {
					int tongTyLeChan = (total / tongTongCong) * 100;
					tongTyLeHoSoDungHan = tongTyLeChan +"%";
				} else {
					tongTyLeHoSoDungHan = Round(((float)total / tongTongCong)* 100,2)+ "%";	
				}
			} else { 
				tongTyLeHoSoDungHan = "/";
			}
			tongCongDTO.setTyLeHoSoDungHan(tongTyLeHoSoDungHan);
			baoCaoHoSoThangList.add(tongCongDTO);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return baoCaoHoSoThangList;
		
	}
	
	/*
	private void xuatFileBaoCaoHoSoThang(PortletRequest req, PortletResponse res, Date fromDate, Date toDate) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		File templateFile = new File(request.getSession().getServletContext().getRealPath("reports/BaoCaoHoSoThang.odt"));
        File outputFile = File.createTempFile("report", ".doc");

        DocumentTemplate template = null;
        if (templateFile.isDirectory()) {
            template = new UnzippedDocumentTemplate(templateFile);
        } else {
            template = new ZippedDocumentTemplate(templateFile);
        }

        Map model = new HashMap();
        model.put("baoCaoHoSoThangList", getBaoCaoHoSoThang(fromDate, toDate));

		if ("odt".equals(FilenameUtils.getExtension(outputFile.getName()))) {
			template.createDocument(model, new FileOutputStream(outputFile));
		} else {
	        OpenOfficeConnection connection = new SocketOpenOfficeConnection();
	        try {
	            connection.connect();
	        } catch (ConnectException connectException) {
	            System.err.println("ERROR: connection failed. Please make sure OpenOffice.org is running and listening on port "+ SocketOpenOfficeConnection.DEFAULT_PORT +".");
	            System.exit(1);
	        }

			File temporaryFile = File.createTempFile("document", ".odt");
			temporaryFile.deleteOnExit();
	        template.createDocument(model, new FileOutputStream(temporaryFile));

	        try {
	            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
	            converter.convert(temporaryFile, outputFile);
	        } finally {
	            connection.disconnect();
	        }
		}
		
		String contentType = MimeTypesUtil.getContentType(outputFile);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ServletResponseUtil.sendFile(response, outputFile.getName(), inputStream, contentType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * Yenlt up date 05/04/2010
	 * @param Rval
	 * @param Rpl
	 * @return
	 */
	public static float Round(float Rval, int Rpl) {
		
		float p = (float) Math.pow(10,Rpl);
		Rval = Rval * p;
		float tmp = Math.round(Rval);
		return tmp / p;
	}

	private void xuatFileBaoCaoHoSoThang(PortletRequest req, PortletResponse res, Date fromDate, Date toDate, List<String> typeList, List<String> valueTypeList, int start, int end , OrderByComparator obc) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		String path = request.getSession().getServletContext().getRealPath("reports");
		String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
		String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
		List<BaoCaoHoSoThangDTO> listDTO = getBaoCaoHoSoThangReport(fromDate1, toDate1, typeList, valueTypeList, start, end, obc);
		BaoCaoHoSoThangUtil rtfUtil = new BaoCaoHoSoThangUtil(path, listDTO	, new SimpleDateFormat("dd/MM/yyyy").format(fromDate), new SimpleDateFormat("dd/MM/yyyy").format(toDate));
		
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/BaoCaoHoSoThang.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
		
}
