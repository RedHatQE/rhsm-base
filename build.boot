(set-env!
 :resource-paths #{"src"}
 :source-paths #{"src" "test"}
 :dependencies '[[org.clojure/clojure "1.8.0"]
                 [org.testng/testng "6.11"]
                 [commons-beanutils/commons-beanutils "1.9.3"]
                 [org.apache.commons/commons-configuration2 "2.1.1"]
                 [adzerk/boot-test "1.2.0" :scope "test"]
                 [spyscope "0.1.5"]])
(require '[adzerk.boot-test :refer :all])
(require 'spyscope.core)
(boot.core/load-data-readers!)
