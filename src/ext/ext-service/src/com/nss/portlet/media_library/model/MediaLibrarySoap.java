package com.nss.portlet.media_library.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MediaLibrarySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.media_library.service.http.MediaLibraryServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_library.service.http.MediaLibraryServiceSoap
 *
 */
public class MediaLibrarySoap implements Serializable {
    private long _maMediaLibrary;
    private long _maMediaChuDe;
    private String _tieuDeMediaLibrary;
    private String _tenMediaLibrary;
    private long _kichThuoc;
    private String _duongDan;
    private long _userId;
    private long _luotXem;
    private Date _createdate;
    private Date _modifieddate;
    private boolean _active;

    public MediaLibrarySoap() {
    }

    public static MediaLibrarySoap toSoapModel(MediaLibrary model) {
        MediaLibrarySoap soapModel = new MediaLibrarySoap();

        soapModel.setMaMediaLibrary(model.getMaMediaLibrary());
        soapModel.setMaMediaChuDe(model.getMaMediaChuDe());
        soapModel.setTieuDeMediaLibrary(model.getTieuDeMediaLibrary());
        soapModel.setTenMediaLibrary(model.getTenMediaLibrary());
        soapModel.setKichThuoc(model.getKichThuoc());
        soapModel.setDuongDan(model.getDuongDan());
        soapModel.setUserId(model.getUserId());
        soapModel.setLuotXem(model.getLuotXem());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static MediaLibrarySoap[] toSoapModels(MediaLibrary[] models) {
        MediaLibrarySoap[] soapModels = new MediaLibrarySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MediaLibrarySoap[][] toSoapModels(MediaLibrary[][] models) {
        MediaLibrarySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MediaLibrarySoap[models.length][models[0].length];
        } else {
            soapModels = new MediaLibrarySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MediaLibrarySoap[] toSoapModels(List<MediaLibrary> models) {
        List<MediaLibrarySoap> soapModels = new ArrayList<MediaLibrarySoap>(models.size());

        for (MediaLibrary model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MediaLibrarySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maMediaLibrary;
    }

    public void setPrimaryKey(long pk) {
        setMaMediaLibrary(pk);
    }

    public long getMaMediaLibrary() {
        return _maMediaLibrary;
    }

    public void setMaMediaLibrary(long maMediaLibrary) {
        _maMediaLibrary = maMediaLibrary;
    }

    public long getMaMediaChuDe() {
        return _maMediaChuDe;
    }

    public void setMaMediaChuDe(long maMediaChuDe) {
        _maMediaChuDe = maMediaChuDe;
    }

    public String getTieuDeMediaLibrary() {
        return _tieuDeMediaLibrary;
    }

    public void setTieuDeMediaLibrary(String tieuDeMediaLibrary) {
        _tieuDeMediaLibrary = tieuDeMediaLibrary;
    }

    public String getTenMediaLibrary() {
        return _tenMediaLibrary;
    }

    public void setTenMediaLibrary(String tenMediaLibrary) {
        _tenMediaLibrary = tenMediaLibrary;
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        _kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return _duongDan;
    }

    public void setDuongDan(String duongDan) {
        _duongDan = duongDan;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getLuotXem() {
        return _luotXem;
    }

    public void setLuotXem(long luotXem) {
        _luotXem = luotXem;
    }

    public Date getCreatedate() {
        return _createdate;
    }

    public void setCreatedate(Date createdate) {
        _createdate = createdate;
    }

    public Date getModifieddate() {
        return _modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        _modifieddate = modifieddate;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }
}
