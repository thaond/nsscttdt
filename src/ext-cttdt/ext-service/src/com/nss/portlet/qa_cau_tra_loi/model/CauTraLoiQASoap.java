package com.nss.portlet.qa_cau_tra_loi.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CauTraLoiQASoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_tra_loi.service.http.CauTraLoiQAServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.service.http.CauTraLoiQAServiceSoap
 *
 */
public class CauTraLoiQASoap implements Serializable {
    private long _maCauTraLoiQA;
    private long _maCauHoiQA;
    private long _maNguoiTraLoi;
    private String _noiDungTraLoi;
    private Date _createdate;
    private Date _publishdate;
    private boolean _publish;

    public CauTraLoiQASoap() {
    }

    public static CauTraLoiQASoap toSoapModel(CauTraLoiQA model) {
        CauTraLoiQASoap soapModel = new CauTraLoiQASoap();

        soapModel.setMaCauTraLoiQA(model.getMaCauTraLoiQA());
        soapModel.setMaCauHoiQA(model.getMaCauHoiQA());
        soapModel.setMaNguoiTraLoi(model.getMaNguoiTraLoi());
        soapModel.setNoiDungTraLoi(model.getNoiDungTraLoi());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setPublishdate(model.getPublishdate());
        soapModel.setPublish(model.getPublish());

        return soapModel;
    }

    public static CauTraLoiQASoap[] toSoapModels(CauTraLoiQA[] models) {
        CauTraLoiQASoap[] soapModels = new CauTraLoiQASoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CauTraLoiQASoap[][] toSoapModels(CauTraLoiQA[][] models) {
        CauTraLoiQASoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CauTraLoiQASoap[models.length][models[0].length];
        } else {
            soapModels = new CauTraLoiQASoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CauTraLoiQASoap[] toSoapModels(List<CauTraLoiQA> models) {
        List<CauTraLoiQASoap> soapModels = new ArrayList<CauTraLoiQASoap>(models.size());

        for (CauTraLoiQA model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CauTraLoiQASoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maCauTraLoiQA;
    }

    public void setPrimaryKey(long pk) {
        setMaCauTraLoiQA(pk);
    }

    public long getMaCauTraLoiQA() {
        return _maCauTraLoiQA;
    }

    public void setMaCauTraLoiQA(long maCauTraLoiQA) {
        _maCauTraLoiQA = maCauTraLoiQA;
    }

    public long getMaCauHoiQA() {
        return _maCauHoiQA;
    }

    public void setMaCauHoiQA(long maCauHoiQA) {
        _maCauHoiQA = maCauHoiQA;
    }

    public long getMaNguoiTraLoi() {
        return _maNguoiTraLoi;
    }

    public void setMaNguoiTraLoi(long maNguoiTraLoi) {
        _maNguoiTraLoi = maNguoiTraLoi;
    }

    public String getNoiDungTraLoi() {
        return _noiDungTraLoi;
    }

    public void setNoiDungTraLoi(String noiDungTraLoi) {
        _noiDungTraLoi = noiDungTraLoi;
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
