(ns democars.core-test
  (:require [clojure.test :refer :all]
            [democars.core :refer :all]
            [democars.file-manager :as fm]))

(deftest getAge
  (is (= 24 (fm/printJson {:age 24}))))