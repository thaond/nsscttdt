package com.nss.portlet.qa_cau_hoi.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="CauHoiQAModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>CauHoiQA</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.model.CauHoiQA
 * @see com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAImpl
 * @see com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAModelImpl
 *
 */
public interface CauHoiQAModel extends BaseModel<CauHoiQA> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaCauHoiQA();

    public void setMaCauHoiQA(long maCauHoiQA);

    public long getMaChuDeCauHoi();

    public void setMaChuDeCauHoi(long maChuDeCauHoi);

    public String getTieuDe();

    public void setTieuDe(String tieuDe);

    public String getTenNguoiHoi();

    public void setTenNguoiHoi(String tenNguoiHoi);

    public String getEmail();

    public void setEmail(String email);

    public String getNoiDungHoi();

    public void setNoiDungHoi(String noiDungHoi);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getPublishdate();

    public void setPublishdate(Date publishdate);

    public boolean getPublish();

    public boolean isPublish();

    public void setPublish(boolean publish);

    public CauHoiQA toEscapedModel();
}
