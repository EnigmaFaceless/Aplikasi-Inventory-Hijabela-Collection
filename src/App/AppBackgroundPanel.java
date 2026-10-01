/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class AppBackgroundPanel extends JPanel{
    private final Image background;

    public AppBackgroundPanel() {
        background = new ImageIcon(
                getClass().getResource("/Assets/Images/background_auth_v1.png")
        ).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(
                background,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );
    }
}
