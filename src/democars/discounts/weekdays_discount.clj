(ns democars.discounts.weekdays-discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]
            [democars.discounts.discount :as discount]
            [democars.rentcars.rent-operations :as operations]))

(defn saturday? [date-time]
  (= (t/day-of-week (l/to-local-date-time date-time) ) 6))

(defn sunday? [date-time]
  (= (t/day-of-week (l/to-local-date-time date-time)) 7))

(defn weekend? [date-time]
  (or (saturday? date-time) (sunday? date-time)))

(defn isWeekday? [date]
  (not (weekend? date)))

(defn discountOnWeekdays [date amount]
  (if (= true (isWeekday? date))
           (discount/applyDiscount amount 0.10)
           (discount/applyDiscount amount 0)))

(defn calculateDiscountOnWeekDay [rentDates car]
  (map (fn [rentDate] (discountOnWeekdays rentDate (operations/getPriceByTypeOfCar car))) rentDates))
