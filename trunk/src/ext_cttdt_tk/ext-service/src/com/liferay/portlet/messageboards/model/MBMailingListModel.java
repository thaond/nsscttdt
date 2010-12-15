package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBMailingListModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBMailingList</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBMailingList
 * @see com.liferay.portlet.messageboards.model.impl.MBMailingListImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMailingListModelImpl
 *
 */
public interface MBMailingListModel extends BaseModel<MBMailingList> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getMailingListId();

    public void setMailingListId(long mailingListId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public long getCategoryId();

    public void setCategoryId(long categoryId);

    public String getEmailAddress();

    public void setEmailAddress(String emailAddress);

    public String getInProtocol();

    public void setInProtocol(String inProtocol);

    public String getInServerName();

    public void setInServerName(String inServerName);

    public int getInServerPort();

    public void setInServerPort(int inServerPort);

    public boolean getInUseSSL();

    public boolean isInUseSSL();

    public void setInUseSSL(boolean inUseSSL);

    public String getInUserName();

    public void setInUserName(String inUserName);

    public String getInPassword();

    public void setInPassword(String inPassword);

    public int getInReadInterval();

    public void setInReadInterval(int inReadInterval);

    public String getOutEmailAddress();

    public void setOutEmailAddress(String outEmailAddress);

    public boolean getOutCustom();

    public boolean isOutCustom();

    public void setOutCustom(boolean outCustom);

    public String getOutServerName();

    public void setOutServerName(String outServerName);

    public int getOutServerPort();

    public void setOutServerPort(int outServerPort);

    public boolean getOutUseSSL();

    public boolean isOutUseSSL();

    public void setOutUseSSL(boolean outUseSSL);

    public String getOutUserName();

    public void setOutUserName(String outUserName);

    public String getOutPassword();

    public void setOutPassword(String outPassword);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public MBMailingList toEscapedModel();
}
