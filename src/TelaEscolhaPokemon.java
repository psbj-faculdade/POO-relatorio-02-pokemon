import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaEscolhaPokemon extends JFrame {
    public TelaEscolhaPokemon(){
        setTitle("Pokémon");
        setVisible(true);
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setLayout(null);

        JButton jButton = new JButton("Começar Jogo");
        jButton.setBounds(30, 10, 250,70);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(15, 15, 15));
        jButton.setBackground(new Color(250, 162, 137));
        
        //add(jButton);


    }
}
