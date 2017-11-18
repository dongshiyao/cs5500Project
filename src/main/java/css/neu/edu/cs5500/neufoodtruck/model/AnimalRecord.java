package css.neu.edu.cs5500.neufoodtruck.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This represents the data model for an animal's tracking information.
 */
@Entity
@Table(name = "fullAnimalRecords")
public class AnimalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @Column( nullable = false)
    private String category;

    @Column
    private String breed;

    @Column
    private int weight;

    @Column
    private String gender;

    @Column
    private String color;

    @Column
    private String status;

    @Column(nullable = false)
    private Timestamp foundTime;

    @Column(nullable = false)
    private Timestamp updateTime;

    @Column(nullable = false)
    private double foundLocationLong;

    @Column(nullable = false)
    private double foundLocationLat;

    @Column(nullable = false)
    private double currentLocationLong;

    @Column(nullable = false)
    private double currentLocationLat;

    @Column
    private int shelterId;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Timestamp foundTime) {
        this.foundTime = foundTime;
    }

    public double getFoundLocationLong() {
        return foundLocationLong;
    }

    public void setFoundLocationLong(double foundLocationLong) {
        this.foundLocationLong = foundLocationLong;
    }

    public double getFoundLocationLat() {
        return foundLocationLat;
    }

    public void setFoundLocationLat(double foundLocationLat) {
        this.foundLocationLat = foundLocationLat;
    }

    public double getCurrentLocationLong() {
        return currentLocationLong;
    }

    public void setCurrentLocationLong(double currentLocationLong) {
        this.currentLocationLong = currentLocationLong;
    }

    public double getCurrentLocationLat() {
        return currentLocationLat;
    }

    public void setCurrentLocationLat(double currentLocationLat) {
        this.currentLocationLat = currentLocationLat;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }
}
