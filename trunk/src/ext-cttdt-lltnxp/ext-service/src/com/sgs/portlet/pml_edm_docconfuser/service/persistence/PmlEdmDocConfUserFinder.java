package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

public interface PmlEdmDocConfUserFinder {
    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAllRecDocLogByDocIdList(
        java.util.ArrayList<Long> recDocIdList)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAllSendDocLogByDocIdList(
        java.util.ArrayList<Long> senDocIdList)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAllDepByUserIdList(
        java.util.ArrayList<Long> userIdList)
        throws com.liferay.portal.SystemException;
}
