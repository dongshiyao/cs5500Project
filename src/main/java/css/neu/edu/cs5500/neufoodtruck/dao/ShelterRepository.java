package css.neu.edu.cs5500.neufoodtruck.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import css.neu.edu.cs5500.neufoodtruck.model.Shelter;

public interface ShelterRepository extends CrudRepository<Shelter, Integer> {

    @Modifying
    @Query("update Shelter s set s.capacity = ?1 where s.shelterId = ?2")
    int setFixedCapacityFor(int capacity, int shelterId);

    @Modifying
    @Query("update Shelter s set s.availability = ?1 where s.shelterId = ?2")
    int setFixedAvailabilityFor(int availability, int shelterId);

    @Modifying
    @Query("update Shelter s set s.locationLong = ?1, s.locationLat = ?2 where s.shelterId = ?3")
    int setFixedLocation(double longitude, double latitude, int shelterId);
}
