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

// Ta linia jest wymagana
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	@Test
	public void mockingWorskAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	// Ann i Joe sie spykneli
	@Test
	public void joeIsFriendsWithAnne(){
		
		Person ann = spy(new Person("Ann"));
		doReturn(ann).when(friends).findByName("Ann");
		doReturn(Arrays.asList(new String[]{ "Joe" })).when(ann).getFriends();
			
		assertThat(friendships.areFriends("Ann", "Joe")).isTrue();
	}
	
	
	// Zdradziła go i juz nie są kolegami #skreśliłaGozFb
	@Test
	public void joeBorkeUpWithAnne(){
		
		Person ann = spy(new Person("Ann"));
		doReturn(ann).when(friends).findByName("Ann");
		doReturn(Arrays.asList(new String[]{ "bob" })).when(ann).getFriends();
			
		assertThat(friendships.areFriends("Ann", "Joe")).isFalse();
	}


}