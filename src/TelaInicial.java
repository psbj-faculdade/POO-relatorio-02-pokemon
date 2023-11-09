import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicial extends JFrame implements ActionListener {
    public TelaInicial() {
        setTitle("Pokémon");
        setVisible(true);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        ImageIcon imagem = new ImageIcon("imagens/inicial.jpg");
        JLabel label = new JLabel(imagem);

        JButton jButton = new JButton("Começar Jogo");
        jButton.setBounds(380, 500, 250, 70);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(15, 15, 15));
        jButton.setBackground(new Color(250, 162, 137));
        add(jButton);
        add(label);
        jButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaEscolhaPokemon();
    }
}
