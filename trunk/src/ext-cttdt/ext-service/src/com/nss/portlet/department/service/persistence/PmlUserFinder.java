package com.nss.portlet.department.service.persistence;

public interface PmlUserFinder {
    public java.util.List<com.nss.portlet.department.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception;

    public java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserTheoDoiHoSo() throws com.liferay.portal.SystemException;
}
