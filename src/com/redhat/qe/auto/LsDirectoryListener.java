package com.redhat.qe.auto;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class LsDirectoryListener implements ITestListener {

  @Override
  public void onFinish(ITestContext context){
    
  }

  @Override
  public void onStart(ITestContext context){
    
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result){
    
  }

  @Override
  public void onTestFailure(ITestResult result){
    
  }

	@Override
  public void onTestSkipped(ITestResult result){
    
  }

	@Override
  public void onTestStart(ITestResult result){
    // get 'ls-dirs' parameter;
    System.out.println("onTestStart -- " + result.getName());
    String lsDir = result.getTestContext()
      .getCurrentXmlTest()
      .getParameter("ls-dirs");
    String cmd = "ls -al " + lsDir;
    System.out.println(cmd);
    Process p;
    try {
      p = Runtime.getRuntime().exec(cmd);
      p.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      reader.lines().forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      
    }
  }

  @Override
  public void onTestSuccess(ITestResult result){
    System.out.println("onTestSuccess");
  }
}
