import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JogoPokemon {
    private Pokemon[] pokemons;
    private Pokemon pokemonEscolhido;
    private int perguntaAtualIndex;

    public JogoPokemon() {
        pokemons = new Pokemon[]{
            new Pokemon("Squirtle", "Masculino", "Kanto", "Água", "Azul", "Sim", "Wartortle", "Blastoise"),
            new Pokemon("Vaporeon", "Sem gênero", "Kanto", "Água", "Azul", "Não", null, null),
            new Pokemon("Milotic", "Feminino", "Hoenn", "Água", "Azul e rosa", "Sim", "Feebas", null),
            new Pokemon("Pidgey", "Variável", "Kanto", "Voador", "Marrom", "Sim", "Pidgeotto", "Pidgeot"),
            new Pokemon("Dragonite", "Masculino", "Kanto", "Voador", "Laranja", "Sim", "Dragonair", null),
            new Pokemon("Lugia", "Sem gênero", "Johto", "Voador", "Branco e azul", "Não", null, null),
            new Pokemon("Geodude", "Variável", "Kanto", "Pedra/Terra", "Marrom", "Sim", "Graveler", "Golem"),
            new Pokemon("Onix", "Variável", "Kanto", "Pedra/Terra", "Cinza", "Sim", "Steelix", null),
            new Pokemon("Garchomp", "Masculino", "Sinnoh", "Dragão/Terra", "Azul e vermelho", "Sim", "Gabite", null),
            new Pokemon("Charmander", "Variável", "Kanto", "Fogo", "Laranja", "Sim", "Charmeleon", "Charizard"),
            new Pokemon("Arcanine", "Masculino", "Kanto", "Fogo", "Laranja", "Não", null, null),
            new Pokemon("Blaziken", "Masculino", "Hoenn", "Fogo/Lutador", "Vermelho e amarelo", "Sim", "Combusken", null),
            new Pokemon("Pikachu", "Variável", "Kanto", "Elétrico", "Amarelo", "Sim", "Raichu", null),
            new Pokemon("Jolteon", "Sem gênero", "Kanto", "Elétrico", "Amarelo", "Não", null, null),
            new Pokemon("Raikou", "Sem gênero", "Johto", "Elétrico", "Amarelo e roxo", "Não", null, null),
            new Pokemon("Bulbasaur", "Variável", "Kanto", "Planta/Venenoso", "Verde", "Sim", "Ivysaur", "Venusaur"),
            new Pokemon("Venusaur", "Masculino", "Kanto", "Planta/Venenoso", "Verde", "Não", null, null),
            new Pokemon("Ludicolo", "Variável", "Hoenn", "Água/Planta", "Verde e marrom", "Sim", "Lombre", null)        
        };
        perguntaAtualIndex = 0;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarJogo();

    }
    
    private void iniciarJogo() {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Pokémon Akinator!");
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(
                        frame,
                        "Tem certeza que deseja sair?",
                        "Confirmação de Saída",
                        JOptionPane.YES_NO_OPTION);
    
                if (confirmacao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    
        escolherPokemon();
    }
    
    private void escolherPokemon() {
        String[] nomesPokemon = new String[pokemons.length];
        for (int i = 0; i < pokemons.length; i++) {
            nomesPokemon[i] = pokemons[i].getNome();
        }
    
        JComboBox<String> pokemonDropdown = new JComboBox<>(nomesPokemon);
    
        JPanel panel = new JPanel();
        panel.add(new JLabel("Escolha um Pokémon:"));
        panel.add(pokemonDropdown);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Escolha de Pokémon", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int escolha = pokemonDropdown.getSelectedIndex();
            if (escolha >= 0 && escolha < pokemons.length) {
                pokemonEscolhido = pokemons[escolha];
                fazerPerguntas();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, escolha um Pokémon antes de começar o jogo.");
            }
        } else if (result == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Jogo encerrado. Obrigado por jogar o Pokémon Akinator!");
            System.exit(0);
        }
    }
    

    private void fazerPerguntas() {
        while (perguntaAtualIndex < Perguntas.getPerguntas().length) {
            String pergunta = Perguntas.getPerguntas()[perguntaAtualIndex];
            int resposta = JOptionPane.showConfirmDialog(null, pergunta, "Responda a pergunta", JOptionPane.YES_NO_OPTION);
    
            if (resposta == JOptionPane.YES_OPTION) {
                processarResposta(true);
            } else if (resposta == JOptionPane.NO_OPTION) {
                processarResposta(false);
            } else if (resposta == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Você escolheu 'Não sei'. Vamos para a próxima pergunta.");
            }
    
            perguntaAtualIndex++;
        }
    
        exibirResultado();
    }
    
    private void processarResposta(boolean resposta) {
        boolean caracteristicaPokemon = pokemonEscolhido.temCaracteristica(perguntaAtualIndex);
    
        Object[] options = {"Sim", "Não", "Não sei"};
    
        int confirmacao = JOptionPane.showOptionDialog(null,
                "Tem certeza da resposta desejada?",
                "Confirmação",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);  
    
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (resposta == caracteristicaPokemon) {
            } else {
                Perguntas.anularPerguntasRelacionadas(perguntaAtualIndex);
    
                perguntaAtualIndex = Perguntas.proximaPerguntaValida(perguntaAtualIndex);
                if (perguntaAtualIndex == -1) {
                    exibirResultado();
                }
            }
        } else if (confirmacao == JOptionPane.NO_OPTION) {
            if (resposta == caracteristicaPokemon) {
            } else {
                Perguntas.anularPerguntasRelacionadas(perguntaAtualIndex);
    
                perguntaAtualIndex = Perguntas.proximaPerguntaValida(perguntaAtualIndex);
                if (perguntaAtualIndex == -1) {
                    exibirResultado();
                }
            }
        } else if (confirmacao == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        } else {
            perguntaAtualIndex = Perguntas.proximaPerguntaValida(perguntaAtualIndex);
            if (perguntaAtualIndex == -1) {
                exibirResultado();
            }
        }
    }
    
    private void exibirResultado() {
        JOptionPane.showMessageDialog(null, "Parabéns, você escolheu o Pokémon: " + pokemonEscolhido.getNome());
        reiniciarJogo();
    }

    private void reiniciarJogo() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Reiniciar o jogo", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            perguntaAtualIndex = 0;
            iniciarJogo();
        } else {
            JOptionPane.showMessageDialog(null, "Obrigado por jogar o Pokémon Akinator!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JogoPokemon());
    }
}
