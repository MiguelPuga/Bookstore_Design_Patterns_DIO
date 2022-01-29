import com.bookstore.Book;
import com.bookstore.Bookstore;
import com.bookstore.strategy.ShowByAuthor;
import com.bookstore.strategy.ShowByName;
import com.bookstore.strategy.ShowByPrice;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bookstore bookstore = Bookstore.getInstance();

        //region instanciando Livros

        bookstore.addBook(new Book("Harry Potter e a Pedra Filosofal", "J.K. Rowling",
                263, 40.99, 2));
        bookstore.addBook(new Book("Harry Potter e a Câmara Secreta", "J.K. Rowling",
                287, 45.99, 3));
        bookstore.addBook(new Book("Harry Potter e o Prisioneiro de Azkaban", "J.K. Rowling",
                318, 50.99, 3));
        bookstore.addBook(new Book("Harry Potter e o Cálice de Fogo", "J.K. Rowling",
                535, 50.99, 3));
        bookstore.addBook(new Book("Harry Potter e a Ordem da Fenix", "J.K. Rowling",
                703, 60.99, 1));
        bookstore.addBook(new Book("Harry Potter e o Enigma do Príncipe", "J.K. Rowling",
                471, 50.99, 3));
        bookstore.addBook(new Book("Harry Potter e as Relíquias da Morte", "J.K. Rowling",
                551, 40.99, 3));

        bookstore.addBook(new Book("Percy Jackson: o Ladrão de Raios", "Rick Riordan",
                387, 45.99, 2));
        bookstore.addBook(new Book("Percy Jackson: o Mar de Monstros", "Rick Riordan",
                286, 40.99, 3));
        bookstore.addBook(new Book("Percy Jackson: a Maldição do Titã", "Rick Riordan",
                316, 45.99, 5));
        bookstore.addBook(new Book("Percy Jackson: a Batalha do Labirinto", "Rick Riordan",
                367, 50.99, 4));
        bookstore.addBook(new Book("Percy Jackson: o Último Olimpiano", "Rick Riordan",
                383, 35.99, 3));

        bookstore.addBook(new Book("O Guia do Mochileiro das Galáxias: Não Entre em Pânico", "Douglas Adams",
                208, 24.99, 1));
        bookstore.addBook(new Book("O Guia do Mochileiro das Galáxias: O Restaurante no Fim do Universo", "Douglas Adams",
                173, 24.99, 1));
        bookstore.addBook(new Book("O Guia do Mochileiro das Galáxias: A Vida, o Universo e Tudo Mais", "Douglas Adams",
                160, 29.99, 2));
        bookstore.addBook(new Book("O Guia do Mochileiro das Galáxias: Até mais e Obrigado pelos Peixes", "Douglas Adams",
                142, 29.99, 4));
        bookstore.addBook(new Book("O Guia do Mochileiro das Galáxias: Praticamente Inofensiva", "Douglas Adams",
                191, 19.99, 6));

        //endregion

        Site site = new Site();

        boolean running = true;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Bem vindo(a) a nossa livraria!");

        while (running)
        {
            System.out.println("Selecione o que você quer fazer, digitando o número das seguintes opções:");
            System.out.println("1 - Procurar um livro.");
            System.out.println("2 - Listar livros da nossa loja.");
            System.out.println("3 - Finalizar compra.");
            System.out.println("0 - Sair.");

            int input = scanner.nextInt();

            String inputTxt;

            switch (input) {
                case 1:
                    System.out.println("****************************************************" +
                            "*****************************************");
                    System.out.println("Você deseja pesquisar por:");
                    System.out.println("1 - Nome.");
                    System.out.println("2 - Autor.");

                    input = scanner.nextInt();

                    System.out.println("****************************************************" +
                            "*****************************************");

                    if(input == 1)
                    {
                        System.out.println("Digite o nome do Livro:");
                        inputTxt = scanner.next();
                        if(!site.searchByName(bookstore, inputTxt))
                        {
                            break;
                        }
                    }else if(input == 2)
                    {
                        System.out.println("Digite o nome do Autor:");
                        inputTxt = scanner.next();
                        if(!site.searchByAuthor(bookstore, inputTxt))
                        {
                            break;
                        }
                    }else
                    {
                        System.out.println("Não entendemos sua solicitação. Tente novamente.");
                    }

                    while (input != 0) {
                        System.out.println("****************************************************" +
                                "*****************************************");
                        System.out.println("Digite o número do Livro para adicioná-lo ao carrinho. Digite 0 para voltar ao menu.");
                        input = scanner.nextInt();
                        if(input != 0)
                        {
                            Book book = site.returnBook(bookstore, input);
                            if(book == null)
                            {
                                System.out.println("Esse livro não existe na lista.");
                            }else
                            {
                                if(site.addToKart(book)) {
                                    System.out.println("'" + book.getName() + "' foi adicionado ao seu carrinho com sucesso!");
                                }else
                                {
                                    System.out.println("Este livro ficou sem estoque!");
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("****************************************************" +
                            "*****************************************");
                    System.out.println("Você deseja pesquisar por:");
                    System.out.println("1 - Nome.");
                    System.out.println("2 - Autor.");
                    System.out.println("3 - Preço.");

                    input = scanner.nextInt();

                    System.out.println("****************************************************" +
                            "*****************************************");

                    if(input == 1)
                    {

                        site.showList(bookstore, new ShowByName());
                    }else if(input == 2)
                    {
                        site.showList(bookstore, new ShowByAuthor());
                    }else if(input == 3)
                    {
                        site.showList(bookstore, new ShowByPrice());
                    }else
                    {
                        System.out.println("Não entendemos sua solicitação. Tente novamente.");
                    }

                    while (input != 0) {
                        System.out.println("****************************************************" +
                                "*****************************************");

                        System.out.println("Digite o número do Livro para adicioná-lo ao carrinho. Digite 0 para voltar ao menu.");
                        input = scanner.nextInt();
                        if(input != 0)
                        {
                            Book book = site.returnBook(bookstore, input);
                            if(book == null)
                            {
                                System.out.println("Esse livro não existe na lista.");
                            }else
                            {
                                if(site.addToKart(book)) {
                                    System.out.println("'" + book.getName() + "' foi adicionado ao seu carrinho com sucesso!");
                                }else
                                {
                                    System.out.println("Este livro ficou sem estoque!");
                                }
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("****************************************************" +
                            "*****************************************");
                    System.out.println("Estes são os livros no seu carrinho:");
                    site.showKart();
                    site.calculateTotalValue();

                    System.out.printf("Esse é o valor total: %.2fR$%n", site.getTotal());

                    while (input != 0) {

                        System.out.println("Digite 1 para concluir sua compra ou digite 2 para limpar o carrinho.");
                        System.out.println("Digite 0 pra voltar ao menu.");

                        input = scanner.nextInt();

                        if (input == 1)
                        {
                            site.buying(bookstore);
                            System.out.println("Sua compra foi finalizada! Nós da loja agradecemos!");
                            input = 0;
                        }else if(input == 2)
                        {
                            site.cleaningKart();
                            System.out.println("Seu carrinho foi limpo!");
                            input = 0;
                        }else
                        {
                            System.out.println("Não entendemos o comando, tente novamente.");
                        }

                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Não entendemos sua solicitação. Tente novamente.");
                    break;
            }
            System.out.println("****************************************************" +
                    "*****************************************");
        }


    }

}
