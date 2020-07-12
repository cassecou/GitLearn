package learningJava;
class Gear{
	private int chainring, cog;
	private Wheel wheel;
	
	class Wheel {
		private double rim, tire;
		Wheel(double rim, double tire) {
			this.rim = rim;
			this.tire = tire;
		}
		double getDiameter(){
			return (rim + (tire*2));
		}
	}

	Gear(int chainring, int cog) {
		this.chainring = chainring;
		this.cog = cog;
	}

	Gear(int chainring, int cog, double rim, double tire){
		this.chainring = chainring;
		this.cog = cog;
		wheel = new Wheel(rim, tire);
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
	}
}
