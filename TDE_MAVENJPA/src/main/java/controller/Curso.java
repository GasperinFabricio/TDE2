package controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Curso {

    @Id
    private int codigo;
    private String nome;
    private int cargaHoraria;

    private HashSet<Aluno> alunos = new HashSet<>();

    public int getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public HashSet<Aluno> getAlunos() {
        return alunos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setAlunos(LinkedHashSet<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public Curso(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
}
