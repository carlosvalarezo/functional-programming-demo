(ns democars.datacars.available-cars)

(defstruct cars :model :type)

(def availableCars [(struct cars "Dwarfy" "small")
                    (struct cars "Halfing" "small")
                    (struct cars "Eveo" "sport")
                    (struct cars "Cherato" "sport")
                    (struct cars "Vitorio" "SUV")
                    (struct cars "Exploring" "SUV")])
