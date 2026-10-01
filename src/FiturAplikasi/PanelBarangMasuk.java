/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FiturAplikasi;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USERR
 */
public class PanelBarangMasuk extends javax.swing.JPanel {

    /**
     * Creates new form panelAbout
     */
    public PanelBarangMasuk() {
        initComponents();
        loadTabelBarangMasuk();
        JumlahBarangMasukHariIni();
        totalTransaksiHariIni();
        reset();
     loadComboBarang();
     loadComboSupplier();
    }
    
    
     void loadTabelBarangMasuk(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID Pembelian");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Tanggal");
        model.addColumn("Kode Supplier");
        
        String sql = "SELECT * FROM pembelian";
        
        try {
            Connection conn = koneksi.konek();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idPembelian = rs.getString("id_pembelian");
                String kodeProduk = rs.getString("id_produk");
                String namaProduk = rs.getString("nama_produk");
                String jumlah = rs.getString("jumlah_masuk");
                String tanggal = rs.getString("tanggal_pembelian");
                String kodeSupplier = rs.getString("id_supplier");

                Object[] baris = {idPembelian, kodeProduk, namaProduk, jumlah, tanggal, kodeSupplier};

                model.addRow(baris);
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Mengambil Data!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        tblBarangMasuk.setModel(model);
     }
    void reset (){
       tJumlahMasuk.setText(null);
       tIDPembelian.setText(null);
       tNamaBarang.setText(null);
      
    }
    
    void JumlahBarangMasukHariIni(){
        
         try {
             Connection conn = koneksi.konek();
            String sqlPembelian = "SELECT COALESCE(SUM(jumlah_masuk),0) AS total_barang " + "FROM pembelian "+"WHERE tanggal_pembelian = CURDATE()";
            Statement psPembelian = conn.createStatement();
            ResultSet rsPembelian = psPembelian.executeQuery(sqlPembelian);
            if (rsPembelian.next()) {
                int jumlah = rsPembelian.getInt("total_barang");
                jJumlahPembelian.setText(String.valueOf(jumlah));
            }
        } catch (Exception e) {
        }
                
    }
    
    
    void totalTransaksiHariIni(){
        try {
             Connection conn = koneksi.konek();
            String sqlPembelian = "SELECT COUNT(*) AS total_transaksi " + "FROM pembelian "+"WHERE tanggal_pembelian = CURDATE()";
            Statement psPembelian = conn.createStatement();
            ResultSet rsPembelian = psPembelian.executeQuery(sqlPembelian);
            if (rsPembelian.next()) {
                int jumlah = rsPembelian.getInt("total_transaksi");
                jTotalTransaksi.setText(String.valueOf(jumlah));
            }
        } catch (Exception e) {
        }
    }
    
        void loadComboBarang(){
        try {
            String sql = "SELECT id_produk FROM produk";
            Connection conn = koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cKodeBarang.removeAllItems();
            while (rs.next()) {
             cKodeBarang.addItem(rs.getString("id_produk"));
            }
        } catch (SQLException e) {
       
                    
        }
    }
        
