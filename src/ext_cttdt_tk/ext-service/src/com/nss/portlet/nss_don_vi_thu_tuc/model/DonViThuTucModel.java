package com.nss.portlet.nss_don_vi_thu_tuc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="DonViThuTucModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>DonViThuTuc</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucImpl
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucModelImpl
 *
 */
public interface DonViThuTucModel extends BaseModel<DonViThuTuc> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaDonViThuTuc();

    public void setMaDonViThuTuc(long maDonViThuTuc);

    public String getTenDonViThuTuc();

    public void setTenDonViThuTuc(String tenDonViThuTuc);

    public int getCapDonVi();

    public void setCapDonVi(int capDonVi);

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

    public DonViThuTuc toEscapedModel();
}
