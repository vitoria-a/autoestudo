<template>
  <div align="right">
    <v-card-widget enableActions title="Matricula">
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
              <template v-slot:[`item.acoes`]="{ item }">
                <v-btn
                  width="30"
                  height="30"
                  color="error"
                  @click="deleteItem(item.id)"
                >
                  <v-icon center> mdi-delete </v-icon>
                </v-btn>
              </template>
            </v-data-table>
          </v-col>
        </v-row>
      </div>
    </v-card-widget>

    <br />
    <div>
      <v-btn
        fab
        dark
        color="#2d5269"
        width="50"
        height="50"
        to="/registerMatricula"
      >
        <v-icon dark>add</v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>
import VCardWidget from "@/components/VWidget";
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
import axios from "axios";
const matriculaRepo = RepositoryFactory.get("matricula");

export default {
  name: "matricula",
  components: {
    VCardWidget,
  },
  data: () => ({
    headers: [
      {
        text: "ID Matricula",
        align: "left",
        value: "id",
      },
      {
        text: "ID Aluno",
        align: "left",
        value: "id_user",
      },
      {
        text: "ID Curso",
        align: "left",
        value: "id_curso",
      },
      {
        text: "Excluir",
        aling: "left",
        value: "acoes",
      },
    ],
    matriculas: [],
  }),

  async created() {
    const { data } = await matriculaRepo.getAll();
    this.matriculas = data;
  },

  methods: {
    getMatriculas: function () {
      axios
        .get("/matricula")
        .then((response) => (this.matriculas = response.data));
    },
    deleteItem: async function (item) {
      console.log(item);
      await axios.delete("/matricula/" + item);
      this.getMatriculas();
    },
  },
};
</script>