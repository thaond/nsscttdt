package com.sgs.portlet.pmllevelsend.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmLevelSendModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmLevelSend</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend
 * @see com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl
 * @see com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendModelImpl
 *
 */
public interface PmlEdmLevelSendModel extends BaseModel {
    public int getPrimaryKey();

    public void setPrimaryKey(int pk);

    public int getLevelSendId();

    public void setLevelSendId(int levelSendId);

    public String getLevelSendName();

    public void setLevelSendName(String levelSendName);

    public String getLevelSendCode();

    public void setLevelSendCode(String levelSendCode);

    public PmlEdmLevelSend toEscapedModel();
}
