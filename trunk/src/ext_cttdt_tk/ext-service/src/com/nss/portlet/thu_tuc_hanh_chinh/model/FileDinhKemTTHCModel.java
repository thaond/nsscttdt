package com.nss.portlet.thu_tuc_hanh_chinh.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="FileDinhKemTTHCModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>FileDinhKemTTHC</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCImpl
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCModelImpl
 *
 */
public interface FileDinhKemTTHCModel extends BaseModel<FileDinhKemTTHC> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaFileDinhKemTTHC();

    public void setMaFileDinhKemTTHC(long maFileDinhKemTTHC);

    public long getMaThuTucHanhChinh();

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh);

    public String getTenFile();

    public void setTenFile(String tenFile);

    public String getMoTa();

    public void setMoTa(String moTa);

    public long getKichThuoc();

    public void setKichThuoc(long kichThuoc);

    public String getDuongDan();

    public void setDuongDan(String duongDan);

    public int getPhienBan();

    public void setPhienBan(int phienBan);

    public FileDinhKemTTHC toEscapedModel();
}
