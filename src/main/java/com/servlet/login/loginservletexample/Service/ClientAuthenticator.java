package com.servlet.login.loginservletexample.Service;

import com.servlet.login.loginservletexample.DAO.ClientDAO;
import com.servlet.login.loginservletexample.Model.Client;

public class ClientAuthenticator {
    private ClientDAO clientDAO;

    public ClientAuthenticator() {
        this.clientDAO = new ClientDAO();
    }

    // Método para autenticar um cliente com base no email e senha
    public Client authenticate(String email, String password) {
        Client client = clientDAO.findByEmail(email);
        System.out.println(client);
        if (client != null && client.getPassword().equals(password)) {
            return client;
        }
        return null;
    }
}
