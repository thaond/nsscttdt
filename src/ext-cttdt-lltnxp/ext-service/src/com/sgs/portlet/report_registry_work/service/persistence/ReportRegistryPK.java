package com.sgs.portlet.report_registry_work.service.persistence;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class ReportRegistryPK implements Comparable<ReportRegistryPK>,
    Serializable {
    public long reportRegistryId;
    public String reportRegistryCode;

    public ReportRegistryPK() {
    }

    public ReportRegistryPK(long reportRegistryId, String reportRegistryCode) {
        this.reportRegistryId = reportRegistryId;
        this.reportRegistryCode = reportRegistryCode;
    }

    public long getReportRegistryId() {
        return reportRegistryId;
    }

    public void setReportRegistryId(long reportRegistryId) {
        this.reportRegistryId = reportRegistryId;
    }

    public String getReportRegistryCode() {
        return reportRegistryCode;
    }

    public void setReportRegistryCode(String reportRegistryCode) {
        this.reportRegistryCode = reportRegistryCode;
    }

    public int compareTo(ReportRegistryPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (reportRegistryId < pk.reportRegistryId) {
            value = -1;
        } else if (reportRegistryId > pk.reportRegistryId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = reportRegistryCode.compareTo(pk.reportRegistryCode);

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ReportRegistryPK pk = null;

        try {
            pk = (ReportRegistryPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((reportRegistryId == pk.reportRegistryId) &&
                (reportRegistryCode.equals(pk.reportRegistryCode))) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (String.valueOf(reportRegistryId) +
        String.valueOf(reportRegistryCode)).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("reportRegistryId");
        sb.append(StringPool.EQUAL);
        sb.append(reportRegistryId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("reportRegistryCode");
        sb.append(StringPool.EQUAL);
        sb.append(reportRegistryCode);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
