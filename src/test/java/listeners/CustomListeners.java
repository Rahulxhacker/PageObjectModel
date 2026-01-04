/*
 * package listeners;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException; import java.io.InputStream;
 * 
 * import org.testng.ITestListener; import org.testng.ITestResult;
 * 
 * import Base.TestBase; import io.qameta.allure.Allure;
 * 
 * public class CustomListeners extends TestBase implements ITestListener {
 * 
 * InputStream is;
 * 
 * public void onTestFailure(ITestResult result) { // not implemented
 * 
 * TestBase bs = new TestBase(); try { bs.captureScreenShot(result.getName()); }
 * catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * try { is = new
 * FileInputStream("C:\\Users\\Rahul Kashyap\\Downloads\\failed.jpg"); } catch
 * (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * Allure.addAttachment("Failed ScreenShot", is);
 * 
 * }
 * 
 * }
 */