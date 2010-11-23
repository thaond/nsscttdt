package com.nss.portlet.thong_tin_lien_quan.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="ThongTinLienQuanModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ThongTinLienQuan</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan
 * @see com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanImpl
 * @see com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanModelImpl
 *
 */
public interface ThongTinLienQuanModel extends BaseModel<ThongTinLienQuan> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaThongTinLienQuan();

    public void setMaThongTinLienQuan(long maThongTinLienQuan);

    public String getTenThongTinLienQuan();

    public void setTenThongTinLienQuan(String tenThongTinLienQuan);

    public String getUrlWebsite();

    public void setUrlWebsite(String urlWebsite);

    public String getMoTaThongTinLienQuan();

    public void setMoTaThongTinLienQuan(String moTaThongTinLienQuan);

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

    public ThongTinLienQuan toEscapedModel();
}
