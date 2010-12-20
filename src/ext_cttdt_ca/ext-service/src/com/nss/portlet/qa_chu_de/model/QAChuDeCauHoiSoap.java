package com.nss.portlet.qa_chu_de.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="QAChuDeCauHoiSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_chu_de.service.http.QAChuDeCauHoiServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.service.http.QAChuDeCauHoiServiceSoap
 *
 */
public class QAChuDeCauHoiSoap implements Serializable {
    private long _maChuDeCauHoi;
    private String _tenChuDeCauHoi;
    private int _active;

    public QAChuDeCauHoiSoap() {
    }

    public static QAChuDeCauHoiSoap toSoapModel(QAChuDeCauHoi model) {
        QAChuDeCauHoiSoap soapModel = new QAChuDeCauHoiSoap();

        soapModel.setMaChuDeCauHoi(model.getMaChuDeCauHoi());
        soapModel.setTenChuDeCauHoi(model.getTenChuDeCauHoi());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static QAChuDeCauHoiSoap[] toSoapModels(QAChuDeCauHoi[] models) {
        QAChuDeCauHoiSoap[] soapModels = new QAChuDeCauHoiSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static QAChuDeCauHoiSoap[][] toSoapModels(QAChuDeCauHoi[][] models) {
        QAChuDeCauHoiSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new QAChuDeCauHoiSoap[models.length][models[0].length];
        } else {
            soapModels = new QAChuDeCauHoiSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static QAChuDeCauHoiSoap[] toSoapModels(List<QAChuDeCauHoi> models) {
        List<QAChuDeCauHoiSoap> soapModels = new ArrayList<QAChuDeCauHoiSoap>(models.size());

        for (QAChuDeCauHoi model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new QAChuDeCauHoiSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maChuDeCauHoi;
    }

    public void setPrimaryKey(long pk) {
        setMaChuDeCauHoi(pk);
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public String getTenChuDeCauHoi() {
        return _tenChuDeCauHoi;
    }

    public void setTenChuDeCauHoi(String tenChuDeCauHoi) {
        _tenChuDeCauHoi = tenChuDeCauHoi;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }
}
