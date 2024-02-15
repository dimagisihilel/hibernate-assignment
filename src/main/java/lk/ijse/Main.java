package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.Year;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Author dimagi = new Author("1", "Dimagi","LK", null);
        Author ashani = new Author("2", "Ashani","China", null);
        Author senumi = new Author("3", "Senumi","India", null);
        Author janani = new Author("4", "Janani", "USA", null);

        Book book1 = new Book("1", "Book 1", 2005, 1000.0, dimagi);
        Book book2 = new Book("2", "Book 2", 2010, 2000.0, dimagi);
        Book book3 = new Book("3", "Book 3", 2015, 3000.0, ashani);
        Book book4 = new Book("4", "Book 4", 2020, 4000.0, senumi);
        Book book5 = new Book("5", "Book 5", 2025, 5000.0, janani);

        List<Book> list = List.of(book1, book2);

        dimagi.setBooks(list);
        ashani.setBooks(List.of(book3));
        senumi.setBooks(List.of(book4));
        janani.setBooks(List.of(book5));

        session.save(dimagi);
        session.save(ashani);
        session.save(senumi);
        session.save(janani);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);*/


        // Question 01

        /*Query query = session.createQuery("select title from Book where publicationYear >= 2010");
        List resultList = query.getResultList();

        System.out.println(resultList.toString());;*/


        // Question 02

        /*Query query = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
        query.setParameter("authorId", 1);

        int result = query.executeUpdate();
        System.out.println("Result: " + result);*/


        //03 wada krnne na
        /*deleteAuthor(session,"3");*/


        // Question 04

       /* Query query = session.createQuery("SELECT AVG(b.price) FROM Book b");
        Double averagePrice = (Double) query.getSingleResult();;
        System.out.println(averagePrice);*/


        // Question 05

       /* Query query = session.createQuery("SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b on a.id = b.author.id GROUP BY a.id");
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " : " + objects[1]);
        }*/


        // Question 06

        /*Query query = session.createQuery("SELECT b.title FROM Book b JOIN Author a on b.author.id = a.id WHERE a.country = :countryName");
        query.setParameter("countryName", "japan");
        List resultList = query.getResultList();

        for (Object o : resultList) {
            System.out.println(o);
        }*/


        // Question 07

        //have to do


        // Qustion 10

       /* Query query = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount FROM Book b GROUP BY b.author.id ))");
        List<String> resultList = query.getResultList();

        for (String s : resultList) {
            System.out.println(s);
        }*/



        transaction.commit();
        session.close();

    }

    private static void deleteAuthor(Session session, String id) {

        Author author = session.get(Author.class, id);

        Query query = session.createQuery("delete from Author a where a.id = :authorId");
        query.setParameter("authorId", author.getId());

        int result = query.executeUpdate();
        System.out.println(result);

    }
}
