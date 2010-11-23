package com.nss.portlet.qa_cau_hoi.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalService;
import com.nss.portlet.qa_cau_hoi.service.CauHoiQAService;
import com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalService;
import com.nss.portlet.qa_cau_hoi.service.FileDinhKemQAService;
import com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAFinder;
import com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence;
import com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence;


public abstract class FileDinhKemQAServiceBaseImpl extends PrincipalBean
    implements FileDinhKemQAService {
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.CauHoiQALocalService.impl")
    protected CauHoiQALocalService cauHoiQALocalService;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.CauHoiQAService.impl")
    protected CauHoiQAService cauHoiQAService;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence.impl")
    protected CauHoiQAPersistence cauHoiQAPersistence;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAFinder.impl")
    protected CauHoiQAFinder cauHoiQAFinder;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.FileDinhKemQALocalService.impl")
    protected FileDinhKemQALocalService fileDinhKemQALocalService;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.FileDinhKemQAService.impl")
    protected FileDinhKemQAService fileDinhKemQAService;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence.impl")
    protected FileDinhKemQAPersistence fileDinhKemQAPersistence;

    public CauHoiQALocalService getCauHoiQALocalService() {
        return cauHoiQALocalService;
    }

    public void setCauHoiQALocalService(
        CauHoiQALocalService cauHoiQALocalService) {
        this.cauHoiQALocalService = cauHoiQALocalService;
    }

    public CauHoiQAService getCauHoiQAService() {
        return cauHoiQAService;
    }

    public void setCauHoiQAService(CauHoiQAService cauHoiQAService) {
        this.cauHoiQAService = cauHoiQAService;
    }

    public CauHoiQAPersistence getCauHoiQAPersistence() {
        return cauHoiQAPersistence;
    }

    public void setCauHoiQAPersistence(CauHoiQAPersistence cauHoiQAPersistence) {
        this.cauHoiQAPersistence = cauHoiQAPersistence;
    }

    public CauHoiQAFinder getCauHoiQAFinder() {
        return cauHoiQAFinder;
    }

    public void setCauHoiQAFinder(CauHoiQAFinder cauHoiQAFinder) {
        this.cauHoiQAFinder = cauHoiQAFinder;
    }

    public FileDinhKemQALocalService getFileDinhKemQALocalService() {
        return fileDinhKemQALocalService;
    }

    public void setFileDinhKemQALocalService(
        FileDinhKemQALocalService fileDinhKemQALocalService) {
        this.fileDinhKemQALocalService = fileDinhKemQALocalService;
    }

    public FileDinhKemQAService getFileDinhKemQAService() {
        return fileDinhKemQAService;
    }

    public void setFileDinhKemQAService(
        FileDinhKemQAService fileDinhKemQAService) {
        this.fileDinhKemQAService = fileDinhKemQAService;
    }

    public FileDinhKemQAPersistence getFileDinhKemQAPersistence() {
        return fileDinhKemQAPersistence;
    }

    public void setFileDinhKemQAPersistence(
        FileDinhKemQAPersistence fileDinhKemQAPersistence) {
        this.fileDinhKemQAPersistence = fileDinhKemQAPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
