package com.sgs.portlet.pml_ho_so_cong_viec.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlChiTietHSCVModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlChiTietHSCV</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVModelImpl
 *
 */
public interface PmlChiTietHSCVModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getIdChiTietHSCV();

    public void setIdChiTietHSCV(long idChiTietHSCV);

    public long getIdHoSoCongViec();

    public void setIdHoSoCongViec(long idHoSoCongViec);

    public long getIdCongVanDen();

    public void setIdCongVanDen(long idCongVanDen);

    public long getIdCongVanDi();

    public void setIdCongVanDi(long idCongVanDi);

    public String getDiDen();

    public void setDiDen(String diDen);

    public PmlChiTietHSCV toEscapedModel();
}
