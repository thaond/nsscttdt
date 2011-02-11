package com.sgs.portlet.pml_tinh_chat.service.persistence;

public interface PmlTinhChatFinder {
    public int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
