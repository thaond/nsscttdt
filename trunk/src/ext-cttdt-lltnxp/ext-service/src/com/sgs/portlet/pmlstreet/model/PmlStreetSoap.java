package com.sgs.portlet.pmlstreet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStreetSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmlstreet.service.http.PmlStreetServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlstreet.service.http.PmlStreetServiceSoap
 *
 */
public class PmlStreetSoap implements Serializable {
    private String _streetId;
    private String _streetName;

    public PmlStreetSoap() {
    }

    public static PmlStreetSoap toSoapModel(PmlStreet model) {
        PmlStreetSoap soapModel = new PmlStreetSoap();

        soapModel.setStreetId(model.getStreetId());
        soapModel.setStreetName(model.getStreetName());

        return soapModel;
    }

    public static PmlStreetSoap[] toSoapModels(List<PmlStreet> models) {
        List<PmlStreetSoap> soapModels = new ArrayList<PmlStreetSoap>(models.size());

        for (PmlStreet model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlStreetSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _streetId;
    }

    public void setPrimaryKey(String pk) {
        setStreetId(pk);
    }

    public String getStreetId() {
        return _streetId;
    }

    public void setStreetId(String streetId) {
        _streetId = streetId;
    }

    public String getStreetName() {
        return _streetName;
    }

    public void setStreetName(String streetName) {
        _streetName = streetName;
    }
}
