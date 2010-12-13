package com.nss.portlet.qa_cau_tra_loi.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService;
import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService;
import com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence;


public abstract class CauTraLoiQAServiceBaseImpl extends PrincipalBean
    implements CauTraLoiQAService {
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService.impl")
    protected CauTraLoiQALocalService cauTraLoiQALocalService;
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService.impl")
    protected CauTraLoiQAService cauTraLoiQAService;
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence.impl")
    protected CauTraLoiQAPersistence cauTraLoiQAPersistence;

    public CauTraLoiQALocalService getCauTraLoiQALocalService() {
        return cauTraLoiQALocalService;
    }

    public void setCauTraLoiQALocalService(
        CauTraLoiQALocalService cauTraLoiQALocalService) {
        this.cauTraLoiQALocalService = cauTraLoiQALocalService;
    }

    public CauTraLoiQAService getCauTraLoiQAService() {
        return cauTraLoiQAService;
    }

    public void setCauTraLoiQAService(CauTraLoiQAService cauTraLoiQAService) {
        this.cauTraLoiQAService = cauTraLoiQAService;
    }

    public CauTraLoiQAPersistence getCauTraLoiQAPersistence() {
        return cauTraLoiQAPersistence;
    }

    public void setCauTraLoiQAPersistence(
        CauTraLoiQAPersistence cauTraLoiQAPersistence) {
        this.cauTraLoiQAPersistence = cauTraLoiQAPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
