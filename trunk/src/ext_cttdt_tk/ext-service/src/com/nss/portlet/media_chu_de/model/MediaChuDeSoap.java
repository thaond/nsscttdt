package com.nss.portlet.media_chu_de.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MediaChuDeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.media_chu_de.service.http.MediaChuDeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_chu_de.service.http.MediaChuDeServiceSoap
 *
 */
public class MediaChuDeSoap implements Serializable {
    private long _maMediaChuDe;
    private String _tenMediaChuDe;
    private boolean _active;

    public MediaChuDeSoap() {
    }

    public static MediaChuDeSoap toSoapModel(MediaChuDe model) {
        MediaChuDeSoap soapModel = new MediaChuDeSoap();

        soapModel.setMaMediaChuDe(model.getMaMediaChuDe());
        soapModel.setTenMediaChuDe(model.getTenMediaChuDe());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static MediaChuDeSoap[] toSoapModels(MediaChuDe[] models) {
        MediaChuDeSoap[] soapModels = new MediaChuDeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MediaChuDeSoap[][] toSoapModels(MediaChuDe[][] models) {
        MediaChuDeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MediaChuDeSoap[models.length][models[0].length];
        } else {
            soapModels = new MediaChuDeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MediaChuDeSoap[] toSoapModels(List<MediaChuDe> models) {
        List<MediaChuDeSoap> soapModels = new ArrayList<MediaChuDeSoap>(models.size());

        for (MediaChuDe model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MediaChuDeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maMediaChuDe;
    }

    public void setPrimaryKey(long pk) {
        setMaMediaChuDe(pk);
    }

    public long getMaMediaChuDe() {
        return _maMediaChuDe;
    }

    public void setMaMediaChuDe(long maMediaChuDe) {
        _maMediaChuDe = maMediaChuDe;
    }

    public String getTenMediaChuDe() {
        return _tenMediaChuDe;
    }

    public void setTenMediaChuDe(String tenMediaChuDe) {
        _tenMediaChuDe = tenMediaChuDe;
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
