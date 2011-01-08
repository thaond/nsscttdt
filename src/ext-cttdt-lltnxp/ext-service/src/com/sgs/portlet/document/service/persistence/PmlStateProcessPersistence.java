package com.sgs.portlet.document.service.persistence;

public interface PmlStateProcessPersistence {
    public com.sgs.portlet.document.model.PmlStateProcess create(
        long stateProcessId);

    public com.sgs.portlet.document.model.PmlStateProcess remove(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess remove(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlStateProcess pmlStateProcess, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlStateProcess update(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlStateProcess update(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess updateImpl(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByPrimaryKey(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess fetchByPrimaryKey(
        long stateProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessCode_First(
        java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessCode_Last(
        java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessName_First(
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessName_Last(
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess[] findByStateProcessName_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess[] findByDescription_PrevAndNext(
        long stateProcessId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByFileStatusId_First(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess findByFileStatusId_Last(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess[] findByFileStatusId_PrevAndNext(
        long stateProcessId, long fileStatusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessCode_First(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess findByStateProcessCode_Last(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public com.sgs.portlet.document.model.PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessCode,
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateProcessException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessCode(java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessName(java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessCode(java.lang.String stateProcessCode,
        java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByStateProcessCode(java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessName(java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessCode(java.lang.String stateProcessCode,
        java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
