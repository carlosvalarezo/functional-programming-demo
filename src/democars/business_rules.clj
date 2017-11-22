(ns democars.business-rules
  (:require [clojure.data.json :as json]
            [cheshire.core :refer :all]
            [democars.variables.variable :as var]))

(defstruct paymentsCar :subtotal :insuranceTotal :discountPercentage :totalPayment)

(def output (struct paymentsCar 0 0 0 0))

(defn getJsonValues [jsonString minimumAge]
  (let [{_rentDates :rentDates _car :car _membership :membership _age :age} jsonString]
    (let [_numberOfDays (var/numberOfDays _rentDates)]
      (let [_subtotal (var/subtotal _numberOfDays _car)]
        (let [_discount (var/totalDiscount _rentDates _numberOfDays _subtotal _car _membership)]
          (let [_insurance (var/insurance _numberOfDays _age _car)]
            (let [_totalPayment (var/totalPayment _subtotal _discount _insurance)]
              (prn "days " _numberOfDays "sb " _subtotal "dc" _discount "in" _insurance "total " _totalPayment)
              )))))
    )

  (prn "hello")
  )

