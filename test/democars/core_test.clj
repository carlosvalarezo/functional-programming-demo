(ns democars.core-test
  (:require [clojure.test :refer :all]
            [democars.core :refer :all]
            [democars.rentcars.rent-operations :as operations]
            [democars.discounts.weekdays-discount :as weekDays]
            [democars.discounts.numberofdays-discount :as numberDays]
            [democars.discounts.discount :as discount]
            [democars.discounts.membership-discount :as membership]
            [democars.utiles.util :as util]
            [democars.insurance.insurance-policy :as insurance]
            [democars.payments.payment :as payment]
            [democars.payments.algorithms.implementation :as implementation]
            [democars.discounts.algorithms.implementation :as implDiscount]))

(deftest gettingNumberOfDays
  (is (= 2 (util/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-21T05:00:00.000Z"))))

(deftest gettingNumberOfDays
  (is (= 3 (util/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-22T05:00:00.000Z"))))

(deftest checkingAvailabilityOfCherato
  (is (= false (operations/checkAvailabilityOfCar {:model "Cherato" :type "sport"}) )))

(deftest getThePriceOfACherato
  (is (= 60 (operations/getPriceByTypeOfCar {:model "Cherato" :type "sport"}))))

(deftest getThePriceOfADwarfy
  (is (= 40 (operations/getPriceByTypeOfCar {:model "Dwarfy" :type "small"}))))

(deftest getSubtotalOf3DaysInASportCar
  (is (= 180 (implementation/calculateSubTotal 3 {:model "Eveo" :type "sport"} ))))

(deftest getDiscountOnTwoDaysAsWeekDay
  (is (= 12.0 (weekDays/calculateDiscountOnWeekDays ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"}))))

(deftest getDiscountByMembership
  (is (= 9.0 (membership/calculateDiscountByMembership 180))))

(deftest getDiscountByThreeDaysOfASmallCar
  (is (= 6.0 (numberDays/calculateDiscountByNumberOfDays 3 120))))

(deftest getDiscountByTwoDaysOfASmallCar
  (is (= 0 (numberDays/calculateDiscountByNumberOfDays 2 120))))

(deftest getInsuranceByTwoDaysOfASmallCar
  (is (= 2.5 (insurance/calculateInsurancePolicy 2 19 {:model "Dwarf" :type "small"}))))

(deftest getInsuranceByTwoDaysOfASmallCar
  (is (= 0 (insurance/calculateInsurancePolicy 2 14 {:model "Dwarf" :type "small"}))))

(deftest getDiscountOnWeekend
  (is (= 0 (implDiscount/getDiscountOnWeekdays "2017-11-19T05:00:00.000Z" 180))))

(deftest getDiscountOnWeekday
  (is (= 18.0 (implDiscount/getDiscountOnWeekdays "2017-11-22T05:00:00.000Z" 180))))