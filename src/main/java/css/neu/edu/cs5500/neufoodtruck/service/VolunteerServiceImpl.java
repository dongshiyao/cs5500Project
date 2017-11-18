package css.neu.edu.cs5500.neufoodtruck.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import css.neu.edu.cs5500.neufoodtruck.dao.AnimalRecordRepository;
import css.neu.edu.cs5500.neufoodtruck.dao.LocationHistoryRepository;
import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.CoordinateRecord;
import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;
import css.neu.edu.cs5500.neufoodtruck.util.DataValid;

@Component("volunteerService")
@Transactional
class VolunteerServiceImpl implements VolunteerService {

    private final AnimalRecordRepository animalRecordRepository;
    private final LocationHistoryRepository locationHistoryRepository;

    public VolunteerServiceImpl(AnimalRecordRepository animalRecordRepository,
                                LocationHistoryRepository locationHistoryRepository) {
        this.animalRecordRepository = animalRecordRepository;
        this.locationHistoryRepository = locationHistoryRepository;
    }

    @Override
    public AnimalRecord findAnimalById(int animalId) {
        return animalRecordRepository.findOne(animalId);
    }

    @Override
    public int createAnimalRecord(AnimalRecord animalRecord) throws IllegalArgumentException {
        DataValid.validateAnimalRecord(animalRecord);
        animalRecordRepository.save(animalRecord);
        int id = animalRecord.getAnimalId();
        String animalTime = String.valueOf(id) + "_" + animalRecord.getFoundTime().toString();
        LocationHistory locationHistory = new LocationHistory(animalTime, id,
            animalRecord.getFoundTime(), animalRecord.getFoundLocationLong(),
            animalRecord.getFoundLocationLat());
        locationHistoryRepository.save(locationHistory);
        return id;
    }

    @Override
    public int updateAnimalLocation(int animalId, CoordinateRecord coordinateRecord) throws IllegalArgumentException {
        DataValid.validateCoordinateRecord(coordinateRecord);
        animalRecordRepository.setFixedUpdateTimeFor(coordinateRecord.getUpdateTime(), animalId);
        animalRecordRepository.setFixedCurrentLocationFor(coordinateRecord.getLongitude(),
            coordinateRecord.getLatitude(), animalId);
        String animalTime = String.valueOf(animalId) + "_" + coordinateRecord.getUpdateTime().toString();
        LocationHistory locationHistory = new LocationHistory(animalTime, animalId, coordinateRecord);
        locationHistoryRepository.save(locationHistory);
        return animalId;
    }

    @Override
    public int deleteAnimalById(int animalId) throws EmptyResultDataAccessException {
        animalRecordRepository.delete(animalId);
        locationHistoryRepository.removeByAnimalId(animalId);
        return animalId;
    }

    @Override
    public String updateAnimalStatus(int animalId, String status) {
        animalRecordRepository.setFixedStatusFor(status, animalId);
        return status;
    }
}
