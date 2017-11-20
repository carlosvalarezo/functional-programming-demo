(ns democars.insurance.insurance-policy
    (:require [democars.rentcars.rent-operations :as operations]
              [democars.utiles.util :as util]))

(defn insurancePolicyByCar [age numberOfDays recharge]
      (if (< age 25)
        (* (* numberOfDays recharge) 0.25)
        (* numberOfDays recharge))
      )

(defn applyInsurancePolicy [policy]
      (fn [age numberOfDays recharge]
          (policy age numberOfDays recharge)))

(def policyCars (applyInsurancePolicy insurancePolicyByCar))

(defn calculateInsurancePolicy [rentDays car age]

      (let [typeOfCar (:type car)]
           (cond
             (= typeOfCar "small")
             (policyCars age (util/getNumberOfDays (first rentDays) (last rentDays)) 5)
             (= typeOfCar "sport")
             (policyCars age (util/getNumberOfDays (first rentDays) (last rentDays)) 7)
             (= typeOfCar "SUV")
             (policyCars age (util/getNumberOfDays (first rentDays) (last rentDays)) 10)
             )
           ))

