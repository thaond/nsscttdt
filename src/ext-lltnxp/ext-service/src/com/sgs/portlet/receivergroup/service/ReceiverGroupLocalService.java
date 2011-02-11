package com.sgs.portlet.receivergroup.service;


/**
 * <a href="ReceiverGroupLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.receivergroup.service.impl.ReceiverGroupLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupLocalServiceUtil
 *
 */
public interface ReceiverGroupLocalService {
    public com.sgs.portlet.receivergroup.model.ReceiverGroup addReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup createReceiverGroup(
        long receiverGroupId);

    public void deleteReceiverGroup(long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup getReceiverGroup(
        long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getReceiverGroupsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    public void addReceiver(long receiverGroupPK, long receiverPK)
        throws com.liferay.portal.SystemException;

    public void removeReceiver(long receiverGroupPK, long receiverPK)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        long userId, long receiverGroupId, java.lang.String receiverGroupName,
        java.lang.String description, int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
