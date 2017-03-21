package com.redhat.qe;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Binder;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class DependencyInjectionModule extends AbstractModule {
  Configuration config = null;

  @Override
  protected void configure (){
    System.out.println("module is configured");
  }

  @Provides
  Configuration getConfigurationFromPropertiesFile () {
    System.out.println("getConfigurationFromPropertiesFile");
    Parameters params = new Parameters();
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder
      = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
      .configure(params.properties().setFileName("automation.properties"));

    if( config == null ){
      try {
        config = builder.getConfiguration();
      } catch (ConfigurationException ex) {
      }
    }
    System.out.println(config);
    return config;
  }
}
