import java.util.List;

import org.junit.Test;


public class LshTablesTest {

	@Test
	public void testSearchImage() {
		int[][] vectors = {{1, 0}, {0, 1}};
		LshTables lshTables = new LshTables(vectors);
		
		double v[] = {1, 0};
		Image im2 = new Image(2);
		im2.setVector(v);
		lshTables.insert(im2);
		
		List<Image> images = lshTables.search(im2);
	}
}
