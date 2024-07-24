
package com.servlet.login.loginservletexample.Controller;

import com.servlet.login.loginservletexample.DAO.BookDAO;
import com.servlet.login.loginservletexample.Model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpSession;

// Anota a classe para definir quais URLs este servlet irá tratar
@WebServlet({"/book", "/books", "/addBook", "/editBook", "/deleteBook"})
public class BookController extends HttpServlet {
    // Declaração do DAO de livros
    private BookDAO bookDAO;

    // Inicializa o DAO de livros quando o servlet é inicializado
    public void init() {
        bookDAO = new BookDAO();
    }

    // Método privado para verificar se o usuário está autenticado
    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Obtém a sessão atual, se existir
        return (session != null && session.getAttribute("user") != null); // Verifica se há um atributo "user" na sessão
    }

    // Método para tratar requisições POST (envio de dados)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath(); // Obtém a ação a ser executada com base na URL
        switch (action) {
            case "/addBook": {
                // Obtém os dados do novo livro do formulário
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                Double price = Double.parseDouble(request.getParameter("price"));

                // Cria um novo objeto Book e salva no banco de dados
                Book newBook = new Book(title, author, price);
                bookDAO.save(newBook); // Chama o método save do DAO
                System.out.println(newBook);
                response.sendRedirect("books"); // Redireciona para a lista de livros
                break;
            }

            case "/editBook": {
                // Obtém os dados do livro a ser editado do formulário
                Long id = Long.parseLong(request.getParameter("id"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                Double price = Double.parseDouble(request.getParameter("price"));

                // Cria um objeto Book atualizado e salva no banco de dados
                Book book = new Book(id, title, author, price);
                bookDAO.update(book); // Chama o método update do DAO
                response.sendRedirect("books"); // Redireciona para a lista de livros
                break;
            }
        }
    }

    // Método para tratar requisições GET (solicitação de dados)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath(); // Obtém a ação a ser executada com base na URL
        switch (action) {
            case "/books": {
                // Obtém a lista de todos os livros e encaminha para a página JSP
                List<Book> books = bookDAO.findAll(); // Chama o método findAll do DAO
                if (books != null) {
                    request.setAttribute("books", books); // Define a lista de livros como atributo da requisição
                    request.getRequestDispatcher("listBooks.jsp").forward(request, response); // Encaminha para a página JSP
                } else {
                    System.out.println("No books found");
                    request.setAttribute("message", "No books found");
                    request.getRequestDispatcher("listBooks.jsp").forward(request, response);
                }
                break;
            }

            case "/deleteBook": {
                // Deleta um livro pelo ID
                Long id = Long.parseLong(request.getParameter("id"));
                Book book = bookDAO.findById(id.intValue()); // Encontra o livro pelo ID
                bookDAO.delete(book); // Chama o método delete do DAO
                response.sendRedirect("books"); // Redireciona para a lista de livros
                break;
            }

            case "/editBook": {
                // Encaminha para a página de edição de livro
                Long id = Long.parseLong(request.getParameter("id"));
                Book book = bookDAO.findById(id.intValue()); // Encontra o livro pelo ID
                request.setAttribute("book", book); // Define o livro como atributo da requisição
                request.getRequestDispatcher("editBook.jsp").forward(request, response); // Encaminha para a página JSP
                break;
            }
        }
    }
}
