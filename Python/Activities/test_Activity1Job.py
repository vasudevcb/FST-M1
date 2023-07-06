import time
import pytest

@pytest.mark.usefixtures("setup1")
class TestPageTitle:
    def test_title_page(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        time.sleep(5)
        assert driver.title == "Alchemy Jobs – Job Board Application"