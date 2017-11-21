(ns democars.discounts.discount
  (:require [democars.discounts.membership-discount :as membership]
            [democars.discounts.weekdays-discount :as weekdays]
            [democars.discounts.numberofdays-discount :as numberOfDays]
            ))


(defn calculateWeekDayDiscount [rentDates car]
  (weekdays/calculateDiscountOnWeekDays rentDates car))

(defn calculateMembershipDiscount [rentDates car]
  (membership/calculateDiscountByMembership rentDates car))

(defn calculateNumberOfDaysDiscount [rentDates car]
  (numberOfDays/calculateDiscountByNumberOfDays rentDates car))

(defn calculateTotalDiscount [rentDates car membership]
  (+ (calculateWeekDayDiscount rentDates car)
     (if (= membership true) (calculateMembershipDiscount rentDates car) 0))
     (calculateNumberOfDaysDiscount rentDates car))
