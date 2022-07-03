<template>
  <div>
    <h1>Restorani</h1>
    <br /><br />
    <div>
      <label for="pretraga">Nadji restoran: </label>
      <input v-model="restoran.naziv" placeholder="Unesite naziv" />
      <input
        v-model="restoran.tipRestorana"
        placeholder="Unesite tip restorana"
      />
      <input v-model="restoran.lokacija" placeholder="Unesite adresu" />
      <button v-on:click="pronadji()">Pronadji</button>
    </div>
    <br /><br />
    <div class="list-container" v-if="restorani">
      <div v-for="restoran in restorani">
        <restorani-comp :key="restoran.id" :restoran="restoran">
        </restorani-comp>
        <button
          v-on:click="deleteRestoran(restoran.id)"
          v-if="adminView"
          type="button"
          class="home-btn"
        >
          Obrisi restoran
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import("../assets/styles/list.css");
import RestoraniComp from "../components/RestoraniComp.vue";
export default {
  name: "RestoraniView",
  components: { RestoraniComp },
  data: function () {
    return {
      restorani: [],
      restoran: {
        naziv: "",
        tipRestorana: "",
        lokacija: "",
      },
    };
  },
  computed: {
    adminView() {
      return this.$route.path === "/admin/restorani";
    },
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/api/restorani", { withCredentials: true })
      .then((res) => {
        this.restorani = res.data;
      })
      .catch((err) => {
        alert(err.response.data);
      });
  },
  methods: {
    pronadji: function () {
      axios
        .post("http://localhost:8080/api/restorani/pretraga", this.restoran, {
          withCredentials: true,
        })
        .then((res) => {
          this.restorani = res.data;
        })
        .catch((err) => {
          alert(err.response.data);
        });
    },
    deleteRestoran: function (id) {
      axios
        .delete(
          "http://localhost:8080/api/restoran/delete/" + id,
          {
            withCredentials: true,
          }
        )
        .then((res) => {
          this.restorani = res.data;
        })
        .catch((err) => {
          alert(err.response.data);
        });
    },
  },
};
</script>
