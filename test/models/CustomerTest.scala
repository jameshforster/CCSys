package models

import org.scalatest.FlatSpec

/**
 * @author jforster
 */
class CustomerTest extends FlatSpec{
  
  findAllTest
  def findAllTest {
    "Full List" should "not be empty" in {
      assert(!Customer.findAll().isEmpty)
    }
    
    "Full List" should "contain Customer entities" in {
      assert(Customer.findAll().isInstanceOf[List[Customer]])
    }
    
    "Full List" should "contain non null objects" in {
      assert(Customer.findAll().head != null)
    }
  }
  
  queryLoopTest
  def queryLoopTest {
    "Result" should "contain one entry with valid ID" in {
      assert(Customer.findByFilter("1").length == 1)
    }
    
    "Result" should "be empty with invalid search term" in {
      assert(Customer.findByFilter("0").isEmpty)
    }
    
    "Result" should "not be empty with valid search term" in {
      assert(!Customer.findByFilter("Brook").isEmpty)
    }
    
    "Result" should "not be empty as long as one search term is valid" in {
      assert(!Customer.findByFilter("Zcfscw 2").isEmpty)
    }
  }
}