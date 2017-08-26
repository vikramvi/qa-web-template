package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(xpath = "//button[contains(@type,'submit') and  contains(@value,'Search')]")
    WebElementFacade searchButton;

    //TBD: Why WebElementFacade needs to be used instead of WebElement
    @FindBy(xpath = "//h1[contains(@class,'display-inline text-smaller')]" )
    WebElement allCategoriesSearchTextHeader;

    @FindBy(xpath="//a[@data-url-with-anchor ='https://www.etsy.com/c/toys-and-games?anchor_listing_id=544894349&ref=hp']/div/picture")
    WebElement shopByCategoryIconToysGames;

    @FindBy(xpath="//div[@id='content']//a[@class='text-gray-lighter'][2]")
    WebElement shopByCategoryIconSearchPageHeaderText;

    //Header Menu
    @FindBy(xpath="//div[@id='cnav-header']//a[text()='Kids & Baby']")
    WebElement menuKidsBaby;

    //Menu Items
    @FindBy(xpath="//div[7]//ul[1]//a[text()='Baby & Child Care']")
    WebElement menuItemBabyChildCare;

    @FindBy(xpath="//div[@id='content']//h1")
    WebElement menuItemSearchPageResultHeader;

    //TBD = To Be Done by self/ Discussed with team/ Debugged by self/with team

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public String getTopCategoriesHeader() {
        //TBD: remove hard coding of locator
        return find(By.cssSelector("h4.pb-xs-1-5")).getText();
    }

    public String getAllCategoriesHeader() {
        //TBD: remove hard coding of locator
        //return find(By.cssSelector("h1.conform-heading.display-inline")).getText();
        return allCategoriesSearchTextHeader.getText();
    }

    public void clickShopByCategoryIcon(String iconName){
        try {
            switch (iconName) {
                case "Toys & Games":
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("//span[@class='vesta-hp-category-default']")));
                    Thread.sleep(1000);

                    //TBD Not working ??
                    //getDriver().findElement(By.xpath("//h2[contains(.,'Shop by category')]")).click();
                    //shopByCategoryIconToysGames.click();

                    //TBD Not working ??
                    //Actions action = new Actions(getDriver());
                    //action.moveToElement(shopByCategoryIconToysGames).perform();
                    //action.moveToElement(shopByCategoryIconToysGames).click().build().perform();

                    //TBD serenity bug ??
                    //((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", shopByCategoryIconToysGames);

                    //Working
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getDriver().findElement( By.xpath("//a[@data-url-with-anchor ='https://www.etsy.com/c/toys-and-games?anchor_listing_id=544894349&ref=hp']/div/picture") ));

                    break;

                default:
                    System.out.println("INVALID INPUT FOR Shop By Category Icon Name");

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getShopByCategoryIconSearchResultsPageHeader(){
        return shopByCategoryIconSearchPageHeaderText.getText();
    }

    public void clickMenuItemUnderMenu(String menuName, String menuItemName){
        try {
            switch(menuName) {
                case "Kids & Baby":
                    Actions action = new Actions(getDriver());
                    action.moveToElement(menuKidsBaby).build().perform();
                    Thread.sleep(2000);
                    action.moveToElement(menuItemBabyChildCare).click().build().perform();
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getMenuItemSearchResultsPageHeader(){
        return menuItemSearchPageResultHeader.getText();
    }
}
