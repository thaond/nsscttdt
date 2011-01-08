package com.sgs.portlet.pml_trang_thai_hscv.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCVSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTrangThaiHSCVModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTrangThaiHSCV</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCVModel
 * @see com.sgs.portlet.pml_trang_thai_hscv.model.impl.PmlTrangThaiHSCVImpl
 *
 */
public class PmlTrangThaiHSCVModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_trang_thai_hscv";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_trang_thai_hscv", new Integer(Types.BIGINT) },
            

            { "ten_trang_thai_hscv", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_trang_thai_hscv (id_trang_thai_hscv LONG not null primary key,ten_trang_thai_hscv VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_trang_thai_hscv";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV"));
    private long _idTrangThaiHSCV;
    private String _tenTrangThaiHSCV;

    public PmlTrangThaiHSCVModelImpl() {
    }

    public static PmlTrangThaiHSCV toModel(PmlTrangThaiHSCVSoap soapModel) {
        PmlTrangThaiHSCV model = new PmlTrangThaiHSCVImpl();

        model.setIdTrangThaiHSCV(soapModel.getIdTrangThaiHSCV());
        model.setTenTrangThaiHSCV(soapModel.getTenTrangThaiHSCV());

        return model;
    }

    public static List<PmlTrangThaiHSCV> toModels(
        PmlTrangThaiHSCVSoap[] soapModels) {
        List<PmlTrangThaiHSCV> models = new ArrayList<PmlTrangThaiHSCV>(soapModels.length);

        for (PmlTrangThaiHSCVSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _idTrangThaiHSCV;
    }

    public void setPrimaryKey(long pk) {
        setIdTrangThaiHSCV(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_idTrangThaiHSCV);
    }

    public long getIdTrangThaiHSCV() {
        return _idTrangThaiHSCV;
    }

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
        if (idTrangThaiHSCV != _idTrangThaiHSCV) {
            _idTrangThaiHSCV = idTrangThaiHSCV;
        }
    }

    public String getTenTrangThaiHSCV() {
        return GetterUtil.getString(_tenTrangThaiHSCV);
    }

    public void setTenTrangThaiHSCV(String tenTrangThaiHSCV) {
        if (((tenTrangThaiHSCV == null) && (_tenTrangThaiHSCV != null)) ||
                ((tenTrangThaiHSCV != null) && (_tenTrangThaiHSCV == null)) ||
                ((tenTrangThaiHSCV != null) && (_tenTrangThaiHSCV != null) &&
                !tenTrangThaiHSCV.equals(_tenTrangThaiHSCV))) {
            _tenTrangThaiHSCV = tenTrangThaiHSCV;
        }
    }

    public PmlTrangThaiHSCV toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTrangThaiHSCV) this;
        } else {
            PmlTrangThaiHSCV model = new PmlTrangThaiHSCVImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIdTrangThaiHSCV(getIdTrangThaiHSCV());
            model.setTenTrangThaiHSCV(HtmlUtil.escape(getTenTrangThaiHSCV()));

            model = (PmlTrangThaiHSCV) Proxy.newProxyInstance(PmlTrangThaiHSCV.class.getClassLoader(),
                    new Class[] { PmlTrangThaiHSCV.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlTrangThaiHSCVImpl clone = new PmlTrangThaiHSCVImpl();

        clone.setIdTrangThaiHSCV(getIdTrangThaiHSCV());
        clone.setTenTrangThaiHSCV(getTenTrangThaiHSCV());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlTrangThaiHSCVImpl pmlTrangThaiHSCV = (PmlTrangThaiHSCVImpl) obj;

        int value = 0;

        value = getTenTrangThaiHSCV().toLowerCase()
                    .compareTo(pmlTrangThaiHSCV.getTenTrangThaiHSCV()
                                               .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlTrangThaiHSCVImpl pmlTrangThaiHSCV = null;

        try {
            pmlTrangThaiHSCV = (PmlTrangThaiHSCVImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTrangThaiHSCV.getPrimaryKey();

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
