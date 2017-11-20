(ns democars.rentcars.rent-operations
  (:require [clj-time.core :as t]
            [clj-time.local :as l]
            [democars.datacars.available-cars :as ac]
            [democars.datacars.type-cars :as tc]))

(defn checkAvailabilityOfCar [car]
  (empty? (filter (fn [availableCar] (= (get car :model) (get availableCar :model))) ac/availableCars)))

(defn getPriceByTypeOfCar [car]
  (:price (first (filter (fn [typeOfCar] (= (get car :type) (get typeOfCar :type))) tc/typeOfCars))))
