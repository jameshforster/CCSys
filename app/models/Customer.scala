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
      Customer(User(3, "Password", "Reginald", "Brookes", "rbs@email.com", false), df.parse("17/08/1965"), 0, "01456 246275", 0),
      Customer(User(4, "Password", "Ben", "Back", "ben.back@NBgardens.com", true), df.parse("05/01/1961"), 0, "01638 734732", 0),
      Customer(User(5, "Password", "Brook", "Delwin", "bdelwin@email.com", false), df.parse("09/12/1990"), 0, "01387 900328", 0))
      
  def findAll() = customers.toList.sortBy(_.user.surname)
  
  def findByFilter(input:String) = {
      
    var resultList:Set[Customer] = Set[Customer]()
    println(input)
    queryLoop(input.split(" "))
    
    def queryLoop(terms: Array[String]) {
      if (!terms.isEmpty) {
        val term = terms.head
        try {
            val intInput = Integer.parseInt(term)
            resultList = resultList ++ findByID(intInput)
          }
        catch{
          case nfe:NumberFormatException =>{ resultList = resultList ++ findBySurname(term)
    
          resultList = resultList ++ findByForeName(term)
    
          resultList = resultList ++ findByEmail(term)}
    
        }
        
        def findByID(input:Int) = customers.find(_.user.idUser == term)
        
        def findBySurname(input:String) = customers.filter(_.user.surname.toLowerCase().contains(term.toLowerCase()))
        
        def findByForeName(input:String) = customers.filter(_.user.forename.toLowerCase().contains(term.toLowerCase()))
        
        def findByEmail(input:String) = customers.filter(_.user.email.toLowerCase().contains(term.toLowerCase()))
        
        queryLoop(terms.tail)
      }
    }
    resultList.toList.sortBy(_.user.surname)
  }
}