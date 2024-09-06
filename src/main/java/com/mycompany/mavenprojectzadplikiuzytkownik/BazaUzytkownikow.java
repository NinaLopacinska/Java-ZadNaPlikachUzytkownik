/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectzadplikiuzytkownik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48514
 */
public class BazaUzytkownikow {
    private List<Uzytkownik> uzytkownicy = new ArrayList<>();

    public void setUzytkownicy(List<Uzytkownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public List<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
}
}