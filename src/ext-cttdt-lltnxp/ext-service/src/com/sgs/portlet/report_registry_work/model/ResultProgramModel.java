package com.sgs.portlet.report_registry_work.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="ResultProgramModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ResultProgram</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.model.ResultProgram
 * @see com.sgs.portlet.report_registry_work.model.impl.ResultProgramImpl
 * @see com.sgs.portlet.report_registry_work.model.impl.ResultProgramModelImpl
 *
 */
public interface ResultProgramModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getResultProgramId();

    public void setResultProgramId(long resultProgramId);

    public String getResultProgramTitle();

    public void setResultProgramTitle(String resultProgramTitle);

    public String getResultProgramPath();

    public void setResultProgramPath(String resultProgramPath);

    public String getResultProgramCheck();

    public void setResultProgramCheck(String resultProgramCheck);

    public long getReportRegistryId();

    public void setReportRegistryId(long reportRegistryId);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public ResultProgram toEscapedModel();
}
