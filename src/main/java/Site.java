import com.bookstore.Book;
import com.bookstore.Bookstore;
import com.bookstore.strategy.IShowList;
import com.bookstore.strategy.ShowByAuthor;
import com.bookstore.strategy.ShowByName;

import java.util.ArrayList;
import java.util.List;

public class Site {

    public List<Book> kart = new ArrayList<>();
    private double total;

    public void showList(Bookstore bookstore, IShowList iShow)
    {
        bookstore.changeShowListParameter(iShow);
        bookstore.listBooks();
    }

    public boolean searchByName(Bookstore bookstore, String input)
    {
        bookstore.changeShowListParameter(new ShowByName());
        return bookstore.searchByName(input);
    }

    public boolean searchByAuthor(Bookstore bookstore, String input)
    {
        bookstore.changeShowListParameter(new ShowByAuthor());
        return bookstore.searchByAuthor(input);
    }

    public Book returnBook(Bookstore bookstore, int index)
    {
        return bookstore.returnBook(index - 1);
    }

    public boolean addToKart(Book book)
    {
        if(book.getStock() == 0)
        {
            return false;
        }
        kart.add(book);
        book.setStock(book.getStock() - 1);
        return true;
    }

    public void showKart()
    {
        for (Book book : kart) {
            System.out.println("Nome: " + book.getName() + ", Preço: " + book.getPrice());
        }
    }

    public void calculateTotalValue()
    {
        for (Book book : kart) {
            total += book.getPrice();
        }
    }

    public void cleaningKart()
    {
        for (Book book : kart) {
            book.setStock(book.getStock() + 1);
        }
        total = 0;
        kart.clear();
    }

    public void buying(Bookstore bookstore)
    {
        bookstore.updateStocks();
        bookstore.receivePayment(total);
        kart.clear();
        total = 0;
    }

    public double getTotal() {
        return total;
    }
}
