(ns democars.discounts.weekdays-discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]))

(defn isWeekday? [date-time]
  (not (weekend? date-time)))

(defn applyDiscount [price discount]
  (* price discount))

