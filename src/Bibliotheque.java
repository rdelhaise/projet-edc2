import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bibliotheque implements InterfaceBook  {

	private ArrayList<Book> books;
	private ArrayList<BookBorrowed> booksBorrowed;
	private static Bibliotheque instance;
	
	private  Bibliotheque() {
		// TODO Auto-generated constructor stub
		//initialisation de l'arraylist
		this.books = new ArrayList<>();
		this.booksBorrowed = new ArrayList<>();
	}
	
	public static Bibliotheque getInstance() {
		if(Bibliotheque.instance == null) {
			instance = new Bibliotheque();
		}
		return instance;
	}
	
	
	@Override
	public Book getBook(String id) {
		// TODO Auto-generated method stub
		if(this.books.size() == 0)
			return null;
		else
		{
			//pour chaque livre existant dans la bibliotheque
			for(Book book : books)
			{
				//on vérifie si son identifiant correspond à l'id
				if(book.getId().equalsIgnoreCase(id))
				{
					//si c'est le cas on retourne le livre
					return book;
				}
			}
			//si on parcourt tous les livres et qu'aucun ne correspond, on retourne null
			return null;
		}
		
	}
	
	public boolean existeDeja(Book bk) {
		
		boolean i=false;
		//pour chaque livre existant dans la bibliothèque
				for(Book book : books)
				{
					//on vérifie si son identifiant correspond à l'id
					if(book.getIsbn().equalsIgnoreCase(bk.getIsbn()))
					{
						//si c'est le cas on retourne le livre
						i=true;
						//on arrete la boucle
						break;
					}		
					
				}
				
				return i;
	}

	@Override
	public String addBook(String isbn) {
		//On initialise la variable à retourner au cas ou on trouve pas l'isbn
		String id=null;
		Auteur a = new Auteur("BACHABI","Bassam");
		Book book = new Book("2", isbn, "Romance", "Titanic",a, 1994);
		
		//On fait un test sur la valeur retouné par la fonction existeDeja
		//Si elle retourne false, on affiche l'id du livre sinon on ajoute le livre et on retourne un méssage
		if(existeDeja(book)) {
			id=book.getId();
		}else {
			
			id="Le livre a été bien ajouté";
		}		
		this.books.add(book);
		return id;
	}
	
	public String addBookWithBook(Book bk) {
		//On initialise la variable à retourner au cas ou on trouve pas l'isbn
		String id=null;
		
		//On fait un test sur la valeur retouné par la fonction existeDeja
		//Si elle retourne false, on affiche l'id du livre sinon on ajoute le livre et on retourne un méssage
		if(existeDeja(bk)) {
			id=bk.getId();
		}else {
			
			id="Le livre a été bien ajouté";
		}		
		this.books.add(bk);
		return id;
	}

	@Override
	public void borrowBook(String id, String username) throws BookNotFoundException, UnavailableBookException {
		// TODO Auto-generated method stub
		
		boolean process = false;
		boolean found = false;
	
		for(int i=0; i < this.books.size(); i++)
		{
			//si l'élément courant correspond 																		
			if(this.books.get(i).getId().equalsIgnoreCase(id))
			{	
				//on précise dans cette variable qu'on a un élément avec le méme id
				found = true;
				
				//on vérifie si il est disponible
				Book b = this.books.get(i);
				
				if(!b.isBorrowed())
				{
					//si c'est le cas, alors on emprunte le livre � l'utilisateur
					b.setBorrowed(true);
					
					//on pr�cise dans cette variable que l'�l�ment trouv� ayant le m�me id a �t� trait�
					process = true;
					
					//et on sauvegarde cet emprunt
					this.booksBorrowed.add(new BookBorrowed(b, username));
					break;
				}
			}
		}
		//Si rien n'a �t� trouv�
		if(!found) 
			throw new BookNotFoundException(); //On d�clenche cette exception
		else //si quelque chose a �t� trouv�
			if(!process) //mais qu'il n'a pas �t� trait�, c'est qu'il est indisponible parce qu'il a d�ja �t� pr�t�.
				throw new UnavailableBookException();
	}

	@Override
	public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
		// TODO Auto-generated method stub
		boolean process = false;
		boolean found = false;
	
		for(int i=0; i < this.books.size(); i++)
		{
			//si l'�l�ment courant correspond 																		
			if(this.books.get(i).getId().equalsIgnoreCase(id))
			{
				found = true;
				
				//on v�rifie si il est effectivement emprunt�
				Book b = this.books.get(i);
				
				if(b.isBorrowed())
				{
					//si c'est le cas, alors on v�rifie si il a bien �t� emprunt� par l'utilisateur
					for(BookBorrowed bb : this.booksBorrowed)
					{
						if(bb.getBook().isEqualTo(b) && bb.getUsername().equalsIgnoreCase(username)) 
						{
							//on v�rifie qu'il est aussi bien emprunt�
							if(bb.getBook().isBorrowed())
							{
								//dans ce cas on le d�semprunte
								b.setBorrowed(false);
								bb.getBook().setBorrowed(false);
								process=true;
								break;	
							}
							//Sinon on a trouv� son livre mais il n'est pas emprunt� donc on d�clenchera une exception si il ne trouve pas le livre parmi les �l�ments suivants
						}
					}					
				}
				else
				{
					throw new AllBooksAlreadyReturnedException();
				}
			}
		}
		
		if(!found) throw new BookNotFoundException();
		else
			if(!process) //si les livres ont �t� trouv� mais pas trait� (parce qu'ils n'�taient pas emprunt�s)
				throw new AllBooksAlreadyReturnedException();							

	}

	@Override
	public ArrayList<Book> getBooks() {
		// TODO Auto-generated method stub
		return this.books;
	}
	
	public ArrayList<BookBorrowed> getBooksBorrowed() {
		// TODO Auto-generated method stub
		return this.booksBorrowed;
	}

	@Override
	public ArrayList<Book> searchBooks(String searchTerm) {
		// TODO Auto-generated method stub
		ArrayList<Book> results=new ArrayList<>();
		for(Book b : this.books)
		{
			if(b.getTitre().equalsIgnoreCase(searchTerm) || b.getIsbn().equalsIgnoreCase(searchTerm))
				results.add(b);
		}
		return results;
	}

}
