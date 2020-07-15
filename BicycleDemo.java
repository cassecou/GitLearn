package learningJava;

class Part {
	private String name, description;
	private boolean needSpare;
	Part(String name, String description, boolean needSpare){
		this.name = name;
		this.description = description;
		this.needSpare = needSpare;
	}

	String getName() { return name; }
	String getDescription() { return description; }
	boolean needSpares() { return needSpare; }
}


class Parts {
	private Part parts[];
	Parts(Part parts[]){
		this.parts = parts;
	}

	protected void spares() {
		for(Part p: parts) {
			if(p.needSpares())
				System.out.println(p.getName() + " : " + p.getDescription());
		}
	}

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

public class BicycleDemo {
	public static void main(String args[]){
		Part chain = new Part("chain", "10-speed", true);
		Part roadTire = new Part("tire size", "23", true);
		Part tapeColor = new Part("tape color", "Red", true);

		Part mountainTire = new Part("tire size", "2.1", true);
		Part frontShock = new Part("front shock", "Manitou", false);
		Part rearShock = new Part("rear shock", "Fox", true);

		Bicycle roadBike = new Bicycle( 'M', new Parts(new Part[] {chain, roadTire, tapeColor}));
		System.out.println("*** Road bike ***");
		System.out.println("Cycle size : " + roadBike.getCycleSize());
		roadBike.spares();

		Bicycle mountainBike = new Bicycle( 'S', new Parts( new Part[] {chain, mountainTire, frontShock, rearShock}));
		System.out.println("*** Mountain bike ***");
		System.out.println("Cycle size : " + mountainBike.getCycleSize());
		mountainBike.spares();

	}
}


