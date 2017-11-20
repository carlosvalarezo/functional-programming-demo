(ns democars.discounts.membership-discount
  (:require [democars.utiles.util :as util]
            [democars.payments.payment :as payment]))

(defn calculateDiscountByMembership [rentDates car]
  (util/applyDiscount (payment/calculateSubTotal rentDates car) 0.05))
