package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import models.Item

/**
 * @author jforster
 */
class Items extends Controller{
   def list = Action {implicit request =>
     val items = Item.findAll
     
     Ok(views.html.items(items))
   }
   
   def show(inputID: Int) = Action {implicit request =>
     Item.findByID(inputID).map { item =>
       Ok(views.html.itemdetails(item))
     }.getOrElse(NotFound)
   }
   
   def filter(input:String) = Action {implicit request =>
     val items = Item.findByFilter(input)
   
     Ok(views.html.items(items))
   }

}