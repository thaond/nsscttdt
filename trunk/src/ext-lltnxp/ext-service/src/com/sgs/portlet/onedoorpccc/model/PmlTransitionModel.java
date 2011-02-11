package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlTransitionModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTransition</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlTransition
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlTransitionImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlTransitionModelImpl
 *
 */
public interface PmlTransitionModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getTransitionId();

    public void setTransitionId(long transitionId);

    public String getTransitionName();

    public void setTransitionName(String transitionName);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public int getNoTransition();

    public void setNoTransition(int noTransition);

    public long getStateProcessCurrent();

    public void setStateProcessCurrent(long stateProcessCurrent);

    public long getStateProcessNext();

    public void setStateProcessNext(long stateProcessNext);

    public String getVersion_();

    public void setVersion_(String version_);

    public PmlTransition toEscapedModel();
}
