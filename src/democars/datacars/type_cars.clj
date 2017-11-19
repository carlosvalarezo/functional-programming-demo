(ns democars.datacars.type-cars)

(defstruct typecars :type :price)

(def typeOfCars [(struct typecars "small" 40)
                 (struct typecars "sport" 60)
                 (struct typecars "SUV" 100)])

