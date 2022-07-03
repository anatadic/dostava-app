<template>
  <a type="button" v-bind:href="href">
    <div class="list">
      <p>{{ restoran.naziv }}</p>
      <p>Tip restorana: {{ restoran.tipRestorana }}</p>
      <p>Adresa: {{ restoran.lokacija.adresa }}</p>
    </div>
  </a>
</template>

<script>
export default {
  name: "RestoraniComp",
  props: ["restoran"],
  computed: {
    href() {
      return "/restorani/" + this.restoran.id;
    },
  },
};
</script>
