package example03.associations;

import c.hb.eg.config.BaseDao;

public class TestCompositeIdAssociations {
    public static void main(String[] args) {
        Author author = new Author("Bikram K. Kundu");
        Book book = new Book("Zero to Hero in JPA", author);

        BaseDao dao = new BaseDao();
        dao.save(author);
        dao.save(book);

        Book book1 = dao.find(Book.class, new Book(book.getTitle(), author));
        System.out.println(book1);
    }
}
