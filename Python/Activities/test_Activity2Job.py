import pytest
from selenium.webdriver.common.by import By

@pytest.mark.usefixtures("setup1")
class TestPageHeading:
    def test_page_heading(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        head = driver.find_element(By.CLASS_NAME, "entry-title")
        assert head.text == "Welcome to Alchemy Jobs"


