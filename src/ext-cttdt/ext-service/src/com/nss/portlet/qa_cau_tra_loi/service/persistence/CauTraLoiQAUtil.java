package com.nss.portlet.qa_cau_tra_loi.service.persistence;

public class CauTraLoiQAUtil {
    private static CauTraLoiQAPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA) {
        getPersistence().cacheResult(cauTraLoiQA);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> cauTraLoiQAs) {
        getPersistence().cacheResult(cauTraLoiQAs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA create(
        long maCauTraLoiQA) {
        return getPersistence().create(maCauTraLoiQA);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA remove(
        long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence().remove(maCauTraLoiQA);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA remove(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(cauTraLoiQA);
    }

    /**
     * @deprecated Use <code>update(CauTraLoiQA cauTraLoiQA, boolean merge)</code>.
     */
    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA update(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(cauTraLoiQA);
    }

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
    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA update(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(cauTraLoiQA, merge);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA updateImpl(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(cauTraLoiQA, merge);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByPrimaryKey(
        long maCauTraLoiQA)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence().findByPrimaryKey(maCauTraLoiQA);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA fetchByPrimaryKey(
        long maCauTraLoiQA) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maCauTraLoiQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoiQA(maCauHoiQA);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoiQA(maCauHoiQA, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA(
        long maCauHoiQA, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoiQA(maCauHoiQA, start, end, obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_First(
        long maCauHoiQA, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence().findByMaCauHoiQA_First(maCauHoiQA, obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Last(
        long maCauHoiQA, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence().findByMaCauHoiQA_Last(maCauHoiQA, obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[] findByMaCauHoiQA_PrevAndNext(
        long maCauTraLoiQA, long maCauHoiQA,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence()
                   .findByMaCauHoiQA_PrevAndNext(maCauTraLoiQA, maCauHoiQA, obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCauHoiQA_Publish(maCauHoiQA, publish);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaCauHoiQA_Publish(maCauHoiQA, publish, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findByMaCauHoiQA_Publish(
        long maCauHoiQA, boolean publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaCauHoiQA_Publish(maCauHoiQA, publish, start, end,
            obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Publish_First(
        long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence()
                   .findByMaCauHoiQA_Publish_First(maCauHoiQA, publish, obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA findByMaCauHoiQA_Publish_Last(
        long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence()
                   .findByMaCauHoiQA_Publish_Last(maCauHoiQA, publish, obc);
    }

    public static com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA[] findByMaCauHoiQA_Publish_PrevAndNext(
        long maCauTraLoiQA, long maCauHoiQA, boolean publish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException {
        return getPersistence()
                   .findByMaCauHoiQA_Publish_PrevAndNext(maCauTraLoiQA,
            maCauHoiQA, publish, obc);
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

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByMaCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaCauHoiQA(maCauHoiQA);
    }

    public static void removeByMaCauHoiQA_Publish(long maCauHoiQA,
        boolean publish) throws com.liferay.portal.SystemException {
        getPersistence().removeByMaCauHoiQA_Publish(maCauHoiQA, publish);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByMaCauHoiQA(long maCauHoiQA)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaCauHoiQA(maCauHoiQA);
    }

    public static int countByMaCauHoiQA_Publish(long maCauHoiQA, boolean publish)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaCauHoiQA_Publish(maCauHoiQA, publish);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static CauTraLoiQAPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CauTraLoiQAPersistence persistence) {
        _persistence = persistence;
    }
}
