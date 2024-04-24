package com.mycompany.app.pdv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    private static Connection conn = null;
    private static String USUARIO = "postgres";
    private static String SENHA = "oitoletras8";
    
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence
                    .createEntityManagerFactory("DesktopPU");      
            System.out.println("Conexão aberta");
        }
        return emf;
    }
    public static EntityManager getManager(){
        if(em == null || !em.isOpen()){
            em = getEntityManagerFactory().createEntityManager();
            System.out.println("COnexão aberta");
        }
        return em;
    }
    public static void closeEntityManagerFactory(){
        if(emf != null && emf.isOpen()){
            emf.close();
            System.out.println("Conexão Fechada!");
        }
    }
    
    public static Connection getConexao() {
        try{
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pdv", USUARIO, SENHA);
                return conn;
            }
            
            return conn;
        } catch(Exception ex) {
            conn = null;
            System.out.println("Erro ao abrir conexão");
        }
        
        return null;
    }
    
}


