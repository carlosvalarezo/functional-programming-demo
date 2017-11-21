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
            [democars.payments.payment :as payment]))

(deftest gettingNumberOfDays
  (is (= 2 (util/getNumberOfDays "2017-11-19T05:00:00.000Z" "2017-11-21T05:00:00.000Z"))))

(deftest checkingAvailabilityOfCherato
  (is (= false (operations/checkAvailabilityOfCar {:model "Cherato" :type "sport"}) )))

(deftest getThePriceOfACherato
  (is (= 60 (operations/getPriceByTypeOfCar {:model "Cherato" :type "sport"}))))

(deftest getThePriceOfADwarfy
  (is (= 40 (operations/getPriceByTypeOfCar {:model "Dwarfy" :type "small"}))))

(deftest getSubtotalOf3DaysInASportCar
  (is (= 120 (payment/calculateSubTotal ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"} ))))

(deftest getDiscountOnTwoDaysAsWeekDay
  (is (= 12.0 (weekDays/calculateDiscountOnWeekDays ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Eveo" :type "sport"}))))

(deftest getDiscountByMembership
  (is (= 6.0 (membership/calculateDiscountByMembership ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Cherato" :type "sport"}))))

(deftest getDiscountByThreeDaysOfASmallCar
  (is (= 0 (numberDays/calculateDiscountByNumberOfDays ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Halfing" :type "small"}))))

(deftest getInsuranceByTwoDaysOfASmallCar
  (is (= 2.5 (insurance/calculateInsurancePolicy ["2017-11-19T05:00:00.000Z","2017-11-20T05:00:00.000Z","2017-11-21T05:00:00.000Z"] {:model "Dwarf" :type "small"} 19))))

(deftest getTotalDiscountThreeDaysOfASmallCarWithMembershipTwoWeekDays
  (is (= 27.0 (+ 6.0 9.0 12.0))))
