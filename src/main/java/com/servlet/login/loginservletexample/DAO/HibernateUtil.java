package com.servlet.login.loginservletexample.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // Cria uma única SessionFactory para ser usada em toda a aplicação
    private static SessionFactory sessionFactory = buildSessionFactory();

    // Método para construir a SessionFactory a partir do arquivo de configuração do Hibernate
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError("Erro ao configurar o Hibernate" + e);
        }
    }

    // Método para obter a SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
