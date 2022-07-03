<template>
  <div class="container">
    <div class="list">
      <h2>Restoran {{ restoran.naziv }}</h2>
      <p>Tip restorana: {{ restoran.tipRestorana }}</p>
      <p v-if="restoran.lokacija">Lokacija: {{ restoran.lokacija }}</p>
      <p v-if="restoran.status">Status: {{ restoran.status }}</p>
    </div>
    <div class="list">
      <h3>Artikli:</h3>
      <div v-for="artikal in restoran.artikli">
        <p>{{ artikal.naziv }} - {{ artikal.cena }} dinara</p>
        <br />
      </div>
    </div>
    <div class="list">
      <h3>Komentari:</h3>
      <div v-for="komentar in restoran.komentari">
        <p>
          {{ komentar.kupac.ime }} {{ komentar.kupac.prezime }}:
          {{ komentar.tekst }} (ocena: {{ komentar.ocena }})
        </p>
        <br />
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "RestoranView",
  data: function () {
    return {
      restoran: {
        naziv: "",
        tipRestorana: "",
        lokacija: "",
        status: "",
        artikli: "",
        komentari: "",
      },
    };
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/api/restorani/" + this.$route.params.id, {
        withCredentials: true,
      })
      .then((res) => {
        this.restoran = res.data;
      })
      .catch((err) => {
        alert(err.response.data);
        if (err.response.data === "Morate biti ulogovani") {
          this.$router.push("/login");
        }
      });
  },
};
</script>
