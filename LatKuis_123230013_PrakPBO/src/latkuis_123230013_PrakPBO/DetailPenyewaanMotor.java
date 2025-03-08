package latkuis_123230013_PrakPBO;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class DetailPenyewaanMotor extends JFrame implements ActionListener {
    
    private JLabel selamat, namaP, nomorP, radio, jumlahH, selected;
    private JTextField iNamaP, iNomorP, iJumlahH ;
    private JRadioButton motor1, motor2, motor3 ;
    private ButtonGroup group ;
    private JButton submit, back ;
    
    public DetailPenyewaanMotor(){
        setTitle("Frame 2/3 Detail Penyewaan Motor");
        setLayout(new GridLayout(0, 1)); 
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // inisiasi
        selamat = new JLabel("Form Detail Penyewaan Motor") ;
        
        namaP = new JLabel("Nama Pengguna : ") ;
        iNamaP = new JTextField(15);
        
        nomorP = new JLabel("NomorPengguna : ") ;
        iNomorP = new JTextField(15);
        
        radio = new JLabel("Pilihan Rental Motor : ") ;
        motor1 = new JRadioButton("ACX, 1000/ hari", true) ;
        motor2 = new JRadioButton("BCX, 1100/ hari") ;
        motor3 = new JRadioButton("CCX, 1200/ hari") ;
        
        group = new ButtonGroup() ;
        group.add(motor1);
        group.add(motor2);
        group.add(motor3);
        
        jumlahH = new JLabel("Jumlah Hari Penyewaan : ") ;
        iJumlahH = new JTextField(15);
        
        selected = new JLabel("Pilihan Akhir : ");
        
        submit = new JButton("Submit");
        
        back = new JButton("Back");
        
        // listener
        motor1.addActionListener(this);
        motor2.addActionListener(this);
        motor3.addActionListener(this);
        submit.addActionListener(this);
        back.addActionListener(this);
        
        // tampilan
        JPanel a = new JPanel(new FlowLayout());
        a.add(selamat);
        add(a);

        JPanel b = new JPanel(new FlowLayout(FlowLayout.LEFT));
        b.add(namaP);
        b.add(iNamaP);
        add(b);

        JPanel c = new JPanel(new FlowLayout(FlowLayout.LEFT));
        c.add(nomorP);
        c.add(iNomorP);
        add(c);

        add(radio);
        add(motor1);
        add(motor2);
        add(motor3);

        JPanel d = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d.add(jumlahH);
        d.add(iJumlahH);
        add(d);

        add(selected);

        JPanel e = new JPanel(new FlowLayout(FlowLayout.LEFT));
        e.add(submit);
        add(e);
        
        JPanel f = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        f.add(back);
        add(f) ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == motor1){
            selected.setText("Pilihan Akhir : ACX");
        }
        if(e.getSource() == motor2){
            selected.setText("Pilihan Akhir : BCX");
        }
        if(e.getSource() == motor3){
            selected.setText("Pilihan Akhir : CCX");
        }
        
        //submit
        if (e.getSource() == submit) {
            String nama = iNamaP.getText().trim();
            String nomor = iNomorP.getText().trim();
            String jumlahHari = iJumlahH.getText().trim();
            String pilihan = selected.getText();

            // errorH
            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Pengguna tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nomor.isEmpty() || !nomor.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Nomor Pengguna harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int jumlahHariInt;
            try {
                jumlahHariInt = Integer.parseInt(jumlahHari);
                if (jumlahHariInt <= 0) { // jika jumlah hari kurang dari 1
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Jumlah Hari harus berupa angka positif!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int harga = 0;
            String pilihanMotor = "";
            if (motor1.isSelected()) {
                harga = 1000;
                pilihanMotor = "ACX";
            } else if (motor2.isSelected()) {
                harga = 1100;
                pilihanMotor = "BCX";
            } else if (motor3.isSelected()) {
                harga = 1200;
                pilihanMotor = "CCX";
            }

            new DetaildanTotalHarga(nama, nomor, jumlahHari, pilihanMotor, harga);
        }
    }
}
