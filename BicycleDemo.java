package learningJava;

abstract class Parts {
	private static int chain = 10;
	private double tireSize;

	Parts(double tireSize){
		this.tireSize = tireSize;
	}

	protected void spares(){
		System.out.println("Chain : " + chain);
		System.out.println("Tire Size : " + tireSize);
		this.localSpares();
	}

	abstract void localSpares();
}


class Bicycle {
	private char cycleSize;
	private Parts parts;

	Bicycle(char cycleSize,Parts parts){
		this.cycleSize = cycleSize;
		this.parts = parts;
	}


	public char getCycleSize() {
		return cycleSize;
	}

	protected void spares(){
		parts.spares();
	}

}

class RoadBikeParts extends Parts {
	private String tapeColor;
	RoadBikeParts(double tireSize, String tapeColor) {
		super(tireSize);
		this.tapeColor = tapeColor;
	}

	RoadBikeParts(String tapeColor) {
		super(23);
		this.tapeColor = tapeColor;
	}

	public void localSpares() {
		//super.spares();
		System.out.println("Tape color : " + tapeColor);
	}
}

class MountainBikeParts extends Parts {
	private String frontShock, rearShock;
	MountainBikeParts(double tireSize, String frontShock, String rearShock) {
		super(tireSize);
		this.frontShock = frontShock;
		this.rearShock = rearShock;
	}

	MountainBikeParts(String frontShock, String rearShock) {
		super(2.1);
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
		Bicycle roadBike = new Bicycle( 'M', new RoadBikeParts("Red"));
		System.out.println("*** Road bike ***");
		System.out.println("Cycle size : " + roadBike.getCycleSize());
		roadBike.spares();

		Bicycle mountainBike = new Bicycle( 'S', new MountainBikeParts("Manitou", "Fox"));
		System.out.println("*** Mountain bike ***");
		System.out.println("Cycle size : " + mountainBike.getCycleSize());
		mountainBike.spares();

	}
}


