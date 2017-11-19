(ns democars.core-test
  (:require [clojure.test :refer :all]
            [democars.core :refer :all]
            [democars.file-manager :as fm]
            [democars.business-rules :as br]
            [democars.payments :as pay]))

(deftest gettingNumberOfDays
  (is (= 2 (pay/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-21T05:00:00.000Z"))))

(deftest checkingAvailabilityOfCherato
  (is (= false (pay/checkAvailabilityOfCar {:model "Cherato" :type "sport"}) )))

(deftest getThePriceOfASportCar
  (is (= 60 (pay/getPriceByTypeOfCar {:model "Cherato" :type "sport"}))))