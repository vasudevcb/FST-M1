import pytest
from selenium.webdriver.common.by import By

@pytest.mark.usefixtures("setup1")
class TestHeaderImage:
    def test_header_image(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://alchemy.hguy.co/jobs")
        getImgSrc = driver.find_element(By.XPATH, "//img[contains(@class, 'attachment-large size-large wp-post-image')]")
        print(getImgSrc.get_attribute('src'))

