package com.nss.portlet.qa_chu_de.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService;
import com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiFinder;
import com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence;


public abstract class QAChuDeCauHoiServiceBaseImpl extends PrincipalBean
    implements QAChuDeCauHoiService {
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService.impl")
    protected QAChuDeCauHoiLocalService qaChuDeCauHoiLocalService;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService.impl")
    protected QAChuDeCauHoiService qaChuDeCauHoiService;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence.impl")
    protected QAChuDeCauHoiPersistence qaChuDeCauHoiPersistence;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiFinder.impl")
    protected QAChuDeCauHoiFinder qaChuDeCauHoiFinder;

    public QAChuDeCauHoiLocalService getQAChuDeCauHoiLocalService() {
        return qaChuDeCauHoiLocalService;
    }

    public void setQAChuDeCauHoiLocalService(
        QAChuDeCauHoiLocalService qaChuDeCauHoiLocalService) {
        this.qaChuDeCauHoiLocalService = qaChuDeCauHoiLocalService;
    }

    public QAChuDeCauHoiService getQAChuDeCauHoiService() {
        return qaChuDeCauHoiService;
    }

    public void setQAChuDeCauHoiService(
        QAChuDeCauHoiService qaChuDeCauHoiService) {
        this.qaChuDeCauHoiService = qaChuDeCauHoiService;
    }

    public QAChuDeCauHoiPersistence getQAChuDeCauHoiPersistence() {
        return qaChuDeCauHoiPersistence;
    }

    public void setQAChuDeCauHoiPersistence(
        QAChuDeCauHoiPersistence qaChuDeCauHoiPersistence) {
        this.qaChuDeCauHoiPersistence = qaChuDeCauHoiPersistence;
    }

    public QAChuDeCauHoiFinder getQAChuDeCauHoiFinder() {
        return qaChuDeCauHoiFinder;
    }

    public void setQAChuDeCauHoiFinder(QAChuDeCauHoiFinder qaChuDeCauHoiFinder) {
        this.qaChuDeCauHoiFinder = qaChuDeCauHoiFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
