package css.neu.edu.cs5500.neufoodtruck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shelters")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shelterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int availability;

    @Column(nullable = false)
    private double locationLong;

    @Column(nullable = false)
    private double locationLat;

    public Shelter() {
    }

    public Shelter(String name) {
    }

    public Shelter(String name, int capacity, int availability, double locationLong, double locationLat) {
        this.name = name;
        this.capacity = capacity;
        this.availability = availability;
        this.locationLong = locationLong;
        this.locationLat = locationLat;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
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
