package com.nss.portlet.image_signer.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="ImageSignerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ImageSigner</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.image_signer.model.ImageSigner
 * @see com.nss.portlet.image_signer.model.impl.ImageSignerImpl
 * @see com.nss.portlet.image_signer.model.impl.ImageSignerModelImpl
 *
 */
public interface ImageSignerModel extends BaseModel<ImageSigner> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getImageSignerId();

    public void setImageSignerId(long imageSignerId);

    public long getImageIdSign();

    public void setImageIdSign(long imageIdSign);

    public long getImageIdUnSign();

    public void setImageIdUnSign(long imageIdUnSign);

    public long getUserId();

    public void setUserId(long userId);

    public ImageSigner toEscapedModel();
}
