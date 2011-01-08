package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmBookDocumentSendPersistence {
    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend create(
        long bookDocumentSendId);

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend remove(
        long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentSend pmlEdmBookDocumentSend, boolean merge)</code>.
     */
    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmBookDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmBookDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByPrimaryKey(
        long bookDocumentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByPrimaryKey(
        long bookDocumentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDateCreated_PrevAndNext(
        long bookDocumentSendId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByCurrentRecord_First(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByCurrentRecord_Last(
        long currentRecord, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByCurrentRecord_PrevAndNext(
        long bookDocumentSendId, long currentRecord,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartmentsId_PrevAndNext(
        long bookDocumentSendId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByAgencyId_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocYear(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocYear_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocYear_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartDocYear_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByDepartDocAgency(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocAgency_First(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDepartDocAgency_Last(
        java.lang.String agencyId, java.lang.String departmentsId,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByDepartDocAgency_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_First(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_Last(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByAgencyId_YearInUse_DocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, java.lang.String agencyId,
        java.lang.String yearInUse, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        java.lang.String yearInUse, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_AgencyId_First(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_AgencyId_Last(
        java.lang.String yearInUse, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByYearInUse_AgencyId_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        java.lang.String yearInUse, java.lang.String departmentsId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_First(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_Last(
        java.lang.String yearInUse, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend[] findByYearInUse_DepartmentsId_PrevAndNext(
        long bookDocumentSendId, java.lang.String yearInUse,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public void removeByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;

    public void removeByYearInUse_AgencyId(java.lang.String yearInUse,
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public void removeByYearInUse_DepartmentsId(java.lang.String yearInUse,
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public int countByCurrentRecord(long currentRecord)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public int countByDepartDocYear(java.lang.String yearInUse,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByDepartDocAgency(java.lang.String agencyId,
        java.lang.String departmentsId, int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countByAgencyId_YearInUse_DocumentRecordTypeId(
        java.lang.String agencyId, java.lang.String yearInUse,
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
