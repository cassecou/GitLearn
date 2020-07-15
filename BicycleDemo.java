package learningJava;

enum Config {ROAD, MOUNTAIN};

class PartsFactory {
	private String[][] configuration;

	public Parts build(Config config){
		switch(config) {
			case ROAD:{
				configuration = new String[][]{ 
					{"chain", "10-speed"},
					{"tire size", "23"},
					{"tape color", "Red"}
				};
				break;
			}

			case MOUNTAIN: {
				configuration = new String[][]{ 
					{"chain", "10-speed"},
					{"tire size", "2.1"},
					{"front shock", "Manitou", "false"},
					{"rear shock", "Fox"}
				};
				break;
			}
		}
		int n = configuration.length;
		Part[] parts = new Part[n];
		for(int i = 0; i < n; i++) {
			parts[i] = new Part(configuration[i][0], configuration[i][1], configuration[i].length==2 ? true : false);	
		}

		return new Parts(parts);
	}


}

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
		
		Bicycle roadBike = new Bicycle( 'M', new PartsFactory().build(Config.ROAD));
		System.out.println("*** Road bike ***");
		System.out.println("Cycle size : " + roadBike.getCycleSize());
		roadBike.spares();

		Bicycle mountainBike = new Bicycle( 'S', new PartsFactory().build(Config.MOUNTAIN));
		System.out.println("*** Mountain bike ***");
		System.out.println("Cycle size : " + mountainBike.getCycleSize());
		mountainBike.spares();

	}
}


