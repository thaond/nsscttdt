package com.sgs.portlet.nation.service;


/**
 * <a href="NationLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.nation.service.impl.NationLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.nation.service.NationLocalServiceUtil
 *
 */
public interface NationLocalService {
    public com.sgs.portlet.nation.model.Nation addNation(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation createNation(
        java.lang.String nationId);

    public void deleteNation(java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteNation(com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation getNation(
        java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> getNations(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getNationsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation updateNation(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_QUOCGIA(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
