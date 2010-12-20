package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlWfOnedoorProcessSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlWfOnedoorProcessServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlWfOnedoorProcessServiceSoap
 *
 */
public class PmlWfOnedoorProcessSoap implements Serializable {
    private String _fileId;
    private long _processId;

    public PmlWfOnedoorProcessSoap() {
    }

    public static PmlWfOnedoorProcessSoap toSoapModel(PmlWfOnedoorProcess model) {
        PmlWfOnedoorProcessSoap soapModel = new PmlWfOnedoorProcessSoap();

        soapModel.setFileId(model.getFileId());
        soapModel.setProcessId(model.getProcessId());

        return soapModel;
    }

    public static PmlWfOnedoorProcessSoap[] toSoapModels(
        PmlWfOnedoorProcess[] models) {
        PmlWfOnedoorProcessSoap[] soapModels = new PmlWfOnedoorProcessSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlWfOnedoorProcessSoap[][] toSoapModels(
        PmlWfOnedoorProcess[][] models) {
        PmlWfOnedoorProcessSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlWfOnedoorProcessSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlWfOnedoorProcessSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlWfOnedoorProcessSoap[] toSoapModels(
        List<PmlWfOnedoorProcess> models) {
        List<PmlWfOnedoorProcessSoap> soapModels = new ArrayList<PmlWfOnedoorProcessSoap>(models.size());

        for (PmlWfOnedoorProcess model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlWfOnedoorProcessSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _fileId;
    }

    public void setPrimaryKey(String pk) {
        setFileId(pk);
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        _processId = processId;
    }
}
