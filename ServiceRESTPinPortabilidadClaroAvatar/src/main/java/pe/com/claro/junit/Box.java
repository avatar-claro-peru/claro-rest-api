package pe.com.claro.junit;

public class Box {
	
	int x;
	int y;
	
	public Box(int theX,int theY){
		x=theX;
		y=theY;
	}
	
	public int getArea() {
		return x*y;
	}

	public static void main(String[] args) {
			Box box = new Box(10,15);
			System.out.println("area: " +box.getArea());
	}

}
