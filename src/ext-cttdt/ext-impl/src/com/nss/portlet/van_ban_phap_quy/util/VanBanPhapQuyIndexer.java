package com.nss.portlet.van_ban_phap_quy.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.DocumentSummary;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuyDisplayTerms;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil;
/**
 * 
 * @author yenlt 13072010
 *
 */
public class VanBanPhapQuyIndexer implements Indexer{

	public static final String PORTLET_ID = "NSS_VAN_BAN_PHAP_QUY";
	
	public static Document getVanBanPhapQuy(long companyId,
			VanBanPhapQuy vanBanPhapQuy) throws UnsupportedEncodingException {
		LoaiVanBan loaiVanBan = null;
		LinhVucVanBan linhVucVanBan = null;
		CoQuanBanHanh coQuanBanHanh = null;
		String tenLoaiVanBan = "";
		String tenLinhVucVanBan = "";
		String tenCoQuanBanHanh = "";
		try {
			loaiVanBan = LoaiVanBanLocalServiceUtil.getLoaiVanBan(vanBanPhapQuy.getMaLoaiVanBan());
			tenLoaiVanBan = loaiVanBan.getTenLoaiVanBan();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			linhVucVanBan = LinhVucVanBanLocalServiceUtil.getLinhVucVanBan(vanBanPhapQuy.getMaLinhVucVanBan());
			tenLinhVucVanBan = linhVucVanBan.getTenLinhVucVanBan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.getCoQuanBanHanh(vanBanPhapQuy.getMaCoQuanBanHanh());
			tenCoQuanBanHanh = coQuanBanHanh.getTenCoQuanBanHanh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getVanBanPhapQuy(companyId, vanBanPhapQuy.getMaVanBanPhapQuy(), vanBanPhapQuy.getKyHieuVanBan(), vanBanPhapQuy.getTomTat(), vanBanPhapQuy.getNguoiKy(),
				vanBanPhapQuy.getMaLoaiVanBan(), tenLoaiVanBan, vanBanPhapQuy.getMaLinhVucVanBan(), tenLinhVucVanBan, vanBanPhapQuy.getMaCoQuanBanHanh(), tenCoQuanBanHanh, vanBanPhapQuy.getNgayBanHanh());
	}
	
	public static Document getVanBanPhapQuy(long companyId,
			long maVanBanPhapQuy, String kyHieuVanBan, String tomTat, String nguoiKy,
			long maLoaiVanBan, String tenLoaiVanBan,long maLinhVucVanBan, String tenLinhVucVanBan, long maCoQuanBanHanh, String tenCoQuanBanHanh, Date ngayBanHanh) {
		kyHieuVanBan = kyHieuVanBan.toLowerCase();
		tomTat = tomTat.toLowerCase();
		tenLoaiVanBan = tenLoaiVanBan.toLowerCase();
		tenLinhVucVanBan = tenLinhVucVanBan.toLowerCase();
		tenCoQuanBanHanh = tenCoQuanBanHanh.toLowerCase();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, maVanBanPhapQuy);
		
		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.ENTRY_CLASS_PK, maVanBanPhapQuy);
		
		doc.addKeyword(VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN, kyHieuVanBan);
		doc.addText(VanBanPhapQuyDisplayTerms.TOM_TAT, tomTat);
		doc.addText(VanBanPhapQuyDisplayTerms.NGUOI_KY, nguoiKy);
		
		doc.addKeyword(VanBanPhapQuyDisplayTerms.MA_LOAI_VAN_BAN, maLoaiVanBan);
		doc.addKeyword(VanBanPhapQuyDisplayTerms.MA_LINH_VUC_VAN_BAN, maLinhVucVanBan);
		doc.addKeyword(VanBanPhapQuyDisplayTerms.MA_CO_QUAN_BAN_HANH, maCoQuanBanHanh);
		
		doc.addText(VanBanPhapQuyDisplayTerms.LOAI_VAN_BAN, tenLoaiVanBan);
		doc.addText(VanBanPhapQuyDisplayTerms.LINH_VUC_VAN_BAN, tenLinhVucVanBan);
		doc.addText(VanBanPhapQuyDisplayTerms.CO_QUAN_BAN_HANH, tenCoQuanBanHanh);
		
		doc.addKeyword("ngayBanHanh", ngayBanHanh != null ? dateFormat.format(ngayBanHanh) : "");
		
		return doc;
	}
	
	public static Document getVanBanPhapQuy(long companyId,
			long maVanBanPhapQuy, String kyHieuVanBan, String tomTat, String nguoiKy,
			long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh, Date ngayBanHanh) {
		kyHieuVanBan = kyHieuVanBan.toLowerCase();
		tomTat = tomTat.toLowerCase();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Document doc = new DocumentImpl();
		doc.addUID(PORTLET_ID, maVanBanPhapQuy);
		
		doc.addKeyword(Field.COMPANY_ID, companyId);
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.ENTRY_CLASS_PK, maVanBanPhapQuy);
		
		doc.addText(VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN, kyHieuVanBan);
		doc.addText(VanBanPhapQuyDisplayTerms.TOM_TAT, tomTat);
		doc.addText(VanBanPhapQuyDisplayTerms.NGUOI_KY, nguoiKy);
		
		doc.addKeyword(VanBanPhapQuyDisplayTerms.LOAI_VAN_BAN, maLoaiVanBan);
		doc.addKeyword(VanBanPhapQuyDisplayTerms.LINH_VUC_VAN_BAN, maLinhVucVanBan);
		doc.addKeyword(VanBanPhapQuyDisplayTerms.CO_QUAN_BAN_HANH, maCoQuanBanHanh);
		doc.addKeyword("ngayBanHanh", ngayBanHanh != null ? dateFormat.format(ngayBanHanh) : "");
		
		return doc;
	}

	public static void addVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SearchException, UnsupportedEncodingException {
		Document doc = getVanBanPhapQuy(companyId, vanBanPhapQuy);
		
		SearchEngineUtil.addDocument(companyId, doc);
	}
	
	public static void deleteVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SearchException, UnsupportedEncodingException {
		Document doc = getVanBanPhapQuy(companyId, vanBanPhapQuy);
		
		SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));
	}
	
	public static void updateVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SearchException, UnsupportedEncodingException {
		Document doc = getVanBanPhapQuy(companyId, vanBanPhapQuy);
		SearchEngineUtil.updateDocument(companyId, doc.get(Field.UID), doc);
	}
	
	public static void deletePortletDocuments(long companyId) throws SearchException {
		SearchEngineUtil.deletePortletDocuments(companyId, PORTLET_ID);
	}
	
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	public DocumentSummary getDocumentSummary(Document arg0, PortletURL arg1) {
		return null;
	}

	public void reIndex(String[] ids) throws SearchException {
		try {
			VanBanPhapQuyLocalServiceUtil.reIndex(ids);
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

	public void reIndex(String className, long classPK) throws SearchException {
	}
	
	private static final String[] _CLASS_NAMES = new String[] {
		VanBanPhapQuy.class.getName()
	};

}
