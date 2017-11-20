(ns democars.discounts.numberofdays-discount
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]
            [democars.payments.payment :as payment]
            [democars.discounts.discount :as discount]))

(defn discountByDays [amount days]
  (cond
    (and (>= days 3) (<= days 5)) (discount/applyDiscount amount 0.05)
    (and (>= days 6) (<= days 10)) (discount/applyDiscount amount 0.10)
    (>= days 11) (discount/applyDiscount amount 0.15)))

(defn calculateDiscountByNumberOfDays [rentDates car]
  (discountByDays (payment/calculateSubTotal rentDates car) (discount/getNumberOfDays (first rentDates) (last rentDates))))

