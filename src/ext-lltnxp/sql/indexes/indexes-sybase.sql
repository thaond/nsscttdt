create index IX_93D5AD4E on Address (companyId)
go
create index IX_ABD7DAC0 on Address (companyId, classNameId)
go
create index IX_71CB1123 on Address (companyId, classNameId, classPK)
go
create index IX_5BC8B0D4 on Address (userId)
go

create index IX_6EDB9600 on AnnouncementsDelivery (userId)
go
create index IX_BA4413D5 on AnnouncementsDelivery (userId, type_)
go

create index IX_A6EF0B81 on AnnouncementsEntry (classNameId, classPK)
go
create index IX_D49C2E66 on AnnouncementsEntry (userId)
go
create index IX_1AFBDE08 on AnnouncementsEntry (uuid_)
go

create index IX_9C7EB9F on AnnouncementsFlag (entryId)
go
create index IX_4539A99C on AnnouncementsFlag (userId, entryId, value)
go

create index IX_72EF6041 on BlogsEntry (companyId)
go
create index IX_81A50303 on BlogsEntry (groupId)
go
create index IX_DB780A20 on BlogsEntry (groupId, urlTitle)
go
create index IX_C07CA83D on BlogsEntry (groupId, userId)
go
create index IX_69157A4D on BlogsEntry (uuid_)
go
create index IX_1B1040FD on BlogsEntry (uuid_, groupId)
go

create index IX_90CDA39A on BlogsStatsUser (companyId, entryCount)
go
create index IX_43840EEB on BlogsStatsUser (groupId)
go
create index IX_28C78D5C on BlogsStatsUser (groupId, entryCount)
go
create index IX_82254C25 on BlogsStatsUser (groupId, userId)
go
create index IX_BB51F1D9 on BlogsStatsUser (userId)
go

create index IX_443BDC38 on BookmarksEntry (folderId)
go
create index IX_B670BA39 on BookmarksEntry (uuid_)
go

create index IX_2ABA25D7 on BookmarksFolder (companyId)
go
create index IX_7F703619 on BookmarksFolder (groupId)
go
create index IX_967799C0 on BookmarksFolder (groupId, parentFolderId)
go
create index IX_451E7AE3 on BookmarksFolder (uuid_)
go
create index IX_DC2F8927 on BookmarksFolder (uuid_, groupId)
go

create index IX_12EE4898 on CalEvent (groupId)
go
create index IX_FCD7C63D on CalEvent (groupId, type_)
go
create index IX_C1AD2122 on CalEvent (uuid_)
go
create index IX_5CCE79C8 on CalEvent (uuid_, groupId)
go

create index IX_B27A301F on ClassName_ (value)
go

create index IX_38EFE3FD on Company (logoId)
go
create index IX_12566EC2 on Company (mx)
go
create index IX_975996C0 on Company (virtualHost)
go
create index IX_EC00543C on Company (webId)
go

create index IX_66D496A3 on Contact_ (companyId)
go

create index IX_717B97E1 on Country (a2)
go
create index IX_717B9BA2 on Country (a3)
go
create index IX_19DA007B on Country (name)
go

create index IX_4CB1B2B4 on DLFileEntry (companyId)
go
create index IX_24A846D1 on DLFileEntry (folderId)
go
create index IX_8F6C75D0 on DLFileEntry (folderId, name)
go
create index IX_A9951F17 on DLFileEntry (folderId, title)
go
create index IX_64F0FE40 on DLFileEntry (uuid_)
go

create index IX_CE705D48 on DLFileRank (companyId, userId, folderId, name)
go
create index IX_40B56512 on DLFileRank (folderId, name)
go
create index IX_EED06670 on DLFileRank (userId)
go

create index IX_E56EC6AD on DLFileShortcut (folderId)
go
create index IX_CA2708A2 on DLFileShortcut (toFolderId, toName)
go
create index IX_4831EBE4 on DLFileShortcut (uuid_)
go

create index IX_9CD91DB6 on DLFileVersion (folderId, name)
go
create index IX_6C5E6512 on DLFileVersion (folderId, name, version)
go

create index IX_A74DB14C on DLFolder (companyId)
go
create index IX_F2EA1ACE on DLFolder (groupId)
go
create index IX_49C37475 on DLFolder (groupId, parentFolderId)
go
create index IX_902FD874 on DLFolder (groupId, parentFolderId, name)
go
create index IX_51556082 on DLFolder (parentFolderId, name)
go
create index IX_CBC408D8 on DLFolder (uuid_)
go
create index IX_3CC1DED2 on DLFolder (uuid_, groupId)
go

create index IX_1BB072CA on EmailAddress (companyId)
go
create index IX_49D2DEC4 on EmailAddress (companyId, classNameId)
go
create index IX_551A519F on EmailAddress (companyId, classNameId, classPK)
go
create index IX_7B43CD8 on EmailAddress (userId)
go

create index IX_A8C0CBE8 on ExpandoColumn (tableId)
go
create index IX_FEFC8DA7 on ExpandoColumn (tableId, name)
go

create index IX_D3F5D7AE on ExpandoRow (tableId)
go
create index IX_81EFBFF5 on ExpandoRow (tableId, classPK)
go

create index IX_F0A86A4F on ExpandoTable (classNameId)
go
create index IX_DED782CE on ExpandoTable (classNameId, name)
go

create index IX_B29FEF17 on ExpandoValue (classNameId, classPK)
go
create index IX_F7DD0987 on ExpandoValue (columnId)
go
create index IX_9DDD21E5 on ExpandoValue (columnId, rowId_)
go
create index IX_9112A7A0 on ExpandoValue (rowId_)
go
create index IX_F0566A77 on ExpandoValue (tableId)
go
create index IX_886B68D1 on ExpandoValue (tableId, columnId, classNameId, classPK)
go
create index IX_B5984EDA on ExpandoValue (tableId, columnId, rowId_)
go
create index IX_B71E92D5 on ExpandoValue (tableId, rowId_)
go

create index IX_D0D5E397 on Group_ (companyId, classNameId, classPK)
go
create index IX_5BDDB872 on Group_ (companyId, friendlyURL)
go
create index IX_5AA68501 on Group_ (companyId, name)
go
create index IX_16218A38 on Group_ (liveGroupId)
go

create index LIFERAY_001 on Groups_Permissions (permissionId)
go

create index IX_60214CF6 on IGFolder (companyId)
go
create index IX_206498F8 on IGFolder (groupId)
go
create index IX_1A605E9F on IGFolder (groupId, parentFolderId)
go
create index IX_9BBAFB1E on IGFolder (groupId, parentFolderId, name)
go
create index IX_F73C0982 on IGFolder (uuid_)
go
create index IX_B10EFD68 on IGFolder (uuid_, groupId)
go

create index IX_E597322D on IGImage (custom1ImageId)
go
create index IX_D9E0A34C on IGImage (custom2ImageId)
go
create index IX_4438CA80 on IGImage (folderId)
go
create index IX_BCB13A3F on IGImage (folderId, name)
go
create index IX_64F0B572 on IGImage (largeImageId)
go
create index IX_D3D32126 on IGImage (smallImageId)
go
create index IX_265BB0F1 on IGImage (uuid_)
go

create index IX_6A925A4D on Image (size_)
go

create index IX_DFF98523 on JournalArticle (companyId)
go
create index IX_9356F865 on JournalArticle (groupId)
go
create index IX_68C0F69C on JournalArticle (groupId, articleId)
go
create index IX_85C52EEC on JournalArticle (groupId, articleId, version)
go
create index IX_2E207659 on JournalArticle (groupId, structureId)
go
create index IX_8DEAE14E on JournalArticle (groupId, templateId)
go
create index IX_EF9B7028 on JournalArticle (smallImageId)
go
create index IX_F029602F on JournalArticle (uuid_)
go
create index IX_3463D95B on JournalArticle (uuid_, groupId)
go

create index IX_3B51BB68 on JournalArticleImage (groupId)
go
create index IX_158B526F on JournalArticleImage (groupId, articleId, version)
go
create index IX_D67292FC on JournalArticleImage (groupId, articleId, version, elName, languageId)
go

