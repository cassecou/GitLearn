package learningJava;
class Gear{

	private int chainring, cog;
	Gear(int chainring, int cog){
		this.chainring = chainring;
		this.cog = cog;
	}

	double getRatio(){
		return (double)chainring/cog;
	}
	
}

public class GearDemo{
	public static void main(String args[]){
		Gear gear1 = new Gear(52, 11);
		Gear gear2 = new Gear(30, 27);
		System.out.println("Gear 1 ratio : " + gear1.getRatio());
		System.out.println("Gear 2 ratio : " + gear2.getRatio());
	}
}