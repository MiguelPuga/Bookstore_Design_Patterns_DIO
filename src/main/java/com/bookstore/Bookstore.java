package com.bookstore;

import com.bookstore.strategy.IShowList;

import java.math.BigDecimal;
import java.util.*;

public class Bookstore {

    //region Singleton

    private static class instanceHolder {
        public static Bookstore instance = new Bookstore();
    }

    private Bookstore(){}

    public static Bookstore getInstance()
    {
        return instanceHolder.instance;
    }

    //endregion

    private int id_counter = 0;

    private String name;
    private double cash;
    private Map<Integer, Book> books = new HashMap<>();
    private IShowList showList;

    private List<Book> currentList;


    public void changeShowListParameter(IShowList iShow){
        showList = iShow;
    }

    public void listBooks()
    {
        currentList = showList.show((HashMap<Integer, Book>) books);
    }

    public void listBooks(HashMap<Integer, Book> list)
    {
        currentList = showList.show(list);
    }

    public boolean searchByName(String input)
    {
        HashMap<Integer, Book> list = new HashMap<>();
        int i = 0;
        for (Map.Entry<Integer, Book> book: books.entrySet()) {
            int compare = input.compareTo(book.getValue().getName());
            if(compare < 3 && compare > -3)
            {
                list.put(i, book.getValue());
                i++;
            }
        }

        if(i == 0)
        {
            System.out.println("Nada foi encontrado.");
            return false;
        }else {
            listBooks(list);
            return true;
        }

    }

    public boolean searchByAuthor(String input)
    {

        HashMap<Integer, Book> list = new HashMap<>();

        int i = 0;
        for (Map.Entry<Integer, Book> book: books.entrySet()) {
            int compare = input.compareTo(book.getValue().getAuthor());
            if(compare < 3 && compare > -3)
            {
                list.put(i, book.getValue());
                i++;
            }
        }

        if(i == 0)
        {
            System.out.println("Nada foi encontrado.");
            return false;
        }else {
            listBooks(list);
            return true;
        }
    }

    public void addBook(Book book)
    {
        books.put(id_counter, book);
        book.setId(id_counter);
        id_counter++;
    }

    public Book returnBook(int index)
    {
        if(index < 0 || index >= currentList.size())
        {
            return null;
        }

        return currentList.get(index);
    }

    public void updateStocks()
    {
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Book> book: books.entrySet())
        {
            if(book.getValue().getStock() <= 0)
            {
                list.add(book.getValue().getId());
            }
        }

        for (int i: list) {
            books.remove(i);
        }

    }

    public void receivePayment(double value)
    {
        cash += value;
    }

}
