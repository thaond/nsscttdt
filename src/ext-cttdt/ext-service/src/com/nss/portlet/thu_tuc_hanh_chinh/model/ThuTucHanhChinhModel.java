package com.nss.portlet.thu_tuc_hanh_chinh.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="ThuTucHanhChinhModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ThuTucHanhChinh</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhImpl
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhModelImpl
 *
 */
public interface ThuTucHanhChinhModel extends BaseModel<ThuTucHanhChinh> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaThuTucHanhChinh();

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh);

    public String getTenThuTucHanhChinh();

    public void setTenThuTucHanhChinh(String tenThuTucHanhChinh);

    public String getDiaChiLienHe();

    public void setDiaChiLienHe(String diaChiLienHe);

    public long getMaLinhVucThuTucHanhChinh();

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh);

    public long getMaDonViThuTucHanhChinh();

    public void setMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh);

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

    public ThuTucHanhChinh toEscapedModel();
}
