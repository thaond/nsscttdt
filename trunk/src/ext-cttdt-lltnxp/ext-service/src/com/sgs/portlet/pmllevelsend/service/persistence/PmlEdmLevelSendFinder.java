package com.sgs.portlet.pmllevelsend.service.persistence;

public interface PmlEdmLevelSendFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmLevelSend(java.lang.String[] pmlEdmLevelSendNames,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByPmlEdmLevelSend(
        java.lang.String[] pmlEdmLevelSendNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendIds(
        java.util.List<Integer> levelSendIds) throws java.lang.Exception;
}
