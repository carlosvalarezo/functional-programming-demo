(ns democars.core-test
  (:require [clojure.test :refer :all]
            [democars.core :refer :all]
            [democars.file-manager :as fm]
            [democars.business-rules :as br]
            [democars.payments.payments :as pay]
            [democars.rentcars.rent-operations :as operations]))

(deftest gettingNumberOfDays
  (is (= 2 (operations/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-21T05:00:00.000Z"))))

(deftest checkingAvailabilityOfCherato
  (is (= false (operations/checkAvailabilityOfCar {:model "Cherato" :type "sport"}) )))

(deftest getThePriceOfASportCar
  (is (= 60 (operations/getPriceByTypeOfCar {:model "Cherato" :type "sport"}))))

(deftest getThePriceOfASportCar
  (is (= 40 (operations/getPriceByTypeOfCar {:model "Dwarfy" :type "small"}))))

(deftest getSubtotalOf3DaysInASportCar
  (is (= 120 (pay/calculateSubTotal ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"} ))))