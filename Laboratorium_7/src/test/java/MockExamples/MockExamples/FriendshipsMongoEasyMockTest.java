package MockExamples.MockExamples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {

	@TestSubject
	FriendshipsMongo friendships = new FriendshipsMongo();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	FriendsCollection friends;
	
	@Test
	public void mockingWorksAsExpected(){
		Person joe = new Person("Joe");
		//Zapisanie zachowania - co sie ma stac
		expect(friends.findByName("Joe")).andReturn(joe);
		//Odpalenie obiektu do sprawdzenia zachowania
		replay(friends);
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(expected);
		replay(friends);
		replay(joe);
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	
	// Ann i Joe sie spykneli
	@Test
	public void joeIsFriendsWithAnne(){
		
		Person ann = createMock(Person.class);
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Ann")).andReturn(ann);
		expect(joe.getFriends()).andReturn(Arrays.asList(new String[]{ "Ann" }));
		expect(ann.getFriends()).andReturn(Arrays.asList(new String[]{ "Joe" }));
		
		replay(friends);
		replay(joe);
		replay(ann);		
		
		assertThat(friendships.areFriends("Ann", "Joe")).isTrue();
	}
	
	// Zdradziła go i juz nie są kolegami #skreśliłaGozFb
	@Test
	public void joeBorkeUpWithAnne(){
		
		Person ann = createMock(Person.class);
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Ann")).andReturn(ann);
		expect(joe.getFriends()).andReturn(Arrays.asList(new String[]{ "Ann" }));
		expect(ann.getFriends()).andReturn(Arrays.asList(new String[]{ "Bill" }));
		
		replay(friends);
		replay(joe);
		replay(ann);		
		
		assertThat(friendships.areFriends("Ann", "Joe")).isFalse();
	}
	
}
