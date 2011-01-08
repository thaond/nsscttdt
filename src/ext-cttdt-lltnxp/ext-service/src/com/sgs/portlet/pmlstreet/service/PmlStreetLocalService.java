package com.sgs.portlet.pmlstreet.service;


/**
 * <a href="PmlStreetLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pmlstreet.service.impl.PmlStreetLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetLocalServiceUtil
 *
 */
public interface PmlStreetLocalService {
    public com.sgs.portlet.pmlstreet.model.PmlStreet addPmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet createPmlStreet(
        java.lang.String streetId);

    public void deletePmlStreet(java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet getPmlStreet(
        java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> getPmlStreets(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlStreetsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet updatePmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlstreet.model.PmlStreet addStreet(
        java.lang.String streetCode, java.lang.String streetName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException,
            com.sgs.portlet.pmlstreet.NoGenerateStreetIdException,
            java.rmi.RemoteException;
}
