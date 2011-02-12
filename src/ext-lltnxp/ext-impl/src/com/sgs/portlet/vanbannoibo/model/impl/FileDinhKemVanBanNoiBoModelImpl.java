package com.sgs.portlet.vanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="FileDinhKemVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>FileDinhKemVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBoModel
 * @see com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoImpl
 *
 */
public class FileDinhKemVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_file_dinh_kem_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileDinhKemVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "tenFileFull", new Integer(Types.VARCHAR) },
            

            { "tenFile", new Integer(Types.VARCHAR) },
            

            { "duongDanFile", new Integer(Types.VARCHAR) },
            

            { "tieuDe", new Integer(Types.VARCHAR) },
            

            { "ngayTao", new Integer(Types.TIMESTAMP) },
            

            { "loaiFile", new Integer(Types.VARCHAR) },
            

            { "mucDichFile", new Integer(Types.VARCHAR) },
            

            { "vanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_file_dinh_kem_vanbannoibo (fileDinhKemVanBanNoiBoId LONG not null primary key,tenFileFull VARCHAR(75) null,tenFile VARCHAR(75) null,duongDanFile VARCHAR(75) null,tieuDe VARCHAR(75) null,ngayTao DATE null,loaiFile VARCHAR(75) null,mucDichFile VARCHAR(75) null,vanBanNoiBoId LONG,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_file_dinh_kem_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo"));
    private long _fileDinhKemVanBanNoiBoId;
    private String _tenFileFull;
    private String _tenFile;
    private String _duongDanFile;
    private String _tieuDe;
    private Date _ngayTao;
    private String _loaiFile;
    private String _mucDichFile;
    private long _vanBanNoiBoId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public FileDinhKemVanBanNoiBoModelImpl() {
    }

    public static FileDinhKemVanBanNoiBo toModel(
        FileDinhKemVanBanNoiBoSoap soapModel) {
        FileDinhKemVanBanNoiBo model = new FileDinhKemVanBanNoiBoImpl();

        model.setFileDinhKemVanBanNoiBoId(soapModel.getFileDinhKemVanBanNoiBoId());
        model.setTenFileFull(soapModel.getTenFileFull());
        model.setTenFile(soapModel.getTenFile());
        model.setDuongDanFile(soapModel.getDuongDanFile());
        model.setTieuDe(soapModel.getTieuDe());
        model.setNgayTao(soapModel.getNgayTao());
        model.setLoaiFile(soapModel.getLoaiFile());
        model.setMucDichFile(soapModel.getMucDichFile());
        model.setVanBanNoiBoId(soapModel.getVanBanNoiBoId());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<FileDinhKemVanBanNoiBo> toModels(
        FileDinhKemVanBanNoiBoSoap[] soapModels) {
        List<FileDinhKemVanBanNoiBo> models = new ArrayList<FileDinhKemVanBanNoiBo>(soapModels.length);

        for (FileDinhKemVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _fileDinhKemVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setFileDinhKemVanBanNoiBoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_fileDinhKemVanBanNoiBoId);
    }

    public long getFileDinhKemVanBanNoiBoId() {
        return _fileDinhKemVanBanNoiBoId;
    }

    public void setFileDinhKemVanBanNoiBoId(long fileDinhKemVanBanNoiBoId) {
        if (fileDinhKemVanBanNoiBoId != _fileDinhKemVanBanNoiBoId) {
            _fileDinhKemVanBanNoiBoId = fileDinhKemVanBanNoiBoId;
        }
    }

    public String getTenFileFull() {
        return GetterUtil.getString(_tenFileFull);
    }

    public void setTenFileFull(String tenFileFull) {
        if (((tenFileFull == null) && (_tenFileFull != null)) ||
                ((tenFileFull != null) && (_tenFileFull == null)) ||
                ((tenFileFull != null) && (_tenFileFull != null) &&
                !tenFileFull.equals(_tenFileFull))) {
            _tenFileFull = tenFileFull;
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

    public String getDuongDanFile() {
        return GetterUtil.getString(_duongDanFile);
    }

    public void setDuongDanFile(String duongDanFile) {
        if (((duongDanFile == null) && (_duongDanFile != null)) ||
                ((duongDanFile != null) && (_duongDanFile == null)) ||
                ((duongDanFile != null) && (_duongDanFile != null) &&
                !duongDanFile.equals(_duongDanFile))) {
            _duongDanFile = duongDanFile;
        }
    }

    public String getTieuDe() {
        return GetterUtil.getString(_tieuDe);
    }

    public void setTieuDe(String tieuDe) {
        if (((tieuDe == null) && (_tieuDe != null)) ||
                ((tieuDe != null) && (_tieuDe == null)) ||
                ((tieuDe != null) && (_tieuDe != null) &&
                !tieuDe.equals(_tieuDe))) {
            _tieuDe = tieuDe;
        }
    }

    public Date getNgayTao() {
        return _ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        if (((ngayTao == null) && (_ngayTao != null)) ||
                ((ngayTao != null) && (_ngayTao == null)) ||
                ((ngayTao != null) && (_ngayTao != null) &&
                !ngayTao.equals(_ngayTao))) {
            _ngayTao = ngayTao;
        }
    }

    public String getLoaiFile() {
        return GetterUtil.getString(_loaiFile);
    }

    public void setLoaiFile(String loaiFile) {
        if (((loaiFile == null) && (_loaiFile != null)) ||
                ((loaiFile != null) && (_loaiFile == null)) ||
                ((loaiFile != null) && (_loaiFile != null) &&
                !loaiFile.equals(_loaiFile))) {
            _loaiFile = loaiFile;
        }
    }

    public String getMucDichFile() {
        return GetterUtil.getString(_mucDichFile);
    }

    public void setMucDichFile(String mucDichFile) {
        if (((mucDichFile == null) && (_mucDichFile != null)) ||
                ((mucDichFile != null) && (_mucDichFile == null)) ||
                ((mucDichFile != null) && (_mucDichFile != null) &&
                !mucDichFile.equals(_mucDichFile))) {
            _mucDichFile = mucDichFile;
        }
    }

    public long getVanBanNoiBoId() {
        return _vanBanNoiBoId;
    }

    public void setVanBanNoiBoId(long vanBanNoiBoId) {
        if (vanBanNoiBoId != _vanBanNoiBoId) {
            _vanBanNoiBoId = vanBanNoiBoId;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public FileDinhKemVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (FileDinhKemVanBanNoiBo) this;
        } else {
            FileDinhKemVanBanNoiBo model = new FileDinhKemVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileDinhKemVanBanNoiBoId(getFileDinhKemVanBanNoiBoId());
            model.setTenFileFull(HtmlUtil.escape(getTenFileFull()));
            model.setTenFile(HtmlUtil.escape(getTenFile()));
            model.setDuongDanFile(HtmlUtil.escape(getDuongDanFile()));
            model.setTieuDe(HtmlUtil.escape(getTieuDe()));
            model.setNgayTao(getNgayTao());
            model.setLoaiFile(HtmlUtil.escape(getLoaiFile()));
            model.setMucDichFile(HtmlUtil.escape(getMucDichFile()));
            model.setVanBanNoiBoId(getVanBanNoiBoId());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (FileDinhKemVanBanNoiBo) Proxy.newProxyInstance(FileDinhKemVanBanNoiBo.class.getClassLoader(),
                    new Class[] { FileDinhKemVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        FileDinhKemVanBanNoiBoImpl clone = new FileDinhKemVanBanNoiBoImpl();

        clone.setFileDinhKemVanBanNoiBoId(getFileDinhKemVanBanNoiBoId());
        clone.setTenFileFull(getTenFileFull());
        clone.setTenFile(getTenFile());
        clone.setDuongDanFile(getDuongDanFile());
        clone.setTieuDe(getTieuDe());
        clone.setNgayTao(getNgayTao());
        clone.setLoaiFile(getLoaiFile());
        clone.setMucDichFile(getMucDichFile());
        clone.setVanBanNoiBoId(getVanBanNoiBoId());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        FileDinhKemVanBanNoiBoImpl fileDinhKemVanBanNoiBo = (FileDinhKemVanBanNoiBoImpl) obj;

        long pk = fileDinhKemVanBanNoiBo.getPrimaryKey();

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

        FileDinhKemVanBanNoiBoImpl fileDinhKemVanBanNoiBo = null;

        try {
            fileDinhKemVanBanNoiBo = (FileDinhKemVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = fileDinhKemVanBanNoiBo.getPrimaryKey();

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
