package com.liferay.portlet.messageboards.model;


/**
 * <a href="MBMessageFlag.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBMessageFlag</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.liferay.portlet.messageboards.model.impl.MBMessageFlagImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBMessageFlagModel
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageFlagImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageFlagModelImpl
 *
 */
public interface MBMessageFlag extends MBMessageFlagModel {
    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);
}
