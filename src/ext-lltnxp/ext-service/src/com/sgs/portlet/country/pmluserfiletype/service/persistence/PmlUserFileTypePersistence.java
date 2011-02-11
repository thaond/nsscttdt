package com.sgs.portlet.country.pmluserfiletype.service.persistence;

public interface PmlUserFileTypePersistence {
    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType create(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK);

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType remove(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType remove(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlUserFileType pmlUserFileType, boolean merge)</code>.
     */
    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType update(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUserFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUserFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType update(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType updateImpl(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByPrimaryKey(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType fetchByPrimaryKey(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType[] findByUserId_PrevAndNext(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType[] findByFileTypeId_PrevAndNext(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
