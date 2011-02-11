package com.sgs.portlet.generatetemplateid.service.persistence;

public class IdGeneratedFinderUtil {
    private static IdGeneratedFinder _finder;

    public static int countAll() throws com.liferay.portal.SystemException {
        return getFinder().countAll();
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getFinder().findAll(start, end);
    }

    public static IdGeneratedFinder getFinder() {
        return _finder;
    }

    public void setFinder(IdGeneratedFinder finder) {
        _finder = finder;
    }
}
