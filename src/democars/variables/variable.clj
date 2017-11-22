(ns democars.variables.variable
  (:require [democars.payments.payment :as payment]
            [democars.insurance.insurance-policy :as insurance]
            [democars.discounts.discount :as dis]
            [democars.utiles.util :as util]
            [democars.payments.algorithms.implementation :as implementation]))


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
    (let [_totalDiscount (dis/calculateTotalDiscount rentDates numberOfDays subtotal car membership)]
      (+ _totalDiscount))))

(def insurance
  (fn [numberOfDays age car]
    (let [_insurance (insurance/calculateInsurancePolicy numberOfDays age car)]
      (+ _insurance))))

(def totalPayment
  (fn [subtotal discount insurance]
    (let [_totalPayment (payment/calculateTotalPayment subtotal discount insurance)]
      (+ _totalPayment))))
