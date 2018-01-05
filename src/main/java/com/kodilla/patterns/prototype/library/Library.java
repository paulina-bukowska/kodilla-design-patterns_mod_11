package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }



    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    @Override
    public String toString() {
        return "Library" +
                " '" + name + '\'' +
                "\n" + books;
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.books = new HashSet<>();

        for(Book bookSet : books) {
            Book clonedSet = new Book(bookSet.getTitle(), bookSet.getAuthor(), bookSet.getPublicationDate());

            clonedLibrary.getBooks().add(clonedSet);
        }
        return clonedLibrary;
    }
}