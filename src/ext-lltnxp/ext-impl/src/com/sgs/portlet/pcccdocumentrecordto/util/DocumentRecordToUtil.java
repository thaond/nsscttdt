/**
 * 
 */
package com.sgs.portlet.pcccdocumentrecordto.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pcccdocumentrecordto.dto.DocumentRecordToDTO;

/**
 * @author DienNH
 *
 */
public class DocumentRecordToUtil extends RTFUtil {

	private List<DocumentRecordToDTO> documentRecordToList;
	
	/**
	 * 
	 */
	
	public DocumentRecordToUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public DocumentRecordToUtil(String outDirectory, List<DocumentRecordToDTO> documentRecordToList) {
		super(outDirectory);
		this.documentRecordToList = new ArrayList<DocumentRecordToDTO>();
		this.documentRecordToList.addAll(documentRecordToList);
	}

	@Override
	protected void putContext(IContext context) {
		context.put("list", this.documentRecordToList);
	}

	public static OrderByComparator getDocumentRecordToOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("soden")) {
			orderByComparator = new DocumentRecordToSoNoiBoComparator(orderByAsc);
		}
		else if (orderByCol.equals("ngayden")) {
			orderByComparator = new DocumentRecordToNgayDenComparator(orderByAsc);
		}
		else if (orderByCol.equals("ngayphathanh")) {
			orderByComparator = new DocumentRecordToNgayPHComparator(orderByAsc);
		}
		else {
			orderByComparator = new DocumentRecordToNgayDenComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
