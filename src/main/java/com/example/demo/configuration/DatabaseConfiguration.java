package com.example.demo.configuration;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private  KorisnikRepository korisnikRepository;

    @Bean
    public boolean instantiate(){

        Lokacija lokacija = new Lokacija();
        lokacija.setGeografskaDuzina(45.297);
        lokacija.setGeografskaSirina(21.319);
        lokacija.setAdresa("Jevrejska 76");
        lokacijaRepository.save(lokacija);

        Restoran restoran = new Restoran();
        restoran.setNaziv("Ming");
        restoran.setTipRestorana("Kineski restoran");
        restoran.setStatus(RestoranStatusEnum.RADI);
        restoran.setLokacija(lokacija);
        restoranRepository.save(restoran);

        Artikal artikal = new Artikal();
        artikal.setNaziv("UDON XL");
        artikal.setCena(890);
        artikal.setTip(TipArtiklaEnum.JELO);
        artikal.setKolicina(3);
        artikal.setOpis("Nudle sa povrcem i piletinom");
        artikal.setRestoran(restoran);
        artikalRepository.save(artikal);

        Artikal artikal2 = new Artikal();
        artikal2.setNaziv("Can Cue");
        artikal2.setCena(420);
        artikal2.setTip(TipArtiklaEnum.JELO);
        artikal2.setKolicina(2);
        artikal2.setOpis("Ljuto zacinjena salata sa tofu sirom");
        artikal2.setRestoran(restoran);
        artikalRepository.save(artikal2);

        TipKupca tipKupca = new TipKupca();
        tipKupca.setIme(TipKupcaEnum.BRONZANI);
        tipKupca.setPopust(5);
        tipKupca.setTrazeniBrojBodova(200);
        tipKupcaRepository.save(tipKupca);

        TipKupca tipKupca2 = new TipKupca();
        tipKupca2.setIme(TipKupcaEnum.SREBRNI);
        tipKupca2.setPopust(10);
        tipKupca2.setTrazeniBrojBodova(400);
        tipKupcaRepository.save(tipKupca2);

        TipKupca tipKupca3 = new TipKupca();
        tipKupca3.setIme(TipKupcaEnum.ZLATNI);
        tipKupca3.setPopust(15);
        tipKupca3.setTrazeniBrojBodova(600);
        tipKupcaRepository.save(tipKupca3);

        Korisnik korisnik = new Korisnik();
        korisnik.setIme("Ivan");
        korisnik.setPrezime("Jovanic");
        korisnik.setPol(PolEnum.MUSKI);
        Date korisnikDatumRodjenja = new GregorianCalendar(1990,11,19).getTime();
        korisnik.setDatumRodjenja(korisnikDatumRodjenja);
        korisnik.setKorisnickoIme("ivke");
        korisnik.setLozinka("ivke1990");
        korisnik.setUloga(UlogaEnum.ADMIN);
        korisnikRepository.save(korisnik);

        Menadzer menadzer = new Menadzer();
        menadzer.setIme("Jovan");
        menadzer.setPrezime("Petrovic");
        menadzer.setPol(PolEnum.MUSKI);
        Date menadzerDatumRodjenja = new GregorianCalendar(1988,10,13).getTime();
        menadzer.setDatumRodjenja(menadzerDatumRodjenja);
        menadzer.setKorisnickoIme("jovanp");
        menadzer.setLozinka("jovanp1206");
        menadzer.setUloga(UlogaEnum.MENADZER);
        menadzer.setRestoran(restoran);
        menadzerRepository.save(menadzer);

        Kupac kupac = new Kupac();
        kupac.setIme("Mara");
        kupac.setPrezime("Jovanovic");
        kupac.setPol(PolEnum.ZENSKI);
        Date kupacDatumRodjenja = new GregorianCalendar(1986,8,7).getTime();
        kupac.setDatumRodjenja(kupacDatumRodjenja);
        kupac.setKorisnickoIme("mara13");
        kupac.setLozinka("marajela");
        kupac.setUloga(UlogaEnum.KUPAC);
        kupac.setTipKupca(tipKupca);
        kupac.setBrojSakupljenihBodova(219);
        kupacRepository.save(kupac);

        Dostavljac dostavljac = new Dostavljac();
        dostavljac.setIme("Marko");
        dostavljac.setPrezime("Ilic");
        dostavljac.setPol(PolEnum.MUSKI);
        Date datumRodjenja = new GregorianCalendar(2000,11,17).getTime();
        dostavljac.setDatumRodjenja(datumRodjenja);
        dostavljac.setKorisnickoIme("ilici9");
        dostavljac.setLozinka("porodicailic67");
        dostavljac.setUloga(UlogaEnum.DOSTAVLJAC);
        dostavljacRepository.save(dostavljac);

        Set<Artikal> artikli = new HashSet<>();
        artikli.add(artikal);
        artikli.add(artikal2);

        Porudzbina porudzbina = new Porudzbina();
        porudzbina.setCena(artikal.getCena() + artikal2.getCena());
        porudzbina.setStatus(StatusPorudzbineEnum.U_PRIPREMI);
        porudzbina.setDatumIVreme(new Date());
        porudzbina.setKupac(kupac);
        porudzbina.setRestoran(restoran);
        porudzbina.setDostavljac(dostavljac);
        porudzbina.setArtikli(artikli);
        porudzbinaRepository.save(porudzbina);

        Set<Porudzbina> svePorudzbine = new HashSet<>();
        svePorudzbine.add(porudzbina);
        kupac.setSvePorudzbine(svePorudzbine);
        kupacRepository.save(kupac);

        Komentar komentar = new Komentar();
        komentar.setKupac(kupac);
        komentar.setRestoran(restoran);
        komentar.setOcena(10);
        komentar.setTekst("Odlicna hrana, brza dostava. Svaka preporuka!");
        komentarRepository.save(komentar);

        return true;
    }
}
