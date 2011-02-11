package com.sgs.portlet.generatetemplateid.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="IdTemplateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.generatetemplateid.service.http.IdTemplateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.http.IdTemplateServiceSoap
 *
 */
public class IdTemplateSoap implements Serializable {
    private long _templateId;
    private String _format;
    private String _startNumber;
    private long _len;
    private String _description;

    public IdTemplateSoap() {
    }

    public static IdTemplateSoap toSoapModel(IdTemplate model) {
        IdTemplateSoap soapModel = new IdTemplateSoap();

        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setFormat(model.getFormat());
        soapModel.setStartNumber(model.getStartNumber());
        soapModel.setLen(model.getLen());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static IdTemplateSoap[] toSoapModels(List<IdTemplate> models) {
        List<IdTemplateSoap> soapModels = new ArrayList<IdTemplateSoap>(models.size());

        for (IdTemplate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IdTemplateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _templateId;
    }

    public void setPrimaryKey(long pk) {
        setTemplateId(pk);
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        _templateId = templateId;
    }

    public String getFormat() {
        return _format;
    }

    public void setFormat(String format) {
        _format = format;
    }

    public String getStartNumber() {
        return _startNumber;
    }

    public void setStartNumber(String startNumber) {
        _startNumber = startNumber;
    }

    public long getLen() {
        return _len;
    }

    public void setLen(long len) {
        _len = len;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
