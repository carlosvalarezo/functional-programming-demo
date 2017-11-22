(ns democars.utiles.util
  (:require [clj-time.core :as t]
            [clj-time.coerce :as coerce]
            [clj-time.local :as l]))

(defn saturday? [date]
  (= (t/day-of-week (l/to-local-date-time date)) 6))

(defn sunday? [date]
  (= (t/day-of-week (l/to-local-date-time date)) 7))

(defn weekend? [date]
  (or (saturday? date) (sunday? date)))

(defn isWeekday? [date]
  (not (weekend? date)))

(defn getNumberOfDays [startDate, endDate]
  (t/in-days (t/interval (l/to-local-date-time startDate) (l/to-local-date-time endDate))))

