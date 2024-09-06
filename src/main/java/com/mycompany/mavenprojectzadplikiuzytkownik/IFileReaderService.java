/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenprojectzadplikiuzytkownik;

import java.io.IOException;

/**
 *
 * @author 48514
 */
public interface IFileReaderService {
    void readerFile(String nazwaPlikuWczytywanie, BazaUzytkownikow bazaUzytkownikow) throws IOException;
}
