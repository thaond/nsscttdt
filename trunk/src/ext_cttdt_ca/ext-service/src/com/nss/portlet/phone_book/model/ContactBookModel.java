package com.nss.portlet.phone_book.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="ContactBookModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ContactBook</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.model.ContactBook
 * @see com.nss.portlet.phone_book.model.impl.ContactBookImpl
 * @see com.nss.portlet.phone_book.model.impl.ContactBookModelImpl
 *
 */
public interface ContactBookModel extends BaseModel<ContactBook> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getContactBookId();

    public void setContactBookId(long contactBookId);

    public String getContactBookCode();

    public void setContactBookCode(String contactBookCode);

    public String getContactBookName();

    public void setContactBookName(String contactBookName);

    public String getContactDescription();

    public void setContactDescription(String contactDescription);

    public boolean getContactActive();

    public boolean isContactActive();

    public void setContactActive(boolean contactActive);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public ContactBook toEscapedModel();
}
