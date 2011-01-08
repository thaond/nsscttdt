package com.sgs.portlet.career.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="CareerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Career</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.model.Career
 * @see com.sgs.portlet.career.model.impl.CareerImpl
 * @see com.sgs.portlet.career.model.impl.CareerModelImpl
 *
 */
public interface CareerModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getCareerId();

    public void setCareerId(String careerId);

    public String getCareerCode();

    public void setCareerCode(String careerCode);

    public String getCareerName();

    public void setCareerName(String careerName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Career toEscapedModel();
}
