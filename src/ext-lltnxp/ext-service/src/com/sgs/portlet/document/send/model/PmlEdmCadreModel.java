package com.sgs.portlet.document.send.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmCadreModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmCadre</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmCadre
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmCadreImpl
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmCadreModelImpl
 *
 */
public interface PmlEdmCadreModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getUserId();

    public void setUserId(long userId);

    public String getPositionId();

    public void setPositionId(String positionId);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public String getHandPhone();

    public void setHandPhone(String handPhone);

    public String getNote();

    public void setNote(String note);

    public String getActive();

    public void setActive(String active);

    public PmlEdmCadre toEscapedModel();
}
