package com.sgs.portlet.generatetemplateid.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;


/**
 * <a href="IdTemplateServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>com.liferay.portal.security.auth.HttpPrincipal</code>
 * parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <code>tunnel.servlet.hosts.allowed</code> in
 * portal.properties to configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.security.auth.HttpPrincipal
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil
 * @see com.sgs.portlet.generatetemplateid.service.http.IdTemplateServiceSoap
 *
 */
public class IdTemplateServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(IdTemplateServiceHttp.class);

    public static java.lang.String generatedId(HttpPrincipal httpPrincipal,
        java.lang.String template)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        try {
            Object paramObj0 = template;

            if (template == null) {
                paramObj0 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(IdTemplateServiceUtil.class.getName(),
                    "generatedId", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                if (e instanceof com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) {
                    throw (com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String generatedId(HttpPrincipal httpPrincipal,
        java.lang.Class clazz)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        try {
            Object paramObj0 = clazz;

            if (clazz == null) {
                paramObj0 = new NullWrapper("java.lang.Class");
            }

            MethodWrapper methodWrapper = new MethodWrapper(IdTemplateServiceUtil.class.getName(),
                    "generatedId", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                if (e instanceof com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) {
                    throw (com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String generatedStringId(
        HttpPrincipal httpPrincipal, java.lang.String template)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        try {
            Object paramObj0 = template;

            if (template == null) {
                paramObj0 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(IdTemplateServiceUtil.class.getName(),
                    "generatedStringId", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                if (e instanceof com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) {
                    throw (com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
