package com.sgs.portlet.pml_template.service.persistence;

public interface PmlTemplateFinder {
    public int countPmlTemplate(java.lang.String type,
        java.lang.String valueType) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findPmlTemplate(
        java.lang.String type, java.lang.String valueType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
