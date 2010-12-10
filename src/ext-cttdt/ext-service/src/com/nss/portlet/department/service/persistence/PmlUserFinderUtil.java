package com.nss.portlet.department.service.persistence;

public class PmlUserFinderUtil {
    private static PmlUserFinder _finder;

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findUserListByDepartment(departmentsId, start, end);
    }

    public static int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception {
        return getFinder().countUserListByDepartment(departmentsId);
    }

    public static java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().listUserTheoDoiHoSo(start, end, obc);
    }

    public static int countUserTheoDoiHoSo()
        throws com.liferay.portal.SystemException {
        return getFinder().countUserTheoDoiHoSo();
    }

    public static PmlUserFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlUserFinder finder) {
        _finder = finder;
    }
}
