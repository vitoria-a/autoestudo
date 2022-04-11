<template>
  <div align="right">
    <v-card-widget enableActions :title="'Matricula'">
      <div slot="widget-header-action"></div>

      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
              :headers="headers"
              :items="matriculas"
              :items-per-page="4"
              class="elevation-1"
            >
            </v-data-table>
          </v-col>
        </v-row>
      </div>
    </v-card-widget>

    <br />
    <div>
      <v-btn fab dark color="#2d5269" width="50" height="50" to="/registerMatricula">
        <v-icon dark>add</v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>


import { RepositoryFactory } from "@/repositories/RepositoryFactory";
const usuarioRepo = RepositoryFactory.get("usuario");
const cursoRepo = RepositoryFactory.get("curso");
const matriculaRepo = RepositoryFactory.get("matricula");

export default {
    data: () => ({
      headers: [
        {
          text: "ID Aluno",
          align: "left",
          value: "id_user"
        },
        {
          text: "ID Curso",
          align: "left",
          value: "id_curso"
        }
      ],
      matriculas: []

    }),

    created() {
        matriculaRepo
        .getAll()
        .then((res) => {
            this.matriculas = res.data;
        })
        .catch(console.error);

    },
};
</script>