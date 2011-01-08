package com.sgs.portlet.signer.service.persistence;

public interface SignerPersistence {
    public com.sgs.portlet.signer.model.Signer create(long signerId);

    public com.sgs.portlet.signer.model.Signer remove(long signerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException;

    public com.sgs.portlet.signer.model.Signer remove(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Signer signer, boolean merge)</code>.
     */
    public com.sgs.portlet.signer.model.Signer update(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                signer the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when signer is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.signer.model.Signer update(
        com.sgs.portlet.signer.model.Signer signer, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer updateImpl(
        com.sgs.portlet.signer.model.Signer signer, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer findByPrimaryKey(long signerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException;

    public com.sgs.portlet.signer.model.Signer fetchByPrimaryKey(long signerId)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.signer.model.Signer findByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException;

    public com.sgs.portlet.signer.model.Signer fetchByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.signer.model.Signer> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.signer.model.Signer> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.signer.model.Signer> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
