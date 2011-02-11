package com.sgs.portlet.receivergroup.service.persistence;

public class ReceiverFinderUtil {
    private static ReceiverFinder _finder;

    public static java.util.List<com.liferay.portal.model.User> findUserByFullName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getFinder().findUserByFullName(companyId, name);
    }

    public static ReceiverFinder getFinder() {
        return _finder;
    }

    public void setFinder(ReceiverFinder finder) {
        _finder = finder;
    }
}
