package com.nss.portlet.journalworkflow.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface InstanceBeanPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean);

    public void cacheResult(
        java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> instanceBeans);

    public void clearCache();

    public com.nss.portlet.journalworkflow.model.InstanceBean create(
        long processInstanceId);

    public com.nss.portlet.journalworkflow.model.InstanceBean remove(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean remove(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(InstanceBean instanceBean, boolean merge)</code>.
     */
    public com.nss.portlet.journalworkflow.model.InstanceBean update(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.journalworkflow.model.InstanceBean update(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean updateImpl(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByPrimaryKey(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean fetchByPrimaryKey(
        long processInstanceId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus(
        java.lang.String status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByStatus_PrevAndNext(
        long processInstanceId, java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByStatus_Finish(
        java.lang.String status, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Finish_First(
        java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByStatus_Finish_Last(
        java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByStatus_Finish_PrevAndNext(
        long processInstanceId, java.lang.String status, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByPreviousNode(
        java.lang.String previousNode, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByPreviousNode_First(
        java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByPreviousNode_Last(
        java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByPreviousNode_PrevAndNext(
        long processInstanceId, java.lang.String previousNode, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByArticleId(
        long articleId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByArticleId_First(
        long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByArticleId_Last(
        long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByArticleId_PrevAndNext(
        long processInstanceId, long articleId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByCreateUserId(
        long createUserId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByCreateUserId_First(
        long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByCreateUserId_Last(
        long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByCreateUserId_PrevAndNext(
        long processInstanceId, long createUserId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findByBusinessProcessId(
        long businessProcessId, boolean finish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByBusinessProcessId_First(
        long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean findByBusinessProcessId_Last(
        long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public com.nss.portlet.journalworkflow.model.InstanceBean[] findByBusinessProcessId_PrevAndNext(
        long processInstanceId, long businessProcessId, boolean finish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.InstanceBean> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByStatus(java.lang.String status)
        throws com.liferay.portal.SystemException;

    public void removeByStatus_Finish(java.lang.String status, boolean finish)
        throws com.liferay.portal.SystemException;

    public void removeByPreviousNode(java.lang.String previousNode,
        boolean finish) throws com.liferay.portal.SystemException;

    public void removeByArticleId(long articleId, boolean finish)
        throws com.liferay.portal.SystemException;

    public void removeByCreateUserId(long createUserId, boolean finish)
        throws com.liferay.portal.SystemException;

    public void removeByBusinessProcessId(long businessProcessId, boolean finish)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByStatus(java.lang.String status)
        throws com.liferay.portal.SystemException;

    public int countByStatus_Finish(java.lang.String status, boolean finish)
        throws com.liferay.portal.SystemException;

    public int countByPreviousNode(java.lang.String previousNode, boolean finish)
        throws com.liferay.portal.SystemException;

    public int countByArticleId(long articleId, boolean finish)
        throws com.liferay.portal.SystemException;

    public int countByCreateUserId(long createUserId, boolean finish)
        throws com.liferay.portal.SystemException;

    public int countByBusinessProcessId(long businessProcessId, boolean finish)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
