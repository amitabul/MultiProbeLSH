import java.util.Vector;


public class Image {
	private int id;
	
	//vector의 크기 최대값은 1
	private double[] vector;
	
	public Image(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setVector(double v[]) {
		vector = v;
	}
	
	public double[] getVector() {
		return vector;
	}
}
