import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import SingUp from '../views/SingUp'
import Curso from '../views/Cursos'
import AddCourse from '../views/AddCourse'
import Edit from '../views/EditUser.vue'

export default [


    /* Geral */

    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/register',
        name: 'Singup',
        component: SingUp
    },
    {
        path: "/edit/:id",
        name: "Edit",
        component: Edit
    },
    {
        path: "/cursos",
        name: 'Cursos',
        component: Curso
    },
    {
        path: "/registerCourse",
        name: 'AddCouse',
        component: AddCourse
    },
    {
        path: '/login',
        meta: {
            public: true,
        },
        props: true,
        name: 'Login',
        component: LoginPage
    },
    {
        path: '/logout',
        meta: { breadcrumb: true },
        name: 'Logout',
        beforeEnter (to, from, next) {
            store.dispatch('auth/logout', false)
        }
    }

];
