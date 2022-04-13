<template>
  <v-container fluid class="fill-height">
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>Cadastro de Curso</v-toolbar-title>
          </v-toolbar>
          <v-form
            @submit.prevent="criarCurso()"
            ref="form"
            lazy-validation
            v-model="valid"
          >
            <v-card-text>
              <p class="error--text text-center">{{ error }}</p>
              <v-text-field
                label="Nome"
                name="nome"
                prepend-icon=""
                type="text"
                v-model="nome"
                required
                :rules="requiredRule"
              />
              <v-text-field
                label="Sigla"
                name="sigla"
                prepend-icon=""
                type="text"
                v-model="sigla"
                required
                :rules="requiredRule"
              />
              <v-text-field
                label="Turno"
                name="turno"
                prepend-icon=""
                type="text"
                v-model="turno"
                required
                :rules="requiredRule"
              />
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn color="primary" :loading="loading" type="submit" large
                >Criar</v-btn
              >
            </v-card-actions>
          </v-form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  props: ["to", "invalidToken"],
  data: () => ({
    valid: true,
    loading: false,
    nome: "",
    sigla: "",
    turno: "",
    error: "",
    requiredRule: [(v) => !!v || "Campo obrigatório"],
  }),
  methods: {
    async criarCurso() {
      try {
        await axios.post("/cursos", {
          nome: this.nome,
          sigla: this.sigla,
          turno: this.turno,
        });
        this.$router.push("/cursos");
        alert("Sucesso: Curso cadastrado!");
      } catch (error) {
        alert("Erro: Revise os dados!");
      }
    },
  },
};
</script>

<style scoped lang="css">
</style>