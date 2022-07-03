import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegisterView from '../views/RegisterView.vue'
import LoginView from '../views/LoginView.vue'
import KupacView from '../views/korisnik/KupacView'
import KupacProfileView from '../views/korisnik/KupacProfileView'
import AdminView from '../views/admin/AdminView.vue'
import CreateKorisnikView from '../views/admin/CreateKorisnikView.vue'
import CreateRestoranView from '../views/admin/CreateRestoranView.vue'
import KorisniciView from '../views/admin/KorisniciView.vue'
import MenadzerView from '../views/menadzer/MenadzerView.vue'
import MenadzerRestoraniView from '../views/menadzer/MenadzerRestoraniView'
import MenadzerPorudzbineView from '../views/menadzer/MenadzerPorudzbineView'
import DostavljacView from '../views/DostavljacView.vue'
import RestoraniView from '../views/RestoraniView.vue'
import RestoranView from '../views/RestoranView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/restorani',
    name: 'restorani',
    component: RestoraniView
  },
  {
    path: '/restorani/:id',
    name: 'restoran-view',
    component: RestoranView
  },
  {
    path: '/admin/restorani',
    name: 'admin-restorani',
    component: RestoraniView
  },
  {
    path: '/admin-view',
    name: 'admin-view',
    component: AdminView
  },
  {
    path: '/kupac-view/:id',
    name: 'kupac-view',
    component: KupacView
  },
  {
    path: '/kupac/profile/:id',
    name: 'kupac-profile-view',
    component: KupacProfileView
  },
  {
    path: '/menadzer-view/:id',
    name: 'menadzer-view',
    component: MenadzerView
  },
  {
    path: '/menadzer/porudzbine/:id',
    name: 'menadzer-porudzbine-view',
    component: MenadzerPorudzbineView
  },
  {
    path: '/menadzer/restorani/:id',
    name: 'menadzer-restorani-view',
    component: MenadzerRestoraniView
  },
  {
    path: '/dostavljac-view/:id',
    name: 'dostavljac-view',
    component: DostavljacView
  },
  {
    path: '/admin/create-korisnik',
    name: 'create-korisnik',
    component: CreateKorisnikView
  },
  {
    path: '/admin/create-restoran',
    name: 'create-restoran',
    component: CreateRestoranView
  },
  {
    path: '/admin/korisnici',
    name: 'korisnici',
    component: KorisniciView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
