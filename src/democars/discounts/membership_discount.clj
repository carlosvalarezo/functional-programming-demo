(ns democars.discounts.membership-discount
  (:require [democars.discounts.discount :as discount]
            [democars.payments.payment :as payment]))

(defn calculateDiscountByMembership [rentDates car]
  (discount/applyDiscount (payment/calculateSubTotal rentDates car) 0.05))
