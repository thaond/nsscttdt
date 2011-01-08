package com.sgs.portlet.document.service.persistence;

public interface PmlFileStatusPersistence {
    public com.sgs.portlet.document.model.PmlFileStatus create(
        long fileStatusId);

    public com.sgs.portlet.document.model.PmlFileStatus remove(
        long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus remove(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileStatus pmlFileStatus, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlFileStatus update(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatus the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatus is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlFileStatus update(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus updateImpl(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByPrimaryKey(
        long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus fetchByPrimaryKey(
        long fileStatusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusCode_First(
        java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusCode_Last(
        java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus[] findByFileStatusCode_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusName_First(
        java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusName_Last(
        java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus[] findByFileStatusName_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus[] findByDescription_PrevAndNext(
        long fileStatusId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByType(
        java.lang.String type) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByType(
        java.lang.String type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByType(
        java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByType_First(
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus findByType_Last(
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus[] findByType_PrevAndNext(
        long fileStatusId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusCode_Type_First(
        java.lang.String fileStatusCode, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus findByFileStatusCode_Type_Last(
        java.lang.String fileStatusCode, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public com.sgs.portlet.document.model.PmlFileStatus[] findByFileStatusCode_Type_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusCode,
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlFileStatusException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatusCode(java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatusName(java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByType(java.lang.String type)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatusCode_Type(java.lang.String fileStatusCode,
        java.lang.String type) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileStatusCode(java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException;

    public int countByFileStatusName(java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByType(java.lang.String type)
        throws com.liferay.portal.SystemException;

    public int countByFileStatusCode_Type(java.lang.String fileStatusCode,
        java.lang.String type) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
