package com.bookstore.strategy;

import com.bookstore.Book;

import java.util.*;

public class ShowByAuthor implements IShowList{


    @Override
    public List<Book> show(HashMap<Integer, Book> map) {

        Set<Book>  set = new TreeSet<>(new ShowByAuthor.ComparatorByAuthor());
        set.addAll(map.values());

        List<Book> list = new ArrayList<>();

        int i = 1;
        for (Book book : set) {
            System.out.println(i + " - Autor: " + book.getAuthor() + ", Nome: "
                    + book.getName() + ", Páginas: " + book.getPages() +
                    ", Preço: " + book.getPrice() + "R$, Estoque: " + book.getStock());
            i++;
            list.add(book);
        }

        return list;
    }

    public class ComparatorByAuthor implements Comparator<Book> {

        @Override
        public int compare(Book b1, Book b2) {

            int i = b1.getAuthor().compareTo(b2.getAuthor());
            if(i != 0)
            {
                return i;
            }

            return b1.getName().compareTo(b2.getName());
        }
    }
}
