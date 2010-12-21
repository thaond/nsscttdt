package com.nss.portlet.phone_book.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ContactBookSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.phone_book.service.http.ContactBookServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.http.ContactBookServiceSoap
 *
 */
public class ContactBookSoap implements Serializable {
    private long _contactBookId;
    private String _contactBookCode;
    private String _contactBookName;
    private String _contactDescription;
    private boolean _contactActive;
    private long _companyid;
    private long _userid;

    public ContactBookSoap() {
    }

    public static ContactBookSoap toSoapModel(ContactBook model) {
        ContactBookSoap soapModel = new ContactBookSoap();

        soapModel.setContactBookId(model.getContactBookId());
        soapModel.setContactBookCode(model.getContactBookCode());
        soapModel.setContactBookName(model.getContactBookName());
        soapModel.setContactDescription(model.getContactDescription());
        soapModel.setContactActive(model.getContactActive());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());

        return soapModel;
    }

    public static ContactBookSoap[] toSoapModels(ContactBook[] models) {
        ContactBookSoap[] soapModels = new ContactBookSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactBookSoap[][] toSoapModels(ContactBook[][] models) {
        ContactBookSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactBookSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactBookSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactBookSoap[] toSoapModels(List<ContactBook> models) {
        List<ContactBookSoap> soapModels = new ArrayList<ContactBookSoap>(models.size());

        for (ContactBook model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactBookSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactBookId;
    }

    public void setPrimaryKey(long pk) {
        setContactBookId(pk);
    }

    public long getContactBookId() {
        return _contactBookId;
    }

    public void setContactBookId(long contactBookId) {
        _contactBookId = contactBookId;
    }

    public String getContactBookCode() {
        return _contactBookCode;
    }

    public void setContactBookCode(String contactBookCode) {
        _contactBookCode = contactBookCode;
    }

    public String getContactBookName() {
        return _contactBookName;
    }

    public void setContactBookName(String contactBookName) {
        _contactBookName = contactBookName;
    }

    public String getContactDescription() {
        return _contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        _contactDescription = contactDescription;
    }

    public boolean getContactActive() {
        return _contactActive;
    }

    public boolean isContactActive() {
        return _contactActive;
    }

    public void setContactActive(boolean contactActive) {
        _contactActive = contactActive;
    }

    public long getCompanyid() {
        return _companyid;
    }

    public void setCompanyid(long companyid) {
        _companyid = companyid;
    }

    public long getUserid() {
        return _userid;
    }

    public void setUserid(long userid) {
        _userid = userid;
    }
}
