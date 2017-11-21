(ns democars.utiles.util
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]))

(defn saturday? [date-time]
  (= (t/day-of-week (l/to-local-date-time date-time) ) 6))

(defn sunday? [date-time]
  (= (t/day-of-week (l/to-local-date-time date-time)) 7))

(defn weekend? [date-time]
  (or (saturday? date-time) (sunday? date-time)))

(defn isWeekday? [date]
  (not (weekend? date)))

(defn getNumberOfDays [startDate, endDate]
  (t/in-days (t/interval (l/to-local-date-time startDate) (l/to-local-date-time endDate))))

(defn applyDiscount [amount discount]
  (if (= discount 0) 0 (* amount discount)))