create index IX_F8433677 on JournalArticleResource (groupId)
go
create index IX_88DF994A on JournalArticleResource (groupId, articleId)
go

create index IX_6838E427 on JournalContentSearch (groupId, articleId)
go

create index IX_35A2DB2F on JournalFeed (groupId)
go
create index IX_65576CBC on JournalFeed (groupId, feedId)
go
create index IX_50C36D79 on JournalFeed (uuid_)
go
create index IX_39031F51 on JournalFeed (uuid_, groupId)
go

create index IX_B97F5608 on JournalStructure (groupId)
go
create index IX_AB6E9996 on JournalStructure (groupId, structureId)
go
create index IX_8831E4FC on JournalStructure (structureId)
go
create index IX_6702CA92 on JournalStructure (uuid_)
go
create index IX_42E86E58 on JournalStructure (uuid_, groupId)
go

create index IX_77923653 on JournalTemplate (groupId)
go
create index IX_1701CB2B on JournalTemplate (groupId, structureId)
go
create index IX_E802AA3C on JournalTemplate (groupId, templateId)
go
create index IX_25FFB6FA on JournalTemplate (smallImageId)
go
create index IX_1B12CA20 on JournalTemplate (templateId)
go
create index IX_2857419D on JournalTemplate (uuid_)
go
create index IX_62D1B3AD on JournalTemplate (uuid_, groupId)
go

create index IX_C7FBC998 on Layout (companyId)
go
create index IX_FAD05595 on Layout (dlFolderId)
go
create index IX_C099D61A on Layout (groupId)
go
create index IX_23922F7D on Layout (iconImageId)
go

create index IX_A40B8BEC on LayoutSet (groupId)
go
create index IX_5ABC2905 on LayoutSet (virtualHost)
go

create index IX_2932DD37 on ListType (type_)
go

create index IX_69951A25 on MBBan (banUserId)
go
create index IX_5C3FF12A on MBBan (groupId)
go
create index IX_8ABC4E3B on MBBan (groupId, banUserId)
go
create index IX_48814BBA on MBBan (userId)
go

create index IX_BC735DCF on MBCategory (companyId)
go
create index IX_BB870C11 on MBCategory (groupId)
go
create index IX_ED292508 on MBCategory (groupId, parentCategoryId)
go
create index IX_C2626EDB on MBCategory (uuid_)
go
create index IX_F7D28C2F on MBCategory (uuid_, groupId)
go

create index IX_79D0120B on MBDiscussion (classNameId)
go
create index IX_33A4DE38 on MBDiscussion (classNameId, classPK)
go
create index IX_B5CA2DC on MBDiscussion (threadId)
go

create index IX_3C865EE5 on MBMessage (categoryId)
go
create index IX_138C7F1E on MBMessage (categoryId, threadId)
go
create index IX_B1432D30 on MBMessage (companyId)
go
create index IX_75B95071 on MBMessage (threadId)
go
create index IX_A7038CD7 on MBMessage (threadId, parentMessageId)
go
create index IX_C57B16BC on MBMessage (uuid_)
go

create index IX_D180D4AE on MBMessageFlag (messageId)
go
create index IX_7B2917BE on MBMessageFlag (userId)
go
create index IX_94A83834 on MBMessageFlag (userId, messageId)
go

create index IX_A00A898F on MBStatsUser (groupId)
go
create index IX_FAB5A88B on MBStatsUser (groupId, messageCount)
go
create index IX_9168E2C9 on MBStatsUser (groupId, userId)
go
create index IX_847F92B5 on MBStatsUser (userId)
go

create index IX_CB854772 on MBThread (categoryId)
go

create index IX_FA179180 on MeetingCalComponent (mcalId)
go

create index IX_F199C38B on MeetingCalendar (groupId)
go
create index IX_3B1B516 on MeetingCalendar (groupId, state)
go
create index IX_5AD0BCD5 on MeetingCalendar (uuid_)
go
create index IX_A1E35775 on MeetingCalendar (uuid_, groupId)
go

create index IX_67E076A0 on MeetingDetailWeek (mdweekId)
go
create index IX_D15DC0FF on MeetingDetailWeek (week, year)
go

create index IX_8A1CC4B on MembershipRequest (groupId)
go
create index IX_C28C72EC on MembershipRequest (groupId, statusId)
go
create index IX_66D70879 on MembershipRequest (userId)
go

create index IX_A425F71A on OrgGroupPermission (groupId)
go
create index IX_6C53DA4E on OrgGroupPermission (permissionId)
go

create index IX_4A527DD3 on OrgGroupRole (groupId)
go
create index IX_AB044D1C on OrgGroupRole (roleId)
go

create index IX_6AF0D434 on OrgLabor (organizationId)
go

create index IX_834BCEB6 on Organization_ (companyId)
go
create index IX_E301BDF5 on Organization_ (companyId, name)
go
create index IX_418E4522 on Organization_ (companyId, parentOrganizationId)
go

create index IX_D7390C66 on PML_Country (active)
go
create index IX_3A155227 on PML_Country (countryCode)
go
create index IX_10E0D02 on PML_Country (countryCode, countryName, description)
go
create index IX_4C196F45 on PML_Country (countryName)
go
create index IX_DA792540 on PML_Country (description)
go

create index IX_88570760 on PML_FILETYPE (description)
go
create index IX_128135D9 on PML_FILETYPE (fieldId)
go
create index IX_3D91D363 on PML_FILETYPE (fileTypeCode)
go
create index IX_5686E658 on PML_FILETYPE (fileTypeCode, fileTypeName)
go
create index IX_4F95F081 on PML_FILETYPE (fileTypeName)
go
create index IX_D75327B6 on PML_FILETYPE (receiptTemplate)
go

create index IX_4A476C8F on PML_IDGENERATED (curvalue)
go
create index IX_2502809B on PML_IDGENERATED (year)
go
create index IX_B91244C0 on PML_IDGENERATED (year, curvalue)
go

create index IX_584A1DA1 on PML_IDTEMPLATE (description)
go
create index IX_9C8A9C16 on PML_IDTEMPLATE (format)
go
create index IX_80B4ACD6 on PML_IDTEMPLATE (format, description)
go

create index IX_3FBFA9F4 on PasswordPolicy (companyId, name)
go

create index IX_C3A17327 on PasswordPolicyRel (classNameId, classPK)
go
create index IX_ED7CF243 on PasswordPolicyRel (passwordPolicyId, classNameId, classPK)
go

create index IX_326F75BD on PasswordTracker (userId)
go

create index IX_4D19C2B8 on Permission_ (actionId, resourceId)
go
create index IX_F090C113 on Permission_ (resourceId)
go

create index IX_9F704A14 on Phone (companyId)
go
create index IX_A2E4AFBA on Phone (companyId, classNameId)
go
create index IX_9A53569 on Phone (companyId, classNameId, classPK)
go
create index IX_F202B9CE on Phone (userId)
go

create index IX_B9746445 on PluginSetting (companyId)
go
create index IX_7171B2E8 on PluginSetting (companyId, pluginId, pluginType)
go

create index IX_EC370F10 on PollsChoice (questionId)
go
create index IX_D76DD2CF on PollsChoice (questionId, name)
go
create index IX_6660B399 on PollsChoice (uuid_)
go

create index IX_9FF342EA on PollsQuestion (groupId)
go
create index IX_51F087F4 on PollsQuestion (uuid_)
go
create index IX_F3C9F36 on PollsQuestion (uuid_, groupId)
go

create index IX_D5DF7B54 on PollsVote (choiceId)
go
create index IX_12112599 on PollsVote (questionId)
go
create index IX_1BBFD4D3 on PollsVote (questionId, userId)
go

create index IX_80CC9508 on Portlet (companyId)
go
create index IX_12B5E51D on Portlet (companyId, portletId)
go

