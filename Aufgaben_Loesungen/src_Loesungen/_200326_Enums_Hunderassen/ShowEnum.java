package _200326_Enums_Hunderassen;

public class ShowEnum {

	public static void main(String[] args) {
		System.out.println("Dackel, max. Größe: " + Hunderasse.DACKEL.getMaxGroesse());
		System.out.println("Collie, max. Größe: " + Hunderasse.COLLIE.getMaxGroesse());
		System.out.println("Dogge,  max. Größe: " + Hunderasse.DOGGE.getMaxGroesse());
	}

}
