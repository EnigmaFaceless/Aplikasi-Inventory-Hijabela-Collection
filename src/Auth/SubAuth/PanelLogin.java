/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Auth.SubAuth;

import App.AppNavigator;
import Auth.FrameAuth;
import Screens.Master.FrameMaster;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import App.AppConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import about.FrameDashbord;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class PanelLogin extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    private boolean passwordTerlihat = false;
    private FrameAuth frame;

    public PanelLogin(FrameAuth frame) {
        initComponents();
        this.frame = frame;
        tLogin.putClientProperty("JTextField.padding", new Insets(0, 8, 0, 0));
        txtPassword.putClientProperty("JTextField.padding", new Insets(0, 8, 0, 0));
        resetPassword();
        initPasswordListener();
    }

    private void ubahPlaceholder() {

        String pilihan = cbLogin.getSelectedItem().toString();
        switch (pilihan) {
            case "Username":
                tLogin.setText("Masukkan Username");
                break;
            case "Email":
                tLogin.setText("Masukkan Email");
                break;
            case "WhatsApp":
                tLogin.setText("Masukkan WhatsApp");
                break;
            default:
                tLogin.setText("");
                break;
        }

    }

    private void togglePassword() {

        if (passwordTerlihat) {

            txtPassword.setEchoChar('•');
            passwordTerlihat = false;

            btnShowPassword.setIcon(new ImageIcon(
                    getClass().getResource("/Assets/Icon/icons8-eye-20.png")));

        } else {

            txtPassword.setEchoChar((char) 0);
            passwordTerlihat = true;

            btnShowPassword.setIcon(new ImageIcon(
                    getClass().getResource("/Assets/Icon/icons8-invisible-20.png")));
        }

    }

    private void resetPassword() {
        passwordTerlihat = false;
        btnShowPassword.setIcon(new ImageIcon(
                getClass().getResource("/Assets/Icon/icons8-eye-20.png")));

    }

    private void initPasswordListener() {

        txtPassword.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {

                if (String.valueOf(txtPassword.getPassword())
                        .equals("Masukkan Password")) {

                    txtPassword.setText("");
                    txtPassword.setForeground(Color.BLACK);
                    txtPassword.setEchoChar('•');

                }

            }

            @Override
            public void focusLost(FocusEvent e) {

                if (String.valueOf(txtPassword.getPassword()).isEmpty()) {

                    showPasswordPlaceholder();

                }

            }

        });

    }

    private void showPasswordPlaceholder() {

        passwordTerlihat = false;

        txtPassword.setText("Masukkan Password");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setEchoChar((char) 0);

        btnShowPassword.setIcon(new ImageIcon(
                getClass().getResource("/Assets/Icon/icons8-eye-20.png")));
    }

    private String hashSHA256(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void login() {

        String metode = cbLogin.getSelectedItem().toString();
        String login = tLogin.getText().trim();
        String password = hashSHA256(String.valueOf(txtPassword.getPassword()));

        if (cbLogin.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Silahkan pilih metode login!");
            return;
        }

        if (login.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Silahkan masukkan data login!");
            return;
        }

        if (password.isEmpty()
                || password.equals("Masukkan Password")) {

            JOptionPane.showMessageDialog(this,
                    "Silahkan masukkan password!");
            return;
        }

        String kolom = "";

        switch (metode) {
            case "Username":
                kolom = "username";
                break;

            case "Email":
                kolom = "email";
                break;

            case "WhatsApp":
                kolom = "whatsapp";
                break;
        }

        try {

            Connection conn = AppConfig.getConnection();

            String sql = "SELECT * FROM user WHERE "
                    + kolom + "=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FrameDashbord dashbord = new FrameDashbord();
                dashbord.setVisible(true);
                FrameAuth frame = (FrameAuth) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
                              

            } else {

                JOptionPane.showMessageDialog(this,
                        "Login gagal!\n"
                        + "Username / Email / WhatsApp atau Password salah.");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Terjadi kesalahan :\n" + e.getMessage());

            e.printStackTrace();

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContent = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblGarisPemisah = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        panelCombo = new javax.swing.JPanel();
        lblIconLogin = new javax.swing.JLabel();
        cbLogin = new javax.swing.JComboBox<>();
        panelUsername = new javax.swing.JPanel();
        lblIconUser = new javax.swing.JLabel();
        tLogin = new javax.swing.JTextField();
        panelPassword = new javax.swing.JPanel();
        lblIconPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnShowPassword = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblForgotPassword = new javax.swing.JLabel();
        lblTanya = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(580, 533));
        setLayout(new java.awt.BorderLayout());

        panelContent.setBackground(new java.awt.Color(253, 247, 242));
        panelContent.setPreferredSize(new java.awt.Dimension(580, 533));
        panelContent.setLayout(new java.awt.GridBagLayout());

        panelBody.setBackground(new java.awt.Color(253, 247, 242));

        panelHeader.setOpaque(false);
        panelHeader.setLayout(new javax.swing.BoxLayout(panelHeader, javax.swing.BoxLayout.Y_AXIS));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Komponen/Logo.png"))); // NOI18N
        lblLogo.setAlignmentX(0.5F);
        panelHeader.add(lblLogo);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(96, 60, 17));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("LOGIN AKUN");
        lblTitle.setAlignmentX(0.5F);
        panelHeader.add(lblTitle);

        lblGarisPemisah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGarisPemisah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Komponen/Garis Pemisah.png"))); // NOI18N
        lblGarisPemisah.setAlignmentX(0.5F);
        panelHeader.add(lblGarisPemisah);

        lblSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSubTitle.setForeground(new java.awt.Color(124, 101, 82));
        lblSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTitle.setText("Masuk ke Akun Anda untuk melanjutkan");
        lblSubTitle.setAlignmentX(0.5F);
        panelHeader.add(lblSubTitle);

        panelCombo.setBackground(new java.awt.Color(253, 247, 242));
        panelCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 94, 60)));
        panelCombo.setPreferredSize(new java.awt.Dimension(42, 45));
        panelCombo.setLayout(new java.awt.BorderLayout());

        lblIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Icon/icons8-drop-down-30.png"))); // NOI18N
        lblIconLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelCombo.add(lblIconLogin, java.awt.BorderLayout.WEST);

        cbLogin.setBackground(new java.awt.Color(253, 247, 242));
        cbLogin.setForeground(new java.awt.Color(128, 128, 128));
        cbLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih Opsi Login Anda!", "Username", "Email", "WhatsApp" }));
        cbLogin.setBorder(null);
        cbLogin.addActionListener(this::cbLoginActionPerformed);
        panelCombo.add(cbLogin, java.awt.BorderLayout.CENTER);

        panelUsername.setBackground(new java.awt.Color(253, 247, 242));
        panelUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 94, 60)));
        panelUsername.setPreferredSize(new java.awt.Dimension(42, 45));
        panelUsername.setLayout(new java.awt.BorderLayout());

        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Icon/icons8-customer-30.png"))); // NOI18N
        lblIconUser.setAlignmentX(0.5F);
        lblIconUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelUsername.add(lblIconUser, java.awt.BorderLayout.WEST);

        tLogin.setBackground(new java.awt.Color(253, 247, 242));
        tLogin.setForeground(new java.awt.Color(128, 128, 128));
        tLogin.setAlignmentX(0.0F);
        tLogin.setBorder(null);
        tLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tLoginFocusLost(evt);
            }
        });
        panelUsername.add(tLogin, java.awt.BorderLayout.CENTER);

        panelPassword.setBackground(new java.awt.Color(253, 247, 242));
        panelPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 94, 60)));
        panelPassword.setPreferredSize(new java.awt.Dimension(42, 45));
        panelPassword.setLayout(new java.awt.BorderLayout());

        lblIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Icon/icons8-password-30.png"))); // NOI18N
        lblIconPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelPassword.add(lblIconPassword, java.awt.BorderLayout.WEST);

        txtPassword.setBackground(new java.awt.Color(253, 247, 242));
        txtPassword.setForeground(new java.awt.Color(128, 128, 128));
        txtPassword.setBorder(null);
        panelPassword.add(txtPassword, java.awt.BorderLayout.CENTER);

        btnShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Icon/icons8-invisible-20.png"))); // NOI18N
        btnShowPassword.setBorderPainted(false);
        btnShowPassword.setContentAreaFilled(false);
        btnShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowPasswordMouseClicked(evt);
            }
        });
        panelPassword.add(btnShowPassword, java.awt.BorderLayout.EAST);

        btnLogin.setBackground(new java.awt.Color(96, 60, 17));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(201, 160, 160));
        btnLogin.setText("Login");
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        lblForgotPassword.setForeground(new java.awt.Color(0, 153, 255));
        lblForgotPassword.setText("Lupa Password?");
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseClicked(evt);
            }
        });

        lblTanya.setForeground(new java.awt.Color(124, 101, 82));
        lblTanya.setText("Belum Punya Akun?");

        lblRegister.setForeground(new java.awt.Color(0, 153, 255));
        lblRegister.setText("Daftar!");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                .addGap(0, 118, Short.MAX_VALUE)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblForgotPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTanya)
                .addGap(18, 18, 18)
                .addComponent(lblRegister)
                .addGap(83, 83, 83))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForgotPassword)
                    .addComponent(lblTanya)
                    .addComponent(lblRegister))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(-40, 0, 0, 0);
        panelContent.add(panelBody, gridBagConstraints);

        add(panelContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoginActionPerformed
        // TODO add your handling code here:
        if (cbLogin.getSelectedIndex() == 0) {

            tLogin.setText("");

            txtPassword.setText("");
            txtPassword.setEchoChar((char) 0);
            txtPassword.setForeground(Color.GRAY);

            return;
        }

        ubahPlaceholder();

        showPasswordPlaceholder();
    }//GEN-LAST:event_cbLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        // TODO add your handling code here:
        frame.showPanel("REGISTER");
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseClicked
        // TODO add your handling code here:
        frame.showPanel("FORGOT");
    }//GEN-LAST:event_lblForgotPasswordMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void tLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tLoginFocusGained
        // TODO add your handling code here:
        String text = tLogin.getText();

        if (text.equals("Masukkan Username")
                || text.equals("Masukkan Email")
                || text.equals("Masukkan WhatsApp")) {

            tLogin.setText("");
        }
    }//GEN-LAST:event_tLoginFocusGained

    private void tLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tLoginFocusLost
        // TODO add your handling code here:
        if (tLogin.getText().trim().isEmpty()) {
            ubahPlaceholder();
        }
    }//GEN-LAST:event_tLoginFocusLost

    private void btnShowPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowPasswordMouseClicked
        // TODO add your handling code here:
        togglePassword();
    }//GEN-LAST:event_btnShowPasswordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnShowPassword;
    private javax.swing.JComboBox<String> cbLogin;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblGarisPemisah;
    private javax.swing.JLabel lblIconLogin;
    private javax.swing.JLabel lblIconPassword;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTanya;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelCombo;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelPassword;
    private javax.swing.JPanel panelUsername;
    private javax.swing.JTextField tLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
