package com.sgs.portlet.holiday.service.persistence;

public class PmlHolidayFinderUtil {
    private static PmlHolidayFinder _finder;

    public static java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findListPmlHoliday(
        int start, int end) throws com.liferay.portal.SystemException {
        return getFinder().findListPmlHoliday(start, end);
    }

    public static int countListPmlHoliday() throws java.lang.Exception {
        return getFinder().countListPmlHoliday();
    }

    public static PmlHolidayFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlHolidayFinder finder) {
        _finder = finder;
    }
}
