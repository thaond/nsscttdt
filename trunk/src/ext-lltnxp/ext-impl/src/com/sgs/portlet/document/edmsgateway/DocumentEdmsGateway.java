/**
 * 
 */

package com.sgs.portlet.document.edmsgateway;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.InternetAddress;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis.message.MessageElement;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.nsgs.webservice.edmsgateway.HttpEndpointStub;
import com.nsgs.webservice.edmsgatewayimpl.ConnectionDocument;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptTempUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalUtil;

/**
 * @author minhnv
 */
public class DocumentEdmsGateway {

	private final Log _log = LogFactoryUtil.getLog(DocumentEdmsGateway.class);

	public static final String TABLE = "Table";
	public static final String DOCUMENTID = "DocumentID";
	public static final String PUBNUM = "PubNum";
	public static final String PUBDATE = "Pubdate";
	public static final String DEPARTMENTRECEIVEID = "DepartmentReceiveID";
	public static final String FILENAME = "FileName";
	public static final String FILESIZE = "FileSize";
	public static final String BYTETRANSFERS = "ByteTransfers";
	public static final String BUFFERLEN = "BufferLen";
	public static final String PUBORGID = "PubOrgID";
	public static final String SUBJECT = "Subject";
	public static final String FILEPATH = "FilePath";
	public static final String SENDDATE = "SendDate";

	private String edmsGatewayUrl;
	private String edmsGatewayUserName;
	private String edmsGatewayPassword;
	private long timerDelay;
	private long timerDelayOrg;
	private long timerDelaySendMail = 86400000;
	private String edmsGatewayStatusNew;
	private String edmsGatewayStatusRecive;
	private String edmsGatewayFromDate;
	private String edmsGatewayToDate;
	private String edmsGatewaySubCompany;

	public static final DocumentEdmsGateway DEG = new DocumentEdmsGateway();

	private final ConnectionDocument connectionDocument =
		new ConnectionDocument();
	private Timer timerGetDocumentEdmsGateway;
	private boolean flagThreadDoc;

	private Timer timerGetOrgEdmsGateway;
	private boolean flagThreadOrg;

	private DocumentEdmsGateway() {

	}

	/**
	 * stop thread when downloading document from edms gateway
	 */
	public void closeDownloadDocumentReceiptsFromGateWayThread(
		DocumentEdmsGateway dEG) {

		dEG.setFlagThreadDoc(false);
	}

	/**
	 * stop timer when downloading document from edms gateway
	 */
	public void closeDownloadDocumentReceiptsFromGateWayTimer() {

		if (timerGetDocumentEdmsGateway != null) {
			timerGetDocumentEdmsGateway.cancel();
		}
	}

	/**
	 * stop thread when downloading External Organization from edms gateway
	 */
	public void closeDownloadExternalOrganizationFromGateWayThread(
		DocumentEdmsGateway dEG) {

		dEG.setFlagThreadOrg(false);
	}

	/**
	 * stop timer when downloading External Organization from edms gateway
	 */
	public void closeDownloadExternalOrganizationFromGateWayTimer() {

		if (timerGetOrgEdmsGateway != null) {
			timerGetOrgEdmsGateway.cancel();
		}

	}

	/**
	 * stop thread when downloading External Organization from edms gateway
	 */
	public void closeTheardSendMail(DocumentEdmsGateway dEG) {

		dEG.setFlagThreadOrg(false);
	}

	/**
	 * stop timer when downloading External Organization from edms gateway
	 */
	public void closeTimerSendMail() {

		if (timerGetOrgEdmsGateway != null) {
			timerGetOrgEdmsGateway.cancel();
		}

	}

	public int compareTo(Date d1, Date d2) {

		return d1.getDate() + d1.getMonth() * 30 + d1.getYear() * 360 -
			d2.getDate() - d2.getMonth() * 30 - d2.getYear() * 360;
	}

	/**
	 * goi mail thong bao cho nguoi xu ly van ban khi van ban gan toi thoi gian
	 * het han
	 */

