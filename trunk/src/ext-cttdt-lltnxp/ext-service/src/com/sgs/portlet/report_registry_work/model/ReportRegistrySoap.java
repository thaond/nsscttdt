package com.sgs.portlet.report_registry_work.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReportRegistrySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.ReportRegistryServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.ReportRegistryServiceSoap
 *
 */
public class ReportRegistrySoap implements Serializable {
    private long _reportRegistryId;
    private String _reportRegistryCode;
    private String _resultWork;
    private String _programWork;
    private Date _reportDate;
    private long _departmentId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public ReportRegistrySoap() {
    }

    public static ReportRegistrySoap toSoapModel(ReportRegistry model) {
        ReportRegistrySoap soapModel = new ReportRegistrySoap();

        soapModel.setReportRegistryId(model.getReportRegistryId());
        soapModel.setReportRegistryCode(model.getReportRegistryCode());
        soapModel.setResultWork(model.getResultWork());
        soapModel.setProgramWork(model.getProgramWork());
        soapModel.setReportDate(model.getReportDate());
        soapModel.setDepartmentId(model.getDepartmentId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static ReportRegistrySoap[] toSoapModels(List<ReportRegistry> models) {
        List<ReportRegistrySoap> soapModels = new ArrayList<ReportRegistrySoap>(models.size());

        for (ReportRegistry model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ReportRegistrySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _reportRegistryId;
    }

    public void setPrimaryKey(long pk) {
        setReportRegistryId(pk);
    }

    public long getReportRegistryId() {
        return _reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        _reportRegistryId = reportRegistryId;
    }

    public String getReportRegistryCode() {
        return _reportRegistryCode;
    }

    public void setReportRegistryCode(String reportRegistryCode) {
        _reportRegistryCode = reportRegistryCode;
    }

    public String getResultWork() {
        return _resultWork;
    }

    public void setResultWork(String resultWork) {
        _resultWork = resultWork;
    }

    public String getProgramWork() {
        return _programWork;
    }

    public void setProgramWork(String programWork) {
        _programWork = programWork;
    }

    public Date getReportDate() {
        return _reportDate;
    }

    public void setReportDate(Date reportDate) {
        _reportDate = reportDate;
    }

    public long getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(long departmentId) {
        _departmentId = departmentId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
