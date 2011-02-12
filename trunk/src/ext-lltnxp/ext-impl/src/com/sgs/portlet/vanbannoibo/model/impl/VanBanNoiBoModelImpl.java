package com.sgs.portlet.vanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>VanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.VanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.VanBanNoiBoModel
 * @see com.sgs.portlet.vanbannoibo.model.impl.VanBanNoiBoImpl
 *
 */
public class VanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "vanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "loaiVanBanNoiBo", new Integer(Types.BIGINT) },
            

            { "ngayTao", new Integer(Types.TIMESTAMP) },
            

            { "ngayKy", new Integer(Types.TIMESTAMP) },
            

            { "trichYeu", new Integer(Types.VARCHAR) },
            

            { "nguoiKy", new Integer(Types.BIGINT) },
            

            { "ghiChu", new Integer(Types.VARCHAR) },
            

            { "soVanBanNoiBo", new Integer(Types.VARCHAR) },
            

            { "soPhatSinhTheoNam", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_vanbannoibo (vanBanNoiBoId LONG not null primary key,loaiVanBanNoiBo LONG,ngayTao DATE null,ngayKy DATE null,trichYeu VARCHAR(75) null,nguoiKy LONG,ghiChu VARCHAR(75) null,soVanBanNoiBo VARCHAR(75) null,soPhatSinhTheoNam VARCHAR(75) null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.vanbannoibo.model.VanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.vanbannoibo.model.VanBanNoiBo"));
    private long _vanBanNoiBoId;
    private long _loaiVanBanNoiBo;
    private Date _ngayTao;
    private Date _ngayKy;
    private String _trichYeu;
    private long _nguoiKy;
    private String _ghiChu;
    private String _soVanBanNoiBo;
    private String _soPhatSinhTheoNam;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public VanBanNoiBoModelImpl() {
    }

    public static VanBanNoiBo toModel(VanBanNoiBoSoap soapModel) {
        VanBanNoiBo model = new VanBanNoiBoImpl();

        model.setVanBanNoiBoId(soapModel.getVanBanNoiBoId());
        model.setLoaiVanBanNoiBo(soapModel.getLoaiVanBanNoiBo());
        model.setNgayTao(soapModel.getNgayTao());
        model.setNgayKy(soapModel.getNgayKy());
        model.setTrichYeu(soapModel.getTrichYeu());
        model.setNguoiKy(soapModel.getNguoiKy());
        model.setGhiChu(soapModel.getGhiChu());
        model.setSoVanBanNoiBo(soapModel.getSoVanBanNoiBo());
        model.setSoPhatSinhTheoNam(soapModel.getSoPhatSinhTheoNam());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<VanBanNoiBo> toModels(VanBanNoiBoSoap[] soapModels) {
        List<VanBanNoiBo> models = new ArrayList<VanBanNoiBo>(soapModels.length);

        for (VanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _vanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setVanBanNoiBoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_vanBanNoiBoId);
    }

    public long getVanBanNoiBoId() {
        return _vanBanNoiBoId;
    }

    public void setVanBanNoiBoId(long vanBanNoiBoId) {
        if (vanBanNoiBoId != _vanBanNoiBoId) {
            _vanBanNoiBoId = vanBanNoiBoId;
        }
    }

    public long getLoaiVanBanNoiBo() {
        return _loaiVanBanNoiBo;
    }

    public void setLoaiVanBanNoiBo(long loaiVanBanNoiBo) {
        if (loaiVanBanNoiBo != _loaiVanBanNoiBo) {
            _loaiVanBanNoiBo = loaiVanBanNoiBo;
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

    public Date getNgayKy() {
        return _ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        if (((ngayKy == null) && (_ngayKy != null)) ||
                ((ngayKy != null) && (_ngayKy == null)) ||
                ((ngayKy != null) && (_ngayKy != null) &&
                !ngayKy.equals(_ngayKy))) {
            _ngayKy = ngayKy;
        }
    }

    public String getTrichYeu() {
        return GetterUtil.getString(_trichYeu);
    }

    public void setTrichYeu(String trichYeu) {
        if (((trichYeu == null) && (_trichYeu != null)) ||
                ((trichYeu != null) && (_trichYeu == null)) ||
                ((trichYeu != null) && (_trichYeu != null) &&
                !trichYeu.equals(_trichYeu))) {
            _trichYeu = trichYeu;
        }
    }

    public long getNguoiKy() {
        return _nguoiKy;
    }

    public void setNguoiKy(long nguoiKy) {
        if (nguoiKy != _nguoiKy) {
            _nguoiKy = nguoiKy;
        }
    }

    public String getGhiChu() {
        return GetterUtil.getString(_ghiChu);
    }

    public void setGhiChu(String ghiChu) {
        if (((ghiChu == null) && (_ghiChu != null)) ||
                ((ghiChu != null) && (_ghiChu == null)) ||
                ((ghiChu != null) && (_ghiChu != null) &&
                !ghiChu.equals(_ghiChu))) {
            _ghiChu = ghiChu;
        }
    }

    public String getSoVanBanNoiBo() {
        return GetterUtil.getString(_soVanBanNoiBo);
    }

    public void setSoVanBanNoiBo(String soVanBanNoiBo) {
        if (((soVanBanNoiBo == null) && (_soVanBanNoiBo != null)) ||
                ((soVanBanNoiBo != null) && (_soVanBanNoiBo == null)) ||
                ((soVanBanNoiBo != null) && (_soVanBanNoiBo != null) &&
                !soVanBanNoiBo.equals(_soVanBanNoiBo))) {
            _soVanBanNoiBo = soVanBanNoiBo;
        }
    }

    public String getSoPhatSinhTheoNam() {
        return GetterUtil.getString(_soPhatSinhTheoNam);
    }

    public void setSoPhatSinhTheoNam(String soPhatSinhTheoNam) {
        if (((soPhatSinhTheoNam == null) && (_soPhatSinhTheoNam != null)) ||
                ((soPhatSinhTheoNam != null) && (_soPhatSinhTheoNam == null)) ||
                ((soPhatSinhTheoNam != null) && (_soPhatSinhTheoNam != null) &&
                !soPhatSinhTheoNam.equals(_soPhatSinhTheoNam))) {
            _soPhatSinhTheoNam = soPhatSinhTheoNam;
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

    public VanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (VanBanNoiBo) this;
        } else {
            VanBanNoiBo model = new VanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setVanBanNoiBoId(getVanBanNoiBoId());
            model.setLoaiVanBanNoiBo(getLoaiVanBanNoiBo());
            model.setNgayTao(getNgayTao());
            model.setNgayKy(getNgayKy());
            model.setTrichYeu(HtmlUtil.escape(getTrichYeu()));
            model.setNguoiKy(getNguoiKy());
            model.setGhiChu(HtmlUtil.escape(getGhiChu()));
            model.setSoVanBanNoiBo(HtmlUtil.escape(getSoVanBanNoiBo()));
            model.setSoPhatSinhTheoNam(HtmlUtil.escape(getSoPhatSinhTheoNam()));
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (VanBanNoiBo) Proxy.newProxyInstance(VanBanNoiBo.class.getClassLoader(),
                    new Class[] { VanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        VanBanNoiBoImpl clone = new VanBanNoiBoImpl();

        clone.setVanBanNoiBoId(getVanBanNoiBoId());
        clone.setLoaiVanBanNoiBo(getLoaiVanBanNoiBo());
        clone.setNgayTao(getNgayTao());
        clone.setNgayKy(getNgayKy());
        clone.setTrichYeu(getTrichYeu());
        clone.setNguoiKy(getNguoiKy());
        clone.setGhiChu(getGhiChu());
        clone.setSoVanBanNoiBo(getSoVanBanNoiBo());
        clone.setSoPhatSinhTheoNam(getSoPhatSinhTheoNam());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        VanBanNoiBoImpl vanBanNoiBo = (VanBanNoiBoImpl) obj;

        long pk = vanBanNoiBo.getPrimaryKey();

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

        VanBanNoiBoImpl vanBanNoiBo = null;

        try {
            vanBanNoiBo = (VanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = vanBanNoiBo.getPrimaryKey();

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
