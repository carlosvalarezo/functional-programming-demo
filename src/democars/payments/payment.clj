(ns democars.payments.payment
  (:require [democars.rentcars.rent-operations :as operations]
            [democars.utiles.util :as util]))



(defn calculateSubTotal [rentDates car]
  (if (= (operations/checkAvailabilityOfCar car) false)
    (* (util/getNumberOfDays (first rentDates) (last rentDates)) (operations/getPriceByTypeOfCar car) )))

(defn calculateTotalPayment [totalDiscount totalMembership subtotal]
  (prn totalDiscount totalMembership subtotal)
  (+ totalDiscount totalMembership subtotal))
