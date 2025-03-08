package latkuis_123230013_PrakPBO;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class Main extends JFrame implements ActionListener{
    
    private JLabel selamat;
    private JButton motor, mobil ;
    
    public Main(){
        setTitle("Frame 1 Pilihan Kendaraan");
        setLayout(new FlowLayout());
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // inisiasi
        selamat = new JLabel ("Selamat Datang di Aplikasi Rental Kendaaran");
        motor = new JButton ("Motor");
        mobil = new JButton ("Mobil");
        
        // listener
        motor.addActionListener(this);
        mobil.addActionListener(this);
        
        // tampilan
        add(selamat) ;
        
        JPanel a = new JPanel(new FlowLayout()) ;
        a.add(motor );
        a.add(mobil );
        add(a) ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == motor){
            new DetailPenyewaanMotor();
        }
        if(e.getSource() == mobil){
            new DetailPenyewaanMobil();
        }
    }

    
    public static void main(String[] args){
        new Main();
    }
    
}
