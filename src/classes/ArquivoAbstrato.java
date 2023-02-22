/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;

/**
 *
 * @author Gustavo
 */
public abstract class ArquivoAbstrato {
    String titulo;
    boolean alterado;
    File arquivo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAlterado() {
        return alterado;
    }

    public void setAlterado(boolean alterado) {
        this.alterado = alterado;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
    
    
    public abstract void salvar(File arquivo, String texto);
    public abstract void salvar(String texto);
    public abstract String abrir(File arquivo);
}
