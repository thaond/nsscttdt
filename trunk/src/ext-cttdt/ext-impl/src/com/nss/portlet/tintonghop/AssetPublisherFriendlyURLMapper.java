package com.nss.portlet.tintonghop;

import com.liferay.portal.kernel.portlet.BaseFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortletKeys;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

public class AssetPublisherFriendlyURLMapper extends BaseFriendlyURLMapper {

	public String buildPath(LiferayPortletURL portletURL) {
		String friendlyURLPath = null;

		String strutsAction = GetterUtil.getString(
			portletURL.getParameter("struts_action"));

		WindowState windowState = portletURL.getWindowState();

		if ((strutsAction.equals("/nss/tintonghop/view_content"))  &&
			((windowState == null) ||
			 (!windowState.equals(LiferayWindowState.EXCLUSIVE)))) {

			String portletId = portletURL.getPortletId();
			String assetId = portletURL.getParameter("assetId");
			String type = GetterUtil.getString(
				portletURL.getParameter("type"), "content");
			String urlTitle = portletURL.getParameter("urlTitle");

			if (Validator.isNotNull(portletId) &&
				Validator.isNotNull(assetId)) {

				if (portletId.equals(_PORTLET_DEFAULT_INSTANCE)) {
					portletId = _PORTLET_ID;
				}

				int pos = portletId.indexOf("_INSTANCE_");

				String instanceId = null;

				if (pos > 0) {
					instanceId = portletId.substring(pos + 10);
				}
				else {
					instanceId = portletId;
				}

				friendlyURLPath =
					"/nss/tintonghop/" + instanceId + StringPool.SLASH + type +
						StringPool.SLASH;

				if (Validator.isNotNull(urlTitle)){
					friendlyURLPath += urlTitle;
					portletURL.addParameterIncludedInPath("urlTitle");
				}
				else {
					friendlyURLPath += "id/" + assetId;
				}

				portletURL.addParameterIncludedInPath("type");
				portletURL.addParameterIncludedInPath("assetId");
			}
		}

		if (Validator.isNotNull(friendlyURLPath)) {
			portletURL.addParameterIncludedInPath("p_p_id");

			portletURL.addParameterIncludedInPath("struts_action");
		}
		
		return friendlyURLPath;
	}

	public String getMapping() {
		return _MAPPING;
	}

	public String getPortletId() {
		return _PORTLET_ID;
	}

	public void populateParams(
		String friendlyURLPath, Map<String, String[]> params) {

		int x = friendlyURLPath.indexOf(StringPool.SLASH, 1);

		String[] urlFragments = StringUtil.split(
			friendlyURLPath.substring(x + 1), StringPool.SLASH);

		if (urlFragments.length > 2) {
			String instanceId = urlFragments[0];
			String type = urlFragments[1];
			String assetId = null;
			String urlTitle = null;

			if (urlFragments.length > 3) {
				assetId = urlFragments[3];
			}
			else {
				urlTitle = urlFragments[2];
			}

			String portletId = _PORTLET_ID + "_INSTANCE_" + instanceId;

		   if (Validator.equals(portletId, _PORTLET_ID)) {
				portletId = _PORTLET_DEFAULT_INSTANCE;

				params.put("p_p_id", new String[] {portletId});
				params.put(
					"p_p_state",
					new String[] {WindowState.MAXIMIZED.toString()});
			}
			else {
				params.put("p_p_id", new String[] {portletId});
				params.put(
					"p_p_state", new String[] {WindowState.NORMAL.toString()});
			}

			params.put("p_p_lifecycle", new String[] {"0"});
			params.put("p_p_mode", new String[] {PortletMode.VIEW.toString()});

			String namespace =
				StringPool.UNDERLINE + portletId + StringPool.UNDERLINE;

			params.put(
				namespace + "struts_action",
				new String[] {"/nss/tintonghop/view_content"});

			if (Validator.isNotNull(assetId)) {
				params.put(namespace + "assetId", new String[] {assetId});
			}
			else {
				params.put(namespace + "type", new String[] {type});
				params.put(namespace + "urlTitle", new String[] {urlTitle});
			}
		}
	}

	private static final String _MAPPING = "tintonghop";

	private static final String _PORTLET_DEFAULT_INSTANCE =
		PortletKeys.ASSET_PUBLISHER + "_INSTANCE_0000";

	private static final String _PORTLET_ID = "10140";//PortletKeys.ASSET_PUBLISHER;

}