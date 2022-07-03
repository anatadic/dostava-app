<template>
  <div class="nav">
    <button class="home-btn" v-on:click="izlogujSe()">Izloguj se</button>
  </div>
  <div class="container">
    <h1>Dobrodosli - admin</h1>

    <a type="button" href="/admin/create-korisnik" class="home-btn"
      >Kreiraj novog korisnika</a
    ><br />
    <a type="button" href="/admin/create-restoran" class="home-btn"
      >Kreiraj novi restoran</a
    ><br />
    <a type="button" href="/admin/korisnici" class="home-btn"
      >Pregled korisnika</a
    ><br />
    <a type="button" href="/admin/restorani" class="home-btn"
      >Pregled restorana</a
    ><br />
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "AdminView",
  methods: {
    izlogujSe: function () {
      axios
        .get("http://localhost:8080/api/logout", { withCredentials: true })
        .then((res) => {
          this.$router.push("/login");
        })
        .catch((err) => {
          alert(err.response.data);
          this.$router.push("/login");
        });
    },
  },
};
</script>
