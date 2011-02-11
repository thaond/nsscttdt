package com.sgs.portlet.onedoorpccc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTeamLeaderSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlTeamLeaderServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlTeamLeaderServiceSoap
 *
 */
public class PmlTeamLeaderSoap implements Serializable {
    private long _teamId;
    private long _userId;

    public PmlTeamLeaderSoap() {
    }

    public static PmlTeamLeaderSoap toSoapModel(PmlTeamLeader model) {
        PmlTeamLeaderSoap soapModel = new PmlTeamLeaderSoap();

        soapModel.setTeamId(model.getTeamId());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static PmlTeamLeaderSoap[] toSoapModels(List<PmlTeamLeader> models) {
        List<PmlTeamLeaderSoap> soapModels = new ArrayList<PmlTeamLeaderSoap>(models.size());

        for (PmlTeamLeader model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTeamLeaderSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _teamId;
    }

    public void setPrimaryKey(long pk) {
        setTeamId(pk);
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        _teamId = teamId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
