/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

/**
 *
 * @author Douglas Horvath
 */
public class Alert extends Thread{
    
    private String mensagem;
    private Icon imagem;
    private int time;
    private Color windowColor = Color.GRAY;
    private Color textColor = Color.BLACK;
    private Font font = new Font("Dialog", Font.BOLD, 18);
    private Dimension dim;
    private boolean canto;
    
    @Override
    public void run(){
        
        //JOptionPane meuJOPane = new JOptionPane("Imagens Encontradas!");//instanciando o JOptionPane
        //final JDialog dialog = meuJOPane.createDialog(null, "Adicionadas "+x+" imagens");//aqui uso um JDialog para manipular
        final JWindow dialog = new JWindow();
        if(dim == null)
        {
            this.dim = new Dimension(250, 100);
        }
        dialog.setSize(dim);
        JLabel label = new JLabel(mensagem,JLabel.CENTER);
        label.setSize((int) (dim.getWidth()-2), (int) (dim.getHeight()-2));
        label.setFont(font);
        label.setForeground(textColor);
        label.setBackground(windowColor);
        dialog.add(label);
        if(imagem != null)
        {
            JLabel image = new JLabel("", imagem, JLabel.CENTER);
            label.setBackground(windowColor);
            dialog.add(image);
            if(dim == null)
            {
                this.dim = new Dimension(imagem.getIconWidth(),imagem.getIconHeight());
            }
        }
        
        
        //dialog.setUndecorated(true);
        
        dialog.setLocationRelativeTo(null);
        
        dialog.getContentPane().setBackground(windowColor);
        //dialog.setModal(true); 
        //Usando o javax.swing.Timer para poder gerar um evento em um tempo determinado
        //Veja o construtor da classe Timer para mais explicações
        dialog.setAlwaysOnTop(true);
        if(canto)
        {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension d = tk.getScreenSize();
            dialog.setLocation(d.width-dim.width-20,30);
        }
        dialog.setVisible(true);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Alert.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.dispose();
    }
    
    public void config(String mensagem,int time, Color windowColor, Color textColor)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.windowColor = windowColor;
        this.textColor = textColor;
        this.imagem = null;
    }
        
    public void config(String mensagem,int time, Color windowColor, Color textColor, Font font)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.windowColor = windowColor;
        this.textColor = textColor;
        this.font = font;
        this.imagem = null;
    }
    
    public void config(String mensagem,int time, Color windowColor, Color textColor, Font font, Dimension dim)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.windowColor = windowColor;
        this.textColor = textColor;
        this.font = font;
        this.dim = dim;
        this.imagem = null;
    }
    
    public void config(String mensagem, Icon imagem, int time, Color windowColor, Color textColor, Font font, Dimension dim)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.windowColor = windowColor;
        this.textColor = textColor;
        this.font = font;
        this.dim = dim;
        this.imagem = imagem;
    }
    
    public void config(String mensagem, int time, Color windowColor, Color textColor, Font font, Dimension dim, boolean canto)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.windowColor = windowColor;
        this.textColor = textColor;
        this.font = font;
        this.dim = dim;
        this.canto = canto;
    }
    
    public void show(String mensagem,int time)
    {
        this.dim = new Dimension(250, 100);
        this.mensagem = mensagem;
        this.time = time;
        this.start();
    }
    
    public void show()
    {
        System.out.println("ALERTA DISPARADO");
        this.start();
    }
    
    
    
    public static void alert(String mensagem,int time, Color windowColor, Color textColor, Font font, Dimension dim, boolean canto)
    {
       if(dim == null)
       {
            dim = new Dimension(250, 100);
       }
       if(font == null)
       {
           font = new Font("Dialog", Font.BOLD, 18);
       }
       if(textColor == null)
       {
           textColor = Color.BLACK;
       }
       if(windowColor == null)
       {
           windowColor = Color.WHITE;
       }
       if(time<1)
       {
           time = 1000;
       }
       
       
       
       Alert alert = new Alert();
       alert.config(mensagem, time, windowColor, textColor, font, dim, canto);
       alert.show();
    }
    
    public static void alert(String mensagem,int time, Color windowColor, Color textColor, Font font, Dimension dim)
    {
       if(dim == null)
       {
            dim = new Dimension(250, 100);
       }
       if(font == null)
       {
           font = new Font("Dialog", Font.BOLD, 18);
       }
       if(textColor == null)
       {
           textColor = Color.BLACK;
       }
       if(windowColor == null)
       {
           windowColor = Color.WHITE;
       }
       if(time<1)
       {
           time = 1000;
       }
       Alert alert = new Alert();
       alert.config(mensagem, time, windowColor, textColor, font, dim);
       alert.show();
    }
    
    public static void alert(String mensagem, Icon imagem, int time)
    {
        if(time<1)
        {
            time = 1000;
        }
        Font font = new Font("Dialog", Font.BOLD, 30);
        Color textColor = Color.WHITE;
        Color windowColor = Color.BLACK;
        Dimension dim = new Dimension(imagem.getIconWidth(), imagem.getIconHeight());
        Alert alert = new Alert();
        alert.config(mensagem,imagem,time, windowColor, textColor, font, dim);
        alert.show();
    }
    
}
