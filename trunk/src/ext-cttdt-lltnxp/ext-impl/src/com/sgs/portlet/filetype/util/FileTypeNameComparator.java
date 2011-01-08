/**
 * 
 */
package com.sgs.portlet.filetype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.filetype.model.PmlFileType;

/**
 * @author canhminh
 *
 */
public class FileTypeNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "pml_filetype.filetypename ASC";
	public static final String ORDER_BY_DESC = "pml_filetype.filetypename DESC";
	
	
	public FileTypeNameComparator(){
		this(false);
	}
	
	public FileTypeNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlFileType fileType1 = (PmlFileType)o1;
		PmlFileType fileType2 = (PmlFileType)o2;
		
		int value = fileType1.getFileTypeCode().compareTo(fileType2.getFileTypeCode());
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}

	@Override
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private final boolean _asc;
}

