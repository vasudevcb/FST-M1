import requests
from bs4 import BeautifulSoup
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

@pytest.mark.usefixtures("setup1")
class TestCreateNewJob:
    def test_navigate_job(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs/wp-login.php")

        userName = driver.find_element(By.ID, "user_login");
        userPwd = driver.find_element(By.ID, "user_pass");
        userName.send_keys("root");
        userPwd.send_keys("pa$$w0rd");
        driver.find_element(By.XPATH, "//input[@id='wp-submit']").click();
#        print("The current URL is: " + driver.current_url)

        page = requests.get('https://alchemy.hguy.co/jobs/wp-admin/')
        soup = BeautifulSoup(page.content, 'html.parser')
        print(soup.prettify())
#        jobList = soup.find(id='adminmenuwrap')
        #print(jobList)
#        print(jobList.find_all('li'))

#        jobLists = driver.find_element(By.XPATH, "//div[@class='wp-menu-name']")
#        print(jobLists.text)
#        jobLists.click()
#        time.sleep(5)

