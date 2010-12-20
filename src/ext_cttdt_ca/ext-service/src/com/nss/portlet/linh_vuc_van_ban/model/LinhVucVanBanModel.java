package com.nss.portlet.linh_vuc_van_ban.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LinhVucVanBanModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LinhVucVanBan</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan
 * @see com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanImpl
 * @see com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanModelImpl
 *
 */
public interface LinhVucVanBanModel extends BaseModel<LinhVucVanBan> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaLinhVucVanBan();

    public void setMaLinhVucVanBan(long maLinhVucVanBan);

    public String getTenLinhVucVanBan();

    public void setTenLinhVucVanBan(String tenLinhVucVanBan);

    public long getParentid();

    public void setParentid(long parentid);

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

    public LinhVucVanBan toEscapedModel();
}
