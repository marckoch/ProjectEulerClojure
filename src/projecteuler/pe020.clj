(ns projecteuler.pe020
  (:require [math.digitsum :as d]
            [math.factorial :as f]))

(d/digitsum (f/factorial 100))