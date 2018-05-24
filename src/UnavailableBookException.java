
public class UnavailableBookException extends Exception {

	public UnavailableBookException() {
		System.out.println("Tous les livres dans la bibliothèque avec l'ID donné ont été empruntés");
	
	}
}
