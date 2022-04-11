<template>
  <div align="right" v-if="editDisabled">
    <v-card-widget enableActions :title="'Usuarios'">
      <div slot="widget-header-action"></div>

      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
              :headers="headers"
              :items="usuarios"
              :items-per-page="4"
              class="elevation-1"
            >
              <template v-slot:[`item.acoes`]="{ item }">
                <v-btn
                  width="30"
                  height="30"
                  color="success"
                  @click="editItem(item)"
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
    </v-card-widget>

    <br />
    <div>
      <v-btn fab dark color="#2d5269" width="50" height="50" to="/register">
        <v-icon dark>add</v-icon>
      </v-btn>
    </div>
  </div>
  <edit-user v-else :user="selectedUser" :editDisabled.sync="editDisabled" />
</template>

<script>
// @ is an alias to /src
import VCardWidget from "@/components/VWidget";
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
import { mdiAccount } from "@mdi/js";
const usuarioRepo = RepositoryFactory.get("usuario");
import axios from "axios";
import EditUser from "./EditUser.vue";

export default {
  name: "home",
  components: {
    VCardWidget,
    EditUser,
  },

  data: () => ({
    svgPath: mdiAccount,
    editDisabled: true,
    selectedUser: {},
    headers: [
      {
        text: "Nome",
        align: "left",
        value: "nome",
      },
      {
        text: "Email",
        align: "left",
        value: "email",
      },
      {
        text: "Habilitado",
        align: "left",
        value: "habilitado",
      },
      {
        text: "Ações",
        align: "left",
        value: "acoes",
      },
    ],
    usuarios: [],
  }),

  created() {
    usuarioRepo
      .getAll()
      .then((res) => {
        this.usuarios = res.data;
      })
      .catch(console.error);
  },

  computed: {},

  methods: {
    getUsuarios: function () {
      axios
        .get("/usuarios")
        .then((response) => (this.usuarios = response.data));
    },
    deleteItem: async function (item) {
      await axios.delete("/usuarios/" + item);
      this.getUsuarios();
    },
    editItem: function (item) {
      this.editDisabled = false;
      this.selectedUser = item;
    }
  }
};
</script>
