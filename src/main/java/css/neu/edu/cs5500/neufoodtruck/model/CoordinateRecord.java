package css.neu.edu.cs5500.neufoodtruck.model;

import java.sql.Timestamp;

/**
 * This represents the coordinate record including coordinate and timestamp.
 */
public class CoordinateRecord {
    private double longitude;
    private double latitude;
    private Timestamp updateTime;

    protected CoordinateRecord() {
    }

    public CoordinateRecord(double longitude, double latitude, Timestamp updateTime) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
        this.updateTime = updateTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
