(ns democars.payments.payment
  (:require [democars.rentcars.rent-operations :as operations]
            [democars.discounts.discount :as discount]))

(defn calculateSubTotal [rentDays, car]
  (if (= (operations/checkAvailabilityOfCar car) false)
    (* (discount/getNumberOfDays (first rentDays) (last rentDays)) (operations/getPriceByTypeOfCar car))))

