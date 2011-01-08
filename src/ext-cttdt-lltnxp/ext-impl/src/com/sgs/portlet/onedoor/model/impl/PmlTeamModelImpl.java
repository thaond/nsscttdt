package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlTeam;
import com.sgs.portlet.onedoor.model.PmlTeamSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTeamModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTeam</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlTeam
 * @see com.sgs.portlet.onedoor.model.PmlTeamModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlTeamImpl
 *
 */
public class PmlTeamModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_team";
    public static final Object[][] TABLE_COLUMNS = {
            { "teamid", new Integer(Types.BIGINT) },
            

            { "departmentid", new Integer(Types.VARCHAR) },
            

            { "teamname", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "organizationid", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "specialteam", new Integer(Types.VARCHAR) },
            

            { "teamcode", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_team (teamid LONG not null primary key,departmentid VARCHAR(75) null,teamname VARCHAR(75) null,description VARCHAR(75) null,organizationid LONG,companyid LONG,specialteam VARCHAR(75) null,teamcode VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_team";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlTeam"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlTeam"));
    private long _teamId;
    private String _departmentId;
    private String _teamName;
    private String _description;
    private long _organizationId;
    private long _companyId;
    private String _specialTeam;
    private String _teamCode;

    public PmlTeamModelImpl() {
    }

    public static PmlTeam toModel(PmlTeamSoap soapModel) {
        PmlTeam model = new PmlTeamImpl();

        model.setTeamId(soapModel.getTeamId());
        model.setDepartmentId(soapModel.getDepartmentId());
        model.setTeamName(soapModel.getTeamName());
        model.setDescription(soapModel.getDescription());
        model.setOrganizationId(soapModel.getOrganizationId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setSpecialTeam(soapModel.getSpecialTeam());
        model.setTeamCode(soapModel.getTeamCode());

        return model;
    }

    public static List<PmlTeam> toModels(PmlTeamSoap[] soapModels) {
        List<PmlTeam> models = new ArrayList<PmlTeam>(soapModels.length);

        for (PmlTeamSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _teamId;
    }

    public void setPrimaryKey(long pk) {
        setTeamId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_teamId);
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        if (teamId != _teamId) {
            _teamId = teamId;
        }
    }

    public String getDepartmentId() {
        return GetterUtil.getString(_departmentId);
    }

    public void setDepartmentId(String departmentId) {
        if (((departmentId == null) && (_departmentId != null)) ||
                ((departmentId != null) && (_departmentId == null)) ||
                ((departmentId != null) && (_departmentId != null) &&
                !departmentId.equals(_departmentId))) {
            _departmentId = departmentId;
        }
    }

    public String getTeamName() {
        return GetterUtil.getString(_teamName);
    }

    public void setTeamName(String teamName) {
        if (((teamName == null) && (_teamName != null)) ||
                ((teamName != null) && (_teamName == null)) ||
                ((teamName != null) && (_teamName != null) &&
                !teamName.equals(_teamName))) {
            _teamName = teamName;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public long getOrganizationId() {
        return _organizationId;
    }

    public void setOrganizationId(long organizationId) {
        if (organizationId != _organizationId) {
            _organizationId = organizationId;
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

    public String getSpecialTeam() {
        return GetterUtil.getString(_specialTeam);
    }

    public void setSpecialTeam(String specialTeam) {
        if (((specialTeam == null) && (_specialTeam != null)) ||
                ((specialTeam != null) && (_specialTeam == null)) ||
                ((specialTeam != null) && (_specialTeam != null) &&
                !specialTeam.equals(_specialTeam))) {
            _specialTeam = specialTeam;
        }
    }

    public String getTeamCode() {
        return GetterUtil.getString(_teamCode);
    }

    public void setTeamCode(String teamCode) {
        if (((teamCode == null) && (_teamCode != null)) ||
                ((teamCode != null) && (_teamCode == null)) ||
                ((teamCode != null) && (_teamCode != null) &&
                !teamCode.equals(_teamCode))) {
            _teamCode = teamCode;
        }
    }

    public PmlTeam toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTeam) this;
        } else {
            PmlTeam model = new PmlTeamImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setTeamId(getTeamId());
            model.setDepartmentId(HtmlUtil.escape(getDepartmentId()));
            model.setTeamName(HtmlUtil.escape(getTeamName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setOrganizationId(getOrganizationId());
            model.setCompanyId(getCompanyId());
            model.setSpecialTeam(HtmlUtil.escape(getSpecialTeam()));
            model.setTeamCode(HtmlUtil.escape(getTeamCode()));

            model = (PmlTeam) Proxy.newProxyInstance(PmlTeam.class.getClassLoader(),
                    new Class[] { PmlTeam.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlTeamImpl clone = new PmlTeamImpl();

        clone.setTeamId(getTeamId());
        clone.setDepartmentId(getDepartmentId());
        clone.setTeamName(getTeamName());
        clone.setDescription(getDescription());
        clone.setOrganizationId(getOrganizationId());
        clone.setCompanyId(getCompanyId());
        clone.setSpecialTeam(getSpecialTeam());
        clone.setTeamCode(getTeamCode());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlTeamImpl pmlTeam = (PmlTeamImpl) obj;

        int value = 0;

        value = getTeamName().toLowerCase()
                    .compareTo(pmlTeam.getTeamName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlTeamImpl pmlTeam = null;

        try {
            pmlTeam = (PmlTeamImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTeam.getPrimaryKey();

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
