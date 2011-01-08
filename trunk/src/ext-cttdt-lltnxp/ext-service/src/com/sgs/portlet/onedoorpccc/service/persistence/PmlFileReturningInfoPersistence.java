package com.sgs.portlet.onedoorpccc.service.persistence;

public interface PmlFileReturningInfoPersistence {
    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo create(
        long fileReturningInfoId);

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo remove(
        long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo remove(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo update(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileReturningInfo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileReturningInfo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo update(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByPrimaryKey(
        long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo fetchByPrimaryKey(
        long fileReturningInfoId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByFileId_PrevAndNext(
        long fileReturningInfoId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileSender_First(
        java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileSender_Last(
        java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByFileSender_PrevAndNext(
        long fileReturningInfoId, java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByLicenseNumber_First(
        java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByLicenseNumber_Last(
        java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByLicenseNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByIssuingDateLicense_First(
        java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByIssuingDateLicense_Last(
        java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByIssuingDateLicense_PrevAndNext(
        long fileReturningInfoId, java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByReceiveLicenseDate_First(
        java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByReceiveLicenseDate_Last(
        java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByReceiveLicenseDate_PrevAndNext(
        long fileReturningInfoId, java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByDocumentNumber_First(
        java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByDocumentNumber_Last(
        java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByDocumentNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByBillNumber_First(
        java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByBillNumber_Last(
        java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByBillNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNumberMoney_First(
        long numberMoney, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNumberMoney_Last(
        long numberMoney, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByNumberMoney_PrevAndNext(
        long fileReturningInfoId, long numberMoney,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByNote_PrevAndNext(
        long fileReturningInfoId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByConclude_First(
        java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByConclude_Last(
        java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByConclude_PrevAndNext(
        long fileReturningInfoId, java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo fetchByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public void removeByFileSender(java.lang.String fileSender)
        throws com.liferay.portal.SystemException;

    public void removeByLicenseNumber(java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingDateLicense(java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException;

    public void removeByReceiveLicenseDate(java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentNumber(java.lang.String documentNumber)
        throws com.liferay.portal.SystemException;

    public void removeByBillNumber(java.lang.String billNumber)
        throws com.liferay.portal.SystemException;

    public void removeByNumberMoney(long numberMoney)
        throws com.liferay.portal.SystemException;

    public void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public void removeByConclude(java.lang.String conclude)
        throws com.liferay.portal.SystemException;

    public void removeByFileReturningInfoIdFileId(java.lang.String fileId,
        long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public int countByFileSender(java.lang.String fileSender)
        throws com.liferay.portal.SystemException;

    public int countByLicenseNumber(java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException;

    public int countByIssuingDateLicense(java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException;

    public int countByReceiveLicenseDate(java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException;

    public int countByDocumentNumber(java.lang.String documentNumber)
        throws com.liferay.portal.SystemException;

    public int countByBillNumber(java.lang.String billNumber)
        throws com.liferay.portal.SystemException;

    public int countByNumberMoney(long numberMoney)
        throws com.liferay.portal.SystemException;

    public int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public int countByConclude(java.lang.String conclude)
        throws com.liferay.portal.SystemException;

    public int countByFileReturningInfoIdFileId(java.lang.String fileId,
        long fileReturningInfoId) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
