package com.sgs.portlet.holiday.service.persistence;

public interface PmlHolidayFinder {
    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findListPmlHoliday(
        int start, int end) throws com.liferay.portal.SystemException;

    public int countListPmlHoliday() throws java.lang.Exception;
}
