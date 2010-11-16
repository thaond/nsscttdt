package com.nss.portlet.link.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LienKetWebsiteModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LienKetWebsite</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.model.LienKetWebsite
 * @see com.nss.portlet.link.model.impl.LienKetWebsiteImpl
 * @see com.nss.portlet.link.model.impl.LienKetWebsiteModelImpl
 *
 */
public interface LienKetWebsiteModel extends BaseModel<LienKetWebsite> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaWebsite();

    public void setMaWebsite(long maWebsite);

    public String getTenWebsite();

    public void setTenWebsite(String tenWebsite);

    public String getUrlWebsite();

    public void setUrlWebsite(String urlWebsite);

    public String getMoTaWebsite();

    public void setMoTaWebsite(String moTaWebsite);

    public long getLoaiWebsite();

    public void setLoaiWebsite(long loaiWebsite);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getThuTuWebsite();

    public void setThuTuWebsite(int thuTuWebsite);

    public String getTarget();

    public void setTarget(String target);

    public long getImageId_liferay();

    public void setImageId_liferay(long imageId_liferay);

    public int getActive();

    public void setActive(int active);

    public LienKetWebsite toEscapedModel();
}
