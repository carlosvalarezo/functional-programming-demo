(ns democars.payments.payments
  (:require [democars.rentcars.rent-operations :as operations]))

(defn calculateSubTotal [rentDays, car]
  (if false (operations/checkAvailabilityOfCar car)
    (* (operations/getNumberOfDays (first rentDays) (last rentDays)) (operations/getPriceByTypeOfCar car))))

