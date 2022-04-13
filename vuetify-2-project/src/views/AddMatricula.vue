<template>
  <v-container fluid class="fill-height">
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title> Matrícula </v-toolbar-title>
          </v-toolbar>

          <v-form
            @submit.prevent="criarMatricula()"
            ref="form"
            lazy-validation
            v-model="valid"
          >
            <v-col class="d-flex" cols="12" sm="6">
              <v-select
                :items="usuarios"
                label="Usuario"
                utlined
                v-model="usuarioSelecionado"
                item-text="nome"
                item-value="id"
              ></v-select>
            </v-col>

            <v-col class="d-flex" cols="12" sm="6">
              <v-select
                :items="cursos"
                label="Curso"
                utlined
                v-model="cursoSelecionado"
                item-text="nome"
                item-value="id"
              ></v-select>
            </v-col>

            <v-card-actions>
              <v-spacer />
              <v-btn color="primary" :loading="loading" type="submit"
                >Realizar matricula</v-btn
              >
            </v-card-actions>
          </v-form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
import axios from "axios";

const usuarioRepo = RepositoryFactory.get("usuario");
const cursoRepo = RepositoryFactory.get("curso");

export default {
  data: () => ({
    valid: true,
    usuarios: [],
    cursos: [],
    loading: false,
    usuarioSelecionado: "",
    cursoSelecionado: "",
  }),

  async created() {
    const promiseUser = usuarioRepo.getAll();
    const promiseCurso = cursoRepo.getAll();
    try {
      this.loading = true;
      const [{ data: usuarios }, { data: cursos }] = await Promise.all([
        promiseUser,
        promiseCurso,
      ]);

      this.usuarios = usuarios;
      this.cursos = cursos;
    } catch (error) {
      console.error(error);
    }
    this.loading = false;
  },

  methods: {
    async criarMatricula() {
      try {
        this.loading = true;
        await axios.post("/matricula", {
          id_user: this.usuarioSelecionado,
          id_curso: this.cursoSelecionado,
        });
        alert("Sucesso: Matrícula cadastratada!");
        this.$router.push("/matricula");
      } catch (error) {
        alert("Erro: Revise os dados!");
        console.error(error);
      }
      this.loading = false;
    },
  },
};
</script>

<style scoped lang="css">
</style>