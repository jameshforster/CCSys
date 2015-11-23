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
}