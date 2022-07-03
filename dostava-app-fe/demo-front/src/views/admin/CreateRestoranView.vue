<template>
  <div class="container">
    <div class="form">
      <h1>Kreiranje restorana</h1>
      <label for="naziv">Naziv:</label>
      <input v-model="restoran.naziv" /><br />
      <label for="tipRestorana">Tip restorana:</label>
      <input v-model="restoran.tipRestorana" /><br />
      <label for="lokacija">Lokacija:</label>
      <input v-model="restoran.lokacija" /><br />
      <br />
      <button v-on:click="submit()">Nastavi</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import("../../assets/styles/style.css");
export default {
  name: "CreateRestoranView",
  data: function () {
    return {
      restoran: {
        naziv: "",
        tipRestorana: "",
        lokacija: "",
      },
    };
  },
  methods: {
    submit: function () {
      axios
        .post("http://localhost:8080/api/restoran/create", this.restoran, {
          withCredentials: true,
        })
        .then((res) => {
          alert(res.data);
          this.$router.push("/admin-view");
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
