package com.nss.portlet.link.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LoaiWebsiteModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LoaiWebsite</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.model.LoaiWebsite
 * @see com.nss.portlet.link.model.impl.LoaiWebsiteImpl
 * @see com.nss.portlet.link.model.impl.LoaiWebsiteModelImpl
 *
 */
public interface LoaiWebsiteModel extends BaseModel<LoaiWebsite> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaLoaiWebsite();

    public void setMaLoaiWebsite(long maLoaiWebsite);

    public String getTenLoaiWebsite();

    public void setTenLoaiWebsite(String tenLoaiWebsite);

    public String getMoTaLoaiWebsite();

    public void setMoTaLoaiWebsite(String moTaLoaiWebsite);

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

    public LoaiWebsite toEscapedModel();
}
