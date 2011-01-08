package com.sgs.portlet.pml_trang_thai_hscv.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlTrangThaiHSCVModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTrangThaiHSCV</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.impl.PmlTrangThaiHSCVImpl
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.impl.PmlTrangThaiHSCVModelImpl
 *
 */
public interface PmlTrangThaiHSCVModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getIdTrangThaiHSCV();

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV);

    public String getTenTrangThaiHSCV();

    public void setTenTrangThaiHSCV(String tenTrangThaiHSCV);

    public PmlTrangThaiHSCV toEscapedModel();
}
