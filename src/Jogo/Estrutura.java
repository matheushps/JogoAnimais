package Jogo;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matheus
 */
public class Estrutura {
    private static final String MSG_ACERTO = "Acertei de novo!";
    private static final String MSG_PERGUNTA_1 = "Qual o animal você pensou?";
    private static final String MSG_ANIMAL_VIVE = "O animal que você pensou vive na ";
    private static final String MSG_ANIMAL_E = "O animal que você pensou é um ";
    static No no;

	public static void main(String[] args) {
		String atributo = "água";
		no = new No(atributo);
		no.texto = MSG_ANIMAL_VIVE + atributo + "?";
		String tubarao = "tubarão";
		no.sim = new No(tubarao);
		no.sim.texto = MSG_ANIMAL_E + tubarao + "?";
		String macaco = "macaco";
		no.nao = new No(macaco);
		no.nao.texto = MSG_ANIMAL_E + macaco + "?";
		iniciarJogo(no);
	}

	public static void iniciarJogo(No animal) {
		int number = JOptionPane.showConfirmDialog(null, "Pense em um animal", "Jogo dos Animais", JOptionPane.PLAIN_MESSAGE);
        switch (number) {
            case 0:
                perguntar(animal);
                break;
            case 1:
                iniciarJogo(animal);
                break;
            default:
                System.exit(0);
        }
	}

	public static void perguntar(No animal) {
		int opcao = JOptionPane.showConfirmDialog(null, animal.texto);
		if (opcao == 0) {
			sim(animal);
		} else if (opcao == 1) {
			nao(animal);
		}
	}

	private static void nao(No animalAtual) {
		if (animalAtual.nao == null) {
			String novoAnimal = JOptionPane.showInputDialog(MSG_PERGUNTA_1);
			String acaoAnimal = JOptionPane.showInputDialog("Um " + novoAnimal + " ____ mas um(a) " + animalAtual.valor + " não.");
			addAnimal(novoAnimal, acaoAnimal);
			iniciarJogo(no);
		} else {
			perguntar(animalAtual.nao);
		}
	}

	private static void sim(No animal) {
		if (animal.sim == null) {
			JOptionPane.showMessageDialog(null, MSG_ACERTO);
			iniciarJogo(no);
		} else {
			perguntar(animal.sim);
		}
	}
        
        public static void addAnimal(String animalNovo, String acaoAnimal) {
		No acao = new No(acaoAnimal);
		acao.texto = MSG_ANIMAL_VIVE + acaoAnimal;
		acao.sim = new No(animalNovo);
		acao.sim.texto = MSG_ANIMAL_E + animalNovo;
		no.nao = acao;
	}

}
