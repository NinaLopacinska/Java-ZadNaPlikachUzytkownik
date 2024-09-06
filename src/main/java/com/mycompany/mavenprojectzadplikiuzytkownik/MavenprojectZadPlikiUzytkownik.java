/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectzadplikiuzytkownik;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 48514
 */
public class MavenprojectZadPlikiUzytkownik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BazaUzytkownikow bazaUzytkownikow = new BazaUzytkownikow();
        IExporter exporter = new TextFileExporter();
        IFileReaderService fileReaderService = new FileReaderService();

        System.out.println("Witaj Uzytkowniku");

        boolean czyWyjsc = false;
        do {
            System.out.println("1. Dodaj nowego uzytkownika");
            System.out.println("2. Usun uzytkownika");
            System.out.println("3. Wyswietl wszystkich uzytkownikow");
            System.out.println("4. Wczytaj liste uzytkownikow ");
            System.out.println("5. Zapisz liste uzyztkowniow do pliku tekstowego csv ");
            System.out.println("6. Zakoncz program");

            int nrOpcji = scanner.nextInt();
            //if (scanner.hasNextInt()) {

            switch (nrOpcji) {
                case 1:

                    boolean poprawna1 = false;
                    scanner.nextLine();
                    String imie;
                    do {
                        System.out.println("Podaj imie uzytkownika: ");
                        imie = scanner.nextLine();
                        if (imie.equals("") || imie.length() > 50) {
                            System.out.println("Podaj poprawne imie.");
                        } else {
                            poprawna1 = true;
                        }
                    } while (!poprawna1);

                    boolean poprawna2 = false;
                    String nazwisko;
                    do {
                        System.out.println("Podaj nazwisko uzytkownika: ");
                        nazwisko = scanner.nextLine();
                        if (nazwisko.equals("") || nazwisko.length() > 50) {
                            System.out.println("Podaj poprawne nazwisko.");
                        } else {
                            poprawna2 = true;
                        }
                    } while (!poprawna2);

                    boolean poprawna4 = false;
                    int wiek;
                    do {
                        System.out.println("Podaj wiek uzytkownika: ");
                        wiek = scanner.nextInt();
                        if (wiek < 0 || wiek > 120) {
                            System.out.println("Podaj poprawny wiek.");
                        } else {
                            poprawna4 = true;
                        }
                    } while (!poprawna4);

                    boolean poprawna5 = false;
                    scanner.nextLine();
                    String email;
                    do {
                        System.out.println("Podaj e-mailch uzytkownika: ");
                        email = scanner.nextLine();
                        if (email.contains("@")) {
                            poprawna5 = true;
                        } else {
                            System.out.println("Podaj poprawny e-mail.");
                        }
                    } while (!poprawna5);

                    Uzytkownik uzytkownik = new Uzytkownik(imie, nazwisko, wiek, email);

                    uzytkownik.setImie(imie);
                    uzytkownik.setNazwisko(nazwisko);
                    uzytkownik.setWiek(wiek);
                    uzytkownik.setEmail(email);

                    // sparwdzenie czy email jest unikalny 
                    boolean czyUnikalne = true;

                    for (Uzytkownik x : bazaUzytkownikow.getUzytkownicy()) {
                        if (x.getEmail().equalsIgnoreCase(uzytkownik.getEmail())) {
                            czyUnikalne = false;
                            break;
                        }
                    }
                    if (czyUnikalne) {
                        bazaUzytkownikow.getUzytkownicy().add(uzytkownik);
                        System.out.println("Uzytkownk zosal pomyslnie dodany.");
                    } else {
                        System.out.println("Uzytkownik o takim e-mailu juz istnieje. Nie mozna go dodac. ");
                    }

                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("Podaj e-mail uzytkownika, ktorego chcesz usunac: ");
                    String emialDoUsuniecia = scanner.nextLine();

                    List<Uzytkownik> bazaUzytkownikowPoUsuniecie = bazaUzytkownikow.getUzytkownicy().stream()
                            .filter(x -> !x.getEmail().equals(emialDoUsuniecia))
                            .collect(Collectors.toList());
                    bazaUzytkownikow.setUzytkownicy(bazaUzytkownikowPoUsuniecie);
                    System.out.println("Uzytkownik o podanym e-mailu zostal usuniety.");
                    
                    break;

                case 3:
                    System.out.println("Lista uzytkownikow:");
                    for (Uzytkownik x : bazaUzytkownikow.getUzytkownicy()) {
                        System.out.println("Uzytkownik " + x.getImie() + " " + x.getNazwisko() + " w wieku " + x.getWiek());
                    }

                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku, z ktorego chcesz wczytac dane:");
                    String nazwaPlikuWczytanie = scanner.nextLine();

                    try {
                        fileReaderService.readerFile(nazwaPlikuWczytanie, bazaUzytkownikow);
                        // Wyświetl użytkowników po załadowaniu z pliku
                        for (Uzytkownik u : bazaUzytkownikow.getUzytkownicy()) {
                            System.out.println(u);
                        }
                    } catch (IOException e) {
                        System.err.println("Błąd: " + e.getMessage());
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Podaj nzawe pliku (np. lista_uzytkownkow.csv)");
                    String nazwaPlikuZapis = scanner.nextLine();
                    try {
                        exporter.exporter(bazaUzytkownikow.getUzytkownicy(), nazwaPlikuZapis + ".csv");
                        System.out.println("Lista osób została zapisana do pliku: " + nazwaPlikuZapis);
                    } catch (IOException e) {
                        System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Zapraszamy ponownie!");
                    czyWyjsc = true;
                    break;
                default:
                    throw new AssertionError();
            }

        } while (!czyWyjsc);
    }
}
