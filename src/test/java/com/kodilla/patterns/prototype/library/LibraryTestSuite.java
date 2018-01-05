package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LibraryTestSuite {
    @Test
    public void testGetBooksBeforeCloning() {
        //Given
        Set<Book> booksInManhattan = new HashSet<>();
        booksInManhattan.add(new Book("Don Quixote", "Miguel de Cervantes", LocalDate.ofYearDay(1605, 1)));
        booksInManhattan.add(new Book("A Tale of Two Cities", "Charles Dickens", LocalDate.ofYearDay(1859, 1)));
        booksInManhattan.add(new Book("The Little Prince", "Antoine de Saint-Exupéry", LocalDate.ofYearDay(1943, 1)));
        booksInManhattan.add(new Book("The Hobbit", "J. R. R. Tolkien", LocalDate.ofYearDay(1937, 1)));
        booksInManhattan.add(new Book("The Catcher in the Rye", "	J. D. Salinger", LocalDate.ofYearDay(1951, 1)));
        booksInManhattan.add(new Book("The Hite Report", "Shere Hite", LocalDate.ofYearDay(1976, 1)));
        booksInManhattan.add(new Book("Angels & Demons", "Dan Brown", LocalDate.ofYearDay(2000, 1)));
        booksInManhattan.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", LocalDate.ofYearDay(2005, 1)));
        booksInManhattan.add(new Book("The Girl on the Train", "Paula Hawkins", LocalDate.ofYearDay(2015, 1)));

        Library manhattanLibrary = new Library("Manhattan");
        manhattanLibrary.books = booksInManhattan;

        //When
        String libraryName = manhattanLibrary.getName();
        Set<Book> bookSet = manhattanLibrary.getBooks();


        //Then
        Assert.assertEquals("Manhattan", libraryName);
        Assert.assertEquals(9, bookSet.size());
    }

    @Test
    public void testGetBooksAfterCloning() {
        //Given
        Set<Book> booksInManhattan = new HashSet<>();
        Book donQuixote = new Book("Don Quixote", "Miguel de Cervantes", LocalDate.ofYearDay(1605, 1));
        booksInManhattan.add(donQuixote);
        booksInManhattan.add(new Book("A Tale of Two Cities", "Charles Dickens", LocalDate.ofYearDay(1859, 1)));
        booksInManhattan.add(new Book("The Little Prince", "Antoine de Saint-Exupéry", LocalDate.ofYearDay(1943, 1)));
        booksInManhattan.add(new Book("The Hobbit", "J. R. R. Tolkien", LocalDate.ofYearDay(1937, 1)));
        booksInManhattan.add(new Book("The Catcher in the Rye", "	J. D. Salinger", LocalDate.ofYearDay(1951, 1)));
        booksInManhattan.add(new Book("The Hite Report", "Shere Hite", LocalDate.ofYearDay(1976, 1)));
        booksInManhattan.add(new Book("Angels & Demons", "Dan Brown", LocalDate.ofYearDay(2000, 1)));
        booksInManhattan.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", LocalDate.ofYearDay(2005, 1)));
        booksInManhattan.add(new Book("The Girl on the Train", "Paula Hawkins", LocalDate.ofYearDay(2015, 1)));

        Library library = new Library("Manhattan");
        library.books = booksInManhattan;

        //making a shallow copy of object manhattanLibrary
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Under the tortoise");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object manhattanLibrary
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Bookworm");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(donQuixote);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(8, library.getBooks().size());
        Assert.assertEquals(8, clonedLibrary.getBooks().size());
        Assert.assertEquals(9, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
        Assert.assertFalse(deepClonedLibrary.getBooks().size() == library.getBooks().size());
        Assert.assertTrue(clonedLibrary.getBooks().size() == library.getBooks().size());


    }
}
