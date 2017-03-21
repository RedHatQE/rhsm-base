package test;

import org.apache.commons.configuration2.Configuration;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.redhat.qe.DependencyInjectionModule;

//@Guice(modules = DependencyInjectionModule.class)
public class FirstTest {

  @Inject
  Configuration config;

  @Test()
  public void test01(){
    System.out.println("Hello World!");
    System.out.print("config in a test:");
    System.out.println(config);
  }
}
