package com.nss.portlet.onedoor.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlFilePCCCPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC);

    public void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> pmlFilePCCCs);

    public void clearCache();

    public com.nss.portlet.onedoor.model.PmlFilePCCC create(
        java.lang.String fileId);

    public com.nss.portlet.onedoor.model.PmlFilePCCC remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC remove(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFilePCCC pmlFilePCCC, boolean merge)</code>.
     */
    public com.nss.portlet.onedoor.model.PmlFilePCCC update(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.onedoor.model.PmlFilePCCC update(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC updateImpl(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByFileName(
        java.lang.String fileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByFileName_First(
        java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByFileName_Last(
        java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC[] findByFileName_PrevAndNext(
        java.lang.String fileId, java.lang.String fileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByProjectName(
        java.lang.String projectName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByProjectName_First(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByProjectName_Last(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC[] findByProjectName_PrevAndNext(
        java.lang.String fileId, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByApplicantCategory(
        java.lang.String applicantCategory, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByApplicantCategory_First(
        java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByApplicantCategory_Last(
        java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC[] findByApplicantCategory_PrevAndNext(
        java.lang.String fileId, java.lang.String applicantCategory,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findByReceiveOfUnit(
        java.lang.String receiveOfUnit, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByReceiveOfUnit_First(
        java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC findByReceiveOfUnit_Last(
        java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public com.nss.portlet.onedoor.model.PmlFilePCCC[] findByReceiveOfUnit_PrevAndNext(
        java.lang.String fileId, java.lang.String receiveOfUnit,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCC> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileName(java.lang.String fileName)
        throws com.liferay.portal.SystemException;

    public void removeByProjectName(java.lang.String projectName)
        throws com.liferay.portal.SystemException;

    public void removeByApplicantCategory(java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException;

    public void removeByReceiveOfUnit(java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileName(java.lang.String fileName)
        throws com.liferay.portal.SystemException;

    public int countByProjectName(java.lang.String projectName)
        throws com.liferay.portal.SystemException;

    public int countByApplicantCategory(java.lang.String applicantCategory)
        throws com.liferay.portal.SystemException;

    public int countByReceiveOfUnit(java.lang.String receiveOfUnit)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
