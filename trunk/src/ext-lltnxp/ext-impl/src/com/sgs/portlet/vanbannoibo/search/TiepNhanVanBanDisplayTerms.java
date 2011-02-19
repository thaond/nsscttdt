package com.sgs.portlet.vanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class TiepNhanVanBanDisplayTerms extends DisplayTerms{
	
	public static final String LOAIVANBANNOIBO = "loaiVanBanNoiBo";
	public static final String NGAYTAO = "ngayTao";
	public static final String NGAYKY = "ngayKy";
	public static final String TRICHYEU = "trichYeu";
	public static final String NGUOIKY = "nguoiKy";
	public static final String GHICHU = "ghiChu";
	public static final String SOVANBANNOIBO = "soVanBanNoiBo";
	public static final String SOPHATSINHTHEONAM = "soPhatSinhTheoNam";
	
	protected long loaiVanBanNoiBo;
	protected String ngayTao;
	protected String ngayKy;
	protected String trichYeu;
	protected long nguoiKy;
	protected String ghiChu;
	protected String soVanBanNoiBo;
	protected String soPhatSinhTheoNam;

	public TiepNhanVanBanDisplayTerms(RenderRequest req) {
		super(req);
		loaiVanBanNoiBo = ParamUtil.getLong(req, LOAIVANBANNOIBO);
		ngayTao = ParamUtil.getString(req, NGAYTAO);
		ngayKy = ParamUtil.getString(req, NGAYKY);
		trichYeu = ParamUtil.getString(req, TRICHYEU);	
		nguoiKy = ParamUtil.getLong(req, NGUOIKY);
		ghiChu = ParamUtil.getString(req, GHICHU);
		soVanBanNoiBo = ParamUtil.getString(req, SOVANBANNOIBO);
		soPhatSinhTheoNam = ParamUtil.getString(req, SOPHATSINHTHEONAM);
	}

	public long getLoaiVanBanNoiBo() {
		return loaiVanBanNoiBo;
	}

	public void setLoaiVanBanNoiBo(long loaiVanBanNoiBo) {
		this.loaiVanBanNoiBo = loaiVanBanNoiBo;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(String ngayKy) {
		this.ngayKy = ngayKy;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}

	public long getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(long nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getSoVanBanNoiBo() {
		return soVanBanNoiBo;
	}

	public void setSoVanBanNoiBo(String soVanBanNoiBo) {
		this.soVanBanNoiBo = soVanBanNoiBo;
	}

	public String getSoPhatSinhTheoNam() {
		return soPhatSinhTheoNam;
	}

	public void setSoPhatSinhTheoNam(String soPhatSinhTheoNam) {
		this.soPhatSinhTheoNam = soPhatSinhTheoNam;
	}
}
