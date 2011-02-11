package com.sgs.portlet.pml_tinh_chat.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTinhChatModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTinhChat</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat
 * @see com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatModel
 * @see com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatImpl
 *
 */
public class PmlTinhChatModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_tinh_chat";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_tinh_chat", new Integer(Types.BIGINT) },
            

            { "ten_tinh_chat", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_tinh_chat (id_tinh_chat LONG not null primary key,ten_tinh_chat VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_tinh_chat";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat"));
    private long _idTinhChat;
    private String _tenTinhChat;

    public PmlTinhChatModelImpl() {
    }

    public static PmlTinhChat toModel(PmlTinhChatSoap soapModel) {
        PmlTinhChat model = new PmlTinhChatImpl();

        model.setIdTinhChat(soapModel.getIdTinhChat());
        model.setTenTinhChat(soapModel.getTenTinhChat());

        return model;
    }

    public static List<PmlTinhChat> toModels(PmlTinhChatSoap[] soapModels) {
        List<PmlTinhChat> models = new ArrayList<PmlTinhChat>(soapModels.length);

        for (PmlTinhChatSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _idTinhChat;
    }

    public void setPrimaryKey(long pk) {
        setIdTinhChat(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_idTinhChat);
    }

    public long getIdTinhChat() {
        return _idTinhChat;
    }

    public void setIdTinhChat(long idTinhChat) {
        if (idTinhChat != _idTinhChat) {
            _idTinhChat = idTinhChat;
        }
    }

    public String getTenTinhChat() {
        return GetterUtil.getString(_tenTinhChat);
    }

    public void setTenTinhChat(String tenTinhChat) {
        if (((tenTinhChat == null) && (_tenTinhChat != null)) ||
                ((tenTinhChat != null) && (_tenTinhChat == null)) ||
                ((tenTinhChat != null) && (_tenTinhChat != null) &&
                !tenTinhChat.equals(_tenTinhChat))) {
            _tenTinhChat = tenTinhChat;
        }
    }

    public PmlTinhChat toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTinhChat) this;
        } else {
            PmlTinhChat model = new PmlTinhChatImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIdTinhChat(getIdTinhChat());
            model.setTenTinhChat(HtmlUtil.escape(getTenTinhChat()));

            model = (PmlTinhChat) Proxy.newProxyInstance(PmlTinhChat.class.getClassLoader(),
                    new Class[] { PmlTinhChat.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlTinhChatImpl clone = new PmlTinhChatImpl();

        clone.setIdTinhChat(getIdTinhChat());
        clone.setTenTinhChat(getTenTinhChat());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlTinhChatImpl pmlTinhChat = (PmlTinhChatImpl) obj;

        int value = 0;

        value = getTenTinhChat().toLowerCase()
                    .compareTo(pmlTinhChat.getTenTinhChat().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlTinhChatImpl pmlTinhChat = null;

        try {
            pmlTinhChat = (PmlTinhChatImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTinhChat.getPrimaryKey();

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