create index IX_96BDD537 on PortletItem (groupId, classNameId)
go
create index IX_D699243F on PortletItem (groupId, name, portletId, classNameId)
go
create index IX_2C61314E on PortletItem (groupId, portletId)
go
create index IX_E922D6C0 on PortletItem (groupId, portletId, classNameId)
go
create index IX_8E71167F on PortletItem (groupId, portletId, classNameId, name)
go
create index IX_33B8CE8D on PortletItem (groupId, portletId, name)
go

create index IX_E4F13E6E on PortletPreferences (ownerId, ownerType, plid)
go
create index IX_C7057FF7 on PortletPreferences (ownerId, ownerType, plid, portletId)
go
create index IX_F15C1C4F on PortletPreferences (plid)
go
create index IX_D340DB76 on PortletPreferences (plid, portletId)
go

create index IX_16184D57 on RatingsEntry (classNameId, classPK)
go
create index IX_B47E3C11 on RatingsEntry (userId, classNameId, classPK)
go

create index IX_A6E99284 on RatingsStats (classNameId, classPK)
go

create index IX_16D87CA7 on Region (countryId)
go

create index IX_882E56F on ReportsEntry (companyId)
go
create index IX_C74E5453 on ReportsEntry (userId)
go

create index IX_717FDD47 on ResourceCode (companyId)
go
create index IX_A32C097E on ResourceCode (companyId, name, scope)
go
create index IX_AACAFF40 on ResourceCode (name)
go

create index IX_2578FBD3 on Resource_ (codeId)
go
create index IX_67DE7856 on Resource_ (codeId, primKey)
go

create index IX_449A10B9 on Role_ (companyId)
go
create index IX_A88E424E on Role_ (companyId, classNameId, classPK)
go
create index IX_EBC931B8 on Role_ (companyId, name)
go

create index LIFERAY_002 on Roles_Permissions (permissionId)
go

create index IX_C98C0D78 on SCFrameworkVersion (companyId)
go
create index IX_272991FA on SCFrameworkVersion (groupId)
go


create index IX_5D25244F on SCProductEntry (companyId)
go
create index IX_72F87291 on SCProductEntry (groupId)
go
create index IX_98E6A9CB on SCProductEntry (groupId, userId)
go
create index IX_7311E812 on SCProductEntry (repoGroupId, repoArtifactId)
go

create index IX_AE8224CC on SCProductScreenshot (fullImageId)
go
create index IX_467956FD on SCProductScreenshot (productEntryId)
go
create index IX_DA913A55 on SCProductScreenshot (productEntryId, priority)
go
create index IX_6C572DAC on SCProductScreenshot (thumbnailId)
go

create index IX_7020130F on SCProductVersion (directDownloadURL)
go
create index IX_8377A211 on SCProductVersion (productEntryId)
go

create index IX_7338606F on ServiceComponent (buildNamespace)
go
create index IX_4F0315B8 on ServiceComponent (buildNamespace, buildNumber)
go

create index IX_C28B41DC on ShoppingCart (groupId)
go
create index IX_FC46FE16 on ShoppingCart (groupId, userId)
go
create index IX_54101CC8 on ShoppingCart (userId)
go

create index IX_5F615D3E on ShoppingCategory (groupId)
go
create index IX_1E6464F5 on ShoppingCategory (groupId, parentCategoryId)
go

create index IX_DC60CFAE on ShoppingCoupon (code_)
go
create index IX_3251AF16 on ShoppingCoupon (groupId)
go

create index IX_C8EACF2E on ShoppingItem (categoryId)
go
create index IX_1C717CA6 on ShoppingItem (companyId, sku)
go
create index IX_903DC750 on ShoppingItem (largeImageId)
go
create index IX_D217AB30 on ShoppingItem (mediumImageId)
go
create index IX_FF203304 on ShoppingItem (smallImageId)
go

create index IX_6D5F9B87 on ShoppingItemField (itemId)
go

create index IX_EA6FD516 on ShoppingItemPrice (itemId)
go

create index IX_1D15553E on ShoppingOrder (groupId)
go
create index IX_119B5630 on ShoppingOrder (groupId, userId, ppPaymentStatus)
go
create index IX_D7D6E87A on ShoppingOrder (number_)
go
create index IX_F474FD89 on ShoppingOrder (ppTxnId)
go

create index IX_B5F82C7A on ShoppingOrderItem (orderId)
go

create index IX_82E39A0C on SocialActivity (classNameId)
go
create index IX_A853C757 on SocialActivity (classNameId, classPK)
go
create index IX_64B1BC66 on SocialActivity (companyId)
go
create index IX_2A2468 on SocialActivity (groupId)
go
create index IX_8F32DEC9 on SocialActivity (groupId, userId, createDate, classNameId, classPK, type_, receiverUserId)
go
create index IX_1271F25F on SocialActivity (mirrorActivityId)
go
create index IX_1F00C374 on SocialActivity (mirrorActivityId, classNameId, classPK)
go
create index IX_121CA3CB on SocialActivity (receiverUserId)
go
create index IX_3504B8BC on SocialActivity (userId)
go

create index IX_61171E99 on SocialRelation (companyId)
go
create index IX_95135D1C on SocialRelation (companyId, type_)
go
create index IX_C31A64C6 on SocialRelation (type_)
go
create index IX_5A40CDCC on SocialRelation (userId1)
go
create index IX_4B52BE89 on SocialRelation (userId1, type_)
go
create index IX_12A92145 on SocialRelation (userId1, userId2, type_)
go
create index IX_5A40D18D on SocialRelation (userId2)
go
create index IX_3F9C2FA8 on SocialRelation (userId2, type_)
go
create index IX_F0CA24A5 on SocialRelation (uuid_)
go

create index IX_A90FE5A0 on SocialRequest (companyId)
go
create index IX_32292ED1 on SocialRequest (receiverUserId)
go
create index IX_D9380CB7 on SocialRequest (receiverUserId, status)
go
create index IX_80F7A9C2 on SocialRequest (userId)
go
create index IX_36A90CA7 on SocialRequest (userId, classNameId, classPK, type_, receiverUserId)
go
create index IX_F3BFB48D on SocialRequest (userId, classNameId, classPK, type_, receiverUserId, status)
go
create index IX_CC86A444 on SocialRequest (userId, classNameId, classPK, type_, status)
go
create index IX_AB5906A8 on SocialRequest (userId, status)
go
create index IX_49D5872C on SocialRequest (uuid_)
go
create index IX_4F973EFE on SocialRequest (uuid_, groupId)
go

create index IX_786D171A on Subscription (companyId, classNameId, classPK)
go
create index IX_2E1A92D4 on Subscription (companyId, userId, classNameId, classPK)
go
create index IX_54243AFD on Subscription (userId)
go

create index IX_1AB6D6D2 on TagsAsset (classNameId, classPK)
go
create index IX_AB3D8BCB on TagsAsset (companyId)
go

create index IX_10563688 on TagsEntry (companyId, name)
go

create index IX_C134234 on TagsProperty (companyId)
go
create index IX_EB974D08 on TagsProperty (companyId, key_)
go
create index IX_5200A629 on TagsProperty (entryId)
go
create index IX_F505253D on TagsProperty (entryId, key_)
go

create index IX_181A4A1B on TasksProposal (classNameId, classPK)
go
create index IX_7FB27324 on TasksProposal (groupId)
go
create index IX_6EEC675E on TasksProposal (groupId, userId)
go

create index IX_4D0C7F8D on TasksReview (proposalId)
go
create index IX_70AFEA01 on TasksReview (proposalId, stage)
go
create index IX_36F512E6 on TasksReview (userId)
go
create index IX_5C6BE4C7 on TasksReview (userId, proposalId)
go

create index IX_524FEFCE on UserGroup (companyId)
go
create index IX_23EAD0D on UserGroup (companyId, name)
go
create index IX_69771487 on UserGroup (companyId, parentUserGroupId)
go

create index IX_1B988D7A on UserGroupRole (groupId)
go
create index IX_871412DF on UserGroupRole (groupId, roleId)
go
create index IX_887A2C95 on UserGroupRole (roleId)
go
create index IX_887BE56A on UserGroupRole (userId)
go
create index IX_4D040680 on UserGroupRole (userId, groupId)
go

