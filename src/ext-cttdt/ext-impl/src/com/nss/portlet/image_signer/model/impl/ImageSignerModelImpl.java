package com.nss.portlet.image_signer.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.image_signer.model.ImageSigner;
import com.nss.portlet.image_signer.model.ImageSignerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ImageSignerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ImageSigner</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.image_signer.model.ImageSigner
 * @see com.nss.portlet.image_signer.model.ImageSignerModel
 * @see com.nss.portlet.image_signer.model.impl.ImageSignerImpl
 *
 */
public class ImageSignerModelImpl extends BaseModelImpl<ImageSigner> {
    public static final String TABLE_NAME = "nss_image_signer";
    public static final Object[][] TABLE_COLUMNS = {
            { "imageSignerId", new Integer(Types.BIGINT) },
            

            { "imageIdSign", new Integer(Types.BIGINT) },
            

            { "imageIdUnSign", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_image_signer (imageSignerId LONG not null primary key,imageIdSign LONG,imageIdUnSign LONG,userId LONG)";
    public static final String TABLE_SQL_DROP = "drop table nss_image_signer";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.image_signer.model.ImageSigner"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.image_signer.model.ImageSigner"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.image_signer.model.ImageSigner"));
    private long _imageSignerId;
    private long _imageIdSign;
    private long _imageIdUnSign;
    private long _userId;
    private transient ExpandoBridge _expandoBridge;

    public ImageSignerModelImpl() {
    }

    public static ImageSigner toModel(ImageSignerSoap soapModel) {
        ImageSigner model = new ImageSignerImpl();

        model.setImageSignerId(soapModel.getImageSignerId());
        model.setImageIdSign(soapModel.getImageIdSign());
        model.setImageIdUnSign(soapModel.getImageIdUnSign());
        model.setUserId(soapModel.getUserId());

        return model;
    }

    public static List<ImageSigner> toModels(ImageSignerSoap[] soapModels) {
        List<ImageSigner> models = new ArrayList<ImageSigner>(soapModels.length);

        for (ImageSignerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _imageSignerId;
    }

    public void setPrimaryKey(long pk) {
        setImageSignerId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_imageSignerId);
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

    public ImageSigner toEscapedModel() {
        if (isEscapedModel()) {
            return (ImageSigner) this;
        } else {
            ImageSigner model = new ImageSignerImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setImageSignerId(getImageSignerId());
            model.setImageIdSign(getImageIdSign());
            model.setImageIdUnSign(getImageIdUnSign());
            model.setUserId(getUserId());

            model = (ImageSigner) Proxy.newProxyInstance(ImageSigner.class.getClassLoader(),
                    new Class[] { ImageSigner.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ImageSigner.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ImageSignerImpl clone = new ImageSignerImpl();

        clone.setImageSignerId(getImageSignerId());
        clone.setImageIdSign(getImageIdSign());
        clone.setImageIdUnSign(getImageIdUnSign());
        clone.setUserId(getUserId());

        return clone;
    }

    public int compareTo(ImageSigner imageSigner) {
        long pk = imageSigner.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ImageSigner imageSigner = null;

        try {
            imageSigner = (ImageSigner) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = imageSigner.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{imageSignerId=");
        sb.append(getImageSignerId());
        sb.append(", imageIdSign=");
        sb.append(getImageIdSign());
        sb.append(", imageIdUnSign=");
        sb.append(getImageIdUnSign());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.image_signer.model.ImageSigner");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>imageSignerId</column-name><column-value><![CDATA[");
        sb.append(getImageSignerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageIdSign</column-name><column-value><![CDATA[");
        sb.append(getImageIdSign());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageIdUnSign</column-name><column-value><![CDATA[");
        sb.append(getImageIdUnSign());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
