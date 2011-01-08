package com.sgs.portlet.recievergroup.model;


/**
 * <a href="RecieverGroup.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>RecieverGroup</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.model.RecieverGroupModel
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverGroupModelImpl
 *
 */
public interface RecieverGroup extends RecieverGroupModel {
    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers();
}
