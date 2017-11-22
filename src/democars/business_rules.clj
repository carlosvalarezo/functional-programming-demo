(ns democars.business-rules
  (:require [clojure.data.json :as json]
            [cheshire.core :refer :all]
            [democars.payments.payment :as payment]
            [democars.insurance.insurance-policy :as insurance]
            [democars.discounts.discount :as dis]
            [democars.utiles.util :as util]
            [democars.payments.algorithms.implementation :as implementation]))

(def demo
  (fn [ii]
    (let [a ii]
      (let [b (str "hello " a)]
         (str (str b " dasd")) ))))

(def numberOfDays
  (fn [rentDates]
    (let [_days (util/getNumberOfDays (first rentDates) (last rentDates))]
      (+ _days))))

(def subtotal
  (fn [numberOfDays car]
    (let [_subtotal (implementation/calculateSubTotal numberOfDays car)]
      (+ _subtotal))))

(def totalDiscount
  (fn [rentDates numberOfDays subtotal car membership]
    (let [_totalDiscount (dis/calculateTotalDiscount rentDates numberOfDays subtotal car membership )]
      (+ _totalDiscount))))

(def insurance
  (fn [numberOfDays age car]
    (let [_insurance (insurance/calculateInsurancePolicy numberOfDays age car)]
      (+ _insurance))))

(def totalPayment
  (fn [subtotal discount insurance]
    (let [_totalPayment (payment/calculateTotalPayment subtotal discount insurance )]
      (+ _totalPayment))))

(defstruct paymentsCar :subtotal :insuranceTotal :discountPercentage :totalPayment)

(def output (struct paymentsCar 0 0 0 0))

(defn getJsonValues [jsonString minimumAge]
  (let [{_rentDates :rentDates _car :car _membership :membership _age :age} jsonString]
      (let [_numberOfDays (numberOfDays _rentDates)]
        (let [_subtotal (subtotal _numberOfDays _car)]
          (let [_discount (totalDiscount _rentDates _numberOfDays _subtotal _car _membership)]
            (let [_insurance (insurance _numberOfDays _age _car)]
              (let [_totalPayment (totalPayment _subtotal _discount _insurance)]
                  (prn "days " _numberOfDays "sb " _subtotal "dc" _discount "in" _insurance "total " _totalPayment )
                )))))
        )

  (prn (str (demo "foo") " asdasd"))
  )

