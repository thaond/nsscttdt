package com.liferay.portlet.messageboards.model;


/**
 * <a href="MBCategory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBCategory</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.liferay.portlet.messageboards.model.impl.MBCategoryImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBCategoryModel
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl
 *
 */
public interface MBCategory extends MBCategoryModel {
    public java.util.List<Long> getAncestorCategoryIds()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getAncestors()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);

    public boolean isRoot();

    public boolean isDiscussion();
}
