<template>
  <div class="nav">
    <button class="home-btn" v-on:click="izlogujSe()">Izloguj se</button>
  </div>
  <div class="container">
    <h1>Dobrodosli - dostavljac</h1>
    <a type="button" v-bind:href="href" class="home-btn"
      >Pregled mojih porudzbina</a
    ><br />
    <a type="button" v-bind:href="hrefPorudzbine" class="home-btn"
      >Pregled porudzbina na cekanju</a
    ><br />
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "DostavljacView",
  computed: {
    href() {
      return "/dostavljac/porudzbine/" + this.$route.params.id;
    },
    hrefPorudzbine() {
      return "/dostavljac/porudzbine/ceka/" + this.$route.params.id;
    },
  },
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
