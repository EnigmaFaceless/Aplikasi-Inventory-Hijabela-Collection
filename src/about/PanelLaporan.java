/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package about;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

/**
 *
 * @author USERR
 */
public class PanelLaporan extends javax.swing.JPanel {

    /**
     * Creates new form PanelDataProduk
     */
    public PanelLaporan() {
        initComponents();
        isiJumlahDataLaporan();
        LoadtabelLaporan();
        
    }
    
    private void isiJumlahDataLaporan(){
            try {
                Connection conn = koneksi.konek();
                
                String sqlProduk = "SELECT COUNT(*) AS jumlah FROM produk";
                Statement psProduk = conn.createStatement();
                ResultSet rsProduk = psProduk.executeQuery(sqlProduk);
                
                if (rsProduk.next()) {
                    int jumlah = rsProduk.getInt("jumlah");
                    jJumlahProduk.setText(String.valueOf(jumlah));
                }
                
                String sqlPembelian = "SELECT COUNT(*) AS jumlah FROM pembelian";
                Statement psPembelian = conn.createStatement();
                ResultSet rsPembelian = psPembelian.executeQuery(sqlPembelian);
                if (rsPembelian.next()) {
                    int jumlah = rsPembelian.getInt("jumlah");
                    jJumlahPembelian.setText(String.valueOf(jumlah));
                }
                
                String sqlPenjualan = "SELECT COUNT(*) AS jumlah FROM penjualan";
                Statement psPenjualan = conn.createStatement();
                ResultSet rsPenjualan = psPenjualan.executeQuery(sqlPenjualan);
                if (rsPenjualan.next()) {
                    int jumlah = rsPenjualan.getInt("jumlah");
                    jJumlahPenjualan.setText(String.valueOf(jumlah));
                }
                
                String sql = "SELECT COUNT(*) AS jumlah FROM produk WHERE stok <=10";
                Statement ps = conn.createStatement();
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int jumlah = rs.getInt("jumlah");
                    tStokMenipis.setText(String.valueOf(jumlah));
                }
            } catch (SQLException e) {
                System.out.println("Gagal Mengambil Data");
            }
        }
    
    
    void LoadtabelLaporan(){
        DefaultTableModel model = new DefaultTableModel();
       
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok Awal");
        model.addColumn("Barang Masuk");
        model.addColumn("Barang Keluar");
        model.addColumn("Stok Akhir");
        
        
        
        String sql = "SELECT p.id_produk, p.nama_produk, p.stok, IFNULL(m.total_masuk, 0) AS barang_masuk, IFNULL(k.total_keluar, 0) AS barang_keluar,"
                + "p.stok + IFNULL(m.total_masuk, 0) - IFNULL (k.total_keluar, 0) AS stok_akhir FROM produk p LEFT JOIN(SELECT id_produk, SUM(jumlah_masuk) AS total_masuk FROM pembelian GROUP BY id_produk) m ON p.id_produk = m.id_produk"
                + " LEFT JOIN (SELECT id_produk, SUM(jumlah_keluar) AS total_keluar FROM penjualan GROUP BY id_produk) k ON p.id_produk = k.id_produk";
        
        try {
            Connection conn = koneksi.konek();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                   int no = 1;
            while (rs.next()) {
                String kodeProduk = rs.getString("id_produk");
                String namaBarang = rs.getString("nama_produk");
                String stokAwal = rs.getString("stok");
                String barangMasuk= rs.getString("barang_masuk");
                String barangKeluar= rs.getString("barang_keluar");
                int stokAkhir = rs.getInt("stok_akhir");
                
                String status;
                
                if(stokAkhir <= 10){
                    status = "Hampr Habis!";
                }else{
                   status = "Aman";
                }

                Object[] baris = {no++, kodeProduk, namaBarang, stokAwal,barangMasuk, barangKeluar, stokAkhir };

                model.addRow(baris);
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Mengambil Data!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        tblLaporan.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jJumlahProduk = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jJumlahPembelian = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jJumlahPenjualan = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tStokMenipis = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMinimumSize(new java.awt.Dimension(780, 600));
        setPreferredSize(new java.awt.Dimension(780, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(250, 245, 241));
        jPanel5.setPreferredSize(new java.awt.Dimension(704, 140));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel2.setPreferredSize(new java.awt.Dimension(704, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Laporan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(686, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(250, 245, 241));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(96, 60, 17));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel4.setMinimumSize(new java.awt.Dimension(204, 88));
        jPanel4.setPreferredSize(new java.awt.Dimension(204, 88));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about/img/icons8-shopping-bag-50 (1).png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Produk");

        jJumlahProduk.setForeground(new java.awt.Color(255, 255, 255));
        jJumlahProduk.setText("jLabel6");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jumlah Seluruh Item Fisik");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jJumlahProduk))
                            .addComponent(jLabel5))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jJumlahProduk))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel1.add(jPanel4);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel10.setMinimumSize(new java.awt.Dimension(204, 88));
        jPanel10.setPreferredSize(new java.awt.Dimension(204, 88));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about/img/icons8-download-64.png"))); // NOI18N

        jLabel9.setText("Barang Masuk");

        jJumlahPembelian.setText("jLabel10");

        jLabel11.setText("Total Barang Masuk");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jJumlahPembelian)))
                    .addComponent(jLabel11))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addComponent(jJumlahPembelian))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel11.setMinimumSize(new java.awt.Dimension(204, 88));
        jPanel11.setPreferredSize(new java.awt.Dimension(204, 88));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about/img/icons8-upload-64.png"))); // NOI18N

        jLabel14.setText("Barang Keluar");

        jJumlahPenjualan.setText("jLabel15");

        jLabel16.setText("Total Penjualan");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jJumlahPenjualan)))
                    .addComponent(jLabel16))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jJumlahPenjualan))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jPanel1.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel12.setMinimumSize(new java.awt.Dimension(204, 88));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about/img/icons8-warning-50.png"))); // NOI18N

        jLabel18.setText("Stok Menipis");

        tStokMenipis.setText("jLabel19");

        jLabel20.setText("Produk Hampir Habis");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tStokMenipis)
                            .addComponent(jLabel18))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tStokMenipis))
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(8, 8, 8))
        );

        jPanel1.add(jPanel12);

        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel6.setPreferredSize(new java.awt.Dimension(600, 550));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(868, 58));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLaporan);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel6, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jJumlahPembelian;
    private javax.swing.JLabel jJumlahPenjualan;
    private javax.swing.JLabel jJumlahProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tStokMenipis;
    private javax.swing.JTable tblLaporan;
    // End of variables declaration//GEN-END:variables
}
