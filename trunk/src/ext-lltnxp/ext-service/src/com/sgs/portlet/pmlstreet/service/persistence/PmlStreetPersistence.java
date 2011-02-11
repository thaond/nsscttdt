package com.sgs.portlet.pmlstreet.service.persistence;

public interface PmlStreetPersistence {
    public com.sgs.portlet.pmlstreet.model.PmlStreet create(
        java.lang.String streetId);

    public com.sgs.portlet.pmlstreet.model.PmlStreet remove(
        java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet remove(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlStreet pmlStreet, boolean merge)</code>.
     */
    public com.sgs.portlet.pmlstreet.model.PmlStreet update(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStreet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStreet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pmlstreet.model.PmlStreet update(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet updateImpl(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet findByPrimaryKey(
        java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet fetchByPrimaryKey(
        java.lang.String streetId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet findByStreetName_First(
        java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet findByStreetName_Last(
        java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet[] findByStreetName_PrevAndNext(
        java.lang.String streetId, java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByStreetName(java.lang.String streetName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByStreetName(java.lang.String streetName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