           void loadComboSupplier(){
        try {
            String sql = "SELECT id_supplier FROM supplier";
            Connection conn = koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cKodeSupplier.removeAllItems();
            while (rs.next()) {
             cKodeSupplier.addItem(rs.getString("id_supplier"));
            }
        } catch (SQLException e) {
       
                    
        }
    }
   protected void paintCommponent(java.awt.Graphics g){
       g.setColor(getBackground());
       g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jJumlahPembelian = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTotalTransaksi = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarangMasuk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tIDPembelian = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tNamaBarang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tJumlahMasuk = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tTanggal = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cKodeBarang = new javax.swing.JComboBox<>();
        cKodeSupplier = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(250, 245, 241));
        setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(250, 245, 241));
        jPanel10.setPreferredSize(new java.awt.Dimension(674, 130));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel11.setPreferredSize(new java.awt.Dimension(674, 45));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Barang Masuk");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(783, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(250, 245, 241));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));
        jPanel2.setPreferredSize(new java.awt.Dimension(363, 70));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FiturAplikasi/img/iconkeluar (3).jpeg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(96, 60, 17));
        jLabel5.setText("Total Barang Masuk Hari Ini");

        jJumlahPembelian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jJumlahPembelian.setForeground(new java.awt.Color(96, 60, 17));
        jJumlahPembelian.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("Total Item");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jJumlahPembelian)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jJumlahPembelian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 60, 17));
        jLabel22.setText("Total Transaksi Hari Ini ");

        jTotalTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTotalTransaksi.setForeground(new java.awt.Color(96, 60, 17));
        jTotalTransaksi.setText("jLabel6");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel24.setText("Transaksi");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FiturAplikasi/img/icons8-file-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTotalTransaksi)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotalTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        jPanel10.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(250, 245, 241));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185)))));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.CardLayout());

        tblBarangMasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarangMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMasukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarangMasuk);

        jPanel13.add(jScrollPane2, "card2");

        jPanel5.add(jPanel13, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel1.setText("Riwayat Barang Masuk");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel5.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 241), 5), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185))));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setText("Catatan Barang Masuk");

        jSeparator1.setForeground(new java.awt.Color(96, 60, 17));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(96, 60, 17));
        jLabel3.setText("Kode barang");

        tIDPembelian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185), 2));

        btnTambah.setBackground(new java.awt.Color(96, 60, 17));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(96, 60, 17));
        jLabel18.setText("Nama Barang");

        tNamaBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185), 2));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(96, 60, 17));
        jLabel19.setText("Jumlah Masuk");

        tJumlahMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185), 2));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(96, 60, 17));
        jLabel20.setText("Tanggal");

        tTanggal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 208, 185), 2));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(96, 60, 17));
        jLabel21.setText("Kode Supplier");

        btnEdit.setBackground(new java.awt.Color(96, 60, 17));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnHapus.setBackground(new java.awt.Color(96, 60, 17));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(this::btnResetActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 60, 17));
        jLabel6.setText("ID Pembelian");

        cKodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cKodeSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(tNamaBarang)
                    .addComponent(tJumlahMasuk)
                    .addComponent(tTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tIDPembelian)
                    .addComponent(cKodeBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel6)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(cKodeSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tIDPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tJumlahMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(cKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        jPanel4.add(jPanel7);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
             String idPembelian = tIDPembelian.getText();
              String kodeProduk = cKodeBarang.getSelectedItem().toString();
        String namaProduk = tNamaBarang.getText();
        // Mengambil Nilai Tanggal dari Komponen Jcalendar
        java.util.Date tanggalDate = tTanggal.getDate();
        if (tanggalDate == null){
    JOptionPane.showMessageDialog(null, "Tanggal Belum Dipilih!");
    return;
    
}
     //Membuat Objek java.sql.Date dari nilai waktu(getTime()) milik tanggalDate, lalu menyimpan ke variabel tanggal
        java.sql.Date tanggal = new java.sql.Date(tanggalDate.getTime());
        String jumlah = tJumlahMasuk.getText();
        String kodeSupplier = cKodeSupplier.getSelectedItem().toString();
       
        String sql = "INSERT INTO pembelian (id_pembelian, id_produk, nama_produk, jumlah_masuk, tanggal_pembelian, id_supplier) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPembelian);
            ps.setString(2 ,kodeProduk);
            ps.setString(3, namaProduk);
            ps.setString(4 , jumlah);
            ps.setDate(5, tanggal);
            ps.setString(6, kodeSupplier);
            
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!");
        } catch (HeadlessException headlessException) {
      
        }
        loadTabelBarangMasuk();
    reset();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
           String idPembelian = tIDPembelian.getText();
              String kodeProduk = cKodeBarang.getSelectedItem().toString();
        String namaProduk = tNamaBarang.getText();
        java.util.Date tanggalDate = tTanggal.getDate();
        //Membuat Objek java.sql.Date mengambil nilai waktu dari tanggalDate dan disimpan ke variabel tanggal
        java.sql.Date tanggal = new java.sql.Date(tanggalDate.getTime());
        
        if (tanggalDate == null){
    JOptionPane.showMessageDialog(null, "Tanggal Belum Dipilih!");
    return;
    
}
     
       
        String jumlah = tJumlahMasuk.getText();
        String kodeSupplier = cKodeSupplier.getSelectedItem().toString();
        
        String sql = "UPDATE pembelian SET id_produk=?, nama_produk=?, tanggal_pembelian=?, jumlah_masuk=?, id_supplier=? WHERE id_pembelian=?";
        try {
            Connection conn = koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodeProduk);
            ps.setString(2, namaProduk);
            ps.setDate(3, tanggal);
            ps.setString(4, jumlah);
            ps.setString(5, kodeSupplier);
            ps.setString(6, idPembelian);
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah!");
        } catch (HeadlessException headlessException) {
        }
        
        loadTabelBarangMasuk();
        reset();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
                   String idPembelian = tIDPembelian.getText();

        String sql = "DELETE FROM pembelian WHERE id_pembelian=?";
        try {
            Connection conn = koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPembelian);
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus!");
        } catch (HeadlessException headlessException) {
        }
        
        loadTabelBarangMasuk();
        reset();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMasukMouseClicked
        // TODO add your handling code here:
               int barisYangDipilih = tblBarangMasuk.rowAtPoint(evt.getPoint());
        
        String idPembelian = tblBarangMasuk.getValueAt(barisYangDipilih, 0).toString();
        String kodeProduk = tblBarangMasuk.getValueAt(barisYangDipilih, 1).toString();
        String tanggal = tblBarangMasuk.getValueAt(barisYangDipilih, 4).toString();
        String namaProduk = tblBarangMasuk.getValueAt(barisYangDipilih, 2).toString();
        String jumlah  = tblBarangMasuk.getValueAt(barisYangDipilih, 3).toString();
        String kodeSupplier = tblBarangMasuk.getValueAt(barisYangDipilih, 5).toString();
        
        tIDPembelian.setText(idPembelian);
        cKodeBarang.setSelectedItem(kodeProduk);
        tIDPembelian.setEditable(false);
        tNamaBarang.setText(namaProduk);
        //tTanggal.setCalendar(tanggal);
        tJumlahMasuk.setText(jumlah);
        cKodeSupplier.setSelectedItem(kodeSupplier);   
    }//GEN-LAST:event_tblBarangMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cKodeBarang;
    private javax.swing.JComboBox<String> cKodeSupplier;
    private javax.swing.JLabel jJumlahPembelian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTotalTransaksi;
    private javax.swing.JTextField tIDPembelian;
    private javax.swing.JTextField tJumlahMasuk;
    private javax.swing.JTextField tNamaBarang;
    private com.toedter.calendar.JDateChooser tTanggal;
    private javax.swing.JTable tblBarangMasuk;
    // End of variables declaration//GEN-END:variables
}
