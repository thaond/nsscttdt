package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPK;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;

import java.util.List;


public abstract class ReportRegistryLocalServiceBaseImpl
    implements ReportRegistryLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService.impl")
    protected ReportRegistryLocalService reportRegistryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryService.impl")
    protected ReportRegistryService reportRegistryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence.impl")
    protected ReportRegistryPersistence reportRegistryPersistence;

    public ReportRegistry addReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistry.setNew(true);

        return reportRegistryPersistence.update(reportRegistry, false);
    }

    public ReportRegistry createReportRegistry(
        ReportRegistryPK reportRegistryPK) {
        return reportRegistryPersistence.create(reportRegistryPK);
    }

    public void deleteReportRegistry(ReportRegistryPK reportRegistryPK)
        throws PortalException, SystemException {
        reportRegistryPersistence.remove(reportRegistryPK);
    }

    public void deleteReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistryPersistence.remove(reportRegistry);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return reportRegistryPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return reportRegistryPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ReportRegistry getReportRegistry(ReportRegistryPK reportRegistryPK)
        throws PortalException, SystemException {
        return reportRegistryPersistence.findByPrimaryKey(reportRegistryPK);
    }

    public List<ReportRegistry> getReportRegistries(int start, int end)
        throws SystemException {
        return reportRegistryPersistence.findAll(start, end);
    }

    public int getReportRegistriesCount() throws SystemException {
        return reportRegistryPersistence.countAll();
    }

    public ReportRegistry updateReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistry.setNew(false);

        return reportRegistryPersistence.update(reportRegistry, true);
    }

    public ReportRegistryLocalService getReportRegistryLocalService() {
        return reportRegistryLocalService;
    }

    public void setReportRegistryLocalService(
        ReportRegistryLocalService reportRegistryLocalService) {
        this.reportRegistryLocalService = reportRegistryLocalService;
    }

    public ReportRegistryService getReportRegistryService() {
        return reportRegistryService;
    }

    public void setReportRegistryService(
        ReportRegistryService reportRegistryService) {
        this.reportRegistryService = reportRegistryService;
    }

    public ReportRegistryPersistence getReportRegistryPersistence() {
        return reportRegistryPersistence;
    }

    public void setReportRegistryPersistence(
        ReportRegistryPersistence reportRegistryPersistence) {
        this.reportRegistryPersistence = reportRegistryPersistence;
    }
}
