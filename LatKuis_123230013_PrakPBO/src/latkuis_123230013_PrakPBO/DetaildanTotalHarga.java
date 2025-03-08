package latkuis_123230013_PrakPBO;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class DetaildanTotalHarga extends JFrame implements ActionListener { 
    
    private JLabel selamat, penyewa, namaP, nomorP, jHari, kendaraanS, hargaS;
    private JButton back, selesai ;

    public DetaildanTotalHarga(String nama, String nomor, String jumlahHari, String pilihanKendaraan, int harga) {
        setTitle("Frame 4 Detail dan Total Harga");
        setLayout(new GridLayout(0,1)); 
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // inisiasi
        int jumlahHariInt = Integer.parseInt(jumlahHari);
        int totalHarga = jumlahHariInt * harga ;
        selamat = new JLabel("Detail dan Total Harga Rental");
        penyewa = new JLabel("Penyewa : ");
        namaP = new JLabel("Nama Penyewa : " + nama);
        nomorP = new JLabel("Nomor Telepon: " + nomor);
        jHari = new JLabel("Jumlah Hari: " + jumlahHari);
        kendaraanS = new JLabel("Pilihan Kendaraan: " + pilihanKendaraan);
        hargaS = new JLabel("Maka, Harga Sewa Sebanyak : " + totalHarga );
        back = new JButton("Back");
        selesai = new JButton("Selesai");
        
        // listener
        back.addActionListener(this);
        selesai.addActionListener(this);

        // tampilan
        JPanel a = new JPanel(new FlowLayout());
        a.add(selamat);
        add(a);
        
        JPanel b = new JPanel(new FlowLayout(FlowLayout.LEFT));
        b.add(penyewa);
        add(b);
        
        JPanel c = new JPanel(new FlowLayout(FlowLayout.LEFT));
        c.add(namaP);
        add(c);
        
        JPanel d = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d.add(nomorP);
        add(d);
        
        JPanel e = new JPanel(new FlowLayout(FlowLayout.LEFT));
        e.add(jHari);
        add(e);
        
        JPanel f = new JPanel(new FlowLayout(FlowLayout.LEFT));
        f.add(kendaraanS);
        add(f);
        
        JPanel g = new JPanel(new FlowLayout(FlowLayout.LEFT));
        g.add(hargaS);
        add(g);
        
        JPanel h = new JPanel(new FlowLayout(FlowLayout.LEFT));
        h.add(selesai);
        add(h);
        
        JPanel i = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        i.add(back);
        add(i);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            dispose();
        }
        if (e.getSource() == selesai) {
            JOptionPane.showMessageDialog(null, 
            "Selesai Memesan, Silahkan Check WA", "Message", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }
    
}
