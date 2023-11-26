package dao;

import controller.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaBootstrap {

    public static void main(String[] args) {
        // Criação de uma 'EntityManagerFactory'. Este é um passo caro, normalmente feito apenas uma vez por aplicação.
        // "exemplo-jpa" é o nome da unidade de persistência definida no arquivo "persistence.xml".
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        // O 'EntityManager' é responsável por gerenciar as entidades e suas transações.
        // É criado a partir da 'EntityManagerFactory' e é uma instância leve que deve ser usada e descartada para cada transação ou série de transações.
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar uma transação. É necessário para realizar operações de persistência, como salvar um objeto no banco de dados.
            em.getTransaction().begin();

            // Criação de uma nova instância de Livro.
            //cria curso
            Curso curso1 = new Curso(12, "Bacharelado em Química", 3800);
            // cria aluno apontando ele pra lista de alunos em Curso
            Aluno a = new Aluno("Kevin", 12345, curso1);
            curso1.getAlunos().add(a);
            // Persiste o objeto Livro no banco de dados. Isso fará com que o JPA insira um novo registro na tabela correspondente.
            em.persist(curso1);
            // Commit da transação. Isso confirmará as operações de persistência realizadas durante a transação.
            em.getTransaction().commit();
        } catch (Exception e) {
            // Se houver alguma exceção durante a transação, faz o rollback para evitar um estado inconsistente no banco de dados.
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Fechamento do 'EntityManager'. É importante fechar para liberar os recursos que ele está consumindo.
            em.close();
        }

        // Fechamento da 'EntityManagerFactory'. Uma vez fechado, nenhum 'EntityManager' pode ser criado. Deve ser fechado ao final do programa para liberar recursos.
        emf.close();
    }
}