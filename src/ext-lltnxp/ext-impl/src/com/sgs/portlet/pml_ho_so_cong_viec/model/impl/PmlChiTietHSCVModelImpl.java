package com.sgs.portlet.pml_ho_so_cong_viec.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCVSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlChiTietHSCVModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlChiTietHSCV</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCVModel
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl
 *
 */
public class PmlChiTietHSCVModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_chi_tiet_hscv";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_chi_tiet_hscv", new Integer(Types.BIGINT) },
            

            { "id_ho_so_cong_viec", new Integer(Types.BIGINT) },
            

            { "id_cong_van_den", new Integer(Types.BIGINT) },
            

            { "id_cong_van_di", new Integer(Types.BIGINT) },
            

            { "di_den", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_chi_tiet_hscv (id_chi_tiet_hscv LONG not null primary key,id_ho_so_cong_viec LONG,id_cong_van_den LONG,id_cong_van_di LONG,di_den VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_chi_tiet_hscv";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"));
    private long _idChiTietHSCV;
    private long _idHoSoCongViec;
    private long _idCongVanDen;
    private long _idCongVanDi;
    private String _diDen;

    public PmlChiTietHSCVModelImpl() {
    }

    public static PmlChiTietHSCV toModel(PmlChiTietHSCVSoap soapModel) {
        PmlChiTietHSCV model = new PmlChiTietHSCVImpl();

        model.setIdChiTietHSCV(soapModel.getIdChiTietHSCV());
        model.setIdHoSoCongViec(soapModel.getIdHoSoCongViec());
        model.setIdCongVanDen(soapModel.getIdCongVanDen());
        model.setIdCongVanDi(soapModel.getIdCongVanDi());
        model.setDiDen(soapModel.getDiDen());

        return model;
    }

    public static List<PmlChiTietHSCV> toModels(PmlChiTietHSCVSoap[] soapModels) {
        List<PmlChiTietHSCV> models = new ArrayList<PmlChiTietHSCV>(soapModels.length);

        for (PmlChiTietHSCVSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _idChiTietHSCV;
    }

    public void setPrimaryKey(long pk) {
        setIdChiTietHSCV(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_idChiTietHSCV);
    }

    public long getIdChiTietHSCV() {
        return _idChiTietHSCV;
    }

    public void setIdChiTietHSCV(long idChiTietHSCV) {
        if (idChiTietHSCV != _idChiTietHSCV) {
            _idChiTietHSCV = idChiTietHSCV;
        }
    }

    public long getIdHoSoCongViec() {
        return _idHoSoCongViec;
    }

    public void setIdHoSoCongViec(long idHoSoCongViec) {
        if (idHoSoCongViec != _idHoSoCongViec) {
            _idHoSoCongViec = idHoSoCongViec;
        }
    }

    public long getIdCongVanDen() {
        return _idCongVanDen;
    }

    public void setIdCongVanDen(long idCongVanDen) {
        if (idCongVanDen != _idCongVanDen) {
            _idCongVanDen = idCongVanDen;
        }
    }

    public long getIdCongVanDi() {
        return _idCongVanDi;
    }

    public void setIdCongVanDi(long idCongVanDi) {
        if (idCongVanDi != _idCongVanDi) {
            _idCongVanDi = idCongVanDi;
        }
    }

    public String getDiDen() {
        return GetterUtil.getString(_diDen);
    }

    public void setDiDen(String diDen) {
        if (((diDen == null) && (_diDen != null)) ||
                ((diDen != null) && (_diDen == null)) ||
                ((diDen != null) && (_diDen != null) && !diDen.equals(_diDen))) {
            _diDen = diDen;
        }
    }

    public PmlChiTietHSCV toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlChiTietHSCV) this;
        } else {
            PmlChiTietHSCV model = new PmlChiTietHSCVImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIdChiTietHSCV(getIdChiTietHSCV());
            model.setIdHoSoCongViec(getIdHoSoCongViec());
            model.setIdCongVanDen(getIdCongVanDen());
            model.setIdCongVanDi(getIdCongVanDi());
            model.setDiDen(HtmlUtil.escape(getDiDen()));

            model = (PmlChiTietHSCV) Proxy.newProxyInstance(PmlChiTietHSCV.class.getClassLoader(),
                    new Class[] { PmlChiTietHSCV.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlChiTietHSCVImpl clone = new PmlChiTietHSCVImpl();

        clone.setIdChiTietHSCV(getIdChiTietHSCV());
        clone.setIdHoSoCongViec(getIdHoSoCongViec());
        clone.setIdCongVanDen(getIdCongVanDen());
        clone.setIdCongVanDi(getIdCongVanDi());
        clone.setDiDen(getDiDen());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlChiTietHSCVImpl pmlChiTietHSCV = (PmlChiTietHSCVImpl) obj;

        int value = 0;

        if (getIdChiTietHSCV() < pmlChiTietHSCV.getIdChiTietHSCV()) {
            value = -1;
        } else if (getIdChiTietHSCV() > pmlChiTietHSCV.getIdChiTietHSCV()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlChiTietHSCVImpl pmlChiTietHSCV = null;

        try {
            pmlChiTietHSCV = (PmlChiTietHSCVImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlChiTietHSCV.getPrimaryKey();

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
