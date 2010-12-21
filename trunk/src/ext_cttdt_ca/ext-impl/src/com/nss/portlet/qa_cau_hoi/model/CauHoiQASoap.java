package com.nss.portlet.qa_cau_hoi.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CauHoiQASoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_hoi.service.http.CauHoiQAServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.http.CauHoiQAServiceSoap
 *
 */
public class CauHoiQASoap implements Serializable {
    private long _maCauHoiQA;
    private long _maChuDeCauHoi;
    private String _tieuDe;
    private String _tenNguoiHoi;
    private String _email;
    private String _noiDungHoi;
    private Date _createdate;
    private Date _publishdate;
    private boolean _publish;

    public CauHoiQASoap() {
    }

    public static CauHoiQASoap toSoapModel(CauHoiQA model) {
        CauHoiQASoap soapModel = new CauHoiQASoap();

        soapModel.setMaCauHoiQA(model.getMaCauHoiQA());
        soapModel.setMaChuDeCauHoi(model.getMaChuDeCauHoi());
        soapModel.setTieuDe(model.getTieuDe());
        soapModel.setTenNguoiHoi(model.getTenNguoiHoi());
        soapModel.setEmail(model.getEmail());
        soapModel.setNoiDungHoi(model.getNoiDungHoi());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setPublishdate(model.getPublishdate());
        soapModel.setPublish(model.getPublish());

        return soapModel;
    }

    public static CauHoiQASoap[] toSoapModels(CauHoiQA[] models) {
        CauHoiQASoap[] soapModels = new CauHoiQASoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CauHoiQASoap[][] toSoapModels(CauHoiQA[][] models) {
        CauHoiQASoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CauHoiQASoap[models.length][models[0].length];
        } else {
            soapModels = new CauHoiQASoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CauHoiQASoap[] toSoapModels(List<CauHoiQA> models) {
        List<CauHoiQASoap> soapModels = new ArrayList<CauHoiQASoap>(models.size());

        for (CauHoiQA model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CauHoiQASoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maCauHoiQA;
    }

    public void setPrimaryKey(long pk) {
        setMaCauHoiQA(pk);
    }

    public long getMaCauHoiQA() {
        return _maCauHoiQA;
    }

    public void setMaCauHoiQA(long maCauHoiQA) {
        _maCauHoiQA = maCauHoiQA;
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public String getTieuDe() {
        return _tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        _tieuDe = tieuDe;
    }

    public String getTenNguoiHoi() {
        return _tenNguoiHoi;
    }

    public void setTenNguoiHoi(String tenNguoiHoi) {
        _tenNguoiHoi = tenNguoiHoi;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getNoiDungHoi() {
        return _noiDungHoi;
    }

    public void setNoiDungHoi(String noiDungHoi) {
        _noiDungHoi = noiDungHoi;
    }

    public Date getCreatedate() {
        return _createdate;
    }

    public void setCreatedate(Date createdate) {
        _createdate = createdate;
    }

    public Date getPublishdate() {
        return _publishdate;
    }

    public void setPublishdate(Date publishdate) {
        _publishdate = publishdate;
    }

    public boolean getPublish() {
        return _publish;
    }

    public boolean isPublish() {
        return _publish;
    }

    public void setPublish(boolean publish) {
        _publish = publish;
    }
}
