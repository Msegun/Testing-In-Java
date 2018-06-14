package mockNotes;

import java.util.ArrayList;
import java.util.List;

public class MockNotesStorage implements NotesStorage{

	public List<Note> list;
	List<Note> NotesOf;
	
	public MockNotesStorage() {
		list = new ArrayList<Note>();
		NotesOf = new ArrayList<Note>();
	}
	
	public void add(Note note) {
		list.add(note);
	}

	public List<Note> getAllNotesOf(String name) {
		NotesOf.clear();
		for(Note n : list) {
			if(n.getName() == name)
				NotesOf.add(n);
		}
		return NotesOf;
	}

	public void clear() {
		list.clear();
	}

}
