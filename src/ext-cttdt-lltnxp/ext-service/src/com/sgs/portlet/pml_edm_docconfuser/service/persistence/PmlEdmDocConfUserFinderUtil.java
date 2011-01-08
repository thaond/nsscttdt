package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

public class PmlEdmDocConfUserFinderUtil {
    private static PmlEdmDocConfUserFinder _finder;

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAllRecDocLogByDocIdList(
        java.util.ArrayList<Long> recDocIdList)
        throws com.liferay.portal.SystemException {
        return getFinder().findAllRecDocLogByDocIdList(recDocIdList);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAllSendDocLogByDocIdList(
        java.util.ArrayList<Long> senDocIdList)
        throws com.liferay.portal.SystemException {
        return getFinder().findAllSendDocLogByDocIdList(senDocIdList);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAllDepByUserIdList(
        java.util.ArrayList<Long> userIdList)
        throws com.liferay.portal.SystemException {
        return getFinder().findAllDepByUserIdList(userIdList);
    }

    public static PmlEdmDocConfUserFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocConfUserFinder finder) {
        _finder = finder;
    }
}
