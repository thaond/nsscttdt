package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlScreenCalendarHeightModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlScreenCalendarHeight</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight
 * @see com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightModelImpl
 *
 */
public interface PmlScreenCalendarHeightModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getScreenCalendarHeightId();

    public void setScreenCalendarHeightId(long screenCalendarHeightId);

    public PmlScreenCalendarHeight toEscapedModel();
}
