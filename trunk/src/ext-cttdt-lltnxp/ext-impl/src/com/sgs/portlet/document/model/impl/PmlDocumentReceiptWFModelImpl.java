package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlDocumentReceiptWFSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptWFModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDocumentReceiptWF</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptWF
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptWFModel
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFImpl
 *
 */
public class PmlDocumentReceiptWFModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_documentreceipt_wf";
    public static final Object[][] TABLE_COLUMNS = {
            { "processid", new Integer(Types.BIGINT) },
            

            { "documentreceiptid", new Integer(Types.BIGINT) },
            

            { "ismain", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_documentreceipt_wf (processid LONG not null primary key,documentreceiptid LONG,ismain VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_documentreceipt_wf";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlDocumentReceiptWF"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlDocumentReceiptWF"));
    private long _processId;
    private long _documentReceiptId;
    private String _isMain;

    public PmlDocumentReceiptWFModelImpl() {
    }

    public static PmlDocumentReceiptWF toModel(
        PmlDocumentReceiptWFSoap soapModel) {
        PmlDocumentReceiptWF model = new PmlDocumentReceiptWFImpl();

        model.setProcessId(soapModel.getProcessId());
        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setIsMain(soapModel.getIsMain());

        return model;
    }

    public static List<PmlDocumentReceiptWF> toModels(
        PmlDocumentReceiptWFSoap[] soapModels) {
        List<PmlDocumentReceiptWF> models = new ArrayList<PmlDocumentReceiptWF>(soapModels.length);

        for (PmlDocumentReceiptWFSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _processId;
    }

    public void setPrimaryKey(long pk) {
        setProcessId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_processId);
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        if (processId != _processId) {
            _processId = processId;
        }
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        if (documentReceiptId != _documentReceiptId) {
            _documentReceiptId = documentReceiptId;
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

    public PmlDocumentReceiptWF toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDocumentReceiptWF) this;
        } else {
            PmlDocumentReceiptWF model = new PmlDocumentReceiptWFImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setProcessId(getProcessId());
            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setIsMain(HtmlUtil.escape(getIsMain()));

            model = (PmlDocumentReceiptWF) Proxy.newProxyInstance(PmlDocumentReceiptWF.class.getClassLoader(),
                    new Class[] { PmlDocumentReceiptWF.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDocumentReceiptWFImpl clone = new PmlDocumentReceiptWFImpl();

        clone.setProcessId(getProcessId());
        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setIsMain(getIsMain());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDocumentReceiptWFImpl pmlDocumentReceiptWF = (PmlDocumentReceiptWFImpl) obj;

        int value = 0;

        if (getProcessId() < pmlDocumentReceiptWF.getProcessId()) {
            value = -1;
        } else if (getProcessId() > pmlDocumentReceiptWF.getProcessId()) {
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

        PmlDocumentReceiptWFImpl pmlDocumentReceiptWF = null;

        try {
            pmlDocumentReceiptWF = (PmlDocumentReceiptWFImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDocumentReceiptWF.getPrimaryKey();

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
