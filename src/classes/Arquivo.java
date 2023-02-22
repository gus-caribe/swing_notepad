/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.*;
import java.io.FileWriter;

/**
 *
 * @author Gustavo
 */
public class Arquivo extends ArquivoAbstrato {

    public Arquivo() {
        this.titulo = "Novo";
        this.alterado = false;
    }

    /**
     *
     * @param arquivo
     * @param texto
     */
    @Override
    public void salvar(File arquivo, String texto) {
        this.arquivo = arquivo;
        FileWriter escrivao = null;

        try {
            escrivao = new FileWriter(this.arquivo);
            this.titulo = this.arquivo.getName();
            this.alterado = false;
            escrivao.write(texto);
        } catch (IOException ioe) {
        } finally {
            try {
                escrivao.close();
            } catch (IOException excp) {
            }
        }
    }

    @Override
    public void salvar(String texto) {
        FileWriter escrivao = null;

        try {
            escrivao = new FileWriter(this.arquivo);
            this.titulo = this.arquivo.getName();
            this.alterado = false;
            escrivao.write(texto);
        } catch (IOException ioe) {
        } finally {
            try {
                escrivao.close();
            } catch (IOException excp) {
            }
        }
    }

    @Override
    public String abrir(File arquivo) {
        FileInputStream fileInput = null;
        BufferedReader leitor = null;
        String retorno = "";
        String linha = " ";
        
        this.arquivo = arquivo;
        this.titulo  = this.arquivo.getName();

        try {
            fileInput = new FileInputStream(arquivo);
            leitor = new BufferedReader(new InputStreamReader(fileInput));
            
            while (linha != null) {
                linha = leitor.readLine();
                if (linha == null) {
                    break;
                }
                retorno = retorno + linha + "\n";
            }
        } 
        catch (IOException ioe) {}
        finally {
            try {
                leitor.close();
                fileInput.close();
            }
            catch (IOException excp) {}
        }
        
        return retorno;
    }
}
