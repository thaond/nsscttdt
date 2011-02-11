package com.sgs.portlet.pml_edm_docconfuser.service;


/**
 * <a href="PmlEdmDocConfUserLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.impl.PmlEdmDocConfUserLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil
 *
 */
public interface PmlEdmDocConfUserLocalService {
    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser addPmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser createPmlEdmDocConfUser(
        long dcuId);

    public void deletePmlEdmDocConfUser(long dcuId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser getPmlEdmDocConfUser(
        long dcuId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> getPmlEdmDocConfUsers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocConfUsersCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updatePmlEdmDocConfUser(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> getUserByCompany(
        long companyId) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser addPmlEdmDocConfUser(
        long userId, boolean viewAllDoc, java.lang.String viewDepDoc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updatePmlEdmDocConfUser(
        long dcuId, long userId, boolean viewAllDoc, java.lang.String viewDepDoc)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.ArrayList<String> getDepIdListForRecDocIdList(
        java.util.ArrayList<Long> recDocIdList)
        throws com.liferay.portal.SystemException;

    public java.util.ArrayList<String> getDepIdListForUserIdList(
        java.util.ArrayList<Long> userIdList)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.ArrayList<String> getDepIdListForSenDocIdList(
        java.util.ArrayList<Long> senDocIdList)
        throws com.liferay.portal.SystemException;
}
