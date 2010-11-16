package com.nss.portlet.adv.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.service.QuangCaoLocalService;
import com.nss.portlet.adv.service.QuangCaoService;
import com.nss.portlet.adv.service.persistence.QuangCaoFinder;
import com.nss.portlet.adv.service.persistence.QuangCaoPersistence;

import java.util.List;


public abstract class QuangCaoLocalServiceBaseImpl
    implements QuangCaoLocalService {
    @BeanReference(name = "com.nss.portlet.adv.service.QuangCaoLocalService.impl")
    protected QuangCaoLocalService quangCaoLocalService;
    @BeanReference(name = "com.nss.portlet.adv.service.QuangCaoService.impl")
    protected QuangCaoService quangCaoService;
    @BeanReference(name = "com.nss.portlet.adv.service.persistence.QuangCaoPersistence.impl")
    protected QuangCaoPersistence quangCaoPersistence;
    @BeanReference(name = "com.nss.portlet.adv.service.persistence.QuangCaoFinder.impl")
    protected QuangCaoFinder quangCaoFinder;

    public QuangCao addQuangCao(QuangCao quangCao) throws SystemException {
        quangCao.setNew(true);

        return quangCaoPersistence.update(quangCao, false);
    }

    public QuangCao createQuangCao(long maQuangCao) {
        return quangCaoPersistence.create(maQuangCao);
    }

    public void deleteQuangCao(long maQuangCao)
        throws PortalException, SystemException {
        quangCaoPersistence.remove(maQuangCao);
    }

    public void deleteQuangCao(QuangCao quangCao) throws SystemException {
        quangCaoPersistence.remove(quangCao);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return quangCaoPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return quangCaoPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public QuangCao getQuangCao(long maQuangCao)
        throws PortalException, SystemException {
        return quangCaoPersistence.findByPrimaryKey(maQuangCao);
    }

    public List<QuangCao> getQuangCaos(int start, int end)
        throws SystemException {
        return quangCaoPersistence.findAll(start, end);
    }

    public int getQuangCaosCount() throws SystemException {
        return quangCaoPersistence.countAll();
    }

    public QuangCao updateQuangCao(QuangCao quangCao) throws SystemException {
        quangCao.setNew(false);

        return quangCaoPersistence.update(quangCao, true);
    }

    public QuangCao updateQuangCao(QuangCao quangCao, boolean merge)
        throws SystemException {
        quangCao.setNew(false);

        return quangCaoPersistence.update(quangCao, merge);
    }

    public QuangCaoLocalService getQuangCaoLocalService() {
        return quangCaoLocalService;
    }

    public void setQuangCaoLocalService(
        QuangCaoLocalService quangCaoLocalService) {
        this.quangCaoLocalService = quangCaoLocalService;
    }

    public QuangCaoService getQuangCaoService() {
        return quangCaoService;
    }

    public void setQuangCaoService(QuangCaoService quangCaoService) {
        this.quangCaoService = quangCaoService;
    }

    public QuangCaoPersistence getQuangCaoPersistence() {
        return quangCaoPersistence;
    }

    public void setQuangCaoPersistence(QuangCaoPersistence quangCaoPersistence) {
        this.quangCaoPersistence = quangCaoPersistence;
    }

    public QuangCaoFinder getQuangCaoFinder() {
        return quangCaoFinder;
    }

    public void setQuangCaoFinder(QuangCaoFinder quangCaoFinder) {
        this.quangCaoFinder = quangCaoFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
