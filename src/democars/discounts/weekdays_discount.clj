(ns democars.discounts.weekdays-discount
  (:require [democars.rentcars.rent-operations :as operations]
            [democars.utiles.util :as util]))

(defn discountOnWeekdays [date amount]
  (if (= (util/isWeekday? date) true)
           (util/applyDiscount amount 0.10)
           (util/applyDiscount amount 0)))

(defn calculateDiscountOnWeekDays [rentDates car]
  (reduce + (map (fn [rentDate] (discountOnWeekdays rentDate (operations/getPriceByTypeOfCar car))) rentDates)))
