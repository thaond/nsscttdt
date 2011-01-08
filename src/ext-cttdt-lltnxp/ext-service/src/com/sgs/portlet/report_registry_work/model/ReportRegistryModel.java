package com.sgs.portlet.report_registry_work.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPK;

import java.util.Date;


/**
 * <a href="ReportRegistryModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ReportRegistry</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.model.ReportRegistry
 * @see com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl
 * @see com.sgs.portlet.report_registry_work.model.impl.ReportRegistryModelImpl
 *
 */
public interface ReportRegistryModel extends BaseModel {
    public ReportRegistryPK getPrimaryKey();

    public void setPrimaryKey(ReportRegistryPK pk);

    public long getReportRegistryId();

    public void setReportRegistryId(long reportRegistryId);

    public long getReportRegistryCode();

    public void setReportRegistryCode(long reportRegistryCode);

    public String getDepartmentName();

    public void setDepartmentName(String departmentName);

    public String getResultWork();

    public void setResultWork(String resultWork);

    public String getProgramWork();

    public void setProgramWork(String programWork);

    public Date getReportDate();

    public void setReportDate(Date reportDate);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public ReportRegistry toEscapedModel();
}
