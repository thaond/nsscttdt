package com.nss.portlet.phone_book.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="DetailBookModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>DetailBook</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.model.DetailBook
 * @see com.nss.portlet.phone_book.model.impl.DetailBookImpl
 * @see com.nss.portlet.phone_book.model.impl.DetailBookModelImpl
 *
 */
public interface DetailBookModel extends BaseModel<DetailBook> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDetailBookId();

    public void setDetailBookId(long detailBookId);

    public String getDetailBookCode();

    public void setDetailBookCode(String detailBookCode);

    public String getDetailBookName();

    public void setDetailBookName(String detailBookName);

    public String getDetailDescription();

    public void setDetailDescription(String detailDescription);

    public boolean getDetailActive();

    public boolean isDetailActive();

    public void setDetailActive(boolean detailActive);

    public String getZip();

    public void setZip(String zip);

    public String getInternal();

    public void setInternal(String internal);

    public String getHome();

    public void setHome(String home);

    public String getMobile();

    public void setMobile(String mobile);

    public long getContactBookId();

    public void setContactBookId(long contactBookId);

    public DetailBook toEscapedModel();
}
