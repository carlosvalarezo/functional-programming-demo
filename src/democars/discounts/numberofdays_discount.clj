(ns democars.discounts.numberofdays-discount
  (:require [democars.discounts.algorithms.implementation :as implementation]))

(defn calculateDiscountByNumberOfDays [numberOfDays subtotal ]
  (implementation/getDiscountByDays numberOfDays subtotal ))

