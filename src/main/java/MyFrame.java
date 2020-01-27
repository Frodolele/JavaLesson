
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author litfr
 */
public class MyFrame extends JFrame implements ActionListener {
    
    private JTextField nameTF;
    private JTextField emailTF;
    private JCheckBox htmlCB;
    private JCheckBox jsCB;
    private JCheckBox phpCB;
    
    
    public MyFrame(){
        
        super("My program");
        
        setBounds(100,200,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        JLabel nameL = new JLabel("Name: ");
        nameTF = new JTextField();
        JLabel emaiL = new JLabel("E-mail: ");
        emailTF = new JTextField();
        
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
        htmlCB = new JCheckBox("HTML");
        jsCB = new JCheckBox("JavaScript");
        phpCB = new JCheckBox("PHP");
        buttonGroup.add(htmlCB);
        buttonGroup.add(jsCB);
        buttonGroup.add(phpCB);
        
        JPanel southButton = new JPanel();
        JButton subscribe = new JButton("Subscribe");
        subscribe.addActionListener(this);
        southButton.add(subscribe);
        
        add(form,BorderLayout.NORTH);
        add(buttonGroup,BorderLayout.CENTER);
        add(southButton,BorderLayout.SOUTH);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());
        if (arg0.getActionCommand().equals("Subscribe")){
            String name = nameTF.getText();
            String email = emailTF.getText();
            boolean html = htmlCB.isSelected();
            boolean js = jsCB.isSelected();
            boolean php = phpCB.isSelected();
            try{
                User u = new User(name, email, html, js, php);
                System.out.println(u);
                User.add(u);
                User.printAllUsers();
            } catch(UserException ue){
                System.out.println(ue);
                switch(ue.getCode()){
                    case UserException.NO_NAME:
                        showError("No_Name");
                        break;
                    case UserException.NO_EMAIL:
                        showError("NO_Email");
                        break;
                }
            }
        }
    }
    
    private void showError(String text){
        JOptionPane.showMessageDialog(this, text);
    }
}
