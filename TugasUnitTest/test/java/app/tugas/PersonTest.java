package app.tugas;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	public Main proses;
	
	private Person createPersonWithAge(int ageToTest) {
		int currentYear = LocalDate.now().getYear();
		int birthYear = currentYear - ageToTest;
		String birthDate = birthYear + "-01-01";
		Person person = new Person ("Lintang", birthDate);
		return person;
	}
	
	@BeforeEach
	public void setUp() {
		proses = mock(Main.class);
	}
	
	@Test
	void testGetAge() {
		int ageToTest = 20;
		Person person = createPersonWithAge(ageToTest);
		when(proses.testPerson()).thenReturn(true);
		Assertions.assertTrue(person.getAge() == ageToTest);
	}
	
	@Test
	void test15YearOldIsNot17OrOlder() {
		Person person = createPersonWithAge(15);
		when(proses.testPerson()).thenReturn(false);
		Assertions.assertFalse(person.is17OrOlder());
	}
	
	@Test
	void test17YearOldIs17OrOlder() {
		Person person = createPersonWithAge(17);
		when(proses.testPerson()).thenReturn(true);
		Assertions.assertTrue(person.is17OrOlder());
	}
	
	@Test
	void test20YearOldIs17OrOlder() {
		Person person = createPersonWithAge(20);
		when(proses.testPerson()).thenReturn(true);
		Assertions.assertTrue(person.is17OrOlder());
	}
	
	@Test
	void test30YearOldIs17OrOlder() {
		Person person = createPersonWithAge(30);
		when(proses.testPerson()).thenReturn(true);
		Assertions.assertTrue(person.is17OrOlder());
	}

}
