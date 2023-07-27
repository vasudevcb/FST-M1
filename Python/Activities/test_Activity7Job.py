import time

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

@pytest.mark.usefixtures("setup1")
class TestCreateNewJob:
    def test_navigate_job(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        driver.find_element(By.XPATH, "//li[@id='menu-item-26']/a").click()
        #assert driver.title == "Jobs – Alchemy Jobs"
        yourEmailID = driver.find_element(By.XPATH, "//input[@id='create_account_email']");
        yourEmailID.clear();
        yourEmailID.send_keys("test1@yahoo.com");

        jobTitle = driver.find_element(By.XPATH, "//input[@id='job_title']");
        jobTitle.clear();
        jobTitle.send_keys("Software Tester");

        jobLocation = driver.find_element(By.XPATH, "//input[@id='job_location']");
        jobLocation.clear();
        jobLocation.send_keys("India");

        jobType = Select(driver.find_element(By.ID, "job_type"));
        #Select jobTypeSelect = new Select(jobType);
        jobType.select_by_index("3");

        driver.find_element(By.XPATH, "//iframe[@id='job_description_ifr']").click();
        driver.find_element(By.XPATH, "//iframe[@id='job_description_ifr']").send_keys("Testing");
        appEmailUrl = driver.find_element(By.ID, "application");
        appEmailUrl.clear();
        appEmailUrl.send_keys("test@gmail.com");

        # Company Details
        cmpName = driver.find_element(By.XPATH, "//input[@id='company_name']");
        cmpName.clear();
        cmpName.send_keys("IBM");
        cmpWebsite = driver.find_element(By.XPATH, "//input[@id='company_website']");
        cmpWebsite.clear();
        cmpWebsite.send_keys("www.ibm.com/india");
        cmpTagLine = driver.find_element(By.XPATH, "//input[@id='company_tagline']");
        cmpTagLine.clear();
        cmpTagLine.send_keys("The Big BLUE");
        cmpVideo = driver.find_element(By.XPATH, "//input[@id='company_video']");
        cmpVideo.clear();
        cmpVideo.send_keys("www.ibm.com");
        cmpTwitter = driver.find_element(By.XPATH, "//input[@id='company_twitter']");
        cmpTwitter.clear();
        cmpTwitter.send_keys("ibmtwiter@ibm.com");
        cmpLogo = driver.find_element(By.XPATH, "//input[@id='company_logo']");
        cmpLogo.send_keys("C:\\Users\\022346744\\Desktop\\logo.jpg");
        inputSubmit = driver.find_element(By.XPATH, "//input[@type='submit']");
        inputSubmit.click();
        time.sleep(5);
        submitListing = driver.find_element(By.XPATH, "//input[@id='job_preview_submit_button']");
        submitListing.click();

        # After Submitting the data re-verify
        driver.find_element(By.XPATH, "//li[@id='menu-item-24']/a").click();
        time.sleep(5)

        searchKeyword = driver.find_element(By.XPATH, "//div[@class='search_keywords']/input[@id='search_keywords']");
        searchKeyword.clear();
        searchKeyword.send_keys("Software Tester");
        searchBtn = driver.find_element(By.XPATH, "//div[@class='search_submit']/input[@type='submit']");
        searchBtn.click();
