package khoalb.ntu.qlsach;

public class Book {
    int  BookID;
    String BookName;
    int Page;
    float Price;
    String Description;

    public Book() {
    }

    public Book(int idSach, String tenSach, int soTrang, float gia, String mota) {
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
