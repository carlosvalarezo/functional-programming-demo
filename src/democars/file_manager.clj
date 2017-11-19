(ns democars.file-manager
  (:require [clojure.data.json :as json]))

(defn getJsonData [fileName]
  (json/read-str (slurp (str fileName)) :key-fn keyword))









