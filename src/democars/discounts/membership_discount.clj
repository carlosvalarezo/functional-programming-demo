(ns democars.discounts.membership-discount
  (:require [democars.payments.payment :as payment]
            [democars.utiles.util :as util]))

(defn getDiscount [rentDates car]
  (util/applyDiscount (payment/calculateSubTotal rentDates car) 0.05))

(defn getDiscountByMembership [calculate]
  (fn [rentDates car]
    (calculate rentDates car)))

(def discountByMembership (getDiscountByMembership getDiscount))

(defn calculateDiscountByMembership [rentDates car]
  (discountByMembership rentDates car))
