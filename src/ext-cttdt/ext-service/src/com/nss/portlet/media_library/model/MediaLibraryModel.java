package com.nss.portlet.media_library.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MediaLibraryModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MediaLibrary</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_library.model.MediaLibrary
 * @see com.nss.portlet.media_library.model.impl.MediaLibraryImpl
 * @see com.nss.portlet.media_library.model.impl.MediaLibraryModelImpl
 *
 */
public interface MediaLibraryModel extends BaseModel<MediaLibrary> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaMediaLibrary();

    public void setMaMediaLibrary(long maMediaLibrary);

    public long getMaMediaChuDe();

    public void setMaMediaChuDe(long maMediaChuDe);

    public String getTieuDeMediaLibrary();

    public void setTieuDeMediaLibrary(String tieuDeMediaLibrary);

    public String getTenMediaLibrary();

    public void setTenMediaLibrary(String tenMediaLibrary);

    public long getKichThuoc();

    public void setKichThuoc(long kichThuoc);

    public String getDuongDan();

    public void setDuongDan(String duongDan);

    public long getUserId();

    public void setUserId(long userId);

    public long getLuotXem();

    public void setLuotXem(long luotXem);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public MediaLibrary toEscapedModel();
}
