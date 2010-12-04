package com.nss.portlet.journal.model;


/**
 * <a href="JournalStructure.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalStructure</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.nss.portlet.journal.model.impl.JournalStructureImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalStructureModel
 * @see com.nss.portlet.journal.model.impl.JournalStructureImpl
 * @see com.nss.portlet.journal.model.impl.JournalStructureModelImpl
 *
 */
public interface JournalStructure extends JournalStructureModel {
    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);

    public java.lang.String getMergedXsd();
}
