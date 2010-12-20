package com.nss.portlet.adv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface QuangCaoPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.adv.model.QuangCao quangCao);

    public void cacheResult(
        java.util.List<com.nss.portlet.adv.model.QuangCao> quangCaos);

    public void clearCache();

    public com.nss.portlet.adv.model.QuangCao create(long maQuangCao);

    public com.nss.portlet.adv.model.QuangCao remove(long maQuangCao)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException;

    public com.nss.portlet.adv.model.QuangCao remove(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(QuangCao quangCao, boolean merge)</code>.
     */
    public com.nss.portlet.adv.model.QuangCao update(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                quangCao the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when quangCao is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.adv.model.QuangCao update(
        com.nss.portlet.adv.model.QuangCao quangCao, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.adv.model.QuangCao updateImpl(
        com.nss.portlet.adv.model.QuangCao quangCao, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.adv.model.QuangCao findByPrimaryKey(long maQuangCao)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException;

    public com.nss.portlet.adv.model.QuangCao fetchByPrimaryKey(long maQuangCao)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.adv.model.QuangCao findByActive_First(int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException;

    public com.nss.portlet.adv.model.QuangCao findByActive_Last(int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException;

    public com.nss.portlet.adv.model.QuangCao[] findByActive_PrevAndNext(
        long maQuangCao, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.adv.model.QuangCao> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
