package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmConfidentialLevelModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmConfidentialLevel</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelModelImpl
 *
 */
public interface PmlEdmConfidentialLevelModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getConfidentialLevelId();

    public void setConfidentialLevelId(String confidentialLevelId);

    public String getConfidentialLevelName();

    public void setConfidentialLevelName(String confidentialLevelName);

    public boolean getLimitViewDetail();

    public boolean isLimitViewDetail();

    public void setLimitViewDetail(boolean limitViewDetail);

    public boolean getHaveProcess();

    public boolean isHaveProcess();

    public void setHaveProcess(boolean haveProcess);

    public int getConfidentialLevelSymbol();

    public void setConfidentialLevelSymbol(int confidentialLevelSymbol);

    public PmlEdmConfidentialLevel toEscapedModel();
}
