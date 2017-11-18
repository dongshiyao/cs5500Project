package css.neu.edu.cs5500.neufoodtruck.util;

import org.springframework.util.Assert;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.CoordinateRecord;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;

public class DataValid {

    public static void validateAnimalRecord(AnimalRecord animalRecord) {
        Assert.notNull(animalRecord.getCategory(), "Category must not be null");
        Assert.notNull(animalRecord.getFoundTime(), "Found time must not be null");
        Assert.notNull(animalRecord.getUpdateTime(), "Update time must not be null");
        Assert.isTrue(animalRecord.getFoundLocationLat() != 0, "Found location latitude must not be 0");
        Assert.isTrue(animalRecord.getFoundLocationLong() != 0, "Found location longitude must not be 0");
        Assert.isTrue(animalRecord.getCurrentLocationLat() != 0, "Current location latitude must not be 0");
        Assert.isTrue(animalRecord.getCurrentLocationLong() != 0, "Current location longitude must not be 0");
    }

    public static void validateCoordinateRecord(CoordinateRecord coordinateRecord) {
        Assert.notNull(coordinateRecord.getUpdateTime(), "Update time must not be null");
        Assert.isTrue(coordinateRecord.getLongitude() != 0, "Longitude must not be 0");
        Assert.isTrue(coordinateRecord.getLatitude() != 0, "Latitude must not be 0");
    }

    public static void validateShelter(Shelter shelter) {
        Assert.notNull(shelter.getName(), "Shelter name must not be null");
        Assert.isTrue(shelter.getCapacity() > 0, "Capacity must be larger than 0");
        Assert.isTrue(shelter.getAvailability() <= shelter.getCapacity(), "Availability must not be larger than capacity");
        Assert.isTrue(shelter.getAvailability() > 0, "Availability must be larger than 0");
        Assert.isTrue(shelter.getLocationLong() != 0, "Location longitude must not be 0");
        Assert.isTrue(shelter.getLocationLat() != 0, "Location latitude must not be 0");
    }
}
