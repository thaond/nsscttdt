package com.sgs.portlet.pmlstreet.service;


/**
 * <a href="PmlStreetLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pmlstreet.service.PmlStreetLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetLocalService
 *
 */
public class PmlStreetLocalServiceUtil {
    private static PmlStreetLocalService _service;

    public static com.sgs.portlet.pmlstreet.model.PmlStreet addPmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStreet(pmlStreet);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet createPmlStreet(
        java.lang.String streetId) {
        return getService().createPmlStreet(streetId);
    }

    public static void deletePmlStreet(java.lang.String streetId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStreet(streetId);
    }

    public static void deletePmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException {
        getService().deletePmlStreet(pmlStreet);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet getPmlStreet(
        java.lang.String streetId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStreet(streetId);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> getPmlStreets(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStreets(start, end);
    }

    public static int getPmlStreetsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStreetsCount();
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet updatePmlStreet(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStreet(pmlStreet);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet addStreet(
        java.lang.String streetCode, java.lang.String streetName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException,
            com.sgs.portlet.pmlstreet.NoGenerateStreetIdException,
            java.rmi.RemoteException {
        return getService().addStreet(streetCode, streetName);
    }

    public static PmlStreetLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlStreetLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlStreetLocalService service) {
        _service = service;
    }
}
