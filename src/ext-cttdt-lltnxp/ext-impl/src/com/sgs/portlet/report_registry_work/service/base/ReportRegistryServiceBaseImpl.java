package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;


public abstract class ReportRegistryServiceBaseImpl extends PrincipalBean
    implements ReportRegistryService {
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService.impl")
    protected ReportRegistryLocalService reportRegistryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryService.impl")
    protected ReportRegistryService reportRegistryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence.impl")
    protected ReportRegistryPersistence reportRegistryPersistence;

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
