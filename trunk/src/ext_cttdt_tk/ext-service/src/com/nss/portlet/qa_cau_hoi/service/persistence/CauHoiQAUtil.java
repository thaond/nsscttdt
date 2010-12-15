package com.nss.portlet.qa_cau_hoi.service.persistence;

public class CauHoiQAUtil {
    private static CauHoiQAPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA) {
        getPersistence().cacheResult(cauHoiQA);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> cauHoiQAs) {
        getPersistence().cacheResult(cauHoiQAs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA create(
        long maCauHoiQA) {
        return getPersistence().create(maCauHoiQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA remove(
        long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence().remove(maCauHoiQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA remove(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(cauHoiQA);
    }

    /**
     * @deprecated Use <code>update(CauHoiQA cauHoiQA, boolean merge)</code>.
     */
    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA update(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(cauHoiQA);
    }

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
    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA update(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(cauHoiQA, merge);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(cauHoiQA, merge);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByPrimaryKey(
        long maCauHoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence().findByPrimaryKey(maCauHoiQA);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA fetchByPrimaryKey(
        long maCauHoiQA) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maCauHoiQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaChuDeCauHoi(maChuDeCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaChuDeCauHoi(maChuDeCauHoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi(maChuDeCauHoi, start, end, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_First(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence().findByMaChuDeCauHoi_First(maChuDeCauHoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Last(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence().findByMaChuDeCauHoi_Last(maChuDeCauHoi, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA[] findByMaChuDeCauHoi_PrevAndNext(
        long maCauHoiQA, long maChuDeCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence()
                   .findByMaChuDeCauHoi_PrevAndNext(maCauHoiQA, maChuDeCauHoi,
            obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish, start,
            end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findByMaChuDeCauHoi_Publish(
        long maChuDeCauHoi, boolean publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish, start,
            end, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Publish_First(
        long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish_First(maChuDeCauHoi, publish,
            obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA findByMaChuDeCauHoi_Publish_Last(
        long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish_Last(maChuDeCauHoi, publish, obc);
    }

    public static com.nss.portlet.qa_cau_hoi.model.CauHoiQA[] findByMaChuDeCauHoi_Publish_PrevAndNext(
        long maCauHoiQA, long maChuDeCauHoi, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException {
        return getPersistence()
                   .findByMaChuDeCauHoi_Publish_PrevAndNext(maCauHoiQA,
            maChuDeCauHoi, publish, obc);
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

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByMaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaChuDeCauHoi(maChuDeCauHoi);
    }

    public static void removeByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish) throws com.liferay.portal.SystemException {
        getPersistence().removeByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByMaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaChuDeCauHoi(maChuDeCauHoi);
    }

    public static int countByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static CauHoiQAPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CauHoiQAPersistence persistence) {
        _persistence = persistence;
    }
}
