<template>
  <h1>Dobrodosli - {{ kupac.ime }} {{ kupac.prezime }}</h1>
  <div class="container">
    <div class="form">
      <label for="korisnickoIme">Korisnicko ime:</label>
      <input disabled v-model="kupac.korisnickoIme" /><br />
      <label for="ime">Ime:</label>
      <input v-model="kupac.ime" /><br />
      <label for="prezime">Prezime:</label>
      <input v-model="kupac.prezime" /><br />
      <label for="lozinka">Lozinka:</label>
      <input type="password" v-model="kupac.lozinka" /><br />
      <div>
        <button v-on:click="back()">Nazad</button>
        <button v-on:click="submit()">Sacuvaj izmene</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "KupacProfileView",
  data: function () {
    return {
      kupac: [],
    };
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/api/korisnici/" + this.$route.params.id, {
        withCredentials: true,
      })
      .then((res) => {
        this.kupac = res.data;
      })
      .catch((err) => {
        alert(err.response.data);
        if (err.response.data === "Morate biti ulogovani") {
          this.$router.push("/login");
        }
      });
  },
  methods: {
    back: function () {
      this.$router.push("/kupac-view/" + this.$route.params.id);
    },
    submit: function () {
      axios
        .put("http://localhost:8080/api/korisnik/edit", this.kupac, {
          withCredentials: true,
        })
        .then((res) => {
          alert(res.data);
          this.$router.push("/kupac-view/" + this.$route.params.id);
        })
        .catch((err) => {
          alert(err.response.data);
          if (err.response.data === "Morate biti ulogovani") {
            this.$router.push("/login");
          }
        });
    },
  },
};
</script>
