package learningJava;

abstract class Bicycle {
	private char cycleSize;
	private static int chain = 10;
	private double tireSize;

	Bicycle(char cycleSize, double tireSize){
		this.cycleSize = cycleSize;
		this.tireSize = tireSize;
	}

	Bicycle(){
		this.cycleSize = 'S';
		this.tireSize = 2.5;
	}

	public char getCycleSize() {
		return cycleSize;
	}

	protected void spares(){
		System.out.println("Chain : " + chain);
		System.out.println("Tire Size : " + tireSize);
		this.localSpares();
	}

	abstract void localSpares();

}

class RoadBike extends Bicycle {
	private String tapeColor;
	RoadBike(char cycleSize, double tireSize, String tapeColor) {
		super(cycleSize, tireSize);
		this.tapeColor = tapeColor;
	}

	RoadBike(char cycleSize, String tapeColor) {
		super(cycleSize, 23);
		this.tapeColor = tapeColor;
	}

	public void localSpares() {
		//super.spares();
		System.out.println("Tape color : " + tapeColor);
	}
}

class MountainBike extends Bicycle {
	private String frontShock, rearShock;
	MountainBike(char cycleSize, double tireSize, String frontShock, String rearShock) {
		super(cycleSize, tireSize);
		this.frontShock = frontShock;
		this.rearShock = rearShock;
	}

	MountainBike(char cycleSize, String frontShock, String rearShock) {
		super(cycleSize, 2.1);
		this.frontShock = frontShock;
		this.rearShock = rearShock;
	}

	public void localSpares() {
		//super.spares();
		System.out.println("Rear-shock : " + rearShock);
	}
}


public class BicycleDemo {
	public static void main(String args[]){
		RoadBike bike1 = new RoadBike('M', "Red");
		System.out.println("*** Road bike ***");
		System.out.println("Cycle size : " + bike1.getCycleSize());
		bike1.spares();

		MountainBike bike2 = new MountainBike('S', "Manitou", "Fox");
		System.out.println("*** Mountain bike ***");
		System.out.println("Cycle size : " + bike2.getCycleSize());
		bike2.spares();

	}
}
