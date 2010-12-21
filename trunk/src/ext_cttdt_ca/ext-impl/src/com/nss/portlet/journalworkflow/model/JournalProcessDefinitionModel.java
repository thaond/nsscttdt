package com.nss.portlet.journalworkflow.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="JournalProcessDefinitionModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalProcessDefinition</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.model.JournalProcessDefinition
 * @see com.nss.portlet.journalworkflow.model.impl.JournalProcessDefinitionImpl
 * @see com.nss.portlet.journalworkflow.model.impl.JournalProcessDefinitionModelImpl
 *
 */
public interface JournalProcessDefinitionModel extends BaseModel<JournalProcessDefinition> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getJournalProcessDefinitionId();

    public void setJournalProcessDefinitionId(long journalProcessDefinitionId);

    public String getName();

    public void setName(String name);

    public String getVersion();

    public void setVersion(String version);

    public String getContent();

    public void setContent(String content);

    public JournalProcessDefinition toEscapedModel();
}
