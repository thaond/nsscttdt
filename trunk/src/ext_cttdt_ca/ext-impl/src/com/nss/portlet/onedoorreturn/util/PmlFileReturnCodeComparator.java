/**
 * 
 */
package com.nss.portlet.onedoorreturn.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;

public class PmlFileReturnCodeComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_file.generalorderno ASC";

	public static String ORDER_BY_DESC = "pml_file.generalorderno DESC";
	
	private boolean _asc;
	
	public PmlFileReturnCodeComparator() {
		this(false);
	}

	public PmlFileReturnCodeComparator(boolean asc) {
		_asc = asc;
	}
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile1 = (PmlOneDoorReceiveFile)obj1;
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile2 = (PmlOneDoorReceiveFile)obj2;

		int value = String.valueOf(pmlOneDoorReceiveFile1.getGeneralorderno()).compareTo(String.valueOf(pmlOneDoorReceiveFile2.getGeneralorderno()));
		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

}
