import pytest
from selenium.webdriver.common.by import By

@pytest.mark.usefixtures("setup1")
class TestSecondHeader:
    def test_second_header(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        getH2Txt = driver.find_element(By.XPATH, "//div[@class='entry-content clear']")
        assert (getH2Txt.find_element(By.XPATH,"//h2").text) == "Quia quis non"