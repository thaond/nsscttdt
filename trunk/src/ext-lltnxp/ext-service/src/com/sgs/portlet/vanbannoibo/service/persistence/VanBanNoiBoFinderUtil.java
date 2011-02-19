package com.sgs.portlet.vanbannoibo.service.persistence;

public class VanBanNoiBoFinderUtil {
    private static VanBanNoiBoFinder _finder;

    public static VanBanNoiBoFinder getFinder() {
        return _finder;
    }

    public void setFinder(VanBanNoiBoFinder finder) {
        _finder = finder;
    }
}
