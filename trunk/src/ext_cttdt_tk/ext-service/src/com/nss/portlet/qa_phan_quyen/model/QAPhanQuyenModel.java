package com.nss.portlet.qa_phan_quyen.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="QAPhanQuyenModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>QAPhanQuyen</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen
 * @see com.nss.portlet.qa_phan_quyen.model.impl.QAPhanQuyenImpl
 * @see com.nss.portlet.qa_phan_quyen.model.impl.QAPhanQuyenModelImpl
 *
 */
public interface QAPhanQuyenModel extends BaseModel<QAPhanQuyen> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaPhanQuyen();

    public void setMaPhanQuyen(long maPhanQuyen);

    public long getMaChuDeCauHoi();

    public void setMaChuDeCauHoi(long maChuDeCauHoi);

    public long getMaNguoiTraLoi();

    public void setMaNguoiTraLoi(long maNguoiTraLoi);

    public boolean getQuyenXem();

    public boolean isQuyenXem();

    public void setQuyenXem(boolean quyenXem);

    public boolean getQuyenCapNhat();

    public boolean isQuyenCapNhat();

    public void setQuyenCapNhat(boolean quyenCapNhat);

    public boolean getQuyenTraLoi();

    public boolean isQuyenTraLoi();

    public void setQuyenTraLoi(boolean quyenTraLoi);

    public boolean getQuyenDuyet();

    public boolean isQuyenDuyet();

    public void setQuyenDuyet(boolean quyenDuyet);

    public QAPhanQuyen toEscapedModel();
}
