package css.neu.edu.cs5500.neufoodtruck.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;

public interface AnimalRecordRepository extends CrudRepository<AnimalRecord, Integer> {

    List<AnimalRecord> findByCategory(String category);

    List<AnimalRecord> findByCategoryAndBreed(String category, String breed);

    List<AnimalRecord> findByCategoryAndColor(String category, String color);

    List<AnimalRecord> findByCategoryAndBreedAndColor(String category, String breed, String color);

    List<AnimalRecord> findByCategoryAndFoundTimeAfter(String category, Timestamp foundTime);

    List<AnimalRecord> findByCategoryAndBreedAndFoundTimeAfter(String category, String breed, Timestamp foundTime);

    List<AnimalRecord> findByCategoryAndColorAndFoundTimeAfter(String category, String color, Timestamp foundTime);

    List<AnimalRecord> findByCategoryAndBreedAndColorAndFoundTimeAfter(String category, String breed, String color, Timestamp foundTime);

    @Modifying
    @Query("update AnimalRecord u set u.category = ?1 where u.animalId = ?2")
    int setFixedCategoryFor(String category, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.breed = ?1 where u.animalId = ?2")
    int setFixedBreedFor(String breed, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.weight = ?1 where u.animalId = ?2")
    int setFixedWeightFor(int weight, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.gender = ?1 where u.animalId = ?2")
    int setFixedGenderFor(String gender, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.color = ?1 where u.animalId = ?2")
    int setFixedColorFor(String color, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.status = ?1 where u.animalId = ?2")
    int setFixedStatusFor(String status, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.foundTime = ?1 where u.animalId = ?2")
    int setFixedFoundTimeFor(Timestamp foundTime, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.updateTime = ?1 where u.animalId = ?2")
    int setFixedUpdateTimeFor(Timestamp updateTime, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.foundLocationLong = ?1, u.foundLocationLat = ?2 where u.animalId = ?3")
    int setFixedFoundLocationFor(double foundLocationLong, double foundLocationLat, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.currentLocationLong = ?1, u.currentLocationLat = ?2 where u.animalId = ?3")
    int setFixedCurrentLocationFor(double currentLocationLong, double currentLocationLat, int animalId);

    @Modifying
    @Query("update AnimalRecord u set u.shelterId = ?1 where u.animalId = ?2")
    int setFixedShelterIdFor(int shelterId, int animalId);

    List<AnimalRecord> removeByShelterId(int shelterId);
}
