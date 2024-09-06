/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectzadplikiuzytkownik;

/**
 *
 * @author 48514
 */
public class Uzytkownik {

    private String imie;
    private String nazwisko;
    private int wiek;
    private String email;

    public Uzytkownik() {
    }

    public Uzytkownik(String imie, String nazwisko, int wiek, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Uzytkownik{"
                + "imie='" + imie + '\''
                + ", nazwisko='" + nazwisko + '\''
                + ", wiek=" + wiek
                + ", email='" + email + '\''
                + '}';
    }

}
