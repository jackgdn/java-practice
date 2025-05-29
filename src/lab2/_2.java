package lab2;

import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        if (price < 10.0) {
            System.out.println("图书价钱较低，增为10元");
            price = 10.0;
        }
        this.price = price;
        this.show();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 10.0) {
            System.out.println("图书价钱较低，增为10元");
            price = 10.0;
        }
        this.price = price;
    }

    public void show() {
        System.out.println(String.format("%s,%.1f,%s,%s", this.author, this.price, this.title, this.publisher));
    }
}

public class _2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String title = line[0];
            String author = line[1];
            String publisher = line[2];
            double price = Double.parseDouble(line[3]);

            Book book = new Book(title, author, publisher, price);
        }
    }
}