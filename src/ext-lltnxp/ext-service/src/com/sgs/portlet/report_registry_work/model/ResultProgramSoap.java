package com.sgs.portlet.report_registry_work.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ResultProgramSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.ResultProgramServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.ResultProgramServiceSoap
 *
 */
public class ResultProgramSoap implements Serializable {
    private long _resultProgramId;
    private String _resultProgramTitle;
    private String _resultProgramPath;
    private String _resultProgramCheck;
    private long _reportRegistryId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public ResultProgramSoap() {
    }

    public static ResultProgramSoap toSoapModel(ResultProgram model) {
        ResultProgramSoap soapModel = new ResultProgramSoap();

        soapModel.setResultProgramId(model.getResultProgramId());
        soapModel.setResultProgramTitle(model.getResultProgramTitle());
        soapModel.setResultProgramPath(model.getResultProgramPath());
        soapModel.setResultProgramCheck(model.getResultProgramCheck());
        soapModel.setReportRegistryId(model.getReportRegistryId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static ResultProgramSoap[] toSoapModels(List<ResultProgram> models) {
        List<ResultProgramSoap> soapModels = new ArrayList<ResultProgramSoap>(models.size());

        for (ResultProgram model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ResultProgramSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _resultProgramId;
    }

    public void setPrimaryKey(long pk) {
        setResultProgramId(pk);
    }

    public long getResultProgramId() {
        return _resultProgramId;
    }

    public void setResultProgramId(long resultProgramId) {
        _resultProgramId = resultProgramId;
    }

    public String getResultProgramTitle() {
        return _resultProgramTitle;
    }

    public void setResultProgramTitle(String resultProgramTitle) {
        _resultProgramTitle = resultProgramTitle;
    }

    public String getResultProgramPath() {
        return _resultProgramPath;
    }

    public void setResultProgramPath(String resultProgramPath) {
        _resultProgramPath = resultProgramPath;
    }

    public String getResultProgramCheck() {
        return _resultProgramCheck;
    }

    public void setResultProgramCheck(String resultProgramCheck) {
        _resultProgramCheck = resultProgramCheck;
    }

    public long getReportRegistryId() {
        return _reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        _reportRegistryId = reportRegistryId;
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
