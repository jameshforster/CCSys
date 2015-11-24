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
      Item(4, "Princess Gnome", 3, 150.00),
      Item(5, "Small Jacuzzi", 1, 500.00),
      Item(6, "Oak Jacuzzi", 2, 750.00),
      Item(7, "Lost Elf", 99, 0.99))
      
  def findAll = items.toList.sortBy(_.itemID)
  
  def findByID(inputID:Int) = items.find(_.itemID == inputID)
  
  def formatPrice(input: Double):String = {
    import java.text.DecimalFormat
    val df = new DecimalFormat("#0.00")
    df.format(input)
  }
  
  def findByFilter(input: String) = {
    
   var resultList:Set[Item] = Set[Item]()
   queryLoop(input.split(" "))
   
   def queryLoop(terms: Array[String]) {
     if(!terms.isEmpty) {
        val term = terms.head
        try {
          val intInput = Integer.parseInt(term)
          resultList = resultList ++ findByID(intInput)
        }
        catch {
          case nfe: NumberFormatException => {resultList = resultList ++ findByName(term)}
        }
         
         def findByName(input:String) = items.filter(_.itemName.toLowerCase().contains(input.toLowerCase()))
         
         queryLoop(terms.tail)
       }
     }
     resultList.toList.sortBy(_.itemID)
   }
}