/**
 * 
 */
package com.nss.portlet.documentfield.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.documentfield.model.PmlField;

public class PmlFieldCodeComparator extends OrderByComparator {

		public static final String ORDER_BY_ASC ="pml_field.fieldcode ASC";
		public static final String ORDER_BY_DESC ="pml_field.fieldcode DESC";
		
		
		public PmlFieldCodeComparator(){
			this(false);
		}
		
		public PmlFieldCodeComparator(boolean asc){
			this._asc = asc;
		}
		
		@Override
		public int compare(Object o1, Object o2) {
			
			PmlField field1 = (PmlField)o1;
			PmlField field2 = (PmlField)o2;
			
			int value = field1.getFieldCode().compareTo(field2.getFieldCode());
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
