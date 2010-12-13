package com.nss.portlet.qa_chu_de.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService;
import com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService;
import com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiFinder;
import com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence;

import java.util.List;


public abstract class QAChuDeCauHoiLocalServiceBaseImpl
    implements QAChuDeCauHoiLocalService {
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiLocalService.impl")
    protected QAChuDeCauHoiLocalService qaChuDeCauHoiLocalService;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.QAChuDeCauHoiService.impl")
    protected QAChuDeCauHoiService qaChuDeCauHoiService;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence.impl")
    protected QAChuDeCauHoiPersistence qaChuDeCauHoiPersistence;
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiFinder.impl")
    protected QAChuDeCauHoiFinder qaChuDeCauHoiFinder;

    public QAChuDeCauHoi addQAChuDeCauHoi(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        qaChuDeCauHoi.setNew(true);

        return qaChuDeCauHoiPersistence.update(qaChuDeCauHoi, false);
    }

    public QAChuDeCauHoi createQAChuDeCauHoi(long maChuDeCauHoi) {
        return qaChuDeCauHoiPersistence.create(maChuDeCauHoi);
    }

    public void deleteQAChuDeCauHoi(long maChuDeCauHoi)
        throws PortalException, SystemException {
        qaChuDeCauHoiPersistence.remove(maChuDeCauHoi);
    }

    public void deleteQAChuDeCauHoi(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        qaChuDeCauHoiPersistence.remove(qaChuDeCauHoi);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return qaChuDeCauHoiPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return qaChuDeCauHoiPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public QAChuDeCauHoi getQAChuDeCauHoi(long maChuDeCauHoi)
        throws PortalException, SystemException {
        return qaChuDeCauHoiPersistence.findByPrimaryKey(maChuDeCauHoi);
    }

    public List<QAChuDeCauHoi> getQAChuDeCauHois(int start, int end)
        throws SystemException {
        return qaChuDeCauHoiPersistence.findAll(start, end);
    }

    public int getQAChuDeCauHoisCount() throws SystemException {
        return qaChuDeCauHoiPersistence.countAll();
    }

    public QAChuDeCauHoi updateQAChuDeCauHoi(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        qaChuDeCauHoi.setNew(false);

        return qaChuDeCauHoiPersistence.update(qaChuDeCauHoi, true);
    }

    public QAChuDeCauHoi updateQAChuDeCauHoi(QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws SystemException {
        qaChuDeCauHoi.setNew(false);

        return qaChuDeCauHoiPersistence.update(qaChuDeCauHoi, merge);
    }

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
