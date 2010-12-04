package com.nss.portlet.agency.model;

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
 * @see com.nss.portlet.agency.model.PmlAgencyLeader
 * @see com.nss.portlet.agency.model.impl.PmlAgencyLeaderImpl
 * @see com.nss.portlet.agency.model.impl.PmlAgencyLeaderModelImpl
 *
 */
public interface PmlAgencyLeaderModel extends BaseModel<PmlAgencyLeader> {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getAgencyId();

    public void setAgencyId(String agencyId);

    public long getUserId();

    public void setUserId(long userId);

    public PmlAgencyLeader toEscapedModel();
}
