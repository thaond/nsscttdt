package com.nss.portlet.linh_vuc_van_ban.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil;

public class LinhVucVanBanDWR {
	private static Log _log = LogFactory.getLog(LinhVucVanBanDWR.class);
	
	public boolean checkLinhVucVanBanParentId(long maLinhVucVanBan, long parentId) {
		boolean result = true;
		List<LinhVucVanBan> linhVucVanBanList = new ArrayList<LinhVucVanBan>();
		try {
			linhVucVanBanList = LinhVucVanBanLocalServiceUtil.getListLinhVucVanBanByParenId(maLinhVucVanBan);
		} catch (Exception e) {
			linhVucVanBanList = new ArrayList<LinhVucVanBan>();
			_log.error(e);
		}
		
		if (linhVucVanBanList.size() > 0 && parentId != 0) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
}
