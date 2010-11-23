package com.nss.portlet.loai_thu_tuc.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;
import com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService;
import com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService;
import com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhFinder;
import com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence;

import java.util.List;


public abstract class LoaiThuTucHanhChinhLocalServiceBaseImpl
    implements LoaiThuTucHanhChinhLocalService {
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService.impl")
    protected LoaiThuTucHanhChinhLocalService loaiThuTucHanhChinhLocalService;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService.impl")
    protected LoaiThuTucHanhChinhService loaiThuTucHanhChinhService;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence.impl")
    protected LoaiThuTucHanhChinhPersistence loaiThuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhFinder.impl")
    protected LoaiThuTucHanhChinhFinder loaiThuTucHanhChinhFinder;

    public LoaiThuTucHanhChinh addLoaiThuTucHanhChinh(
        LoaiThuTucHanhChinh loaiThuTucHanhChinh) throws SystemException {
        loaiThuTucHanhChinh.setNew(true);

        return loaiThuTucHanhChinhPersistence.update(loaiThuTucHanhChinh, false);
    }

    public LoaiThuTucHanhChinh createLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) {
        return loaiThuTucHanhChinhPersistence.create(maLoaiThuTucHanhChinh);
    }

    public void deleteLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws PortalException, SystemException {
        loaiThuTucHanhChinhPersistence.remove(maLoaiThuTucHanhChinh);
    }

    public void deleteLoaiThuTucHanhChinh(
        LoaiThuTucHanhChinh loaiThuTucHanhChinh) throws SystemException {
        loaiThuTucHanhChinhPersistence.remove(loaiThuTucHanhChinh);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return loaiThuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return loaiThuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public LoaiThuTucHanhChinh getLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) throws PortalException, SystemException {
        return loaiThuTucHanhChinhPersistence.findByPrimaryKey(maLoaiThuTucHanhChinh);
    }

    public List<LoaiThuTucHanhChinh> getLoaiThuTucHanhChinhs(int start, int end)
        throws SystemException {
        return loaiThuTucHanhChinhPersistence.findAll(start, end);
    }

    public int getLoaiThuTucHanhChinhsCount() throws SystemException {
        return loaiThuTucHanhChinhPersistence.countAll();
    }

    public LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        LoaiThuTucHanhChinh loaiThuTucHanhChinh) throws SystemException {
        loaiThuTucHanhChinh.setNew(false);

        return loaiThuTucHanhChinhPersistence.update(loaiThuTucHanhChinh, true);
    }

    public LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        LoaiThuTucHanhChinh loaiThuTucHanhChinh, boolean merge)
        throws SystemException {
        loaiThuTucHanhChinh.setNew(false);

        return loaiThuTucHanhChinhPersistence.update(loaiThuTucHanhChinh, merge);
    }

    public LoaiThuTucHanhChinhLocalService getLoaiThuTucHanhChinhLocalService() {
        return loaiThuTucHanhChinhLocalService;
    }

    public void setLoaiThuTucHanhChinhLocalService(
        LoaiThuTucHanhChinhLocalService loaiThuTucHanhChinhLocalService) {
        this.loaiThuTucHanhChinhLocalService = loaiThuTucHanhChinhLocalService;
    }

    public LoaiThuTucHanhChinhService getLoaiThuTucHanhChinhService() {
        return loaiThuTucHanhChinhService;
    }

    public void setLoaiThuTucHanhChinhService(
        LoaiThuTucHanhChinhService loaiThuTucHanhChinhService) {
        this.loaiThuTucHanhChinhService = loaiThuTucHanhChinhService;
    }

    public LoaiThuTucHanhChinhPersistence getLoaiThuTucHanhChinhPersistence() {
        return loaiThuTucHanhChinhPersistence;
    }

    public void setLoaiThuTucHanhChinhPersistence(
        LoaiThuTucHanhChinhPersistence loaiThuTucHanhChinhPersistence) {
        this.loaiThuTucHanhChinhPersistence = loaiThuTucHanhChinhPersistence;
    }

    public LoaiThuTucHanhChinhFinder getLoaiThuTucHanhChinhFinder() {
        return loaiThuTucHanhChinhFinder;
    }

    public void setLoaiThuTucHanhChinhFinder(
        LoaiThuTucHanhChinhFinder loaiThuTucHanhChinhFinder) {
        this.loaiThuTucHanhChinhFinder = loaiThuTucHanhChinhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
