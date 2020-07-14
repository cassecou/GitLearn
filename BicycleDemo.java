package learningJava;

class Bicycle {
	private char cycleSize;
	private String tapeColor;
	private static int chain = 10, tireSize = 23;

	Bicycle(char cycleSize, String tapeColor){
		this.cycleSize = cycleSize;
		this.tapeColor = tapeColor;
	}

	public char getCycleSize() {
		return cycleSize;
	}

	public void spares(){
		System.out.println("Chain : " + chain);
		System.out.println("Tire Size : " + tireSize);
		System.out.println("Tape color : " + tapeColor);
	}
}

public class BicycleDemo {
	public static void main(String args[]){
		Bicycle bike = new Bicycle('M', "Red");
		System.out.println("Cycle size : " + bike.getCycleSize());
		bike.spares();
	}
}