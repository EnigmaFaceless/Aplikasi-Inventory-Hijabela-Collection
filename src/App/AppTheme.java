/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.BorderFactory;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class AppTheme {

    public static void applyThemeAuth() {
        try {
            /*Frame & Panel Auth*/
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("Component.arc", 15);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("Button.focusWidth", 0);
            UIManager.put("Component.focusWidth", 1);
            UIManager.put("Button.borderWidth", 0);
            UIManager.put("TextComponent.borderWidth", 1);
            Color bg = new Color(0xFD, 0xF7, 0xF2);
            UIManager.put("ComboBox.background", bg);
            UIManager.put("ComboBox.buttonBackground", bg);
            UIManager.put("ComboBox.buttonEditableBackground", bg);
            UIManager.put("ComboBox.arrowButtonBackground", bg);

            /* ============================PANEL DASHBOARD============================ */
            UIManager.put("Panel.background", Color.WHITE);
            UIManager.put("Label.foreground", new Color(45, 45, 45));

            /* ============================TABLE============================ */
            UIManager.put("Table.background", Color.WHITE);
            UIManager.put("Table.foreground", new Color(55, 55, 55));
            UIManager.put("Table.selectionBackground", new Color(232, 240, 254));
            UIManager.put("Table.selectionForeground", Color.BLACK);

            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", false);

            UIManager.put("Table.rowHeight", 34);

            UIManager.put("Table.gridColor", new Color(235, 235, 235));

            UIManager.put("TableHeader.background", Color.WHITE);
            UIManager.put("TableHeader.foreground", new Color(70, 70, 70));
            UIManager.put("TableHeader.height", 38);

            /* ============================SCROLLPANE============================ */
            UIManager.put("ScrollPane.border",
                    BorderFactory.createEmptyBorder());

            UIManager.put("Viewport.background", Color.WHITE);

            /* ============================SCROLLBAR============================ */
            UIManager.put("ScrollBar.width", 10);
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.trackArc", 999);

            /* ============================TOOLTIP============================ */
            UIManager.put("ToolTip.arc", 12);

            /* ============================POPUP MENU============================ */
            UIManager.put("PopupMenu.borderCornerRadius", 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
