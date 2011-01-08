package com.sgs.portlet.recievergroup.service.persistence;

public class RecieverFinderUtil {
    private static RecieverFinder _finder;

    public static java.util.List<com.liferay.portal.model.User> findUserByFullName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getFinder().findUserByFullName(companyId, name);
    }

    public static RecieverFinder getFinder() {
        return _finder;
    }

    public void setFinder(RecieverFinder finder) {
        _finder = finder;
    }
}
