(defproject rhsm-utils "0.1.0-SNAPSHOT"
  :description "Utils to support RHSM Testware"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :java-source-paths ["src"]
  :source-patsh ["src"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.testng/testng "6.8"]
                 [danielsz/boot-shell "0.0.1"]
                 ]

  :plugins [[lein2-eclipse "2.0.0"]]
  :javac-options {:debug "on"}
  )
