package com.sgs.portlet.document.service.persistence;

public interface PmlMainSupportPersistence {
    public com.sgs.portlet.document.model.PmlMainSupport create(long processId);

    public com.sgs.portlet.document.model.PmlMainSupport remove(long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport remove(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlMainSupport pmlMainSupport, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlMainSupport update(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlMainSupport the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlMainSupport is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlMainSupport update(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport updateImpl(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport findByPrimaryKey(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport fetchByPrimaryKey(
        long processId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport findByProcessIdMain_First(
        long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport findByProcessIdMain_Last(
        long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport[] findByProcessIdMain_PrevAndNext(
        long processId, long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport findByType_First(
        java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport findByType_Last(
        java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport[] findByType_PrevAndNext(
        long processId, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport findBySupportInfomation_First(
        java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport findBySupportInfomation_Last(
        java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport[] findBySupportInfomation_PrevAndNext(
        long processId, java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlMainSupport findByprocessIdMain_Type_First(
        long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport findByprocessIdMain_Type_Last(
        long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public com.sgs.portlet.document.model.PmlMainSupport[] findByprocessIdMain_Type_PrevAndNext(
        long processId, long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByProcessIdMain(long processId_Main)
        throws com.liferay.portal.SystemException;

    public void removeByType(java.lang.String type_)
        throws com.liferay.portal.SystemException;

    public void removeBySupportInfomation(java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException;

    public void removeByprocessIdMain_Type(long processId_Main,
        java.lang.String type_) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByProcessIdMain(long processId_Main)
        throws com.liferay.portal.SystemException;

    public int countByType(java.lang.String type_)
        throws com.liferay.portal.SystemException;

    public int countBySupportInfomation(java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException;

    public int countByprocessIdMain_Type(long processId_Main,
        java.lang.String type_) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
