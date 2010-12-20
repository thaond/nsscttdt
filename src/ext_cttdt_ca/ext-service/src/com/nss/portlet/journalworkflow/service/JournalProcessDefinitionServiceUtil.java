package com.nss.portlet.journalworkflow.service;


/**
 * <a href="JournalProcessDefinitionServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService
 *
 */
public class JournalProcessDefinitionServiceUtil {
    private static JournalProcessDefinitionService _service;

    public static JournalProcessDefinitionService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "JournalProcessDefinitionService is not set");
        }

        return _service;
    }

    public void setService(JournalProcessDefinitionService service) {
        _service = service;
    }
}
