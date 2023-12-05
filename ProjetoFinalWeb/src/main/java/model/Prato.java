package model;

public class Prato {
    private int id;
    private String nome;
    private String ingredientes;
    private String tipo;

    public Prato(int id, String nome, String ingredientes, String tipo) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
