package css.neu.edu.cs5500.neufoodtruck.service;

import css.neu.edu.cs5500.neufoodtruck.dao.AnimalRecordRepository;
import css.neu.edu.cs5500.neufoodtruck.dao.LocationHistoryRepository;
import css.neu.edu.cs5500.neufoodtruck.dao.ShelterRepository;
import css.neu.edu.cs5500.neufoodtruck.model.CoordinateRecord;
import css.neu.edu.cs5500.neufoodtruck.model.LocationHistory;
import css.neu.edu.cs5500.neufoodtruck.util.DataValid;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.model.Shelter;


@Component("shelterEmployeeService")
@Transactional
public class ShelterEmployeeServiceImpl implements ShelterEmployeeService {

    private final AnimalRecordRepository animalRecordRepository;
    private final LocationHistoryRepository locationHistoryRepository;
    private final ShelterRepository shelterRepository;

    public ShelterEmployeeServiceImpl(AnimalRecordRepository animalRecordRepository,
                                      LocationHistoryRepository locationHistoryRepository,
                                      ShelterRepository shelterRepository) {
        this.animalRecordRepository = animalRecordRepository;
        this.locationHistoryRepository = locationHistoryRepository;
        this.shelterRepository = shelterRepository;
    }

    @Override
    public Shelter findShelterById(int shelterId) {
        return shelterRepository.findOne(shelterId);
    }

    @Override
    public int createShelter(Shelter shelter) throws IllegalArgumentException {
        DataValid.validateShelter(shelter);
        shelterRepository.save(shelter);
        int id = shelter.getShelterId();
        return id;
    }

    @Override
    public int putAnimalIntoShelter(int animalId, int shelterId) {
        Shelter shelter = findShelterById(shelterId);
        AnimalRecord animalRecord = animalRecordRepository.findOne(animalId);
        DataValid.validateAnimalRecord(animalRecord);
        DataValid.validateShelter(shelter);
        double shelterLong = shelter.getLocationLong();
        double shelterLat = shelter.getLocationLat();
        int shelterAvailability = shelter.getAvailability();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        CoordinateRecord coordinateRecord = new CoordinateRecord(shelterLong, shelterLat, now);

        animalRecordRepository.setFixedStatusFor("in shelter", animalId);
        animalRecordRepository.setFixedShelterIdFor(shelterId, animalId);
        animalRecordRepository.setFixedUpdateTimeFor(now, animalId);
        animalRecordRepository.setFixedCurrentLocationFor(shelterLong, shelterLat, animalId);
        shelterRepository.setFixedAvailabilityFor(shelterAvailability - 1, shelterId);
        String animalTime = String.valueOf(animalId) + "_" + now.toString();
        LocationHistory locationHistory = new LocationHistory(animalTime, animalId, coordinateRecord);
        locationHistoryRepository.save(locationHistory);

        return animalId;
    }

    @Override
    public List<Shelter> findAllShelters() {
        ArrayList<Shelter> shelters = (ArrayList<Shelter>) shelterRepository.findAll();
        return shelters;
    }

    @Override
    public List<AnimalRecord> findAnimalByShelterId(int shelterId) {
        List<AnimalRecord> result = new ArrayList<>();
        ArrayList<AnimalRecord> animalRecords = (ArrayList<AnimalRecord>) animalRecordRepository.findAll();
        for (AnimalRecord animalRecord : animalRecords) {
            if (animalRecord.getShelterId() == shelterId) {
                result.add(animalRecord);
            }
        }
        return result;
    }

    @Override
    public int checkShelterCapacityById(int shelterId) {
        Shelter shelter = shelterRepository.findOne(shelterId);
        return shelter.getCapacity();
    }

    @Override
    public int checkShelterAvailabilityById(int shelterId) {
        Shelter shelter = shelterRepository.findOne(shelterId);
        return shelter.getAvailability();
    }
}
