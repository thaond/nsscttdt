package com.ext.portlet.saveprocesstype.service.persistence;

public interface SaveProcessTypePersistence {
    public com.ext.portlet.saveprocesstype.model.SaveProcessType create(
        long sptId);

    public com.ext.portlet.saveprocesstype.model.SaveProcessType remove(
        long sptId)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType remove(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(SaveProcessType saveProcessType, boolean merge)</code>.
     */
    public com.ext.portlet.saveprocesstype.model.SaveProcessType update(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                saveProcessType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when saveProcessType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.saveprocesstype.model.SaveProcessType update(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType updateImpl(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType findByPrimaryKey(
        long sptId)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType fetchByPrimaryKey(
        long sptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType findByDocId_First(
        long docId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType findByDocId_Last(
        long docId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType[] findByDocId_PrevAndNext(
        long sptId, long docId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType findByFlagProcessType_First(
        long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType findByFlagProcessType_Last(
        long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.saveprocesstype.model.SaveProcessType[] findByFlagProcessType_PrevAndNext(
        long sptId, long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocId(long docId)
        throws com.liferay.portal.SystemException;

    public void removeByFlagProcessType(long flagProcessType)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocId(long docId)
        throws com.liferay.portal.SystemException;

    public int countByFlagProcessType(long flagProcessType)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
