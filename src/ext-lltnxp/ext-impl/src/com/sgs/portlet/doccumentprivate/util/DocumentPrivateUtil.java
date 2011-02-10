package com.sgs.portlet.doccumentprivate.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.util.DocumentPrivateNguoiKiComparator;
import com.sgs.portlet.document.receipt.util.DocumentPrivateSoCVDenComparator;
import com.sgs.portlet.document.receipt.util.DocumentPrivateSoVaoSoComparator;

public class DocumentPrivateUtil {

	public static OrderByComparator getDocumentPrivateComparator(String orderByCol, String orderByType){
		boolean orderByAsc = false;
		
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals("signer")){
			orderByComparator = new DocumentPrivateNguoiKiComparator(orderByAsc);
		} else if(orderByCol.equals("documentReference")){
			orderByComparator = new DocumentPrivateSoCVDenComparator(orderByAsc);
		} else if(orderByCol.equals("numberDocumentReceipt")){
			orderByComparator = new DocumentPrivateSoVaoSoComparator(orderByAsc);
		}
			
		return orderByComparator;
	}
}
