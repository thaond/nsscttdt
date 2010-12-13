package com.ext.portlet.meetingcalendar.dto;
/**
 * @author Dao Duy Duong
 * @author Hai Trieu
 * @update Date: 20091026
 *
 */
public class MeetingCalendarDTO {
	private String thuNgay;
	private String buoiSang;
	private String buoiChieu;
	
	public MeetingCalendarDTO() {
	}
	
	public String getThuNgay() {
		return thuNgay;
	}
	public void setThuNgay(String thuNgay) {
		this.thuNgay = thuNgay;
	}
	public String getBuoiSang() {
		return buoiSang;
	}
	public void setBuoiSang(String buoiSang) {
		this.buoiSang = buoiSang;
	}
	public String getBuoiChieu() {
		return buoiChieu;
	}
	public void setBuoiChieu(String buoiChieu) {
		this.buoiChieu = buoiChieu;
	}
}
