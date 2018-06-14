package MockExamples.MockExamples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class NotesServiceImplMockitoTest {
	
	@Mock
    NotesStorage storage;

    @Test
    public void createWith_InstantiatesNewNotesServiceImp(){
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        assertThat(ns).isNotNull();
    }

    @Test
    public void add_NewNote_StorageNowContainsUser(){
        Note note = Note.of("Janusz", 4.0f);
        List<Note> list = Arrays.asList(new Note[] {note});
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        doReturn(list).when(storage).getAllNotesOf("Janusz");

        ns.add(note);

        assertThat(4.0f).isEqualTo(ns.averageOf("Janusz"));
    }

    @Test
    public void clear_StorageEmpty_ResetsList(){
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        doNothing().when(storage).clear();
        doReturn(Arrays.asList(new Note[] { } )).when(storage).getAllNotesOf("Pan");

        ns.clear();

        assertThat(ns.averageOf("Pan")).isEqualTo(Float.NaN);
    }

    @Test
    public void clear_StorageWithMultipleNotes_ResetsList(){
        Note note2 = Note.of("Pan", 3.0f);
        Note note3 = Note.of("Pan", 4.0f);
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        doNothing().when(storage).clear();
        doReturn(Arrays.asList(new Note[] { } )).when(storage).getAllNotesOf("Pan");

        ns.clear();

        assertThat(Float.NaN).isEqualTo(ns.averageOf("Pan"));
    }

    @Test
    public void averageOf_StorageWithMultipleNotesOfSameUser_ReturnsProperAverageValue(){
        Note note2 = Note.of("Pan", 3.0f);
        Note note3 = Note.of("Pan", 4.0f);
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        doReturn(Arrays.asList(new Note[] {note2, note3})).when(storage).getAllNotesOf("Pan");
        doNothing().when(storage).add(note2);
        doNothing().when(storage).add(note3);

        ns.add(note2);
        ns.add(note3);

        float expected = (3.0f + 4.0f) / 2;
        assertThat(expected).isEqualTo(ns.averageOf("Pan"));
    }

    @Test
    public void averageOf_UserNotInStorage_ReturnZero(){
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        assertThat(Float.NaN).isEqualTo(ns.averageOf("Nie ma go"));
    }

}
