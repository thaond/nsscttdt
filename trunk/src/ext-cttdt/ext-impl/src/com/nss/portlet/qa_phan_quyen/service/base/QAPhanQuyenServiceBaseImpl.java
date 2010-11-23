package com.nss.portlet.qa_phan_quyen.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService;
import com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence;


public abstract class QAPhanQuyenServiceBaseImpl extends PrincipalBean
    implements QAPhanQuyenService {
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService.impl")
    protected QAPhanQuyenLocalService qaPhanQuyenLocalService;
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService.impl")
    protected QAPhanQuyenService qaPhanQuyenService;
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence.impl")
    protected QAPhanQuyenPersistence qaPhanQuyenPersistence;

    public QAPhanQuyenLocalService getQAPhanQuyenLocalService() {
        return qaPhanQuyenLocalService;
    }

    public void setQAPhanQuyenLocalService(
        QAPhanQuyenLocalService qaPhanQuyenLocalService) {
        this.qaPhanQuyenLocalService = qaPhanQuyenLocalService;
    }

    public QAPhanQuyenService getQAPhanQuyenService() {
        return qaPhanQuyenService;
    }

    public void setQAPhanQuyenService(QAPhanQuyenService qaPhanQuyenService) {
        this.qaPhanQuyenService = qaPhanQuyenService;
    }

    public QAPhanQuyenPersistence getQAPhanQuyenPersistence() {
        return qaPhanQuyenPersistence;
    }

    public void setQAPhanQuyenPersistence(
        QAPhanQuyenPersistence qaPhanQuyenPersistence) {
        this.qaPhanQuyenPersistence = qaPhanQuyenPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
