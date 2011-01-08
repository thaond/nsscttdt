
package com.sgs.portlet.documentrecord.dto;

public class DocumentTypeDTO {

	private long documentTypeId;
	private String documentTypeName;
	private String documentSymbol;
	private String documentRecordTypeName;

	/**
	 * @return the documentTypyId
	 */
	public long getDocumentTypeId() {

		return documentTypeId;
	}

	/**
	 * @param documentTypyId
	 *            the documentTypyId to set
	 */
	public void setDocumentTypeId(long documentTypeId) {

		this.documentTypeId = documentTypeId;
	}

	/**
	 * @return the documentTypeName
	 */
	public String getDocumentTypeName() {

		return documentTypeName;
	}

	/**
	 * @param documentTypeName
	 *            the documentTypeName to set
	 */
	public void setDocumentTypeName(String documentTypeName) {

		this.documentTypeName = documentTypeName;
	}

	/**
	 * @return the documentSymbol
	 */
	public String getDocumentSymbol() {

		return documentSymbol;
	}

	/**
	 * @param documentSymbol
	 *            the documentSymbol to set
	 */
	public void setDocumentSymbol(String documentSymbol) {

		this.documentSymbol = documentSymbol;
	}

	/**
	 * @return the documentRecordTypeName
	 */
	public String getDocumentRecordTypeName() {

		return documentRecordTypeName;
	}

	/**
	 * @param documentRecordTypeName
	 *            the documentRecordTypeName to set
	 */
	public void setDocumentRecordTypeName(String documentRecordTypeName) {

		this.documentRecordTypeName = documentRecordTypeName;
	}

}
