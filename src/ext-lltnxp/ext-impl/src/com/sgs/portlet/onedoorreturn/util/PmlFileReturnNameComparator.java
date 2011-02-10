/**
 * 
 */
package com.sgs.portlet.onedoorreturn.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;

/**
 * @author minhnv
 *
 */
public class PmlFileReturnNameComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_file_pccc.filename ASC";

	public static String ORDER_BY_DESC = "pml_file_pccc.filename DESC";
	
private boolean _asc;
	
	public PmlFileReturnNameComparator() {
		this(false);
	}

	public PmlFileReturnNameComparator(boolean asc) {
		_asc = asc;
	}
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile1 = (PmlOneDoorReceiveFile)obj1;
		PmlOneDoorReceiveFile pmlOneDoorReceiveFile2 = (PmlOneDoorReceiveFile)obj2;
		
		PmlFilePCCC pmlFilePCCC1 = null;
		PmlFilePCCC pmlFilePCCC2 = null;
		try {
			pmlFilePCCC1 = PmlFilePCCCUtil.findByPrimaryKey(pmlOneDoorReceiveFile1.getFileId());
			pmlFilePCCC2 = PmlFilePCCCUtil.findByPrimaryKey(pmlOneDoorReceiveFile2.getFileId());
		} catch (Exception e) {
		}

		int value = pmlFilePCCC1.getFileName().compareTo(pmlFilePCCC2.getFileName());

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
