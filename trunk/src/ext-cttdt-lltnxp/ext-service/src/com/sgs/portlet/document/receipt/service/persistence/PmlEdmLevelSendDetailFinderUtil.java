package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmLevelSendDetailFinderUtil {
    private static PmlEdmLevelSendDetailFinder _finder;

    public static int containLevelSend(int levelSendId,
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getFinder().containLevelSend(levelSendId, issuingPlaceId);
    }

    public static PmlEdmLevelSendDetailFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmLevelSendDetailFinder finder) {
        _finder = finder;
    }
}
