package com.nss.portlet.adv.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="QuangCaoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>QuangCao</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.model.QuangCao
 * @see com.nss.portlet.adv.model.impl.QuangCaoImpl
 * @see com.nss.portlet.adv.model.impl.QuangCaoModelImpl
 *
 */
public interface QuangCaoModel extends BaseModel<QuangCao> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaQuangCao();

    public void setMaQuangCao(long maQuangCao);

    public String getTenQuangCao();

    public void setTenQuangCao(String tenQuangCao);

    public String getUrlWebsite();

    public void setUrlWebsite(String urlWebsite);

    public String getMoTaQuangCao();

    public void setMoTaQuangCao(String moTaQuangCao);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getThuTuQuangCao();

    public void setThuTuQuangCao(int thuTuQuangCao);

    public String getTarget();

    public void setTarget(String target);

    public long getImageId_liferay();

    public void setImageId_liferay(long imageId_liferay);

    public int getActive();

    public void setActive(int active);

    public QuangCao toEscapedModel();
}
