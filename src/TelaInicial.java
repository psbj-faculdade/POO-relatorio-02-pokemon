import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TelaInicial extends JFrame implements ActionListener{
    public TelaInicial(){
        
        BufferedImage img = null;

        try{
            img = ImageIO.read(new File("imagens/inicial.jpg"));
        } catch (IOException e){
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(380, 500, Image.SCALE_SMOOTH);

        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(dimg);
        label.setIcon(imageIcon);
        

        setTitle("Pokémon");
        setVisible(true);
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        setLayout(null);

        JButton jButton = new JButton("Começar Jogo");
        jButton.setBounds(380, 500, 250,70);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(15, 15, 15));
        jButton.setBackground(new Color(250, 162, 137));
        add(jButton);

        jButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaEscolhaPokemon();
    }
}
