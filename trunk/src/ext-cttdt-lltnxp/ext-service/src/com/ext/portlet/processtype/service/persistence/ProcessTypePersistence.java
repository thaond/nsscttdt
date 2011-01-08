package com.ext.portlet.processtype.service.persistence;

public interface ProcessTypePersistence {
    public com.ext.portlet.processtype.model.ProcessType create(
        long processTypeId);

    public com.ext.portlet.processtype.model.ProcessType remove(
        long processTypeId)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType remove(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ProcessType processType, boolean merge)</code>.
     */
    public com.ext.portlet.processtype.model.ProcessType update(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                processType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when processType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.processtype.model.ProcessType update(
        com.ext.portlet.processtype.model.ProcessType processType, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType updateImpl(
        com.ext.portlet.processtype.model.ProcessType processType, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType findByPrimaryKey(
        long processTypeId)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType fetchByPrimaryKey(
        long processTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType[] findByName_PrevAndNext(
        long processTypeId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType findByFlagProcessType_First(
        int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType findByFlagProcessType_Last(
        int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.processtype.model.ProcessType[] findByFlagProcessType_PrevAndNext(
        long processTypeId, int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByName(java.lang.String name)
        throws com.liferay.portal.SystemException;

    public void removeByFlagProcessType(int flagProcessType)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByName(java.lang.String name)
        throws com.liferay.portal.SystemException;

    public int countByFlagProcessType(int flagProcessType)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
