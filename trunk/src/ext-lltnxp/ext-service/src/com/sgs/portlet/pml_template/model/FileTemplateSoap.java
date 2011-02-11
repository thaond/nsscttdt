package com.sgs.portlet.pml_template.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileTemplateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_template.service.http.FileTemplateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.http.FileTemplateServiceSoap
 *
 */
public class FileTemplateSoap implements Serializable {
    private long _fileTemplateId;
    private long _templateId;
    private String _tenFile;
    private long _kichThuoc;
    private String _duongDan;

    public FileTemplateSoap() {
    }

    public static FileTemplateSoap toSoapModel(FileTemplate model) {
        FileTemplateSoap soapModel = new FileTemplateSoap();

        soapModel.setFileTemplateId(model.getFileTemplateId());
        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setTenFile(model.getTenFile());
        soapModel.setKichThuoc(model.getKichThuoc());
        soapModel.setDuongDan(model.getDuongDan());

        return soapModel;
    }

    public static FileTemplateSoap[] toSoapModels(List<FileTemplate> models) {
        List<FileTemplateSoap> soapModels = new ArrayList<FileTemplateSoap>(models.size());

        for (FileTemplate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileTemplateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileTemplateId;
    }

    public void setPrimaryKey(long pk) {
        setFileTemplateId(pk);
    }

    public long getFileTemplateId() {
        return _fileTemplateId;
    }

    public void setFileTemplateId(long fileTemplateId) {
        _fileTemplateId = fileTemplateId;
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        _templateId = templateId;
    }

    public String getTenFile() {
        return _tenFile;
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        _kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return _duongDan;
    }

    public void setDuongDan(String duongDan) {
        _duongDan = duongDan;
    }
}
