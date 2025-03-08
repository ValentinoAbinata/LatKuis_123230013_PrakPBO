package latkuis_123230013_PrakPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailPenyewaanMobil extends JFrame implements ActionListener {
    
    private JLabel selamat, namaP, nomorP, radio, jumlahH, selected;
    private JTextField iNamaP, iNomorP, iJumlahH;
    private JRadioButton mobil1, mobil2, mobil3;
    private ButtonGroup group;
    private JButton submit, back;
    
    public DetailPenyewaanMobil(){
        setTitle("Frame 2/3 Detail Penyewaan Mobil");
        setLayout(new GridLayout(0, 1)); 
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // inisiasi
        selamat = new JLabel("Form Detail Penyewaan Mobil");
        
        namaP = new JLabel("Nama Pengguna : ");
        iNamaP = new JTextField(15);
        
        nomorP = new JLabel("Nomor Pengguna : ");
        iNomorP = new JTextField(15);
        
        radio = new JLabel("Pilihan Rental Mobil : ");
        mobil1 = new JRadioButton("Mobilio, 5000/ hari", true);
        mobil2 = new JRadioButton("Kijang, 6000/ hari");
        mobil3 = new JRadioButton("Kuda, 7000/ hari");
        
        group = new ButtonGroup();
        group.add(mobil1);
        group.add(mobil2);
        group.add(mobil3);
        
        jumlahH = new JLabel("Jumlah Hari Penyewaan : ");
        iJumlahH = new JTextField(15);
        
        selected = new JLabel("Pilihan Akhir : ");
        
        submit = new JButton("Submit");
        back = new JButton("Back");
        
        // listener
        mobil1.addActionListener(this);
        mobil2.addActionListener(this);
        mobil3.addActionListener(this);
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
        add(mobil1);
        add(mobil2);
        add(mobil3);

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
        add(f);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mobil1){
            selected.setText("Pilihan Akhir : Mobilio");
        }
        if(e.getSource() == mobil2){
            selected.setText("Pilihan Akhir : Kijang");
        }
        if(e.getSource() == mobil3){
            selected.setText("Pilihan Akhir : Kuda");
        }
        
        // submit
        if (e.getSource() == submit) {
            String nama = iNamaP.getText().trim();
            String nomor = iNomorP.getText().trim();
            String jumlahHari = iJumlahH.getText().trim();
            String pilihan = selected.getText();

            // Validasi
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
                if (jumlahHariInt <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Jumlah Hari harus berupa angka positif!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int harga = 0;
            String pilihanMobil = "";
            if (mobil1.isSelected()) {
                harga = 5000;
                pilihanMobil = "Mobilio";
            } else if (mobil2.isSelected()) {
                harga = 6000;
                pilihanMobil = "Kijang";
            } else if (mobil3.isSelected()) {
                harga = 7000;
                pilihanMobil = "Kuda";
            }

            new DetaildanTotalHarga(nama, nomor, jumlahHari, pilihanMobil, harga);
        }
        
        if(e.getSource() == back){
            dispose();
        }
    }
}
