(ns projecteuler.pe034
  (:require [math.factorial]))

(defn sum-of-factorial-of-digits [n]
  (->> 
   (str n)
   (map #(Character/digit % 10))
   (map math.factorial/factorial)
   (reduce +)
   )
  )

(sum-of-factorial-of-digits 145)

(time (->>
 (range 3 1e6)
 (filter #(= % (sum-of-factorial-of-digits %))) 
 (reduce +))
)