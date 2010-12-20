package com.nss.portlet.thong_ke_tin.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalService;
import com.nss.portlet.thong_ke_tin.service.persistence.NSSTagsAssetFinder;


public abstract class NSSTagsAssetLocalServiceBaseImpl
    implements NSSTagsAssetLocalService {
    @BeanReference(name = "com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalService.impl")
    protected NSSTagsAssetLocalService nssTagsAssetLocalService;
    @BeanReference(name = "com.nss.portlet.thong_ke_tin.service.persistence.NSSTagsAssetFinder.impl")
    protected NSSTagsAssetFinder nssTagsAssetFinder;

    public NSSTagsAssetLocalService getNSSTagsAssetLocalService() {
        return nssTagsAssetLocalService;
    }

    public void setNSSTagsAssetLocalService(
        NSSTagsAssetLocalService nssTagsAssetLocalService) {
        this.nssTagsAssetLocalService = nssTagsAssetLocalService;
    }

    public NSSTagsAssetFinder getNSSTagsAssetFinder() {
        return nssTagsAssetFinder;
    }

    public void setNSSTagsAssetFinder(NSSTagsAssetFinder nssTagsAssetFinder) {
        this.nssTagsAssetFinder = nssTagsAssetFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
