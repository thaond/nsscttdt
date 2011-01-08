package com.sgs.portlet.pmluser.service.persistence;

public interface PmlUserFinder {
    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findListUserByDepartment(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListUserByDepartments(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlUser(java.lang.String screenName,
        java.lang.String lastName, java.lang.String middleName,
        java.lang.String firstName, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByPmlUser(java.lang.String[] screenNames,
        java.lang.String[] lastNames, java.lang.String[] middleNames,
        java.lang.String[] firstNames, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPmlUser(
        java.lang.String screenName, java.lang.String lastName,
        java.lang.String middleName, java.lang.String firstName,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPmlUser(
        java.lang.String[] screenNames, java.lang.String[] lastNames,
        java.lang.String[] middleNames, java.lang.String[] firstNames,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartmentId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartmentId(java.lang.String departmentsId)
        throws java.lang.Exception;

    public int countTinhHinhThuLyCongVanChuyenVien(
        java.lang.String departmentId) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception;

    public java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserTheoDoiHoSo() throws com.liferay.portal.SystemException;
}
