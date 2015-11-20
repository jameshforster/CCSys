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
}