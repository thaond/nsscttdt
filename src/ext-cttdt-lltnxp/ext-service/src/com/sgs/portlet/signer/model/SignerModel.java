package com.sgs.portlet.signer.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="SignerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Signer</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.model.Signer
 * @see com.sgs.portlet.signer.model.impl.SignerImpl
 * @see com.sgs.portlet.signer.model.impl.SignerModelImpl
 *
 */
public interface SignerModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getSignerId();

    public void setSignerId(long signerId);

    public long getUserId();

    public void setUserId(long userId);

    public Signer toEscapedModel();
}
