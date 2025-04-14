package stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDefs {
	
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage chkoutPage;
	
	public OrderStepDefs() {
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		chkoutPage = new CheckOutPage(driver);
	}
	
	
	@Given("User in on login page")
	public void user_in_on_login_page() {
		TestBase.openUrl("https://www.saucedemo.com/");
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) {
		loginPage.loginIntoApp(strUser, strPwd);
	    
	}
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
	    Assert.assertTrue(loginPage.isOnProducts());
	}
	
	@When("User add item to cart")
	public void user_add_item_to_cart() {
		listPage.addItemsToCart();
	    
	}
	@Then("Item must be added")
	public void item_must_be_added() {
	    listPage.viewCart();
	    Assert.assertTrue(cartPage.isItemsAdded());
	}

	@Given("Cart must have items")
	public void cart_must_have_items() {
		listPage.viewCart();
		cartPage.isItemsAdded();
	}
	
	@When("user delete an item")
	public void user_delete_an_item() {
		cartPage.removeItems();
		cartPage.removeItems();
	    
	}
	
	@Then("Should delete item from cart")
	public void should_delete_item_from_cart() {
		Assert.assertTrue(cartPage.IsItemremoved());
	   
	}
	
	@Given("User is on cart page")
	public void user_is_on_cart_page() {
		listPage.viewCart();
	}
	
	@When("User do checkout")
	public void user_do_checkout() {
		cartPage.checkOutItems();
	    
	}
	
	@Then("Should navigate to Checkout page")
	public void should_navigate_to_checkout_page() {
		chkoutPage.ProvideUserDetails("Automation", "user1242", "132452");
		chkoutPage.contiueCheckOut();
		chkoutPage.finishOrder();
		chkoutPage.isOrderSuccess();
	}
}
