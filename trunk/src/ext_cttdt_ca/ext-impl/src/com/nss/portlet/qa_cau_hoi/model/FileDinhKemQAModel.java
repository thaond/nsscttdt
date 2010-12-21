package com.nss.portlet.qa_cau_hoi.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="FileDinhKemQAModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>FileDinhKemQA</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA
 * @see com.nss.portlet.qa_cau_hoi.model.impl.FileDinhKemQAImpl
 * @see com.nss.portlet.qa_cau_hoi.model.impl.FileDinhKemQAModelImpl
 *
 */
public interface FileDinhKemQAModel extends BaseModel<FileDinhKemQA> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaFileDinhKemQA();

    public void setMaFileDinhKemQA(long maFileDinhKemQA);

    public long getMaCauHoi();

    public void setMaCauHoi(long maCauHoi);

    public long getMaCauTraLoi();

    public void setMaCauTraLoi(long maCauTraLoi);

    public String getTenFile();

    public void setTenFile(String tenFile);

    public long getKichThuoc();

    public void setKichThuoc(long kichThuoc);

    public String getDuongDan();

    public void setDuongDan(String duongDan);

    public FileDinhKemQA toEscapedModel();
}
