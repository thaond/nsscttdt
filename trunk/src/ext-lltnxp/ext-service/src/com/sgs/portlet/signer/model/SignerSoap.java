package com.sgs.portlet.signer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SignerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.signer.service.http.SignerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.service.http.SignerServiceSoap
 *
 */
public class SignerSoap implements Serializable {
    private long _signerId;
    private long _userId;

    public SignerSoap() {
    }

    public static SignerSoap toSoapModel(Signer model) {
        SignerSoap soapModel = new SignerSoap();

        soapModel.setSignerId(model.getSignerId());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static SignerSoap[] toSoapModels(List<Signer> models) {
        List<SignerSoap> soapModels = new ArrayList<SignerSoap>(models.size());

        for (Signer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SignerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _signerId;
    }

    public void setPrimaryKey(long pk) {
        setSignerId(pk);
    }

    public long getSignerId() {
        return _signerId;
    }

    public void setSignerId(long signerId) {
        _signerId = signerId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
