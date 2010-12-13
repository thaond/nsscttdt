package com.nss.portlet.documentfield.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.service.PmlFieldLocalService;
import com.nss.portlet.documentfield.service.PmlFieldService;
import com.nss.portlet.documentfield.service.persistence.PmlFieldFinder;
import com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence;

import java.util.List;


public abstract class PmlFieldLocalServiceBaseImpl
    implements PmlFieldLocalService {
    @BeanReference(name = "com.nss.portlet.documentfield.service.PmlFieldLocalService.impl")
    protected PmlFieldLocalService pmlFieldLocalService;
    @BeanReference(name = "com.nss.portlet.documentfield.service.PmlFieldService.impl")
    protected PmlFieldService pmlFieldService;
    @BeanReference(name = "com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence.impl")
    protected PmlFieldPersistence pmlFieldPersistence;
    @BeanReference(name = "com.nss.portlet.documentfield.service.persistence.PmlFieldFinder.impl")
    protected PmlFieldFinder pmlFieldFinder;

    public PmlField addPmlField(PmlField pmlField) throws SystemException {
        pmlField.setNew(true);

        return pmlFieldPersistence.update(pmlField, false);
    }

    public PmlField createPmlField(String fieldId) {
        return pmlFieldPersistence.create(fieldId);
    }

    public void deletePmlField(String fieldId)
        throws PortalException, SystemException {
        pmlFieldPersistence.remove(fieldId);
    }

    public void deletePmlField(PmlField pmlField) throws SystemException {
        pmlFieldPersistence.remove(pmlField);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlFieldPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlFieldPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public PmlField getPmlField(String fieldId)
        throws PortalException, SystemException {
        return pmlFieldPersistence.findByPrimaryKey(fieldId);
    }

    public List<PmlField> getPmlFields(int start, int end)
        throws SystemException {
        return pmlFieldPersistence.findAll(start, end);
    }

    public int getPmlFieldsCount() throws SystemException {
        return pmlFieldPersistence.countAll();
    }

    public PmlField updatePmlField(PmlField pmlField) throws SystemException {
        pmlField.setNew(false);

        return pmlFieldPersistence.update(pmlField, true);
    }

    public PmlField updatePmlField(PmlField pmlField, boolean merge)
        throws SystemException {
        pmlField.setNew(false);

        return pmlFieldPersistence.update(pmlField, merge);
    }

    public PmlFieldLocalService getPmlFieldLocalService() {
        return pmlFieldLocalService;
    }

    public void setPmlFieldLocalService(
        PmlFieldLocalService pmlFieldLocalService) {
        this.pmlFieldLocalService = pmlFieldLocalService;
    }

    public PmlFieldService getPmlFieldService() {
        return pmlFieldService;
    }

    public void setPmlFieldService(PmlFieldService pmlFieldService) {
        this.pmlFieldService = pmlFieldService;
    }

    public PmlFieldPersistence getPmlFieldPersistence() {
        return pmlFieldPersistence;
    }

    public void setPmlFieldPersistence(PmlFieldPersistence pmlFieldPersistence) {
        this.pmlFieldPersistence = pmlFieldPersistence;
    }

    public PmlFieldFinder getPmlFieldFinder() {
        return pmlFieldFinder;
    }

    public void setPmlFieldFinder(PmlFieldFinder pmlFieldFinder) {
        this.pmlFieldFinder = pmlFieldFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