	public void createThreadSendMail(final DocumentEdmsGateway dEG) {

		new Thread() {

			@Override
			public void run() {

				dEG.setFlagThreadOrg(true);
				while (dEG.isFlagThreadOrg()) {
					try {
						sendMail();
						Thread.sleep(dEG.getTimerDelaySendMail());
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

	}

	/**
	 * download External Organization from edms gateway with timer
	 */
	public void createTimerSendMail(DocumentEdmsGateway dEG) {

		try {
			TimerTask sendmail = new TimerTask() {

				@Override
				public void run() {

					try {
						sendMail();
					}
					catch (Exception e) {
					}
				}
			};

			timerGetOrgEdmsGateway = new Timer();
			timerGetOrgEdmsGateway.scheduleAtFixedRate(
				sendmail, 0, dEG.getTimerDelaySendMail());
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * download document from edms gateway with thread
	 */

	public void downloadDocumentReceiptsFromGateWayThread(
		final DocumentEdmsGateway dEG, final String pathFileServer) {

		new Thread() {

			@Override
			public void run() {

				dEG.setFlagThreadDoc(true);
				while (dEG.isFlagThreadDoc()) {
					try {
						String receiveOrgID = "";
						List<OrganizationExternal> oETrues =
							OrganizationExternalUtil.findByIsOwnerOrg(true);
						if ((oETrues != null) && !oETrues.isEmpty()) {
							OrganizationExternal organizationExternal =
								OrganizationExternalUtil.findByIsOwnerOrg(true).get(
									0);
							receiveOrgID =
								organizationExternal.getOrgExternalCode();
						}
						String status = dEG.getEdmsGatewayStatusNew();
						Date currentDate = new Date();
						SimpleDateFormat sdf =
							new SimpleDateFormat("dd/MM/yyyy");
						String fromDate = sdf.format(currentDate);
						String toDate = sdf.format(currentDate);

						if (!"".equals(dEG.getEdmsGatewayFromDate())) {
							fromDate = dEG.getEdmsGatewayFromDate();
						}

						if (!"".equals(dEG.getEdmsGatewayToDate())) {
							toDate = dEG.getEdmsGatewayToDate();
						}

						List<OrganizationExternal> oEs =
							OrganizationExternalUtil.findByIsOwnerOrg(false);
						int size = oEs.size();

						for (int i = 0; i < size; i++) {
							MessageElement[] messageElements =
								getDocumentReceiptsFromGateWay(
									receiveOrgID,
									oEs.get(i).getOrgExternalCode(), fromDate,
									toDate, status);
							// MessageElement[] messageElements =
							// getDocumentReceiptsFromGateWay("ORGS04100000066",
							// "ORGS04100000064", fromDate, toDate, status);
							saveToDocumentReceiptTempAndUpdateState(
								messageElements, pathFileServer);
							// Can phai parser xml doc
							// luu nhung van ban vao ban tam
							// TODO
						}

						Thread.sleep(dEG.getTimerDelay());
					}
					catch (InterruptedException e) {
						_log.error("ERROR: IN METHOD DOWNLOADDOCUMENTRECEIPTSFROMGATEWAYTHREAD IN " +
							DocumentEdmsGateway.class + " " + e.getMessage());
					}
					catch (NumberFormatException e) {
						_log.error("ERROR: IN METHOD DOWNLOADDOCUMENTRECEIPTSFROMGATEWAYTHREAD IN " +
							DocumentEdmsGateway.class + " " + e.getMessage());
					}
					catch (Exception e) {
						_log.error("ERROR: IN METHOD DOWNLOADDOCUMENTRECEIPTSFROMGATEWAYTHREAD IN " +
							DocumentEdmsGateway.class + " " + e.getMessage());
					}
				}

			}
		}.start();
	}

	/**
	 * download document from edms gateway with timer
	 */
	public void downloadDocumentReceiptsFromGateWayTimer(
		final DocumentEdmsGateway dEG, final String pathFileServer) {

		try {
			TimerTask downloadDocumentFromEdmsGateWayTimerTask =
				new TimerTask() {

					@Override
					public void run() {

						try {
							String receiveOrgID = "";
							List<OrganizationExternal> oETrues =
								OrganizationExternalUtil.findByIsOwnerOrg(true);
							if ((oETrues != null) && !oETrues.isEmpty()) {
								OrganizationExternal organizationExternal =
									OrganizationExternalUtil.findByIsOwnerOrg(
										true).get(0);
								receiveOrgID =
									organizationExternal.getOrgExternalCode();
							}
							String status = dEG.getEdmsGatewayStatusNew();
							Date currentDate = new Date();
							SimpleDateFormat sdf =
								new SimpleDateFormat("dd/MM/yyyy");
							String fromDate = sdf.format(currentDate);
							String toDate = sdf.format(currentDate);

							if (!"".equals(dEG.getEdmsGatewayFromDate())) {
								fromDate = dEG.getEdmsGatewayFromDate();
							}

							if (!"".equals(dEG.getEdmsGatewayToDate())) {
								toDate = dEG.getEdmsGatewayToDate();
							}
							List<OrganizationExternal> oEs =
								OrganizationExternalUtil.findByIsOwnerOrg(false);
							int size = oEs.size();
							for (int i = 0; i < size; i++) {
								MessageElement[] messageElements =
									getDocumentReceiptsFromGateWay(
										receiveOrgID,
										oEs.get(i).getOrgExternalCode(),
										fromDate, toDate, status);
								// MessageElement[] messageElements =
								// getDocumentReceiptsFromGateWay("ORGS04100000065",
								// "ORGS04100000064", fromDate, toDate, status);
								// Can phai parser xml doc
								saveToDocumentReceiptTempAndUpdateState(
									messageElements, pathFileServer);
								// luu nhung van ban vao ban tam
								// TODO

							}
						}
						catch (Exception e) {
						}
					}
				};

			timerGetDocumentEdmsGateway = new Timer();
			timerGetDocumentEdmsGateway.scheduleAtFixedRate(
				downloadDocumentFromEdmsGateWayTimerTask, 0,
				dEG.getTimerDelay());
		}
		catch (NumberFormatException e) {
			_log.error("ERROR: IN METHOD DOWNLOADDOCUMENTRECEIPTSFROMGATEWAYTIMER IN " +
				DocumentEdmsGateway.class + " " + e.getMessage());
		}
		catch (Exception e) {
			_log.error("ERROR: IN METHOD DOWNLOADDOCUMENTRECEIPTSFROMGATEWAYTIMER IN " +
				DocumentEdmsGateway.class + " " + e.getMessage());
		}
	}

	/**
	 * download External Organization from edms gateway with thread
	 */

	public void downloadExternalOrganizationFromGateWayThread(
		final DocumentEdmsGateway dEG) {

		new Thread() {

			@Override
			public void run() {

				dEG.setFlagThreadOrg(true);
				while (dEG.isFlagThreadOrg()) {
					try {
						MessageElement[] messageElements =
							getExternalOrganizationGateWay();
						// Can phai parser xml doc
						// kiem tra xem to chuc ben ngoai da ton tai chua, neu
						// chua thi luu vao
						// TODO

						// delay thread
						Thread.sleep(dEG.getTimerDelayOrg());
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

	}

	/**
	 * download External Organization from edms gateway with timer
	 */
	public void downloadExternalOrganizationFromGateWayTimer(
		DocumentEdmsGateway dEG) {

		try {
			TimerTask downloadOrgFromEdmsGateWayTimerTask = new TimerTask() {

				@Override
				public void run() {

					try {

						MessageElement[] messageElements =
							getExternalOrganizationGateWay();
						// Can phai parser xml doc
						// kiem tra xem to chuc ben ngoai da ton tai chua, neu
						// chua thi luu vao
						// TODO
					}
					catch (Exception e) {
					}
				}
			};

			timerGetOrgEdmsGateway = new Timer();
			timerGetOrgEdmsGateway.scheduleAtFixedRate(
				downloadOrgFromEdmsGateWayTimerTask, 0, dEG.getTimerDelayOrg());
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get all document from other organization to a organization
	 * 
	 * @param receiveOrgID
	 *            : String
	 * @param sendOrgID
	 *            : String
	 * @param fromDate
	 *            : String
	 * @param toDate
	 *            : String
	 * @param status
	 *            : String
	 * @return org.apache.axis.message.MessageElement[]
	 */
	public MessageElement[] getDocumentReceiptsFromGateWay(
		String receiveOrgID, String sendOrgID, String fromDate, String toDate,
		String status) {

		return connectionDocument.getDocumentListFromGateWay(
			receiveOrgID, sendOrgID, fromDate, toDate, status);

	}

	public String getEdmsGatewayFromDate() {

		return edmsGatewayFromDate;
	}

	public String getEdmsGatewayPassword() {

		return edmsGatewayPassword;
	}

	public String getEdmsGatewayStatusNew() {

		return edmsGatewayStatusNew;
	}

	public String getEdmsGatewayStatusRecive() {

		return edmsGatewayStatusRecive;
	}

	public String getEdmsGatewaySubCompany() {

		return edmsGatewaySubCompany;
	}

	public String getEdmsGatewayToDate() {

		return edmsGatewayToDate;
	}

	public String getEdmsGatewayUrl() {

		return edmsGatewayUrl;
	}

	public String getEdmsGatewayUserName() {

		return edmsGatewayUserName;
	}

	/**
	 * get all external Organization from other system
	 * 
	 * @return org.apache.axis.message.MessageElement[]
	 */
	public MessageElement[] getExternalOrganizationGateWay() {

		return connectionDocument.getOrgList();
	}

	public long getTimerDelay() {

		return timerDelay;
	}

	public long getTimerDelayOrg() {

		return timerDelayOrg;
	}

	/**
	 * @return the timerDelaySendMail
	 */
	public long getTimerDelaySendMail() {

		return timerDelaySendMail;
	}

	/**
	 * Get value of node (org.w3c.dom.Node) in axis
	 * 
	 * @param node
	 *            : org.w3c.dom.Node
	 * @return String
	 */
	public String getValueNode(Node node) {

		NodeList nodeList = node.getChildNodes();
		if (nodeList != null) {
			if ((nodeList.item(0) != null) &&
				(nodeList.item(0).getNodeType() == Node.TEXT_NODE)) {
				return nodeList.item(0).getNodeValue().trim();
			}
		}
		return "";

	}

	/**
	 * check connect to gateway
	 * 
	 * @return boolean
	 */

	public boolean isConnectGateWay() {

		boolean res = false;
		HttpEndpointStub stub = null;
		try {
			stub = connectionDocument.getHttpEndpointStub();
			if (stub != null) {
				res = (!res);
			}
		}
		catch (Exception e) {
		}
		return res;
	}

	/**
	 * @param docID
	 *            : String
	 * @param orgExternalId
	 *            : long
	 * @return boolean
	 */
	public boolean isExisDocId(String docID, long orgExternalId) {

		boolean flag = false;
		List<PmlEdmDocumentReceiptTemp> documentReceiptTempList =
			new ArrayList<PmlEdmDocumentReceiptTemp>();

		try {
			documentReceiptTempList =
				PmlEdmDocumentReceiptTempUtil.findByNumberDocumentReceipt_OrgExternalId(
					docID, orgExternalId);
			if (!documentReceiptTempList.isEmpty()) {
				flag = true;
			}
		}
		catch (SystemException e) {
			_log.error("ERROR: IN METHOD ISEXISDOCID IN " +
				DocumentEdmsGateway.class + " " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean isFlagThreadDoc() {

		return flagThreadDoc;
	}

	public boolean isFlagThreadOrg() {

		return flagThreadOrg;
	}

	/**
	 * save doc down load from getway to pml_edm_documentreceipt_temp
	 * 
	 * @author yenlt
	 * @param element
	 * @return PmlEdmDocumentReceiptTemp
	 */

	public void saveToDocumentReceiptTempAndUpdateState(
		MessageElement[] messageElement, String pathFileServer) {

		if (messageElement.length > 1) {
			DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = null;

			try {
				builder = factory.newDocumentBuilder();
				String messageGateWay = messageElement[1].getAsString();
				NodeList nodeListTable =
					messageElement[1].getElementsByTagName(DocumentEdmsGateway.TABLE);
				String docId = "";
				String pubNum = "";
				String pubDate = "";
				String pubOrgId = "";
				String departmentReceiveId = "";
				String sendDate = "";
				String subject = "";
				String fileName = "";
				String filePath = "";
				String fileSize = "";
				String bufferLen = "";
				String byteTransfers = "";

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sfHour = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				Date dateArrive = new Date();
				Date publishDate = new Date();
				String thoigiannhancvden = "";
				dateArrive = sdf.parse(sdf.format(dateArrive));
				thoigiannhancvden = sfHour.format(dateArrive);

				String pathFileDownload = "";
				String[] pubDates = null;
				List<String> listFileName = new ArrayList<String>();
				List<Long> longDocumentReceiptId = new ArrayList<Long>();
				long documentReceiptId = 0;
				PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = null;

				Node elementTable = null;
				NodeList elementTableChildNodes = null;
				Node elementTableChildNode = null;

				long orgExternalId = 0;
				List<OrganizationExternal> publishORGList =
					new ArrayList<OrganizationExternal>();
				for (int k = 0; k < nodeListTable.getLength(); k++) {
					elementTable = nodeListTable.item(k);
					if (elementTable.getNodeType() == Node.ELEMENT_NODE) {
						elementTableChildNodes = elementTable.getChildNodes();
						for (int i = 0; i < elementTableChildNodes.getLength(); i++) {
							elementTableChildNode =
								elementTableChildNodes.item(i);
							if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.DOCUMENTID)) {
								docId = getValueNode(elementTableChildNode);
							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.PUBNUM)) {
								pubNum = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.PUBDATE)) {
								pubDate = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.PUBORGID)) {
								pubOrgId = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.DEPARTMENTRECEIVEID)) {
								departmentReceiveId =
									getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.SENDDATE)) {
								sendDate = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.SUBJECT)) {
								subject = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.FILENAME)) {
								fileName = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.FILEPATH)) {
								filePath = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.FILESIZE)) {
								fileSize = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.BUFFERLEN)) {
								bufferLen = getValueNode(elementTableChildNode);

							}
							else if (elementTableChildNode.getNodeName().equals(
								DocumentEdmsGateway.BYTETRANSFERS)) {
								byteTransfers =
									getValueNode(elementTableChildNode);
							}
						}

						if (null != pubDate) {
							pubDates = StringUtil.split(pubDate, "T");
							publishDate = sdf.parse(pubDates[0]);
						}
						try {
							publishORGList =
								OrganizationExternalUtil.findByOrgExternalCode(pubOrgId);
							orgExternalId =
								publishORGList.get(0).getOrgExternalId();
						}
						catch (Exception e) {
							orgExternalId = 0;
							_log.error("ERROR: GET ORGEXTERNALID IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
								DocumentEdmsGateway.class +
								" " +
								e.getMessage());
						}

						try {
							if (!isExisDocId(docId, orgExternalId)) {
								// luu nhung van ban vao bang
								// PmlEdmDocumentReceiptTemp
								documentReceiptId =
									CounterLocalServiceUtil.increment();
								pmlEdmDocumentReceiptTemp =
									PmlEdmDocumentReceiptTempLocalServiceUtil.createPmlEdmDocumentReceiptTemp(documentReceiptId);
								pmlEdmDocumentReceiptTemp.setNumberDocumentReceipt(docId);
								pmlEdmDocumentReceiptTemp.setDocumentReference(pubNum);
								pmlEdmDocumentReceiptTemp.setBriefContent(subject);
								pmlEdmDocumentReceiptTemp.setOrgExternalId(orgExternalId);
								pmlEdmDocumentReceiptTemp.setDateArrive(dateArrive);
								pmlEdmDocumentReceiptTemp.setIssuingDate(publishDate);
								pmlEdmDocumentReceiptTemp.setThoigiannhancvden(thoigiannhancvden);
								pmlEdmDocumentReceiptTemp.setDocumentTypeId(0);
								pmlEdmDocumentReceiptTemp.setLevelSendId(0);
								pmlEdmDocumentReceiptTemp.setIssuingPlaceId("");
								pmlEdmDocumentReceiptTemp.setIssuingPlaceOtherName("");

								PmlEdmDocumentReceiptTempLocalServiceUtil.addPmlEdmDocumentReceiptTemp(pmlEdmDocumentReceiptTemp);
							}
							else {
								pmlEdmDocumentReceiptTemp =
									PmlEdmDocumentReceiptTempUtil.findByNumberDocumentReceipt_OrgExternalId(
										docId, orgExternalId).get(0);
							}

						}
						catch (SystemException e) {
							_log.error("ERROR: SAVE PMLEDMDOCUMENTRECEIPTTEMP IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
								DocumentEdmsGateway.class +
								" " +
								e.getMessage());
						}

						// TODO: download load file, update status document
						pathFileDownload = filePath + "/" + fileName;
						byte[] fileByte =
							connectionDocument.downloadFileAttachedDocument(pathFileDownload);
						File fileDownload =
							(File) Base64.stringToObject(Base64.encode(fileByte));
						// File fileDownload = new
						// File("C:/DanhGiaTinhNangPhanMemLoi.docx");
						String fileNameAtt = Constants.getDateTime() + fileName;
						File destFile =
							new File(pathFileServer + "/" + fileNameAtt);
						if (!(new File(pathFileServer)).exists()) {
							(new File(pathFileServer)).mkdir();
						}
						FileUtils.copyFile(fileDownload, destFile);

						long attachedFileId = 0;
						PmlEdmAttachedFile attachedFile = null;
						attachedFileId = CounterLocalServiceUtil.increment();
						attachedFile =
							PmlEdmAttachedFileLocalServiceUtil.createPmlEdmAttachedFile(attachedFileId);
						attachedFile.setObjectContentId(pmlEdmDocumentReceiptTemp.getDocumentReceiptId());
						attachedFile.setObjectType(pmlEdmDocumentReceiptTemp.getClass().getName());
						attachedFile.setAttachedFileName(fileNameAtt);
						attachedFile.setPath("/upload" + "/" + fileNameAtt);
						attachedFile.setDateCreated(new Date());
						if (fileNameAtt.lastIndexOf(".") != -1) {
							attachedFile.setFileType(fileNameAtt.substring(fileNameAtt.lastIndexOf(".") + 1));
						}
						// lay ngay hien tai
						String datevalue = formatter.format(date.getTime());

						attachedFile.setTitle(com.ext.portlet.util.StringUtil.encodeHtml(fileNameAtt +
							"_" + datevalue));
						attachedFile.setDisplayOrHidden(true);
						PmlEdmAttachedFileLocalServiceUtil.addPmlEdmAttachedFile(attachedFile);
						connectionDocument.updateStatusOfODocument(
							docId, fileName, pubOrgId, departmentReceiveId);
					}
				}

			}
			catch (ParserConfigurationException e) {
				_log.error("ERROR: IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
					DocumentEdmsGateway.class + " " + e.getMessage());
				e.printStackTrace();
			}
			catch (SAXException e) {
				_log.error("ERROR: IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
					DocumentEdmsGateway.class + " " + e.getMessage());
				e.printStackTrace();
			}
			catch (IOException e) {
				_log.error("ERROR: IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
					DocumentEdmsGateway.class + " " + e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e) {
				_log.error("ERROR: IN METHOD SAVETODOCUMENTRECEIPTTEMPANDUPDATESTATE IN " +
					DocumentEdmsGateway.class + " " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * send a document to other system
	 * 
	 * @param docID
	 *            :String
	 * @param fileAttach
	 *            :String[]
	 * @param orgReceive
	 *            :String[]
	 * @param orgSend
	 *            :String
	 * @param pubDate
	 *            :String
	 * @param pubNum
	 *            :String
	 * @param pubOrgID
	 *            :String
	 * @param pubOrgName
	 *            :String
	 * @param subject
	 *            :String
	 * @return String
	 */
	public String SendDocumentSendToGateWay(
		String docID, String[] fileAttach, String[] orgReceive, String orgSend,
		String pubDate, String pubNum, String pubOrgID, String pubOrgName,
		String subject) {

		return connectionDocument.SendDocumentToGateWay(
			docID, fileAttach, orgReceive, orgSend, pubDate, pubNum, pubOrgID,
			pubOrgName, subject);

	}

	public void sendMail()
		throws Exception {

		// lay tat ca user
		List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
		List<PmlEdmDocumentReceipt> listDocRecNeedPro = null;
		String fileStatusCodeCVDen = "";
		fileStatusCodeCVDen = "CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly";
		PmlFileStatus fileStatusCVDen =
			PmlFileStatusUtil.findByFileStatusCode(fileStatusCodeCVDen).get(0);
		List<Long> uesrList = null;
		Date now = new Date();
		Date dateReceipt = null;
		for (User user : users) {
			uesrList = new ArrayList<Long>();
			uesrList.add(user.getUserId());
			listDocRecNeedPro =
				PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(
					uesrList, fileStatusCVDen.getFileStatusId(), "0", "0",
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			for (PmlEdmDocumentReceipt documentReceipt : listDocRecNeedPro) {
				dateReceipt = documentReceipt.getDateArrive();
				if (documentReceipt.getProcessTime() > 5) {
					if (documentReceipt.getProcessTime() -
						compareTo(now, dateReceipt) < 5) {
						threadSendMail(user, listDocRecNeedPro);
					}
				}
				else if ((documentReceipt.getProcessTime() < 5) &&
					(documentReceipt.getProcessTime() > 0)) {
					if (documentReceipt.getProcessTime() -
						compareTo(now, dateReceipt) < 1) {
						threadSendMail(user, listDocRecNeedPro);
					}
				}
			}
		}

	}

	public void setEdmsGatewayFromDate(String edmsGatewayFromDate) {

		this.edmsGatewayFromDate = edmsGatewayFromDate;
	}

	public void setEdmsGatewayPassword(String edmsGatewayPassword) {

		this.edmsGatewayPassword = edmsGatewayPassword;
	}

	public void setEdmsGatewayStatusNew(String edmsGatewayStatusNew) {

		this.edmsGatewayStatusNew = edmsGatewayStatusNew;
	}

	public void setEdmsGatewayStatusRecive(String edmsGatewayStatusRecive) {

		this.edmsGatewayStatusRecive = edmsGatewayStatusRecive;
	}

	public void setEdmsGatewaySubCompany(String edmsGatewaySubCompany) {

		this.edmsGatewaySubCompany = edmsGatewaySubCompany;
	}

	public void setEdmsGatewayToDate(String edmsGatewayToDate) {

		this.edmsGatewayToDate = edmsGatewayToDate;
	}

	public void setEdmsGatewayUrl(String edmsGatewayUrl) {

		this.edmsGatewayUrl = edmsGatewayUrl;
	}

	public void setEdmsGatewayUserName(String edmsGatewayUserName) {

		this.edmsGatewayUserName = edmsGatewayUserName;
	}

	public void setFlagThreadDoc(boolean flagThreadDoc) {

		this.flagThreadDoc = flagThreadDoc;
	}

	public void setFlagThreadOrg(boolean flagThreadOrg) {

		this.flagThreadOrg = flagThreadOrg;
	}

	/**
	 * create connection to edmsgateway system
	 */
	public void setParamForConnectionDocument(DocumentEdmsGateway dEG) {

		connectionDocument.setEdmsGateWayUrl(dEG.getEdmsGatewayUrl());
		connectionDocument.setEdmsGateWayUserName(dEG.getEdmsGatewayUserName());
		connectionDocument.setEdmsGateWayPassword(dEG.getEdmsGatewayPassword());
	}

	public void setTimerDelay(long timerDelay) {

		this.timerDelay = timerDelay;
	}

	public void setTimerDelayOrg(long timerDelayOrg) {

		this.timerDelayOrg = timerDelayOrg;
	}

	/**
	 * @param timerDelaySendMail
	 *            the timerDelaySendMail to set
	 */
	public void setTimerDelaySendMail(long timerDelaySendMail) {

		this.timerDelaySendMail = timerDelaySendMail;
	}

	public void threadSendMail(
		final User user, final List<PmlEdmDocumentReceipt> listDocRecNeedPro) {

		new Thread() {

			// sen mail chon nguoi do
			public void run() {

				// PortletProps.get("ca.tp.hcm")
				InternetAddress from;
				try {
					from =
						new InternetAddress(
							PortletProps.get("email"),
							PortletProps.get("ca.tp.hcm"));
					MailMessage mailMessage = new MailMessage();
					mailMessage.setFrom(from);
					String dscv = "";
					int stt = 1;
					for (PmlEdmDocumentReceipt documentReceipt : listDocRecNeedPro) {
						dscv +=
							"\t\t" + stt++ + "\t" +
								documentReceipt.getNumberDocumentReceipt() +
								"\t" + documentReceipt.getBriefContent() + "\n";
					}
					mailMessage.setBody(PortletProps.get("ban-co") + " " +
						listDocRecNeedPro.size() + " " +
						PortletProps.get("cvcdxl") + "\n" +
						PortletProps.get("dscv") + "\n " + dscv);
					mailMessage.setSubject(PortletProps.get("xu-ly-cong-viec"));

					mailMessage.setTo(new InternetAddress[] {
						new InternetAddress(
							user.getEmailAddress(), user.getScreenName())
					});

					MailServiceUtil.sendEmail(mailMessage);
				}
				catch (UnsupportedEncodingException e) {
					System.out.println("khong goi dc mail");
				}

			};
		}.start();
	}
}
