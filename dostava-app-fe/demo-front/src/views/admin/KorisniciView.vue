<template>
  <div>
    <h1>Korisnici</h1>
    <br /><br />
    <div>
      <label for="pretraga">Nadji korisnika: </label>
      <input v-model="korisnikPretraga.ime" placeholder="Unesite ime" />
      <input v-model="korisnikPretraga.prezime" placeholder="Unesite prezime" />
      <input
        v-model="korisnikPretraga.korisnickoIme"
        placeholder="Unesite korisnicko ime"
      />
      <button v-on:click="pronadji()">Pronadji</button>
    </div>
    <br /><br />
    <div class="container-korisnici">
      <table id="korisnici">
        <tr>
          <th>Ime</th>
          <th>Prezime</th>
          <th>Korisnicko ime</th>
          <th>Datum rodjenja</th>
          <th>Uloga</th>
        </tr>
        <korisnici-comp
          v-for="korisnik in korisnici"
          :key="korisnik.id"
          :korisnik="korisnik"
        >
        </korisnici-comp>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import("../../assets/styles/table.css");
import KorisniciComp from "../../components/KorisniciComp.vue";
export default {
  name: "KorisniciView",
  components: { KorisniciComp },
  data: function () {
    return {
      korisnici: [],
      korisnikPretraga: {
        ime: "",
        prezime: "",
        korisnickoIme: "",
      },
    };
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/api/korisnici", { withCredentials: true })
      .then((res) => {
        this.korisnici = res.data;
      })
      .catch((err) => {
        alert(err.response.data);
        if (err.response.data === "Morate biti ulogovani") {
          this.$router.push("/login");
        }
      });
  },
  methods: {
    pronadji: function () {
      axios
        .post(
          "http://localhost:8080/api/korisnici/pretraga",
          this.korisnikPretraga,
          {
            withCredentials: true,
          }
        )
        .then((res) => {
          this.korisnici = res.data;
        })
        .catch((err) => {
          alert(err.response.data);
        });
    },
  },
};
</script>
