package com.sgs.portlet.pml_do_quan_trong.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlDoQuanTrongModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDoQuanTrong</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong
 * @see com.sgs.portlet.pml_do_quan_trong.model.impl.PmlDoQuanTrongImpl
 * @see com.sgs.portlet.pml_do_quan_trong.model.impl.PmlDoQuanTrongModelImpl
 *
 */
public interface PmlDoQuanTrongModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getIdDoQuanTrong();

    public void setIdDoQuanTrong(long idDoQuanTrong);

    public String getTenDoQuanTrong();

    public void setTenDoQuanTrong(String tenDoQuanTrong);

    public PmlDoQuanTrong toEscapedModel();
}
