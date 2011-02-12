package com.sgs.portlet.vanbannoibo.service.persistence;

public interface VanBanNoiBoPersistence {
    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo create(
        long vanBanNoiBoId);

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo remove(
        long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(VanBanNoiBo vanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo findByPrimaryKey(
        long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchException;

    public com.sgs.portlet.vanbannoibo.model.VanBanNoiBo fetchByPrimaryKey(
        long vanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getFileDinhKemVanBanNoiBosSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsFileDinhKemVanBanNoiBo(long pk,
        long fileDinhKemVanBanNoiBoPK)
        throws com.liferay.portal.SystemException;

    public boolean containsFileDinhKemVanBanNoiBos(long pk)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
