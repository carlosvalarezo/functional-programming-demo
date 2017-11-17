(ns democars.core
  (:require [clojure.data.json :as json]
  			[democars.file-manager :as fm])
  (:gen-class))

(defn -main
  "I do maginc from here!!!"
  [& args]
  (fm/jsonData (str "data/democars.json")))
