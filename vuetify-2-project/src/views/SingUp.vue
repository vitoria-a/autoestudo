<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Cadastro</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="criarUser()" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Nome" name="nome" prepend-icon="person" type="text" v-model="nome" required :rules="requiredRule"/>
                            <v-text-field label="E-mail" name="email" prepend-icon="email" type="text" v-model="email" required :rules="requiredRule"/>
                            <v-text-field id="password" label="Password" name="password" prepend-icon="lock" type="password" v-model="password" required :rules="requiredRule"/>
                        
                            <template>
                                <label for="toggle_button"> Habilitado ? 
                                    <span v-if="isActive" class="toggle__label"> On </span>
                                    <span v-if="! isActive" class="toggle__label"> Off </span>

                                    <input type="checkbox" id="toggle_button" v-model="checkedValue">
                                </label>
                            </template>
                        </v-card-text>
                        
                        <v-card-actions>
                            <v-spacer />
                            <v-btn color="primary" :loading="loading" type="submit" large>Criar</v-btn>
                        </v-card-actions>

                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import { mapGetters, mapState } from 'vuex'
    import axios from 'axios';

    export default {
        props: ["to"],
        currentState: false,
        data: () => ({
            valid: true,
            loading: false,
            nome: '',
            email: '',
            password: '',
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
        }),

        computed: {
            isActive() {
                return this.currentState;
            },
            checkedValue: {
            get() {
                return this.defaultState;
            },
            set(newValue) {
                this.currentState = newValue;
            }
        }
        },

        methods: {
            criarUser: function() {    
                if (this.id == '' || this.id == null) {
                    console.log(this.nome, this.email, this.password);
                    axios
                        .post("/usuarios", {
                            "nome": this.nome,
                            "email": this.email,
                            "password": this.password
                        })
                        .then(savedUser => {
                            this.usuarios.push(savedUser.data);
                            this.usuarios.nome = '';
                            this.usuarios.email = '';
                            this.usuarios.password = '';
                        })
                    this.$router.push('/')
                }           
                
            }
        }
    };
</script>

<style scoped lang="css">
.toggle__button {
    vertical-align: middle;
    user-select: none;
    cursor: pointer;
}
.toggle__button input[type="checkbox"] {
    opacity: 0;
    position: absolute;
    width: 1px;
    height: 1px;
}
.toggle__button .toggle__switch {
    display:inline-block;
    height:12px;
    border-radius:6px;
    width:40px;
    background: #BFCBD9;
    box-shadow: inset 0 0 1px #BFCBD9;
    position:relative;
    margin-left: 10px;
    transition: all .25s;
}

.toggle__button .toggle__switch::after, 
.toggle__button .toggle__switch::before {
    content: "";
    position: absolute;
    display: block;
    height: 18px;
    width: 18px;
    border-radius: 50%;
    left: 0;
    top: -3px;
    transform: translateX(0);
    transition: all .25s cubic-bezier(.5, -.6, .5, 1.6);
}

.toggle__button .toggle__switch::after {
    background: #4D4D4D;
    box-shadow: 0 0 1px #666;
}
.toggle__button .toggle__switch::before {
    background: #4D4D4D;
    box-shadow: 0 0 0 3px rgba(0,0,0,0.1);
    opacity:0;
}
</style>