create index IX_41A32E0D on UserIdMapper (type_, externalUserId)
go
create index IX_E60EA987 on UserIdMapper (userId)
go
create index IX_D1C44A6E on UserIdMapper (userId, type_)
go

create index IX_29BA1CF5 on UserTracker (companyId)
go
create index IX_46B0AE8E on UserTracker (sessionId)
go
create index IX_E4EFBA8D on UserTracker (userId)
go

create index IX_14D8BCC0 on UserTrackerPath (userTrackerId)
go

create index IX_3A1E834E on User_ (companyId)
go
create index IX_615E9F7A on User_ (companyId, emailAddress)
go
create index IX_765A87C6 on User_ (companyId, password_)
go
create index IX_C5806019 on User_ (companyId, screenName)
go
create index IX_9782AD88 on User_ (companyId, userId)
go
create index IX_5ADBE171 on User_ (contactId)
go
create index IX_762F63C6 on User_ (emailAddress)
go
create index IX_A9ED7DD3 on User_ (openId)
go
create index IX_A18034A4 on User_ (portraitId)
go
create index IX_E0422BDA on User_ (uuid_)
go

create index LIFERAY_003 on Users_Permissions (permissionId)
go

create index IX_97DFA146 on WebDAVProps (classNameId, classPK)
go

create index IX_96F07007 on Website (companyId)
go
create index IX_4F0F0CA7 on Website (companyId, classNameId)
go
create index IX_F960131C on Website (companyId, classNameId, classPK)
go
create index IX_F75690BB on Website (userId)
go

create index IX_5D6FE3F0 on WikiNode (companyId)
go
create index IX_B480A672 on WikiNode (groupId)
go
create index IX_920CD8B1 on WikiNode (groupId, name)
go
create index IX_6C112D7C on WikiNode (uuid_)
go
create index IX_7609B2AE on WikiNode (uuid_, groupId)
go

create index IX_A2001730 on WikiPage (format)
go
create index IX_C8A9C476 on WikiPage (nodeId)
go
create index IX_46EEF3C8 on WikiPage (nodeId, parentTitle)
go
create index IX_1ECC7656 on WikiPage (nodeId, redirectTitle)
go
create index IX_997EEDD2 on WikiPage (nodeId, title)
go
create index IX_3D4AF476 on WikiPage (nodeId, title, version)
go
create index IX_9C0E478F on WikiPage (uuid_)
go

create index IX_21277664 on WikiPageResource (nodeId, title)
go

create index IX_2A105741 on holiday_calendar (holidayCalendarTitle)
go

create index IX_2FEAD0BC on pml_Receiver (userId, receiverType)
go
create index IX_A43BE445 on pml_Receiver (userId, receiverUserId, receiverType)
go
create index IX_F4C2DEF5 on pml_Receiver (userId, receiverUserName, receiverType)
go
create index IX_506889AC on pml_Receiver (userName, receiverType)
go
create index IX_E189BD35 on pml_Receiver (userName, receiverUserId, receiverType)
go
create index IX_15FE3BE5 on pml_Receiver (userName, receiverUserName, receiverType)
go

create index IX_B2593D80 on pml_ReceiverGroup (userId)
go
create index IX_68769EB on pml_ReceiverGroup (userId, receiverGroupName)
go
create index IX_D502FC55 on pml_ReceiverGroup (userId, type_)
go
create index IX_897D5E30 on pml_ReceiverGroup (userName)
go
create index IX_FDC9B5A5 on pml_ReceiverGroup (userName, type_)
go

create index IX_94534BCC on pml_Reciever (userId, recieverType)
go
create index IX_635945DD on pml_Reciever (userId, recieverUserId, recieverType)
go
create index IX_4935BC8D on pml_Reciever (userId, recieverUserName, recieverType)
go
create index IX_23C602BC on pml_Reciever (userName, recieverType)
go
create index IX_31E01CCD on pml_Reciever (userName, recieverUserId, recieverType)
go
create index IX_9162977D on pml_Reciever (userName, recieverUserName, recieverType)
go

create index IX_1A370FF8 on pml_RecieverGroup (userId)
go
create index IX_C41AA2EB on pml_RecieverGroup (userId, recieverGroupName)
go
create index IX_B2E1F2DD on pml_RecieverGroup (userId, type_)
go
create index IX_713072A8 on pml_RecieverGroup (userName)
go
create index IX_DFC52A2D on pml_RecieverGroup (userName, type_)
go

create index IX_F88C2FA1 on pml_agency (agencycode)
go
create index IX_F036A8A7 on pml_agency (agencycode, agencyname, description)
go
create index IX_A904CBF on pml_agency (agencyname)
go
create index IX_64EE6A51 on pml_agency (description)
go

create index IX_B1E9DBB8 on pml_agencyleader (agencyId)
go
create index IX_39E841FE on pml_agencyleader (userId)
go

create index IX_DAEDA857 on pml_attachedfile (attachedfilecode)
go
create index IX_3B085E76 on pml_attachedfile (attachedfilecode, attachedfilename, description)
go
create index IX_ECF1C575 on pml_attachedfile (attachedfilename)
go
create index IX_3648AFD6 on pml_attachedfile (description)
go

create index IX_BD1C5906 on pml_car_resource (carCode, companyId)
go
create index IX_BB4C3AF9 on pml_car_resource (companyId)
go

create index IX_8A35C013 on pml_career (careercode)
go
create index IX_5E23A45C on pml_career (careercode, careername, description)
go
create index IX_9C39DD31 on pml_career (careername)
go
create index IX_F31FDB8 on pml_career (description)
go

create index IX_923002F7 on pml_chi_tiet_hscv (id_cong_van_den)
go
create index IX_C2A6BC7F on pml_chi_tiet_hscv (id_cong_van_di)
go
create index IX_F7D3D244 on pml_chi_tiet_hscv (id_ho_so_cong_viec)
go
create index IX_1B406F27 on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_den)
go
create index IX_7CC00A4F on pml_chi_tiet_hscv (id_ho_so_cong_viec, id_cong_van_di)
go

create index IX_3461E29B on pml_city (active)
go
create index IX_FDA6104D on pml_city (cityCode)
go
create index IX_3FA09675 on pml_city (cityCode, cityName, description)
go
create index IX_FAA2D6B on pml_city (cityName)
go
create index IX_B4C69D60 on pml_city (countryid)
go
create index IX_FDD6E82B on pml_city (description)
go

create index IX_B0F6ED33 on pml_conf_phongban_hscv (departmentsId)
go

create index IX_5C17FC4B on pml_delegate (assigner)
go
create index IX_99BC9FAE on pml_delegate (assigner, receiver)
go
create index IX_771BE1E7 on pml_delegate (assigner, receiver, startdate, enddate)
go
create index IX_200281EE on pml_delegate (canceldelegate)
go
create index IX_45A908CF on pml_delegate (datecreated)
go
create index IX_2B691F9E on pml_delegate (receiver)
go
create index IX_1DD7D351 on pml_delegate (receiver, canceldelegate)
go
create index IX_A14C32B1 on pml_delegate (receiver, startdate, canceldate, canceldelegate)
go
create index IX_2BF909D7 on pml_delegate (receiver, startdate, enddate)
go
create index IX_5B262B8A on pml_delegate (receiver, startdate, enddate, canceldelegate)
go

create index IX_448EF07B on pml_departmentleader (clericalid)
go
create index IX_D88249DB on pml_departmentleader (departmentsId)
go
create index IX_BA719715 on pml_departmentleader (departmentsId, userId)
go
create index IX_BA1D974B on pml_departmentleader (userId)
go

