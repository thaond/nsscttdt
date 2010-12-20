package com.nss.portlet.qa_cau_tra_loi.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService;
import com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService;
import com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence;

import java.util.List;


public abstract class CauTraLoiQALocalServiceBaseImpl
    implements CauTraLoiQALocalService {
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQALocalService.impl")
    protected CauTraLoiQALocalService cauTraLoiQALocalService;
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.CauTraLoiQAService.impl")
    protected CauTraLoiQAService cauTraLoiQAService;
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence.impl")
    protected CauTraLoiQAPersistence cauTraLoiQAPersistence;

    public CauTraLoiQA addCauTraLoiQA(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        cauTraLoiQA.setNew(true);

        return cauTraLoiQAPersistence.update(cauTraLoiQA, false);
    }

    public CauTraLoiQA createCauTraLoiQA(long maCauTraLoiQA) {
        return cauTraLoiQAPersistence.create(maCauTraLoiQA);
    }

    public void deleteCauTraLoiQA(long maCauTraLoiQA)
        throws PortalException, SystemException {
        cauTraLoiQAPersistence.remove(maCauTraLoiQA);
    }

    public void deleteCauTraLoiQA(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        cauTraLoiQAPersistence.remove(cauTraLoiQA);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return cauTraLoiQAPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return cauTraLoiQAPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public CauTraLoiQA getCauTraLoiQA(long maCauTraLoiQA)
        throws PortalException, SystemException {
        return cauTraLoiQAPersistence.findByPrimaryKey(maCauTraLoiQA);
    }

    public List<CauTraLoiQA> getCauTraLoiQAs(int start, int end)
        throws SystemException {
        return cauTraLoiQAPersistence.findAll(start, end);
    }

    public int getCauTraLoiQAsCount() throws SystemException {
        return cauTraLoiQAPersistence.countAll();
    }

    public CauTraLoiQA updateCauTraLoiQA(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        cauTraLoiQA.setNew(false);

        return cauTraLoiQAPersistence.update(cauTraLoiQA, true);
    }

    public CauTraLoiQA updateCauTraLoiQA(CauTraLoiQA cauTraLoiQA, boolean merge)
        throws SystemException {
        cauTraLoiQA.setNew(false);

        return cauTraLoiQAPersistence.update(cauTraLoiQA, merge);
    }

    public CauTraLoiQALocalService getCauTraLoiQALocalService() {
        return cauTraLoiQALocalService;
    }

    public void setCauTraLoiQALocalService(
        CauTraLoiQALocalService cauTraLoiQALocalService) {
        this.cauTraLoiQALocalService = cauTraLoiQALocalService;
    }

    public CauTraLoiQAService getCauTraLoiQAService() {
        return cauTraLoiQAService;
    }

    public void setCauTraLoiQAService(CauTraLoiQAService cauTraLoiQAService) {
        this.cauTraLoiQAService = cauTraLoiQAService;
    }

    public CauTraLoiQAPersistence getCauTraLoiQAPersistence() {
        return cauTraLoiQAPersistence;
    }

    public void setCauTraLoiQAPersistence(
        CauTraLoiQAPersistence cauTraLoiQAPersistence) {
        this.cauTraLoiQAPersistence = cauTraLoiQAPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
