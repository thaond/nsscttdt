package com.nss.portlet.qa_chu_de.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="QAChuDeCauHoiModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>QAChuDeCauHoi</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi
 * @see com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiImpl
 * @see com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiModelImpl
 *
 */
public interface QAChuDeCauHoiModel extends BaseModel<QAChuDeCauHoi> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaChuDeCauHoi();

    public void setMaChuDeCauHoi(long maChuDeCauHoi);

    public String getTenChuDeCauHoi();

    public void setTenChuDeCauHoi(String tenChuDeCauHoi);

    public int getActive();

    public void setActive(int active);

    public QAChuDeCauHoi toEscapedModel();
}
