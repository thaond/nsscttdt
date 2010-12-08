package com.nss.portlet.onedoor.dto;

public class BaoCaoHoSoThangDTO {

	private String fileTypeId;
	private int stt;
	private String tenSanPham;
	private int tonDauKy;
	private int hoSoNhanTrongThang;
	private int tongCong;
	private int soDungHan;
	private int soTreHan;
	private int trongHan;
	private int daTreHan;
	private int chinhSuaBoSung;
	private String tyLeHoSoDungHan; // Tinh theo %
	private boolean hasFile;
	
	public BaoCaoHoSoThangDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(String fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getTonDauKy() {
		return tonDauKy;
	}

	public void setTonDauKy(int tonDauKy) {
		this.tonDauKy = tonDauKy;
	}

	public int getHoSoNhanTrongThang() {
		return hoSoNhanTrongThang;
	}

	public void setHoSoNhanTrongThang(int hoSoNhanTrongThang) {
		this.hoSoNhanTrongThang = hoSoNhanTrongThang;
	}

	public int getTongCong() {
		return tongCong;
	}

	public void setTongCong(int tongCong) {
		this.tongCong = tongCong;
	}

	public int getSoDungHan() {
		return soDungHan;
	}

	public void setSoDungHan(int soDungHan) {
		this.soDungHan = soDungHan;
	}

	public int getSoTreHan() {
		return soTreHan;
	}

	public void setSoTreHan(int soTreHan) {
		this.soTreHan = soTreHan;
	}

	public int getTrongHan() {
		return trongHan;
	}

	public void setTrongHan(int trongHan) {
		this.trongHan = trongHan;
	}

	public int getDaTreHan() {
		return daTreHan;
	}

	public void setDaTreHan(int daTreHan) {
		this.daTreHan = daTreHan;
	}

	public int getChinhSuaBoSung() {
		return chinhSuaBoSung;
	}

	public void setChinhSuaBoSung(int chinhSuaBoSung) {
		this.chinhSuaBoSung = chinhSuaBoSung;
	}

	public String getTyLeHoSoDungHan() {
		return tyLeHoSoDungHan;
	}

	public void setTyLeHoSoDungHan(String tyLeHoSoDungHan) {
		this.tyLeHoSoDungHan = tyLeHoSoDungHan;
	}

	public boolean isHasFile() {
		return hasFile;
	}

	public void setHasFile(boolean hasFile) {
		this.hasFile = hasFile;
	}

}
