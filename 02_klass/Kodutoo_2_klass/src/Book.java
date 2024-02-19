public class Book {
    public Book(String name, int id, int pages, String author, String location, int amount) {
        this.name = name;
        this.id = id;
        this.pages = pages;
        this.author = author;
        this.location = location;
        this.amount = amount;
    }

    public int loanBook(int amount){
        if (amount > 0) {
            return amount - 1;
        } else {
            System.out.println("Raamatud otsas");
            return amount;
        }
    }
    String name; 
    int id;
    int pages; 
    String author; 
    String location; 
    int amount;
}