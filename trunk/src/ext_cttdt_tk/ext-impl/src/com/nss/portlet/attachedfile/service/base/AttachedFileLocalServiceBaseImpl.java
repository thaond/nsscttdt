package com.nss.portlet.attachedfile.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.attachedfile.model.AttachedFile;
import com.nss.portlet.attachedfile.service.AttachedFileLocalService;
import com.nss.portlet.attachedfile.service.AttachedFileService;
import com.nss.portlet.attachedfile.service.persistence.AttachedFileFinder;
import com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence;

import java.util.List;


public abstract class AttachedFileLocalServiceBaseImpl
    implements AttachedFileLocalService {
    @BeanReference(name = "com.nss.portlet.attachedfile.service.AttachedFileLocalService.impl")
    protected AttachedFileLocalService attachedFileLocalService;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.AttachedFileService.impl")
    protected AttachedFileService attachedFileService;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence.impl")
    protected AttachedFilePersistence attachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.persistence.AttachedFileFinder.impl")
    protected AttachedFileFinder attachedFileFinder;

    public AttachedFile addAttachedFile(AttachedFile attachedFile)
        throws SystemException {
        attachedFile.setNew(true);

        return attachedFilePersistence.update(attachedFile, false);
    }

    public AttachedFile createAttachedFile(String attachedFileId) {
        return attachedFilePersistence.create(attachedFileId);
    }

    public void deleteAttachedFile(String attachedFileId)
        throws PortalException, SystemException {
        attachedFilePersistence.remove(attachedFileId);
    }

    public void deleteAttachedFile(AttachedFile attachedFile)
        throws SystemException {
        attachedFilePersistence.remove(attachedFile);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return attachedFilePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return attachedFilePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public AttachedFile getAttachedFile(String attachedFileId)
        throws PortalException, SystemException {
        return attachedFilePersistence.findByPrimaryKey(attachedFileId);
    }

    public List<AttachedFile> getAttachedFiles(int start, int end)
        throws SystemException {
        return attachedFilePersistence.findAll(start, end);
    }

    public int getAttachedFilesCount() throws SystemException {
        return attachedFilePersistence.countAll();
    }

    public AttachedFile updateAttachedFile(AttachedFile attachedFile)
        throws SystemException {
        attachedFile.setNew(false);

        return attachedFilePersistence.update(attachedFile, true);
    }

    public AttachedFile updateAttachedFile(AttachedFile attachedFile,
        boolean merge) throws SystemException {
        attachedFile.setNew(false);

        return attachedFilePersistence.update(attachedFile, merge);
    }

    public AttachedFileLocalService getAttachedFileLocalService() {
        return attachedFileLocalService;
    }

    public void setAttachedFileLocalService(
        AttachedFileLocalService attachedFileLocalService) {
        this.attachedFileLocalService = attachedFileLocalService;
    }

    public AttachedFileService getAttachedFileService() {
        return attachedFileService;
    }

    public void setAttachedFileService(AttachedFileService attachedFileService) {
        this.attachedFileService = attachedFileService;
    }

    public AttachedFilePersistence getAttachedFilePersistence() {
        return attachedFilePersistence;
    }

    public void setAttachedFilePersistence(
        AttachedFilePersistence attachedFilePersistence) {
        this.attachedFilePersistence = attachedFilePersistence;
    }

    public AttachedFileFinder getAttachedFileFinder() {
        return attachedFileFinder;
    }

    public void setAttachedFileFinder(AttachedFileFinder attachedFileFinder) {
        this.attachedFileFinder = attachedFileFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
