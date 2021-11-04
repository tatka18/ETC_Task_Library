package by.epamtc.library.model;

public class Book {
    private long id;
    private String bookName;
    private String author;
    private int yearOfPublishing;
    private String category;

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (bookName == null) {
            if (book.bookName != null) return false;
        } else if (!bookName.equals(book.bookName)) return false;
        if (bookName == null) {
            if (book.author != null) return false;
        } else if (!author.equals(book.author)) return false;
        if (category == null) {
            if (book.category != null) return false;
        } else if (!category.equals(book.category)) return false;
        return id == book.id && yearOfPublishing == book.yearOfPublishing;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + yearOfPublishing;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", category='" + category + '\'' +
                '}';
    }
}
