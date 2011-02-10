package com.sgs.portlet.message_note.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.service.PmlMessageLocalService;
import com.sgs.portlet.message_note.service.persistence.PmlMessageFinder;
import com.sgs.portlet.message_note.service.persistence.PmlMessagePersistence;

import java.util.List;


public abstract class PmlMessageLocalServiceBaseImpl
    implements PmlMessageLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.message_note.service.PmlMessageLocalService.impl")
    protected PmlMessageLocalService pmlMessageLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.message_note.service.persistence.PmlMessagePersistence.impl")
    protected PmlMessagePersistence pmlMessagePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.message_note.service.persistence.PmlMessageFinder.impl")
    protected PmlMessageFinder pmlMessageFinder;

    public PmlMessage addPmlMessage(PmlMessage pmlMessage)
        throws SystemException {
        pmlMessage.setNew(true);

        return pmlMessagePersistence.update(pmlMessage, false);
    }

    public PmlMessage createPmlMessage(long messageId) {
        return pmlMessagePersistence.create(messageId);
    }

    public void deletePmlMessage(long messageId)
        throws PortalException, SystemException {
        pmlMessagePersistence.remove(messageId);
    }

    public void deletePmlMessage(PmlMessage pmlMessage)
        throws SystemException {
        pmlMessagePersistence.remove(pmlMessage);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlMessagePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlMessagePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlMessage getPmlMessage(long messageId)
        throws PortalException, SystemException {
        return pmlMessagePersistence.findByPrimaryKey(messageId);
    }

    public List<PmlMessage> getPmlMessages(int start, int end)
        throws SystemException {
        return pmlMessagePersistence.findAll(start, end);
    }

    public int getPmlMessagesCount() throws SystemException {
        return pmlMessagePersistence.countAll();
    }

    public PmlMessage updatePmlMessage(PmlMessage pmlMessage)
        throws SystemException {
        pmlMessage.setNew(false);

        return pmlMessagePersistence.update(pmlMessage, true);
    }

    public PmlMessageLocalService getPmlMessageLocalService() {
        return pmlMessageLocalService;
    }

    public void setPmlMessageLocalService(
        PmlMessageLocalService pmlMessageLocalService) {
        this.pmlMessageLocalService = pmlMessageLocalService;
    }

    public PmlMessagePersistence getPmlMessagePersistence() {
        return pmlMessagePersistence;
    }

    public void setPmlMessagePersistence(
        PmlMessagePersistence pmlMessagePersistence) {
        this.pmlMessagePersistence = pmlMessagePersistence;
    }

    public PmlMessageFinder getPmlMessageFinder() {
        return pmlMessageFinder;
    }

    public void setPmlMessageFinder(PmlMessageFinder pmlMessageFinder) {
        this.pmlMessageFinder = pmlMessageFinder;
    }
}
