import java.util.ArrayList;
import java.util.List;


public class LshTable {
	private int bucketCount;
	private List<Image>[] ht;
	private double[] standardVector;
	
	public LshTable(int size, int[] vector) {
		bucketCount = size;
		ht = new ArrayList[bucketCount];
		setStandardVector(vector);
		
	}
	
	public static double[] makeUnitVector(int[] v) {
		double powSum = 0;
		for (int i = 0; i < v.length; i++) {
			powSum += Math.pow(v[i], 2);
		}
		double size = Math.sqrt(powSum);
		double unitVector[] = new double[v.length];
		for (int i = 0; i < v.length; i ++) {
			unitVector[i] = v[i]/size;
		}
		return unitVector;
	}
	
	// 0 < x <= 1
	private void setStandardVector(int[] v) {
		// TODO 단위 백타로 변경 필요
		standardVector = makeUnitVector(v);
	}
	
	// LSH
	public double hashing(double[] v){
		// (v 내적 standardVector)/v의 최대 크기
		if (v.length != standardVector.length) {
			//throw invalid vector length;
			return -1;
		}
		
		// 표준vector와의 내적
		double innerProduct = 0;
		for (int i = 0; i < v.length; i++) {
			innerProduct += v[i] * standardVector[i];
		}
		return (innerProduct / (1.0/bucketCount));
	}
	
	public int getSlotNumber(double[] v) {
		double value = hashing(v);
		return (int)Math.floor(value);
	}
	
	public void insert(Image im) {
		int slot = getSlotNumber(im.getVector());
		if (ht[slot] == null) {
			ht[slot] = new ArrayList<Image>();
		}
		ht[slot].add(im);
	}
	
	public List<Image> getImages(int slot) {
		if (ht[slot] == null) {
			ht[slot] = new ArrayList<Image>();
			return ht[slot];
		}
		
		return ht[slot];
	}
	
	public List<Image> getImages(double[] v) {
		int slot = getSlotNumber(v);
		return getImages(slot);
	}
}
