package com.bookstore.strategy;

import java.util.*;

import com.bookstore.Book;

public class ShowByName implements IShowList{

    @Override
    public List<Book> show(HashMap<Integer, Book> map) {

        Set<Book>  set = new TreeSet<>(new ShowByName.ComparatorByName());
        set.addAll(map.values());

        List<Book> list = new ArrayList<>();

        int i = 1;
        for (Book book : set) {
            System.out.println(i + " - Nome: " + book.getName() + ", Autor: "
                    + book.getAuthor() + ", Páginas: " + book.getPages() +
                    ", Preço: " + book.getPrice() + "R$, Estoque: " + book.getStock());
            i++;
            list.add(book);
        }

        return list;
    }

    public class ComparatorByName implements Comparator<Book> {

        @Override
        public int compare(Book b1, Book b2) {

            return b1.getName().compareTo(b2.getName());
        }
    }

}
