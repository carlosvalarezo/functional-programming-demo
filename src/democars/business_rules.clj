(ns democars.business-rules
  (:require [clojure.data.json :as json]
            [democars.payments :as payment]))


(defn getJsonValues [jsonString, minimumAge]
    (let [{rentDates :rentDates car :car membership :membership age :age} jsonString]
              (if (> age minimumAge)
                  (payment/calculateSubTotal rentDates, car)
                )))


