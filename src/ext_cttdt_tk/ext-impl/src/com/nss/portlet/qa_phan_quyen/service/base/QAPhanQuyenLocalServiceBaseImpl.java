package com.nss.portlet.qa_phan_quyen.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService;
import com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence;

import java.util.List;


public abstract class QAPhanQuyenLocalServiceBaseImpl
    implements QAPhanQuyenLocalService {
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalService.impl")
    protected QAPhanQuyenLocalService qaPhanQuyenLocalService;
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenService.impl")
    protected QAPhanQuyenService qaPhanQuyenService;
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence.impl")
    protected QAPhanQuyenPersistence qaPhanQuyenPersistence;

    public QAPhanQuyen addQAPhanQuyen(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        qaPhanQuyen.setNew(true);

        return qaPhanQuyenPersistence.update(qaPhanQuyen, false);
    }

    public QAPhanQuyen createQAPhanQuyen(long maPhanQuyen) {
        return qaPhanQuyenPersistence.create(maPhanQuyen);
    }

    public void deleteQAPhanQuyen(long maPhanQuyen)
        throws PortalException, SystemException {
        qaPhanQuyenPersistence.remove(maPhanQuyen);
    }

    public void deleteQAPhanQuyen(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        qaPhanQuyenPersistence.remove(qaPhanQuyen);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return qaPhanQuyenPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return qaPhanQuyenPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public QAPhanQuyen getQAPhanQuyen(long maPhanQuyen)
        throws PortalException, SystemException {
        return qaPhanQuyenPersistence.findByPrimaryKey(maPhanQuyen);
    }

    public List<QAPhanQuyen> getQAPhanQuyens(int start, int end)
        throws SystemException {
        return qaPhanQuyenPersistence.findAll(start, end);
    }

    public int getQAPhanQuyensCount() throws SystemException {
        return qaPhanQuyenPersistence.countAll();
    }

    public QAPhanQuyen updateQAPhanQuyen(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        qaPhanQuyen.setNew(false);

        return qaPhanQuyenPersistence.update(qaPhanQuyen, true);
    }

    public QAPhanQuyen updateQAPhanQuyen(QAPhanQuyen qaPhanQuyen, boolean merge)
        throws SystemException {
        qaPhanQuyen.setNew(false);

        return qaPhanQuyenPersistence.update(qaPhanQuyen, merge);
    }

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
