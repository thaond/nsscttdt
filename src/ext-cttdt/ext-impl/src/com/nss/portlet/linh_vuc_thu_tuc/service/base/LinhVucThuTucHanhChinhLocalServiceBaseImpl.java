package com.nss.portlet.linh_vuc_thu_tuc.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhService;
import com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhFinder;
import com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence;

import java.util.List;


public abstract class LinhVucThuTucHanhChinhLocalServiceBaseImpl
    implements LinhVucThuTucHanhChinhLocalService {
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService.impl")
    protected LinhVucThuTucHanhChinhLocalService linhVucThuTucHanhChinhLocalService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhService.impl")
    protected LinhVucThuTucHanhChinhService linhVucThuTucHanhChinhService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence.impl")
    protected LinhVucThuTucHanhChinhPersistence linhVucThuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhFinder.impl")
    protected LinhVucThuTucHanhChinhFinder linhVucThuTucHanhChinhFinder;

    public LinhVucThuTucHanhChinh addLinhVucThuTucHanhChinh(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        linhVucThuTucHanhChinh.setNew(true);

        return linhVucThuTucHanhChinhPersistence.update(linhVucThuTucHanhChinh,
            false);
    }

    public LinhVucThuTucHanhChinh createLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh) {
        return linhVucThuTucHanhChinhPersistence.create(maLinhVucThuTucHanhChinh);
    }

    public void deleteLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh)
        throws PortalException, SystemException {
        linhVucThuTucHanhChinhPersistence.remove(maLinhVucThuTucHanhChinh);
    }

    public void deleteLinhVucThuTucHanhChinh(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        linhVucThuTucHanhChinhPersistence.remove(linhVucThuTucHanhChinh);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return linhVucThuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return linhVucThuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public LinhVucThuTucHanhChinh getLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh) throws PortalException, SystemException {
        return linhVucThuTucHanhChinhPersistence.findByPrimaryKey(maLinhVucThuTucHanhChinh);
    }

    public List<LinhVucThuTucHanhChinh> getLinhVucThuTucHanhChinhs(int start,
        int end) throws SystemException {
        return linhVucThuTucHanhChinhPersistence.findAll(start, end);
    }

    public int getLinhVucThuTucHanhChinhsCount() throws SystemException {
        return linhVucThuTucHanhChinhPersistence.countAll();
    }

    public LinhVucThuTucHanhChinh updateLinhVucThuTucHanhChinh(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        linhVucThuTucHanhChinh.setNew(false);

        return linhVucThuTucHanhChinhPersistence.update(linhVucThuTucHanhChinh,
            true);
    }

    public LinhVucThuTucHanhChinh updateLinhVucThuTucHanhChinh(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge)
        throws SystemException {
        linhVucThuTucHanhChinh.setNew(false);

        return linhVucThuTucHanhChinhPersistence.update(linhVucThuTucHanhChinh,
            merge);
    }

    public LinhVucThuTucHanhChinhLocalService getLinhVucThuTucHanhChinhLocalService() {
        return linhVucThuTucHanhChinhLocalService;
    }

    public void setLinhVucThuTucHanhChinhLocalService(
        LinhVucThuTucHanhChinhLocalService linhVucThuTucHanhChinhLocalService) {
        this.linhVucThuTucHanhChinhLocalService = linhVucThuTucHanhChinhLocalService;
    }

    public LinhVucThuTucHanhChinhService getLinhVucThuTucHanhChinhService() {
        return linhVucThuTucHanhChinhService;
    }

    public void setLinhVucThuTucHanhChinhService(
        LinhVucThuTucHanhChinhService linhVucThuTucHanhChinhService) {
        this.linhVucThuTucHanhChinhService = linhVucThuTucHanhChinhService;
    }

    public LinhVucThuTucHanhChinhPersistence getLinhVucThuTucHanhChinhPersistence() {
        return linhVucThuTucHanhChinhPersistence;
    }

    public void setLinhVucThuTucHanhChinhPersistence(
        LinhVucThuTucHanhChinhPersistence linhVucThuTucHanhChinhPersistence) {
        this.linhVucThuTucHanhChinhPersistence = linhVucThuTucHanhChinhPersistence;
    }

    public LinhVucThuTucHanhChinhFinder getLinhVucThuTucHanhChinhFinder() {
        return linhVucThuTucHanhChinhFinder;
    }

    public void setLinhVucThuTucHanhChinhFinder(
        LinhVucThuTucHanhChinhFinder linhVucThuTucHanhChinhFinder) {
        this.linhVucThuTucHanhChinhFinder = linhVucThuTucHanhChinhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
