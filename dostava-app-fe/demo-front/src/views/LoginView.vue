<template>
  <div class="container">
    <div class="form">
      <h1>Login</h1>
      <label for="korisnickoIme">Korisnicko ime:</label>
      <input v-model="korisnik.korisnickoIme" /><br />
      <label for="lozinka">Lozinka:</label>
      <input type="password" v-model="korisnik.lozinka" /><br />
      <button v-on:click="submit()">Uloguj se</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import("../assets/styles/style.css");
export default {
  name: "LoginView",
  data: function () {
    return {
      korisnik: {
        korisnickoIme: "",
        lozinka: "",
      },
    };
  },
  methods: {
    submit: function () {
      axios
        .post("http://localhost:8080/api/login", this.korisnik, {
          withCredentials: true,
        })
        .then((res) => {
          if (res?.data?.uloga === "ADMIN") {
            this.$router.push("/admin-view");
          }
          if (res?.data?.uloga === "KUPAC") {
            this.$router.push("/kupac-view/" + res.data.id);
          }
          if (res?.data?.uloga === "MENADZER") {
            this.$router.push("/menadzer-view/"  + res.data.id);
          }
          if (res?.data?.uloga === "DOSTAVLJAC") {
            this.$router.push("/dostavljac-view/"  + res.data.id);
          }
        })
        .catch((err) => {
          alert(err.response.data);
        });
    },
  },
};
</script>
