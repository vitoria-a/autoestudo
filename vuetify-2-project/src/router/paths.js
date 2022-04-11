import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import SingUp from '../views/SingUp'
import Curso from '../views/Cursos'
import AddCourse from '../views/AddCourse'
import Matricula from '../views/Matricula'
import AddMatricula from '../views/AddMatricula'

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
        path:"/matricula",
        name: 'Matricula',
        component: Matricula
    },
    {
        path: "/registerMatricula",
        name: 'AddMatricula',
        component: AddMatricula
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
