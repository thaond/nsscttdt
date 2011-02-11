package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentRecordToPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo create(
        long documentRecordToId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo remove(
        long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordTo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordTo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByPrimaryKey(
        long documentRecordToId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByPrimaryKey(
        long documentRecordToId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDateCreate_First(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDateCreate_Last(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDateCreate_PrevAndNext(
        long documentRecordToId, java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByCurrentRecord_First(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByCurrentRecord_Last(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByCurrentRecord_PrevAndNext(
        long documentRecordToId, long currentRecord,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartmentsId_PrevAndNext(
        long documentRecordToId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDocumentRecordTypeId_PrevAndNext(
        long documentRecordToId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse(
        java.lang.String yearInUse, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_First(
        java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_Last(
        java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgencyId_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocYear_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocYear_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartDocYear_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocAgency_First(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDepartDocAgency_Last(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByDepartDocAgency_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_First(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_Last(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgencyId_Year_DocumentRecordTo_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        java.lang.String yearInUse, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        java.lang.String agencyId, int documentRecordTypeId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgency_DocumentType_First(
        java.lang.String agencyId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByAgency_DocumentType_Last(
        java.lang.String agencyId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByAgency_DocumentType_PrevAndNext(
        long documentRecordToId, java.lang.String agencyId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_AgencyId_First(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_AgencyId_Last(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_AgencyId_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo[] findByYearInUse_DepartmentsId_PrevAndNext(
        long documentRecordToId, java.lang.String yearInUse,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException;

    public void removeByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByYearInUse(java.lang.String yearInUse)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public void removeByAgency_DocumentType(java.lang.String agencyId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;

    public void removeByYearInUse_AgencyId(java.lang.String yearInUse,
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public void removeByYearInUse_DepartmentsId(java.lang.String yearInUse,
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException;

    public int countByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByYearInUse(java.lang.String yearInUse)
        throws com.liferay.portal.SystemException;

    public int countByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public int countByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByAgencyId_Year_DocumentRecordTo(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public int countByAgency_DocumentType(java.lang.String agencyId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeId_AgencyId(int documentRecordTypeId,
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public int countByYearInUse_AgencyId(java.lang.String yearInUse,
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public int countByYearInUse_DepartmentsId(java.lang.String yearInUse,
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
