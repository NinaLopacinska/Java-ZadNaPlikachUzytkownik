/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectzadplikiuzytkownik;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

/**
 *
 * @author 48514
 */
public class TextFileExporter implements IExporter{

    @Override
    public void exporter(List<Uzytkownik> uzytkownicy, String nazwaPliku) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nazwaPliku))) {
            for (Uzytkownik x : uzytkownicy) {
                    writer.println(x.getImie() + "-" + x.getNazwisko()
                            + "-" + x.getWiek() + "-" + x.getEmail());
            }
            writer.close();
        }
    }
    
}
