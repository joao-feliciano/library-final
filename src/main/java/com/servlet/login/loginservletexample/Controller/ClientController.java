package com.servlet.login.loginservletexample.Controller;

import com.servlet.login.loginservletexample.DAO.ClientDAO;
import com.servlet.login.loginservletexample.Model.Client;
import com.servlet.login.loginservletexample.Service.ClientAuthenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// Define as URLs que este servlet irá tratar
@WebServlet({"/teste", "/index", "/login", "/addNewClient", "/listAllClients", "/logout"})
public class ClientController extends HttpServlet {
    private ClientDAO clientDAO;

    // Inicializa o ClientDAO quando o servlet é inicializado
    public void init() {
        clientDAO = new ClientDAO();
    }

    // Método para tratar requisições POST (envio de dados)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        ClientAuthenticator authenticator = new ClientAuthenticator();
        Client client;

        switch (action) {
            case "/login": {
                // Autentica o usuário com base no email e senha fornecidos
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                Client authClient = authenticator.authenticate(email, password);
                if (authClient != null) {
                    // Se autenticado, define a sessão e encaminha para a página de boas-vindas
                    request.getSession().setAttribute("client", authClient);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                } else {
                    // Se falhar, encaminha para a página de falha de login
                    request.getSession().setAttribute("client", authClient);
                    request.getRequestDispatcher("loginFail.jsp").forward(request, response);
                }
                break;
            }
            case "/addNewClient": {
                // Adiciona um novo cliente
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                Client existingClient = clientDAO.findByEmail(email);
                if (existingClient != null) {
                    // Se o cliente já existe, encaminha para a página de falha de adição
                    request.setAttribute("client", new Client(name, email, password));
                    request.getRequestDispatcher("addFail.jsp").forward(request, response);
                } else {
                    // Caso contrário, salva o novo cliente no banco de dados
                    client = Client.builder().name(name).password(password).email(email).build();
                    clientDAO.save(client);
                    request.getSession().setAttribute("client", client);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }
                break;
            }
        }
    }

    // Método para tratar requisições GET (solicitação de dados)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/index":
                // Encaminha para a página index.jsp
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/listAllClients": {
                // Obtém a lista de todos os clientes e encaminha para a página JSP
                List<Client> clients = clientDAO.findAll();
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("listAllClients.jsp").forward(request, response);
                break;
            }
            case "/login":
                // Encaminha para a página de login
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "/logout": {
                // Invalida a sessão e encaminha para a página de login
                request.getSession().invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            }
        }
    }
}
