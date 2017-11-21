(ns democars.business-rules
    (:require [clojure.data.json :as json]
      [democars.payments.payment :as payment]
      [democars.insurance.insurance-policy :as insurance]
      [democars.discounts.discount :as discount]
      [democars.utiles.util :as util]))


(defn getSubtotal [getValues]
      (fn [rentDates car]
          (getValues rentDates car)))

(defn getInsurance [getInsurancePolicy]
      (fn [rentDates car age]
          (getInsurancePolicy rentDates car age)))

(defn getDiscount [getDiscounts]
      (fn [rentDates car membership]
          (getDiscounts rentDates car membership)))

(def subtotal (getSubtotal payment/calculateSubTotal))

(def insurance (getInsurance insurance/calculateInsurancePolicy) )

(def discountPercentage (getDiscount discount/calculateTotalDiscount))

(defn getJsonValues [jsonString, minimumAge]
      (let [{rentDates :rentDates car :car membership :membership age :age} jsonString]
           (if (> age minimumAge)
             (payment/calculateTotalPayment
               (subtotal rentDates car)
               (insurance rentDates car age)
               (discountPercentage rentDates car membership)))))


