import java.util.HashSet;
import java.util.Set;

public class Perguntas {
    private static String[] perguntas = {
            "Este Pokémon tem um tipo de elemento 'Água'?",
            "Este Pokémon é do tipo 'Voador'?",
            "Este Pokémon é da região de 'Kanto'?",
            "Este Pokémon é do tipo 'Terra'?",
            "Este Pokémon é do tipo 'Fogo'?",
            "Este Pokémon é da região de 'Johto'?",
            "Este Pokémon é do tipo 'Dragão'?",
            "Este Pokémon é do tipo 'Elétrico'?",
            "Este Pokémon é de cor 'laranja'?",
            "Este Pokémon é do tipo 'Planta'?",
            "Este Pokémon é do tipo 'Lutador'?",
            "Este Pokémon é do tipo 'Venenoso'?",
            "Este Pokémon é do tipo 'Pedra'?",
            "Este Pokémon é sem gênero (Genderless)?",
            "Este Pokémon é masculino ?",
            "Este Pokémon tem uma evolução?",
            "Este Pokémon é de cor 'rosa'?",
            "Este Pokémon é de cor 'azul'?",
            "Este Pokémon é de cor 'Branco'?"
    };

    private static Set<Integer> perguntasAnuladas = new HashSet<>();

    public static String[] getPerguntas() {
        return perguntas;
    }

    public static boolean isRelacionada(int indice) {
        return false;
    }

    public static void anularPerguntasRelacionadas(int indice) {
        perguntasAnuladas.add(indice);
    }

    public static boolean isAnulada(int indice) {
        return perguntasAnuladas.contains(indice);
    }

    public static int proximaPerguntaValida(int indiceAtual) {
        for (int i = indiceAtual + 1; i < perguntas.length; i++) {
            if (!isAnulada(i)) {
                return i;  
            }
        }
        return -1;  
    }
}
