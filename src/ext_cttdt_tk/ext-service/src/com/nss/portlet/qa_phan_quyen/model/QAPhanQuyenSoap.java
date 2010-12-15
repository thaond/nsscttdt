package com.nss.portlet.qa_phan_quyen.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="QAPhanQuyenSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_phan_quyen.service.http.QAPhanQuyenServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.service.http.QAPhanQuyenServiceSoap
 *
 */
public class QAPhanQuyenSoap implements Serializable {
    private long _maPhanQuyen;
    private long _maChuDeCauHoi;
    private long _maNguoiTraLoi;
    private boolean _quyenXem;
    private boolean _quyenCapNhat;
    private boolean _quyenTraLoi;
    private boolean _quyenDuyet;

    public QAPhanQuyenSoap() {
    }

    public static QAPhanQuyenSoap toSoapModel(QAPhanQuyen model) {
        QAPhanQuyenSoap soapModel = new QAPhanQuyenSoap();

        soapModel.setMaPhanQuyen(model.getMaPhanQuyen());
        soapModel.setMaChuDeCauHoi(model.getMaChuDeCauHoi());
        soapModel.setMaNguoiTraLoi(model.getMaNguoiTraLoi());
        soapModel.setQuyenXem(model.getQuyenXem());
        soapModel.setQuyenCapNhat(model.getQuyenCapNhat());
        soapModel.setQuyenTraLoi(model.getQuyenTraLoi());
        soapModel.setQuyenDuyet(model.getQuyenDuyet());

        return soapModel;
    }

    public static QAPhanQuyenSoap[] toSoapModels(QAPhanQuyen[] models) {
        QAPhanQuyenSoap[] soapModels = new QAPhanQuyenSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static QAPhanQuyenSoap[][] toSoapModels(QAPhanQuyen[][] models) {
        QAPhanQuyenSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new QAPhanQuyenSoap[models.length][models[0].length];
        } else {
            soapModels = new QAPhanQuyenSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static QAPhanQuyenSoap[] toSoapModels(List<QAPhanQuyen> models) {
        List<QAPhanQuyenSoap> soapModels = new ArrayList<QAPhanQuyenSoap>(models.size());

        for (QAPhanQuyen model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new QAPhanQuyenSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maPhanQuyen;
    }

    public void setPrimaryKey(long pk) {
        setMaPhanQuyen(pk);
    }

    public long getMaPhanQuyen() {
        return _maPhanQuyen;
    }

    public void setMaPhanQuyen(long maPhanQuyen) {
        _maPhanQuyen = maPhanQuyen;
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public long getMaNguoiTraLoi() {
        return _maNguoiTraLoi;
    }

    public void setMaNguoiTraLoi(long maNguoiTraLoi) {
        _maNguoiTraLoi = maNguoiTraLoi;
    }

    public boolean getQuyenXem() {
        return _quyenXem;
    }

    public boolean isQuyenXem() {
        return _quyenXem;
    }

    public void setQuyenXem(boolean quyenXem) {
        _quyenXem = quyenXem;
    }

    public boolean getQuyenCapNhat() {
        return _quyenCapNhat;
    }

    public boolean isQuyenCapNhat() {
        return _quyenCapNhat;
    }

    public void setQuyenCapNhat(boolean quyenCapNhat) {
        _quyenCapNhat = quyenCapNhat;
    }

    public boolean getQuyenTraLoi() {
        return _quyenTraLoi;
    }

    public boolean isQuyenTraLoi() {
        return _quyenTraLoi;
    }

    public void setQuyenTraLoi(boolean quyenTraLoi) {
        _quyenTraLoi = quyenTraLoi;
    }

    public boolean getQuyenDuyet() {
        return _quyenDuyet;
    }

    public boolean isQuyenDuyet() {
        return _quyenDuyet;
    }

    public void setQuyenDuyet(boolean quyenDuyet) {
        _quyenDuyet = quyenDuyet;
    }
}
