package com.sgs.portlet.pml_trang_thai_hscv.service.persistence;

public interface PmlTrangThaiHSCVFinder {
    public int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
