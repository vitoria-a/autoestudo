<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Matrícula</v-toolbar-title>
                    </v-toolbar>
                    
                    <v-form @submit.prevent="criarMatricula()" ref="form" lazy-validation v-model="valid" >
                        
                        <v-col class="d-flex" cols="12" sm="6">
                            <v-select :items="usuarios" label="Aluno" utlined></v-select>
                        </v-col>

                        <v-col class="d-flex" cols="12" sm="6">
                            <v-select :items="cursos" label="Curso" utlined></v-select>
                        </v-col>
                    

                        <v-card-actions>
                            <v-spacer />
                            <v-btn color="primary" :loading="loading" type="submit" large>Realizar matricula</v-btn>
                        </v-card-actions>

                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
const usuarioRepo = RepositoryFactory.get("usuario");
const cursoRepo = RepositoryFactory.get("curso");

export default {
    data: () => ({
        usuarios: [],
        cursos: []
    }),

    created() {
    usuarioRepo
      .getAll()
      .then((res) => {
        this.usuarios = res.data;
      })
      .catch(console.error);


    cursoRepo
        .getId()
        .then((res) => {
            this.cursos = res.data;
        })
        .catch(console.error);
  },
    
}
</script>