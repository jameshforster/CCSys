package models

case class Employee (user:User, role:Role){
  
}

object Employee {
  var employees = Set(
      Employee(User(4, "Password", "Ben", "Back", "ben.back@NBgardens.com", true), Role(1, "Warehouse Operative")),
      Employee(User(6, "Password", "Ray", "Smithy", "ray.smithy@NBGardens.com", true), Role(2, "Salesman")))

}

  