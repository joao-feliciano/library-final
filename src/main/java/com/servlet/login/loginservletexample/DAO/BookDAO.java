package com.servlet.login.loginservletexample.DAO;

import com.servlet.login.loginservletexample.Model.Book;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAO {
    // Obtém a SessionFactory configurada
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    // Método para encontrar todos os livros no banco de dados
    public List<Book> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Book ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os livros " + e.getMessage());
        }
    }

    // Método para salvar um livro no banco de dados
    public void save(Book book) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo livro " + e.getMessage());
        }
    }

    // Método para deletar um livro do banco de dados
    public void delete(Book book) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar livro " + e.getMessage());
        }
    }

    // Método para encontrar um livro pelo ID
    public Book findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar livro " + e.getMessage());
        }
    }

    // Método para atualizar um livro no banco de dados
    public void update(Book book) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar livro " + e.getMessage());
        }
    }
}
