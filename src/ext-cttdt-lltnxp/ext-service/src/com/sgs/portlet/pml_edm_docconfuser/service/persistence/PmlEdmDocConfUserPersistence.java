package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

public interface PmlEdmDocConfUserPersistence {
    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser create(
        long dcuId);

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser remove(
        long dcuId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser remove(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocConfUser pmlEdmDocConfUser, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser update(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocConfUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocConfUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser update(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updateImpl(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByPrimaryKey(
        long dcuId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser fetchByPrimaryKey(
        long dcuId) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByUserId(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser fetchByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
