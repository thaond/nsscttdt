package com.sgs.portlet.pmllevelsend.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSendSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmLevelSendModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmLevelSend</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend
 * @see com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSendModel
 * @see com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl
 *
 */
public class PmlEdmLevelSendModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_levelsend";
    public static final Object[][] TABLE_COLUMNS = {
            { "levelsendid", new Integer(Types.INTEGER) },
            

            { "levelsendname", new Integer(Types.VARCHAR) },
            

            { "levelsendcode", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_levelsend (levelsendid INTEGER not null primary key,levelsendname VARCHAR(75) null,levelsendcode VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_levelsend";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"));
    private int _levelSendId;
    private String _levelSendName;
    private String _levelSendCode;

    public PmlEdmLevelSendModelImpl() {
    }

    public static PmlEdmLevelSend toModel(PmlEdmLevelSendSoap soapModel) {
        PmlEdmLevelSend model = new PmlEdmLevelSendImpl();

        model.setLevelSendId(soapModel.getLevelSendId());
        model.setLevelSendName(soapModel.getLevelSendName());
        model.setLevelSendCode(soapModel.getLevelSendCode());

        return model;
    }

    public static List<PmlEdmLevelSend> toModels(
        PmlEdmLevelSendSoap[] soapModels) {
        List<PmlEdmLevelSend> models = new ArrayList<PmlEdmLevelSend>(soapModels.length);

        for (PmlEdmLevelSendSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public int getPrimaryKey() {
        return _levelSendId;
    }

    public void setPrimaryKey(int pk) {
        setLevelSendId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Integer(_levelSendId);
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        if (levelSendId != _levelSendId) {
            _levelSendId = levelSendId;
        }
    }

    public String getLevelSendName() {
        return GetterUtil.getString(_levelSendName);
    }

    public void setLevelSendName(String levelSendName) {
        if (((levelSendName == null) && (_levelSendName != null)) ||
                ((levelSendName != null) && (_levelSendName == null)) ||
                ((levelSendName != null) && (_levelSendName != null) &&
                !levelSendName.equals(_levelSendName))) {
            _levelSendName = levelSendName;
        }
    }

    public String getLevelSendCode() {
        return GetterUtil.getString(_levelSendCode);
    }

    public void setLevelSendCode(String levelSendCode) {
        if (((levelSendCode == null) && (_levelSendCode != null)) ||
                ((levelSendCode != null) && (_levelSendCode == null)) ||
                ((levelSendCode != null) && (_levelSendCode != null) &&
                !levelSendCode.equals(_levelSendCode))) {
            _levelSendCode = levelSendCode;
        }
    }

    public PmlEdmLevelSend toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmLevelSend) this;
        } else {
            PmlEdmLevelSend model = new PmlEdmLevelSendImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLevelSendId(getLevelSendId());
            model.setLevelSendName(HtmlUtil.escape(getLevelSendName()));
            model.setLevelSendCode(HtmlUtil.escape(getLevelSendCode()));

            model = (PmlEdmLevelSend) Proxy.newProxyInstance(PmlEdmLevelSend.class.getClassLoader(),
                    new Class[] { PmlEdmLevelSend.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmLevelSendImpl clone = new PmlEdmLevelSendImpl();

        clone.setLevelSendId(getLevelSendId());
        clone.setLevelSendName(getLevelSendName());
        clone.setLevelSendCode(getLevelSendCode());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmLevelSendImpl pmlEdmLevelSend = (PmlEdmLevelSendImpl) obj;

        int value = 0;

        value = getLevelSendName().toLowerCase()
                    .compareTo(pmlEdmLevelSend.getLevelSendName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmLevelSendImpl pmlEdmLevelSend = null;

        try {
            pmlEdmLevelSend = (PmlEdmLevelSendImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        int pk = pmlEdmLevelSend.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey();
    }
}
