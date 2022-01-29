package com.bookstore.strategy;

import com.bookstore.Book;

import java.util.*;

public class ShowByPrice implements IShowList{

    @Override
    public List<Book> show(HashMap<Integer, Book> map) {

        Set<Book>  set = new TreeSet<>(new ComparatorByPrice());
        set.addAll(map.values());

        List<Book> list = new ArrayList<>();

        int i = 1;
        for (Book book : set) {
            System.out.println(i + " - Preço: " + book.getPrice() + "R$, Nome: "
                    + book.getName() + ", Autor: " + book.getAuthor() +
                    ", Páginas: " + book.getPages() + ", Estoque: " + book.getStock());
            i++;
            list.add(book);
        }

        return list;
    }

    public class ComparatorByPrice implements Comparator<Book> {

        @Override
        public int compare(Book b1, Book b2) {

            int i = Double.compare(b1.getPrice(), b2.getPrice());
            if(i != 0)
            {
                return i;
            }

            return b1.getName().compareTo(b2.getName());
        }
    }

}
