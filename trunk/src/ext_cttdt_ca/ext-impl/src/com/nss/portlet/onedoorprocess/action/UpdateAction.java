package com.nss.portlet.onedoorprocess.action;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.counter.service.persistence.CounterUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.impl.PmlFileAttachedFileImpl;
import com.nss.portlet.filetype.service.PmlFileAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.filetype.service.persistence.PmlFileAttachedFileUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCAttachedFileImpl;
import com.nss.portlet.onedoor.model.impl.PmlPaintDocumentImpl;
import com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlPaintDocumentLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalServiceUtil;

public class UpdateAction extends PortletAction {
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String redirect = ParamUtil.getString(req, "redirect", "/nss/onedoorprocess/view");
		updateDocument(req, res);
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "update",PortletSession.APPLICATION_SCOPE);
		res.sendRedirect(redirect);
		
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
		initDataForRender(req);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.onedoorprocess.update");
			}
	}



	private void initDataForRender(PortletRequest req) throws Exception{
		long userId = PortalUtil.getUserId((RenderRequest) req);
		String userName = PortalUtil.getUserName(userId, "");
		
		String fileId = ParamUtil.getString(req, "fileId");
		PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
		PmlOneDoorReceiveFile pmlFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		List<PmlFileAttachedFile> attachFiles = PmlFileAttachedFileUtil.findByFileId(fileId);
		List<PmlPaintDocument> paintDocuments = PmlPaintDocumentLocalServiceUtil.findByFileId(fileId);
		List<PmlFilePCCCAttachedFile> filePCCCAttachedFiles = PmlFilePCCCAttachedFileLocalServiceUtil.findByFilePcccId(fileId);
		List<PmlProcessDispose> processDisposeList = PmlProcessDisposeLocalServiceUtil.findByFileId(fileId);
		
		req.setAttribute("processDisposeList", processDisposeList);
		req.setAttribute("filePCCCAttachedFiles", filePCCCAttachedFiles);
		req.setAttribute("pmlFile", pmlFile);
		req.setAttribute("filePCCC", filePCCC);
		req.setAttribute("attachFiles", attachFiles);
		req.setAttribute("paintDocuments", paintDocuments);
		
		
		req.setAttribute("numberReceipt", "numberReceipt");
		req.setAttribute("userId", userId);
		req.setAttribute("userName", userName);
		
		List<PmlFileType> listFileType = PmlFileTypeLocalServiceUtil.getPmlFileTypes(-1, -1);
		req.setAttribute("listFileType", listFileType);
	}
	
	/**
	 * update process
	 * @param req
	 * @param res
	 */
	private void updateDocument(ActionRequest req, ActionResponse res) throws Exception {
		String fileId = ParamUtil.getString(req, "fileId", "");
		PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
		PmlOneDoorReceiveFile pmlFile = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
		
		//thong tin ho so
		String fileName = ParamUtil.getString(req, "fileName");
		String applicantName = ParamUtil.getString(req, "applicantName");
		String applicantRepresentation = ParamUtil.getString(req, "applicantRepresentation");
		String applicantTelephone = ParamUtil.getString(req, "applicantTelephone");
		String receiveOfUnit = ParamUtil.getString(req, "receiveOfUnit");
		String receiverRepresentation = ParamUtil.getString(req, "applicantRepresentation");
		String permanentAddress = ParamUtil.getString(req, "permanentAddress");
		String receiverTelephone = ParamUtil.getString(req, "receiverTelephone");
		//ho so thiet ke 
		String projectName = ParamUtil.getString(req, "projectName");
		String applicantCategory = ParamUtil.getString(req, "applicantCategory");
		String addressBuilder = ParamUtil.getString(req, "addressBuilder");
		String investor = ParamUtil.getString(req, "investor");
		String designCop = ParamUtil.getString(req, "designCop");
		int fileNumber = ParamUtil.getInteger(req, "fileNumber");
		
		//thong tin quan ly
		String noteinformationManagement = ParamUtil.getString(req, "noteinformationManagement");
		
		//Ket luan ve ho so tham duyet
		String conclusion = ParamUtil.getString(req, "conclusion");
		
		//update
		pmlFile.setApplicantName(applicantName);
		pmlFile.setPermanentAddress(permanentAddress);
		//update filePCCC
		filePCCC.setFileName(fileName);
		filePCCC.setApplicantRepresentation(applicantRepresentation);
		filePCCC.setApplicantTelephone(applicantTelephone);
		filePCCC.setReceiveOfUnit(receiveOfUnit);
		filePCCC.setReceiverRepresentation(receiverRepresentation);
		
		filePCCC.setReceiverTelephone(receiverTelephone);
		filePCCC.setProjectName(projectName);
		filePCCC.setApplicantCategory(applicantCategory);
		filePCCC.setAddressBuilder(addressBuilder);
		filePCCC.setInvestor(investor);
		filePCCC.setDesignCop(designCop);
		filePCCC.setFileNumber(fileNumber);
		filePCCC.setNoteInformationManagement(noteinformationManagement);
		filePCCC.setConclusion(conclusion);
		
		PmlFilePCCCLocalServiceUtil.updatePmlFilePCCC(filePCCC);
		PmlOneDoorReceiveFileLocalServiceUtil.updatePmlOneDoorReceiveFile(pmlFile);
		
		//update file dinh kem
		uploadFile(req, fileId);
		
		// update paint document
		updatePaintDocument(req, fileId);
		
		// update attachedFile
		updateAttachedFile(req, fileId);
	}

	/**
	 * @param req
	 * @param fileId
	 * @throws IOException
	 * @throws SystemException
	 * @throws MalformedURLException
	 */
