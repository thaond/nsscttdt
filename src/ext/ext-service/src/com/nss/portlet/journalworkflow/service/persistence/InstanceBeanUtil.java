package com.nss.portlet.journalworkflow.service.persistence;

public class InstanceBeanUtil {
    private static InstanceBeanPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean) {
        getPersistence().cacheResult(instanceBean);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> instanceBeans) {
        getPersistence().cacheResult(instanceBeans);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean create(
        long processInstanceId) {
        return getPersistence().create(processInstanceId);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean remove(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().remove(processInstanceId);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean remove(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(instanceBean);
    }

    /**
     * @deprecated Use <code>update(InstanceBean instanceBean, boolean merge)</code>.
     */
    public static com.nss.portlet.journalworkflow.model.InstanceBean update(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(instanceBean);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                instanceBean the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when instanceBean is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.journalworkflow.model.InstanceBean update(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(instanceBean, merge);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean updateImpl(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(instanceBean, merge);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByPrimaryKey(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByPrimaryKey(processInstanceId);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean fetchByPrimaryKey(
        long processInstanceId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(processInstanceId);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status) throws com.liferay.portal.SystemException {
        return getPersistence().findByStatus(status);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatus(status, start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatus(status, start, end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByStatus_First(status, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByStatus_Last(status, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByStatus_PrevAndNext(
        long processInstanceId, java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByStatus_PrevAndNext(processInstanceId, status, obc);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatus_Finish(status, finish);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatus_Finish(status, finish, start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStatus_Finish(status, finish, start, end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Finish_First(
        java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByStatus_Finish_First(status, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Finish_Last(
        java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByStatus_Finish_Last(status, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByStatus_Finish_PrevAndNext(
        long processInstanceId, java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByStatus_Finish_PrevAndNext(processInstanceId, status,
            finish, obc);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPreviousNode(previousNode, finish);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPreviousNode(previousNode, finish, start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPreviousNode(previousNode, finish, start, end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByPreviousNode_First(
        java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByPreviousNode_First(previousNode, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByPreviousNode_Last(
        java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByPreviousNode_Last(previousNode, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByPreviousNode_PrevAndNext(
        long processInstanceId, java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByPreviousNode_PrevAndNext(processInstanceId,
            previousNode, finish, obc);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByArticleId(articleId, finish);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByArticleId(articleId, finish, start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByArticleId(articleId, finish, start, end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByArticleId_First(
        long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByArticleId_First(articleId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByArticleId_Last(
        long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence().findByArticleId_Last(articleId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByArticleId_PrevAndNext(
        long processInstanceId, long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByArticleId_PrevAndNext(processInstanceId, articleId,
            finish, obc);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateUserId(createUserId, finish);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCreateUserId(createUserId, finish, start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCreateUserId(createUserId, finish, start, end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByCreateUserId_First(
        long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByCreateUserId_First(createUserId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByCreateUserId_Last(
        long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByCreateUserId_Last(createUserId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByCreateUserId_PrevAndNext(
        long processInstanceId, long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByCreateUserId_PrevAndNext(processInstanceId,
            createUserId, finish, obc);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByBusinessProcessId(businessProcessId, finish);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByBusinessProcessId(businessProcessId, finish, start,
            end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByBusinessProcessId(businessProcessId, finish, start,
            end, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByBusinessProcessId_First(
        long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByBusinessProcessId_First(businessProcessId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean findByBusinessProcessId_Last(
        long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByBusinessProcessId_Last(businessProcessId, finish, obc);
    }

    public static com.nss.portlet.journalworkflow.model.InstanceBean[] findByBusinessProcessId_PrevAndNext(
        long processInstanceId, long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException {
        return getPersistence()
                   .findByBusinessProcessId_PrevAndNext(processInstanceId,
            businessProcessId, finish, obc);
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

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByStatus(java.lang.String status)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStatus(status);
    }

    public static void removeByStatus_Finish(java.lang.String status,
        boolean finish) throws com.liferay.portal.SystemException {
        getPersistence().removeByStatus_Finish(status, finish);
    }

    public static void removeByPreviousNode(java.lang.String previousNode,
        boolean finish) throws com.liferay.portal.SystemException {
        getPersistence().removeByPreviousNode(previousNode, finish);
    }

    public static void removeByArticleId(long articleId, boolean finish)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByArticleId(articleId, finish);
    }

    public static void removeByCreateUserId(long createUserId, boolean finish)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCreateUserId(createUserId, finish);
    }

    public static void removeByBusinessProcessId(long businessProcessId,
        boolean finish) throws com.liferay.portal.SystemException {
        getPersistence().removeByBusinessProcessId(businessProcessId, finish);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByStatus(java.lang.String status)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStatus(status);
    }

    public static int countByStatus_Finish(java.lang.String status,
        boolean finish) throws com.liferay.portal.SystemException {
        return getPersistence().countByStatus_Finish(status, finish);
    }

    public static int countByPreviousNode(java.lang.String previousNode,
        boolean finish) throws com.liferay.portal.SystemException {
        return getPersistence().countByPreviousNode(previousNode, finish);
    }

    public static int countByArticleId(long articleId, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByArticleId(articleId, finish);
    }

    public static int countByCreateUserId(long createUserId, boolean finish)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCreateUserId(createUserId, finish);
    }

    public static int countByBusinessProcessId(long businessProcessId,
        boolean finish) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByBusinessProcessId(businessProcessId, finish);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static InstanceBeanPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(InstanceBeanPersistence persistence) {
        _persistence = persistence;
    }
}
