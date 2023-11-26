package controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.*;

@Entity
public class Aluno {
    @Column(nullable = false)
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int matricula;


    @ManyToMany(mappedBy = "alunos")
    private HashSet<Curso> cursos = new LinkedHashSet<>();

    private static HashSet<Aluno> alunosGerados = new LinkedHashSet<>();
    public Aluno(String n, int m, Curso c){
        this.nome = n;
        this.matricula = m;
        cursos.add(c);
    }
    public Aluno(String n, int m){
        this.nome = n;
        this.matricula = m;
    }

    public void criarAluno(String n, int m, Curso c) {
        Aluno a = new Aluno(n, m, c);

    }
    public void inserirCursoMatriculado(Curso c) {
        this.cursos.add(c);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


}
