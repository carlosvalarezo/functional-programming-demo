(ns democars.file-manager
  (:require [clojure.data.json :as json]))

(def jsonData (fn [fileName]
  (json/read-str (slurp (str fileName)) :key-fn keyword)))


(defn printJson [jsonToPrint] (get jsonToPrint (keyword "age") ))