create index IX_F958ACE1 on pml_departments (abbreviatename)
go
create index IX_CC20E6B1 on pml_departments (active)
go
create index IX_6B9E2EEB on pml_departments (agencyId)
go
create index IX_6BACBACB on pml_departments (agencyid)
go
create index IX_14823E3F on pml_departments (departmentsParentId)
go
create index IX_8D4EA2A7 on pml_departments (departmentscode)
go
create index IX_9EEF10DB on pml_departments (departmentscode, agencyId)
go
create index IX_9EFD9CBB on pml_departments (departmentscode, agencyid)
go
create index IX_63A5BF8D on pml_departments (departmentscode, departmentsname, abbreviatename, description)
go
create index IX_A696C777 on pml_departments (departmentscode, departmentsname, description)
go
create index IX_9F52BFC5 on pml_departments (departmentsname)
go
create index IX_9DBEEDFF on pml_departments (departmentsparentid)
go
create index IX_5E6501D5 on pml_departments (description)
go
create index IX_D3074E90 on pml_departments (hasteam)
go
create index IX_1EFA98FC on pml_departments (roleid)
go

create index IX_57BED4FE on pml_district (active)
go
create index IX_65B319BE on pml_district (cityID)
go
create index IX_31B0FBA8 on pml_district (description)
go
create index IX_1A5F56D3 on pml_district (districtCode)
go
create index IX_E7D49132 on pml_district (districtCode, districtName, cityID, description)
go
create index IX_2C6373F1 on pml_district (districtName)
go

create index IX_7DDBAE38 on pml_do_quan_trong (ten_do_quan_trong)
go

create index IX_765B14DA on pml_documentreceipt_issuingplace_log (documentReceiptId)
go
create index IX_D48B8868 on pml_documentreceipt_issuingplace_log (documentReceiptId, processor, step)
go
create index IX_7CF5591A on pml_documentreceipt_issuingplace_log (documentReceiptId, step)
go

create index IX_61702019 on pml_documentreceipt_log (dateprocess)
go
create index IX_F2B17075 on pml_documentreceipt_log (departmentprocess)
go
create index IX_C34DE10 on pml_documentreceipt_log (departmentprocessid)
go
create index IX_5DA377E9 on pml_documentreceipt_log (departmentreceive)
go
create index IX_82C2D884 on pml_documentreceipt_log (departmentreceiveid)
go
create index IX_9AC1A170 on pml_documentreceipt_log (documentreceiptid)
go
create index IX_F13EA49C on pml_documentreceipt_log (documentreceiptid, processer)
go
create index IX_60F6FFCE on pml_documentreceipt_log (documentreceiptid, processer, receivedate, stateprocessidafter)
go
create index IX_51D1F577 on pml_documentreceipt_log (documentreceiptid, processer, stateprocessidafter)
go
create index IX_B32A8F5C on pml_documentreceipt_log (documentreceiptid, processer, step)
go
create index IX_4569DA93 on pml_documentreceipt_log (documentreceiptid, receiver)
go
create index IX_5130EFE0 on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter)
go
create index IX_D3E3577A on pml_documentreceipt_log (documentreceiptid, receiver, stateprocessidafter, transition_)
go
create index IX_402827C on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore)
go
create index IX_BEAAE410 on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, processer)
go
create index IX_1A7DDC9F on pml_documentreceipt_log (documentreceiptid, stateprocessidbefore, receiver)
go
create index IX_24299D30 on pml_documentreceipt_log (documentreceiptid, step)
go
create index IX_F97BAFEA on pml_documentreceipt_log (documentreceiptid, transition_)
go
create index IX_5BF8A5E2 on pml_documentreceipt_log (documentreceiptid, transition_, processer)
go
create index IX_9F0F4A65 on pml_documentreceipt_log (documentreceiptid, type_)
go
create index IX_1C2DC0EB on pml_documentreceipt_log (expireddate)
go
create index IX_5B3152F7 on pml_documentreceipt_log (maindepartmentprocessid)
go
create index IX_189C629E on pml_documentreceipt_log (mainuserprocessid)
go
create index IX_BE581447 on pml_documentreceipt_log (numdateprocess)
go
create index IX_EB41C334 on pml_documentreceipt_log (processer)
go
create index IX_8A503D37 on pml_documentreceipt_log (processinstanceid)
go
create index IX_1DCAA8B5 on pml_documentreceipt_log (processinstanceid, stateprocessidafter, dateprocess)
go
create index IX_990CD0CE on pml_documentreceipt_log (processinstanceid, stateprocessidbefore, dateprocess)
go
create index IX_C9F630BE on pml_documentreceipt_log (processinstanceid, type_)
go
create index IX_2A554629 on pml_documentreceipt_log (receivedate)
go
create index IX_55BC88FB on pml_documentreceipt_log (receiver)
go
create index IX_DC6AC441 on pml_documentreceipt_log (senddatebefore)
go
create index IX_DF02C5BB on pml_documentreceipt_log (stateprocessidafter)
go
create index IX_1CFAD4E4 on pml_documentreceipt_log (stateprocessidbefore)
go
create index IX_B5D974FD on pml_documentreceipt_log (type_)
go

create index IX_F9949A1 on pml_documentreceipt_wf (documentreceiptid)
go
create index IX_813F3D38 on pml_documentreceipt_wf (documentreceiptid, ismain)
go

create index IX_BF3D5193 on pml_documentsend_log (dateprocess)
go
create index IX_EDDF58A on pml_documentsend_log (departmentprocessid)
go
create index IX_856BEFFE on pml_documentsend_log (departmentreceiveid)
go
create index IX_95446B90 on pml_documentsend_log (documentsendid)
go
create index IX_D42E467C on pml_documentsend_log (documentsendid, processer)
go
create index IX_166629AE on pml_documentsend_log (documentsendid, processer, receivedate, stateprocessidafter)
go
create index IX_B9A43F97 on pml_documentsend_log (documentsendid, processer, stateprocessidafter)
go
create index IX_7B91493C on pml_documentsend_log (documentsendid, processer, step)
go
create index IX_970E7CB3 on pml_documentsend_log (documentsendid, receiver)
go
create index IX_BA24F49C on pml_documentsend_log (documentsendid, stateprocessidbefore)
go
create index IX_825026BF on pml_documentsend_log (documentsendid, stateprocessidbefore, receiver)
go
create index IX_FCB44F50 on pml_documentsend_log (documentsendid, step)
go
create index IX_DF0A59CA on pml_documentsend_log (documentsendid, transition_)
go
create index IX_79FAF265 on pml_documentsend_log (expireddate)
go
create index IX_87E8B88D on pml_documentsend_log (numdateprocess)
go
create index IX_6BC10B2E on pml_documentsend_log (processer)
go
create index IX_9727582F on pml_documentsend_log (processinstanceid, stateprocessidafter, dateprocess)
go
create index IX_4B461094 on pml_documentsend_log (processinstanceid, stateprocessidbefore, dateprocess)
go
create index IX_882277A3 on pml_documentsend_log (receivedate)
go
create index IX_309759C1 on pml_documentsend_log (receiver)
go
create index IX_A5FB6887 on pml_documentsend_log (senddatebefore)
go
create index IX_E1ABDD35 on pml_documentsend_log (stateprocessidafter)
go
create index IX_6F74ACAA on pml_documentsend_log (stateprocessidbefore)
go

create index IX_EF559A19 on pml_documentsend_wf (processid)
go

create index IX_DF61BFE8 on pml_edm_answerdetail (documentsendid)
go

create index IX_9A5F97E6 on pml_edm_attachedfile (attachedfilename)
go
create index IX_9AA1EC3 on pml_edm_attachedfile (datecreated)
go
create index IX_BC68EC12 on pml_edm_attachedfile (fileid)
go
create index IX_59EC5531 on pml_edm_attachedfile (filetype)
go
create index IX_38A173FE on pml_edm_attachedfile (objectcontentid)
go
create index IX_3B07BA2B on pml_edm_attachedfile (objectcontentid, objecttype)
go
create index IX_F431D674 on pml_edm_attachedfile (objecttype)
go
create index IX_45D87F60 on pml_edm_attachedfile (path)
go

create index IX_B6759412 on pml_edm_bookdocumentrecordto (datecomplete)
go
create index IX_AA87ECD5 on pml_edm_bookdocumentrecordto (datecreate)
go
create index IX_3104DFB1 on pml_edm_bookdocumentrecordto (documentreceiptid)
go
create index IX_896B2527 on pml_edm_bookdocumentrecordto (documentreceiptid, documentrecordtoid)
go
create index IX_E6BAE7AD on pml_edm_bookdocumentrecordto (documentrecordtoid)
go

