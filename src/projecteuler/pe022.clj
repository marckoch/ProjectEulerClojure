(ns projecteuler.pe022
  (:require [clojure.string :as str]))

(def filename "resources/pe022_names.txt")

(def names
  (let [content (slurp filename)
        raw-names (str/split content #",")]
    (->>
     raw-names
     (map #(str/replace % #"\"" ""))
     (map #(str/replace % #"\\" "")))))

(defn alphabetic-weight [str]
  (->>
   str
   (map #(Character/getNumericValue %))
   (map #(- % 9)) ; - 9, because Character.getNumericValue ("A") == 10, etc.
   (reduce +)))

(alphabetic-weight "COLIN")

(defn score [[idx name]]
  (* idx (alphabetic-weight name)))

(def index-starting-with-1 
  (fn [idx item] [(inc idx) item]))

(->>
 (map-indexed index-starting-with-1 (sort names))
 (map #(score %))
 (reduce +))
