package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlDocumentSendWFModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentSendWF</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentSendWF
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendWFImpl
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendWFModelImpl
 *
 */
public interface PmlDocumentSendWFModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentSendId();

    public void setDocumentSendId(long documentSendId);

    public long getProcessId();

    public void setProcessId(long processId);

    public String getIsMain();

    public void setIsMain(String isMain);

    public PmlDocumentSendWF toEscapedModel();
}
