package com.sgs.portlet.department.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.department.model.PmlDepartmentHSCV;
import com.sgs.portlet.department.model.PmlDepartmentHSCVSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDepartmentHSCVModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDepartmentHSCV</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.model.PmlDepartmentHSCV
 * @see com.sgs.portlet.department.model.PmlDepartmentHSCVModel
 * @see com.sgs.portlet.department.model.impl.PmlDepartmentHSCVImpl
 *
 */
public class PmlDepartmentHSCVModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_conf_phongban_hscv";
    public static final Object[][] TABLE_COLUMNS = {
            { "pmlDepartmentHSCVId", new Integer(Types.BIGINT) },
            

            { "departmentsId", new Integer(Types.VARCHAR) },
            

            { "id_ho_so_cong_viec", new Integer(Types.BIGINT) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_conf_phongban_hscv (pmlDepartmentHSCVId LONG not null primary key,departmentsId VARCHAR(75) null,id_ho_so_cong_viec LONG,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_conf_phongban_hscv";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.department.model.PmlDepartmentHSCV"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.department.model.PmlDepartmentHSCV"));
    private long _pmlDepartmentHSCVId;
    private String _departmentsId;
    private long _id_ho_so_cong_viec;
    private String _description;

    public PmlDepartmentHSCVModelImpl() {
    }

    public static PmlDepartmentHSCV toModel(PmlDepartmentHSCVSoap soapModel) {
        PmlDepartmentHSCV model = new PmlDepartmentHSCVImpl();

        model.setPmlDepartmentHSCVId(soapModel.getPmlDepartmentHSCVId());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setId_ho_so_cong_viec(soapModel.getId_ho_so_cong_viec());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<PmlDepartmentHSCV> toModels(
        PmlDepartmentHSCVSoap[] soapModels) {
        List<PmlDepartmentHSCV> models = new ArrayList<PmlDepartmentHSCV>(soapModels.length);

        for (PmlDepartmentHSCVSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _pmlDepartmentHSCVId;
    }

    public void setPrimaryKey(long pk) {
        setPmlDepartmentHSCVId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_pmlDepartmentHSCVId);
    }

    public long getPmlDepartmentHSCVId() {
        return _pmlDepartmentHSCVId;
    }

    public void setPmlDepartmentHSCVId(long pmlDepartmentHSCVId) {
        if (pmlDepartmentHSCVId != _pmlDepartmentHSCVId) {
            _pmlDepartmentHSCVId = pmlDepartmentHSCVId;
        }
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
        }
    }

    public long getId_ho_so_cong_viec() {
        return _id_ho_so_cong_viec;
    }

    public void setId_ho_so_cong_viec(long id_ho_so_cong_viec) {
        if (id_ho_so_cong_viec != _id_ho_so_cong_viec) {
            _id_ho_so_cong_viec = id_ho_so_cong_viec;
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

    public PmlDepartmentHSCV toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDepartmentHSCV) this;
        } else {
            PmlDepartmentHSCV model = new PmlDepartmentHSCVImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setPmlDepartmentHSCVId(getPmlDepartmentHSCVId());
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setId_ho_so_cong_viec(getId_ho_so_cong_viec());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (PmlDepartmentHSCV) Proxy.newProxyInstance(PmlDepartmentHSCV.class.getClassLoader(),
                    new Class[] { PmlDepartmentHSCV.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDepartmentHSCVImpl clone = new PmlDepartmentHSCVImpl();

        clone.setPmlDepartmentHSCVId(getPmlDepartmentHSCVId());
        clone.setDepartmentsId(getDepartmentsId());
        clone.setId_ho_so_cong_viec(getId_ho_so_cong_viec());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDepartmentHSCVImpl pmlDepartmentHSCV = (PmlDepartmentHSCVImpl) obj;

        int value = 0;

        if (getPmlDepartmentHSCVId() < pmlDepartmentHSCV.getPmlDepartmentHSCVId()) {
            value = -1;
        } else if (getPmlDepartmentHSCVId() > pmlDepartmentHSCV.getPmlDepartmentHSCVId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDepartmentHSCVImpl pmlDepartmentHSCV = null;

        try {
            pmlDepartmentHSCV = (PmlDepartmentHSCVImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDepartmentHSCV.getPrimaryKey();

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
