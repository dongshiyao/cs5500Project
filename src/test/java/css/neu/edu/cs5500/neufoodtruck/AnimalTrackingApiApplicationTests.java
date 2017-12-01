package css.neu.edu.cs5500.neufoodtruck;

import css.neu.edu.cs5500.neufoodtruck.dao.AnimalRecordRepository;
import css.neu.edu.cs5500.neufoodtruck.model.AnimalRecord;
import css.neu.edu.cs5500.neufoodtruck.service.PetOwnerService;
import css.neu.edu.cs5500.neufoodtruck.service.PetOwnerServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AnimalTrackingApiApplicationTests {
	public PetOwnerService petOwnerService;
	public AnimalRecordRepository animalRecordRepository;

	@Before
	public void doSetup() {
		animalRecordRepository = mock(AnimalRecordRepository.class);
		petOwnerService = new PetOwnerServiceImpl(animalRecordRepository);
	}

	@Test
	public void testFindByCategory() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("23/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		animalRecords.add(animalRecord1);
		animalRecords.add(animalRecord2);
		when(animalRecordRepository.findByCategory("cat")).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategory("cat");
		verify(animalRecordRepository).findByCategory("cat");
	}

	@Test
	public void testFindByCategoryAndBreed() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("23/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		animalRecords.add(animalRecord1);
		when(animalRecordRepository.findByCategoryAndBreed("cat", "siamese cat")).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAndBreed("cat", "siamese cat");
		verify(animalRecordRepository).findByCategoryAndBreed("cat", "siamese cat");
	}

	@Test
	public void testFindByCategoryAndColor() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("23/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		when(animalRecordRepository.findByCategoryAndColor("cat", "yellow")).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAndColor("cat", "yellow");
		verify(animalRecordRepository).findByCategoryAndColor("cat", "yellow");
	}

	@Test
	public void testFindByCategoryAndBreedAndColor() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("23/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		when(animalRecordRepository.findByCategoryAndBreedAndColor("cat", "siamese cat", "yellow")).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAndBreedAndColor("cat", "siamese cat", "yellow");
		verify(animalRecordRepository).findByCategoryAndBreedAndColor("cat", "siamese cat", "yellow");
	}

	@Test
	public void testFindByCategoryAndFoundAfterTime() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("24/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		animalRecords.add(animalRecord1);
		when(animalRecordRepository.findByCategoryAndFoundTimeAfter("cat", past)).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAfterLostTime("cat", past);
		verify(animalRecordRepository).findByCategoryAndFoundTimeAfter("cat", past);
	}

	@Test
	public void testFindByCategoryAndBreedAfterFoundTime() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("24/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		animalRecords.add(animalRecord1);
		when(animalRecordRepository.findByCategoryAndBreedAndFoundTimeAfter("cat", "siamese cat", past)).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAndBreedAfterLostTime("cat", "siamese cat", past);
		verify(animalRecordRepository).findByCategoryAndBreedAndFoundTimeAfter("cat", "siamese cat", past);
	}

	@Test
	public void testFindAnimalByCategoryAndBreedAndColorAfterLostTime() throws  Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("24/09/2017");
		long time = date.getTime();
		Timestamp past = new Timestamp(time);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		List<AnimalRecord> animalRecords = new ArrayList<>();
		AnimalRecord animalRecord1 = new AnimalRecord(
				"cat",
				"siamese cat",
				23,
				"M",
				"yellow",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		AnimalRecord animalRecord2 = new AnimalRecord(
				"cat",
				"beagle",
				23,
				"M",
				"white",
				"in shelter",
				past,
				past,
				11,
				12,
				11,
				12,
				1);
		animalRecords.add(animalRecord1);
		when(animalRecordRepository.findByCategoryAndBreedAndColorAndFoundTimeAfter("cat", "siamese cat", "yellow", past)).thenReturn(animalRecords);
		List<AnimalRecord> result = petOwnerService.findAnimalByCategoryAndBreedAndColorAfterLostTime("cat", "siamese cat", "yellow", past);
		verify(animalRecordRepository).findByCategoryAndBreedAndColorAndFoundTimeAfter("cat", "siamese cat", "yellow", past);
	}
}