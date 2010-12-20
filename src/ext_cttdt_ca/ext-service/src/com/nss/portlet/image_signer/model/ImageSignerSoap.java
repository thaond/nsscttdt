package com.nss.portlet.image_signer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ImageSignerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.image_signer.service.http.ImageSignerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.image_signer.service.http.ImageSignerServiceSoap
 *
 */
public class ImageSignerSoap implements Serializable {
    private long _imageSignerId;
    private long _imageIdSign;
    private long _imageIdUnSign;
    private long _userId;

    public ImageSignerSoap() {
    }

    public static ImageSignerSoap toSoapModel(ImageSigner model) {
        ImageSignerSoap soapModel = new ImageSignerSoap();

        soapModel.setImageSignerId(model.getImageSignerId());
        soapModel.setImageIdSign(model.getImageIdSign());
        soapModel.setImageIdUnSign(model.getImageIdUnSign());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static ImageSignerSoap[] toSoapModels(ImageSigner[] models) {
        ImageSignerSoap[] soapModels = new ImageSignerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ImageSignerSoap[][] toSoapModels(ImageSigner[][] models) {
        ImageSignerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ImageSignerSoap[models.length][models[0].length];
        } else {
            soapModels = new ImageSignerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ImageSignerSoap[] toSoapModels(List<ImageSigner> models) {
        List<ImageSignerSoap> soapModels = new ArrayList<ImageSignerSoap>(models.size());

        for (ImageSigner model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ImageSignerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _imageSignerId;
    }

    public void setPrimaryKey(long pk) {
        setImageSignerId(pk);
    }

    public long getImageSignerId() {
        return _imageSignerId;
    }

    public void setImageSignerId(long imageSignerId) {
        _imageSignerId = imageSignerId;
    }

    public long getImageIdSign() {
        return _imageIdSign;
    }

    public void setImageIdSign(long imageIdSign) {
        _imageIdSign = imageIdSign;
    }

    public long getImageIdUnSign() {
        return _imageIdUnSign;
    }

    public void setImageIdUnSign(long imageIdUnSign) {
        _imageIdUnSign = imageIdUnSign;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
