package com.Retool.ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestApiGeneratorPage {
////div[@class="column-header-name"]/span
	@FindBy(xpath = "//p[.='Add Column']")
	@CacheLookup
	private WebElement addColumnLink;

	@FindBy(id = "input_name--0")
	@CacheLookup
	private WebElement nameTextField;

	@FindBy(id = "input_name--1")
	@CacheLookup
	private WebElement orderCountTextField;

	@FindBy(id = "input_name--2")
	@CacheLookup
	private WebElement emailTextField;

	@FindBy(id = "input_name--3")
	@CacheLookup
	private WebElement productIdTextField;

	@FindBy(xpath = "//input[@id='input_name--0']/ancestor::div[@class='retool-grid-content' and @data-grid-id='properties____0__body']/descendant::input[@tabindex='-1']")
	@CacheLookup
	private WebElement nameTextFieldDropDown;

	@FindBy(xpath = "//input[@id='input_name--1']/ancestor::div[@class='retool-grid-content' and @data-grid-id='properties____0__body']/descendant::input[@tabindex='-1']")
	@CacheLookup
	private WebElement orderCountTextFieldDropDown;

	@FindBy(xpath = "//input[@id='input_name--2']/ancestor::div[@class='retool-grid-content' and @data-grid-id='properties____0__body']/descendant::input[@tabindex='-1']")
	@CacheLookup
	private WebElement emailTextFieldDropDown;

	@FindBy(xpath = "//input[@id='input_name--3']/ancestor::div[@class='retool-grid-content' and @data-grid-id='properties____0__body']/descendant::input[@tabindex='-1']")
	@CacheLookup
	private WebElement productIdTextFieldDropDown;

	@FindBy(id = "input_api_name--0")
	@CacheLookup
	private WebElement apiNameTextBox;

	@FindBy(id="input_rows--0")
	@CacheLookup
	private WebElement apiRowsTextBox;
	
	public WebElement getApiRowsTextBox() {
		return apiRowsTextBox;
	}

	public void setApiRowsTextBox(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		apiRowsTextBox.sendKeys(val);
	}

	@FindBy(xpath = "//p[.='Generate API']")
	@CacheLookup
	private WebElement generateApiButton;

	public WebElement getGenerateApiButton() {
		return generateApiButton;
	}

	public void setGenerateApiButton(WebElement generateApiButton) {
		this.generateApiButton = generateApiButton;
	}

	public WebElement getApiNameTextBox() {
		return apiNameTextBox;
	}

	public void setApiNameTextBox(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		apiNameTextBox.sendKeys(val);
	}

	public RestApiGeneratorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddColumnLink() {
		return addColumnLink;
	}

	public void setAddColumnLink(WebElement addColumnLink) {
		this.addColumnLink = addColumnLink;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		nameTextField.sendKeys(val);;
	}

	public WebElement getOrderCountTextField() {
		return orderCountTextField;
	}

	public void setOrderCountTextField(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		orderCountTextField.sendKeys(val);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		emailTextField.sendKeys(val);
	}

	public WebElement getProductIdTextField() {
		return productIdTextField;
	}

	public void setProductIdTextField(String val) throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		productIdTextField.sendKeys(val);;
	}

	public WebElement getNameTextFieldDropDown() {
		return nameTextFieldDropDown;
	}

	public void setNameTextFieldDropDown(WebElement nameTextFieldDropDown) {
		this.nameTextFieldDropDown = nameTextFieldDropDown;
	}

	public WebElement getOrderCountTextFieldDropDown() {
		return orderCountTextFieldDropDown;
	}

	public void setOrderCountTextFieldDropDown(WebElement orderCountTextFieldDropDown) {
		this.orderCountTextFieldDropDown = orderCountTextFieldDropDown;
	}

	public WebElement getEmailTextFieldDropDown() {
		return emailTextFieldDropDown;
	}

	public void setEmailTextFieldDropDown(WebElement emailTextFieldDropDown) {
		this.emailTextFieldDropDown = emailTextFieldDropDown;
	}

	public WebElement getProductIdTextFieldDropDown() {
		return productIdTextFieldDropDown;
	}

	public void setProductIdTextFieldDropDown(WebElement productIdTextFieldDropDown) {
		this.productIdTextFieldDropDown = productIdTextFieldDropDown;
	}

}
