(ns democars.file-manager
  (:require [clojure.data.json :as json]))

(def jsonData
	(fn [fileName]
		(prn (json/read-str (slurp (str fileName))
                :key-fn keyword)))) 






