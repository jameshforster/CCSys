package models

import org.scalatest.FlatSpec

class ItemTest extends FlatSpec{
  
  findAllTest
  def findAllTest {
     "Full List" should "not be empty" in {
       assert(!Item.findAll.isEmpty)
     }
     
     "Full List" should "contain Item entities" in {
       assert(Item.findAll.isInstanceOf[List[Item]])
     }
     
     "Full List" should "contain non-null entities" in {
       assert(Item.findAll.head != null)
     }
  }
  
  findByIDTest
  def findByIDTest {
    "Result" should "not be null with a valid query" in {
      assert(Item.findByID(1) != null)
    }
    
    "Result" should "be empty with an invalid query" in {
      assert(Item.findByID(0).isEmpty)
    }
  }
  
  findByFilterTest
  def findByFilterTest {
    "Result" should "contain one entry with a valid ID" in {
      assert(Item.findByFilter("1").length == 1)
    }
    
    "Result" should "be empty with invalid search term" in {
      assert(Item.findByFilter("0").isEmpty)
    }
    
    "Result" should "not be empty with valid search term" in {
      assert(!Item.findByFilter("King").isEmpty)
    }
    
    "Result" should "not be empty as long as one search term is valid" in {
      assert(!Item.findByFilter("zdvce 2").isEmpty)
    }
  }
}