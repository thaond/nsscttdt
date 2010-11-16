package com.nss.portlet.digitalsignature.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="SignatureModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Signature</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.model.Signature
 * @see com.nss.portlet.digitalsignature.model.impl.SignatureImpl
 * @see com.nss.portlet.digitalsignature.model.impl.SignatureModelImpl
 *
 */
public interface SignatureModel extends BaseModel<Signature> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getSignatureId();

    public void setSignatureId(long signatureId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public long getArticleId();

    public void setArticleId(long articleId);

    public String getSignData();

    public void setSignData(String signData);

    public Signature toEscapedModel();
}
