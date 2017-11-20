(ns democars.discounts.discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]))

(defn getNumberOfDays [startDate, endDate]
  (t/in-days (t/interval (l/to-local-date-time startDate) (l/to-local-date-time endDate))))

(defn applyDiscount [amount discount]
  (if (= discount 0) 0 (* amount discount)))

(defn calculateTotalDiscount [& args]
  (+ args))