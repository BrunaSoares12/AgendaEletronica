package agenda_eletronica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bruni
 */
public class Agenda {

    private List<Contato> listaDeContatos;

    public Agenda() {
        this.listaDeContatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        listaDeContatos.add(contato);
    }

    public boolean removerContato(String nome) {
        for (Contato contato : listaDeContatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                listaDeContatos.remove(contato);
                return true;
            }
        }
        return false;
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato contatoNome : listaDeContatos) {
            if (contatoNome.getNome().equalsIgnoreCase(nome)) {
                return contatoNome;
            }
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email) {
        for (Contato contato : listaDeContatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(long telefone) {
        for (Contato contato : listaDeContatos) {
            if (contato.getTelefone() == telefone) {
                return contato;
            }
        }
        return null; // Contato não encontrado
    }

    // Métodos Getters
    public int getTamanho() {
        return listaDeContatos.size();
    }
}
