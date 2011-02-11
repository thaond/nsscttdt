package com.sgs.portlet.pml_do_quan_trong.service;


/**
 * <a href="PmlDoQuanTrongLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_do_quan_trong.service.impl.PmlDoQuanTrongLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil
 *
 */
public interface PmlDoQuanTrongLocalService {
    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong createPmlDoQuanTrong(
        long idDoQuanTrong);

    public void deletePmlDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong getPmlDoQuanTrong(
        long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> getPmlDoQuanTrongs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDoQuanTrongsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong addPmlDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updatePmlDoQuanTrong(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removePmlDoQuanTrong(java.lang.String idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
