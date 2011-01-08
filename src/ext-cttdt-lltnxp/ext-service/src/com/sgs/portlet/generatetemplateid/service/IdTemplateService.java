package com.sgs.portlet.generatetemplateid.service;


/**
 * <a href="IdTemplateService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.generatetemplateid.service.impl.IdTemplateServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil
 *
 */
public interface IdTemplateService {
    public java.lang.String generatedId(java.lang.String template)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public java.lang.String generatedId(java.lang.Class clazz)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;

    public java.lang.String generatedStringId(java.lang.String template)
        throws java.rmi.RemoteException, com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
}
