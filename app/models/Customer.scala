package models

import java.util.Date
import java.text.SimpleDateFormat

/**
 * @author jforster
 */
case class Customer (user:User, dateOfBirth:Date, credit:Double, phoneNumber:String, blackListStrikes:Int)
  
object Customer {
  
  val df = new SimpleDateFormat("dd/MM/yyyy")
  var customers = Set(
      Customer(User(1, "Password", "Clarence", "Brookes", "cbrookes@email.com", false), df.parse("10/05/1963"), 0, "01456 246275", 0),
      Customer(User(2, "Password", "Evelyn", "Tamwool", "evetam@email.com", false), df.parse("26/10/1972"), 0, "09465 889452", 0),
      Customer(User(3, "Password", "Reginald", "Brookes", "rbrookes@email.com", false), df.parse("17/08/1965"), 0, "01456 246275", 0),
      Customer(User(4, "Password", "Ben", "Back", "ben.back@NBgardens.com", true), df.parse("05/01/1961"), 0, "01638 734732", 0))
      
  def findAll() = customers.toList.sortBy(_.user.surname)
  
  def findByFilter(input:String) = {
    
    var resultList:Set[Customer] = null
    try {
        val intInput = Integer.parseInt(input)
        resultList = Set(findByID(intInput).getOrElse(null))
      }
    catch{
      case nfe:NumberFormatException => resultList = null
      resultList = findBySurname(input)
      resultList = resultList ++ findByForeName(input)
      resultList = resultList ++ findByEmail(input)
    }
    
    def findByID(input:Int) = customers.find(_.user.idUser == input)
    
    def findBySurname(input:String) = customers.filter(_.user.surname.contains(input))
    
    def findByForeName(input:String) = customers.filter(_.user.forename.contains(input))
    
    def findByEmail(input:String) = customers.filter(_.user.email.contains(input))
    
    resultList.toList
  }
}