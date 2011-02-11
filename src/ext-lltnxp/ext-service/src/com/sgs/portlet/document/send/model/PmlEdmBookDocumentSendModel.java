package com.sgs.portlet.document.send.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmBookDocumentSendModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmBookDocumentSend</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendImpl
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendModelImpl
 *
 */
public interface PmlEdmBookDocumentSendModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getBookDocumentSendId();

    public void setBookDocumentSendId(long bookDocumentSendId);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public long getCurrentRecord();

    public void setCurrentRecord(long currentRecord);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public int getDocumentRecordTypeId();

    public void setDocumentRecordTypeId(int documentRecordTypeId);

    public String getYearInUse();

    public void setYearInUse(String yearInUse);

    public String getActive();

    public void setActive(String active);

    public String getIsAgency();

    public void setIsAgency(String isAgency);

    public String getAgencyId();

    public void setAgencyId(String agencyId);

    public PmlEdmBookDocumentSend toEscapedModel();
}
