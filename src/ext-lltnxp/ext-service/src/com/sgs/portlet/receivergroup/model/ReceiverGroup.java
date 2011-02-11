package com.sgs.portlet.receivergroup.model;


/**
 * <a href="ReceiverGroup.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ReceiverGroup</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.sgs.portlet.receivergroup.model.impl.ReceiverGroupImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.model.ReceiverGroupModel
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverGroupImpl
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverGroupModelImpl
 *
 */
public interface ReceiverGroup extends ReceiverGroupModel {
    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers();
}
