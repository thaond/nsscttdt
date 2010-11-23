package com.nss.portlet.qa_cau_hoi.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface FileDinhKemQAPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA);

    public void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> fileDinhKemQAs);

    public void clearCache();

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA create(
        long maFileDinhKemQA);

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA remove(
        long maFileDinhKemQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA remove(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(FileDinhKemQA fileDinhKemQA, boolean merge)</code>.
     */
    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA update(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA update(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByPrimaryKey(
        long maFileDinhKemQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fetchByPrimaryKey(
        long maFileDinhKemQA) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauHoi_First(
        long maCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauHoi_Last(
        long maCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[] findByMaCauHoi_PrevAndNext(
        long maFileDinhKemQA, long maCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauTraLoi_First(
        long maCauTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauTraLoi_Last(
        long maCauTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[] findByMaCauTraLoi_PrevAndNext(
        long maFileDinhKemQA, long maCauTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByMaCauHoi(long maCauHoi)
        throws com.liferay.portal.SystemException;

    public void removeByMaCauTraLoi(long maCauTraLoi)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByMaCauHoi(long maCauHoi)
        throws com.liferay.portal.SystemException;

    public int countByMaCauTraLoi(long maCauTraLoi)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
