/**
 * 
 */

package com.sgs.portlet.pcccdocumentreceiptprocess.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;

/**
 * @author canhminh
 */
public class DocumentReceiptLogNode {

	private PmlDocumentReceiptLog receiptLog;
	private DocumentReceiptLogNode parent;
	private List<DocumentReceiptLogNode> children =
		new ArrayList<DocumentReceiptLogNode>();
	private User processer;
	private static final DateFormat DF = new SimpleDateFormat(
		"dd/MM/yyyy HH:mm:ss");
	private boolean isCurrentNodeWF = false;

	/**
	 * 
	 */
	public DocumentReceiptLogNode() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param receiptLog
	 * @throws SystemException
	 */
	public DocumentReceiptLogNode(
		PmlDocumentReceiptLog receiptLog, DocumentReceiptLogNode parent)
		throws SystemException {

		super();
		this.receiptLog = receiptLog;
		List<PmlDocumentReceiptLog> documentReceiptLogs =
			new ArrayList<PmlDocumentReceiptLog>();
		if (parent == null) {
			documentReceiptLogs =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_Step(
					this.receiptLog.getDocumentReceiptId(),
					this.receiptLog.getProcesser(), 1);
		}
		else if (this.receiptLog.getReceiver() > 0) {
			documentReceiptLogs =
				PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_Step(
					this.receiptLog.getDocumentReceiptId(),
					this.receiptLog.getReceiver(),
					this.receiptLog.getStep() + 1);
		}
		this.parent = parent;
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : documentReceiptLogs) {
			if (((parent == null) || (pmlDocumentReceiptLog.getTransition_() > this.receiptLog.getTransition_()))) {
				children.add(new DocumentReceiptLogNode(
					pmlDocumentReceiptLog, this));
			}
			if (pmlDocumentReceiptLog.getDateProcess() == null) {
				isCurrentNodeWF = true;
			}
		}
	}

	/**
	 * @return the children
	 */
	public List<DocumentReceiptLogNode> getChildren() {

		return children;
	}

	public String getInformation() {

		StringBuilder sb = new StringBuilder();
		sb.append("<div class='ttip_content'>");
		sb.append(isCurrentNodeWF
			? "<p>(Ch\u01b0a x\u1eed l\u00fd)</p>"
			: "<p>(\u0110\u00e3 x\u1eed l\u00fd" +
				(isAutoFinish() ? " - T\u1ef1 ho\u00e0n th\u00e0nh" : "") +
				")</p>");
		sb.append("<p><b>Ng\u00e0y g\u1eedi: </b>");
		sb.append(receiptLog.getDateProcessTime() == null
			? "N/A" : DF.format(receiptLog.getDateProcessTime()));
		sb.append("</p>");
		sb.append("<p><b>Ng\u00e0y nh\u1eadn: </b>");
		sb.append(receiptLog.getReceiveDateTime() == null
			? "N/A" : DF.format(receiptLog.getReceiveDateTime()));
		sb.append("</p>");
		sb.append("<p><b>Y\u00eau c\u1ea7u x\u1eed l\u00fd: </b>");
		sb.append(receiptLog.getProcessInfomation());
		sb.append("</p>");
		sb.append("</div>");
		return sb.toString();
	}

	/**
	 * @return the parent
	 */
	public DocumentReceiptLogNode getParent() {

		return parent;
	}

	/**
	 * @return
	 */
	public User getProcesser() {

		if (processer == null) {

			try {
				if (parent == null) {
					processer =
						UserLocalServiceUtil.getUser(receiptLog.getProcesser());
				}
				else {
					processer =
						UserLocalServiceUtil.getUser(receiptLog.getReceiver());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return processer;
	}

	public String getProcesserName() {

		StringBuilder sb = new StringBuilder();
		getProcesser();
		if (processer == null) {
			return sb.toString();
		}

		sb.append(processer.getLastName());
		sb.append(" ");
		sb.append(processer.getMiddleName());
		sb.append(" ");
		sb.append(processer.getFirstName());

		if (children.size() > 0) {
			DocumentReceiptLogNode child = children.get(0);
			if ((child.receiptLog.getDirectProcesserId() > 0) &&
				(child.receiptLog.getDirectProcesserId() != child.receiptLog.getProcesser())) {
				try {
					User directProcesser =
						UserLocalServiceUtil.getUser(child.receiptLog.getDirectProcesserId());
					sb.append(" (\u1ee6y quy\u1ec1n x\u1eed l\u00fd: ");
					sb.append(directProcesser.getLastName());
					sb.append(" ");
					sb.append(directProcesser.getMiddleName());
					sb.append(" ");
					sb.append(directProcesser.getFirstName());
					sb.append(" )");
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @return the receiptLog
	 */
	public PmlDocumentReceiptLog getReceiptLog() {

		return receiptLog;
	}

	/**
	 * @return
	 */
	private boolean isAutoFinish() {

		// TODO Auto-generated method stub
		if (children.size() > 0) {
			DocumentReceiptLogNode child = children.get(0);
			return (child.receiptLog.getDateProcess() != null) &&
				(child.receiptLog.getReceiver() == 0) &&
				(receiptLog.getProcesser() != receiptLog.getReceiver());
		}
		return false;
	}

	/**
	 * @return the isCurrentNodeWF
	 */
	public boolean isCurrentNodeWF() {

		return isCurrentNodeWF;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<DocumentReceiptLogNode> children) {

		this.children = children;
	}

	/**
	 * @param isCurrentNodeWF
	 *            the isCurrentNodeWF to set
	 */
	public void setCurrentNodeWF(boolean isCurrentNodeWF) {

		this.isCurrentNodeWF = isCurrentNodeWF;
	}

	// /**
	// * @return
	// */
	// public User getReciever() {
	//
	// if (reciever == null) {
	// try {
	// reciever =
	// UserLocalServiceUtil.getUser(receiptLog.getReceiver());
	// }
	// catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// return reciever;
	// }
	//
	// public String getRecieverName() {
	//
	// getReciever();
	// if (reciever == null) {
	// return "";
	// }
	//
	// return reciever.getLastName() + " " + reciever.getMiddleName() + " " +
	// reciever.getFirstName();
	// }

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(DocumentReceiptLogNode parent) {

		this.parent = parent;
	}

	/**
	 * @param receiptLog
	 *            the receiptLog to set
	 */
	public void setReceiptLog(PmlDocumentReceiptLog receiptLog) {

		this.receiptLog = receiptLog;
	}

}
