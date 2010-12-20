package com.nss.portlet.qa_chu_de.service.persistence;

public interface QAChuDeCauHoiFinder {
    public int countChuDeCauHoi(java.lang.String tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countChuDeCauHoi(java.lang.String[] tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String[] tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
