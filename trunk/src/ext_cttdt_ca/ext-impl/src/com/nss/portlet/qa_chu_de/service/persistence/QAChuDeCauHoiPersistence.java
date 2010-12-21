package com.nss.portlet.qa_chu_de.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface QAChuDeCauHoiPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi);

    public void cacheResult(
        java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> qaChuDeCauHois);

    public void clearCache();

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi create(
        long maChuDeCauHoi);

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi remove(
        long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi remove(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(QAChuDeCauHoi qaChuDeCauHoi, boolean merge)</code>.
     */
    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi update(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                qaChuDeCauHoi the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when qaChuDeCauHoi is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi update(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateImpl(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByPrimaryKey(
        long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi fetchByPrimaryKey(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi[] findByActive_PrevAndNext(
        long maChuDeCauHoi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
