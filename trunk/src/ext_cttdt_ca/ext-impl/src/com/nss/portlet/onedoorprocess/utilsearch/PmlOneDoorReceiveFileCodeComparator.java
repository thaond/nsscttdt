package com.nss.portlet.onedoorprocess.utilsearch;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileCodeComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "pml_file.numberreceipt ASC";

	public static String ORDER_BY_DESC = "pml_file.numberreceipt DESC";
	
	private final boolean _asc;
	
	public PmlOneDoorReceiveFileCodeComparator() {
		this(false);
	}

	public PmlOneDoorReceiveFileCodeComparator(boolean asc) {
		_asc = asc;
	}
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile1 = (PmlOneDoorReceiveFile)obj1;
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile2 = (PmlOneDoorReceiveFile)obj2;

		int value = pmlOneDoorReceiveFile1.getNumberReceipt().compareTo(pmlOneDoorReceiveFile2.getNumberReceipt());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	@Override
	public String getOrderBy() {
		if (_asc) {
			
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

}
