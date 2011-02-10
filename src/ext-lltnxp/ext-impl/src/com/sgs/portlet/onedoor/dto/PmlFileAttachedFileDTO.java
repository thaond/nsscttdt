/**
 * 
 */

package com.sgs.portlet.onedoor.dto;

/**
 * @author kienbqc
 */
public class PmlFileAttachedFileDTO {

	private String fileAttachedFileId;
	private String attachedFileName;
	private String attachedFileCode;
	private int original;
	private int copy;
	private String note;

	public String getFileAttachedFileId() {

		return fileAttachedFileId;
	}

	public void setFileAttachedFileId(String fileAttachedFileId) {

		this.fileAttachedFileId = fileAttachedFileId;
	}

	public String getAttachedFileName() {

		return attachedFileName;
	}

	public void setAttachedFileName(String attachedFileName) {

		this.attachedFileName = attachedFileName;
	}

	public String getAttachedFileCode() {

		return attachedFileCode;
	}

	public void setAttachedFileCode(String attachedFileCode) {

		this.attachedFileCode = attachedFileCode;
	}

	public int getOriginal() {

		return original;
	}

	public void setOriginal(int original) {

		this.original = original;
	}

	public int getCopy() {

		return copy;
	}

	public void setCopy(int copy) {

		this.copy = copy;
	}

	public String getNote() {

		return note;
	}

	public void setNote(String note) {

		this.note = note;
	}

}
