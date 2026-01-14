/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ishar
 */
public class User {
    private String username = "admin";
    private String password = "1234";

    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
