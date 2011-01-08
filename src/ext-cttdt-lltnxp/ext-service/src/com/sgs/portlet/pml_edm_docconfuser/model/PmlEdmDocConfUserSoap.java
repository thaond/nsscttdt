package com.sgs.portlet.pml_edm_docconfuser.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocConfUserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.http.PmlEdmDocConfUserServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_edm_docconfuser.service.http.PmlEdmDocConfUserServiceSoap
 *
 */
public class PmlEdmDocConfUserSoap implements Serializable {
    private long _dcuId;
    private long _userId;
    private boolean _viewAllDoc;
    private String _viewDepDoc;

    public PmlEdmDocConfUserSoap() {
    }

    public static PmlEdmDocConfUserSoap toSoapModel(PmlEdmDocConfUser model) {
        PmlEdmDocConfUserSoap soapModel = new PmlEdmDocConfUserSoap();

        soapModel.setDcuId(model.getDcuId());
        soapModel.setUserId(model.getUserId());
        soapModel.setViewAllDoc(model.getViewAllDoc());
        soapModel.setViewDepDoc(model.getViewDepDoc());

        return soapModel;
    }

    public static PmlEdmDocConfUserSoap[] toSoapModels(
        List<PmlEdmDocConfUser> models) {
        List<PmlEdmDocConfUserSoap> soapModels = new ArrayList<PmlEdmDocConfUserSoap>(models.size());

        for (PmlEdmDocConfUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocConfUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dcuId;
    }

    public void setPrimaryKey(long pk) {
        setDcuId(pk);
    }

    public long getDcuId() {
        return _dcuId;
    }

    public void setDcuId(long dcuId) {
        _dcuId = dcuId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public boolean getViewAllDoc() {
        return _viewAllDoc;
    }

    public boolean isViewAllDoc() {
        return _viewAllDoc;
    }

    public void setViewAllDoc(boolean viewAllDoc) {
        _viewAllDoc = viewAllDoc;
    }

    public String getViewDepDoc() {
        return _viewDepDoc;
    }

    public void setViewDepDoc(String viewDepDoc) {
        _viewDepDoc = viewDepDoc;
    }
}
