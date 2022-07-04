<template>
  <div class="container">
    <div class="form">
      <h1>Registracija</h1>
      <label for="korisnickoIme">Korisnicko ime:</label>
      <input v-model="korisnik.korisnickoIme" /><br />
      <label for="ime">Ime:</label>
      <input v-model="korisnik.ime" /><br />
      <label for="prezime">Prezime:</label>
      <input v-model="korisnik.prezime" /><br />
      <label for="lozinka">Lozinka:</label>
      <input type="password" v-model="korisnik.lozinka" /><br />
      <label for="pol">Pol:</label>
      <div class="pol">
        <span>
          <label for="z">Z</label>
          <input type="radio" id="z" value="zenski" v-model="korisnik.pol" />
        </span>
        <span>
          <label for="m">M</label>
          <input type="radio" id="m" value="muski" v-model="korisnik.pol" />
        </span>
      </div>
      <br />
      <label for="datumRodjenja">Datum rodjenja:</label>
      <input type="date" v-model="korisnik.datumRodjenja" /><br />
      <button v-on:click="submit()">Nastavi</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import("../assets/styles/style.css");
export default {
  name: "RegisterView",
  data: function () {
    return {
      korisnik: {
        korisnickoIme: "",
        ime: "",
        prezime: "",
        lozinka: "",
        pol: "",
        datumRodjenja: "",
      },
    };
  },
  methods: {
    submit: function () {
      axios
        .post("http://localhost:8080/api/register", this.korisnik, {withCredentials: true})
        .then((res) => {
          this.$router.push("/login");
        })
        .catch((err) => {
          alert(err.response.data);
        });
    },
  },
};
</script>
