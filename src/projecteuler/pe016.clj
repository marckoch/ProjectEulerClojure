(ns projecteuler.pe016
  (:require [math.digitsum :as d]))

(d/digitsum (.pow (BigInteger. "2") 1000))