(ns democars.discounts.weekdays-discount
  (:require [democars.rentcars.rent-operations :as operations]
            [democars.utiles.util :as util]
            [democars.discounts.algorithms.implementation :as implementation]))

(defn calculateDiscountOnWeekDays [rentDates car]
  (reduce + (map (fn [rentDate] (implementation/getDiscountOnWeekdays rentDate (operations/getPriceByTypeOfCar car))) rentDates)))
