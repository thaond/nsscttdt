package com.sgs.portlet.generatetemplateid.service.http;

import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;


/**
 * <a href="IdTemplateServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil</code>
 * service utility. The static methods of this class calls the same methods of
 * the service utility. However, the signatures are different because it is
 * difficult for JSON to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONArray</code>. If the method in the
 * service utility returns a <code>com.sgs.portlet.generatetemplateid.model.IdTemplate</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.sgs.portlet.generatetemplateid.service.http.IdTemplateJSONSerializer</code>.
 * </p>
 *
 * <p>
 * This allows you to call the the backend services directly from JavaScript.
 * See <code>portal-web/docroot/html/portlet/tags_admin/unpacked.js</code> for a
 * reference of how that portlet uses the generated JavaScript in
 * <code>portal-web/docroot/html/js/service.js</code> to call the backend
 * services directly from JavaScript.
 * </p>
 *
 * <p>
 * The JSON utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil
 * @see com.sgs.portlet.generatetemplateid.service.http.IdTemplateJSONSerializer
 *
 */
public class IdTemplateServiceJSON {
    public static java.lang.String generatedId(java.lang.String template)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        java.lang.String returnValue = IdTemplateServiceUtil.generatedId(template);

        return returnValue;
    }

    public static java.lang.String generatedId(java.lang.Class clazz)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        java.lang.String returnValue = IdTemplateServiceUtil.generatedId(clazz);

        return returnValue;
    }

    public static java.lang.String generatedStringId(java.lang.String template)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        java.lang.String returnValue = IdTemplateServiceUtil.generatedStringId(template);

        return returnValue;
    }
}
