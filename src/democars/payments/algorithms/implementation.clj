(ns democars.payments.algorithms.implementation
  (:require [democars.rentcars.rent-operations :as operations]))

(defn calculateSubTotal [numberOfDays car]
  (if (= (operations/checkAvailabilityOfCar car) false)
    (* numberOfDays (operations/getPriceByTypeOfCar car))
    0))
