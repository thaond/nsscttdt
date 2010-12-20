package com.nss.portlet.loai_thu_tuc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LoaiThuTucHanhChinhModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LoaiThuTucHanhChinh</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh
 * @see com.nss.portlet.loai_thu_tuc.model.impl.LoaiThuTucHanhChinhImpl
 * @see com.nss.portlet.loai_thu_tuc.model.impl.LoaiThuTucHanhChinhModelImpl
 *
 */
public interface LoaiThuTucHanhChinhModel extends BaseModel<LoaiThuTucHanhChinh> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaLoaiThuTucHanhChinh();

    public void setMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh);

    public String getTenLoaiThuTucHanhChinh();

    public void setTenLoaiThuTucHanhChinh(String tenLoaiThuTucHanhChinh);

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

    public LoaiThuTucHanhChinh toEscapedModel();
}
