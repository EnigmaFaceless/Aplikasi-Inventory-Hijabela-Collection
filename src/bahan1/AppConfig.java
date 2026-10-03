/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bahan1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class AppConfig {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/aplikasi_hijabella_collection";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(
                    url,
                    user,
                    password
            );
            return conn;
        } catch (Exception e) {

            System.out.println("Koneksi Gagal : " + e.getMessage()
            );
            return null;
        }
    }
}
