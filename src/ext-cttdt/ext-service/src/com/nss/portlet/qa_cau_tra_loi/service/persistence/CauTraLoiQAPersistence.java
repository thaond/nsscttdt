package com.nss.portlet.qa_cau_tra_loi.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface CauTraLoiQAPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA);

    public void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> cauTraLoiQAs);

    public void clearCache();

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA create(
        long maCauTraLoiQA);

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA remove(
        long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA remove(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(CauTraLoiQA cauTraLoiQA, boolean merge)</code>.
     */
    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA update(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                cauTraLoiQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when cauTraLoiQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA update(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateImpl(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByPrimaryKey(
        long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA fetchByPrimaryKey(
        long maCauTraLoiQA) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_First(
        long maCauHoiQA, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Last(
        long maCauHoiQA, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[] findByMaCauHoiQA_PrevAndNext(
        long maCauTraLoiQA, long maCauHoiQA,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Publish_First(
        long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Publish_Last(
        long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[] findByMaCauHoiQA_Publish_PrevAndNext(
        long maCauTraLoiQA, long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByMaCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.SystemException;

    public void removeByMaCauHoiQA_Publish(long maCauHoiQA, boolean publish)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByMaCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.SystemException;

    public int countByMaCauHoiQA_Publish(long maCauHoiQA, boolean publish)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
