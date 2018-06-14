package MockExamples.MockExamples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class NotesServiceImplMongoEasyMockTest {
	
	@Mock(type = MockType.NICE)
	NotesStorage storage;

	
	@Test
    public void createWith_InstantiatesNewNotesServiceImplShouldWork(){
		
        NotesServiceImpl test = NotesServiceImpl.createWith(storage);
        assertThat(test).isNotNull();
    }
	
	@Test
	public void EmptyArrayTestCheckingIfEasyMockWorks(){
		
		List<Note> expected = Arrays.asList(new Note[] {});

		expect(storage.getAllNotesOf("Joe")).andReturn(expected);
		
		replay(storage);

		assertThat(storage.getAllNotesOf("Joe")).isEqualTo(expected);
	}

	
	@Test
	public void GetNotesOfJoeTest() {
		
		Note joe = Note.of("Joe", 3.0f);
		List<Note> expected = Arrays.asList(new Note[]{ joe });
		expect(storage.getAllNotesOf("Joe")).andReturn(expected);
		
		replay(storage);
		
		assertThat(storage.getAllNotesOf("Joe")).hasSize(1).containsOnly(joe);

	}
	
	@Test
	public void GetAverageOfJoeTest() {
		
		Note joe = Note.of("Joe", 3.0f);
		List<Note> expected = Arrays.asList(new Note[]{ joe });
		expect(storage.getAllNotesOf("Joe")).andReturn(expected);
		
		replay(storage);
		
		NotesServiceImpl test = NotesServiceImpl.createWith(storage);
		
		test.add(joe);
		
		assertThat(test.averageOf("Joe")).isEqualTo(3.0f);

	}
	
	@Test
	public void AverageProperTest() {
		
		Note joe = Note.of("Joe", 3.0f);
		Note joe2 = Note.of("Joe", 4.0f);
		Note Bzyl = Note.of("Włodek", 5.0f);
		Note Miotk = Note.of("M", 4.0f);
		
		List<Note> expected = Arrays.asList(new Note[]{ joe, joe2 });
		
		expect(storage.getAllNotesOf("Joe")).andReturn(expected);
		
		replay(storage);
		
		NotesServiceImpl test = NotesServiceImpl.createWith(storage);
		
		test.add(joe);
		test.add(joe2);
		test.add(Bzyl);
		test.add(Miotk);
		
		assertThat(test.averageOf("Joe")).isEqualTo(3.5f);
	}
	
	@Test
    public void clear_StorageEmpty_ResetsList() {
		
        NotesServiceImpl test = NotesServiceImpl.createWith(storage);
        expect(storage.getAllNotesOf("Joe")).andReturn(Arrays.asList(new Note[]{}));
        replay(storage);

        test.clear();

        assertThat(Float.NaN).isEqualTo(test.averageOf("Joe"));
    }
	
	@Test
    public void averageOf_UserNotInStorage_ReturnNaN(){
		
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        expect(storage.getAllNotesOf("Nie ma go")).andReturn(Arrays.asList(new Note[]{}));
        replay(storage);
        assertThat(Float.NaN).isEqualTo(ns.averageOf("Nie ma go"));
    }
	
    //Przykłady z metodami typu Void dodam poza terminem chciałbym tematykę dokładnie ogarnąć

}
