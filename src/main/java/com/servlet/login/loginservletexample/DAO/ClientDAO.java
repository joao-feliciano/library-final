package com.servlet.login.loginservletexample.DAO;

import com.servlet.login.loginservletexample.Model.Client;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAO {
    // Obtém a SessionFactory configurada
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    // Método para encontrar todos os clientes no banco de dados
    public List<Client> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Client ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os clientes " + e.getMessage());
        }
    }

    // Método para salvar um cliente no banco de dados
    public void save(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo cliente " + e.getMessage());
        }
    }

    // Método para deletar um cliente do banco de dados
    public void delete(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar cliente " + e.getMessage());
        }
    }

    // Método para encontrar um cliente pelo ID
    public Client findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar cliente " + e.getMessage());
        }
    }

    // Método para atualizar um cliente no banco de dados
    public void update(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar cliente " + e.getMessage());
        }
    }

    // Método para encontrar um cliente pelo email
    public Client findByEmail(String email) {
        try (Session session = factory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE email = :email", Client.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding client by email: " + e.getMessage(), e);
        }
    }
}
