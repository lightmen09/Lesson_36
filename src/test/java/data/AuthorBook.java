package data;

public enum AuthorBook {
    SAPKOVSK("Анджей Сапковский", "Ведьмак"),
    KARRIZI("Донато Карризи", "Девушка в тумане");

    private final String author;
    private final String book;

    AuthorBook(String author, String book) {
        this.author = author;
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public String getBook() {
        return book;
    }
}
