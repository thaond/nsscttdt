package com.nss.portlet.contact.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="HoTroTrucTuyenModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>HoTroTrucTuyen</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.contact.model.HoTroTrucTuyen
 * @see com.nss.portlet.contact.model.impl.HoTroTrucTuyenImpl
 * @see com.nss.portlet.contact.model.impl.HoTroTrucTuyenModelImpl
 *
 */
public interface HoTroTrucTuyenModel extends BaseModel<HoTroTrucTuyen> {
    public int getPrimaryKey();

    public void setPrimaryKey(int pk);

    public int getMaHoTroTrucTuyen();

    public void setMaHoTroTrucTuyen(int maHoTroTrucTuyen);

    public String getTen();

    public void setTen(String ten);

    public String getLink();

    public void setLink(String link);

    public String getImageUrl();

    public void setImageUrl(String imageUrl);

    public int getOrder();

    public void setOrder(int order);

    public int getActive();

    public void setActive(int active);

    public String getDescription();

    public void setDescription(String description);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public HoTroTrucTuyen toEscapedModel();
}
