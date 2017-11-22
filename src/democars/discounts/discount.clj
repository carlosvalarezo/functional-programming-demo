(ns democars.discounts.discount
  (:require [democars.discounts.membership-discount :as membership]
            [democars.discounts.weekdays-discount :as weekdays]
            [democars.discounts.numberofdays-discount :as numberOfDays]))

(defn calculateWeekDayDiscount [rentDates car]
  (weekdays/calculateDiscountOnWeekDays rentDates car))

(defn calculateMembershipDiscount [subtotal]
  (membership/calculateDiscountByMembership subtotal))

(defn calculateNumberOfDaysDiscount [numberOfDays subtotal]
  (numberOfDays/calculateDiscountByNumberOfDays numberOfDays subtotal))

(defn calculateDiscount [rentDates numberOfDays subtotal car discount]
  (cond
    (= discount "weekdays") (calculateWeekDayDiscount rentDates car)
    (= discount "numberOfDays") (calculateNumberOfDaysDiscount numberOfDays subtotal)
    (= discount "membership") (calculateMembershipDiscount subtotal)
  ))

(defn calculateTotalDiscount [rentDates numberOfDays subtotal car membership]
  (+ (calculateDiscount rentDates numberOfDays subtotal car "weekdays")
     (calculateDiscount rentDates numberOfDays subtotal car "numberOfDays")
     (if (= membership true) (calculateDiscount rentDates numberOfDays subtotal car "membership") 0)))