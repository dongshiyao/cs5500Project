package css.neu.edu.cs5500.neufoodtruck.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;

public interface LocationHistoryRepository extends CrudRepository<LocationHistory, String>{

    List<LocationHistory> findByAnimalIdOrderByUpdateTimeAsc(int animalId);

    List<LocationHistory> removeByAnimalId(int animalId);
}
