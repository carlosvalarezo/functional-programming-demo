(ns democars.discounts.discount
  (:require [democars.discounts.membership-discount :as membership]
            [democars.discounts.numberofdays-discount :as numberOfDays]
            [democars.discounts.weekdays-discount :as weekdays]))


(defn calculateTotalDiscount [& args]
  (+ args))

(defn calculateDiscount [rentDays car ]
      (+ (weekdays/calculateDiscountOnWeekDay rentDays car)
         (membership/calculateDiscountByMembership rentDays car)
         (numberOfDays/calculateDiscountByNumberOfDays rentDays car)
         ))