create index IX_C213CCC7 on pml_edm_bookdocumentsend (agencyid)
go
create index IX_6951E23A on pml_edm_bookdocumentsend (agencyid, departmentsid, documentrecordtypeid)
go
create index IX_C2147AA3 on pml_edm_bookdocumentsend (agencyid, yearinuse, documentrecordtypeid)
go
create index IX_B3B1DB27 on pml_edm_bookdocumentsend (currentrecord)
go
create index IX_12A9A257 on pml_edm_bookdocumentsend (datecreated)
go
create index IX_7E34CBD9 on pml_edm_bookdocumentsend (departmentsid)
go
create index IX_DB1A8728 on pml_edm_bookdocumentsend (documentrecordtypeid)
go
create index IX_217A93FC on pml_edm_bookdocumentsend (documentrecordtypeid, agencyid)
go
create index IX_BD633DC4 on pml_edm_bookdocumentsend (documentrecordtypeid, departmentsid)
go
create index IX_5C6A0756 on pml_edm_bookdocumentsend (yearinuse, agencyid)
go
create index IX_D6B7D2AA on pml_edm_bookdocumentsend (yearinuse, departmentsid)
go
create index IX_79A204DF on pml_edm_bookdocumentsend (yearinuse, departmentsid, documentrecordtypeid)
go

create index IX_CE3025EE on pml_edm_cadre (departmentsid)
go
create index IX_EA107351 on pml_edm_cadre (handphone)
go
create index IX_393FE4B6 on pml_edm_cadre (positionid)
go

create index IX_F30AEFD6 on pml_edm_confidentiallevel (confidentiallevelname)
go

create index IX_8A4FDF66 on pml_edm_docconfuser (userId)
go

create index IX_F635B970 on pml_edm_documentdelegate (userIsDelegateId)
go

create index IX_6C706605 on pml_edm_documentreceipt (confidentiallevelid)
go
create index IX_A5806B65 on pml_edm_documentreceipt (docreceipttempid)
go
create index IX_F7702835 on pml_edm_documentreceipt (docreceipttempid, orgexternalid)
go
create index IX_195C7CCB on pml_edm_documentreceipt (documenttype)
go
create index IX_344E2CE6 on pml_edm_documentreceipt (documenttypeid)
go
create index IX_B64C9B03 on pml_edm_documentreceipt (fieldid)
go
create index IX_F4D3AF82 on pml_edm_documentreceipt (issuingplaceid)
go
create index IX_A65D2BA7 on pml_edm_documentreceipt (isvbqppl)
go
create index IX_44318C15 on pml_edm_documentreceipt (levelsendid)
go
create index IX_5095AB4D on pml_edm_documentreceipt (maindepartmentprocessid)
go
create index IX_A4E73374 on pml_edm_documentreceipt (mainuserprocessid)
go
create index IX_FE328031 on pml_edm_documentreceipt (numberlocaldocumentreceipt)
go
create index IX_1C937938 on pml_edm_documentreceipt (orgexternalid)
go
create index IX_7D644D84 on pml_edm_documentreceipt (privilegelevelid)
go
create index IX_41D2A81C on pml_edm_documentreceipt (socongvandiphucdap)
go
create index IX_FF31DE83 on pml_edm_documentreceipt (statusid)
go

create index IX_8ABCB96A on pml_edm_documentreceipt_temp (confidentiallevelid)
go
create index IX_4B990106 on pml_edm_documentreceipt_temp (documenttype)
go
create index IX_C97A8E61 on pml_edm_documentreceipt_temp (documenttypeid)
go
create index IX_8A0010FD on pml_edm_documentreceipt_temp (issuingplaceid)
go
create index IX_1C86147A on pml_edm_documentreceipt_temp (levelsendid)
go
create index IX_FC432 on pml_edm_documentreceipt_temp (maindepartmentprocessid)
go
create index IX_1C8B1C19 on pml_edm_documentreceipt_temp (mainuserprocessid)
go
create index IX_BA18BC33 on pml_edm_documentreceipt_temp (numberdocumentreceipt, orgexternalid)
go
create index IX_6FC9812C on pml_edm_documentreceipt_temp (numberlocaldocumentreceipt)
go
create index IX_31E77C5D on pml_edm_documentreceipt_temp (orgexternalid)
go
create index IX_78FE3C3F on pml_edm_documentreceipt_temp (privilegelevelid)
go
create index IX_BEABD417 on pml_edm_documentreceipt_temp (socongvandiphucdap)
go
create index IX_FFB7B83E on pml_edm_documentreceipt_temp (statusid)
go

create index IX_3CFED46C on pml_edm_documentreceiptextend (documentreceiptid)
go

create index IX_26138E35 on pml_edm_documentreceiptprocesstype (documentReceiptId)
go

create index IX_38A6EC62 on pml_edm_documentrecordto (agencyid)
go
create index IX_909AF77F on pml_edm_documentrecordto (agencyid, departmentsid, documentrecordtypeid)
go
create index IX_59EE8497 on pml_edm_documentrecordto (agencyid, documentrecordtypeid)
go
create index IX_84DCFA68 on pml_edm_documentrecordto (agencyid, yearinuse, documentrecordtypeid)
go
create index IX_4FB9446C on pml_edm_documentrecordto (currentrecord)
go
create index IX_E515482C on pml_edm_documentrecordto (datecreate)
go
create index IX_1A3C351E on pml_edm_documentrecordto (departmentsid)
go
create index IX_544C1643 on pml_edm_documentrecordto (documentrecordtypeid)
go
create index IX_5643D57 on pml_edm_documentrecordto (documentrecordtypeid, agencyid)
go
create index IX_E1643549 on pml_edm_documentrecordto (documentrecordtypeid, departmentsid)
go
create index IX_62D856C7 on pml_edm_documentrecordto (yearinuse)
go
create index IX_478CA8DB on pml_edm_documentrecordto (yearinuse, agencyid)
go
create index IX_30065C45 on pml_edm_documentrecordto (yearinuse, departmentsid)
go
create index IX_3B7B983A on pml_edm_documentrecordto (yearinuse, departmentsid, documentrecordtypeid)
go

create index IX_ACE905D4 on pml_edm_documentrecordtype (documentrecordtypecode)
go
create index IX_BEED22F2 on pml_edm_documentrecordtype (documentrecordtypename)
go


create index IX_96281CBD on pml_edm_documentsend (confidentiallevelid)
go
create index IX_7FB46F6 on pml_edm_documentsend (documentreference)
go
create index IX_ABCFC10E on pml_edm_documentsend (documentsendcode)
go
create index IX_665D232E on pml_edm_documentsend (documenttypeid)
go
create index IX_609C46C6 on pml_edm_documentsend (editorid)
go
create index IX_1D01FC6A on pml_edm_documentsend (issuingdate)
go
create index IX_348309D6 on pml_edm_documentsend (numberpage)
go
create index IX_1C0C48C on pml_edm_documentsend (numberpublish)
go
create index IX_FD2899F0 on pml_edm_documentsend (orgexternalid)
go
create index IX_E564F13C on pml_edm_documentsend (position_)
go
create index IX_678ED1CC on pml_edm_documentsend (privilegelevelid)
go
create index IX_F6373734 on pml_edm_documentsend (senddate)
go
create index IX_83BE6E03 on pml_edm_documentsend (signerid)
go
create index IX_965879F3 on pml_edm_documentsend (signername)
go
create index IX_CC292ACB on pml_edm_documentsend (statusid)
go

create index IX_FC3F0EF1 on pml_edm_documenttype (documentrecordtypeid)
go
create index IX_189CF563 on pml_edm_documenttype (documentsymbol)
go
create index IX_2DA48310 on pml_edm_documenttype (documenttypename)
go
create index IX_CA49CA8C on pml_edm_documenttype (sendreceiptdistinction)
go

