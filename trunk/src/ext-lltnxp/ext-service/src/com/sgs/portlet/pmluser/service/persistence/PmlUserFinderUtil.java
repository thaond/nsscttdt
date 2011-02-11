package com.sgs.portlet.pmluser.service.persistence;

public class PmlUserFinderUtil {
    private static PmlUserFinder _finder;

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findListUserByDepartment(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findListUserByDepartment(departmentsId, start, end, obc);
    }

    public static int countListUserByDepartments(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getFinder().countListUserByDepartments(departmentsId);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlUser(java.lang.String screenName,
        java.lang.String lastName, java.lang.String middleName,
        java.lang.String firstName, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlUser(screenName, lastName, middleName, firstName,
            positionId, andOperator);
    }

    public static int countByPmlUser(java.lang.String[] screenNames,
        java.lang.String[] lastNames, java.lang.String[] middleNames,
        java.lang.String[] firstNames, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlUser(screenNames, lastNames, middleNames,
            firstNames, positionId, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPmlUser(
        java.lang.String screenName, java.lang.String lastName,
        java.lang.String middleName, java.lang.String firstName,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlUser(screenName, lastName, middleName, firstName,
            positionId, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPmlUser(
        java.lang.String[] screenNames, java.lang.String[] lastNames,
        java.lang.String[] middleNames, java.lang.String[] firstNames,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlUser(screenNames, lastNames, middleNames,
            firstNames, positionId, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartmentId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findUserListByDepartmentId(departmentsId, start, end, obc);
    }

    public static int countUserListByDepartmentId(
        java.lang.String departmentsId) throws java.lang.Exception {
        return getFinder().countUserListByDepartmentId(departmentsId);
    }

    public static int countTinhHinhThuLyCongVanChuyenVien(
        java.lang.String departmentId) throws java.lang.Exception {
        return getFinder().countTinhHinhThuLyCongVanChuyenVien(departmentId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartment(
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
