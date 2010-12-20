package com.nss.portlet.loai_van_ban.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LoaiVanBanModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LoaiVanBan</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_van_ban.model.LoaiVanBan
 * @see com.nss.portlet.loai_van_ban.model.impl.LoaiVanBanImpl
 * @see com.nss.portlet.loai_van_ban.model.impl.LoaiVanBanModelImpl
 *
 */
public interface LoaiVanBanModel extends BaseModel<LoaiVanBan> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaLoaiVanBan();

    public void setMaLoaiVanBan(long maLoaiVanBan);

    public String getTenLoaiVanBan();

    public void setTenLoaiVanBan(String tenLoaiVanBan);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getActive();

    public void setActive(int active);

    public String getDescription();

    public void setDescription(String description);

    public LoaiVanBan toEscapedModel();
}
