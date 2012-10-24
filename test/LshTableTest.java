import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class LshTableTest {
	int maxSlot;
	int standardVector[] = {1, 0};
	LshTable lsh;
	
	@Before
	public void setUpLshTable() {
		maxSlot = 256;
		lsh = new LshTable(maxSlot, standardVector);
	}

	@Test
	public void testMakeUnitVector() {
		int[] vector = {1, 0};
		double[] unitVector = LshTable.makeUnitVector(vector);
		assertEquals(1, (int)unitVector[0]);
		assertEquals(0, (int)unitVector[1]);
		
		int[] vector2 = {1, 1};
		double[] unitVector2 = LshTable.makeUnitVector(vector2);
		assertEquals(0.707, unitVector2[0], 0.001);
		assertEquals(0.707, unitVector2[1], 0.001);
	}
	
	@Test
	public void testHashing() {
		double vector[] = {0.707, 0.707};
		assertEquals(0.707 * maxSlot, lsh.hashing(vector), 0.001);
	}
	
	@Test
	public void testInsert() {
		double v[] = {0.707, 0.707};
		int slot = lsh.getSlotNumber(v);
		List images = lsh.getImages(slot);
		assertEquals(0, images.size());
		
		Image im2 = new Image(2);
		im2.setVector(v);
		lsh.insert(im2);
		
		slot = lsh.getSlotNumber(v);
		images = lsh.getImages(slot);
		assertEquals(1, images.size());
		
		Image im4 = new Image(4);
		im4.setVector(v);
		lsh.insert(im4);
		
		slot = lsh.getSlotNumber(v);
		images = lsh.getImages(slot);
		assertEquals(2, images.size());
	}
	
	@Test
	public void testGetImages() {
		double v[] = {0.707, 0.707};
		
		Image im2 = new Image(2);
		im2.setVector(v);
		lsh.insert(im2);
		
		List<Image> Images = lsh.getImages(v);
		
		assertEquals(im2, Images.get(0));
	}

}
