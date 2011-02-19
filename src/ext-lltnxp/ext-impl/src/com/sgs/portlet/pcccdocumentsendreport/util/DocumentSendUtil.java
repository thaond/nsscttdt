
package com.sgs.portlet.pcccdocumentsendreport.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pcccdocumentsendreport.dto.DocumentSendDTO;

/**
 * @author DienNH
 *
 */
public class DocumentSendUtil extends RTFUtil {

	private List<DocumentSendDTO> documentSendList;
	private int total;
	
	public DocumentSendUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public DocumentSendUtil(String outDirectory, List<DocumentSendDTO> documentSendList) {
		super(outDirectory);
		this.documentSendList = new ArrayList<DocumentSendDTO>();
		this.documentSendList.addAll(documentSendList);
	}
	
	public DocumentSendUtil(String outDirectory, List<DocumentSendDTO> documentSendList, int total) {
		super(outDirectory);
		this.documentSendList = new ArrayList<DocumentSendDTO>();
		this.documentSendList.addAll(documentSendList);
		this.total = total;
	}
	
	@Override
	protected void putContext(IContext context) {
		context.put("list", this.documentSendList);
		context.put("total", this.total);
	}

	public static OrderByComparator getDocSendReportOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("sophathanh")) {
			orderByComparator = new DocSendReportSoPHComparator(orderByAsc);
		}
		else if (orderByCol.equals("ngayphathanh")) {
			orderByComparator = new DocSendReportNgayPHComparator(orderByAsc);
		}

		return orderByComparator;
	}	
}