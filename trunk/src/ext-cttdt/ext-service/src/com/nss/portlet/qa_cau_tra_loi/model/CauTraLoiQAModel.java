package com.nss.portlet.qa_cau_tra_loi.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="CauTraLoiQAModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>CauTraLoiQA</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA
 * @see com.nss.portlet.qa_cau_tra_loi.model.impl.CauTraLoiQAImpl
 * @see com.nss.portlet.qa_cau_tra_loi.model.impl.CauTraLoiQAModelImpl
 *
 */
public interface CauTraLoiQAModel extends BaseModel<CauTraLoiQA> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaCauTraLoiQA();

    public void setMaCauTraLoiQA(long maCauTraLoiQA);

    public long getMaCauHoiQA();

    public void setMaCauHoiQA(long maCauHoiQA);

    public long getMaNguoiTraLoi();

    public void setMaNguoiTraLoi(long maNguoiTraLoi);

    public String getNoiDungTraLoi();

    public void setNoiDungTraLoi(String noiDungTraLoi);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getPublishdate();

    public void setPublishdate(Date publishdate);

    public boolean getPublish();

    public boolean isPublish();

    public void setPublish(boolean publish);

    public boolean getAnswerThroughWeb();

    public boolean isAnswerThroughWeb();

    public void setAnswerThroughWeb(boolean answerThroughWeb);

    public String getAnswerThroughEmail();

    public void setAnswerThroughEmail(String answerThroughEmail);

    public CauTraLoiQA toEscapedModel();
}
