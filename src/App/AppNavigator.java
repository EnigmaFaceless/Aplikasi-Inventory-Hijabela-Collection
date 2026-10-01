/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Screens.Loading.FrameLoading;
import about.panelNotifikasi;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class AppNavigator {

    // ==============================
    // FRAME -> FRAME
    // ==============================
    public static void openFrame(JFrame currentFrame,
            JFrame nextFrame,
            String fitur) {

        if (currentFrame != null) {
            currentFrame.dispose();      // Tutup dulu Login
        }

        FrameLoading loading = new FrameLoading(fitur, () -> {

            nextFrame.setLocationRelativeTo(null);
            nextFrame.setVisible(true);

        });

        loading.setLocationRelativeTo(null);
        loading.setVisible(true);
        loading.mulaiLoading();

    }

    // ==============================
    // Panel -> Panel
    // ==============================
    public static void openPanel(
            JPanel parent,
            JPanel panel,
            String fitur) {

        FrameLoading loading = new FrameLoading(fitur, () -> {

            parent.removeAll();
            parent.setLayout(new java.awt.BorderLayout());
            parent.add(panel);

            parent.revalidate();
            parent.repaint();

        });

        loading.setVisible(true);
        loading.mulaiLoading();

    }

    public static void setPanel(panelNotifikasi panelNotifikasi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
