package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="CarResourceModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>CarResource</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.CarResource
 * @see com.ext.portlet.meetingcalendar.model.impl.CarResourceImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.CarResourceModelImpl
 *
 */
public interface CarResourceModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getCarId();

    public void setCarId(long carId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public String getCarName();

    public void setCarName(String carName);

    public String getCarCode();

    public void setCarCode(String carCode);

    public String getDescription();

    public void setDescription(String description);

    public CarResource toEscapedModel();
}
