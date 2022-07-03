<template>
  <tr>
    <td>{{ korisnik.ime }}</td>
    <td>{{ korisnik.prezime }}</td>
    <td>{{ korisnik.korisnickoIme }}</td>
    <td>{{ korisnik.datumRodjenja }}</td>
    <td>{{ korisnik.uloga }}</td>
  </tr>
</template>

<script>
export default {
  name: "KorisniciComp",
  props: ["korisnik"],
};
</script>
