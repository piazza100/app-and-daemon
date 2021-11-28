package com.piazza.app.batch;

import com.piazza.app.domain.AppVO;
import com.piazza.app.service.AppService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world! > https://www.guru99.com/first-webdriver-script.html
 *
 */
@Component
public class DailyApp {
	@Autowired
	private AppService appService;

	private void checkTopSellingFree(WebDriver driver) {
		driver.get("https://play.google.com/store/apps/collection/topselling_free");
		driver.manage().window().maximize();
		List<WebElement> cardList = null;
		do {
			cardList = driver.findElements(By.className("card"));

			// 스크롤 내리기
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			js.executeScript("window.scrollBy(0,100)");

			if ("block".equals(driver.findElement(By.id("show-more-button")).getCssValue("display"))) {
				driver.findElement(By.id("show-more-button")).click();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		} while (driver.findElements(By.className("card")).size() < 540);

		// cardList = driver.findElements(By.className("card"));// TODO TEST
		for (int i = 0; i < cardList.size(); i++) {
			String title = cardList.get(i).findElement(By.className("title")).getAttribute("title");
			String href = cardList.get(i).findElement(By.className("title")).getAttribute("href");
			String id = href.substring(href.indexOf("id="), href.length()).replace("id=", "");
			String price = "0";
			System.out.println(id + "|" + title + "|" + price);// https://play.google.com/store/apps/details?id={id}
		}

		// driver.close();
	}

	private void checkTopSellingPaid(WebDriver driver) {
		driver.get("https://play.google.com/store/apps/collection/topselling_paid");
		driver.manage().window().maximize();
		List<WebElement> cardList = null;
		do {
			cardList = driver.findElements(By.className("card"));

			// 스크롤 내리기
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			js.executeScript("window.scrollBy(0,100)");

			if ("block".equals(driver.findElement(By.id("show-more-button")).getCssValue("display"))) {
				driver.findElement(By.id("show-more-button")).click();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		} while (driver.findElements(By.className("card")).size() < 540);

		// cardList = driver.findElements(By.className("card"));// TODO TEST
		for (int i = 0; i < cardList.size(); i++) {
			String title = cardList.get(i).findElement(By.className("title")).getAttribute("title");
			String href = cardList.get(i).findElement(By.className("title")).getAttribute("href");
			String id = href.substring(href.indexOf("id="), href.length()).replace("id=", "");
			if (cardList.get(i).findElements(By.className("display-price")).size() > 0) {
				String displayPrice = cardList.get(i).findElements(By.className("display-price")).get(1).getText().replaceAll("₩", "").replaceAll(",", "");
				String fullPrice = cardList.get(i).findElements(By.className("full-price")).size() > 0 ? cardList.get(i).findElements(By.className("full-price")).get(1).getText().replaceAll("₩", "").replaceAll(",", "") : displayPrice;
				// 힐인
				if (!fullPrice.equals(displayPrice)) {
					System.out.println(id + "|" + title + "|" + fullPrice + "|" + displayPrice);
				} else {
					// System.out.println(id + "|" + title + "|" + fullPrice + "|" + displayPrice);
				}
			} else {
				// 무료
				System.out.println(id + "|" + title + "|" + 0 + "|" + 0);
			}
			// https://play.google.com/store/apps/details?id={id}
		}

		driver.close();
	}

	private void checkAnd(String threadId, WebDriver driver, String url) {
		LinkedList<String> letterList = new LinkedList<String>();
		letterList.add("A");
		letterList.add("B");
		letterList.add("C");

		List<AppVO> urlList = new ArrayList<AppVO>();
		for (int i = 0; i < letterList.size(); i++) {
			if (i > 0) {
				url = url.replaceAll("letter=" + letterList.get(i - 1), "letter=" + letterList.get(i));
			}
			driver.get(url);
			this.getUrlList(threadId, driver, urlList);
		}

		// 모든 url 에 대해, url 호출한다.
		System.out.println(urlList.size());
		if (urlList.size() > 0) {
			for (AppVO appVo : urlList) {
//				try {
//					Connection.Response response = Jsoup.connect(appVo.getUrl()).method(Connection.Method.GET).execute();
//					Document document = response.parse();
//					Element element = document.select(".product-header__list__item").last();
//					String price = element.text().replaceAll("￦", "").replaceAll(",", "");
//					String name = document.selectFirst(".product-header__title").text();
//					appVo.setType("I");
//					appVo.setName(name);
//					appVo.setCategory(threadId);
//					appVo.setFullPrice(price);
//					appVo.setDisplayPrice(price);
//					System.out.println("threadId = " + threadId + "|" + appVo.getAppId() + "|" + appVo.getFullPrice());
//					
//					try {
//						AppVO resultAppVo = this.appService.getApp(appVo);
//						if(resultAppVo == null) {
//							this.appService.addApp(appVo);
//						}else {
//							if(!resultAppVo.getDisplayPrice().equals(price)) {
//								this.appService.updateAppHis(resultAppVo);
//								this.appService.addAppHis(resultAppVo);
//								this.appService.updateApp(appVo);
//							}
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
		driver.close();
	}

	private void getUrlList(String threadId, WebDriver driver, List<AppVO> urlList) {
		// MAP 에 모든 PAGE 에 대해서 넣는다. > '다음' 버튼이 없어질 때 까지 .. 반복
		while (true) {
			List<WebElement> appList = driver.findElements(By.cssSelector("#selectedcontent li a"));
			for (int i = 0; i < appList.size(); i++) {
				String title = appList.get(i).getAttribute("text");
				String href = appList.get(i).getAttribute("href");
				String id = href.substring(href.lastIndexOf("/") + 1, href.indexOf("?") >= 0 ? href.indexOf("?") : href.length());

				AppVO appVo = new AppVO();
				appVo.setAppId(id);
				appVo.setName(title);
				appVo.setUrl(href);
				urlList.add(appVo);

				// TODO TEST
//				 if (i >= 6) {
//				 break;
//				 }
			}
//			System.out.println("threadId = " + threadId + "|urlList = " + urlList.size());
			if (driver.findElements(By.cssSelector(".paginate")).get(0).findElements(By.partialLinkText("다음")).size() <= 0) {
				break;
			} else {
				driver.findElements(By.cssSelector(".paginate-more")).get(0).click();
			}
//			break;// TODO TEST
		}
	}

	class ThreadTaskHeadLess implements Runnable {
		private String id;
		private String url;

		public ThreadTaskHeadLess(String id, String url) {
			this.id = id;
			this.url = url;
		}

		public void run() {
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--headless");
//			WebDriver driver = new ChromeDriver(chromeOptions);
			WebDriver driver = new ChromeDriver();
			checkAnd(this.id, driver, this.url);
		}
	}


	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\util\\PROJECT_BOOT\\app-and-daemon\\src\\main\\lib\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 // AND
		 checkTopSellingPaid(driver);
//		 checkTopSellingFree(driver);
		 
//		 ExecutorService execService = Executors.newFixedThreadPool(4);


		// IOS
//		ExecutorService execService = Executors.newFixedThreadPool(1);
//		execService.execute(new ThreadTaskHeadLess("GAME_ARCADE", "https://play.google.com/store/apps/category/GAME_ARCADE"));//threadId > category ID 로 변경 및 DB INSERT 필요.
//		execService.execute(new ThreadTaskHeadLess("생산성", "https://itunes.apple.com/kr/genre/ios-생산성/id6007?mt=8&letter=A"));
//		execService.execute(new ThreadTaskHeadLess("도서", "https://itunes.apple.com/kr/genre/ios-도서/id6018?mt=8&letter=A"));
//		execService.execute(new ThreadTaskHeadLess("게임", "https://itunes.apple.com/kr/genre/ios-게임/id6014?mt=8&letter=A"));
//		execService.shutdown();
	}

	public static void main(String[] args) {
		DailyApp app = new DailyApp();
		app.start();
	}
}
