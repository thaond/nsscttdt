package com.nss.portlet.journalworkflow.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="InstanceBeanModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>InstanceBean</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.model.InstanceBean
 * @see com.nss.portlet.journalworkflow.model.impl.InstanceBeanImpl
 * @see com.nss.portlet.journalworkflow.model.impl.InstanceBeanModelImpl
 *
 */
public interface InstanceBeanModel extends BaseModel<InstanceBean> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getProcessInstanceId();

    public void setProcessInstanceId(long processInstanceId);

    public long getBusinessProcessId();

    public void setBusinessProcessId(long businessProcessId);

    public long getArticleId();

    public void setArticleId(long articleId);

    public long getCategoryId();

    public void setCategoryId(long categoryId);

    public String getPreviousNode();

    public void setPreviousNode(String previousNode);

    public String getStatus();

    public void setStatus(String status);

    public long getCreateUserId();

    public void setCreateUserId(long createUserId);

    public boolean getFinish();

    public boolean isFinish();

    public void setFinish(boolean finish);

    public InstanceBean toEscapedModel();
}
