(ns democars.discounts.discount)

(defn calculateDiscount [weekday, numberOfDays, membership]
  (+ weekday numberOfDays membership ))