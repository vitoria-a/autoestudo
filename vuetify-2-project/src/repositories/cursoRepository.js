import Repository from "./Repository";

const resource = "/cursos";

export default {
    getByAutenticacao() {
      return Repository.get(`${resource}/cursos`);
    },

    getAll() {
      return Repository.get(`${resource}`)
    },
    getId(id) {
      return Repository.get(`/cursos/${id}`)
    },
    update(id, data) {
      return http.put(`/cursos/${id}`, data);
    }
}
