package com.sgs.portlet.report_registry_work.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.ReportRegistrySoap;

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
            

            { "reportRegistryCode", new Integer(Types.VARCHAR) },
            

            { "userCreate", new Integer(Types.VARCHAR) },
            

            { "reportDate", new Integer(Types.TIMESTAMP) },
            

            { "departmentId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table report_registry_work (reportRegistryId LONG not null primary key,reportRegistryCode VARCHAR(75) null,userCreate VARCHAR(75) null,reportDate DATE null,departmentId LONG,userId LONG,groupId LONG,companyId LONG)";
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
    private String _reportRegistryCode;
    private String _userCreate;
    private Date _reportDate;
    private long _departmentId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public ReportRegistryModelImpl() {
    }

    public static ReportRegistry toModel(ReportRegistrySoap soapModel) {
        ReportRegistry model = new ReportRegistryImpl();

        model.setReportRegistryId(soapModel.getReportRegistryId());
        model.setReportRegistryCode(soapModel.getReportRegistryCode());
        model.setUserCreate(soapModel.getUserCreate());
        model.setReportDate(soapModel.getReportDate());
        model.setDepartmentId(soapModel.getDepartmentId());
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

    public long getPrimaryKey() {
        return _reportRegistryId;
    }

    public void setPrimaryKey(long pk) {
        setReportRegistryId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_reportRegistryId);
    }

    public long getReportRegistryId() {
        return _reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        if (reportRegistryId != _reportRegistryId) {
            _reportRegistryId = reportRegistryId;
        }
    }

    public String getReportRegistryCode() {
        return GetterUtil.getString(_reportRegistryCode);
    }

    public void setReportRegistryCode(String reportRegistryCode) {
        if (((reportRegistryCode == null) && (_reportRegistryCode != null)) ||
                ((reportRegistryCode != null) && (_reportRegistryCode == null)) ||
                ((reportRegistryCode != null) && (_reportRegistryCode != null) &&
                !reportRegistryCode.equals(_reportRegistryCode))) {
            _reportRegistryCode = reportRegistryCode;
        }
    }

    public String getUserCreate() {
        return GetterUtil.getString(_userCreate);
    }

    public void setUserCreate(String userCreate) {
        if (((userCreate == null) && (_userCreate != null)) ||
                ((userCreate != null) && (_userCreate == null)) ||
                ((userCreate != null) && (_userCreate != null) &&
                !userCreate.equals(_userCreate))) {
            _userCreate = userCreate;
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

    public long getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(long departmentId) {
        if (departmentId != _departmentId) {
            _departmentId = departmentId;
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
            model.setReportRegistryCode(HtmlUtil.escape(getReportRegistryCode()));
            model.setUserCreate(HtmlUtil.escape(getUserCreate()));
            model.setReportDate(getReportDate());
            model.setDepartmentId(getDepartmentId());
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
        clone.setUserCreate(getUserCreate());
        clone.setReportDate(getReportDate());
        clone.setDepartmentId(getDepartmentId());
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

        long pk = reportRegistry.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
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

        long pk = reportRegistry.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
