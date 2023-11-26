/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change frame license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit frame template
 */
package GUI;

/**
 *
 * @author Muhammad Nibras A. A
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame();
        frame.setTitle("BMI CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500,400); //
        
        String imagePath = "C:/Users/Muhammad Nibras A. A/Documents/NetBeansProjects/Java Tab/src/GUI/logo.png";
        ImageIcon image = new ImageIcon(imagePath);
        frame.setIconImage(image.getImage());
        
        JPanel newPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        newPanel.setBackground(new Color(255,255,255));
        
        JLabel BMI = new JLabel("BODY MASS INDEX CALCULATOR");
        Font arial1 = new Font("Arial", Font.BOLD, 17);
        BMI.setFont(arial1);
        BMI.setForeground(new Color(39, 35, 67));
        BMI.setBounds(95, 10, 300, 30);
        
        JLabel pengertian = new JLabel("<html>BMI adalah indikator pengukuran yang digunakan untuk menentukan kategori berat badan ideal atau tidak. "
                + "BMI dikembangkan oleh Adolphe Quetelet selama abad ke-19. Melalui hasil perhitungan BMI, "
                + "Anda akan mengetahui kategori berat badan, yaitu kurus, ideal, berlebihan, atau bahkan obesitas.</html>");
        Font arial2 = new Font("Arial",Font.PLAIN,12);
        pengertian.setFont(arial2);
        pengertian.setBounds(10,30,460,100);
        pengertian.setForeground(new Color(39,35,67));
        
        JLabel beratBadan = new JLabel ("Masukan Berat Badanmu (KG) : ");
        Font arial3 = new Font("Arial", Font.BOLD,12);
        beratBadan.setFont(arial3);
        beratBadan.setBounds(10, 115, 200, 30);
        beratBadan.setForeground(new Color(39,35,67));
        
        JLabel tinggiBadan = new JLabel ("Masukan Tinggi Badanmu (M)  : ");
        tinggiBadan.setFont(arial3);
        tinggiBadan.setBounds(10,150,200,30);
        tinggiBadan.setForeground(new Color(39,35,67));
        
        JTextField kB = new JTextField(10);
        kB.setBounds(200, 115, 250, 30);
        kB.setBackground(new Color(255,216,3));
        kB.setForeground(new Color(39,35,67));
        kB.setBorder(null);
        kB.setHorizontalAlignment(JTextField.CENTER);
       
        JTextField kT = new JTextField(10);
        kT.setBounds(200, 150, 250, 30);
        kT.setBackground(new Color(255,216,3));
        kT.setForeground(new Color(39,35,67));
        kT.setBorder(null);
        kT.setHorizontalAlignment(JTextField.CENTER);
        
        JButton submit = new JButton("Hitung");
        submit.setBounds(200,185,100,35);
        submit.setBackground(new Color(227,246,245));
        submit.setForeground(new Color(39,35,67));
        submit.setBorder(null);
        
        JLabel hasil = new JLabel("BMI: ");
        hasil.setBounds(200, 220, 300, 30);
        
        String tablePath = "C:/Users/Muhammad Nibras A. A/Documents/NetBeansProjects/Java Tab/src/GUI/tabel.jpg";
        ImageIcon tabel = new ImageIcon (tablePath);
        
        int maxWidth = 475;
        int maxHeight = 108;
        
        Image img = tabel.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        ImageIcon tabelResized = new ImageIcon(img);
        
        JLabel gambar = new JLabel();
        gambar.setIcon(tabelResized);
        int imageWidth = tabelResized.getIconWidth();
        int imageHeight = tabelResized.getIconHeight();
        
        int x = (frame.getWidth() - imageWidth) / 2;
        int y = 250;
        gambar.setBounds(5, 240, imageWidth, imageHeight);
        
        submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double height = Double.parseDouble(kT.getText());
                        double weight = Double.parseDouble(kB.getText());

                        double bmi = calculateBMI(weight, height);
                        hasil.setText("BMI: " + String.format("%.2f", bmi));
                    } catch (NumberFormatException ex) {
                        hasil.setText("Gunakan titik (.) untuk pengganti koma (,)");
                    }
                }
            });
        
            newPanel.setLayout(null);
            newPanel.add(BMI);
            newPanel.add(pengertian);
            newPanel.add(beratBadan);
            newPanel.add(tinggiBadan);
            newPanel.add(kB);
            newPanel.add(kT);
            newPanel.add(submit);
            newPanel.add(hasil);
            newPanel.add(gambar);
            frame.add(newPanel);
            frame.setVisible(true); //make frame visible
        });
    }
    
    private static double calculateBMI(double weight, double height) {
        // BMI formula: BMI = weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }
}
