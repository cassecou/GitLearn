package learningJava;

class Wheel {
	private double rim, tire;
	Wheel(double rim, double tire) {
		this.rim = rim;
		this.tire = tire;
	}
	double getDiameter(){
		return (rim + (tire*2));
	}
	double getCircumference() {
		return 3.14*this.getDiameter();
	}
}


class Gear{
	private int chainring, cog;
	private Wheel wheel;

	Gear(int chainring, int cog) {
		this.chainring = chainring;
		this.cog = cog;
	}

	Gear(int chainring, int cog, double rim, double tire){
		this.chainring = chainring;
		this.cog = cog;
		wheel = new Wheel(rim, tire);
	}

	Gear(int chainring, int cog, Wheel wheel){
		this.chainring = chainring;
		this.cog = cog;
		this.wheel = wheel;
	}

	public double getRatio(){
		return (double)chainring/cog;
	}

	public double getGearInches() {
		return this.getRatio()*wheel.getDiameter();
	}
}

public class GearDemo{
	public static void main(String args[]){
		Gear gear1 = new Gear(52, 11);
		Gear gear2 = new Gear(30, 27);
		System.out.println("Gear 1 ratio : " + gear1.getRatio());
		System.out.println("Gear 2 ratio : " + gear2.getRatio());

		System.out.println("\n****Compare gear inches now **** \n");

		Gear gear3 = new Gear(55, 11, 1, 1.5);
		Gear gear4 = new Gear(40, 20, 2, 2.5);
		System.out.println("            Gear 3 | Gear 4");
		System.out.println("_____________________________");
		System.out.println("Ratio        " + gear3.getRatio() + "   | " + gear4.getRatio());
		System.out.println("Gear Inches  " + gear3.getGearInches() + "  | " + gear4.getGearInches());

		Wheel wheel = new Wheel(26, 1.5);
		System.out.println("\nCircumference of the wheel = " + wheel.getCircumference());
		Gear gear5 = new Gear(40, 20, wheel);
		System.out.println("Ratio = " + gear5.getRatio()+ "  Gear inches = " + gear5.getGearInches());
	}
}
