package com.sgs.portlet.career.service.persistence;

public interface CareerPersistence {
    public com.sgs.portlet.career.model.Career create(java.lang.String careerId);

    public com.sgs.portlet.career.model.Career remove(java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career remove(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Career career, boolean merge)</code>.
     */
    public com.sgs.portlet.career.model.Career update(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                career the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when career is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.career.model.Career update(
        com.sgs.portlet.career.model.Career career, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career updateImpl(
        com.sgs.portlet.career.model.Career career, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career findByPrimaryKey(
        java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career fetchByPrimaryKey(
        java.lang.String careerId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career findByCareerCode_First(
        java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career findByCareerCode_Last(
        java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career[] findByCareerCode_PrevAndNext(
        java.lang.String careerId, java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career findByCareerName_First(
        java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career findByCareerName_Last(
        java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career[] findByCareerName_PrevAndNext(
        java.lang.String careerId, java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career[] findByDescription_PrevAndNext(
        java.lang.String careerId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.career.model.Career findByC_N_D_First(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career findByC_N_D_Last(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public com.sgs.portlet.career.model.Career[] findByC_N_D_PrevAndNext(
        java.lang.String careerId, java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.career.model.Career> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCareerCode(java.lang.String careerCode)
        throws com.liferay.portal.SystemException;

    public void removeByCareerName(java.lang.String careerName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCareerCode(java.lang.String careerCode)
        throws com.liferay.portal.SystemException;

    public int countByCareerName(java.lang.String careerName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
