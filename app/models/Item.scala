package models

/**
 * @author jforster
 */
case class Item (itemID: Int, itemName: String, itemStock: Int, itemPrice: Double)

object Item {
  var items = Set(
      Item(1, "Gnome", 20, 10.00),
      Item(2, "King Gnome", 1, 1000.00),
      Item(3, "Prince Gnome", 5, 150.00),
      Item(4, "Princess Gnome", 3, 150.00))
      
  def findAll = items.toList.sortBy(_.itemID)
  
  def findByID(inputID:Int) = items.find(_.itemID == inputID)
  
  def formatPrice(input: Double):String = {
    import java.text.DecimalFormat
    val df = new DecimalFormat("#.00")
    df.format(input)
  }
}