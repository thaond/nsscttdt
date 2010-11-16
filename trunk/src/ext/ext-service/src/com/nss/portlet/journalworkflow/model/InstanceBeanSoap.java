package com.nss.portlet.journalworkflow.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="InstanceBeanSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journalworkflow.service.http.InstanceBeanServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.http.InstanceBeanServiceSoap
 *
 */
public class InstanceBeanSoap implements Serializable {
    private long _processInstanceId;
    private long _businessProcessId;
    private long _articleId;
    private long _categoryId;
    private String _previousNode;
    private String _status;
    private long _createUserId;
    private boolean _finish;

    public InstanceBeanSoap() {
    }

    public static InstanceBeanSoap toSoapModel(InstanceBean model) {
        InstanceBeanSoap soapModel = new InstanceBeanSoap();

        soapModel.setProcessInstanceId(model.getProcessInstanceId());
        soapModel.setBusinessProcessId(model.getBusinessProcessId());
        soapModel.setArticleId(model.getArticleId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setPreviousNode(model.getPreviousNode());
        soapModel.setStatus(model.getStatus());
        soapModel.setCreateUserId(model.getCreateUserId());
        soapModel.setFinish(model.getFinish());

        return soapModel;
    }

    public static InstanceBeanSoap[] toSoapModels(InstanceBean[] models) {
        InstanceBeanSoap[] soapModels = new InstanceBeanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static InstanceBeanSoap[][] toSoapModels(InstanceBean[][] models) {
        InstanceBeanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new InstanceBeanSoap[models.length][models[0].length];
        } else {
            soapModels = new InstanceBeanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static InstanceBeanSoap[] toSoapModels(List<InstanceBean> models) {
        List<InstanceBeanSoap> soapModels = new ArrayList<InstanceBeanSoap>(models.size());

        for (InstanceBean model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new InstanceBeanSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _processInstanceId;
    }

    public void setPrimaryKey(long pk) {
        setProcessInstanceId(pk);
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        _processInstanceId = processInstanceId;
    }

    public long getBusinessProcessId() {
        return _businessProcessId;
    }

    public void setBusinessProcessId(long businessProcessId) {
        _businessProcessId = businessProcessId;
    }

    public long getArticleId() {
        return _articleId;
    }

    public void setArticleId(long articleId) {
        _articleId = articleId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getPreviousNode() {
        return _previousNode;
    }

    public void setPreviousNode(String previousNode) {
        _previousNode = previousNode;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public long getCreateUserId() {
        return _createUserId;
    }

    public void setCreateUserId(long createUserId) {
        _createUserId = createUserId;
    }

    public boolean getFinish() {
        return _finish;
    }

    public boolean isFinish() {
        return _finish;
    }

    public void setFinish(boolean finish) {
        _finish = finish;
    }
}
