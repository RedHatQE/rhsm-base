(ns rhsm-base.testng-tests
  (:require [clojure.test :refer :all])
  (:import [org.testng TestNG]))

(deftest run-suite-test
  (TestNG/main (into-array String ["resources/suite.xml"])))
