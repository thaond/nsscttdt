package com.sgs.portlet.onedoor.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalService;
import com.sgs.portlet.onedoor.service.PmlAgencyLeaderService;
import com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService;
import com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderService;
import com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService;
import com.sgs.portlet.onedoor.service.PmlFileAttachedFileService;
import com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalService;
import com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileService;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileService;
import com.sgs.portlet.onedoor.service.PmlTeamLocalService;
import com.sgs.portlet.onedoor.service.PmlTeamService;
import com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalService;
import com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService;
import com.sgs.portlet.onedoor.service.PmlWorkflowLocalService;
import com.sgs.portlet.onedoor.service.PmlWorkflowService;
import com.sgs.portlet.onedoor.service.persistence.PmlAgencyLeaderPersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlFileAttachedFilePersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFilePersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileFinder;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlTeamPersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowFinder;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowPersistence;

import java.util.List;


public abstract class PmlFileAttachedFileLocalServiceBaseImpl
    implements PmlFileAttachedFileLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService.impl")
    protected PmlOneDoorReceiveFileLocalService pmlOneDoorReceiveFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileService.impl")
    protected PmlOneDoorReceiveFileService pmlOneDoorReceiveFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence.impl")
    protected PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileFinder.impl")
    protected PmlOneDoorReceiveFileFinder pmlOneDoorReceiveFileFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService.impl")
    protected PmlFileAttachedFileLocalService pmlFileAttachedFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlFileAttachedFileService.impl")
    protected PmlFileAttachedFileService pmlFileAttachedFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlFileAttachedFilePersistence.impl")
    protected PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalService.impl")
    protected PmlWfOnedoorProcessLocalService pmlWfOnedoorProcessLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService.impl")
    protected PmlWfOnedoorProcessService pmlWfOnedoorProcessService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence.impl")
    protected PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService.impl")
    protected PmlDepartmentsLeaderLocalService pmlDepartmentsLeaderLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderService.impl")
    protected PmlDepartmentsLeaderService pmlDepartmentsLeaderService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPersistence.impl")
    protected PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalService.impl")
    protected PmlAgencyLeaderLocalService pmlAgencyLeaderLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlAgencyLeaderService.impl")
    protected PmlAgencyLeaderService pmlAgencyLeaderService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlAgencyLeaderPersistence.impl")
    protected PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalService.impl")
    protected PmlFileTypeAttachedFileLocalService pmlFileTypeAttachedFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileService.impl")
    protected PmlFileTypeAttachedFileService pmlFileTypeAttachedFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFilePersistence.impl")
    protected PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlWorkflowLocalService.impl")
    protected PmlWorkflowLocalService pmlWorkflowLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlWorkflowService.impl")
    protected PmlWorkflowService pmlWorkflowService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlWorkflowPersistence.impl")
    protected PmlWorkflowPersistence pmlWorkflowPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlWorkflowFinder.impl")
    protected PmlWorkflowFinder pmlWorkflowFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlTeamLocalService.impl")
    protected PmlTeamLocalService pmlTeamLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.PmlTeamService.impl")
    protected PmlTeamService pmlTeamService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoor.service.persistence.PmlTeamPersistence.impl")
    protected PmlTeamPersistence pmlTeamPersistence;

    public PmlFileAttachedFile addPmlFileAttachedFile(
        PmlFileAttachedFile pmlFileAttachedFile) throws SystemException {
        pmlFileAttachedFile.setNew(true);

        return pmlFileAttachedFilePersistence.update(pmlFileAttachedFile, false);
    }

    public PmlFileAttachedFile createPmlFileAttachedFile(
        String fileAttachedFileId) {
        return pmlFileAttachedFilePersistence.create(fileAttachedFileId);
    }

    public void deletePmlFileAttachedFile(String fileAttachedFileId)
        throws PortalException, SystemException {
        pmlFileAttachedFilePersistence.remove(fileAttachedFileId);
    }

    public void deletePmlFileAttachedFile(
        PmlFileAttachedFile pmlFileAttachedFile) throws SystemException {
        pmlFileAttachedFilePersistence.remove(pmlFileAttachedFile);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlFileAttachedFilePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlFileAttachedFilePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlFileAttachedFile getPmlFileAttachedFile(String fileAttachedFileId)
        throws PortalException, SystemException {
        return pmlFileAttachedFilePersistence.findByPrimaryKey(fileAttachedFileId);
    }

    public List<PmlFileAttachedFile> getPmlFileAttachedFiles(int start, int end)
        throws SystemException {
        return pmlFileAttachedFilePersistence.findAll(start, end);
    }

    public int getPmlFileAttachedFilesCount() throws SystemException {
        return pmlFileAttachedFilePersistence.countAll();
    }

    public PmlFileAttachedFile updatePmlFileAttachedFile(
        PmlFileAttachedFile pmlFileAttachedFile) throws SystemException {
        pmlFileAttachedFile.setNew(false);

        return pmlFileAttachedFilePersistence.update(pmlFileAttachedFile, true);
    }

    public PmlOneDoorReceiveFileLocalService getPmlOneDoorReceiveFileLocalService() {
        return pmlOneDoorReceiveFileLocalService;
    }

    public void setPmlOneDoorReceiveFileLocalService(
        PmlOneDoorReceiveFileLocalService pmlOneDoorReceiveFileLocalService) {
        this.pmlOneDoorReceiveFileLocalService = pmlOneDoorReceiveFileLocalService;
    }

    public PmlOneDoorReceiveFileService getPmlOneDoorReceiveFileService() {
        return pmlOneDoorReceiveFileService;
    }

    public void setPmlOneDoorReceiveFileService(
        PmlOneDoorReceiveFileService pmlOneDoorReceiveFileService) {
        this.pmlOneDoorReceiveFileService = pmlOneDoorReceiveFileService;
    }

    public PmlOneDoorReceiveFilePersistence getPmlOneDoorReceiveFilePersistence() {
        return pmlOneDoorReceiveFilePersistence;
    }

    public void setPmlOneDoorReceiveFilePersistence(
        PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence) {
        this.pmlOneDoorReceiveFilePersistence = pmlOneDoorReceiveFilePersistence;
    }

    public PmlOneDoorReceiveFileFinder getPmlOneDoorReceiveFileFinder() {
        return pmlOneDoorReceiveFileFinder;
    }

    public void setPmlOneDoorReceiveFileFinder(
        PmlOneDoorReceiveFileFinder pmlOneDoorReceiveFileFinder) {
        this.pmlOneDoorReceiveFileFinder = pmlOneDoorReceiveFileFinder;
    }

    public PmlFileAttachedFileLocalService getPmlFileAttachedFileLocalService() {
        return pmlFileAttachedFileLocalService;
    }

    public void setPmlFileAttachedFileLocalService(
        PmlFileAttachedFileLocalService pmlFileAttachedFileLocalService) {
        this.pmlFileAttachedFileLocalService = pmlFileAttachedFileLocalService;
    }

    public PmlFileAttachedFileService getPmlFileAttachedFileService() {
        return pmlFileAttachedFileService;
    }

    public void setPmlFileAttachedFileService(
        PmlFileAttachedFileService pmlFileAttachedFileService) {
        this.pmlFileAttachedFileService = pmlFileAttachedFileService;
    }

    public PmlFileAttachedFilePersistence getPmlFileAttachedFilePersistence() {
        return pmlFileAttachedFilePersistence;
    }

    public void setPmlFileAttachedFilePersistence(
        PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence) {
        this.pmlFileAttachedFilePersistence = pmlFileAttachedFilePersistence;
    }

    public PmlWfOnedoorProcessLocalService getPmlWfOnedoorProcessLocalService() {
        return pmlWfOnedoorProcessLocalService;
    }

    public void setPmlWfOnedoorProcessLocalService(
        PmlWfOnedoorProcessLocalService pmlWfOnedoorProcessLocalService) {
        this.pmlWfOnedoorProcessLocalService = pmlWfOnedoorProcessLocalService;
    }

    public PmlWfOnedoorProcessService getPmlWfOnedoorProcessService() {
        return pmlWfOnedoorProcessService;
    }

    public void setPmlWfOnedoorProcessService(
        PmlWfOnedoorProcessService pmlWfOnedoorProcessService) {
        this.pmlWfOnedoorProcessService = pmlWfOnedoorProcessService;
    }

    public PmlWfOnedoorProcessPersistence getPmlWfOnedoorProcessPersistence() {
        return pmlWfOnedoorProcessPersistence;
    }

    public void setPmlWfOnedoorProcessPersistence(
        PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence) {
        this.pmlWfOnedoorProcessPersistence = pmlWfOnedoorProcessPersistence;
    }

    public PmlDepartmentsLeaderLocalService getPmlDepartmentsLeaderLocalService() {
        return pmlDepartmentsLeaderLocalService;
    }

    public void setPmlDepartmentsLeaderLocalService(
        PmlDepartmentsLeaderLocalService pmlDepartmentsLeaderLocalService) {
        this.pmlDepartmentsLeaderLocalService = pmlDepartmentsLeaderLocalService;
    }

    public PmlDepartmentsLeaderService getPmlDepartmentsLeaderService() {
        return pmlDepartmentsLeaderService;
    }

    public void setPmlDepartmentsLeaderService(
        PmlDepartmentsLeaderService pmlDepartmentsLeaderService) {
        this.pmlDepartmentsLeaderService = pmlDepartmentsLeaderService;
    }

    public PmlDepartmentsLeaderPersistence getPmlDepartmentsLeaderPersistence() {
        return pmlDepartmentsLeaderPersistence;
    }

    public void setPmlDepartmentsLeaderPersistence(
        PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence) {
        this.pmlDepartmentsLeaderPersistence = pmlDepartmentsLeaderPersistence;
    }

    public PmlAgencyLeaderLocalService getPmlAgencyLeaderLocalService() {
        return pmlAgencyLeaderLocalService;
    }

    public void setPmlAgencyLeaderLocalService(
        PmlAgencyLeaderLocalService pmlAgencyLeaderLocalService) {
        this.pmlAgencyLeaderLocalService = pmlAgencyLeaderLocalService;
    }

    public PmlAgencyLeaderService getPmlAgencyLeaderService() {
        return pmlAgencyLeaderService;
    }

    public void setPmlAgencyLeaderService(
        PmlAgencyLeaderService pmlAgencyLeaderService) {
        this.pmlAgencyLeaderService = pmlAgencyLeaderService;
    }

    public PmlAgencyLeaderPersistence getPmlAgencyLeaderPersistence() {
        return pmlAgencyLeaderPersistence;
    }

    public void setPmlAgencyLeaderPersistence(
        PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence) {
        this.pmlAgencyLeaderPersistence = pmlAgencyLeaderPersistence;
    }

    public PmlFileTypeAttachedFileLocalService getPmlFileTypeAttachedFileLocalService() {
        return pmlFileTypeAttachedFileLocalService;
    }

    public void setPmlFileTypeAttachedFileLocalService(
        PmlFileTypeAttachedFileLocalService pmlFileTypeAttachedFileLocalService) {
        this.pmlFileTypeAttachedFileLocalService = pmlFileTypeAttachedFileLocalService;
    }

    public PmlFileTypeAttachedFileService getPmlFileTypeAttachedFileService() {
        return pmlFileTypeAttachedFileService;
    }

    public void setPmlFileTypeAttachedFileService(
        PmlFileTypeAttachedFileService pmlFileTypeAttachedFileService) {
        this.pmlFileTypeAttachedFileService = pmlFileTypeAttachedFileService;
    }

    public PmlFileTypeAttachedFilePersistence getPmlFileTypeAttachedFilePersistence() {
        return pmlFileTypeAttachedFilePersistence;
    }

    public void setPmlFileTypeAttachedFilePersistence(
        PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence) {
        this.pmlFileTypeAttachedFilePersistence = pmlFileTypeAttachedFilePersistence;
    }

    public PmlWorkflowLocalService getPmlWorkflowLocalService() {
        return pmlWorkflowLocalService;
    }

    public void setPmlWorkflowLocalService(
        PmlWorkflowLocalService pmlWorkflowLocalService) {
        this.pmlWorkflowLocalService = pmlWorkflowLocalService;
    }

    public PmlWorkflowService getPmlWorkflowService() {
        return pmlWorkflowService;
    }

    public void setPmlWorkflowService(PmlWorkflowService pmlWorkflowService) {
        this.pmlWorkflowService = pmlWorkflowService;
    }

    public PmlWorkflowPersistence getPmlWorkflowPersistence() {
        return pmlWorkflowPersistence;
    }

    public void setPmlWorkflowPersistence(
        PmlWorkflowPersistence pmlWorkflowPersistence) {
        this.pmlWorkflowPersistence = pmlWorkflowPersistence;
    }

    public PmlWorkflowFinder getPmlWorkflowFinder() {
        return pmlWorkflowFinder;
    }

    public void setPmlWorkflowFinder(PmlWorkflowFinder pmlWorkflowFinder) {
        this.pmlWorkflowFinder = pmlWorkflowFinder;
    }

    public PmlTeamLocalService getPmlTeamLocalService() {
        return pmlTeamLocalService;
    }

    public void setPmlTeamLocalService(PmlTeamLocalService pmlTeamLocalService) {
        this.pmlTeamLocalService = pmlTeamLocalService;
    }

    public PmlTeamService getPmlTeamService() {
        return pmlTeamService;
    }

    public void setPmlTeamService(PmlTeamService pmlTeamService) {
        this.pmlTeamService = pmlTeamService;
    }

    public PmlTeamPersistence getPmlTeamPersistence() {
        return pmlTeamPersistence;
    }

    public void setPmlTeamPersistence(PmlTeamPersistence pmlTeamPersistence) {
        this.pmlTeamPersistence = pmlTeamPersistence;
    }
}
