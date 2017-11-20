package css.neu.edu.cs5500.neufoodtruck.util;

import java.util.Objects;

public class DistanceCalculator {

    /**
     * Calculate distance between two coordinate point.
     *
     * @param lat1 latitude one
     * @param lon1 longitude one
     * @param lat2 latitude two
     * @param lon2 longitude two
     * @param unit distance unit, M for mile(default), K for kilometer, N for nautical mile
     * @return the distance
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (Objects.equals(unit, "K")) {
            dist = dist * 1.609344;
        } else if (Objects.equals(unit, "N")) {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    /**
     * Convert decimal degrees to radians
     * @param deg degree
     * @return radian
     */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * Convert radians to decimal degree
     * @param rad radian
     * @return degree
     */
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
