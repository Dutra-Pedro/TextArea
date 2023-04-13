package br.com.TextAreaFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaFrame extends JFrame{
    private JPanel contentPane;
    private JTextArea txta1;
    private JTextArea txta2;
    private JButton btnCopiar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    TextAreaFrame frame = new TextAreaFrame();
                    frame.setVisible(true);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public TextAreaFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,200);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        Box box = Box.createHorizontalBox();
        String string = "Isto é um texto demonstrativo para ser copiado";
        txta1 = new JTextArea(string,10,15);
        box.add(new JScrollPane(txta1));
        btnCopiar = new JButton("Copiar ->");
        box.add(btnCopiar);

        btnCopiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txta2.setText(txta1.getSelectedText());
            }
        });

        txta2 = new JTextArea(10,15);
        txta2.setEditable(false);
        box.add(new JScrollPane(txta2));
        add(box);
    }

}