private void uploadFile(ActionRequest req, String fileId) throws Exception {
		
		// nguoi dung chon xoa nhung tap tin da upload
		String strFileAttachedFile = ParamUtil.getString(req, "str_fileattachedfile");
		if(strFileAttachedFile.equals("") == false) {
			
			String[] arrFileAttachedFile = strFileAttachedFile.split("/");
			int fileAttachedFileSize = arrFileAttachedFile.length;
			for(int i = 0; i < fileAttachedFileSize; i ++) {
				long id = Long.parseLong(arrFileAttachedFile[i]);		
				PmlFilePCCCAttachedFileLocalServiceUtil.deletePmlFilePCCCAttachedFile(id);
			}
		}
		
		String manyFile = ParamUtil.getString(req, "manyFile", "");
		
		if (manyFile != null && manyFile != "") {
			String[] manyFileArr = manyFile.split("_");
			if (manyFileArr.length != 0) { 
					for (int i = 0; i < manyFileArr.length; i++) {
						UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
						File myFile = uploadRequest.getFile(manyFileArr[i]);
						
						if (!"".equals(manyFileArr[i])) {
							String filename = uploadRequest.getFileName(manyFileArr[i]);
							File destFile = new File(getServlet().getServletContext().getRealPath("/")+ "upload" + "/" + filename);
							
							if (!(new File(getServlet().getServletContext().getRealPath("/")
									+ "upload")).exists()) {
								(new File(getServlet().getServletContext().getRealPath("/")	+ "upload")).mkdir();
							}
							
							/* copy file to server from client */
							if (myFile != null) {
								FileUtils.copyFile(myFile, destFile);
								PmlFilePCCCAttachedFile filePcccAttach = new PmlFilePCCCAttachedFileImpl();
								long attachedFileId = CounterLocalServiceUtil.increment();
								filePcccAttach.setAttachedFileId(attachedFileId);
								filePcccAttach.setAttachedFileName(filename);
								filePcccAttach.setFilePcccId(fileId);
								filePcccAttach.setObjectType(PmlOneDoorReceiveFile.class.getName());
								filePcccAttach.setPath("/upload" + "/" + filename);
								filePcccAttach.setDateCreated(new Date());
								filePcccAttach.setFileType(filename.substring(filename.lastIndexOf(".") +1));
								PmlFilePCCCAttachedFileLocalServiceUtil.addPmlFilePCCCAttachedFile(filePcccAttach);
							}
						}
//					}
				}
			}
		}
	}
	 
	/**
	 * 
	 */
	private void updatePaintDocument(ActionRequest req, String fileId) throws Exception {
		
		// Xoa nhung PaintDocument nguoi dung da chon trong csdl truoc do
		PmlPaintDocumentLocalServiceUtil.removeByFileId(fileId);
		
		/* 
		 * Lay chuoi str_paintdocument tu client
		 * Chuoi str_paintdocument co dang: ',,,/,,,/,,,/,,,/'
		 */	
		String strPmlPaintDocument = ParamUtil.getString(req, "str_paintdocumnet");
		// Thay the ',,,/' bang '' (neu co)
		strPmlPaintDocument = strPmlPaintDocument.replace(",,,/", "");
		
		// 
		if(strPmlPaintDocument.equals("") == false) {
			
			// cut string (arrDocument[i]: (id, name, quantity, note))
			String[] arrPaintDocumnet = strPmlPaintDocument.split("/");
			
			// Them moi PaintDocumnet duoc nguoi dung chon
			int size = arrPaintDocumnet.length;
			
			for(int i = 0; i < size; i ++) { // duyet qua tung PaintDocumnet
				strPmlPaintDocument = arrPaintDocumnet[i];
				String[] _strPmlPaintDocumnet = strPmlPaintDocument.split(","); // cat PaintDocumnet thanh tung thuoc tinh theo ','
				
				PmlPaintDocument pmlPaintDocument = new PmlPaintDocumentImpl();
				long paintDocumentId = CounterUtil.increment();
			
				if(_strPmlPaintDocumnet[0].equals("") == false) { // Neu PaintDocumnet da co trong csdl
					paintDocumentId = Long.parseLong(_strPmlPaintDocumnet[0]);
				} 
				pmlPaintDocument.setPaintDocumentId(paintDocumentId);
				pmlPaintDocument.setPaintDocumentName(ParamUtil.getString(req, _strPmlPaintDocumnet[1]));
				pmlPaintDocument.setQuantity(Integer.parseInt(ParamUtil.getString(req, _strPmlPaintDocumnet[2], "1")));
				pmlPaintDocument.setNote(ParamUtil.getString(req, _strPmlPaintDocumnet[3]));
				pmlPaintDocument.setFileId(fileId);
				
				PmlPaintDocumentLocalServiceUtil.addPmlPaintDocument(pmlPaintDocument);
			}
		}
	}
	
	/**
	 * 
	 */
	private void updateAttachedFile(ActionRequest req, String fileId) throws Exception {

		// Xoa nhung AttachedFile nguoi dung da chon trong csdl truoc do
		PmlFileAttachedFileLocalServiceUtil.removeByFileId(fileId);
		
		/* 
		 * Lay chuoi str_attachedfile tu client
		 * Chuoi str_attachedfile co dang: ',,,,,/,,,,,/,,,,,/,,,,,/'
		 */	
		String strPmlAttachedFile = ParamUtil.getString(req, "str_attachedfile");		
		strPmlAttachedFile = strPmlAttachedFile.replace(",,,,,/", "");
		
		if(strPmlAttachedFile.equals("") == false) {
			
			String[] arrAttachedFile = strPmlAttachedFile.split("/");
			
			int size = arrAttachedFile.length;
			for(int i = 0; i < size; i ++) { 
				strPmlAttachedFile = arrAttachedFile[i];
				String[] _strPmlAttachedFile = strPmlAttachedFile.split(","); 
				
				PmlFileAttachedFile pmlFileAttachedFile = new PmlFileAttachedFileImpl();
				String pmlFileAttachedFileId = CounterUtil.increment() + "";
				
				if(_strPmlAttachedFile[0].equals("") == false) { 
					pmlFileAttachedFileId = _strPmlAttachedFile[0];
				}
				pmlFileAttachedFile.setFileAttachedFileId(pmlFileAttachedFileId);
				pmlFileAttachedFile.setAttachedFileId(_strPmlAttachedFile[1]);
				pmlFileAttachedFile.setFileId(fileId);
				pmlFileAttachedFile.setAttachedFileName(ParamUtil.getString(req, _strPmlAttachedFile[2], ""));
				pmlFileAttachedFile.setOriginal(ParamUtil.getInteger(req, _strPmlAttachedFile[3], 0));
				pmlFileAttachedFile.setCopy_(ParamUtil.getInteger(req, _strPmlAttachedFile[4], 0));
				pmlFileAttachedFile.setNote(ParamUtil.getString(req, _strPmlAttachedFile[5], ""));
				
				PmlFileAttachedFileLocalServiceUtil.addPmlFileAttachedFile(pmlFileAttachedFile);
			}
		}
	}
}
