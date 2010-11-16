package com.nss.portlet.digitalsignature.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CertificateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.digitalsignature.service.http.CertificateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.http.CertificateServiceSoap
 *
 */
public class CertificateSoap implements Serializable {
    private long _userId;
    private String _x509Certificate;

    public CertificateSoap() {
    }

    public static CertificateSoap toSoapModel(Certificate model) {
        CertificateSoap soapModel = new CertificateSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setX509Certificate(model.getX509Certificate());

        return soapModel;
    }

    public static CertificateSoap[] toSoapModels(Certificate[] models) {
        CertificateSoap[] soapModels = new CertificateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CertificateSoap[][] toSoapModels(Certificate[][] models) {
        CertificateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CertificateSoap[models.length][models[0].length];
        } else {
            soapModels = new CertificateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CertificateSoap[] toSoapModels(List<Certificate> models) {
        List<CertificateSoap> soapModels = new ArrayList<CertificateSoap>(models.size());

        for (Certificate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CertificateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getX509Certificate() {
        return _x509Certificate;
    }

    public void setX509Certificate(String x509Certificate) {
        _x509Certificate = x509Certificate;
    }
}
