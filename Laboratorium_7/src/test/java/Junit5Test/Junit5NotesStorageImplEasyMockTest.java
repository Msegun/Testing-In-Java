package Junit5Test;

import org.easymock.Mock;
import org.easymock.MockType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; //uzywam JUnit5!!!
import org.junit.jupiter.api.extension.ExtendWith;

import MockExamples.MockExamples.Note;
import MockExamples.MockExamples.NotesServiceImpl;
import MockExamples.MockExamples.NotesStorage;


@ExtendWith(EasyMockExtention.class)
public class Junit5NotesStorageImplEasyMockTest {

	@Mock(type = MockType.NICE)
    NotesStorage storage;

	private NotesServiceImpl test;
	
	@BeforeEach
	public void SetUp() {
		test = NotesServiceImpl.createWith(storage);
	}
	
    @Test
    public void createWith_InstantiatesNewNotesServiceImp(){
        assertThat(test).isNotNull();
    }

    @Test
    public void add_NewNote_StorageNowContainsUser(){
        Note note = Note.of("Janusz", 4.0f);
        List<Note> list = Arrays.asList(new Note[] {note});
        expect(storage.getAllNotesOf("Janusz")).andReturn(list);
        replay(storage);

        test.add(note);

        assertThat(4.0f).isEqualTo(test.averageOf("Janusz"));
    }

    @Test
    public void clear_StorageEmpty_ResetsList() {
        expect(storage.getAllNotesOf("Pan")).andReturn(Arrays.asList(new Note[]{}));
        replay(storage);

        test.clear();

        assertThat(Float.NaN).isEqualTo(test.averageOf("Pan"));
    }

    @Test
    public void averageOf_StorageWithMultipleNotesOfSameUser_ReturnsProperAverageValue(){
        Note note2 = Note.of("Pan", 3.0f);
        Note note3 = Note.of("Pan", 4.0f);
        expect(storage.getAllNotesOf("Pan")).andReturn(Arrays.asList(new Note[] {note2, note3} ));
        replay(storage);

        test.add(note2);
        test.add(note3);

        float expected = (3.0f + 4.0f) / 2;
        assertThat(expected).isEqualTo(test.averageOf("Pan"));
    }
}
