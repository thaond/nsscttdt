package com.sgs.portlet.pml_edm_docconfuser.service;


/**
 * <a href="PmlEdmDocConfUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService
 *
 */
public class PmlEdmDocConfUserLocalServiceUtil {
    private static PmlEdmDocConfUserLocalService _service;

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser addPmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocConfUser(pmlEdmDocConfUser);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser createPmlEdmDocConfUser(
        long dcuId) {
        return getService().createPmlEdmDocConfUser(dcuId);
    }

    public static void deletePmlEdmDocConfUser(long dcuId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocConfUser(dcuId);
    }

    public static void deletePmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocConfUser(pmlEdmDocConfUser);
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

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser getPmlEdmDocConfUser(
        long dcuId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocConfUser(dcuId);
    }

    public static java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> getPmlEdmDocConfUsers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocConfUsers(start, end);
    }

    public static int getPmlEdmDocConfUsersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocConfUsersCount();
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updatePmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocConfUser(pmlEdmDocConfUser);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getService().countAll();
    }

    public static java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findAll(start, end, obc);
    }

    public static java.util.List<com.liferay.portal.model.User> getUserByCompany(
        long companyId) throws com.liferay.portal.SystemException {
        return getService().getUserByCompany(companyId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser addPmlEdmDocConfUser(
        long userId, boolean viewAllDoc, java.lang.String viewDepDoc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().addPmlEdmDocConfUser(userId, viewAllDoc, viewDepDoc);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updatePmlEdmDocConfUser(
        long dcuId, long userId, boolean viewAllDoc, java.lang.String viewDepDoc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmDocConfUser(dcuId, userId, viewAllDoc,
            viewDepDoc);
    }

    public static java.util.ArrayList<String> getDepIdListForRecDocIdList(
        java.util.ArrayList<Long> recDocIdList)
        throws com.liferay.portal.SystemException {
        return getService().getDepIdListForRecDocIdList(recDocIdList);
    }

    public static java.util.ArrayList<String> getDepIdListForUserIdList(
        java.util.ArrayList<Long> userIdList)
        throws com.liferay.portal.SystemException {
        return getService().getDepIdListForUserIdList(userIdList);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getService().findByUserId(userId);
    }

    public static java.util.ArrayList<String> getDepIdListForSenDocIdList(
        java.util.ArrayList<Long> senDocIdList)
        throws com.liferay.portal.SystemException {
        return getService().getDepIdListForSenDocIdList(senDocIdList);
    }

    public static PmlEdmDocConfUserLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocConfUserLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocConfUserLocalService service) {
        _service = service;
    }
}
