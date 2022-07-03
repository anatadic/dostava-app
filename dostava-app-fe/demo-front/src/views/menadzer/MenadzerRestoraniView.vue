<template>
  <div class="item">
    <h2>Restoran:</h2>
    <restorani-comp :key="restoran.id" :restoran="restoran"> </restorani-comp>
    <a type="button" v-bind:href="href" class="home-btn"
      >Pregledaj porudzbine za restoran {{ restoran.naziv }}</a
    >
  </div>
</template>

<script>
import axios from "axios";
import RestoraniComp from "../../components/RestoraniComp.vue";
export default {
  name: "menadzerProfileView",
  components: { RestoraniComp },
  computed: {
    href() {
      return "/menadzer/porudzbine/" + this.restoran.id;
    },
  },
  data: function () {
    return {
      menadzer: [],
      restoran: {
        naziv: "",
        tipRestorana: "",
        lokacija: "",
      },
    };
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/api/korisnici/" + this.$route.params.id, {
        withCredentials: true,
      })
      .then((res) => {
        this.menadzer = res.data;
        this.restoran = res.data.restoran;
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
