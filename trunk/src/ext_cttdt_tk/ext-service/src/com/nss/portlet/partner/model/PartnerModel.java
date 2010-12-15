package com.nss.portlet.partner.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PartnerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Partner</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.model.Partner
 * @see com.nss.portlet.partner.model.impl.PartnerImpl
 * @see com.nss.portlet.partner.model.impl.PartnerModelImpl
 *
 */
public interface PartnerModel extends BaseModel<Partner> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaPartner();

    public void setMaPartner(long maPartner);

    public String getTenPartner();

    public void setTenPartner(String tenPartner);

    public String getUrlPartner();

    public void setUrlPartner(String urlPartner);

    public String getMoTaPartner();

    public void setMoTaPartner(String moTaPartner);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getThuTuPartner();

    public void setThuTuPartner(int thuTuPartner);

    public String getTarget();

    public void setTarget(String target);

    public int getActive();

    public void setActive(int active);

    public long getImageId_liferay();

    public void setImageId_liferay(long imageId_liferay);

    public Partner toEscapedModel();
}
