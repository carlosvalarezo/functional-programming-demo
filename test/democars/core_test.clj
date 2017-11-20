(ns democars.core-test
    (:require [clojure.test :refer :all]
      [democars.core :refer :all]
      [democars.file-manager :as fm]
      [democars.business-rules :as br]
      [democars.payments.payment :as pay]
      [democars.rentcars.rent-operations :as operations]
      [democars.discounts.weekdays-discount :as wd]
      [democars.discounts.numberofdays-discount :as nd]
      [democars.utiles.util :as util]
      [democars.discounts.membership-discount :as membership]
      [democars.insurance.insurance-policy :as insurance]
      [democars.discounts.discount :as discount]))

(deftest gettingNumberOfDays
  (is (= 2 (util/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-21T05:00:00.000Z"))))

(deftest checkingAvailabilityOfCherato
  (is (= false (operations/checkAvailabilityOfCar {:model "Cherato" :type "sport"}) )))

(deftest getThePriceOfACherato
  (is (= 60 (operations/getPriceByTypeOfCar {:model "Cherato" :type "sport"}))))

(deftest getThePriceOfADwarfy
  (is (= 40 (operations/getPriceByTypeOfCar {:model "Dwarfy" :type "small"}))))

(deftest getSubtotalOf3DaysInASportCar
  (is (= 120 (pay/calculateSubTotal ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"} ))))

(deftest getDiscountOnTwoDaysAsWeekDay
  (is (= 12.0 (wd/calculateDiscountOnWeekDay ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"}))))

(deftest getDiscountByMembership
  (is (= 9.0 (membership/calculateDiscountByMembership ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z","2017-11-22T05:00:00.000Z"] {:model "Cherato" :type "sport"}))))

(deftest getInsurance
   (is (= 21 (insurance/calculateInsurancePolicy ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z","2017-11-22T05:00:00.000Z"] {:model "Cherato" :type "sport"} 25)))      )

(deftest getTotalDiscount
         (is (= 36.0 (discount/calculateDiscount ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z","2017-11-22T05:00:00.000Z"] {:model "Cherato" :type "sport"}))))

