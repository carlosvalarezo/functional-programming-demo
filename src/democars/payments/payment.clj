(ns democars.payments.payment
  (:require [democars.rentcars.rent-operations :as operations]
            [democars.utiles.util :as util]))

(defn calculateSubTotal [rentDays, car]
  (if (= (operations/checkAvailabilityOfCar car) false)
    (* (util/getNumberOfDays (first rentDays) (last rentDays)) (operations/getPriceByTypeOfCar car))))