create index IX_7506C14C on pml_edm_issuingplace (address)
go
create index IX_E2A13874 on pml_edm_issuingplace (email)
go
create index IX_D322EF77 on pml_edm_issuingplace (handphone)
go
create index IX_51947C2A on pml_edm_issuingplace (issuingplacecode)
go
create index IX_63989948 on pml_edm_issuingplace (issuingplacename)
go
create index IX_40E6F8AC on pml_edm_issuingplace (tablephone)
go

create index IX_6B1386B8 on pml_edm_levelsend (levelsendcode)
go
create index IX_7D17A3D6 on pml_edm_levelsend (levelsendname)
go

create index IX_96C78722 on pml_edm_levelsenddetail (issuingPlaceId)
go
create index IX_A510EC75 on pml_edm_levelsenddetail (levelsendid)
go
create index IX_6FFCD535 on pml_edm_levelsenddetail (levelsendid, issuingPlaceId)
go

create index IX_55886F8C on pml_edm_privilegelevel (privilegelevelname)
go

create index IX_707D1D62 on pml_edm_processdocumentreceiptdetail (documentreceiptid)
go
create index IX_F222C540 on pml_edm_processdocumentreceiptdetail (userid)
go

create index IX_48D6104C on pml_edm_so_loai_vanbannoibo (loaiVanBanNoiBoId)
go
create index IX_9FE5DAFB on pml_edm_so_loai_vanbannoibo (soVanBanNoiBoId)
go
create index IX_7C19E70E on pml_edm_so_loai_vanbannoibo (soVanBanNoiBoId, loaiVanBanNoiBoId)
go

create index IX_60CA7786 on pml_edm_so_phong_vanbannoibo (phongVanBanNoiBoId)
go
create index IX_431EFE9A on pml_edm_so_phong_vanbannoibo (soVanBanNoiBoId)
go
create index IX_A8F35322 on pml_edm_so_phong_vanbannoibo (soVanBanNoiBoId, phongVanBanNoiBoId)
go

create index IX_F963C762 on pml_edm_writedocumentsend (bookdocumentsendid)
go
create index IX_438BB903 on pml_edm_writedocumentsend (datecreated)
go
create index IX_34A68AF9 on pml_edm_writedocumentsend (documentsendid)
go

create index IX_15C023FC on pml_field (departmentsId)
go
create index IX_4483E71C on pml_field (description)
go
create index IX_C99E25E7 on pml_field (fieldCode)
go
create index IX_4D7208CE on pml_field (fieldCode, fieldName)
go
create index IX_DBA24305 on pml_field (fieldName)
go

create index IX_596B556B on pml_file (applicantName)
go
create index IX_D45EFE9C on pml_file (applicationDate)
go
create index IX_4D50D500 on pml_file (authorisedLetter)
go
create index IX_A972ABD8 on pml_file (dateCreated)
go
create index IX_5351F437 on pml_file (fileTypeId)
go
create index IX_5F9DE377 on pml_file (fileTypeId, applicationDate)
go
create index IX_E3AD19AC on pml_file (fileTypeId, exactReturningDate)
go
create index IX_A4791A88 on pml_file (fileTypeId, numberReceipt)
go
create index IX_B02ADD59 on pml_file (organization)
go
create index IX_38EB14CC on pml_file (permanentAddress)
go

create index IX_61D51B08 on pml_file_attachedfile (attachedFileId)
go
create index IX_4977F9B8 on pml_file_attachedfile (attachedFileName)
go
create index IX_56516844 on pml_file_attachedfile (fileId)
go

create index IX_71CC95A4 on pml_file_pccc (applicantcategory)
go
create index IX_41FD1EE7 on pml_file_pccc (fileName)
go
create index IX_F0267148 on pml_file_pccc (projectname)
go
create index IX_AACDDDA2 on pml_file_pccc (receiveofunit)
go

create index IX_84D37C45 on pml_filepccc_attachedfile (attachedfilename)
go
create index IX_2D22BB04 on pml_filepccc_attachedfile (datecreated)
go
create index IX_582E144 on pml_filepccc_attachedfile (filepcccid)
go
create index IX_C0016E71 on pml_filepccc_attachedfile (filepcccid, objecttype)
go
create index IX_665E0890 on pml_filepccc_attachedfile (filetype)
go
create index IX_AB042E13 on pml_filepccc_attachedfile (objecttype)
go
create index IX_40B0BA3F on pml_filepccc_attachedfile (path)
go

create index IX_1D541E7E on pml_filereturninginfo (billnumber)
go
create index IX_6C028719 on pml_filereturninginfo (conclude)
go
create index IX_18347992 on pml_filereturninginfo (documentnumber)
go
create index IX_31A6CC45 on pml_filereturninginfo (fileid)
go
create index IX_674A1FCA on pml_filereturninginfo (fileid, filereturninginfoid)
go
create index IX_E90EDEDF on pml_filereturninginfo (filesender)
go
create index IX_415DBCEB on pml_filereturninginfo (issuingdatelicense)
go
create index IX_870F0CC0 on pml_filereturninginfo (licensenumber)
go
create index IX_62C25CE0 on pml_filereturninginfo (note)
go
create index IX_CA4BAECD on pml_filereturninginfo (numbermoney)
go
create index IX_4B4BAA1A on pml_filereturninginfo (receivelicensedate)
go

create index IX_5935E6C8 on pml_filestatus (description)
go
create index IX_22A22EF3 on pml_filestatus (filestatuscode)
go
create index IX_267CE161 on pml_filestatus (filestatuscode, type)
go
create index IX_34A64C11 on pml_filestatus (filestatusname)
go
create index IX_8037DA92 on pml_filestatus (type)
go

create index IX_1AB3D3C2 on pml_filestatus_stateprocess (filestatusid)
go
create index IX_CC0394F on pml_filestatus_stateprocess (filestatusid, stateprocessid)
go
create index IX_46DF2252 on pml_filestatus_stateprocess (stateprocessid)
go

create index IX_A0F11380 on pml_filetype (description)
go
create index IX_894651F9 on pml_filetype (fieldId)
go
create index IX_38394B43 on pml_filetype (fileTypeCode)
go
create index IX_BF4F1638 on pml_filetype (fileTypeCode, fileTypeName)
go
create index IX_4A3D6861 on pml_filetype (fileTypeName)
go
create index IX_BDCA23D6 on pml_filetype (receiptTemplate)
go

create index IX_3F989A8E on pml_filetype_attachedfile (attachedFileId)
go
create index IX_C459AFBE on pml_filetype_attachedfile (attachedFileName)
go
create index IX_685D30A4 on pml_filetype_attachedfile (attachedFileName, note)
go
create index IX_8EEEF5BD on pml_filetype_attachedfile (attachedFileName, original, copy_, note)
go
create index IX_16CE77B on pml_filetype_attachedfile (copy_)
go
create index IX_1D1C5FC0 on pml_filetype_attachedfile (copy_, fileTypeId)
go
create index IX_A8123DA4 on pml_filetype_attachedfile (fileTypeId)
go
create index IX_C87FFF85 on pml_filetype_attachedfile (note)
go
create index IX_7969B8CA on pml_filetype_attachedfile (note, fileTypeId)
go
create index IX_96238524 on pml_filetype_attachedfile (original)
go
create index IX_204EC7E9 on pml_filetype_attachedfile (original, fileTypeId)
go

create index IX_EEEA49C5 on pml_filetypedelegate (delegateid)
go
create index IX_8711D276 on pml_filetypedelegate (filetypeid)
go
create index IX_4F36494A on pml_filetypedelegate (filetypeid, delegateid)
go

create index IX_22B22256 on pml_ho_so_cong_viec (id_do_quan_trong)
go
create index IX_4B004359 on pml_ho_so_cong_viec (id_hscv_cha)
go
create index IX_E4A110BA on pml_ho_so_cong_viec (id_linh_vuc)
go
create index IX_3583860E on pml_ho_so_cong_viec (id_tinh_chat)
go
create index IX_F5AC1C84 on pml_ho_so_cong_viec (id_trang_thai_hscv)
go
create index IX_6641DAF3 on pml_ho_so_cong_viec (so_hieu_hscv)
go
create index IX_8CAC1550 on pml_ho_so_cong_viec (userId)
go
create index IX_D07F49 on pml_ho_so_cong_viec (userId, hoat_dong)
go

