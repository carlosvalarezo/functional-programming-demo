(ns democars.discounts.membership-discount
  (:require [democars.discounts.algorithms.implementation :as implementation]))

(defn calculateDiscountByMembership [subtotal]
  (implementation/getMembershipDiscount subtotal))
