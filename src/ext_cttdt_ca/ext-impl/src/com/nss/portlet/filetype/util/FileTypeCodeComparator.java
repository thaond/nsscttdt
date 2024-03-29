/**
 * 
 */
package com.nss.portlet.filetype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.filetype.model.PmlFileType;

public class FileTypeCodeComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC ="pml_filetype.filetypecode ASC";
	public static final String ORDER_BY_DESC ="pml_filetype.filetypecode DESC";
	
	
	public FileTypeCodeComparator(){
		this(false);
	}
	
	public FileTypeCodeComparator(boolean asc){
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
