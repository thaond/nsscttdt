package com.sgs.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlAgencyLeaderSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlAgencyLeaderServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlAgencyLeaderServiceSoap
 *
 */
public class PmlAgencyLeaderSoap implements Serializable {
    private String _agencyId;
    private long _userId;

    public PmlAgencyLeaderSoap() {
    }

    public static PmlAgencyLeaderSoap toSoapModel(PmlAgencyLeader model) {
        PmlAgencyLeaderSoap soapModel = new PmlAgencyLeaderSoap();

        soapModel.setAgencyId(model.getAgencyId());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static PmlAgencyLeaderSoap[] toSoapModels(
        List<PmlAgencyLeader> models) {
        List<PmlAgencyLeaderSoap> soapModels = new ArrayList<PmlAgencyLeaderSoap>(models.size());

        for (PmlAgencyLeader model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlAgencyLeaderSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _agencyId;
    }

    public void setPrimaryKey(String pk) {
        setAgencyId(pk);
    }

    public String getAgencyId() {
        return _agencyId;
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
