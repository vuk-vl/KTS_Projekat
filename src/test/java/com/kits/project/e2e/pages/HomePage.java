package com.kits.project.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, '/')]")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(@href, '/lines-map')]")
    private WebElement linesMapLink;

    @FindBy(xpath = "//li[3]/a")
    private WebElement linesLink;

    @FindBy(xpath = "//a[contains(@href, '/live-location')]")
    private WebElement liveLocationLink;

    //@FindBy(xpath = "//a[contains(@href, '/tickets')]")
    @FindBy(id = "ticketsLink")
    private WebElement ticketsLink;

    @FindBy(id = "timeSchedule")
    private WebElement timeSchedule;

    @FindBy(xpath = "//a[contains(@href, '/showpricelist')]")
    private WebElement showPriceListLink;

    @FindBy(xpath = "//a[contains(@href, '/pricelist')]")
    private WebElement priceListLink;

    @FindBy(xpath = "//a[contains(@href, '/stations')]")
    private WebElement stationsLink;

    @FindBy(css = "li.navbar-personal-dropdown.ng-star-inserted > a")
    private WebElement logoutDropdown;

    @FindBy(xpath = "//a[contains(text(),'Sign out')]")
    private WebElement signoutLink;

    @FindBy(xpath = "//a[contains(text(), 'Dashboard')]")
    private WebElement dashboardLink;

    @FindBy(css = "img.bus")
    private WebElement bus;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(WebElement homeLink) {
        this.homeLink = homeLink;
    }

    public WebElement getTicketsLink() {
        return ticketsLink;
    }

    public void setTicketsLink(WebElement ticketsLink) {
        this.ticketsLink = ticketsLink;
    }

    public WebElement getShowPriceListLink() {
        return showPriceListLink;
    }

    public void setShowPriceListLink(WebElement showPriceListLink) {
        this.showPriceListLink = showPriceListLink;
    }

    public WebElement getTimeScheduleLink() {
        return timeSchedule;
    }

    public void setTimeScheduleLink(WebElement timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    public WebElement getPriceListLink() {
        return priceListLink;
    }

    public void setPriceListLink(WebElement priceListLink) {
        this.priceListLink = priceListLink;
    }

    public WebElement getStationsLink() {
        return stationsLink;
    }

    public void setStationsLink(WebElement stationsLink) {
        this.stationsLink = stationsLink;
    }

    public WebElement getLinesLink() {
        return linesLink;
    }

    public void setLinesLink(WebElement linesLink) {
        this.linesLink = linesLink;
    }

    public WebElement getLiveLocationLink() {
        return liveLocationLink;
    }

    public void setLiveLocationLink(WebElement liveLocationLink) {
        this.liveLocationLink = liveLocationLink;
    }

    public WebElement getLinesMapLink() {
        return linesMapLink;
    }

    public void setLinesMapLink(WebElement linesMapLink) {
        this.linesMapLink = linesMapLink;
    }

    public WebElement getSignoutLink() {
        return signoutLink;
    }

    public void setSignoutLink(WebElement signoutLink) {
        this.signoutLink = signoutLink;
    }

    public WebElement getLogoutDropdown() {
        return logoutDropdown;
    }

    public void setLogoutDropdown(WebElement logoutDropdown) {
        this.logoutDropdown = logoutDropdown;
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public void setDashboardLink(WebElement dashboardLink) {
        this.dashboardLink = dashboardLink;
    }

    public void priceListLinkIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(priceListLink));
    }

    public void linesLinkIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(linesLink));
    }

    public void ticketsLinkIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(ticketsLink));
    }

    public void stationsLinkIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(stationsLink));
    }

    public void linesMapLinkIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(linesMapLink));
    }

    public void busIsDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(bus));
    }

    public void logoutDropdownDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(logoutDropdown));
    }

    public void logoutDropDownClickable() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(logoutDropdown));
    }

    public void logoutLinkClickable() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(signoutLink));
    }

    public void ticketLinkIsClickable() {
        (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions.elementToBeClickable(ticketsLink));
    }

    public void ensureBusIsVisible() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(bus));
    }
    public boolean adminLinksVisible(){
        try {
            this.getStationsLink().isEnabled();
            this.getLinesLink().isEnabled();
            this.getPriceListLink().isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
