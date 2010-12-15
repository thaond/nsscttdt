package com.nss.portlet.linh_vuc_thu_tuc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LinhVucThuTucHanhChinhModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LinhVucThuTucHanhChinh</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhImpl
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhModelImpl
 *
 */
public interface LinhVucThuTucHanhChinhModel extends BaseModel<LinhVucThuTucHanhChinh> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaLinhVucThuTucHanhChinh();

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh);

    public String getTenLinhVucThuTucHanhChinh();

    public void setTenLinhVucThuTucHanhChinh(String tenLinhVucThuTucHanhChinh);

    public long getMaLoaiThuTucHanhChinh();

    public void setMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh);

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

    public LinhVucThuTucHanhChinh toEscapedModel();
}
