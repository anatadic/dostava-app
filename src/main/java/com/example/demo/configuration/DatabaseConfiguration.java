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

        Lokacija lokacija2 = new Lokacija();
        lokacija2.setGeografskaDuzina(45.539);
        lokacija2.setGeografskaSirina(19.423);
        lokacija2.setAdresa("Pavla Papa 15/2");
        lokacijaRepository.save(lokacija2);

        Restoran restoran2 = new Restoran();
        restoran2.setNaziv("Viva");
        restoran2.setTipRestorana("Tajlandski restoran");
        restoran2.setStatus(RestoranStatusEnum.RADI);
        restoran2.setLokacija(lokacija2);
        restoranRepository.save(restoran2);

        Lokacija lokacija3 = new Lokacija();
        lokacija3.setGeografskaDuzina(44.284);
        lokacija3.setGeografskaSirina(20.465);
        lokacija3.setAdresa("Branka Bajica 72");
        lokacijaRepository.save(lokacija3);

        Restoran restoran3 = new Restoran();
        restoran3.setNaziv("Sarmica");
        restoran3.setTipRestorana("Srpski restoran");
        restoran3.setStatus(RestoranStatusEnum.RADI);
        restoran3.setLokacija(lokacija3);
        restoranRepository.save(restoran3);

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

        Artikal artikal3 = new Artikal();
        artikal3.setNaziv("Pad Thai");
        artikal3.setCena(1430);
        artikal3.setTip(TipArtiklaEnum.JELO);
        artikal3.setKolicina(2);
        artikal3.setOpis("Testo sa mesom ili plodovima more, zacinjeno kikirikijem i tofu sirom.");
        artikal3.setRestoran(restoran2);
        artikalRepository.save(artikal3);

        Artikal artikal4 = new Artikal();
        artikal4.setNaziv("Tavce na gravce");
        artikal4.setCena(360);
        artikal4.setTip(TipArtiklaEnum.JELO);
        artikal4.setKolicina(70);
        artikal4.setOpis("Domaci srpski pasulj sa dimljenim rebrima");
        artikal4.setRestoran(restoran3);
        artikalRepository.save(artikal4);

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

        Porudzbina porudzbina2 = new Porudzbina();
        porudzbina2.setCena(artikal.getCena() + artikal2.getCena());
        porudzbina2.setStatus(StatusPorudzbineEnum.CEKA_DOSTAVLJACA);
        porudzbina2.setDatumIVreme(new Date());
        porudzbina2.setKupac(kupac);
        porudzbina2.setRestoran(restoran2);
        porudzbina2.setDostavljac(dostavljac);
        porudzbina2.setArtikli(artikli);
        porudzbinaRepository.save(porudzbina2);

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

        Komentar komentar2 = new Komentar();
        komentar2.setKupac(kupac);
        komentar2.setRestoran(restoran2);
        komentar2.setOcena(10);
        komentar2.setTekst("Inovativno i originalno, hrana preukusna!");
        komentarRepository.save(komentar2);

        Komentar komentar3 = new Komentar();
        komentar3.setKupac(kupac);
        komentar3.setRestoran(restoran3);
        komentar3.setOcena(10);
        komentar3.setTekst("Ljubaznost zaposlenih, savrsen ukus i prijatna atmosfera");
        komentarRepository.save(komentar3);
        return true;
    }
}