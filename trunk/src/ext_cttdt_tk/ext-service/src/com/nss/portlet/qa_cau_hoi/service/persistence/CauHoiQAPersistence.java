package com.nss.portlet.qa_cau_hoi.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface CauHoiQAPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA);

    public void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> cauHoiQAs);

    public void clearCache();

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA create(long maCauHoiQA);

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA remove(long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA remove(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(CauHoiQA cauHoiQA, boolean merge)</code>.
     */
    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA update(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                cauHoiQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when cauHoiQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA update(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByPrimaryKey(
        long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA fetchByPrimaryKey(
        long maCauHoiQA) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_First(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Last(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA[] findByMaChuDeCauHoi_PrevAndNext(
        long maCauHoiQA, long maChuDeCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Publish_First(
        long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Publish_Last(
        long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public com.nss.portlet.qa_cau_hoi.model.CauHoiQA[] findByMaChuDeCauHoi_Publish_PrevAndNext(
        long maCauHoiQA, long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByMaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public void removeByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByMaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public int countByMaChuDeCauHoi_Publish(long maChuDeCauHoi, boolean publish)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
