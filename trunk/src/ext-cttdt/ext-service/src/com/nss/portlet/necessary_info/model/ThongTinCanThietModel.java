package com.nss.portlet.necessary_info.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="ThongTinCanThietModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ThongTinCanThiet</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.model.ThongTinCanThiet
 * @see com.nss.portlet.necessary_info.model.impl.ThongTinCanThietImpl
 * @see com.nss.portlet.necessary_info.model.impl.ThongTinCanThietModelImpl
 *
 */
public interface ThongTinCanThietModel extends BaseModel<ThongTinCanThiet> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaThongTinCanThiet();

    public void setMaThongTinCanThiet(long maThongTinCanThiet);

    public String getTenThongTinCanThiet();

    public void setTenThongTinCanThiet(String tenThongTinCanThiet);

    public String getUrlWebsite();

    public void setUrlWebsite(String urlWebsite);

    public String getMoTaThongTinCanThiet();

    public void setMoTaThongTinCanThiet(String moTaThongTinCanThiet);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getThuTuThongTin();

    public void setThuTuThongTin(int thuTuThongTin);

    public String getTarget();

    public void setTarget(String target);

    public long getImageId_liferay();

    public void setImageId_liferay(long imageId_liferay);

    public int getActive();

    public void setActive(int active);

    public ThongTinCanThiet toEscapedModel();
}
