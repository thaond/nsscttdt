package com.sgs.portlet.pml_template.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_template.model.FileTemplate;
import com.sgs.portlet.pml_template.model.FileTemplateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileTemplateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>FileTemplate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.model.FileTemplate
 * @see com.sgs.portlet.pml_template.model.FileTemplateModel
 * @see com.sgs.portlet.pml_template.model.impl.FileTemplateImpl
 *
 */
public class FileTemplateModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_template_file";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileTemplateId", new Integer(Types.BIGINT) },
            

            { "templateId", new Integer(Types.BIGINT) },
            

            { "tenFile", new Integer(Types.VARCHAR) },
            

            { "kichThuoc", new Integer(Types.BIGINT) },
            

            { "duongDan", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_template_file (fileTemplateId LONG not null primary key,templateId LONG,tenFile VARCHAR(75) null,kichThuoc LONG,duongDan VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_template_file";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_template.model.FileTemplate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_template.model.FileTemplate"));
    private long _fileTemplateId;
    private long _templateId;
    private String _tenFile;
    private long _kichThuoc;
    private String _duongDan;

    public FileTemplateModelImpl() {
    }

    public static FileTemplate toModel(FileTemplateSoap soapModel) {
        FileTemplate model = new FileTemplateImpl();

        model.setFileTemplateId(soapModel.getFileTemplateId());
        model.setTemplateId(soapModel.getTemplateId());
        model.setTenFile(soapModel.getTenFile());
        model.setKichThuoc(soapModel.getKichThuoc());
        model.setDuongDan(soapModel.getDuongDan());

        return model;
    }

    public static List<FileTemplate> toModels(FileTemplateSoap[] soapModels) {
        List<FileTemplate> models = new ArrayList<FileTemplate>(soapModels.length);

        for (FileTemplateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _fileTemplateId;
    }

    public void setPrimaryKey(long pk) {
        setFileTemplateId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_fileTemplateId);
    }

    public long getFileTemplateId() {
        return _fileTemplateId;
    }

    public void setFileTemplateId(long fileTemplateId) {
        if (fileTemplateId != _fileTemplateId) {
            _fileTemplateId = fileTemplateId;
        }
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        if (templateId != _templateId) {
            _templateId = templateId;
        }
    }

    public String getTenFile() {
        return GetterUtil.getString(_tenFile);
    }

    public void setTenFile(String tenFile) {
        if (((tenFile == null) && (_tenFile != null)) ||
                ((tenFile != null) && (_tenFile == null)) ||
                ((tenFile != null) && (_tenFile != null) &&
                !tenFile.equals(_tenFile))) {
            _tenFile = tenFile;
        }
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        if (kichThuoc != _kichThuoc) {
            _kichThuoc = kichThuoc;
        }
    }

    public String getDuongDan() {
        return GetterUtil.getString(_duongDan);
    }

    public void setDuongDan(String duongDan) {
        if (((duongDan == null) && (_duongDan != null)) ||
                ((duongDan != null) && (_duongDan == null)) ||
                ((duongDan != null) && (_duongDan != null) &&
                !duongDan.equals(_duongDan))) {
            _duongDan = duongDan;
        }
    }

    public FileTemplate toEscapedModel() {
        if (isEscapedModel()) {
            return (FileTemplate) this;
        } else {
            FileTemplate model = new FileTemplateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileTemplateId(getFileTemplateId());
            model.setTemplateId(getTemplateId());
            model.setTenFile(HtmlUtil.escape(getTenFile()));
            model.setKichThuoc(getKichThuoc());
            model.setDuongDan(HtmlUtil.escape(getDuongDan()));

            model = (FileTemplate) Proxy.newProxyInstance(FileTemplate.class.getClassLoader(),
                    new Class[] { FileTemplate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        FileTemplateImpl clone = new FileTemplateImpl();

        clone.setFileTemplateId(getFileTemplateId());
        clone.setTemplateId(getTemplateId());
        clone.setTenFile(getTenFile());
        clone.setKichThuoc(getKichThuoc());
        clone.setDuongDan(getDuongDan());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        FileTemplateImpl fileTemplate = (FileTemplateImpl) obj;

        long pk = fileTemplate.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        FileTemplateImpl fileTemplate = null;

        try {
            fileTemplate = (FileTemplateImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = fileTemplate.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
