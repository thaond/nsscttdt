/**
 * 
 */

package com.sgs.portlet.pcccdocumentsendprocess.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;

/**
 * @author canhminh
 */
public class DocumentSendLogNode {

	private PmlDocumentSendLog sendLog;
	private DocumentSendLogNode parent;
	private List<DocumentSendLogNode> children =
		new ArrayList<DocumentSendLogNode>();
	private User processer;
	private static final DateFormat DF = new SimpleDateFormat(
		"dd/MM/yyyy HH:mm:ss");
	private boolean isCurrentNodeWF = false;

	/**
	 * 
	 */
	public DocumentSendLogNode() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sendLog
	 * @throws SystemException
	 */
	public DocumentSendLogNode(
		PmlDocumentSendLog sendLog, DocumentSendLogNode parent)
		throws SystemException {

		super();
		this.sendLog = sendLog;
		List<PmlDocumentSendLog> DocumentSendLogs =
			new ArrayList<PmlDocumentSendLog>();
		if (parent == null) {
			DocumentSendLogs =
				PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Step(
					this.sendLog.getDocumentSendId(),
					this.sendLog.getProcesser(), 1);
		}
		else if (this.sendLog.getReceiver() > 0) {
			DocumentSendLogs =
				PmlDocumentSendLogUtil.findByDocumentSendId_Processor_Step(
					this.sendLog.getDocumentSendId(),
					this.sendLog.getReceiver(), this.sendLog.getStep() + 1);
		}
		this.parent = parent;
		for (PmlDocumentSendLog PmlDocumentSendLog : DocumentSendLogs) {
			if (((parent == null) || (PmlDocumentSendLog.getTransition_() > this.sendLog.getTransition_()))) {
				children.add(new DocumentSendLogNode(PmlDocumentSendLog, this));
			}
			if (PmlDocumentSendLog.getDateProcess() == null) {
				isCurrentNodeWF = true;
			}
		}
	}

	/**
	 * @return the children
	 */
	public List<DocumentSendLogNode> getChildren() {

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
		sb.append(sendLog.getDateProcessTime() == null
			? "N/A" : DF.format(sendLog.getDateProcessTime()));
		sb.append("</p>");
		sb.append("<p><b>Ng\u00e0y nh\u1eadn: </b>");
		sb.append(sendLog.getReceiveDateTime() == null
			? "N/A" : DF.format(sendLog.getReceiveDateTime()));
		sb.append("</p>");
		sb.append("<p><b>Y\u00eau c\u1ea7u x\u1eed l\u00fd: </b>");
		sb.append(sendLog.getProcessInfomation());
		sb.append("</p>");
		sb.append("</div>");
		return sb.toString();
	}

	/**
	 * @return the parent
	 */
	public DocumentSendLogNode getParent() {

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
						UserLocalServiceUtil.getUser(sendLog.getProcesser());
				}
				else {
					processer =
						UserLocalServiceUtil.getUser(sendLog.getReceiver());
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
			DocumentSendLogNode child = children.get(0);
			if ((child.sendLog.getDirectProcesserId() > 0) &&
				(child.sendLog.getDirectProcesserId() != child.sendLog.getProcesser())) {
				try {
					User directProcesser =
						UserLocalServiceUtil.getUser(child.sendLog.getDirectProcesserId());
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
	 * @return the sendLog
	 */
	public PmlDocumentSendLog getReceiptLog() {

		return sendLog;
	}

	/**
	 * @return
	 */
	private boolean isAutoFinish() {

		// TODO Auto-generated method stub
		if (children.size() > 0) {
			DocumentSendLogNode child = children.get(0);
			return (child.sendLog.getDateProcess() != null) &&
				(child.sendLog.getReceiver() == 0) &&
				(sendLog.getProcesser() != sendLog.getReceiver());
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
	public void setChildren(List<DocumentSendLogNode> children) {

		this.children = children;
	}

	/**
	 * @param isCurrentNodeWF
	 *            the isCurrentNodeWF to set
	 */
	public void setCurrentNodeWF(boolean isCurrentNodeWF) {

		this.isCurrentNodeWF = isCurrentNodeWF;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(DocumentSendLogNode parent) {

		this.parent = parent;
	}

	/**
	 * @param sendLog
	 *            the sendLog to set
	 */
	public void setReceiptLog(PmlDocumentSendLog sendLog) {

		this.sendLog = sendLog;
	}

}
