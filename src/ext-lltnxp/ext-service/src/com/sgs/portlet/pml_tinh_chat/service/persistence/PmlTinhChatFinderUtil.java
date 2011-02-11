package com.sgs.portlet.pml_tinh_chat.service.persistence;

public class PmlTinhChatFinderUtil {
    private static PmlTinhChatFinder _finder;

    public static int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByC_G(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByC_G(andOperator, start, end, obc);
    }

    public static PmlTinhChatFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlTinhChatFinder finder) {
        _finder = finder;
    }
}
