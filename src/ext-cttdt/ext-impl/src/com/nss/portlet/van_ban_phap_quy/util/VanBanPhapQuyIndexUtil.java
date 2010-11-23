package com.nss.portlet.van_ban_phap_quy.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Time;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil;

public class VanBanPhapQuyIndexUtil {
	public boolean reIndexVanBanPhapQuy(long companyId){
		try {
			VanBanPhapQuyIndexer.deletePortletDocuments(companyId);
			List<VanBanPhapQuy> vanBanPhapQuyList = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			VanBanPhapQuy vanBanPhapQuy;
			
			for (int i = 0; i < vanBanPhapQuyList.size(); i++) {
				vanBanPhapQuy = vanBanPhapQuyList.get(i);
				VanBanPhapQuyIndexer.addVanBanPhapQuy(companyId, vanBanPhapQuy);
			}
			
			if ("file".equals(PropsUtil.get("lucene.store.type"))) {
				StringBuilder builder = new StringBuilder();
				builder.append(PropsUtil.get("lucene.dir"));
				builder.append(companyId);
				builder.append("/");
				builder.append("write.lock");
				File file = new File(builder.toString());
				boolean flagNoExistBefore = file.exists();
				boolean flagNoExistAfter = false;
					
				if (!flagNoExistBefore) {
					for (;;){
						flagNoExistBefore = file.exists();
						if (flagNoExistBefore) {						
							break;
						}
					}
				}
					
				flagNoExistAfter = flagNoExistBefore;
				while (flagNoExistAfter) {
					flagNoExistAfter = file.exists();
					if (!flagNoExistAfter) {
						try {
							Thread.sleep(Time.SECOND * 10);
							
							flagNoExistAfter = file.exists();
							if (!flagNoExistAfter) {								
								break;
							}
						}
						catch (InterruptedException ie) {
						}
						
					}
				}
			}
			
			return true;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
