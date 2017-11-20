(ns democars.business-rules
  (:require [clojure.data.json :as json]
            [democars.payments.payment :as pay]))


(defn getJsonValues [jsonString, minimumAge]
    (let [{rentDates :rentDates car :car membership :membership age :age} jsonString]
              (if (> age minimumAge)
                  (pay/calculateSubTotal rentDates, car)
                )))


