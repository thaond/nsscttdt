package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlTeamLeaderModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTeamLeader</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlTeamLeader
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlTeamLeaderImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlTeamLeaderModelImpl
 *
 */
public interface PmlTeamLeaderModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getTeamId();

    public void setTeamId(long teamId);

    public long getUserId();

    public void setUserId(long userId);

    public PmlTeamLeader toEscapedModel();
}