create index IX_6FE7F965 on pml_holiday (from_date)
go
create index IX_DA2F71DD on pml_holiday (from_date, to_date)
go
create index IX_BE96F7E3 on pml_holiday (holiday_type)
go
create index IX_B000EB7 on pml_holiday (holiday_type, holiday_value)
go
create index IX_54EFF34C on pml_holiday (holiday_value)
go
create index IX_AC2C1974 on pml_holiday (to_date)
go

create index IX_B6A8CE01 on pml_main_support (processid_main)
go
create index IX_2B8908B4 on pml_main_support (processid_main, type_)
go
create index IX_3DADA2F6 on pml_main_support (supportinfomation)
go
create index IX_B29867F6 on pml_main_support (type_)
go

create index IX_2070F48B on pml_manage_documentworkflow (type_)
go
create index IX_55510545 on pml_manage_documentworkflow (version_)
go
create index IX_56BF56C8 on pml_manage_documentworkflow (workflowname)
go

create index IX_D3C8915E on pml_message_note (createDate)
go
create index IX_3B0D672A on pml_message_note (documentId)
go
create index IX_5187B7B on pml_message_note (documentId, fromUserId, objectType)
go
create index IX_F26FDBA4 on pml_message_note (fromUserId)
go
create index IX_CC62AA2E on pml_message_note (fromUserId, documentId)
go
create index IX_BFE701F5 on pml_message_note (toUserId)
go

create index IX_9E1C1904 on pml_nation (countryid)
go
create index IX_E7BC0ACF on pml_nation (description)
go
create index IX_7BB3C125 on pml_nation (nationcode)
go
create index IX_AD004521 on pml_nation (nationcode, nationname, description)
go
create index IX_B64C62E0 on pml_nation (nationcode, nationname, description, countryid)
go
create index IX_8DB7DE43 on pml_nation (nationname)
go

create index IX_DC4571BF on pml_organization_external (orgexternalcode)
go
create index IX_EE498EDD on pml_organization_external (orgexternalname)
go

create index IX_1A4A0D1A on pml_paintdocument (fileid)
go
create index IX_9AF230CE on pml_paintdocument (quantity)
go

create index IX_F9124CAD on pml_position (description)
go
create index IX_C722BFA9 on pml_position (positioncode)
go
create index IX_40E870BB on pml_position (positioncode, positionname, description)
go
create index IX_D926DCC7 on pml_position (positionname)
go

create index IX_16BA87EB on pml_processdispose (dateprocess)
go
create index IX_5A6F9F0A on pml_processdispose (delegateuser)
go
create index IX_D17828BD on pml_processdispose (expireddate)
go
create index IX_86178411 on pml_processdispose (fileid)
go
create index IX_ACA8C122 on pml_processdispose (fileid, stateprocessidafter)
go
create index IX_414465D on pml_processdispose (fileid, stateprocessidbefore)
go
create index IX_B8C0DAE9 on pml_processdispose (fileid, transition_)
go
create index IX_947F786 on pml_processdispose (processer)
go
create index IX_DF9FADFB on pml_processdispose (receivedate)
go
create index IX_DAD58269 on pml_processdispose (receiver)
go
create index IX_73C1DF0 on pml_processdispose (senddate)
go
create index IX_D3193B8D on pml_processdispose (stateprocessidafter)
go
create index IX_ABB31952 on pml_processdispose (stateprocessidbefore)
go
create index IX_347BF054 on pml_processdispose (transition_)
go

create index IX_6740CD8E on pml_processtype (flagprocesstype)
go
create index IX_6F02DFE on pml_processtype (name)
go

create index IX_8189A9C0 on pml_role (description)
go
create index IX_3EA90583 on pml_role (rolecode)
go
create index IX_5A584BB4 on pml_role (rolecode, rolename, description)
go
create index IX_50AD22A1 on pml_role (rolename)
go

create index IX_5B7B5B20 on pml_room_resource (companyId)
go
create index IX_9C76B966 on pml_room_resource (roomName, companyId)
go

create index IX_7C75D901 on pml_saveprocesstype (docId)
go
create index IX_2F8EFE4B on pml_saveprocesstype (flagprocesstype)
go

create index IX_4BE268DA on pml_signer (userId)
go

create index IX_D9BC27D7 on pml_state_department (departmentid)
go
create index IX_D57677B5 on pml_state_department (statewfid)
go

create index IX_923D54E6 on pml_state_wf (solvingtime)
go
create index IX_E95EB980 on pml_state_wf (stateprocessid)
go
create index IX_DDD4126 on pml_state_wf (workflow)
go
create index IX_FFD4EEAE on pml_state_wf (workflow, stateprocessid, version_)
go
create index IX_83F19D61 on pml_state_wf (workflow, version_)
go

create index IX_9225FC78 on pml_stateprocess (description)
go
create index IX_7608CFF1 on pml_stateprocess (filestatusid)
go
create index IX_75268613 on pml_stateprocess (stateprocesscode)
go
create index IX_D2E7C250 on pml_stateprocess (stateprocesscode, stateprocessname)
go
create index IX_872AA331 on pml_stateprocess (stateprocessname)
go

create index IX_C8F855DB on pml_street (streetName)
go

create index IX_81CDA715 on pml_team (companyid)
go
create index IX_5F105874 on pml_team (departmentid)
go
create index IX_4F4A1B2 on pml_team (departmentid, teamcode)
go
create index IX_F351D895 on pml_team (organizationid)
go
create index IX_8D369D91 on pml_team (teamcode)
go
create index IX_9F3ABAAF on pml_team (teamname)
go

create index IX_8A699036 on pml_teamleader (userid)
go

create index IX_9088E4B1 on pml_template (departmentId)
go

create index IX_723E8560 on pml_template_file (templateId)
go

create index IX_81341A38 on pml_tinh_chat (ten_tinh_chat)
go

create index IX_787D1D78 on pml_trang_thai_hscv (ten_trang_thai_hscv)
go

create index IX_39228010 on pml_transition (filetypeid)
go
create index IX_994CBFCB on pml_transition (filetypeid, version_)
go
create index IX_8BB21315 on pml_transition (notransition)
go
create index IX_20816340 on pml_transition (stateprocesscurrent)
go
create index IX_40267CB0 on pml_transition (stateprocessnext)
go
create index IX_D61160DF on pml_transition (transitionname)
go
create index IX_96AFFA06 on pml_transition (version_)
go

create index IX_4871D6EB on pml_user (departmentsId)
go
create index IX_4A13A6AE on pml_user (handphone)
go
create index IX_8EF417A7 on pml_user (note)
go
create index IX_D9949119 on pml_user (positionId)
go
create index IX_54858438 on pml_user (positionId, departmentsId, roleId)
go
create index IX_3439E366 on pml_user (roleId)
go
create index IX_E0B7E5AD on pml_user (teamid)
go

create index IX_25F95C64 on pml_user_file_type (filetypeid)
go
create index IX_82420779 on pml_user_file_type (userid)
go

create index IX_E695A0FF on pml_wards (description)
go
create index IX_A171A34A on pml_wards (districtId)
go
create index IX_D65D0747 on pml_wards (wardsCode)
go
create index IX_139E1304 on pml_wards (wardsCode, wardsName, districtId, description)
go
create index IX_E8612465 on pml_wards (wardsName)
go

create index IX_6F3C858B on pml_wf_onedoor (nodeId)
go
create index IX_30AE8040 on pml_wf_onedoor (processId)
go

create index IX_4C98D3A on pml_workflow (fileTypeId)
go
create index IX_5BD98D66 on pml_workflow (fileTypeId, startDate)
go
create index IX_4ACCE075 on pml_workflow (fileTypeId, version_)
go
create index IX_77A8AE63 on pml_workflow (workflow, version_)
go
