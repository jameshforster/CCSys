package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import models.Customer


/**
 * @author jforster
 */
class Customers extends Controller{
   def list = Action {implicit request =>
     val customers = Customer.findAll
     
     Ok(views.html.customers(customers))
   }
   
   def filter(input:String) = Action {implicit request =>
     val customers = Customer.findByFilter(input)  
     
     Ok(views.html.customers(customers))
   }
   
   def show(inputID: Int) = Action {implicit request =>
     Customer.findByID(inputID).map { customer =>
       Ok(views.html.customerdetails(customer))
       }.getOrElse(NotFound)
     }
}