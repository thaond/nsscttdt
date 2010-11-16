package com.nss.portlet.qa_chu_de.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="QAChuDeCauHoiLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.qa_chu_de.service.impl.QAChuDeCauHoiLocalServiceImpl</code>.
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
 * @see com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface QAChuDeCauHoiLocalService {
    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi addQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi createQAChuDeCauHoi(
        long maChuDeCauHoi);

    public void deleteQAChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi getQAChuDeCauHoi(
        long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> getQAChuDeCauHois(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getQAChuDeCauHoisCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException;

    public int countChuDeCauHoi(java.lang.String tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi addQAChuDeCauHoi(
        java.lang.String tenChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateQAChuDeCauHoi(
        long maChuDeCauHoi, java.lang.String tenChuDeCauHoi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
