package com.nss.portlet.digitalsignature.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="CertificateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Certificate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.model.Certificate
 * @see com.nss.portlet.digitalsignature.model.impl.CertificateImpl
 * @see com.nss.portlet.digitalsignature.model.impl.CertificateModelImpl
 *
 */
public interface CertificateModel extends BaseModel<Certificate> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getUserId();

    public void setUserId(long userId);

    public String getX509Certificate();

    public void setX509Certificate(String x509Certificate);

    public Certificate toEscapedModel();
}
