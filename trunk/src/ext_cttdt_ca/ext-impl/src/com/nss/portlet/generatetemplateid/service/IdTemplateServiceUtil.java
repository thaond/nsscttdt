package com.nss.portlet.generatetemplateid.service;


/**
 * <a href="IdTemplateServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.generatetemplateid.service.IdTemplateService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.generatetemplateid.service.IdTemplateService
 *
 */
public class IdTemplateServiceUtil {
    private static IdTemplateService _service;

    public static java.lang.String generatedId(java.lang.Class clazz)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getService().generatedId(clazz);
    }

    public static java.lang.String generatedId(java.lang.String template)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getService().generatedId(template);
    }

    public static IdTemplateService getService() {
        if (_service == null) {
            throw new RuntimeException("IdTemplateService is not set");
        }

        return _service;
    }

    public void setService(IdTemplateService service) {
        _service = service;
    }
}
