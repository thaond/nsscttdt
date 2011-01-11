package com.sgs.portlet.report_registry_work.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.report_registry_work.model.ResultProgram;
import com.sgs.portlet.report_registry_work.model.ResultProgramSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ResultProgramModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ResultProgram</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.model.ResultProgram
 * @see com.sgs.portlet.report_registry_work.model.ResultProgramModel
 * @see com.sgs.portlet.report_registry_work.model.impl.ResultProgramImpl
 *
 */
public class ResultProgramModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "result_program_file";
    public static final Object[][] TABLE_COLUMNS = {
            { "resultProgramId", new Integer(Types.BIGINT) },
            

            { "resultProgramTitle", new Integer(Types.VARCHAR) },
            

            { "resultProgramPath", new Integer(Types.VARCHAR) },
            

            { "resultProgramCheck", new Integer(Types.VARCHAR) },
            

            { "reportRegistryId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table result_program_file (resultProgramId LONG not null primary key,resultProgramTitle VARCHAR(75) null,resultProgramPath VARCHAR(75) null,resultProgramCheck VARCHAR(75) null,reportRegistryId LONG,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table result_program_file";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.report_registry_work.model.ResultProgram"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.report_registry_work.model.ResultProgram"));
    private long _resultProgramId;
    private String _resultProgramTitle;
    private String _resultProgramPath;
    private String _resultProgramCheck;
    private long _reportRegistryId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public ResultProgramModelImpl() {
    }

    public static ResultProgram toModel(ResultProgramSoap soapModel) {
        ResultProgram model = new ResultProgramImpl();

        model.setResultProgramId(soapModel.getResultProgramId());
        model.setResultProgramTitle(soapModel.getResultProgramTitle());
        model.setResultProgramPath(soapModel.getResultProgramPath());
        model.setResultProgramCheck(soapModel.getResultProgramCheck());
        model.setReportRegistryId(soapModel.getReportRegistryId());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<ResultProgram> toModels(ResultProgramSoap[] soapModels) {
        List<ResultProgram> models = new ArrayList<ResultProgram>(soapModels.length);

        for (ResultProgramSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _resultProgramId;
    }

    public void setPrimaryKey(long pk) {
        setResultProgramId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_resultProgramId);
    }

    public long getResultProgramId() {
        return _resultProgramId;
    }

    public void setResultProgramId(long resultProgramId) {
        if (resultProgramId != _resultProgramId) {
            _resultProgramId = resultProgramId;
        }
    }

    public String getResultProgramTitle() {
        return GetterUtil.getString(_resultProgramTitle);
    }

    public void setResultProgramTitle(String resultProgramTitle) {
        if (((resultProgramTitle == null) && (_resultProgramTitle != null)) ||
                ((resultProgramTitle != null) && (_resultProgramTitle == null)) ||
                ((resultProgramTitle != null) && (_resultProgramTitle != null) &&
                !resultProgramTitle.equals(_resultProgramTitle))) {
            _resultProgramTitle = resultProgramTitle;
        }
    }

    public String getResultProgramPath() {
        return GetterUtil.getString(_resultProgramPath);
    }

    public void setResultProgramPath(String resultProgramPath) {
        if (((resultProgramPath == null) && (_resultProgramPath != null)) ||
                ((resultProgramPath != null) && (_resultProgramPath == null)) ||
                ((resultProgramPath != null) && (_resultProgramPath != null) &&
                !resultProgramPath.equals(_resultProgramPath))) {
            _resultProgramPath = resultProgramPath;
        }
    }

    public String getResultProgramCheck() {
        return GetterUtil.getString(_resultProgramCheck);
    }

    public void setResultProgramCheck(String resultProgramCheck) {
        if (((resultProgramCheck == null) && (_resultProgramCheck != null)) ||
                ((resultProgramCheck != null) && (_resultProgramCheck == null)) ||
                ((resultProgramCheck != null) && (_resultProgramCheck != null) &&
                !resultProgramCheck.equals(_resultProgramCheck))) {
            _resultProgramCheck = resultProgramCheck;
        }
    }

    public long getReportRegistryId() {
        return _reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        if (reportRegistryId != _reportRegistryId) {
            _reportRegistryId = reportRegistryId;
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

    public ResultProgram toEscapedModel() {
        if (isEscapedModel()) {
            return (ResultProgram) this;
        } else {
            ResultProgram model = new ResultProgramImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setResultProgramId(getResultProgramId());
            model.setResultProgramTitle(HtmlUtil.escape(getResultProgramTitle()));
            model.setResultProgramPath(HtmlUtil.escape(getResultProgramPath()));
            model.setResultProgramCheck(HtmlUtil.escape(getResultProgramCheck()));
            model.setReportRegistryId(getReportRegistryId());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (ResultProgram) Proxy.newProxyInstance(ResultProgram.class.getClassLoader(),
                    new Class[] { ResultProgram.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        ResultProgramImpl clone = new ResultProgramImpl();

        clone.setResultProgramId(getResultProgramId());
        clone.setResultProgramTitle(getResultProgramTitle());
        clone.setResultProgramPath(getResultProgramPath());
        clone.setResultProgramCheck(getResultProgramCheck());
        clone.setReportRegistryId(getReportRegistryId());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        ResultProgramImpl resultProgram = (ResultProgramImpl) obj;

        long pk = resultProgram.getPrimaryKey();

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

        ResultProgramImpl resultProgram = null;

        try {
            resultProgram = (ResultProgramImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = resultProgram.getPrimaryKey();

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
