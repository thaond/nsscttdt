package com.nss.portlet.van_ban_phap_quy.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="FileDinhKemModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>FileDinhKem</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.model.FileDinhKem
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemImpl
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemModelImpl
 *
 */
public interface FileDinhKemModel extends BaseModel<FileDinhKem> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaFileDinhKem();

    public void setMaFileDinhKem(long maFileDinhKem);

    public long getMaVanBanPhapQuy();

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy);

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

    public FileDinhKem toEscapedModel();
}
