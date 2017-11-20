package css.neu.edu.cs5500.neufoodtruck.service;

import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Timestamp;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.CoordinateRecord;

public interface VolunteerService {

    /**
     * Create an animal record.
     *
     * @param animalRecord the animal record
     * @return id
     * @throws  IllegalArgumentException when input is not valid
     */
    int createAnimalRecord(AnimalRecord animalRecord) throws IllegalArgumentException;

    /**
     * Update animal's location.
     *
     * @param animalId animal id
     * @param coordinateRecord the coordinate record
     * @return animal id
     * @throws IllegalArgumentException when input is not valid
     */
    int updateAnimalLocation(int animalId, CoordinateRecord coordinateRecord) throws IllegalArgumentException;

    /**
     * Delete animal record by id.
     *
     * @param id animal id
     * @return animal id
     * @throws EmptyResultDataAccessException when id doesn't exist
     */
    int deleteAnimalById(int id) throws EmptyResultDataAccessException;

    /**
     * Find animal by id.
     *
     * @param id animal id
     * @return animal record
     */
    AnimalRecord findAnimalById(int id);

    /**
     * Update animal status.
     *
     * @param animalId animal id
     * @param status new status
     * @return status
     */
    String updateAnimalStatus(int animalId, String status);
}
