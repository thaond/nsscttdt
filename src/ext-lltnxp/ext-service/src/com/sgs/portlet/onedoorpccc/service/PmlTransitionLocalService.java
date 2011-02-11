package com.sgs.portlet.onedoorpccc.service;


/**
 * <a href="PmlTransitionLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoorpccc.service.impl.PmlTransitionLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalServiceUtil
 *
 */
public interface PmlTransitionLocalService {
    public com.sgs.portlet.onedoorpccc.model.PmlTransition addPmlTransition(
        com.sgs.portlet.onedoorpccc.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTransition createPmlTransition(
        long transitionId);

    public void deletePmlTransition(long transitionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlTransition(
        com.sgs.portlet.onedoorpccc.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTransition getPmlTransition(
        long transitionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTransition> getPmlTransitions(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlTransitionsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTransition updatePmlTransition(
        com.sgs.portlet.onedoorpccc.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException;
}
