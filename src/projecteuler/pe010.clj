(ns projecteuler.pe010
  (:require [com.hypirion.primes :as p]))

(->>
 (p/take-below 2e6)
 (reduce +))
