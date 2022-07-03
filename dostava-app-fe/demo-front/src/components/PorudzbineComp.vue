<template>
  <div class="list">
    <p>Datum porudzbine: {{ porudzbina.datumIVreme }}</p>
    <p>Kupac: {{ porudzbina.kupac?.ime }} {{ porudzbina.kupac?.prezime }}</p>
    <p>
      Dostavljac: {{ porudzbina.dostavljac?.ime }}
      {{ porudzbina.dostavljac?.prezime }}
    </p>
    <p>Status: {{ porudzbina.status }}</p>
    <p>Ukupan iznos porudzbine: {{ porudzbina.cena }} dinara</p>
    <br/>
    <div  class="list-items">
    <p>Artikli:</p>
    <ul
      v-for="artikal in porudzbina.artikli"
      :key="artikal.id"
      :artikal="artikal"
    >
      <li>{{ artikal.kolicina }}x {{ artikal.naziv }} </li>
    </ul></div>
  </div>
</template>

<script>
export default {
  name: "PorudzbineComp",
  props: ["porudzbina"],
};
</script>
