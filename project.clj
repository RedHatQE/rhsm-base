(defproject rhsm-base "0.1.0-SNAPSHOT"
  :description "The Base of the RHSM Testware"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :java-source-paths ["src"]
  :source-patsh ["src"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.testng/testng "6.11"
                  :exclusions [com.google.inject/guice]
                  ]
                 [com.google.inject/guice "4.1.0"]
                 [commons-beanutils/commons-beanutils "1.9.3"]
                 [org.apache.commons/commons-configuration2 "2.1.1"]]
  :plugins [[lein2-eclipse "2.0.0"]]
  :javac-options {:debug "on"})
