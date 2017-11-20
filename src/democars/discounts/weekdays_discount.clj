(ns democars.discounts.weekdays-discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]
            [democars.rentcars.rent-operations :as operations]
            [democars.utiles.util :as util]))

(defn discountOnWeekdays [date amount]
  (if (= true (util/isWeekday? date))
           (util/applyDiscount amount 0.10)
           (util/applyDiscount amount 0)))

(defn calculateDiscountOnWeekDay [rentDates car]
  (reduce + (map (fn [rentDate] (discountOnWeekdays rentDate (operations/getPriceByTypeOfCar car))) rentDates)))
