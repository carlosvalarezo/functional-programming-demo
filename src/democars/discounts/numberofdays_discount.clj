(ns democars.discounts.numberofdays-discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]
            [democars.payments.payment :as payment]
            [democars.utiles.util :as util]))

(defn discountByDays [amount days]
  (cond
    (and (>= days 3) (<= days 5)) (util/applyDiscount amount 0.05)
    (and (>= days 6) (<= days 10)) (util/applyDiscount amount 0.10)
    (>= days 11) (util/applyDiscount amount 0.15)
    :else 0))

(defn calculateDiscountByNumberOfDays [rentDates car]
  (discountByDays (payment/calculateSubTotal rentDates car) (util/getNumberOfDays (first rentDates) (last rentDates))))

