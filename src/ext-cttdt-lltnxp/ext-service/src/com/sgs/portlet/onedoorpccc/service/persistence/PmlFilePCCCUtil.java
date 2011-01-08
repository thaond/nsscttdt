package com.sgs.portlet.onedoorpccc.service.persistence;

public class PmlFilePCCCUtil {
    private static PmlFilePCCCPersistence _persistence;

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC create(
        java.lang.String fileId) {
        return getPersistence().create(fileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().remove(fileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC remove(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFilePCCC);
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCC pmlFilePCCC, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFilePCCC);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCC the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCC is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFilePCCC, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFilePCCC, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByPrimaryKey(fileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileName(fileName);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileName(fileName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileName(fileName, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByFileName_First(
        java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByFileName_First(fileName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByFileName_Last(
        java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByFileName_Last(fileName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC[] findByFileName_PrevAndNext(
        java.lang.String fileId, java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByFileName_PrevAndNext(fileId, fileName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName) throws com.liferay.portal.SystemException {
        return getPersistence().findByProjectName(projectName);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProjectName(projectName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProjectName(projectName, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByProjectName_First(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByProjectName_First(projectName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByProjectName_Last(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByProjectName_Last(projectName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC[] findByProjectName_PrevAndNext(
        java.lang.String fileId, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence()
                   .findByProjectName_PrevAndNext(fileId, projectName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByApplicantCategory(applicantCategory);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByApplicantCategory(applicantCategory, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByApplicantCategory(applicantCategory, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByApplicantCategory_First(
        java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence()
                   .findByApplicantCategory_First(applicantCategory, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByApplicantCategory_Last(
        java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence()
                   .findByApplicantCategory_Last(applicantCategory, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC[] findByApplicantCategory_PrevAndNext(
        java.lang.String fileId, java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence()
                   .findByApplicantCategory_PrevAndNext(fileId,
            applicantCategory, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveOfUnit(receiveOfUnit);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveOfUnit(receiveOfUnit, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiveOfUnit(receiveOfUnit, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByReceiveOfUnit_First(
        java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByReceiveOfUnit_First(receiveOfUnit, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC findByReceiveOfUnit_Last(
        java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence().findByReceiveOfUnit_Last(receiveOfUnit, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCC[] findByReceiveOfUnit_PrevAndNext(
        java.lang.String fileId, java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchException {
        return getPersistence()
                   .findByReceiveOfUnit_PrevAndNext(fileId, receiveOfUnit, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCC> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileName(java.lang.String fileName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileName(fileName);
    }

    public static void removeByProjectName(java.lang.String projectName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProjectName(projectName);
    }

    public static void removeByApplicantCategory(
        java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByApplicantCategory(applicantCategory);
    }

    public static void removeByReceiveOfUnit(java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiveOfUnit(receiveOfUnit);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileName(java.lang.String fileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileName(fileName);
    }

    public static int countByProjectName(java.lang.String projectName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProjectName(projectName);
    }

    public static int countByApplicantCategory(
        java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByApplicantCategory(applicantCategory);
    }

    public static int countByReceiveOfUnit(java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiveOfUnit(receiveOfUnit);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlFilePCCCPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFilePCCCPersistence persistence) {
        _persistence = persistence;
    }
}
