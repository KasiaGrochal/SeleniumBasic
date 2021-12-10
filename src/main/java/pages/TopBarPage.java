package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basic.*;
import pages.basic.tablePage.TablePage;
import pages.interactions.*;
import pages.others.HighSitePage;
import pages.widgets.*;

public class TopBarPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(TopBarPage.class);

    public TopBarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-ite")
    private WebElement topMenuBasicDropdown;

    @FindBy(css = ".nav-ite.dropdown .dropdown-menu")
    private WebElement basicDropdownMenu;

    @FindBy(css = "#iframes-item")
    private WebElement iFramesButton;

    @FindBy(css = "#alerts-item")
    private WebElement alertsButton;

    @FindBy(css = "#form-item")
    private WebElement formButton;

    @FindBy(css = "#table-item")
    private WebElement tableButton;

    @FindBy(css = "#windows-tabs-item")
    private WebElement windowsTabsButton;

    @FindBy(css = "[class='nav-item dropdown']:nth-child(3)")
    private WebElement widgetsDropDownMenu;

    @FindBy(css = "#accordion-item")
    private WebElement accordionButton;

    @FindBy(css = "#slider-item")
    private WebElement sliderButton;

    @FindBy(css = "#tooltip-item")
    private WebElement tooltipButton;

    @FindBy(css = "[class='nav-item dropdown']:nth-child(2)")
    private WebElement interactionsDropDownMenu;

    @FindBy(css = "#draggable-item")
    private WebElement draggableButton;

    @FindBy(css = "#droppable-item")
    private WebElement droppableButton;

    @FindBy(css = "#resizable-item")
    private WebElement resizableButton;

    @FindBy(css = "#selectable-item")
    private WebElement selectableButton;

    @FindBy(css = "#autocomplete-item")
    private WebElement autocompleteButton;

    @FindBy(css = "#datepicker-item")
    private WebElement datepickerButton;

    @FindBy(css = "#menu-item")
    private WebElement menuButton;

    @FindBy(css = "#modal-dialog-item")
    private WebElement modalDialogButton;

    @FindBy(css = "#progressbar-item")
    private WebElement progressBarButton;

    @FindBy(css = "#selectmenu-item")
    private WebElement selectMenuButton;

    @FindBy(css = "#sortable-item")
    private WebElement sortableButton;

    @FindBy(css = "[class='nav-item dropdown']:nth-child(4)")
    private WebElement topMenuOthersDropdown;

    @FindBy(css = "#high-site-item")
    private WebElement highSiteButton;


    public TopBarPage clickOnTopMenuBasicButton() {
        topMenuBasicDropdown.click();
        logger.info("Clicked on top menu 'Basic' button");
        return this;
    }

    public boolean checkIfBasicDropDownMenuIsDisplayed() {
        boolean display = basicDropdownMenu.isDisplayed();
        logger.info("Is dropdown menu visible, result: {}", display);
        return display;
    }

    public IframesPage clickOnIframesButton() {
        waitForWebElementToBeClickable(iFramesButton);
        iFramesButton.click();
        logger.info("Clicked on 'Iframes' button from Basic Dropdown Menu");
        logger.info("Navigating to IframesPage");
        return new IframesPage(driver);
    }

    public AlertsPage clickOnAlertsButton() {
        waitForWebElementToBeClickable(alertsButton);
        alertsButton.click();
        logger.info("Clicked on 'Alerts' button from Basic Dropdown Menu");
        logger.info("Navigating to AlertsPage");
        return new AlertsPage(driver);
    }


    public FormPage clickOnFormButton() {
        waitForWebElementToBeClickable(formButton);
        formButton.click();
        logger.info("Clicked on 'Form' button from Basic Dropdown Menu");
        logger.info("Navigating to FormPage");
        return new FormPage(driver);
    }

    public TablePage clickOnTableButton() {
        waitForWebElementToBeClickable(tableButton);
        tableButton.click();
        logger.info("Clicked on 'Table' button from Basic Dropdown Menu");
        logger.info("Navigating to TablePage");
        return new TablePage(driver);
    }

    public WindowsTabsPage clickOnWindowsTabsButton() {
        waitForWebElementToBeClickable(windowsTabsButton);
        windowsTabsButton.click();
        logger.info("Clicked on 'Windows/Tabs' button from Basic Dropdown Menu");
        logger.info("Navigating to WindowsTabsPage");
        return new WindowsTabsPage(driver);
    }

    public TopBarPage clickOnTopMenuWidgetsButton() {
        widgetsDropDownMenu.click();
        logger.info("Clicked on top menu 'Widgets' button");
        return this;
    }

    public AccordionPage clickOnAccordionButton() {
        waitForWebElementToBeClickable(accordionButton);
        accordionButton.click();
        logger.info("Clicked on 'Accordion' button from Widgets Dropdown Menu");
        logger.info("Navigating to AccordionPage");
        return new AccordionPage(driver);
    }

    public AutocompletePage clickOnAutocompleteButton() {
        waitForWebElementToBeClickable(autocompleteButton);
        autocompleteButton.click();
        logger.info("Clicked on 'Autocomplete' button from Widgets Dropdown Menu");
        logger.info("Navigating to AutoCompletePage");
        return new AutocompletePage(driver);
    }

    public DatepickerPage clickOnDatepickerButton() {
        waitForWebElementToBeClickable(datepickerButton);
        datepickerButton.click();
        logger.info("Clicked on 'Datepicker' button from Widgets Dropdown Menu");
        logger.info("Navigating to DatepickerPage");
        return new DatepickerPage(driver);
    }

    public MenuPage clickOnMenuButton() {
        waitForWebElementToBeClickable(menuButton);
        menuButton.click();
        logger.info("Clicked on 'Menu' button from Widgets Dropdown Menu");
        logger.info("Navigating to MenuPage");
        return new MenuPage(driver);
    }

    public ModalDialogPage clickOnModalDialogButton() {
        waitForWebElementToBeClickable(modalDialogButton);
        modalDialogButton.click();
        logger.info("Clicked on 'ModalDialog' button from Widgets Dropdown Menu");
        logger.info("Navigating to ModalDialogPage");
        return new ModalDialogPage(driver);
    }

    public ProgressBarPage clickOnProgressBarButton() {
        waitForWebElementToBeClickable(progressBarButton);
        progressBarButton.click();
        logger.info("Clicked on 'Progressbar' button from Widgets Dropdown Menu");
        logger.info("Navigating to ProgressBarPage");
        return new ProgressBarPage(driver);
    }

    public SelectMenuPage clickOnSelectMenuButton() {
        waitForWebElementToBeClickable(selectMenuButton);
        selectMenuButton.click();
        logger.info("Clicked on 'Selectmenu' button from Widgets Dropdown Menu");
        logger.info("Navigating to SelectMenuPage");
        return new SelectMenuPage(driver);
    }

    public SliderPage clickOnSliderButton() {
        waitForWebElementToBeClickable(sliderButton);
        sliderButton.click();
        logger.info("Clicked on 'Slider' button from Widgets Dropdown Menu");
        logger.info("Navigating to SliderPage");
        return new SliderPage(driver);
    }

    public TooltipPage clickOnTooltipButton() {
        waitForWebElementToBeClickable(tooltipButton);
        tooltipButton.click();
        logger.info("Clicked on 'Tooltip' button from Widgets Dropdown Menu");
        logger.info("Navigating to TooltipPage");
        return new TooltipPage(driver);
    }

    public TopBarPage clickOnTopMenuInteractionsButton() {
        interactionsDropDownMenu.click();
        logger.info("Clicked on top menu 'Interactions' button");
        return this;
    }

    public TopBarPage clickOnTopMenuOthersButton() {
        topMenuOthersDropdown.click();
        logger.info("Clicked on top menu 'Other' button");
        return this;
    }

    public HighSitePage clickOnHighSiteButton(){
        waitForWebElementToBeClickable(highSiteButton);
        highSiteButton.click();
        logger.info("Clicked on 'High site' button");
        logger.info("Navigating to HighSitePage");
        return new HighSitePage(driver);
    }

    public DraggablePage clickOnDraggableButton() {
        waitForWebElementToBeClickable(draggableButton);
        draggableButton.click();
        logger.info("Clicked on 'Draggable' button from Interactions Dropdown Menu");
        logger.info("Navigating to DraggablePage");
        return new DraggablePage(driver);
    }

    public DroppablePage clickOnDroppableButton() {
        waitForWebElementToBeClickable(droppableButton);
        droppableButton.click();
        logger.info("Clicked on 'Droppable' button from Interactions Dropdown Menu");
        logger.info("Navigating to DroppablePage");
        return new DroppablePage(driver);
    }

    public ResizablePage clickOnResizableButton() {
        waitForWebElementToBeClickable(resizableButton);
        resizableButton.click();
        logger.info("Clicked on 'Resizable' button from Interactions Dropdown Menu");
        logger.info("Navigating to ResizablePage");
        return new ResizablePage(driver);
    }

    public SelectablePage clickOnSelectableButton() {
        waitForWebElementToBeClickable(selectableButton);
        selectableButton.click();
        logger.info("Clicked on 'Selectable' button from Interactions Dropdown Menu");
        logger.info("Navigating to SelectablePage");
        return new SelectablePage(driver);
    }

    public SortablePage clickOnSortableButton() {
        waitForWebElementToBeClickable(sortableButton);
        sortableButton.click();
        logger.info("Clicked on 'Sortable' button from Interactions Dropdown Menu");
        logger.info("Navigating to SortableePage");
        return new SortablePage(driver);
    }
}
