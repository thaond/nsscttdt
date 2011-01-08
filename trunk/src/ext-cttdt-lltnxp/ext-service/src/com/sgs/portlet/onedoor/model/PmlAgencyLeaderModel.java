package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlAgencyLeaderModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlAgencyLeader</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlAgencyLeader
 * @see com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderModelImpl
 *
 */
public interface PmlAgencyLeaderModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getAgencyId();

    public void setAgencyId(String agencyId);

    public long getUserId();

    public void setUserId(long userId);

    public PmlAgencyLeader toEscapedModel();
}
