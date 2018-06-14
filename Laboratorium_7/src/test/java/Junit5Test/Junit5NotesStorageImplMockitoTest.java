package Junit5Test;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import MockExamples.MockExamples.Note;
import MockExamples.MockExamples.NotesServiceImpl;
import MockExamples.MockExamples.NotesStorage;

@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtention.class) //Reczna implementacja extensiona Mockito
class Junit5NotesStorageImplMockitoTest {

	@Mock
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
        doReturn(list).when(storage).getAllNotesOf("Janusz");

        test.add(note);

        assertThat(4.0f).isEqualTo(test.averageOf("Janusz"));
    }

    @Test
    public void clear_StorageEmpty_ResetsList(){
        doNothing().when(storage).clear();
        doReturn(Arrays.asList(new Note[] { } )).when(storage).getAllNotesOf("Pan");

        test.clear();

        assertThat(test.averageOf("Pan")).isEqualTo(Float.NaN);
    }

    @Test
    public void clear_StorageWithMultipleNotes_ResetsList(){
        Note note2 = Note.of("Pan", 3.0f);
        Note note3 = Note.of("Pan", 4.0f);
        doNothing().when(storage).clear();
        doReturn(Arrays.asList(new Note[] { } )).when(storage).getAllNotesOf("Pan");

        test.clear();

        assertThat(Float.NaN).isEqualTo(test.averageOf("Pan"));
    }

    @Test
    public void averageOf_StorageWithMultipleNotesOfSameUser_ReturnsProperAverageValue(){
        Note note2 = Note.of("Pan", 3.0f);
        Note note3 = Note.of("Pan", 4.0f);
        doReturn(Arrays.asList(new Note[] {note2, note3})).when(storage).getAllNotesOf("Pan");
        doNothing().when(storage).add(note2);
        doNothing().when(storage).add(note3);

        test.add(note2);
        test.add(note3);

        float expected = (3.0f + 4.0f) / 2;
        assertThat(expected).isEqualTo(test.averageOf("Pan"));
    }

    @Test
    public void averageOf_UserNotInStorage_ReturnZero(){
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        assertThat(Float.NaN).isEqualTo(ns.averageOf("Nie ma go"));
    }

}
