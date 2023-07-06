import pytest
from selenium.webdriver.common.by import By

@pytest.mark.usefixtures("setup1")
class TestNavigateJob:
    def test_navigate_job(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        driver.find_element(By.XPATH, "//li[@id='menu-item-24']/a").click()
        assert driver.title == "Jobs – Alchemy Jobs"