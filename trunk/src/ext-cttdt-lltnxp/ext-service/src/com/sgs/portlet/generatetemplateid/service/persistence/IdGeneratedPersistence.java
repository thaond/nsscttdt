package com.sgs.portlet.generatetemplateid.service.persistence;

public interface IdGeneratedPersistence {
    public com.sgs.portlet.generatetemplateid.model.IdGenerated create(long id);

    public com.sgs.portlet.generatetemplateid.model.IdGenerated remove(long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated remove(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(IdGenerated idGenerated, boolean merge)</code>.
     */
    public com.sgs.portlet.generatetemplateid.model.IdGenerated update(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                idGenerated the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when idGenerated is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.generatetemplateid.model.IdGenerated update(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated updateImpl(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByAllLike_First(
        java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByAllLike_Last(
        java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByAllLike_PrevAndNext(
        long id, java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByYear_First(
        java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByYear_Last(
        java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByYear_PrevAndNext(
        long id, java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByCurValue_First(
        long curValue, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated findByCurValue_Last(
        long curValue, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByCurValue_PrevAndNext(
        long id, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByAllLike(java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException;

    public void removeByYear(java.lang.String year)
        throws com.liferay.portal.SystemException;

    public void removeByCurValue(long curValue)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByAllLike(java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException;

    public int countByYear(java.lang.String year)
        throws com.liferay.portal.SystemException;

    public int countByCurValue(long curValue)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
