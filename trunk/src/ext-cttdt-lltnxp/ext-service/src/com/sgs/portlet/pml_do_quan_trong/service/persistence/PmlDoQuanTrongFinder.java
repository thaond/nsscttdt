package com.sgs.portlet.pml_do_quan_trong.service.persistence;

public interface PmlDoQuanTrongFinder {
    public int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
