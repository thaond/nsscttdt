package com.sgs.portlet.pmlissuingplace.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlaceSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmIssuingPlaceModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmIssuingPlace</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace
 * @see com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlaceModel
 * @see com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl
 *
 */
public class PmlEdmIssuingPlaceModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_issuingplace";
    public static final Object[][] TABLE_COLUMNS = {
            { "issuingplaceid", new Integer(Types.VARCHAR) },
            

            { "issuingplacename", new Integer(Types.VARCHAR) },
            

            { "tablephone", new Integer(Types.VARCHAR) },
            

            { "handphone", new Integer(Types.VARCHAR) },
            

            { "email", new Integer(Types.VARCHAR) },
            

            { "address", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "issuingplacecode", new Integer(Types.VARCHAR) },
            

            { "signer", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_issuingplace (issuingplaceid VARCHAR(75) not null primary key,issuingplacename VARCHAR(75) null,tablephone VARCHAR(75) null,handphone VARCHAR(75) null,email VARCHAR(75) null,address VARCHAR(75) null,active VARCHAR(75) null,note VARCHAR(75) null,issuingplacecode VARCHAR(75) null,signer VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_issuingplace";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"));
    private String _issuingPlaceId;
    private String _issuingPlaceName;
    private String _tablePhone;
    private String _handPhone;
    private String _email;
    private String _address;
    private String _active;
    private String _note;
    private String _issuingPlaceCode;
    private String _signer;

    public PmlEdmIssuingPlaceModelImpl() {
    }

    public static PmlEdmIssuingPlace toModel(PmlEdmIssuingPlaceSoap soapModel) {
        PmlEdmIssuingPlace model = new PmlEdmIssuingPlaceImpl();

        model.setIssuingPlaceId(soapModel.getIssuingPlaceId());
        model.setIssuingPlaceName(soapModel.getIssuingPlaceName());
        model.setTablePhone(soapModel.getTablePhone());
        model.setHandPhone(soapModel.getHandPhone());
        model.setEmail(soapModel.getEmail());
        model.setAddress(soapModel.getAddress());
        model.setActive(soapModel.getActive());
        model.setNote(soapModel.getNote());
        model.setIssuingPlaceCode(soapModel.getIssuingPlaceCode());
        model.setSigner(soapModel.getSigner());

        return model;
    }

    public static List<PmlEdmIssuingPlace> toModels(
        PmlEdmIssuingPlaceSoap[] soapModels) {
        List<PmlEdmIssuingPlace> models = new ArrayList<PmlEdmIssuingPlace>(soapModels.length);

        for (PmlEdmIssuingPlaceSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _issuingPlaceId;
    }

    public void setPrimaryKey(String pk) {
        setIssuingPlaceId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _issuingPlaceId;
    }

    public String getIssuingPlaceId() {
        return GetterUtil.getString(_issuingPlaceId);
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        if (((issuingPlaceId == null) && (_issuingPlaceId != null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId == null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId != null) &&
                !issuingPlaceId.equals(_issuingPlaceId))) {
            _issuingPlaceId = issuingPlaceId;
        }
    }

    public String getIssuingPlaceName() {
        return GetterUtil.getString(_issuingPlaceName);
    }

    public void setIssuingPlaceName(String issuingPlaceName) {
        if (((issuingPlaceName == null) && (_issuingPlaceName != null)) ||
                ((issuingPlaceName != null) && (_issuingPlaceName == null)) ||
                ((issuingPlaceName != null) && (_issuingPlaceName != null) &&
                !issuingPlaceName.equals(_issuingPlaceName))) {
            _issuingPlaceName = issuingPlaceName;
        }
    }

    public String getTablePhone() {
        return GetterUtil.getString(_tablePhone);
    }

    public void setTablePhone(String tablePhone) {
        if (((tablePhone == null) && (_tablePhone != null)) ||
                ((tablePhone != null) && (_tablePhone == null)) ||
                ((tablePhone != null) && (_tablePhone != null) &&
                !tablePhone.equals(_tablePhone))) {
            _tablePhone = tablePhone;
        }
    }

    public String getHandPhone() {
        return GetterUtil.getString(_handPhone);
    }

    public void setHandPhone(String handPhone) {
        if (((handPhone == null) && (_handPhone != null)) ||
                ((handPhone != null) && (_handPhone == null)) ||
                ((handPhone != null) && (_handPhone != null) &&
                !handPhone.equals(_handPhone))) {
            _handPhone = handPhone;
        }
    }

    public String getEmail() {
        return GetterUtil.getString(_email);
    }

    public void setEmail(String email) {
        if (((email == null) && (_email != null)) ||
                ((email != null) && (_email == null)) ||
                ((email != null) && (_email != null) && !email.equals(_email))) {
            _email = email;
        }
    }

    public String getAddress() {
        return GetterUtil.getString(_address);
    }

    public void setAddress(String address) {
        if (((address == null) && (_address != null)) ||
                ((address != null) && (_address == null)) ||
                ((address != null) && (_address != null) &&
                !address.equals(_address))) {
            _address = address;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
        }
    }

    public String getIssuingPlaceCode() {
        return GetterUtil.getString(_issuingPlaceCode);
    }

    public void setIssuingPlaceCode(String issuingPlaceCode) {
        if (((issuingPlaceCode == null) && (_issuingPlaceCode != null)) ||
                ((issuingPlaceCode != null) && (_issuingPlaceCode == null)) ||
                ((issuingPlaceCode != null) && (_issuingPlaceCode != null) &&
                !issuingPlaceCode.equals(_issuingPlaceCode))) {
            _issuingPlaceCode = issuingPlaceCode;
        }
    }

    public String getSigner() {
        return GetterUtil.getString(_signer);
    }

    public void setSigner(String signer) {
        if (((signer == null) && (_signer != null)) ||
                ((signer != null) && (_signer == null)) ||
                ((signer != null) && (_signer != null) &&
                !signer.equals(_signer))) {
            _signer = signer;
        }
    }

    public PmlEdmIssuingPlace toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmIssuingPlace) this;
        } else {
            PmlEdmIssuingPlace model = new PmlEdmIssuingPlaceImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setIssuingPlaceId(HtmlUtil.escape(getIssuingPlaceId()));
            model.setIssuingPlaceName(HtmlUtil.escape(getIssuingPlaceName()));
            model.setTablePhone(HtmlUtil.escape(getTablePhone()));
            model.setHandPhone(HtmlUtil.escape(getHandPhone()));
            model.setEmail(HtmlUtil.escape(getEmail()));
            model.setAddress(HtmlUtil.escape(getAddress()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setNote(HtmlUtil.escape(getNote()));
            model.setIssuingPlaceCode(HtmlUtil.escape(getIssuingPlaceCode()));
            model.setSigner(HtmlUtil.escape(getSigner()));

            model = (PmlEdmIssuingPlace) Proxy.newProxyInstance(PmlEdmIssuingPlace.class.getClassLoader(),
                    new Class[] { PmlEdmIssuingPlace.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmIssuingPlaceImpl clone = new PmlEdmIssuingPlaceImpl();

        clone.setIssuingPlaceId(getIssuingPlaceId());
        clone.setIssuingPlaceName(getIssuingPlaceName());
        clone.setTablePhone(getTablePhone());
        clone.setHandPhone(getHandPhone());
        clone.setEmail(getEmail());
        clone.setAddress(getAddress());
        clone.setActive(getActive());
        clone.setNote(getNote());
        clone.setIssuingPlaceCode(getIssuingPlaceCode());
        clone.setSigner(getSigner());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmIssuingPlaceImpl pmlEdmIssuingPlace = (PmlEdmIssuingPlaceImpl) obj;

        int value = 0;

        value = getIssuingPlaceName().toLowerCase()
                    .compareTo(pmlEdmIssuingPlace.getIssuingPlaceName()
                                                 .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmIssuingPlaceImpl pmlEdmIssuingPlace = null;

        try {
            pmlEdmIssuingPlace = (PmlEdmIssuingPlaceImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlEdmIssuingPlace.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }
}
