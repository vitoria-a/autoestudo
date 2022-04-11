<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Editar Curso</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="editarCurso()" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Nome" name="nome" prepend-icon="info" type="text" v-model="cursoToEdit.nome" required :rules="requiredRule"/>
                            <v-text-field label="Sigla" name="sigla" type="text" v-model="cursoToEdit.sigla" required :rules="requiredRule"/>
                            <v-text-field label="Turno" name="turno" type="text" v-model="cursoToEdit.turno" required :rules="requiredRule"/>
                            
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
        props: ['curso', 'editDisabled'],
        data: () => ({
            valid: true,
            loading: false,
            cursoToEdit: {
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
            this.cursoToEdit = this.curso;
        },
        
        methods: {
            async editarCurso() {    
                await axios
                    .put(`/cursos/${this.cursoToEdit.id}`, {
                        "id": this.cursoToEdit.id,
                        "nome": this.cursoToEdit.nome,
                        "sigla": this.cursoToEdit.sigla,
                        "turno": this.cursoToEdit.turno
                    })
                this.$emit('update:editDisabled', true);
            }
        }
    };
</script>

<style scoped lang="css">

</style>