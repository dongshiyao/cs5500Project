package css.neu.edu.cs5500.neufoodtruck.service;

import java.sql.Timestamp;
import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;

public interface PetOwnerService {

    List<AnimalRecord> findAnimalByCategory(String category);

    List<AnimalRecord> findAnimalByCategoryAndBreed(String category, String breed);

    List<AnimalRecord> findAnimalByCategoryAndColor(String category, String color);

    List<AnimalRecord> findAnimalByCategoryAndBreedAndColor(String category, String breed, String color);

    List<AnimalRecord> findAnimalByCategoryAfterLostTime(String category, Timestamp lostTime);

    List<AnimalRecord> findAnimalByCategoryAndBreedAfterLostTime(String category, String breed, Timestamp lostTime);

    List<AnimalRecord> findAnimalByCategoryAndColorAfterLostTime(String category, String color, Timestamp lostTime);

    List<AnimalRecord> findAnimalByCategoryAndBreedAndColorAfterLostTime(String category, String breed, String color, Timestamp lostTime);

    List<AnimalRecord> findAnimalWithinCertainLocation(double distance, double latitude, double longitude, String unit);
}
