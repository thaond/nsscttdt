package com.sgs.portlet.recievergroup.service;


/**
 * <a href="RecieverGroupLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.recievergroup.service.impl.RecieverGroupLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupLocalServiceUtil
 *
 */
public interface RecieverGroupLocalService {
    public com.sgs.portlet.recievergroup.model.RecieverGroup addRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup createRecieverGroup(
        long recieverGroupId);

    public void deleteRecieverGroup(long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup getRecieverGroup(
        long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getRecieverGroupsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    public void addReciever(long recieverGroupPK, long recieverPK)
        throws com.liferay.portal.SystemException;

    public void removeReciever(long recieverGroupPK, long recieverPK)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup updateRecieverGroup(
        long userId, long recieverGroupId, java.lang.String recieverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
