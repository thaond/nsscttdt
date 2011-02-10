package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.model.PmlDocumentSendWFSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDocumentSendWFModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDocumentSendWF</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentSendWF
 * @see com.sgs.portlet.document.model.PmlDocumentSendWFModel
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendWFImpl
 *
 */
public class PmlDocumentSendWFModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_documentsend_wf";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentsendid", new Integer(Types.BIGINT) },
            

            { "processid", new Integer(Types.BIGINT) },
            

            { "isMain", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_documentsend_wf (documentsendid LONG not null primary key,processid LONG,isMain VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_documentsend_wf";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlDocumentSendWF"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlDocumentSendWF"));
    private long _documentSendId;
    private long _processId;
    private String _isMain;

    public PmlDocumentSendWFModelImpl() {
    }

    public static PmlDocumentSendWF toModel(PmlDocumentSendWFSoap soapModel) {
        PmlDocumentSendWF model = new PmlDocumentSendWFImpl();

        model.setDocumentSendId(soapModel.getDocumentSendId());
        model.setProcessId(soapModel.getProcessId());
        model.setIsMain(soapModel.getIsMain());

        return model;
    }

    public static List<PmlDocumentSendWF> toModels(
        PmlDocumentSendWFSoap[] soapModels) {
        List<PmlDocumentSendWF> models = new ArrayList<PmlDocumentSendWF>(soapModels.length);

        for (PmlDocumentSendWFSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentSendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentSendId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentSendId);
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        if (documentSendId != _documentSendId) {
            _documentSendId = documentSendId;
        }
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        if (processId != _processId) {
            _processId = processId;
        }
    }

    public String getIsMain() {
        return GetterUtil.getString(_isMain);
    }

    public void setIsMain(String isMain) {
        if (((isMain == null) && (_isMain != null)) ||
                ((isMain != null) && (_isMain == null)) ||
                ((isMain != null) && (_isMain != null) &&
                !isMain.equals(_isMain))) {
            _isMain = isMain;
        }
    }

    public PmlDocumentSendWF toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDocumentSendWF) this;
        } else {
            PmlDocumentSendWF model = new PmlDocumentSendWFImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentSendId(getDocumentSendId());
            model.setProcessId(getProcessId());
            model.setIsMain(HtmlUtil.escape(getIsMain()));

            model = (PmlDocumentSendWF) Proxy.newProxyInstance(PmlDocumentSendWF.class.getClassLoader(),
                    new Class[] { PmlDocumentSendWF.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDocumentSendWFImpl clone = new PmlDocumentSendWFImpl();

        clone.setDocumentSendId(getDocumentSendId());
        clone.setProcessId(getProcessId());
        clone.setIsMain(getIsMain());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDocumentSendWFImpl pmlDocumentSendWF = (PmlDocumentSendWFImpl) obj;

        int value = 0;

        if (getDocumentSendId() < pmlDocumentSendWF.getDocumentSendId()) {
            value = -1;
        } else if (getDocumentSendId() > pmlDocumentSendWF.getDocumentSendId()) {
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

        PmlDocumentSendWFImpl pmlDocumentSendWF = null;

        try {
            pmlDocumentSendWF = (PmlDocumentSendWFImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDocumentSendWF.getPrimaryKey();

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
