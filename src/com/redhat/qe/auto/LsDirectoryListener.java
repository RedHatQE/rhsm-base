package com.redhat.qe.auto;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Guice;

import com.google.inject.Inject;
import com.redhat.qe.DependencyInjectionModule;

import org.apache.commons.configuration2.Configuration;
import org.testng.ITestContext;

import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
  This listener prints directories content.
  The content is specified by testng parameter `ls-dirs`

  You can see an example of the usage in `resources/suite.xml`
*/

//@Guice(modules=DependencyInjectionModule.class)
public class LsDirectoryListener implements ITestListener {

  @Inject
  Configuration config;

  // @Inject
  // LsDirectoryListener(Configuration config){
  //   this.config = config;
  // }

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
    printDirs("onTestFailure", result);
  }

	@Override
  public void onTestSkipped(ITestResult result){
  }

	@Override
  public void onTestStart(ITestResult result){
    printDirs("onTestStart",result);
  }

  @Override
  public void onTestSuccess(ITestResult result){
    printDirs("onTestSuccess", result);
  }

  private void printDirs(String prefix, ITestResult result){
    // get 'ls-dirs' parameter;
    System.out.println(prefix + " -- " + result.getName());
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
      //reader.lines().forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
    System.out.print("sm.client.url is: ");
    System.out.println(this.config);
    //System.out.println(config.getProperty("sm.client.url"));
  }
}
