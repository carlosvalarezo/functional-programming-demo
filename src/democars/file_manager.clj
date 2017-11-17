(ns democars.file-manager
  (:require [clojure.data.json :as json]))

(def jsonData (json/parse-string (slurp  "../data/democars.json") true))


