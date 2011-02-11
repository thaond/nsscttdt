package com.sgs.portlet.pml_do_quan_trong.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrongSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDoQuanTrongModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDoQuanTrong</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong
 * @see com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrongModel
 * @see com.sgs.portlet.pml_do_quan_trong.model.impl.PmlDoQuanTrongImpl
 *
 */
public class PmlDoQuanTrongModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_do_quan_trong";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_do_quan_trong", new Integer(Types.BIGINT) },
            

            { "ten_do_quan_trong", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_do_quan_trong (id_do_quan_trong LONG not null primary key,ten_do_quan_trong VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_do_quan_trong";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong"));
    private long _idDoQuanTrong;
    private String _tenDoQuanTrong;

    public PmlDoQuanTrongModelImpl() {
    }

    public static PmlDoQuanTrong toModel(PmlDoQuanTrongSoap soapModel) {
        PmlDoQuanTrong model = new PmlDoQuanTrongImpl();

        model.setIdDoQuanTrong(soapModel.getIdDoQuanTrong());
        model.setTenDoQuanTrong(soapModel.getTenDoQuanTrong());

        return model;
    }

    public static List<PmlDoQuanTrong> toModels(PmlDoQuanTrongSoap[] soapModels) {
        List<PmlDoQuanTrong> models = new ArrayList<PmlDoQuanTrong>(soapModels.length);

        for (PmlDoQuanTrongSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _idDoQuanTrong;
    }

    public void setPrimaryKey(long pk) {
        setIdDoQuanTrong(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_idDoQuanTrong);
    }

    public long getIdDoQuanTrong() {
        return _idDoQuanTrong;
    }

    public void setIdDoQuanTrong(long idDoQuanTrong) {
        if (idDoQuanTrong != _idDoQuanTrong) {
            _idDoQuanTrong = idDoQuanTrong;
        }
    }

    public String getTenDoQuanTrong() {
        return GetterUtil.getString(_tenDoQuanTrong);
    }

    public void setTenDoQuanTrong(String tenDoQuanTrong) {
        if (((tenDoQuanTrong == null) && (_tenDoQuanTrong != null)) ||
                ((tenDoQuanTrong != null) && (_tenDoQuanTrong == null)) ||
                ((tenDoQuanTrong != null) && (_tenDoQuanTrong != null) &&
                !tenDoQuanTrong.equals(_tenDoQuanTrong))) {
            _tenDoQuanTrong = tenDoQuanTrong;
        }
    }

    public PmlDoQuanTrong toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDoQuanTrong) this;
        } else {
            PmlDoQuanTrong model = new PmlDoQuanTrongImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIdDoQuanTrong(getIdDoQuanTrong());
            model.setTenDoQuanTrong(HtmlUtil.escape(getTenDoQuanTrong()));

            model = (PmlDoQuanTrong) Proxy.newProxyInstance(PmlDoQuanTrong.class.getClassLoader(),
                    new Class[] { PmlDoQuanTrong.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDoQuanTrongImpl clone = new PmlDoQuanTrongImpl();

        clone.setIdDoQuanTrong(getIdDoQuanTrong());
        clone.setTenDoQuanTrong(getTenDoQuanTrong());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDoQuanTrongImpl pmlDoQuanTrong = (PmlDoQuanTrongImpl) obj;

        int value = 0;

        value = getTenDoQuanTrong().toLowerCase()
                    .compareTo(pmlDoQuanTrong.getTenDoQuanTrong().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDoQuanTrongImpl pmlDoQuanTrong = null;

        try {
            pmlDoQuanTrong = (PmlDoQuanTrongImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDoQuanTrong.getPrimaryKey();

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
