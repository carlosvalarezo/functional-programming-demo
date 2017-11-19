(ns democars.rentcars.rent-operations
  (:require [clj-time.core :as t]
            [clj-time.local :as l]
            [democars.datacars.available-cars :as ac]
            [democars.datacars.type-cars :as tc]))

(defn getNumberOfDays [startDate, endDate]
  (t/in-days (t/interval (l/to-local-date-time startDate), (l/to-local-date-time endDate))))

(defn checkAvailabilityOfCar [car]
  (empty? (filter (fn [car1] (= (get car :model) (get car1 :model))) ac/availableCars)))

(defn getPriceByTypeOfCar [car]
  (:price (first (filter (fn [car1] (= (get car :type) (get car1 :type))) tc/typeOfCars))))
