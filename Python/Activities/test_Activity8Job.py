import time

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
        #time.sleep(5)
        userLogin = driver.find_element(By.ID, "wpadminbar");
        userValue = driver.find_element(By.XPATH, "//ul[@id='wp-admin-bar-top-secondary']//a").text;
        if userValue == "root":
            print("User logged in Successfully");

