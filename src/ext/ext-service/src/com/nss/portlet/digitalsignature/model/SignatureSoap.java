package com.nss.portlet.digitalsignature.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="SignatureSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.digitalsignature.service.http.SignatureServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.http.SignatureServiceSoap
 *
 */
public class SignatureSoap implements Serializable {
    private long _signatureId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private long _articleId;
    private String _signData;

    public SignatureSoap() {
    }

    public static SignatureSoap toSoapModel(Signature model) {
        SignatureSoap soapModel = new SignatureSoap();

        soapModel.setSignatureId(model.getSignatureId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setArticleId(model.getArticleId());
        soapModel.setSignData(model.getSignData());

        return soapModel;
    }

    public static SignatureSoap[] toSoapModels(Signature[] models) {
        SignatureSoap[] soapModels = new SignatureSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SignatureSoap[][] toSoapModels(Signature[][] models) {
        SignatureSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SignatureSoap[models.length][models[0].length];
        } else {
            soapModels = new SignatureSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SignatureSoap[] toSoapModels(List<Signature> models) {
        List<SignatureSoap> soapModels = new ArrayList<SignatureSoap>(models.size());

        for (Signature model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SignatureSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _signatureId;
    }

    public void setPrimaryKey(long pk) {
        setSignatureId(pk);
    }

    public long getSignatureId() {
        return _signatureId;
    }

    public void setSignatureId(long signatureId) {
        _signatureId = signatureId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getArticleId() {
        return _articleId;
    }

    public void setArticleId(long articleId) {
        _articleId = articleId;
    }

    public String getSignData() {
        return _signData;
    }

    public void setSignData(String signData) {
        _signData = signData;
    }
}
