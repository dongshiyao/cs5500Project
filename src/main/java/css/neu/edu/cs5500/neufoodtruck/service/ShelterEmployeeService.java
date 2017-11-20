package css.neu.edu.cs5500.neufoodtruck.service;

import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;

public interface ShelterEmployeeService {

    int createShelter(Shelter shelter) throws IllegalArgumentException;

    Shelter findShelterById(int id);

    int putAnimalIntoShelter(int animalId, int shelterId);

    List<Shelter> findAllShelters();

    List<AnimalRecord> findAnimalByShelterId(int shelterId);

    int checkShelterCapacityById(int shelterId);

    int checkShelterAvailabilityById(int shelterId);

    List<AnimalRecord> findAllAnimals();

    int updateAnimalCategory(String category, int animalId);

    int updateAnimalBreed(String breed, int animalId);

    int updateAnimalWeight(int weight, int animalId);

    int updateAnimalGender(String gender, int animalId);

    int updateAnimalColor(String color, int animalId);

    List<AnimalRecord> removeAllAnimalInShelter(int shelterId);

    int updateShelterCapacity(int capacity, int shelterId);

    int updateShelterLocation(double longitude, double latitude, int shelterId);

    int moveAnimalToShelter(int animalId, int shelterId);

    List<LocationHistory> trackAnimal(int animalId);
}
