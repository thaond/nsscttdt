package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlMainSupportModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlMainSupport</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlMainSupport
 * @see com.sgs.portlet.document.model.impl.PmlMainSupportImpl
 * @see com.sgs.portlet.document.model.impl.PmlMainSupportModelImpl
 *
 */
public interface PmlMainSupportModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getProcessId();

    public void setProcessId(long processId);

    public long getProcessId_Main();

    public void setProcessId_Main(long processId_Main);

    public String getType_();

    public void setType_(String type_);

    public String getSupportInfomation();

    public void setSupportInfomation(String supportInfomation);

    public PmlMainSupport toEscapedModel();
}
