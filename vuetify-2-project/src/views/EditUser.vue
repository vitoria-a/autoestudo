<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Editar Usuário</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="editarUser()" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Nome" name="nome" prepend-icon="person" type="text" v-model="userToEdit.nome" required :rules="requiredRule"/>
                            <v-text-field label="E-mail" name="email" prepend-icon="email" type="text" v-model="userToEdit.email" required :rules="requiredRule"/>
                            <v-text-field id="password" label="Password" name="password" prepend-icon="lock" type="password" v-model="userToEdit.password" required :rules="requiredRule"/>
                            
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer />
                            <v-btn color="primary" :loading="loading" type="submit" large> Editar </v-btn>
                        </v-card-actions>

                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import axios from 'axios';

    export default {
        props: ['user', 'editDisabled'],
        data: () => ({
            valid: true,
            loading: false,
            userToEdit: {
                nome: '',
                email: '',
                password: '',
            },
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
        }),
        created() {
            this.userToEdit = this.user;
        },
        
        methods: {
            async editarUser() {    
                await axios
                    .put(`/usuarios/${this.userToEdit.id}`, {
                        "id": this.userToEdit.id,
                        "nome": this.userToEdit.nome,
                        "email": this.userToEdit.email,
                        "password": this.userToEdit.password
                    })
                this.$emit('update:editDisabled', true);
            }
        }
    };
</script>

<style scoped lang="css">

</style>