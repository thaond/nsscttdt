package com.nss.portlet.image_signer.action;

import java.io.File;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.image_signer.model.ImageSigner;
import com.nss.portlet.image_signer.service.ImageSignerLocalServiceUtil;

public class UpLoadAction extends PortletAction{
	private static Log _log = LogFactory.getLog(UpLoadAction.class);

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String userIdParam = ParamUtil.getString(req, "userId");
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileImageSign = uploadRequest.getFile("imageSign");
		File fileImageUnSign = uploadRequest.getFile("imageUnSign");
		long imageIdSign = 0;
		long imageIdUnSign = 0;
		try {
			if (fileImageSign.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				try {
					Image image = ImageLocalServiceUtil.updateImage(
							imageUpload, fileImageSign);
					imageIdSign = image.getImageId();
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			if (fileImageUnSign.exists()) {
				long imageUpload = CounterLocalServiceUtil.increment();
				try {
					Image image = ImageLocalServiceUtil.updateImage(
							imageUpload, fileImageUnSign);
					imageIdUnSign = image.getImageId();
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			List<ImageSigner> imageSigners = ImageSignerLocalServiceUtil.getImageSigners(-1, -1);
			long userId = Long.parseLong(userIdParam);
			boolean check = false;
			ImageSigner imageSigner=null;
			for(ImageSigner signer : imageSigners){
				if(signer.getUserId() == userId){
					check = true;
					imageSigner=signer;
				}
			}
			if(!check){
				long imageSignerId = CounterLocalServiceUtil.increment();
				imageSigner = ImageSignerLocalServiceUtil
						.createImageSigner(imageSignerId);
				if (imageIdSign != 0 && imageIdUnSign != 0) {
					imageSigner.setImageIdSign(imageIdSign);
					imageSigner.setImageIdUnSign(imageIdUnSign);
					imageSigner.setUserId(userId);
					ImageSignerLocalServiceUtil.addImageSigner(imageSigner);
				}
			}else{
				imageSigner.setImageIdSign(imageIdSign);
				imageSigner.setImageIdUnSign(imageIdUnSign);
				ImageSignerLocalServiceUtil.updateImageSigner(imageSigner);
			}
			
		} catch (SystemException e) {
			_log.error("ERROR UPLOAD IN METHOD PROCESSACTION OF "+ UpLoadAction.class + " "+ e.getMessage());
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		} else {
			return mapping.findForward("portlet.nss.image_signer.upload");
		}
	}
}
