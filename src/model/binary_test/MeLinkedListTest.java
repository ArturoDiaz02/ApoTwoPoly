package binary_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import data_structure.MeLinkedLists;
import javafx.scene.image.ImageView;
import objects.Player;


public class MeLinkedListTest {
	
	private MeLinkedLists<Player> list;
	private ArrayList<Player> array;
	private Player player;

	@Test
	public void test() {
		
		array = new ArrayList<>();
		list = new MeLinkedLists<>();
		
		for(int i = 0; i < 1000; i++) {
			player = new Player(new ImageView());
			
			list.add(player);
			array.add(player);
			
			assertEquals(player, list.get(i));
			assertEquals(i, list.indexOf(player));
			assertEquals(array.get(i), list.toArray().get(i));
			
		}
		
		int size = list.size();
		
		for(int i = 0; i < 1000; i++) {
	
			list.remove(0);
			size -= 1;
			
			assertEquals(size, list.size());
			
			if(i == 999) {
				assertEquals(null, list.getHead());
				
			}else {
				assertNotEquals(null, list.get(0));
				
			}
			
			
		}
		
        
	}

}
