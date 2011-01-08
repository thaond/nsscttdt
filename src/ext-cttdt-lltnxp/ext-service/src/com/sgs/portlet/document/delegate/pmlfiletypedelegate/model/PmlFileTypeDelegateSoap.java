package com.sgs.portlet.document.delegate.pmlfiletypedelegate.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeDelegateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.http.PmlFileTypeDelegateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.http.PmlFileTypeDelegateServiceSoap
 *
 */
public class PmlFileTypeDelegateSoap implements Serializable {
    private long _fileTypeDelegateId;
    private String _fileTypeId;
    private long _delegateId;

    public PmlFileTypeDelegateSoap() {
    }

    public static PmlFileTypeDelegateSoap toSoapModel(PmlFileTypeDelegate model) {
        PmlFileTypeDelegateSoap soapModel = new PmlFileTypeDelegateSoap();

        soapModel.setFileTypeDelegateId(model.getFileTypeDelegateId());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setDelegateId(model.getDelegateId());

        return soapModel;
    }

    public static PmlFileTypeDelegateSoap[] toSoapModels(
        List<PmlFileTypeDelegate> models) {
        List<PmlFileTypeDelegateSoap> soapModels = new ArrayList<PmlFileTypeDelegateSoap>(models.size());

        for (PmlFileTypeDelegate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileTypeDelegateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileTypeDelegateId;
    }

    public void setPrimaryKey(long pk) {
        setFileTypeDelegateId(pk);
    }

    public long getFileTypeDelegateId() {
        return _fileTypeDelegateId;
    }

    public void setFileTypeDelegateId(long fileTypeDelegateId) {
        _fileTypeDelegateId = fileTypeDelegateId;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public long getDelegateId() {
        return _delegateId;
    }

    public void setDelegateId(long delegateId) {
        _delegateId = delegateId;
    }
}
