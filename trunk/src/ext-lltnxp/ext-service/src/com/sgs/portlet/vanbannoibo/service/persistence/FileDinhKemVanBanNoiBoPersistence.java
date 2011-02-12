package com.sgs.portlet.vanbannoibo.service.persistence;

public interface FileDinhKemVanBanNoiBoPersistence {
    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo create(
        long fileDinhKemVanBanNoiBoId);

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo remove(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchFileDinhKemVanBanNoiBoException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo findByPrimaryKey(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchFileDinhKemVanBanNoiBoException;

    public com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fetchByPrimaryKey(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
