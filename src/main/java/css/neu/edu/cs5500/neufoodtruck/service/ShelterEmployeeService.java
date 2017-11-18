package css.neu.edu.cs5500.neufoodtruck.service;

import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;

public interface ShelterEmployeeService {

    int createShelter(Shelter shelter) throws IllegalArgumentException;

    Shelter findShelterById(int id);

    int putAnimalIntoShelter(int animalId, int shelterId);

    List<Shelter> findAllShelters();

    List<AnimalRecord> findAnimalByShelterId(int shelterId);

    int checkShelterCapacityById(int shelterId);

    int checkShelterAvailabilityById(int shelterId);
}
