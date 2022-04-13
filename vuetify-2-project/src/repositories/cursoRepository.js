import Repository from "./Repository";

const resource = "/cursos";

export default {
    getByAutenticacao() {
      return Repository.get(`${resource}/cursos`);
    },

    getAll() {
      return Repository.get(`${resource}`)
    },
    update(id, data) {
      return http.put(`/cursos/${id}`, data);
    }
}
