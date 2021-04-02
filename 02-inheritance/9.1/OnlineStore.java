class ItemForSale
{
    String itemName;
    Author author;
    int cost;

    public ItemForSale(String itemName, String authorName, int age, int cost) {
        this.itemName = itemName;
        this.author = new Author(authorName, age);
        this.cost = cost;
    }

}

class Movie extends ItemForSale
{
    String genre;
    int ageRating;

    public Movie(String genre, int ageRating, String movieName, String authorName, int age, int cost) {
        super(movieName, authorName, age, cost);
        this.genre = genre;
        this.ageRating = ageRating;
    }
}

class Book extends ItemForSale
{
    int totalWords;
    int GradeLevel;

    public Book(int totalWords, int GradeLevel, String bookName, String authorName, int age, int cost) {
        super(bookName, authorName, age, cost);
        this.totalWords = totalWords;
        this.GradeLevel = GradeLevel;
    }
}

class Author
{
    String authorName;
    int age;

    public Author(String authorName, int age) {
        this.authorName = authorName;
        this.age = age;
    }
}

public class OnlineStore
{
    public static void main(String[] args)
    {
        Book book = new Book(1, 1, "test", "a_name", 1, 1);
        System.out.println(book instanceof ItemForSale);
    }
}