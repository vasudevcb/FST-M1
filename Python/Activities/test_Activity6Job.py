import requests
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from bs4 import BeautifulSoup

@pytest.mark.usefixtures("setup1")
class TestNavigateJob:
    def test_navigate_job(self):
        driver = self.driver
        driver.maximize_window()
        req = requests.get("https://alchemy.hguy.co/jobs/jobs/")
        data = BeautifulSoup(req.text, 'html')
        # creating request object
        driver.get("https://alchemy.hguy.co/jobs")
        driver.find_element(By.XPATH, "//li[@id='menu-item-24']/a").click()
        # assert driver.title == "Jobs – Alchemy Jobs"
        print("The page title is : " + driver.title);

        searchKeyword = driver.find_element(By.XPATH, "//div[@class='search_keywords']/input[@id='search_keywords']");
        searchKeyword.clear();
        searchKeyword.send_keys("Banking");

        searchBtn = driver.find_element(By.XPATH, "//div[@class='search_submit']/input[@type='submit']");
        searchBtn.click();

        searchVal="banking";
        action = ActionChains(driver);

#        jobListing = driver.find_elements(By.XPATH, "//ul[@class='job_listings']/li");
#       #listItems = jobListing.find_elements_by_tag_name("li");
#        listItems = jobListing.find_elements(By.TAG_NAME,"li")
#        for li in jobListing:
#            print(li.text)
        htmlContext = req.content
#        print(htmlContext)
        soup = BeautifulSoup(htmlContext,'html5lib')
#        listall = soup.find_all("ul", class_="job_listings");
        listall = soup.find_all('h3');
#        print(listall)

