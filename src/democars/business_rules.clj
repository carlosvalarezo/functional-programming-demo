(ns democars.business-rules
    (:require [clojure.data.json :as json]
      [democars.payments.payment :as payment]
      [democars.insurance.insurance-policy :as insurance]
      [democars.discounts.discount :as discount]
      [democars.utiles.util :as util] [cheshire.core :refer :all]))

(defstruct paymentsCar :subtotal :insuranceTotal :discountPercentage :totalPayment)

(def output (struct paymentsCar 0 0 0 0))

(defn getSubtotal [getValues]
      (fn [rentDates car]
          (getValues rentDates car)))

(defn getInsurance [getInsurancePolicy]
      (fn [rentDates car age]
          (getInsurancePolicy rentDates car age)))

(defn getDiscount [getDiscounts]
      (fn [rentDates car membership]
          (getDiscounts rentDates car membership)))

(defn getTotal [getValue]
  (fn [subtotal insurance discountPercentage]
      (getValue subtotal insurance discountPercentage)
    ))

(def subtotal (getSubtotal payment/calculateSubTotal))

(def insurance (getInsurance insurance/calculateInsurancePolicy) )

(def discountPercentage (getDiscount discount/calculateTotalDiscount))

(def total (getTotal payment/calculateTotalPayment))


(defn getJsonValues [jsonString minimumAge]
      (let [{rentDates :rentDates car :car membership :membership age :age} jsonString]
           (if (> age minimumAge)
             (let [_subtotal (subtotal rentDates car)]
               (let [_insurance (insurance rentDates car age)]
                 (let [_discountPercentage (discountPercentage rentDates car membership)]
                   (let [_total (total _subtotal _insurance _discountPercentage)]
                      (def output (struct paymentsCar _subtotal _insurance _discountPercentage _total)))))))
  (prn (parse-string  (generate-string output {:pretty true})))))