import axios from "axios";

const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/employees";

const EMPLOYEE_ID = 12;

class EmployeeService {
  getEmployee() {
    return axios.get(EMPLOYEE_SERVICE_BASE_URL + "/" + EMPLOYEE_ID);
    //return axios.get("http://localhost:9191/api/employees/12");
  }
}

export default new EmployeeService();
