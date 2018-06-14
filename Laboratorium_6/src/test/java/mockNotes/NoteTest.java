package mockNotes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoteTest {

	private Note test;
	private Note testBadBloodName;
	private Note emptyNameTest;
	private Note TooHighNote;
	private Note TooLowNote;
	
	@BeforeEach
	public void SetUp(){
		test = Note.of("Mateusz Miotk", 4.5f);
	}
	
	@Test
	public void GetNameTest() {
		assertEquals("Mateusz Miotk", test.getName());
	}
	
	
	@Test
	public void GetNoteTest() {
		assertEquals(4.5f, test.getNote(),0.01f);
	}
	
	@Test
	public void GetTrimTest() {
		testBadBloodName = Note.of("     bad blood", 2.0f);
		assertEquals("bad blood", testBadBloodName.getName());
	}
	
	@Test
	public void itShouldThrowIllegalArgumentExceptionwhenCreatingNullName() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Note NullNameTest = Note.of(null, 4.5f);
	            });
	}
	
	@Test
	public void itShouldThrowIllegalArgumentExceptionwhenCreatingEmptyName() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	emptyNameTest = Note.of("      ", 4.5f);
	            });
	}
	
	@Test
	public void itShouldThrowIllegalArgumentExceptionwhenCreatingWithTooHighNote() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	TooHighNote = Note.of("Fryderyk Szop", 7.0f);
	            });
	}
	
	@Test
	public void itShouldThrowIllegalArgumentExceptionwhenCreatingTooLowNote() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	TooLowNote = Note.of("Zły student który nie zdau", 1.8f);
	            });
	}
	
	@Test
	public void itShouldThrowIllegalArgumentExceptionwhenCreatingwithBotWrongInputs() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Note FullEvilNote = Note.of("   ", 1.0f);
	            });
	}
	
	@AfterEach
	public void Fall(){
		test = null;
	}
}
