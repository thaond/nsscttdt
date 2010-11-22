package com.nss.portlet.image_signer.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
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
            

            { "imagePath", new Integer(Types.VARCHAR) },
            

            { "imageExtend", new Integer(Types.VARCHAR) },
            

            { "imageSize", new Integer(Types.DOUBLE) },
            

            { "userId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_image_signer (imageSignerId LONG not null primary key,imagePath VARCHAR(75) null,imageExtend VARCHAR(75) null,imageSize DOUBLE,userId LONG)";
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
    private String _imagePath;
    private String _imageExtend;
    private double _imageSize;
    private long _userId;
    private transient ExpandoBridge _expandoBridge;

    public ImageSignerModelImpl() {
    }

    public static ImageSigner toModel(ImageSignerSoap soapModel) {
        ImageSigner model = new ImageSignerImpl();

        model.setImageSignerId(soapModel.getImageSignerId());
        model.setImagePath(soapModel.getImagePath());
        model.setImageExtend(soapModel.getImageExtend());
        model.setImageSize(soapModel.getImageSize());
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

    public String getImagePath() {
        return GetterUtil.getString(_imagePath);
    }

    public void setImagePath(String imagePath) {
        _imagePath = imagePath;
    }

    public String getImageExtend() {
        return GetterUtil.getString(_imageExtend);
    }

    public void setImageExtend(String imageExtend) {
        _imageExtend = imageExtend;
    }

    public double getImageSize() {
        return _imageSize;
    }

    public void setImageSize(double imageSize) {
        _imageSize = imageSize;
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
            model.setImagePath(HtmlUtil.escape(getImagePath()));
            model.setImageExtend(HtmlUtil.escape(getImageExtend()));
            model.setImageSize(getImageSize());
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
        clone.setImagePath(getImagePath());
        clone.setImageExtend(getImageExtend());
        clone.setImageSize(getImageSize());
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
        sb.append(", imagePath=");
        sb.append(getImagePath());
        sb.append(", imageExtend=");
        sb.append(getImageExtend());
        sb.append(", imageSize=");
        sb.append(getImageSize());
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
            "<column><column-name>imagePath</column-name><column-value><![CDATA[");
        sb.append(getImagePath());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageExtend</column-name><column-value><![CDATA[");
        sb.append(getImageExtend());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageSize</column-name><column-value><![CDATA[");
        sb.append(getImageSize());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
