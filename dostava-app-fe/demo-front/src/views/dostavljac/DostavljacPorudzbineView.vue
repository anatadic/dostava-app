<template>
  <div class="item">
    <h1>Moje porudzbine</h1>
    <porudzbine-comp
      v-for="porudzbina in porudzbine"
      :key="porudzbina.id"
      :porudzbina="porudzbina"
    >
    </porudzbine-comp>
  </div>
</template>

<script>
import axios from "axios";
import PorudzbineComp from "../../components/PorudzbineComp.vue";
export default {
  name: "DostavljacPorudzbineView",
  components: { PorudzbineComp },
  data: function () {
    return {
      porudzbine: [],
    };
  },
  mounted: function () {
    axios
      .get(
        "http://localhost:8080/api/porudzbine/dostavljac/" + this.$route.params.id,
        {
          withCredentials: true,
        }
      )
      .then((res) => {
        this.porudzbine = res.data;
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
