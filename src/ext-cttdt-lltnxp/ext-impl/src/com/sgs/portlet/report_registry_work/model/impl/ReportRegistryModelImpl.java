package com.sgs.portlet.report_registry_work.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.ReportRegistrySoap;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReportRegistryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ReportRegistry</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.model.ReportRegistry
 * @see com.sgs.portlet.report_registry_work.model.ReportRegistryModel
 * @see com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl
 *
 */
public class ReportRegistryModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "report_registry_work";
    public static final Object[][] TABLE_COLUMNS = {
            { "reportRegistryId", new Integer(Types.BIGINT) },
            

            { "reportRegistryCode", new Integer(Types.BIGINT) },
            

            { "departmentName", new Integer(Types.VARCHAR) },
            

            { "resultWork", new Integer(Types.VARCHAR) },
            

            { "programWork", new Integer(Types.VARCHAR) },
            

            { "reportDate", new Integer(Types.TIMESTAMP) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table report_registry_work (reportRegistryId LONG not null,reportRegistryCode LONG not null,departmentName VARCHAR(75) null,resultWork VARCHAR(75) null,programWork VARCHAR(75) null,reportDate DATE null,userId LONG,groupId LONG,companyId LONG,primary key (reportRegistryId, reportRegistryCode))";
    public static final String TABLE_SQL_DROP = "drop table report_registry_work";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.report_registry_work.model.ReportRegistry"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.report_registry_work.model.ReportRegistry"));
    private long _reportRegistryId;
    private long _reportRegistryCode;
    private String _departmentName;
    private String _resultWork;
    private String _programWork;
    private Date _reportDate;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public ReportRegistryModelImpl() {
    }

    public static ReportRegistry toModel(ReportRegistrySoap soapModel) {
        ReportRegistry model = new ReportRegistryImpl();

        model.setReportRegistryId(soapModel.getReportRegistryId());
        model.setReportRegistryCode(soapModel.getReportRegistryCode());
        model.setDepartmentName(soapModel.getDepartmentName());
        model.setResultWork(soapModel.getResultWork());
        model.setProgramWork(soapModel.getProgramWork());
        model.setReportDate(soapModel.getReportDate());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<ReportRegistry> toModels(ReportRegistrySoap[] soapModels) {
        List<ReportRegistry> models = new ArrayList<ReportRegistry>(soapModels.length);

        for (ReportRegistrySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public ReportRegistryPK getPrimaryKey() {
        return new ReportRegistryPK(_reportRegistryId, _reportRegistryCode);
    }

    public void setPrimaryKey(ReportRegistryPK pk) {
        setReportRegistryId(pk.reportRegistryId);
        setReportRegistryCode(pk.reportRegistryCode);
    }

    public Serializable getPrimaryKeyObj() {
        return new ReportRegistryPK(_reportRegistryId, _reportRegistryCode);
    }

    public long getReportRegistryId() {
        return _reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        if (reportRegistryId != _reportRegistryId) {
            _reportRegistryId = reportRegistryId;
        }
    }

    public long getReportRegistryCode() {
        return _reportRegistryCode;
    }

    public void setReportRegistryCode(long reportRegistryCode) {
        if (reportRegistryCode != _reportRegistryCode) {
            _reportRegistryCode = reportRegistryCode;
        }
    }

    public String getDepartmentName() {
        return GetterUtil.getString(_departmentName);
    }

    public void setDepartmentName(String departmentName) {
        if (((departmentName == null) && (_departmentName != null)) ||
                ((departmentName != null) && (_departmentName == null)) ||
                ((departmentName != null) && (_departmentName != null) &&
                !departmentName.equals(_departmentName))) {
            _departmentName = departmentName;
        }
    }

    public String getResultWork() {
        return GetterUtil.getString(_resultWork);
    }

    public void setResultWork(String resultWork) {
        if (((resultWork == null) && (_resultWork != null)) ||
                ((resultWork != null) && (_resultWork == null)) ||
                ((resultWork != null) && (_resultWork != null) &&
                !resultWork.equals(_resultWork))) {
            _resultWork = resultWork;
        }
    }

    public String getProgramWork() {
        return GetterUtil.getString(_programWork);
    }

    public void setProgramWork(String programWork) {
        if (((programWork == null) && (_programWork != null)) ||
                ((programWork != null) && (_programWork == null)) ||
                ((programWork != null) && (_programWork != null) &&
                !programWork.equals(_programWork))) {
            _programWork = programWork;
        }
    }

    public Date getReportDate() {
        return _reportDate;
    }

    public void setReportDate(Date reportDate) {
        if (((reportDate == null) && (_reportDate != null)) ||
                ((reportDate != null) && (_reportDate == null)) ||
                ((reportDate != null) && (_reportDate != null) &&
                !reportDate.equals(_reportDate))) {
            _reportDate = reportDate;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public ReportRegistry toEscapedModel() {
        if (isEscapedModel()) {
            return (ReportRegistry) this;
        } else {
            ReportRegistry model = new ReportRegistryImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setReportRegistryId(getReportRegistryId());
            model.setReportRegistryCode(getReportRegistryCode());
            model.setDepartmentName(HtmlUtil.escape(getDepartmentName()));
            model.setResultWork(HtmlUtil.escape(getResultWork()));
            model.setProgramWork(HtmlUtil.escape(getProgramWork()));
            model.setReportDate(getReportDate());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (ReportRegistry) Proxy.newProxyInstance(ReportRegistry.class.getClassLoader(),
                    new Class[] { ReportRegistry.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        ReportRegistryImpl clone = new ReportRegistryImpl();

        clone.setReportRegistryId(getReportRegistryId());
        clone.setReportRegistryCode(getReportRegistryCode());
        clone.setDepartmentName(getDepartmentName());
        clone.setResultWork(getResultWork());
        clone.setProgramWork(getProgramWork());
        clone.setReportDate(getReportDate());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        ReportRegistryImpl reportRegistry = (ReportRegistryImpl) obj;

        ReportRegistryPK pk = reportRegistry.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ReportRegistryImpl reportRegistry = null;

        try {
            reportRegistry = (ReportRegistryImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        ReportRegistryPK pk = reportRegistry.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }
}
