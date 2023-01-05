package scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Retool.GenericUtilities.BaseClass;
import com.Retool.ObjectRepository.RestApiGeneratorPage;

public class TestRestApiGeneratorPage extends BaseClass {

	@Test
	public void testWebPage() throws Throwable {

		RestApiGeneratorPage page = new RestApiGeneratorPage(driver);
		page.getNameTextField().click();
		page.setNameTextField("Name");
		page.getNameTextFieldDropDown().click();
		wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//li[.='People']")));
		driver.findElement(By.xpath("//li[.='Full Name']")).click();
		page.getOrderCountTextField().click();
		page.setOrderCountTextField("OrderCount");
		page.getOrderCountTextFieldDropDown().click();
		wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("(//li[.='Numbers'])[2]")));
		driver.findElement(By.xpath("//li[.='Random']")).click();
		page.getEmailTextField().click();
		page.setEmailTextField("Email");
		//wlib.scrollBarAction(driver, 800);
		page.getEmailTextFieldDropDown().click();
		wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("(//li[.='People'])[3]")));
		driver.findElement(By.xpath("(//li[.='Email Address'])[2]")).click();
		page.getProductIdTextField().click();
		page.setProductIdTextField("ProductId");
		page.getProductIdTextFieldDropDown().click();
		wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("(//li[.='Numbers'])[4]")));
		driver.findElement(By.xpath("(//li[.='Product ID'])[2]")).click();
		page.getApiNameTextBox().click();
		page.setApiNameTextBox("orders");
		page.getApiRowsTextBox().click();
		page.setApiRowsTextBox("5");
		page.getGenerateApiButton().click();
	}
}
