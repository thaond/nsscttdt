package com.nss.portlet.co_quan_ban_hanh.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="CoQuanBanHanhModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>CoQuanBanHanh</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh
 * @see com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhImpl
 * @see com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhModelImpl
 *
 */
public interface CoQuanBanHanhModel extends BaseModel<CoQuanBanHanh> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaCoQuanBanHanh();

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh);

    public String getTenCoQuanBanHanh();

    public void setTenCoQuanBanHanh(String tenCoQuanBanHanh);

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

    public CoQuanBanHanh toEscapedModel();
}
