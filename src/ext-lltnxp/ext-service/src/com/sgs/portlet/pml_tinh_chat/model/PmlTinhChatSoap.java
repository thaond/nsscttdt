package com.sgs.portlet.pml_tinh_chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTinhChatSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceSoap
 *
 */
public class PmlTinhChatSoap implements Serializable {
    private long _idTinhChat;
    private String _tenTinhChat;

    public PmlTinhChatSoap() {
    }

    public static PmlTinhChatSoap toSoapModel(PmlTinhChat model) {
        PmlTinhChatSoap soapModel = new PmlTinhChatSoap();

        soapModel.setIdTinhChat(model.getIdTinhChat());
        soapModel.setTenTinhChat(model.getTenTinhChat());

        return soapModel;
    }

    public static PmlTinhChatSoap[] toSoapModels(List<PmlTinhChat> models) {
        List<PmlTinhChatSoap> soapModels = new ArrayList<PmlTinhChatSoap>(models.size());

        for (PmlTinhChat model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTinhChatSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idTinhChat;
    }

    public void setPrimaryKey(long pk) {
        setIdTinhChat(pk);
    }

    public long getIdTinhChat() {
        return _idTinhChat;
    }

    public void setIdTinhChat(long idTinhChat) {
        _idTinhChat = idTinhChat;
    }

    public String getTenTinhChat() {
        return _tenTinhChat;
    }

    public void setTenTinhChat(String tenTinhChat) {
        _tenTinhChat = tenTinhChat;
    }
}
