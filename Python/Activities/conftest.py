import pytest
from selenium import webdriver
from selenium.webdriver.common import keys
from selenium.webdriver.common.by import By
# Create a fixture to initialize our webdriver
@pytest.fixture(scope="session")
def setup1(request):
    # Initialize the webdriver
    driver = webdriver.Firefox()
    # Get the underlying collection
    session = request.node
    # Pass through the driver to the test class
    for item in session.items:
        cls = item.getparent(pytest.Class)
    setattr(cls.obj, "driver", driver)
# Execute the test method
    yield
# Close the browser once the test has ended
    request.addfinalizer(driver.close)