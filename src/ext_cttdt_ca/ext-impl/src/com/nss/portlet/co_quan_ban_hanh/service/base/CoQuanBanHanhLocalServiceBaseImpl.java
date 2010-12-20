package com.nss.portlet.co_quan_ban_hanh.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService;
import com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhFinder;
import com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence;

import java.util.List;


public abstract class CoQuanBanHanhLocalServiceBaseImpl
    implements CoQuanBanHanhLocalService {
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService.impl")
    protected CoQuanBanHanhLocalService coQuanBanHanhLocalService;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService.impl")
    protected CoQuanBanHanhService coQuanBanHanhService;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence.impl")
    protected CoQuanBanHanhPersistence coQuanBanHanhPersistence;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhFinder.impl")
    protected CoQuanBanHanhFinder coQuanBanHanhFinder;

    public CoQuanBanHanh addCoQuanBanHanh(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        coQuanBanHanh.setNew(true);

        return coQuanBanHanhPersistence.update(coQuanBanHanh, false);
    }

    public CoQuanBanHanh createCoQuanBanHanh(long maCoQuanBanHanh) {
        return coQuanBanHanhPersistence.create(maCoQuanBanHanh);
    }

    public void deleteCoQuanBanHanh(long maCoQuanBanHanh)
        throws PortalException, SystemException {
        coQuanBanHanhPersistence.remove(maCoQuanBanHanh);
    }

    public void deleteCoQuanBanHanh(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        coQuanBanHanhPersistence.remove(coQuanBanHanh);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return coQuanBanHanhPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return coQuanBanHanhPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public CoQuanBanHanh getCoQuanBanHanh(long maCoQuanBanHanh)
        throws PortalException, SystemException {
        return coQuanBanHanhPersistence.findByPrimaryKey(maCoQuanBanHanh);
    }

    public List<CoQuanBanHanh> getCoQuanBanHanhs(int start, int end)
        throws SystemException {
        return coQuanBanHanhPersistence.findAll(start, end);
    }

    public int getCoQuanBanHanhsCount() throws SystemException {
        return coQuanBanHanhPersistence.countAll();
    }

    public CoQuanBanHanh updateCoQuanBanHanh(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        coQuanBanHanh.setNew(false);

        return coQuanBanHanhPersistence.update(coQuanBanHanh, true);
    }

    public CoQuanBanHanh updateCoQuanBanHanh(CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws SystemException {
        coQuanBanHanh.setNew(false);

        return coQuanBanHanhPersistence.update(coQuanBanHanh, merge);
    }

    public CoQuanBanHanhLocalService getCoQuanBanHanhLocalService() {
        return coQuanBanHanhLocalService;
    }

    public void setCoQuanBanHanhLocalService(
        CoQuanBanHanhLocalService coQuanBanHanhLocalService) {
        this.coQuanBanHanhLocalService = coQuanBanHanhLocalService;
    }

    public CoQuanBanHanhService getCoQuanBanHanhService() {
        return coQuanBanHanhService;
    }

    public void setCoQuanBanHanhService(
        CoQuanBanHanhService coQuanBanHanhService) {
        this.coQuanBanHanhService = coQuanBanHanhService;
    }

    public CoQuanBanHanhPersistence getCoQuanBanHanhPersistence() {
        return coQuanBanHanhPersistence;
    }

    public void setCoQuanBanHanhPersistence(
        CoQuanBanHanhPersistence coQuanBanHanhPersistence) {
        this.coQuanBanHanhPersistence = coQuanBanHanhPersistence;
    }

    public CoQuanBanHanhFinder getCoQuanBanHanhFinder() {
        return coQuanBanHanhFinder;
    }

    public void setCoQuanBanHanhFinder(CoQuanBanHanhFinder coQuanBanHanhFinder) {
        this.coQuanBanHanhFinder = coQuanBanHanhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
