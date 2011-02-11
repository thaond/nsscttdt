package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmDocumentRecordToModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentRecordTo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToModelImpl
 *
 */
public interface PmlEdmDocumentRecordToModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentRecordToId();

    public void setDocumentRecordToId(long documentRecordToId);

    public Date getDateCreate();

    public void setDateCreate(Date dateCreate);

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

    public PmlEdmDocumentRecordTo toEscapedModel();
}
