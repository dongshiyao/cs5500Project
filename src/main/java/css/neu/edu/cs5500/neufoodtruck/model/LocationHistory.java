package css.neu.edu.cs5500.neufoodtruck.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This represents the data model of location history record
 */
@Entity
@Table(name = "locationHistory")
public class LocationHistory {
    @Id
    private String animalTime;

    @Column(nullable = false)
    private int animalId;

    @Column(nullable = false)
    private Timestamp updateTime;

    @Column(nullable = false)
    private double locationLong;

    @Column(nullable = false)
    private double locationLat;

    protected LocationHistory() {}

    public LocationHistory(String animalTime, int animalId, CoordinateRecord coordinateRecord) {
        super();
        this.animalTime = animalTime;
        this.animalId = animalId;
        this.updateTime = coordinateRecord.getUpdateTime();
        this.locationLong = coordinateRecord.getLongitude();
        this.locationLat = coordinateRecord.getLatitude();
    }

    public LocationHistory(String animalTime, int animalId, Timestamp updateTime,
                           double locationLong, double locationLat) {
        super();
        this.animalTime = animalTime;
        this.animalId = animalId;
        this.updateTime = updateTime;
        this.locationLong = locationLong;
        this.locationLat = locationLat;
    }

    public String getAnimalTime() {
        return animalTime;
    }

    public void setAnimalTime(String animalTime) {
        this.animalTime = animalTime;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public double getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(double locationLong) {
        this.locationLong = locationLong;
    }

    public double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(double locationLat) {
        this.locationLat = locationLat;
    }
}
