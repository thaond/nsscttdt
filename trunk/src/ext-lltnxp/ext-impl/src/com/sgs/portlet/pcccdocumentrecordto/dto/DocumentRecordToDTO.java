/**
 * 
 */
package com.sgs.portlet.pcccdocumentrecordto.dto;

/**
 * @author DienNH
 *
 */
public class DocumentRecordToDTO {

	private int stt;
	private String soCVNoiBo;
	private String soCVDen;
	private String ngayDen;
	private String ngayHetHan;
	private String ngayPhatHanh;
	private String noiBanHanh;
	private String trichYeu;
	private String loaiCV;
	private String doUuTien;
	private String trinhTuXuLy;
	
	/**
	 * 
	 */
	public DocumentRecordToDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}
	
	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}
	
	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public String getSoCVNoiBo() {
		return soCVNoiBo;
	}

	public void setSoCVNoiBo(String soCVNoiBo) {
		this.soCVNoiBo = soCVNoiBo;
	}

	public String getSoCVDen() {
		return soCVDen;
	}

	public void setSoCVDen(String soCVDen) {
		this.soCVDen = soCVDen;
	}

	public String getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(String ngayDen) {
		this.ngayDen = ngayDen;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getNoiBanHanh() {
		return noiBanHanh;
	}

	public void setNoiBanHanh(String noiBanHanh) {
		this.noiBanHanh = noiBanHanh;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}

	public String getLoaiCV() {
		return loaiCV;
	}

	public void setLoaiCV(String loaiCV) {
		this.loaiCV = loaiCV;
	}

	public String getDoUuTien() {
		return doUuTien;
	}

	public void setDoUuTien(String doUuTien) {
		this.doUuTien = doUuTien;
	}

	public String getTrinhTuXuLy() {
		return trinhTuXuLy;
	}

	public void setTrinhTuXuLy(String trinhTuXuLy) {
		this.trinhTuXuLy = trinhTuXuLy;
	}

}
