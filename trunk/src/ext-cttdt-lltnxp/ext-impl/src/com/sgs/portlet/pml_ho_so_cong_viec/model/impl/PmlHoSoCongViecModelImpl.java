package com.sgs.portlet.pml_ho_so_cong_viec.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViecSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHoSoCongViecModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlHoSoCongViec</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViecModel
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecImpl
 *
 */
public class PmlHoSoCongViecModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_ho_so_cong_viec";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_ho_so_cong_viec", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "id_hscv_cha", new Integer(Types.BIGINT) },
            

            { "so_hieu_hscv", new Integer(Types.VARCHAR) },
            

            { "tieu_de", new Integer(Types.VARCHAR) },
            

            { "ngay_mo_hscv", new Integer(Types.TIMESTAMP) },
            

            { "han_xu_ly", new Integer(Types.TIMESTAMP) },
            

            { "id_linh_vuc", new Integer(Types.VARCHAR) },
            

            { "van_de_lien_quan", new Integer(Types.VARCHAR) },
            

            { "id_do_quan_trong", new Integer(Types.BIGINT) },
            

            { "id_tinh_chat", new Integer(Types.BIGINT) },
            

            { "id_trang_thai_hscv", new Integer(Types.BIGINT) },
            

            { "tom_tat_noi_dung", new Integer(Types.VARCHAR) },
            

            { "hoat_dong", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_ho_so_cong_viec (id_ho_so_cong_viec LONG not null primary key,userId LONG,userName VARCHAR(75) null,id_hscv_cha LONG,so_hieu_hscv VARCHAR(75) null,tieu_de VARCHAR(75) null,ngay_mo_hscv DATE null,han_xu_ly DATE null,id_linh_vuc VARCHAR(75) null,van_de_lien_quan VARCHAR(75) null,id_do_quan_trong LONG,id_tinh_chat LONG,id_trang_thai_hscv LONG,tom_tat_noi_dung VARCHAR(75) null,hoat_dong VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_ho_so_cong_viec";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"));
    private long _idHoSoCongViec;
    private long _userId;
    private String _userName;
    private long _idHSCVCha;
    private String _soHieuHSCV;
    private String _tieuDe;
    private Date _ngayMoHSCV;
    private Date _hanXuLy;
    private String _idLinhVuc;
    private String _vanDeLienQuan;
    private long _idDoQuanTrong;
    private long _idTinhChat;
    private long _idTrangThaiHSCV;
    private String _tomTatNoiDung;
    private String _hoatDong;

    public PmlHoSoCongViecModelImpl() {
    }

    public static PmlHoSoCongViec toModel(PmlHoSoCongViecSoap soapModel) {
        PmlHoSoCongViec model = new PmlHoSoCongViecImpl();

        model.setIdHoSoCongViec(soapModel.getIdHoSoCongViec());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setIdHSCVCha(soapModel.getIdHSCVCha());
        model.setSoHieuHSCV(soapModel.getSoHieuHSCV());
        model.setTieuDe(soapModel.getTieuDe());
        model.setNgayMoHSCV(soapModel.getNgayMoHSCV());
        model.setHanXuLy(soapModel.getHanXuLy());
        model.setIdLinhVuc(soapModel.getIdLinhVuc());
        model.setVanDeLienQuan(soapModel.getVanDeLienQuan());
        model.setIdDoQuanTrong(soapModel.getIdDoQuanTrong());
        model.setIdTinhChat(soapModel.getIdTinhChat());
        model.setIdTrangThaiHSCV(soapModel.getIdTrangThaiHSCV());
        model.setTomTatNoiDung(soapModel.getTomTatNoiDung());
        model.setHoatDong(soapModel.getHoatDong());

        return model;
    }

    public static List<PmlHoSoCongViec> toModels(
        PmlHoSoCongViecSoap[] soapModels) {
        List<PmlHoSoCongViec> models = new ArrayList<PmlHoSoCongViec>(soapModels.length);

        for (PmlHoSoCongViecSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _idHoSoCongViec;
    }

    public void setPrimaryKey(long pk) {
        setIdHoSoCongViec(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_idHoSoCongViec);
    }

    public long getIdHoSoCongViec() {
        return _idHoSoCongViec;
    }

    public void setIdHoSoCongViec(long idHoSoCongViec) {
        if (idHoSoCongViec != _idHoSoCongViec) {
            _idHoSoCongViec = idHoSoCongViec;
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

    public String getUserName() {
        return GetterUtil.getString(_userName);
    }

    public void setUserName(String userName) {
        if (((userName == null) && (_userName != null)) ||
                ((userName != null) && (_userName == null)) ||
                ((userName != null) && (_userName != null) &&
                !userName.equals(_userName))) {
            _userName = userName;
        }
    }

    public long getIdHSCVCha() {
        return _idHSCVCha;
    }

    public void setIdHSCVCha(long idHSCVCha) {
        if (idHSCVCha != _idHSCVCha) {
            _idHSCVCha = idHSCVCha;
        }
    }

    public String getSoHieuHSCV() {
        return GetterUtil.getString(_soHieuHSCV);
    }

    public void setSoHieuHSCV(String soHieuHSCV) {
        if (((soHieuHSCV == null) && (_soHieuHSCV != null)) ||
                ((soHieuHSCV != null) && (_soHieuHSCV == null)) ||
                ((soHieuHSCV != null) && (_soHieuHSCV != null) &&
                !soHieuHSCV.equals(_soHieuHSCV))) {
            _soHieuHSCV = soHieuHSCV;
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

    public Date getNgayMoHSCV() {
        return _ngayMoHSCV;
    }

    public void setNgayMoHSCV(Date ngayMoHSCV) {
        if (((ngayMoHSCV == null) && (_ngayMoHSCV != null)) ||
                ((ngayMoHSCV != null) && (_ngayMoHSCV == null)) ||
                ((ngayMoHSCV != null) && (_ngayMoHSCV != null) &&
                !ngayMoHSCV.equals(_ngayMoHSCV))) {
            _ngayMoHSCV = ngayMoHSCV;
        }
    }

    public Date getHanXuLy() {
        return _hanXuLy;
    }

    public void setHanXuLy(Date hanXuLy) {
        if (((hanXuLy == null) && (_hanXuLy != null)) ||
                ((hanXuLy != null) && (_hanXuLy == null)) ||
                ((hanXuLy != null) && (_hanXuLy != null) &&
                !hanXuLy.equals(_hanXuLy))) {
            _hanXuLy = hanXuLy;
        }
    }

    public String getIdLinhVuc() {
        return GetterUtil.getString(_idLinhVuc);
    }

    public void setIdLinhVuc(String idLinhVuc) {
        if (((idLinhVuc == null) && (_idLinhVuc != null)) ||
                ((idLinhVuc != null) && (_idLinhVuc == null)) ||
                ((idLinhVuc != null) && (_idLinhVuc != null) &&
                !idLinhVuc.equals(_idLinhVuc))) {
            _idLinhVuc = idLinhVuc;
        }
    }

    public String getVanDeLienQuan() {
        return GetterUtil.getString(_vanDeLienQuan);
    }

    public void setVanDeLienQuan(String vanDeLienQuan) {
        if (((vanDeLienQuan == null) && (_vanDeLienQuan != null)) ||
                ((vanDeLienQuan != null) && (_vanDeLienQuan == null)) ||
                ((vanDeLienQuan != null) && (_vanDeLienQuan != null) &&
                !vanDeLienQuan.equals(_vanDeLienQuan))) {
            _vanDeLienQuan = vanDeLienQuan;
        }
    }

    public long getIdDoQuanTrong() {
        return _idDoQuanTrong;
    }

    public void setIdDoQuanTrong(long idDoQuanTrong) {
        if (idDoQuanTrong != _idDoQuanTrong) {
            _idDoQuanTrong = idDoQuanTrong;
        }
    }

    public long getIdTinhChat() {
        return _idTinhChat;
    }

    public void setIdTinhChat(long idTinhChat) {
        if (idTinhChat != _idTinhChat) {
            _idTinhChat = idTinhChat;
        }
    }

    public long getIdTrangThaiHSCV() {
        return _idTrangThaiHSCV;
    }

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
        if (idTrangThaiHSCV != _idTrangThaiHSCV) {
            _idTrangThaiHSCV = idTrangThaiHSCV;
        }
    }

    public String getTomTatNoiDung() {
        return GetterUtil.getString(_tomTatNoiDung);
    }

    public void setTomTatNoiDung(String tomTatNoiDung) {
        if (((tomTatNoiDung == null) && (_tomTatNoiDung != null)) ||
                ((tomTatNoiDung != null) && (_tomTatNoiDung == null)) ||
                ((tomTatNoiDung != null) && (_tomTatNoiDung != null) &&
                !tomTatNoiDung.equals(_tomTatNoiDung))) {
            _tomTatNoiDung = tomTatNoiDung;
        }
    }

    public String getHoatDong() {
        return GetterUtil.getString(_hoatDong);
    }

    public void setHoatDong(String hoatDong) {
        if (((hoatDong == null) && (_hoatDong != null)) ||
                ((hoatDong != null) && (_hoatDong == null)) ||
                ((hoatDong != null) && (_hoatDong != null) &&
                !hoatDong.equals(_hoatDong))) {
            _hoatDong = hoatDong;
        }
    }

    public PmlHoSoCongViec toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlHoSoCongViec) this;
        } else {
            PmlHoSoCongViec model = new PmlHoSoCongViecImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIdHoSoCongViec(getIdHoSoCongViec());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setIdHSCVCha(getIdHSCVCha());
            model.setSoHieuHSCV(HtmlUtil.escape(getSoHieuHSCV()));
            model.setTieuDe(HtmlUtil.escape(getTieuDe()));
            model.setNgayMoHSCV(getNgayMoHSCV());
            model.setHanXuLy(getHanXuLy());
            model.setIdLinhVuc(HtmlUtil.escape(getIdLinhVuc()));
            model.setVanDeLienQuan(HtmlUtil.escape(getVanDeLienQuan()));
            model.setIdDoQuanTrong(getIdDoQuanTrong());
            model.setIdTinhChat(getIdTinhChat());
            model.setIdTrangThaiHSCV(getIdTrangThaiHSCV());
            model.setTomTatNoiDung(HtmlUtil.escape(getTomTatNoiDung()));
            model.setHoatDong(HtmlUtil.escape(getHoatDong()));

            model = (PmlHoSoCongViec) Proxy.newProxyInstance(PmlHoSoCongViec.class.getClassLoader(),
                    new Class[] { PmlHoSoCongViec.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlHoSoCongViecImpl clone = new PmlHoSoCongViecImpl();

        clone.setIdHoSoCongViec(getIdHoSoCongViec());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setIdHSCVCha(getIdHSCVCha());
        clone.setSoHieuHSCV(getSoHieuHSCV());
        clone.setTieuDe(getTieuDe());
        clone.setNgayMoHSCV(getNgayMoHSCV());
        clone.setHanXuLy(getHanXuLy());
        clone.setIdLinhVuc(getIdLinhVuc());
        clone.setVanDeLienQuan(getVanDeLienQuan());
        clone.setIdDoQuanTrong(getIdDoQuanTrong());
        clone.setIdTinhChat(getIdTinhChat());
        clone.setIdTrangThaiHSCV(getIdTrangThaiHSCV());
        clone.setTomTatNoiDung(getTomTatNoiDung());
        clone.setHoatDong(getHoatDong());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlHoSoCongViecImpl pmlHoSoCongViec = (PmlHoSoCongViecImpl) obj;

        int value = 0;

        value = getTieuDe().toLowerCase()
                    .compareTo(pmlHoSoCongViec.getTieuDe().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlHoSoCongViecImpl pmlHoSoCongViec = null;

        try {
            pmlHoSoCongViec = (PmlHoSoCongViecImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlHoSoCongViec.getPrimaryKey();

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
