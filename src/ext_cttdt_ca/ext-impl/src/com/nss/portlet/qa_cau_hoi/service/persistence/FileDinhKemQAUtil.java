package com.nss.portlet.qa_cau_hoi.service.persistence;

public class FileDinhKemQAUtil {
    private static FileDinhKemQAPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA) {
        getPersistence().cacheResult(fileDinhKemQA);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> fileDinhKemQAs) {
        getPersistence().cacheResult(fileDinhKemQAs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA create(
        long maFileDinhKemQA) {
        return getPersistence().create(maFileDinhKemQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA remove(
        long maFileDinhKemQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().remove(maFileDinhKemQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA remove(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(fileDinhKemQA);
    }

    /**
     * @deprecated Use <code>update(FileDinhKemQA fileDinhKemQA, boolean merge)</code>.
     */
    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA update(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemQA);
    }

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
    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA update(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemQA, merge);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(fileDinhKemQA, merge);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByPrimaryKey(
        long maFileDinhKemQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().findByPrimaryKey(maFileDinhKemQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fetchByPrimaryKey(
        long maFileDinhKemQA) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maFileDinhKemQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoi(maCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoi(maCauHoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauHoi(
        long maCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoi(maCauHoi, start, end, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauHoi_First(
        long maCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().findByMaCauHoi_First(maCauHoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauHoi_Last(
        long maCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().findByMaCauHoi_Last(maCauHoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[] findByMaCauHoi_PrevAndNext(
        long maFileDinhKemQA, long maCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence()
                   .findByMaCauHoi_PrevAndNext(maFileDinhKemQA, maCauHoi, obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauTraLoi(maCauTraLoi);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauTraLoi(maCauTraLoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findByMaCauTraLoi(
        long maCauTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauTraLoi(maCauTraLoi, start, end, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauTraLoi_First(
        long maCauTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().findByMaCauTraLoi_First(maCauTraLoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA findByMaCauTraLoi_Last(
        long maCauTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence().findByMaCauTraLoi_Last(maCauTraLoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA[] findByMaCauTraLoi_PrevAndNext(
        long maFileDinhKemQA, long maCauTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException {
        return getPersistence()
                   .findByMaCauTraLoi_PrevAndNext(maFileDinhKemQA, maCauTraLoi,
            obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByMaCauHoi(long maCauHoi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaCauHoi(maCauHoi);
    }

    public static void removeByMaCauTraLoi(long maCauTraLoi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaCauTraLoi(maCauTraLoi);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByMaCauHoi(long maCauHoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaCauHoi(maCauHoi);
    }

    public static int countByMaCauTraLoi(long maCauTraLoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaCauTraLoi(maCauTraLoi);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static FileDinhKemQAPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(FileDinhKemQAPersistence persistence) {
        _persistence = persistence;
    }
}
