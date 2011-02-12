package com.sgs.portlet.vanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="FileDinhKemVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>FileDinhKemVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoImpl
 * @see com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoModelImpl
 *
 */
public interface FileDinhKemVanBanNoiBoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getFileDinhKemVanBanNoiBoId();

    public void setFileDinhKemVanBanNoiBoId(long fileDinhKemVanBanNoiBoId);

    public String getTenFileFull();

    public void setTenFileFull(String tenFileFull);

    public String getTenFile();

    public void setTenFile(String tenFile);

    public String getDuongDanFile();

    public void setDuongDanFile(String duongDanFile);

    public String getTieuDe();

    public void setTieuDe(String tieuDe);

    public Date getNgayTao();

    public void setNgayTao(Date ngayTao);

    public String getLoaiFile();

    public void setLoaiFile(String loaiFile);

    public String getMucDichFile();

    public void setMucDichFile(String mucDichFile);

    public long getVanBanNoiBoId();

    public void setVanBanNoiBoId(long vanBanNoiBoId);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public FileDinhKemVanBanNoiBo toEscapedModel();
}
