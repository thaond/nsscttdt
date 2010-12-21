package com.nss.portlet.media_chu_de.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="MediaChuDeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MediaChuDe</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_chu_de.model.MediaChuDe
 * @see com.nss.portlet.media_chu_de.model.impl.MediaChuDeImpl
 * @see com.nss.portlet.media_chu_de.model.impl.MediaChuDeModelImpl
 *
 */
public interface MediaChuDeModel extends BaseModel<MediaChuDe> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaMediaChuDe();

    public void setMaMediaChuDe(long maMediaChuDe);

    public String getTenMediaChuDe();

    public void setTenMediaChuDe(String tenMediaChuDe);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public MediaChuDe toEscapedModel();
}
