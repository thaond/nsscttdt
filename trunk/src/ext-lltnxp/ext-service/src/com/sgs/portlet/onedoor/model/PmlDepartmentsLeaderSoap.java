package com.sgs.portlet.onedoor.model;

import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDepartmentsLeaderSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlDepartmentsLeaderServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlDepartmentsLeaderServiceSoap
 *
 */
public class PmlDepartmentsLeaderSoap implements Serializable {
    private String _departmentsId;
    private long _userId;
    private long _clericalId;
    private boolean _main;

    public PmlDepartmentsLeaderSoap() {
    }

    public static PmlDepartmentsLeaderSoap toSoapModel(
        PmlDepartmentsLeader model) {
        PmlDepartmentsLeaderSoap soapModel = new PmlDepartmentsLeaderSoap();

        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setUserId(model.getUserId());
        soapModel.setClericalId(model.getClericalId());
        soapModel.setMain(model.getMain());

        return soapModel;
    }

    public static PmlDepartmentsLeaderSoap[] toSoapModels(
        List<PmlDepartmentsLeader> models) {
        List<PmlDepartmentsLeaderSoap> soapModels = new ArrayList<PmlDepartmentsLeaderSoap>(models.size());

        for (PmlDepartmentsLeader model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDepartmentsLeaderSoap[soapModels.size()]);
    }

    public PmlDepartmentsLeaderPK getPrimaryKey() {
        return new PmlDepartmentsLeaderPK(_departmentsId, _userId);
    }

    public void setPrimaryKey(PmlDepartmentsLeaderPK pk) {
        setDepartmentsId(pk.departmentsId);
        setUserId(pk.userId);
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getClericalId() {
        return _clericalId;
    }

    public void setClericalId(long clericalId) {
        _clericalId = clericalId;
    }

    public boolean getMain() {
        return _main;
    }

    public boolean isMain() {
        return _main;
    }

    public void setMain(boolean main) {
        _main = main;
    }
}
