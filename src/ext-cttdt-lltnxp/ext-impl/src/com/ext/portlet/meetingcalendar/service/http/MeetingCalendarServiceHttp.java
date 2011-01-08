package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;


/**
 * <a href="MeetingCalendarServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>com.liferay.portal.security.auth.HttpPrincipal</code>
 * parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <code>tunnel.servlet.hosts.allowed</code> in
 * portal.properties to configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.security.auth.HttpPrincipal
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceSoap
 *
 */
public class MeetingCalendarServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(MeetingCalendarServiceHttp.class);

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        HttpPrincipal httpPrincipal, long plid, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(plid);

            Object paramObj1 = title;

            if (title == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = description;

            if (description == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new IntegerWrapper(startDateMonth);

            Object paramObj4 = new IntegerWrapper(startDateDay);

            Object paramObj5 = new IntegerWrapper(startDateYear);

            Object paramObj6 = new IntegerWrapper(startDateHour);

            Object paramObj7 = new IntegerWrapper(startDateMinute);

            Object paramObj8 = new IntegerWrapper(endDateMonth);

            Object paramObj9 = new IntegerWrapper(endDateDay);

            Object paramObj10 = new IntegerWrapper(endDateYear);

            Object paramObj11 = new IntegerWrapper(durationHour);

            Object paramObj12 = new IntegerWrapper(durationMinute);

            Object paramObj13 = new BooleanWrapper(allDay);

            Object paramObj14 = new BooleanWrapper(timeZoneSensitive);

            Object paramObj15 = type;

            if (type == null) {
                paramObj15 = new NullWrapper("java.lang.String");
            }

            Object paramObj16 = new BooleanWrapper(repeating);

            Object paramObj17 = recurrence;

            if (recurrence == null) {
                paramObj17 = new NullWrapper(
                        "com.liferay.portal.kernel.cal.TZSRecurrence");
            }

            Object paramObj18 = remindBy;

            if (remindBy == null) {
                paramObj18 = new NullWrapper("java.lang.String");
            }

            Object paramObj19 = new IntegerWrapper(firstReminder);

            Object paramObj20 = new IntegerWrapper(secondReminder);

            Object paramObj21 = communityPermissions;

            if (communityPermissions == null) {
                paramObj21 = new NullWrapper("[Ljava.lang.String;");
            }

            Object paramObj22 = guestPermissions;

            if (guestPermissions == null) {
                paramObj22 = new NullWrapper("[Ljava.lang.String;");
            }

            Object paramObj23 = new BooleanWrapper(morning);

            Object paramObj24 = new BooleanWrapper(afternoon);

            Object paramObj25 = new BooleanWrapper(evening);

            Object paramObj26 = new BooleanWrapper(prior);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "addEvent",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25,
                        paramObj26
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.liferay.portlet.calendar.model.CalEvent) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        HttpPrincipal httpPrincipal, long plid, long userId,
        java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(plid);

            Object paramObj1 = new LongWrapper(userId);

            Object paramObj2 = title;

            if (title == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = description;

            if (description == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = new IntegerWrapper(startDateMonth);

            Object paramObj5 = new IntegerWrapper(startDateDay);

            Object paramObj6 = new IntegerWrapper(startDateYear);

            Object paramObj7 = new IntegerWrapper(startDateHour);

            Object paramObj8 = new IntegerWrapper(startDateMinute);

            Object paramObj9 = new IntegerWrapper(endDateMonth);

            Object paramObj10 = new IntegerWrapper(endDateDay);

            Object paramObj11 = new IntegerWrapper(endDateYear);

            Object paramObj12 = new IntegerWrapper(durationHour);

            Object paramObj13 = new IntegerWrapper(durationMinute);

            Object paramObj14 = new BooleanWrapper(allDay);

            Object paramObj15 = new BooleanWrapper(timeZoneSensitive);

            Object paramObj16 = type;

            if (type == null) {
                paramObj16 = new NullWrapper("java.lang.String");
            }

            Object paramObj17 = new BooleanWrapper(repeating);

            Object paramObj18 = recurrence;

            if (recurrence == null) {
                paramObj18 = new NullWrapper(
                        "com.liferay.portal.kernel.cal.TZSRecurrence");
            }

            Object paramObj19 = remindBy;

            if (remindBy == null) {
                paramObj19 = new NullWrapper("java.lang.String");
            }

            Object paramObj20 = new IntegerWrapper(firstReminder);

            Object paramObj21 = new IntegerWrapper(secondReminder);

            Object paramObj22 = communityPermissions;

            if (communityPermissions == null) {
                paramObj22 = new NullWrapper("[Ljava.lang.String;");
            }

            Object paramObj23 = guestPermissions;

            if (guestPermissions == null) {
                paramObj23 = new NullWrapper("[Ljava.lang.String;");
            }

            Object paramObj24 = new BooleanWrapper(morning);

            Object paramObj25 = new BooleanWrapper(afternoon);

            Object paramObj26 = new BooleanWrapper(evening);

            Object paramObj27 = new BooleanWrapper(prior);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "addEvent",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25,
                        paramObj26, paramObj27
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.liferay.portlet.calendar.model.CalEvent) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteEvent(HttpPrincipal httpPrincipal, long plid,
        long eventId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(plid);

            Object paramObj1 = new LongWrapper(eventId);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "deleteEvent", new Object[] { paramObj0, paramObj1 });

            try {
                TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent getEvent(
        HttpPrincipal httpPrincipal, long eventId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(eventId);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "getEvent", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.liferay.portlet.calendar.model.CalEvent) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        HttpPrincipal httpPrincipal, long eventId, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(eventId);

            Object paramObj1 = title;

            if (title == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = description;

            if (description == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new IntegerWrapper(startDateMonth);

            Object paramObj4 = new IntegerWrapper(startDateDay);

            Object paramObj5 = new IntegerWrapper(startDateYear);

            Object paramObj6 = new IntegerWrapper(startDateHour);

            Object paramObj7 = new IntegerWrapper(startDateMinute);

            Object paramObj8 = new IntegerWrapper(endDateMonth);

            Object paramObj9 = new IntegerWrapper(endDateDay);

            Object paramObj10 = new IntegerWrapper(endDateYear);

            Object paramObj11 = new IntegerWrapper(durationHour);

            Object paramObj12 = new IntegerWrapper(durationMinute);

            Object paramObj13 = new BooleanWrapper(allDay);

            Object paramObj14 = new BooleanWrapper(timeZoneSensitive);

            Object paramObj15 = type;

            if (type == null) {
                paramObj15 = new NullWrapper("java.lang.String");
            }

            Object paramObj16 = new BooleanWrapper(repeating);

            Object paramObj17 = recurrence;

            if (recurrence == null) {
                paramObj17 = new NullWrapper(
                        "com.liferay.portal.kernel.cal.TZSRecurrence");
            }

            Object paramObj18 = remindBy;

            if (remindBy == null) {
                paramObj18 = new NullWrapper("java.lang.String");
            }

            Object paramObj19 = new IntegerWrapper(firstReminder);

            Object paramObj20 = new IntegerWrapper(secondReminder);

            Object paramObj21 = new BooleanWrapper(morning);

            Object paramObj22 = new BooleanWrapper(afternoon);

            Object paramObj23 = new BooleanWrapper(evening);

            Object paramObj24 = new BooleanWrapper(prior);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "updateEvent",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.liferay.portlet.calendar.model.CalEvent) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        HttpPrincipal httpPrincipal, long plid, long eventId,
        java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(plid);

            Object paramObj1 = new LongWrapper(eventId);

            Object paramObj2 = title;

            if (title == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = description;

            if (description == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = new IntegerWrapper(startDateMonth);

            Object paramObj5 = new IntegerWrapper(startDateDay);

            Object paramObj6 = new IntegerWrapper(startDateYear);

            Object paramObj7 = new IntegerWrapper(startDateHour);

            Object paramObj8 = new IntegerWrapper(startDateMinute);

            Object paramObj9 = new IntegerWrapper(endDateMonth);

            Object paramObj10 = new IntegerWrapper(endDateDay);

            Object paramObj11 = new IntegerWrapper(endDateYear);

            Object paramObj12 = new IntegerWrapper(durationHour);

            Object paramObj13 = new IntegerWrapper(durationMinute);

            Object paramObj14 = new BooleanWrapper(allDay);

            Object paramObj15 = new BooleanWrapper(timeZoneSensitive);

            Object paramObj16 = type;

            if (type == null) {
                paramObj16 = new NullWrapper("java.lang.String");
            }

            Object paramObj17 = new BooleanWrapper(repeating);

            Object paramObj18 = recurrence;

            if (recurrence == null) {
                paramObj18 = new NullWrapper(
                        "com.liferay.portal.kernel.cal.TZSRecurrence");
            }

            Object paramObj19 = remindBy;

            if (remindBy == null) {
                paramObj19 = new NullWrapper("java.lang.String");
            }

            Object paramObj20 = new IntegerWrapper(firstReminder);

            Object paramObj21 = new IntegerWrapper(secondReminder);

            Object paramObj22 = new BooleanWrapper(morning);

            Object paramObj23 = new BooleanWrapper(afternoon);

            Object paramObj24 = new BooleanWrapper(evening);

            Object paramObj25 = new BooleanWrapper(prior);

            MethodWrapper methodWrapper = new MethodWrapper(MeetingCalendarServiceUtil.class.getName(),
                    "updateEvent",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.liferay.portlet.calendar.model.CalEvent) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
