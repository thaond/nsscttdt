package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.MBDiscussionSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MBDiscussionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MBDiscussion</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBDiscussion
 * @see com.liferay.portlet.messageboards.model.MBDiscussionModel
 * @see com.liferay.portlet.messageboards.model.impl.MBDiscussionImpl
 *
 */
public class MBDiscussionModelImpl extends BaseModelImpl<MBDiscussion> {
    public static final String TABLE_NAME = "MBDiscussion";
    public static final Object[][] TABLE_COLUMNS = {
            { "discussionId", new Integer(Types.BIGINT) },
            

            { "classNameId", new Integer(Types.BIGINT) },
            

            { "classPK", new Integer(Types.BIGINT) },
            

            { "threadId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table MBDiscussion (discussionId LONG not null primary key,classNameId LONG,classPK LONG,threadId LONG)";
    public static final String TABLE_SQL_DROP = "drop table MBDiscussion";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBDiscussion"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBDiscussion"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.liferay.portlet.messageboards.model.MBDiscussion"));
    private long _discussionId;
    private long _classNameId;
    private long _originalClassNameId;
    private boolean _setOriginalClassNameId;
    private long _classPK;
    private long _originalClassPK;
    private boolean _setOriginalClassPK;
    private long _threadId;
    private long _originalThreadId;
    private boolean _setOriginalThreadId;
    private transient ExpandoBridge _expandoBridge;

    public MBDiscussionModelImpl() {
    }

    public static MBDiscussion toModel(MBDiscussionSoap soapModel) {
        MBDiscussion model = new MBDiscussionImpl();

        model.setDiscussionId(soapModel.getDiscussionId());
        model.setClassNameId(soapModel.getClassNameId());
        model.setClassPK(soapModel.getClassPK());
        model.setThreadId(soapModel.getThreadId());

        return model;
    }

    public static List<MBDiscussion> toModels(MBDiscussionSoap[] soapModels) {
        List<MBDiscussion> models = new ArrayList<MBDiscussion>(soapModels.length);

        for (MBDiscussionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _discussionId;
    }

    public void setPrimaryKey(long pk) {
        setDiscussionId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_discussionId);
    }

    public long getDiscussionId() {
        return _discussionId;
    }

    public void setDiscussionId(long discussionId) {
        _discussionId = discussionId;
    }

    public String getClassName() {
        if (getClassNameId() <= 0) {
            return StringPool.BLANK;
        }

        return PortalUtil.getClassName(getClassNameId());
    }

    public long getClassNameId() {
        return _classNameId;
    }

    public void setClassNameId(long classNameId) {
        _classNameId = classNameId;

        if (!_setOriginalClassNameId) {
            _setOriginalClassNameId = true;

            _originalClassNameId = classNameId;
        }
    }

    public long getOriginalClassNameId() {
        return _originalClassNameId;
    }

    public long getClassPK() {
        return _classPK;
    }

    public void setClassPK(long classPK) {
        _classPK = classPK;

        if (!_setOriginalClassPK) {
            _setOriginalClassPK = true;

            _originalClassPK = classPK;
        }
    }

    public long getOriginalClassPK() {
        return _originalClassPK;
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;

        if (!_setOriginalThreadId) {
            _setOriginalThreadId = true;

            _originalThreadId = threadId;
        }
    }

    public long getOriginalThreadId() {
        return _originalThreadId;
    }

    public MBDiscussion toEscapedModel() {
        if (isEscapedModel()) {
            return (MBDiscussion) this;
        } else {
            MBDiscussion model = new MBDiscussionImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDiscussionId(getDiscussionId());
            model.setClassNameId(getClassNameId());
            model.setClassPK(getClassPK());
            model.setThreadId(getThreadId());

            model = (MBDiscussion) Proxy.newProxyInstance(MBDiscussion.class.getClassLoader(),
                    new Class[] { MBDiscussion.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MBDiscussion.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MBDiscussionImpl clone = new MBDiscussionImpl();

        clone.setDiscussionId(getDiscussionId());
        clone.setClassNameId(getClassNameId());
        clone.setClassPK(getClassPK());
        clone.setThreadId(getThreadId());

        return clone;
    }

    public int compareTo(MBDiscussion mbDiscussion) {
        long pk = mbDiscussion.getPrimaryKey();

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

        MBDiscussion mbDiscussion = null;

        try {
            mbDiscussion = (MBDiscussion) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = mbDiscussion.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{discussionId=");
        sb.append(getDiscussionId());
        sb.append(", classNameId=");
        sb.append(getClassNameId());
        sb.append(", classPK=");
        sb.append(getClassPK());
        sb.append(", threadId=");
        sb.append(getThreadId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.liferay.portlet.messageboards.model.MBDiscussion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>discussionId</column-name><column-value><![CDATA[");
        sb.append(getDiscussionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>classNameId</column-name><column-value><![CDATA[");
        sb.append(getClassNameId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>classPK</column-name><column-value><![CDATA[");
        sb.append(getClassPK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>threadId</column-name><column-value><![CDATA[");
        sb.append(getThreadId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
