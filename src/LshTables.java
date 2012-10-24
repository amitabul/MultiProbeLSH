import java.util.ArrayList;
import java.util.List;


public class LshTables {
	private LshTable[] tables;
	
	LshTables(int[][] vectors) {
		tables = new LshTable[vectors.length];
		for (int i = 0; i < vectors.length; i++) {
			tables[i] = new LshTable(256, vectors[i]);
		}
	}
	
	public void insert(Image image) {
		for (int i = 0; i < tables.length; i++) {
			tables[i].insert(image);
		}
	}
	
	public List<Image> search(Image image) {
		List<Image> images = new ArrayList<Image>();
		return images;
	}
}
