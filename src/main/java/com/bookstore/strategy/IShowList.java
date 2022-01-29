package com.bookstore.strategy;

import com.bookstore.Book;

import java.util.HashMap;
import java.util.List;

public interface IShowList {

    List<Book> show(HashMap<Integer, Book> map);

}
