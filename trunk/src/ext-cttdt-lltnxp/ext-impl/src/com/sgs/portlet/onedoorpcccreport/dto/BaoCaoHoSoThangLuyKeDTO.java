package com.sgs.portlet.onedoorpcccreport.dto;

import java.util.List;

public class BaoCaoHoSoThangLuyKeDTO {
	private String departmentId;
	private String tenPhongBan;
	private int tonDauKy;
	private int trongThangHoSoNhan;
	private int tongCong;
	private int trongNamHoSoNhan;
	private int trongThangHoSoGiaiQuyet;
	private int trongNamHoSoGiaiQuyet;
	private int hoSoTon;
	private String ghiChu;
	private List<LoaiHoSoDTO> loaiHoSoList;
	private boolean hasFile;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public int getTonDauKy() {
		return tonDauKy;
	}

	public void setTonDauKy(int tonDauKy) {
		this.tonDauKy = tonDauKy;
	}

	public int getTrongThangHoSoNhan() {
		return trongThangHoSoNhan;
	}

	public void setTrongThangHoSoNhan(int trongThangHoSoNhan) {
		this.trongThangHoSoNhan = trongThangHoSoNhan;
	}

	public int getTongCong() {
		return tongCong;
	}

	public void setTongCong(int tongCong) {
		this.tongCong = tongCong;
	}

	public int getTrongNamHoSoNhan() {
		return trongNamHoSoNhan;
	}

	public void setTrongNamHoSoNhan(int trongNamHoSoNhan) {
		this.trongNamHoSoNhan = trongNamHoSoNhan;
	}

	public int getTrongThangHoSoGiaiQuyet() {
		return trongThangHoSoGiaiQuyet;
	}

	public void setTrongThangHoSoGiaiQuyet(int trongThangHoSoGiaiQuyet) {
		this.trongThangHoSoGiaiQuyet = trongThangHoSoGiaiQuyet;
	}

	public int getTrongNamHoSoGiaiQuyet() {
		return trongNamHoSoGiaiQuyet;
	}

	public void setTrongNamHoSoGiaiQuyet(int trongNamHoSoGiaiQuyet) {
		this.trongNamHoSoGiaiQuyet = trongNamHoSoGiaiQuyet;
	}

	public int getHoSoTon() {
		return hoSoTon;
	}

	public void setHoSoTon(int hoSoTon) {
		this.hoSoTon = hoSoTon;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<LoaiHoSoDTO> getLoaiHoSoList() {
		return loaiHoSoList;
	}

	public void setLoaiHoSoList(List<LoaiHoSoDTO> loaiHoSoList) {
		this.loaiHoSoList = loaiHoSoList;
	}

	public boolean isHasFile() {
		return hasFile;
	}

	public void setHasFile(boolean hasFile) {
		this.hasFile = hasFile;
	}

}
