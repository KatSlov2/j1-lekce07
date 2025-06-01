package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky ();
        assertEquals(true,svatky.jeVSeznamu("Nataša"));
        assertNotEquals (true, svatky.jeVSeznamu("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky ();
        int pocetJmen = svatky.getPocetJmen();
        assertEquals(37, pocetJmen);
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky ();
        int pocetJmen = 37;
        int vysledek = svatky.getSeznamJmen().size();
        assertEquals(pocetJmen, vysledek);

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky ();

        svatky.pridejSvatek("Laura", 1, 6);

        assertEquals(true, svatky.jeVSeznamu("Laura"));

        assertEquals(MonthDay.of(1, 6), svatky.vratKdyMaSvatek("Laura"));

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky ();
        svatky.pridejSvatek("Laura", 1, Month.JUNE);

        assertEquals(true, svatky.jeVSeznamu("Laura"));

        assertEquals(MonthDay.of(Month.JUNE,1), svatky.vratKdyMaSvatek("Laura"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky ();
        svatky.pridejSvatek("Laura",MonthDay.of(Month.JUNE,1));

        assertEquals(true, svatky.jeVSeznamu("Laura"));

        assertEquals(MonthDay.of(Month.JUNE,1), svatky.vratKdyMaSvatek("Laura"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky ();

        svatky.smazSvatek("Nataša");
        int pocetJmen = svatky.getSeznamJmen().size();

        assertEquals(36, pocetJmen);

    }
}
