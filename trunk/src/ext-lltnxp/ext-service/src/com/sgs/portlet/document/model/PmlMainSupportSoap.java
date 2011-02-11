package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlMainSupportSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlMainSupportServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlMainSupportServiceSoap
 *
 */
public class PmlMainSupportSoap implements Serializable {
    private long _processId;
    private long _processId_Main;
    private String _type_;
    private String _supportInfomation;

    public PmlMainSupportSoap() {
    }

    public static PmlMainSupportSoap toSoapModel(PmlMainSupport model) {
        PmlMainSupportSoap soapModel = new PmlMainSupportSoap();

        soapModel.setProcessId(model.getProcessId());
        soapModel.setProcessId_Main(model.getProcessId_Main());
        soapModel.setType_(model.getType_());
        soapModel.setSupportInfomation(model.getSupportInfomation());

        return soapModel;
    }

    public static PmlMainSupportSoap[] toSoapModels(List<PmlMainSupport> models) {
        List<PmlMainSupportSoap> soapModels = new ArrayList<PmlMainSupportSoap>(models.size());

        for (PmlMainSupport model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlMainSupportSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _processId;
    }

    public void setPrimaryKey(long pk) {
        setProcessId(pk);
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        _processId = processId;
    }

    public long getProcessId_Main() {
        return _processId_Main;
    }

    public void setProcessId_Main(long processId_Main) {
        _processId_Main = processId_Main;
    }

    public String getType_() {
        return _type_;
    }

    public void setType_(String type_) {
        _type_ = type_;
    }

    public String getSupportInfomation() {
        return _supportInfomation;
    }

    public void setSupportInfomation(String supportInfomation) {
        _supportInfomation = supportInfomation;
    }
}
