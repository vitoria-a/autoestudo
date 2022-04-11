<template>
  <div align="right" v-if="editDisabled">
    <v-card-widget enableActions :title="'Cursos'">
      <div slot="widget-header-action"></div>

      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
              :headers="headers"
              :items="cursos"
              :items-per-page="4"
              class="elevation-1"
            >
              <template v-slot:[`item.acoes`]="{ item }">
                <v-btn
                  width="30"
                  height="30"
                  color="success"
                  @click="editItem(item.id)"
                >
                  <v-icon center> mdi-pencil </v-icon>
                </v-btn>

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
      <v-else :curso="selectedCurso" :editDisabled.sync="editDisabled" />
    </v-card-widget>

    <br />
    <div>
      <v-btn fab dark color="#2d5269" width="50" height="50" to="/registerCourse">
        <v-icon dark>add</v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import VCardWidget from "@/components/VWidget";
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
import { mdiAccount } from "@mdi/js";
const cursoRepo = RepositoryFactory.get("curso");
import axios from "axios";
import EditCurso from './EditCurso.vue'

export default {
  name: "curso",
  components: {
    VCardWidget,
    EditCurso,
  },

  data: () => ({
    svgPath: mdiAccount,
    editDisabled: true,
    selectedCurso: {},
    headers: [
      {
        text: "Nome",
        align: "left",
        value: "nome",
      },
      {
        text: "Sigla",
        align: "left",
        value: "sigla",
      },
      {
        text: "Turno",
        align: "left",
        value: "turno",
      },
      {
        text: "Ações",
        align: "left",
        value: "acoes",
      },
    ],
    cursos: [],
  }),

  created() {
    cursoRepo
      .getAll()
      .then((res) => {
        this.cursos = res.data;
      })
      .catch(console.error);
  },

  computed: {},

  methods: {
    getCursos: function () {
      axios
        .get("/cursos")
        .then((response) => (this.cursos = response.data));
    },
    deleteItem: async function (item) {
      await axios.delete("/cursos/" + item);
      this.getCursos();
    },
    editItem: function (item) {
      this.editDisabled = false;
      this.selectedCurso = item;
    }
  },
};
</script>
