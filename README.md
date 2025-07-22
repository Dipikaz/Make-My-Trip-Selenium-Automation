MakeMyTrip Flight Search Automation ✈️

Overview

This project is a Java-based automation script using Selenium WebDriver to perform a flight search on the MakeMyTrip website. The script automates the process of entering departure and destination cities, handling dynamic suggestion lists, and selecting a travel date from the calendar. It's an excellent example of handling modern, dynamic web components.

Features✨

1. Dynamic Pop-up Handling: Intelligently waits for and closes the initial promotional modal.

2. Auto-Suggestive Dropdowns: Enters city names and selects the correct option from the dynamic suggestion lists that appear.

3. Dynamic Date Selection: Calculates a target date (one month from the current system date) and selects it from the calendar.

4. Robust Waits: Employs WebDriverWait to ensure the script is stable and only interacts with elements after they are visible and clickable, preventing common race condition errors.


Table of Contents

1. Tech Stack

2. Project Structure

3. Prerequisites

4. Installation

5. Expected Outcome



Tech Stack 🛠️

Language: Java

Automation Framework: Selenium WebDriver

Browser Driver: ChromeDriver

Build Tool (Recommended): Maven or Gradle

IDE: Eclipse, IntelliJ IDEA, or VS Code




Project Structure

The project has a straightforward structure with a single class containing the main automation logic.

src

└── com

    └── MakeMyTrip

        └── MakeMyTripAutomation.java


MakeMyTripAutomation.java: The core file that contains the main method and all the Selenium code to drive the browser interactions.


Prerequisites

1. Before running this script, ensure you have the following installed and configured:

2. Java Development Kit (JDK): Version 8 or higher.

3. Selenium WebDriver for Java: The necessary client library for Selenium.

4. Google Chrome: An up-to-date version of the Chrome browser.

5. ChromeDriver: The driver version must match your installed Google Chrome version.


Installation

Follow these steps to get the project running on your local machine.

1. Get the Code: Clone the repository or download the MakeMyTripAutomation.java file.

      git clone <your-repository-url>

2. Set Up Project in IDE:

  1. Open your preferred Java IDE (e.g., Eclipse, IntelliJ).

  2. Create a new Java project and place the MakeMyTripAutomation.java file into the com.MakeMyTrip package.


3. Add Selenium Dependency:

   <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.22.0</version> </dependency>

Alternatively, download the Selenium JAR files and add them to your project's build path manually.


4. Configure ChromeDriver:

Download the appropriate ChromeDriver executable for your OS and Chrome version.

Ensure the path to chromedriver.exe is added to your system's PATH environment variable, or specify the path in the code using System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver.exe");.

5. Run the Script:

Open the MakeMyTripAutomation.java file and run the main method.




Expected Outcome
1. When you execute the script, it will perform the following actions:

2. A new Google Chrome window will open in maximized mode.

3. The browser will navigate to https://www.makemytrip.com/.

4. The script will close the initial pop-up advertisement.

5. "Pune" will be entered and selected as the From city.

6. "Hyderabad" will be entered and selected as the To city.

7. The script will calculate the date one month from today (August 21, 2025) and select it on the calendar.

The script will then complete its execution.














