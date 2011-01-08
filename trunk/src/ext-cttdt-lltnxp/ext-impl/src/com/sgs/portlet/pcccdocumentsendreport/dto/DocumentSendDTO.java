/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendreport.dto;

/**
 * @author DienNH
 *
 */
public class DocumentSendDTO {

	private String stt;
	private String soCVNoiBo;
	private String soCVDi;
	private String noiNhan;
	private String nguoiSoanThao;
	private String nguoiKy;
	private String trichYeu;
	private String loaiCV;
	private String ngayPhatHanh;
	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	private String doUuTien;
	private String trinhTuXuLy;
	
	/**
	 * 
	 */
	public DocumentSendDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getSoCVNoiBo() {
		return soCVNoiBo;
	}

	public void setSoCVNoiBo(String soCVNoiBo) {
		this.soCVNoiBo = soCVNoiBo;
	}

	public String getSoCVDi() {
		return soCVDi;
	}

	public void setSoCVDi(String soCVDi) {
		this.soCVDi = soCVDi;
	}

	public String getNoiNhan() {
		return noiNhan;
	}

	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}

	public String getNguoiSoanThao() {
		return nguoiSoanThao;
	}

	public void setNguoiSoanThao(String nguoiSoanThao) {
		this.nguoiSoanThao = nguoiSoanThao;
	}
	
	public String getNguoiKy() {
		return nguoiKy;
	}
	
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
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
