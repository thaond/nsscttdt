package com.liferay.portlet.messageboards.model;


/**
 * <a href="MBBan.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBBan</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.liferay.portlet.messageboards.model.impl.MBBanImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBBanModel
 * @see com.liferay.portlet.messageboards.model.impl.MBBanImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBBanModelImpl
 *
 */
public interface MBBan extends MBBanModel {
    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);

    public java.lang.String getBanUserUuid()
        throws com.liferay.portal.SystemException;

    public void setBanUserUuid(java.lang.String banUserUuid);
}
