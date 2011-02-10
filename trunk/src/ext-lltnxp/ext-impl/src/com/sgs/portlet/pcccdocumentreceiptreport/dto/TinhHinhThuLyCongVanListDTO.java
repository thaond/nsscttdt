/**
 * 
 */
package com.sgs.portlet.pcccdocumentreceiptreport.dto;

import java.util.List;

/**
 * @author diennh
 *
 */
public class TinhHinhThuLyCongVanListDTO {

	private int stt = 1;
	private String ten = "";
	private List<Object> tonDauKy = null;
	private List<Object> nhanTrongKy = null;
	private List<Object> dungHan = null;
	private List<Object> treHan = null;
	private List<Object> tongDaGiaiQuyet = null;
	private List<Object> trongQuiDinh = null;
	private List<Object> quaQuiDinh = null;
	private List<Object> tongDangGiaiQuyet = null;
	private String tyLeGiaiQuyetDungHan = "";
	
	/**
	 * 
	 */
	public TinhHinhThuLyCongVanListDTO() {
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<Object> getTonDauKy() {
		return tonDauKy;
	}

	public void setTonDauKy(List<Object> tonDauKy) {
		this.tonDauKy = tonDauKy;
	}

	public List<Object> getNhanTrongKy() {
		return nhanTrongKy;
	}

	public void setNhanTrongKy(List<Object> nhanTrongKy) {
		this.nhanTrongKy = nhanTrongKy;
	}

	public List<Object> getDungHan() {
		return dungHan;
	}

	public void setDungHan(List<Object> dungHan) {
		this.dungHan = dungHan;
	}

	public List<Object> getTreHan() {
		return treHan;
	}

	public void setTreHan(List<Object> treHan) {
		this.treHan = treHan;
	}

	public List<Object> getTongDaGiaiQuyet() {
		return tongDaGiaiQuyet;
	}

	public void setTongDaGiaiQuyet(List<Object> tongDaGiaiQuyet) {
		this.tongDaGiaiQuyet = tongDaGiaiQuyet;
	}

	public List<Object> getTrongQuiDinh() {
		return trongQuiDinh;
	}

	public void setTrongQuiDinh(List<Object> trongQuiDinh) {
		this.trongQuiDinh = trongQuiDinh;
	}

	public List<Object> getQuaQuiDinh() {
		return quaQuiDinh;
	}

	public void setQuaQuiDinh(List<Object> quaQuiDinh) {
		this.quaQuiDinh = quaQuiDinh;
	}

	public List<Object> getTongDangGiaiQuyet() {
		return tongDangGiaiQuyet;
	}

	public void setTongDangGiaiQuyet(List<Object> tongDangGiaiQuyet) {
		this.tongDangGiaiQuyet = tongDangGiaiQuyet;
	}

	public String getTyLeGiaiQuyetDungHan() {
		return tyLeGiaiQuyetDungHan;
	}

	public void setTyLeGiaiQuyetDungHan(String tyLeGiaiQuyetDungHan) {
		this.tyLeGiaiQuyetDungHan = tyLeGiaiQuyetDungHan;
	}

}
