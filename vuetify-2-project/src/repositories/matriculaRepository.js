import Repository from "./Repository";

const resource = "/matricula";

export default {
    getAll() {
      return Repository.get(`${resource}`)
    },
}
