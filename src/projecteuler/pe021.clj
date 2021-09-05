(ns projecteuler.pe021
  (:require [math.divisors :as d]))

(defn get-amicable-partner
  "Find the amicable partner number for n.
   Returns vector of n and amicable partner
   or nil when n has no amicable partner.
   note: perfect numbers (like 6 or 28) return nil!"
  [n]
  (let [divs (d/proper-divisors n)
        div-sum (reduce + divs)
        divs-partner (d/proper-divisors div-sum)
        divs-partner-sum (reduce + divs-partner)]
    (when (and (= n divs-partner-sum)
               (not= n div-sum)) ; remove perfect n numbers like 6 or 28
      [n div-sum])))

(->> (range 1 10000)
     (map #(get-amicable-partner %))
     (remove #(nil? %))
     flatten
     set
     (reduce +))