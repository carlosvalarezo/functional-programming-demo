(ns democars.discounts.algorithms.implementation
  (:require [democars.utiles.util :as util]
            [democars.payments.payment :as payment]))

(defn applyDiscount [amount discount]
  (if (= discount 0) 0 (* amount discount)))

(defn getMembershipDiscount [amount]
  (applyDiscount amount 0.05))

(defn getDiscountByDays [numberOfDays subtotal]
  (cond
    (and (>= numberOfDays 3) (<= numberOfDays 5)) (applyDiscount subtotal 0.05)
    (and (>= numberOfDays 6) (<= numberOfDays 10)) (applyDiscount subtotal 0.10)
    (>= numberOfDays 11) (applyDiscount subtotal 0.15)
    :else 0))

(defn getDiscountOnWeekdays [date subtotal]
  (if (= (util/isWeekday? date) true)
    (applyDiscount subtotal 0.10)
    0))


