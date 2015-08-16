package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.entities.CalendarEntry;
import com.uwetrottmann.trakt.v2.entities.CalendarShowEntry;
import com.uwetrottmann.trakt.v2.exceptions.OAuthUnauthorizedException;
import org.joda.time.DateTime;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;
import java.util.Map;

public interface Calendars {

    /**
     * <b>OAuth Required</b>
     *
     * @see #shows(String, int)
     */
    @GET("/calendars/my/shows/{startdate}/{days}")
    List<CalendarShowEntry> myShows(
            @Path("startdate") String startDate,
            @Path("days") int days
    ) throws OAuthUnauthorizedException;

    /**
     * <b>OAuth Required</b>
     *
     * @see #newShows(String, int)
     */
    @GET("/calendars/my/shows/new/{startdate}/{days}")
    List<CalendarShowEntry> myNewShows(
            @Path("startdate") String startDate,
            @Path("days") int days
    ) throws OAuthUnauthorizedException;

    /**
     * <b>OAuth Required</b>
     *
     * @see #seasonPremieres(String, int)
     */
    @GET("/calendars/my/shows/premieres/{startdate}/{days}")
    List<CalendarShowEntry> mySeasonPremieres(
            @Path("startdate") String startDate,
            @Path("days") int days
    ) throws OAuthUnauthorizedException;

    /**
     * Returns all shows airing during the time period specified.
     *
     * @param startDate Start the calendar on this date. Example: 2014-09-01.
     * @param days Number of days to display. Example: 7.
     */
    @GET("/calendars/all/shows/{startdate}/{days}")
    List<CalendarShowEntry> shows(
            @Path("startdate") String startDate,
            @Path("days") int days
    );

    /**
     * Returns all new show premieres (season 1, episode 1) airing during the time period specified.
     *
     * @param startDate Start the calendar on this date. Example: 2014-09-01.
     * @param days Number of days to display. Example: 7.
     */
    @GET("/calendars/all/shows/new/{startdate}/{days}")
    List<CalendarShowEntry> newShows(
            @Path("startdate") String startDate,
            @Path("days") int days
    );

    /**
     * Returns all show premieres (any season, episode 1) airing during the time period specified.
     *
     * @param startDate Start the calendar on this date. Example: 2014-09-01.
     * @param days Number of days to display. Example: 7.
     */
    @GET("/calendars/all/shows/premieres/{startdate}/{days}")
    List<CalendarShowEntry> seasonPremieres(
            @Path("startdate") String startDate,
            @Path("days") int days
    );

    /**
     * <b>OAuth Optional</b>
     *
     * <p> Returns all movies with a release date in the next 7 days.
     */
    @GET("/calendars/movies")
    Map<DateTime, List<CalendarEntry>> movies() throws OAuthUnauthorizedException;

    /**
     * <b>OAuth Optional</b>
     *
     * <p> Returns all movies with a release date during the time period specified.
     *
     * @param startDate Start the calendar on this date. Example: 2014-09-01.
     * @param days Number of days to display. Example: 7.
     */
    @GET("/calendars/movies/{startdate}/{days}")
    Map<DateTime, List<CalendarEntry>> movies(
            @Path("startdate") String startDate,
            @Path("days") int days
    ) throws OAuthUnauthorizedException;

}
