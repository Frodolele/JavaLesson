
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author litfr
 */
public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("New applicaton");
        
        frame.setBounds(100,200,800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new BorderLayout());
        
        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        JLabel nameL = new JLabel("Name: ");
        JTextField nameTF = new JTextField();
        JLabel emaiL = new JLabel("E-mail: ");
        JTextField emailTF = new JTextField();
        
        nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        emaiL.setHorizontalAlignment(SwingConstants.RIGHT);
        nameTF.setPreferredSize(new Dimension(200,30));
        emailTF.setPreferredSize(new Dimension(200,30));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,0,10,5);
        c.gridx=0;
        c.gridy=0;
        form.add(nameL, c);
        c.gridx=1;
        form.add(nameTF, c);
        c.gridy=1;
        form.add(emailTF, c);
        c.gridx=0;
        form.add(emaiL, c);
        
        
        JPanel buttonGroup = new JPanel();
        JCheckBox htmlCB = new JCheckBox("HTML");
        JCheckBox jsCB = new JCheckBox("JavaScript");
        JCheckBox phpCB = new JCheckBox("PHP");
        buttonGroup.add(htmlCB);
        buttonGroup.add(jsCB);
        buttonGroup.add(phpCB);
        
        JPanel southButton = new JPanel();
        JButton subscribe = new JButton("Subscribe");
        southButton.add(subscribe);
        
        
        frame.add(form,BorderLayout.NORTH);
        frame.add(buttonGroup,BorderLayout.CENTER);
        frame.add(southButton,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
   
}
