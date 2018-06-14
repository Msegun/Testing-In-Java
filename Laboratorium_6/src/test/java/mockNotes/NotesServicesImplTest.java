package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mocks.Checker;
import mocks.MockSystemEnvironment;

public class NotesServicesImplTest {

	private MockNotesStorage mock;
	private NotesServiceImpl test;
	Note note1;
	Note note2;
	Note note3;
	Note note4;
	
	@BeforeEach
	public void setUp() {
		mock = new MockNotesStorage();
		test = NotesServiceImpl.createWith(mock);
		note1 = Note.of("Jan", 3.0f);
		note2 = Note.of("Jan", 4.0f);
		note3 = Note.of("Paweu", 2.0f);
		note4 = Note.of("II", 4.0f);
	}
	
	@Test
	public void EmptyTest() {
		
		assertEquals(0, mock.list.size());
	}
	
	@Test
	public void AddTest() {
		Note newGuy = Note.of("M Miotk", 3.0f);
		test.add(newGuy);
		
		assertEquals(1, mock.list.size());
	}
	
	@Test
	public void AddAllPeopleTest() {
		test.add(note1);
		test.add(note2);
		test.add(note3);
		test.add(note4);
		
		assertEquals(4, mock.list.size());
	}
	
	
	@Test
	public void ListAvgTest() {
		test.add(note1);
		test.add(note2);
		test.add(note3);
		test.add(note4);
		
		assertEquals(3.5, test.averageOf("Jan"), 0.01f);
	}
	
	@Test
	public void NonExistantElementInListAvgTest() {
		test.add(note1);
		test.add(note2);
		test.add(note3);
		test.add(note4);
		
		assertEquals(Double.NaN, test.averageOf("EloNieMaMnieWlisciexD"), 0.01f);
	}
	
	@Test
	public void EmptyListAvgTest() {
		assertEquals(Double.NaN, test.averageOf("PustaLista :("), 0.01f);
	}
	
	@Test
	public void CleanTest() {
		test.clear();
		
		assertTrue(mock.list.isEmpty());
	}
	
}