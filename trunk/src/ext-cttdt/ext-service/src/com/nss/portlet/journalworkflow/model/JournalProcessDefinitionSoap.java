package com.nss.portlet.journalworkflow.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="JournalProcessDefinitionSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journalworkflow.service.http.JournalProcessDefinitionServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.http.JournalProcessDefinitionServiceSoap
 *
 */
public class JournalProcessDefinitionSoap implements Serializable {
    private long _journalProcessDefinitionId;
    private String _name;
    private String _version;
    private String _content;

    public JournalProcessDefinitionSoap() {
    }

    public static JournalProcessDefinitionSoap toSoapModel(
        JournalProcessDefinition model) {
        JournalProcessDefinitionSoap soapModel = new JournalProcessDefinitionSoap();

        soapModel.setJournalProcessDefinitionId(model.getJournalProcessDefinitionId());
        soapModel.setName(model.getName());
        soapModel.setVersion(model.getVersion());
        soapModel.setContent(model.getContent());

        return soapModel;
    }

    public static JournalProcessDefinitionSoap[] toSoapModels(
        JournalProcessDefinition[] models) {
        JournalProcessDefinitionSoap[] soapModels = new JournalProcessDefinitionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JournalProcessDefinitionSoap[][] toSoapModels(
        JournalProcessDefinition[][] models) {
        JournalProcessDefinitionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JournalProcessDefinitionSoap[models.length][models[0].length];
        } else {
            soapModels = new JournalProcessDefinitionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JournalProcessDefinitionSoap[] toSoapModels(
        List<JournalProcessDefinition> models) {
        List<JournalProcessDefinitionSoap> soapModels = new ArrayList<JournalProcessDefinitionSoap>(models.size());

        for (JournalProcessDefinition model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JournalProcessDefinitionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _journalProcessDefinitionId;
    }

    public void setPrimaryKey(long pk) {
        setJournalProcessDefinitionId(pk);
    }

    public long getJournalProcessDefinitionId() {
        return _journalProcessDefinitionId;
    }

    public void setJournalProcessDefinitionId(long journalProcessDefinitionId) {
        _journalProcessDefinitionId = journalProcessDefinitionId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        _version = version;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }
}
