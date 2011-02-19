package com.sgs.portlet.vanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LogVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LogVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBoModel
 * @see com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoImpl
 *
 */
public class LogVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_log_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "logVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "buocLuanChuyen", new Integer(Types.INTEGER) },
            

            { "nguoiXuLy", new Integer(Types.BIGINT) },
            

            { "ngayXuLy", new Integer(Types.TIMESTAMP) },
            

            { "nguoiNhan", new Integer(Types.BIGINT) },
            

            { "ngayNhan", new Integer(Types.TIMESTAMP) },
            

            { "trangThaiTruoc", new Integer(Types.VARCHAR) },
            

            { "trangThaiSau", new Integer(Types.VARCHAR) },
            

            { "ngayGui", new Integer(Types.TIMESTAMP) },
            

            { "phongXuLyChinh", new Integer(Types.VARCHAR) },
            

            { "nguoiXuLyChinh", new Integer(Types.BIGINT) },
            

            { "loaiQuyTrinh", new Integer(Types.INTEGER) },
            

            { "ngayHetHan", new Integer(Types.TIMESTAMP) },
            

            { "soNgayXuLy", new Integer(Types.INTEGER) },
            

            { "processInstanceId", new Integer(Types.BIGINT) },
            

            { "thongTinXuLy", new Integer(Types.VARCHAR) },
            

            { "step", new Integer(Types.INTEGER) },
            

            { "nguoiXuLyTrucTiep", new Integer(Types.BIGINT) },
            

            { "phongXuLy", new Integer(Types.VARCHAR) },
            

            { "phongNhan", new Integer(Types.VARCHAR) },
            

            { "vanBanHoanThanhHayChua", new Integer(Types.BOOLEAN) },
            

            { "vanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_log_vanbannoibo (logVanBanNoiBoId LONG not null primary key,buocLuanChuyen INTEGER,nguoiXuLy LONG,ngayXuLy DATE null,nguoiNhan LONG,ngayNhan DATE null,trangThaiTruoc VARCHAR(75) null,trangThaiSau VARCHAR(75) null,ngayGui DATE null,phongXuLyChinh VARCHAR(75) null,nguoiXuLyChinh LONG,loaiQuyTrinh INTEGER,ngayHetHan DATE null,soNgayXuLy INTEGER,processInstanceId LONG,thongTinXuLy VARCHAR(75) null,step INTEGER,nguoiXuLyTrucTiep LONG,phongXuLy VARCHAR(75) null,phongNhan VARCHAR(75) null,vanBanHoanThanhHayChua BOOLEAN,vanBanNoiBoId LONG,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_log_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo"));
    private long _logVanBanNoiBoId;
    private int _buocLuanChuyen;
    private long _nguoiXuLy;
    private Date _ngayXuLy;
    private long _nguoiNhan;
    private Date _ngayNhan;
    private String _trangThaiTruoc;
    private String _trangThaiSau;
    private Date _ngayGui;
    private String _phongXuLyChinh;
    private long _nguoiXuLyChinh;
    private int _loaiQuyTrinh;
    private Date _ngayHetHan;
    private int _soNgayXuLy;
    private long _processInstanceId;
    private String _thongTinXuLy;
    private int _step;
    private long _nguoiXuLyTrucTiep;
    private String _phongXuLy;
    private String _phongNhan;
    private boolean _vanBanHoanThanhHayChua;
    private long _vanBanNoiBoId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public LogVanBanNoiBoModelImpl() {
    }

    public static LogVanBanNoiBo toModel(LogVanBanNoiBoSoap soapModel) {
        LogVanBanNoiBo model = new LogVanBanNoiBoImpl();

        model.setLogVanBanNoiBoId(soapModel.getLogVanBanNoiBoId());
        model.setBuocLuanChuyen(soapModel.getBuocLuanChuyen());
        model.setNguoiXuLy(soapModel.getNguoiXuLy());
        model.setNgayXuLy(soapModel.getNgayXuLy());
        model.setNguoiNhan(soapModel.getNguoiNhan());
        model.setNgayNhan(soapModel.getNgayNhan());
        model.setTrangThaiTruoc(soapModel.getTrangThaiTruoc());
        model.setTrangThaiSau(soapModel.getTrangThaiSau());
        model.setNgayGui(soapModel.getNgayGui());
        model.setPhongXuLyChinh(soapModel.getPhongXuLyChinh());
        model.setNguoiXuLyChinh(soapModel.getNguoiXuLyChinh());
        model.setLoaiQuyTrinh(soapModel.getLoaiQuyTrinh());
        model.setNgayHetHan(soapModel.getNgayHetHan());
        model.setSoNgayXuLy(soapModel.getSoNgayXuLy());
        model.setProcessInstanceId(soapModel.getProcessInstanceId());
        model.setThongTinXuLy(soapModel.getThongTinXuLy());
        model.setStep(soapModel.getStep());
        model.setNguoiXuLyTrucTiep(soapModel.getNguoiXuLyTrucTiep());
        model.setPhongXuLy(soapModel.getPhongXuLy());
        model.setPhongNhan(soapModel.getPhongNhan());
        model.setVanBanHoanThanhHayChua(soapModel.getVanBanHoanThanhHayChua());
        model.setVanBanNoiBoId(soapModel.getVanBanNoiBoId());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<LogVanBanNoiBo> toModels(LogVanBanNoiBoSoap[] soapModels) {
        List<LogVanBanNoiBo> models = new ArrayList<LogVanBanNoiBo>(soapModels.length);

        for (LogVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _logVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setLogVanBanNoiBoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_logVanBanNoiBoId);
    }

    public long getLogVanBanNoiBoId() {
        return _logVanBanNoiBoId;
    }

    public void setLogVanBanNoiBoId(long logVanBanNoiBoId) {
        if (logVanBanNoiBoId != _logVanBanNoiBoId) {
            _logVanBanNoiBoId = logVanBanNoiBoId;
        }
    }

    public int getBuocLuanChuyen() {
        return _buocLuanChuyen;
    }

    public void setBuocLuanChuyen(int buocLuanChuyen) {
        if (buocLuanChuyen != _buocLuanChuyen) {
            _buocLuanChuyen = buocLuanChuyen;
        }
    }

    public long getNguoiXuLy() {
        return _nguoiXuLy;
    }

    public void setNguoiXuLy(long nguoiXuLy) {
        if (nguoiXuLy != _nguoiXuLy) {
            _nguoiXuLy = nguoiXuLy;
        }
    }

    public Date getNgayXuLy() {
        return _ngayXuLy;
    }

    public void setNgayXuLy(Date ngayXuLy) {
        if (((ngayXuLy == null) && (_ngayXuLy != null)) ||
                ((ngayXuLy != null) && (_ngayXuLy == null)) ||
                ((ngayXuLy != null) && (_ngayXuLy != null) &&
                !ngayXuLy.equals(_ngayXuLy))) {
            _ngayXuLy = ngayXuLy;
        }
    }

    public long getNguoiNhan() {
        return _nguoiNhan;
    }

    public void setNguoiNhan(long nguoiNhan) {
        if (nguoiNhan != _nguoiNhan) {
            _nguoiNhan = nguoiNhan;
        }
    }

    public Date getNgayNhan() {
        return _ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        if (((ngayNhan == null) && (_ngayNhan != null)) ||
                ((ngayNhan != null) && (_ngayNhan == null)) ||
                ((ngayNhan != null) && (_ngayNhan != null) &&
                !ngayNhan.equals(_ngayNhan))) {
            _ngayNhan = ngayNhan;
        }
    }

    public String getTrangThaiTruoc() {
        return GetterUtil.getString(_trangThaiTruoc);
    }

    public void setTrangThaiTruoc(String trangThaiTruoc) {
        if (((trangThaiTruoc == null) && (_trangThaiTruoc != null)) ||
                ((trangThaiTruoc != null) && (_trangThaiTruoc == null)) ||
                ((trangThaiTruoc != null) && (_trangThaiTruoc != null) &&
                !trangThaiTruoc.equals(_trangThaiTruoc))) {
            _trangThaiTruoc = trangThaiTruoc;
        }
    }

    public String getTrangThaiSau() {
        return GetterUtil.getString(_trangThaiSau);
    }

    public void setTrangThaiSau(String trangThaiSau) {
        if (((trangThaiSau == null) && (_trangThaiSau != null)) ||
                ((trangThaiSau != null) && (_trangThaiSau == null)) ||
                ((trangThaiSau != null) && (_trangThaiSau != null) &&
                !trangThaiSau.equals(_trangThaiSau))) {
            _trangThaiSau = trangThaiSau;
        }
    }

    public Date getNgayGui() {
        return _ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        if (((ngayGui == null) && (_ngayGui != null)) ||
                ((ngayGui != null) && (_ngayGui == null)) ||
                ((ngayGui != null) && (_ngayGui != null) &&
                !ngayGui.equals(_ngayGui))) {
            _ngayGui = ngayGui;
        }
    }

    public String getPhongXuLyChinh() {
        return GetterUtil.getString(_phongXuLyChinh);
    }

    public void setPhongXuLyChinh(String phongXuLyChinh) {
        if (((phongXuLyChinh == null) && (_phongXuLyChinh != null)) ||
                ((phongXuLyChinh != null) && (_phongXuLyChinh == null)) ||
                ((phongXuLyChinh != null) && (_phongXuLyChinh != null) &&
                !phongXuLyChinh.equals(_phongXuLyChinh))) {
            _phongXuLyChinh = phongXuLyChinh;
        }
    }

    public long getNguoiXuLyChinh() {
        return _nguoiXuLyChinh;
    }

    public void setNguoiXuLyChinh(long nguoiXuLyChinh) {
        if (nguoiXuLyChinh != _nguoiXuLyChinh) {
            _nguoiXuLyChinh = nguoiXuLyChinh;
        }
    }

    public int getLoaiQuyTrinh() {
        return _loaiQuyTrinh;
    }

    public void setLoaiQuyTrinh(int loaiQuyTrinh) {
        if (loaiQuyTrinh != _loaiQuyTrinh) {
            _loaiQuyTrinh = loaiQuyTrinh;
        }
    }

    public Date getNgayHetHan() {
        return _ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (((ngayHetHan == null) && (_ngayHetHan != null)) ||
                ((ngayHetHan != null) && (_ngayHetHan == null)) ||
                ((ngayHetHan != null) && (_ngayHetHan != null) &&
                !ngayHetHan.equals(_ngayHetHan))) {
            _ngayHetHan = ngayHetHan;
        }
    }

    public int getSoNgayXuLy() {
        return _soNgayXuLy;
    }

    public void setSoNgayXuLy(int soNgayXuLy) {
        if (soNgayXuLy != _soNgayXuLy) {
            _soNgayXuLy = soNgayXuLy;
        }
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        if (processInstanceId != _processInstanceId) {
            _processInstanceId = processInstanceId;
        }
    }

    public String getThongTinXuLy() {
        return GetterUtil.getString(_thongTinXuLy);
    }

    public void setThongTinXuLy(String thongTinXuLy) {
        if (((thongTinXuLy == null) && (_thongTinXuLy != null)) ||
                ((thongTinXuLy != null) && (_thongTinXuLy == null)) ||
                ((thongTinXuLy != null) && (_thongTinXuLy != null) &&
                !thongTinXuLy.equals(_thongTinXuLy))) {
            _thongTinXuLy = thongTinXuLy;
        }
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        if (step != _step) {
            _step = step;
        }
    }

    public long getNguoiXuLyTrucTiep() {
        return _nguoiXuLyTrucTiep;
    }

    public void setNguoiXuLyTrucTiep(long nguoiXuLyTrucTiep) {
        if (nguoiXuLyTrucTiep != _nguoiXuLyTrucTiep) {
            _nguoiXuLyTrucTiep = nguoiXuLyTrucTiep;
        }
    }

    public String getPhongXuLy() {
        return GetterUtil.getString(_phongXuLy);
    }

    public void setPhongXuLy(String phongXuLy) {
        if (((phongXuLy == null) && (_phongXuLy != null)) ||
                ((phongXuLy != null) && (_phongXuLy == null)) ||
                ((phongXuLy != null) && (_phongXuLy != null) &&
                !phongXuLy.equals(_phongXuLy))) {
            _phongXuLy = phongXuLy;
        }
    }

    public String getPhongNhan() {
        return GetterUtil.getString(_phongNhan);
    }

    public void setPhongNhan(String phongNhan) {
        if (((phongNhan == null) && (_phongNhan != null)) ||
                ((phongNhan != null) && (_phongNhan == null)) ||
                ((phongNhan != null) && (_phongNhan != null) &&
                !phongNhan.equals(_phongNhan))) {
            _phongNhan = phongNhan;
        }
    }

    public boolean getVanBanHoanThanhHayChua() {
        return _vanBanHoanThanhHayChua;
    }

    public boolean isVanBanHoanThanhHayChua() {
        return _vanBanHoanThanhHayChua;
    }

    public void setVanBanHoanThanhHayChua(boolean vanBanHoanThanhHayChua) {
        if (vanBanHoanThanhHayChua != _vanBanHoanThanhHayChua) {
            _vanBanHoanThanhHayChua = vanBanHoanThanhHayChua;
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

    public LogVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (LogVanBanNoiBo) this;
        } else {
            LogVanBanNoiBo model = new LogVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLogVanBanNoiBoId(getLogVanBanNoiBoId());
            model.setBuocLuanChuyen(getBuocLuanChuyen());
            model.setNguoiXuLy(getNguoiXuLy());
            model.setNgayXuLy(getNgayXuLy());
            model.setNguoiNhan(getNguoiNhan());
            model.setNgayNhan(getNgayNhan());
            model.setTrangThaiTruoc(HtmlUtil.escape(getTrangThaiTruoc()));
            model.setTrangThaiSau(HtmlUtil.escape(getTrangThaiSau()));
            model.setNgayGui(getNgayGui());
            model.setPhongXuLyChinh(HtmlUtil.escape(getPhongXuLyChinh()));
            model.setNguoiXuLyChinh(getNguoiXuLyChinh());
            model.setLoaiQuyTrinh(getLoaiQuyTrinh());
            model.setNgayHetHan(getNgayHetHan());
            model.setSoNgayXuLy(getSoNgayXuLy());
            model.setProcessInstanceId(getProcessInstanceId());
            model.setThongTinXuLy(HtmlUtil.escape(getThongTinXuLy()));
            model.setStep(getStep());
            model.setNguoiXuLyTrucTiep(getNguoiXuLyTrucTiep());
            model.setPhongXuLy(HtmlUtil.escape(getPhongXuLy()));
            model.setPhongNhan(HtmlUtil.escape(getPhongNhan()));
            model.setVanBanHoanThanhHayChua(getVanBanHoanThanhHayChua());
            model.setVanBanNoiBoId(getVanBanNoiBoId());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (LogVanBanNoiBo) Proxy.newProxyInstance(LogVanBanNoiBo.class.getClassLoader(),
                    new Class[] { LogVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        LogVanBanNoiBoImpl clone = new LogVanBanNoiBoImpl();

        clone.setLogVanBanNoiBoId(getLogVanBanNoiBoId());
        clone.setBuocLuanChuyen(getBuocLuanChuyen());
        clone.setNguoiXuLy(getNguoiXuLy());
        clone.setNgayXuLy(getNgayXuLy());
        clone.setNguoiNhan(getNguoiNhan());
        clone.setNgayNhan(getNgayNhan());
        clone.setTrangThaiTruoc(getTrangThaiTruoc());
        clone.setTrangThaiSau(getTrangThaiSau());
        clone.setNgayGui(getNgayGui());
        clone.setPhongXuLyChinh(getPhongXuLyChinh());
        clone.setNguoiXuLyChinh(getNguoiXuLyChinh());
        clone.setLoaiQuyTrinh(getLoaiQuyTrinh());
        clone.setNgayHetHan(getNgayHetHan());
        clone.setSoNgayXuLy(getSoNgayXuLy());
        clone.setProcessInstanceId(getProcessInstanceId());
        clone.setThongTinXuLy(getThongTinXuLy());
        clone.setStep(getStep());
        clone.setNguoiXuLyTrucTiep(getNguoiXuLyTrucTiep());
        clone.setPhongXuLy(getPhongXuLy());
        clone.setPhongNhan(getPhongNhan());
        clone.setVanBanHoanThanhHayChua(getVanBanHoanThanhHayChua());
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

        LogVanBanNoiBoImpl logVanBanNoiBo = (LogVanBanNoiBoImpl) obj;

        long pk = logVanBanNoiBo.getPrimaryKey();

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

        LogVanBanNoiBoImpl logVanBanNoiBo = null;

        try {
            logVanBanNoiBo = (LogVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = logVanBanNoiBo.getPrimaryKey();

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
