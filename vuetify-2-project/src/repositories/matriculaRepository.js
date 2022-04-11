import Repository from "./Repository";

const resource = "/matricula";

export default {
    getByAutenticacao() {
      return Repository.get(`${resource}/matricula`);
    },

    getAll() {
      return Repository.get(`${resource}`)
    },
}
